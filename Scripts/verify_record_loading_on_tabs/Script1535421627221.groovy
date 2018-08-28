import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang3.StringUtils
import com.mysql.jdbc.StringUtils as myStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

println 'directly goto the record id from site profile'
println('get all Tabs from the Record Page')
println 'click on each tab'
println 'verify no js error and each tab is loaded properly '

CustomKeywords.'helper.login.LoginHelper.login'()

println 'directly goto the record id from site profile'
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
	WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordID)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))
	
}

WebUI.waitForPageLoad(30)
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),25)
WebDriver driver = DriverFactory.getWebDriver()

println('get all Tabs from the Record Page')
List<WebElement> elements = driver.findElements(By.xpath("//div[@class='labelAndIcon']/div[@class='tablabel']"));
int size=elements.size()
println('size='+size)
for (int i = 0; i < size; i++) {
	KeywordUtil.logInfo("Record Tab Name: " + elements.get(i).getText());
	println 'click on each tab'
	elements.get(i).click()
	println 'verify no js error and each tab is loaded properly '
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),25)
}

return



