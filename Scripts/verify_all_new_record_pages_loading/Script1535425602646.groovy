if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* verify all links in create New record page are accessible and each add new record link is loading without any errors.
 * now only limit to first 5 links checking due to time saving
 * 
 * Steps:
 * 
 * click on New link from the Home page
 * click All link if exists to display all new enter record links
 * dynamically get all the add new record links on the page (Page of Enter Record)
 * verify on each Page of New Record (max_new_recording_page_loading=5)
 * 		perform verifyLinksAccessible() to verify link is accessible
 * 		get new record link name and url
 * 		navigate to link url to open new record page 
 * 		check for js error on each new record page when page is being loaded
 * if training site, call testcase to create a new record
 * 
	
 *///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

boolean create_new_record_on_training=true
int max_new_recording_page_loading=5

KeywordLogger log = new KeywordLogger()
String found_new_record_link
String url
int size
List<WebElement> elements
WebDriver driver
boolean have_All_link=false
List<String> list_urls

int retry_count = 0;
int maxTries = 1;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

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
	WebUI.delay(1)
}
//println('check Links Broken (http return code != 200) On Current Page of New Record Record')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
//println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
//boolean STOP_ON_FAILURE=false
//CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)

if (WebUI.waitForElementPresent(findTestObject('Page_ISS Hazard Main Page/a_New blank record'),3,FailureHandling.OPTIONAL)){
	WebUI.waitForElementClickable(findTestObject('Page_ISS Hazard Main Page/a_New blank record'),2)
	WebUI.click(findTestObject('Page_ISS Hazard Main Page/a_New blank record'))
	//WebUI.click(findTestObject('Object Repository/Page_Select Category/a_All'))
	//WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Boeing'))
}
// select All 
if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Select Record Type/a_All_enter_new_record_links'),2,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_All_enter_new_record_links'))
	have_All_link=true
}

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
if( ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training') ) ){
//if( ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training') ) || ((WebUI.getUrl()).contains('MAKE-MAS')&& (GlobalVariable.G_MAKE_MAS_url).contains('MAKE-MAS')) ){
	WebUI.comment 'going to run testcase:verify_create_record_on_training'
	WebUI.comment 'this is a training site, so trying to create a new record'
	//WebUI.comment 'navigate to the first create new record link from the list (should be less mandatory required fields), which is '+urls[0]
	if (have_All_link)
		WebUI.navigateToUrl(urls[0])
	WebUI.delay(1)
	WebUI.callTestCase(findTestCase('verify_create_record_on_training'),[('call'):'test'])	

	if (GlobalVariable.G_MAKE_MAS_url.contains('ARC-PRACA')|| GlobalVariable.G_MAKE_MAS_url.contains('arc_praca')){
		WebUI.comment 'going to run testcase: verify_mandatory_fields_in_record'
		WebUI.callTestCase(findTestCase('verify_mandatory_fields_in_record'),[('call'):'test'])	
		WebUI.comment 'going to run testcase: verify_save_comments_SignatureClosure_TAB'
		WebUI.callTestCase(findTestCase('verify_save_comments_SignatureClosure_TAB'),[('call'):'test'])
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