if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement;
import org.python.antlr.PythonParser.return_stmt_return
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* verify all links in create New record page are accessible and each add new record link is loading without any errors.
 * 
 * Steps:
 * 
 * click on New link from the Home page
 * dynamically get all the add new record links on the page (Page_Enter Record)
 * 		On the Page of New Record, perform verifyLinksAccessible() to verify all create record links are not broken 
 * 		will report any links that are not accessible.
 * 		will fail the test if FailureHandling.STOP_ON_FAILURE
 *
 * 		get new record link name and url
 * 		navigate each link url to open new record page 
 * 		check for js error on each new record page when page is being loaded
 *///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

boolean create_new_record_on_training=false
int max_new_recording_page_loading=5

KeywordLogger log = new KeywordLogger()
String found_new_record_link
String url
int size
List<WebElement> elements
WebDriver driver

List<String> list_urls

int retry_count = 0;
int maxTries = 2;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

println('click New Record link from Home page')
if ((GlobalVariable.G_MAKE_MAS_url).contains('doctree')){
	WebUI.click(findTestObject('Page_Document Tree/a_NEW RECORD'))
	WebUI.click(findTestObject('Object Repository/Page_Select Program/a_All'))
}
else if((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	//WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ARC JET/button_Save'),5)
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_ARC JET/button_Save'))
}
else{
	WebUI.click(findTestObject('Page_Main Page/a_New'))
}
//println('check Links Broken (http return code != 200) On Current Page of New Record Record')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
//println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
//boolean STOP_ON_FAILURE=false
//CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)

if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Select Record Type/a_All_enter_new_record_links'),2,FailureHandling.OPTIONAL))
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_All_enter_new_record_links'))


driver = DriverFactory.getWebDriver()
WebUI.comment('get all new record links from the New Record Page')
elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"));
//WebElement firstElement = elements.get(0);
size=elements.size()
if (size>max_new_recording_page_loading){
	WebUI.comment 'randomly to run verifyLinksAccessible() on all new record links or only first '+max_new_recording_page_loading+' links'	
	WebUI.comment 'found '+size+' create new record links, only run verifyLinksAccessible() on first '+max_new_recording_page_loading+' links to save time'
	size=max_new_recording_page_loading		
	
	/*else{
		WebUI.comment 'found '+size+' create new record links, run verifyLinksAccessible() on all new record liniks'		
	}*/
}else{
	WebUI.comment 'found '+size+' create new record links, run verifyLinksAccessible() on all new record liniks'		
}

//WebUI.comment 'found '+size+' links to create new record links'
urls = new String[size]
for (int i = 0; i < size; i++) {
	//println('get new record link name and url')
	found_new_record_link=elements.get(i).getText()
	url = elements.get(i).getAttribute("href");
	urls[i]=url
	log.logInfo("found new_record name: " + found_new_record_link+ "with URL: " + url);
	//log.logInfo("with URL: " + url);
}

WebUI.comment 'run verifyLinksAccessible() to verify all new record links are Accessible'
list_urls= Arrays.asList(urls);
WebUI.verifyLinksAccessible(list_urls, FailureHandling.STOP_ON_FAILURE)

if (size>max_new_recording_page_loading){
	WebUI.comment 'found '+size+' create new record links, only navigate first '+max_new_recording_page_loading+' links to save time and check for js error on each loaded record page'
	size='+max_new_recording_page_loading+'
} else{
	WebUI.comment 'navigate each link url to open new record page and check for js error on each new record page when page is being loaded'
}
for (int i = 0; i < size; i++) {
	WebUI.comment('navigate to new record link: '+urls[i])
	WebUI.navigateToUrl(urls[i])
	//driver.navigate().to(url)
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	//WebUI.click(findTestObject('Page_Main Page/a_New'))
}
// will exit if create_new_record_on_training=false
if (!create_new_record_on_training) return

/////////////////////////////////////////////////////////////////////////////
///////// create a new record for the training site
search_term = 'test_create_record_on_training'
if ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training')){
	WebUI.comment 'this is a training site, so trying to create a new record'
	WebUI.comment 'navigate to the first create new record link from the list (should be less mandatory required fields), which is '+urls[0]
	WebUI.navigateToUrl(urls[0])
	WebUI.delay(1)
	WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_short_desc'),10)
	WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)

	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/span_component_required'),2,FailureHandling.OPTIONAL)){
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record 20g Centrifuge/select_component'), 1,FailureHandling.STOP_ON_FAILURE)
	}
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/span_mandatory_on_close_filled'),1,FailureHandling.OPTIONAL)){
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/select_omrs_type'),1,FailureHandling.OPTIONAL)){
			WebUI.selectOptionByIndex(findTestObject('Object Repository/select_omrs_type'),1,FailureHandling.STOP_ON_FAILURE)
		}
	}
	
	WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Create New Record'),5)
	WebUI.click(findTestObject('Page_Enter Record View/input_Create New Record'))
	// check record is created
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),15,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'))
		WebUI.comment (recordID+' has been created successfully')
	}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'),1,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'))
		WebUI.comment (recordID+' has been created successfully')
	}else if( WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'),1,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'))
		WebUI.comment (recordID+' has been created successfully')
	}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),1) ){
		WebUI.comment ('found save button, so the record has been created successfully')
	}else{
		KeywordUtil.markFailedAndStop("cannot determine the record has been created")
	}
}

return
/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	 cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}
/////////////////////////////////////////////////////////////////////////////
/*

	WebUI.click(findTestObject('Page_Main Page/a_New'))
	CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
	//WebDriver driver = DriverFactory.getWebDriver()
	println('get all new record links from the New Record Page')
	elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"));
	size=elements.size()
	urls = new String[size]
	for (int i = 0; i < size; i++) {
		println('get new record link name and url')
		found_new_record_link=elements.get(i).getText()
		url = elements.get(i).getAttribute("href");
		urls[i]=url
		log.logInfo("found_new_record_link: " + found_new_record_link);
		log.logInfo("with URL: " + url);

	}
	for (int i = 0; i < size; i++) {
		println('navigate to new record link: '+urls[i])
		WebUI.navigateToUrl(urls[i])
		//driver.navigate().to(url)
		CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
		//WebUI.click(findTestObject('Page_Main Page/a_New'))

	}

}*/