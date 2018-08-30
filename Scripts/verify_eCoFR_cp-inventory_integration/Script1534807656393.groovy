import static org.junit.Assert.*

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen;

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

import internal.GlobalVariable as GlobalVariable
searchTerm="criterion"
println('check cp-inventory integration in eCoFR')
println('directly go to record 76 and open Products Tab')
println('check cp-inventory integration on record 76->Products Tab->Mapped Product: Search for Record ID field with searchTerm: '+searchTerm)
println('check cp-inventory integration on record 76->Products Tab->Compliance Products: Search for Record ID field with searchTerm: '+searchTerm)


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

println('directly go to record 76 and open Products Tab')
selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/show_bug.cgi?id=76#tv=Products")

//searchTerm="criterion"
println('check cp-inventory integration on record 76->Products Tab->Mapped Product: Search for Record ID field with searchTerm: '+searchTerm)
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_mapped_id_NEW_ROW_1",25)
selenium.click("id=cf_mapped_id_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(1)
selenium.typeKeys("id=cf_mapped_id_NEW_ROW_1", searchTerm)
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
s.type(Key.ENTER)
selenium.waitForPageToLoad("30000")
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(2)

println('check cp-inventory integration on record 76->Products Tab->Compliance Products: Search for Record ID field with searchTerm: '+searchTerm)
selenium.click("id=cf_compliance_id_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
selenium.typeKeys("id=cf_compliance_id_NEW_ROW_1", searchTerm)
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
s.type(Key.ENTER)
selenium.waitForPageToLoad("30000")
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(2)

CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
GlobalVariable.userPin2='ScreenshotTaken'
// open the current window which will trigger the popup
s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return