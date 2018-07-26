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
WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
*/

println('add a new record with tile - test_automation_record')

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Enter a new record'))

WebUI.click(findTestObject('Page_Select Record Type/a_Hazard'))

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EGSHazards'))

WebUI.setText(findTestObject('Object Repository/Page_Enter Record EGS Hazards/input_short_desc'), 'test_automation_record')

WebUI.click(findTestObject('Object Repository/Page_Enter Record EGS Hazards/input_Create New Record'))

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record View - test_automation_record/div_Hazard Record - INWORK'),20)

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record View - test_automation_record/div_test_automation_record'),5)

//WebUI.closeBrowser()