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
import org.openqa.selenium.Keys as Keys
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen;

println('Only for iss_part: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_part')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

println('directly go to record 7168 which has VMDB integration')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_part_dev/show_bug.cgi?id=7168')

println 'verify VMDB Linkable Fields'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/span_VMDB Linkable Fields'),10)
WebUI.click(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/span_VMDB Linkable Fields'))

println 'do a quick search on the part number 1F28980'
WebUI.click(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/input_cf_partnumber'))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/input_cf_partnumber'), Keys.chord(Keys.ENTER))


println('search list displayed and click on the create link button')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/img_create_23971972'),10)
WebUI.click(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/img_create_23971972'))


println("verify create link is working and showing linking status")
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/img_img_cf_partnumber'),5)


/*WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/div_View part in VMDB'),5)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PRACA - Record 7168  ETCS RBVM/div_View drawing in VMDB'),5)*/

CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
GlobalVariable.userPin2='ScreenshotTaken'
// open the current window which will trigger the reload page popup to reload page
Screen s = new Screen()
s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return
