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
WebUI.click(findTestObject('Page_CP-Hazard Main Page/a_SavedSearches'))

WebUI.click(findTestObject('Page_CP-Hazard Main Page/a_My Records'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/a_test_automation_record'),10)

WebUI.click(findTestObject('Object Repository/Page_Record List/label_EmailSearchResults'))

WebUI.setText(findTestObject('Object Repository/Page_Record List/input_em_to'), 'joseph.fu@nasa.gov')

WebUI.click(findTestObject('Object Repository/Page_Record List/button_Send'))

//WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record test_automation_record/a_My Records'),10)

//WebUI.click(findTestObject('Object Repository/Page_Record List/a_Home'))


