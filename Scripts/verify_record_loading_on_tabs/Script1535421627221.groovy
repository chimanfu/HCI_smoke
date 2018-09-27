if (GlobalVariable.userPin2.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

WebUI.comment 'directly goto the record id from site profile'
WebUI.comment('get all Tabs from the Record Page')
WebUI.comment 'click on each tab'
WebUI.comment 'verify no js error and each tab is loaded properly '

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.comment 'directly goto the record id from site profile'
String recordID=GlobalVariable.recordName1
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (recordID.trim().equals("") || recordID.trim().equals(null)){
	recordID='test_automation_record'
}
if (StringUtils.isNumeric(recordID)){
	if (!siteURL.endsWith('/'))
	siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'show_bug.cgi?id='+recordID)
}else{
	// if recordID is not number
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
	if (WebUI.waitForElementVisible(findTestObject('Page_Main Page/select_search_option'),2))
		WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordID)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))
	
}

WebUI.waitForPageLoad(30)
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),5)
WebDriver driver = DriverFactory.getWebDriver()

WebUI.comment('get all Tabs from the Record Page')
List<WebElement> elements = driver.findElements(By.xpath("//div[@class='labelAndIcon']/div[@class='tablabel']"));
int size=elements.size()
WebUI.comment('size='+size)
for (int i = 0; i < size; i++) {
	KeywordUtil.logInfo("will click on Record Tab Name: " + elements.get(i).getText());
	//WebUI.comment 'click on each tab'
	elements.get(i).click()
	WebUI.comment 'verify no js error and each tab is loaded properly '
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	//WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),1)
}

return


/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}


