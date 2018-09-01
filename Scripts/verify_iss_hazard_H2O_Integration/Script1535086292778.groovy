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

//H2O Integration - e.g. record 27228 Ctl-8
if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard'))) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

String recordID='27228'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabControls&gv=group'
WebUI.navigateToUrl(siteURL)
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_dev/show_bug.cgi?id=27228#tv=tabControls&gv=group')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/div_Controls'),35)

WebUI.click(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/div_Controls'))

// click on the control ID: ctl-8
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/span_3c Crew to ensure hooks c'),22)
WebUI.click(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/span_3c Crew to ensure hooks c'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/div_Controls ID'),15)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause - Record 27228  Inabilit/a_OCAD 123001'),10)
