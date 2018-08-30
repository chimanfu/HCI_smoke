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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.KeyModifier
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import com.thoughtworks.selenium.Selenium

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

println 'only run on cp_hazard'
println 'directly goto existing record 6505->Verifications Tab'
println 'select VERIF49'
println 'from Verification Traceability Type:, select LCC'
println 'enter Transmission as the LCC number to searh, get the search results'
println 'verify search result of linking works'
println 'takingScreenshot and exit the current state and reload page after popup'

if (!GlobalVariable.G_MAKE_MAS_url.contains('cp_hazard')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

/*println('advanced search on SLS Integrated Cause')
WebUI.click(findTestObject('Page_Search for records/a_Advanced Search'))

WebUI.click(findTestObject('Page_Search for records/select_product_SLS Integrated Cause'))

WebUI.click(findTestObject('Page_Search for records/input_Search'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record List/a_record_1'),10)
WebUI.click(findTestObject('Object Repository/Page_Record List/a_record_1'))

WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/div_Verifications'),10)
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/div_Verifications'))
WebUI.delay(8)
*/
def waifForElement(String xpath, int inSeconds){
	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
	for (int second = 0;; second++) {
		if (second >= inSeconds) fail("timeout");
		try { if (selenium.isElementPresent(xpath)&&selenium.isVisible(xpath)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
}

/////////////////////////
// get record 6505->Verifications->VERIF49
String baseUrl = "https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group"
//WebUI.navigateToUrl(baseUrl)
//WebDriver driver = DriverFactory.getWebDriver()
def driver = DriverFactory.getWebDriver()
Screen s = new Screen()
WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver,baseUrl)

//*[@id="cfgr_Verifications_list_item_1929070"]

String verification_id='1935140' //from VERIF49 on record 6505

selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group")

String verifiedRecord="//*[@id='cfgr_Verifications_row_"+verification_id+"_collapsed_display_area_content_title']/span"
//String verifiedRecord="//span[@id='cf_omrs_daggr_1935140_link_image_on']/img"
waifForElement(verifiedRecord,160)
WebUI.delay(10)
selenium.click(verifiedRecord)

waifForElement("id=cf_verification_traceability_"+verification_id,60)
WebUI.delay(1)
WebUI.scrollToElement(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/label_Verification Traceabilit'), 3)

selenium.click("id=cf_verification_traceability_"+verification_id)
selenium.select("id=cf_verification_traceability_"+verification_id, "label=LCC")
waifForElement("id=cf_lcc_id_"+verification_id,10)
selenium.click("id=cf_lcc_id_"+verification_id)
selenium.type("id=cf_lcc_id_"+verification_id, "Transmission")
WebUI.delay(2)
s.type(Key.ENTER)
selenium.waitForPageToLoad("30000")
waifForElement("id=daggr_title_search",25)
selenium.click("id=daggr_title_search")
WebUI.delay(2)
// create link on first record and verify
WebUI.click(findTestObject('Page_Cause - Record 6505  Erroneous/div_search results title'))
WebUI.waitForElementClickable(findTestObject('Page_Cause - Record 6505  Erroneous/img_create_recordLink'),10)
WebUI.click(findTestObject('Page_Cause - Record 6505  Erroneous/img_create_recordLink'))
waifForElement('id=img_cf_lcc_id_'+verification_id, 25)

WebUI.delay(2)

CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
GlobalVariable.userPin2='ScreenshotTaken'
s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return
///////////////////////////////////////////////////////
/*selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Method of Closure:'])[1]/following::img[3]")) break; } catch (Exception e) {}
	Thread.sleep(3000);
}
Thread.sleep(5000)
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Method of Closure:'])[1]/following::img[3]")

selenium.click("id=cf_verification_traceability_1929134")
selenium.select("id=cf_verification_traceability_1929134", "label=DMM")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("id=cf_dmm_number_1929134")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isVisible("id=cf_dmm_number_1929134")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

selenium.clickAt("id=cf_dmm_number_1929134", "")
selenium.waitForPageToLoad("30000")
selenium.type("id=cf_dmm_number_1929134", "Transmission")
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
s.type(Key.ENTER)
//selenium.clickAt("id=cf_dmm_number_1929134", "")
selenium.waitForPageToLoad("30000")

return*/
// get record 6505



WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/img_link_icon_1'),25)
WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/img_link_icon_1'),25)
WebUI.delay(2)
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/img_link_icon_1'))
WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'),5)

selenium.click("id=cf_verification_traceability_1929070")

selenium.select("id=cf_verification_traceability_1929070", "label=DMM")
selenium.click("id=cf_verification_traceability_1929070")
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/span_CP-DMM Linkable Fields'),10)
WebUI.delay(2)
s.type(Key.TAB)
WebUI.delay(2)
s.type('Transmission')
WebUI.delay(2)
s.type(Key.ENTER)
WebUI.delay(8)

selenium.select("id=cf_verification_traceability_1929070", "label=LCC")
selenium.click("id=cf_verification_traceability_1929070")
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/span_CP-LMS Linkable Fields'),10)
WebUI.delay(2)
s.type(Key.TAB)
WebUI.delay(2)
s.type('Transmission')
WebUI.delay(2)
s.type(Key.ENTER)
WebUI.delay(8)

selenium.select("id=cf_verification_traceability_1929070", "label=OMRS")
selenium.click("id=cf_verification_traceability_1929070")
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/span_CP-OMS Linkable Fields'),10)
WebUI.delay(2)
s.type(Key.TAB)
WebUI.delay(2)
s.type('Transmission')
WebUI.delay(2)
s.type(Key.ENTER)
WebUI.delay(8)

selenium.select("id=cf_verification_traceability_1929070", "label=DVO")
selenium.click("id=cf_verification_traceability_1929070")

WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/span_Cradle Linkable Fields'),10)
WebUI.delay(1)

s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return
///////////////////////

//Screen s = new Screen()

println('check DMM linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.UP)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-DMM Linkable Fields'),10)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'DVO', true)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-DMM search results'))

println('check DVO linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_Cradle Linkable Fields'),10)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'LCC', true)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/button_Linked'))

println('check LCC linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-LMS Linkable Fields'),10)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-LMS search results'))

println('check OMRS linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'OMRS', true)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-OMS Linkable Fields'),10)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-OMS search results'))


s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
