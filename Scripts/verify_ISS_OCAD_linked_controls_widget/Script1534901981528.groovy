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

/*
 * Only for ISS OCAD, Check linked controls widget (using record 123001)
 * 
 */

// login to ocad and access record #123001
// check Linked ISS Hazard Controls on the record
// check ISS Hazard Controls status
// select on CTRL ID: Ctl-8 from the record
// open a new tab on record #27228 from iss_hazard (will ask for login)
// select OCAD #123001
// open a new tab on record 123001 from ocad
// verify for record #123001 exists for OCAD 

if (!GlobalVariable.G_MAKE_MAS_url.contains('ocad')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/ocad_dev/show_bug.cgi?id=123001#tv=Information%20%26%20Evaluation')

// login to ocad and access record 123001
// check Linked ISS Hazard Controls
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_General 123001 MCH Inability t/div_Linked ISS Hazard Controls'),25)
WebUI.click(findTestObject('Object Repository/Page_General 123001 MCH Inability t/div_Linked ISS Hazard Controls'))


// check ISS Hazard Controls: 1
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_General 123001 MCH Inability t/span_ISS Hazard Controls 1'),25)
WebUI.click(findTestObject('Object Repository/Page_General 123001 MCH Inability t/span_ISS Hazard Controls 1'))


// select on CTRL ID: Ctl-8 from ocad
WebUI.click(findTestObject('Object Repository/Page_General 123001 MCH Inability t/a_Ctl-8'))

// open a new tab on record 27228 from iss_hazard
WebUI.delay(3)
WebUI.switchToWindowIndex(1)

// take care the login page from iss_hazard
if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),5,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Page_Login/input_login_btn'))
}
// select OCAD #123001
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 27228 Inability to gain/a_OCAD 123001'),40)
WebUI.click(findTestObject('Object Repository/Page_Cause 27228 Inability to gain/a_OCAD 123001'))

// open a new tab on record 123001 from ocad
WebUI.delay(3)
WebUI.switchToWindowIndex(2)
// wait for record exists for OCAD #123001
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_General 123001 MCH Inability t/strong_Record 123001 - APPROVE'),30)


WebUI.switchToWindowIndex(0)
WebUI.closeWindowIndex(2)
WebUI.closeWindowIndex(1)
