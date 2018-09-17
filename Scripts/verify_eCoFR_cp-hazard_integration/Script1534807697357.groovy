import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.*

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen;

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
println('check cp-hazard integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
println('Select Hazard from the Source Type list')
println('Search for Hazard Number field with searchTerm: open work')
println('verify CP-Hazard search results')

if (!GlobalVariable.G_MAKE_MAS_url.contains('cofr')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()
//Screen s = new Screen()
WebDriver driver = DriverFactory.getWebDriver()
//def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)

println('check cp-hazard integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/show_bug.cgi?id=126#tv=Authoritative%20Sources")


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