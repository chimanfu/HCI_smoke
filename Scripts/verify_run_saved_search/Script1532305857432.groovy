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

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_SavedSearches'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_My Records'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Record List/a_EditSearch'))

WebUI.setText(findTestObject('Page_Search for records/input_content'), 'joseph fu')

WebUI.click(findTestObject('Page_Search for records/input_Search'))

WebUI.click(findTestObject('Page_Record List/label_SaveSearch'))

WebUI.setText(findTestObject('Page_Record List/input_newqueryname'), 'joe_search')

WebUI.click(findTestObject('Page_Record List/button_Save'))

WebUI.click(findTestObject('Page_Search created/a_SavedSearches'))

WebUI.click(findTestObject('Page_Search created/a_joe_search'))

/*
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'))

WebUI.click(findTestObject('Object Repository/Page_Search for records/input_Search'))

WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'))


WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/button_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_SavedSearches'))

WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_joe_search'))
*/
WebUI.delay(1)

WebUI.click(findTestObject('Page_Record List joe_search/a_ForgetSearch'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Search is gone/div_search_notification_message'))

WebUI.click(findTestObject('Object Repository/Page_Search is gone/a_SavedSearches'))

//WebUI.click(findTestObject('Object Repository/Page_Search is gone/a_Home'))




