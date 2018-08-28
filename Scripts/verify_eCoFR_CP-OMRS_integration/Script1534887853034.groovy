import static org.junit.Assert.*

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen;

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

import internal.GlobalVariable as GlobalVariable

println('check cp-OMRS integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
println('Select OMRS from the Source Type list')
println('Search for OMRS Number field with searchTerm: ')
println('verify CP-OMRS search results')

if (!GlobalVariable.G_MAKE_MAS_url.contains('cofr')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}




CustomKeywords.'helper.login.LoginHelper.login'()
Screen s = new Screen()
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)

println('check cp-OMRS integration in eCoFR')
println('directly go to record 126 and open Authoritative Sources Tab')
selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/show_bug.cgi?id=126#tv=Authoritative%20Sources")


println('Select OMRS from the Source Type list')
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_source_type_NEW_ROW_1",25)
selenium.click("id=cf_source_type_NEW_ROW_1")
selenium.select("id=cf_source_type_NEW_ROW_1", "label=OMRS")

searchTerm="open work"
println('Search for OMRS Number field with searchTerm: '+searchTerm)
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_omrs_alias_NEW_ROW_1",15)
selenium.click("id=cf_omrs_alias_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(1)
selenium.typeKeys("id=cf_omrs_alias_NEW_ROW_1", searchTerm)
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
s.type(Key.ENTER)
selenium.waitForPageToLoad("30000")

println('verify CP-OMRS search results')
CustomKeywords.'hci_smoke_test.common.waifForElement'("//div[@id='digIt_title_find']//span",60)
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(10)

CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
GlobalVariable.userPin2='ScreenshotTaken'
// open the current window which will trigger the popup
s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return