if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.WebDriver as WebDriver
import org.sikuli.script.Key;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable
println('check cp-hazard integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
println('Select Hazard from the Source Type list')
println('Search for Hazard Number field with searchTerm: open work')
println('verify CP-Hazard search results')

if (!GlobalVariable.G_MAKE_MAS_url.contains('ecofr') && !GlobalVariable.G_MAKE_MAS_url.contains('cofr_dev')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
	return
}
if (!GlobalVariable.G_MAKE_MAS_url.contains('dev') ) return

String baseUrl = "https://www.katalon.com/"
recordID='126'
if (GlobalVariable.G_MAKE_MAS_url.contains('ecofr'))
	recordID='76'
String siteURL=GlobalVariable.G_MAKE_MAS_url
WebDriver driver
int retry_count = 0;
int maxTries = 1;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()
//Screen s = new Screen()
driver = DriverFactory.getWebDriver()
//def driver = DriverFactory.getWebDriver()

//selenium = new WebDriverBackedSelenium(driver, baseUrl)

println('check cp-hazard integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
//selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/show_bug.cgi?id=126#tv=Authoritative%20Sources")


baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Authoritative%20Sources'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(siteURL)

println('Select Hazard from the Source Type list')
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_source_type_NEW_ROW_1",25)
selenium.click("id=cf_source_type_NEW_ROW_1")
selenium.select("id=cf_source_type_NEW_ROW_1", "label=Hazard")

searchTerm="open work"
searchTerm="LASER Air Monitor (LAM)"
println('Search for Hazard Number field with searchTerm: '+searchTerm)
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_hazard_alias_NEW_ROW_1",5)
selenium.click("id=cf_hazard_alias_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(1)
selenium.typeKeys("id=cf_hazard_alias_NEW_ROW_1", searchTerm)
//selenium.waitForPageToLoad("30000")
WebUI.delay(2)
selenium.typeKeys("id=cf_hazard_alias_NEW_ROW_1", Key.ENTER)
//s.type(Key.ENTER)
selenium.waitForPageToLoad("80000")

println('verify CP-Hazard search results')
CustomKeywords.'hci_smoke_test.common.waifForElement'("//div[@id='digIt_title_find']//span",80)
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(5)
// check the create link
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'),80)
CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'))
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),20)

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()


/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}