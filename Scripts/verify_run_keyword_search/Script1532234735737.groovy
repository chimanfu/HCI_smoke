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
// search by record ID
 
WebUI.setText(findTestObject('Object Repository/Page_CP-Hazard Main Page/input_quicksearch'), '7626')

WebUI.waitForPageLoad(5)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CP-Hazard Main Page/select_search_option'), 'all', true)

WebUI.waitForPageLoad(15)

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/input'))

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record 7626/div_Hazard Record 7626 - INWOR'), 15)

WebUI.click(findTestObject('Page_Hazard Record 7626/div_Record-summary'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Hazard Record 7626/button_Save Changes'))

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record 7626/div_Close alertRecord Saved'), 12)

//WebUI.click(findTestObject('Page_Hazard Record 7626/div_Close alertRecord Saved'))
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Home'))
*/

////////////////////


/*
 WebUI.openBrowser('')
 
 WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
 
 WebUI.click(findTestObject('Page_Login/input_login_btn'))
 
 WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
 */
 
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CP-Hazard Main Page/input_quicksearch'),15)
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CP-Hazard Main Page/select_search_option'), 'all', true)
WebUI.waitForPageLoad(5)
WebUI.setText(findTestObject('Object Repository/Page_CP-Hazard Main Page/input_quicksearch'), 'test_automation_record')

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/bt_Search'))

WebUI.waitForElementVisible(findTestObject('Page_Record List/li_Content_test_automation_record'),15)

WebUI.click(findTestObject('Object Repository/Page_Record List/a_test_automation_record'))

WebUI.click(findTestObject('Page_Hazard Record test_automation_record/div_test_automation_record'))
WebUI.delay(1)

WebUI.click(findTestObject('Page_Hazard Record test_automation_record/button_Save Changes'))

WebUI.waitForElementVisible(findTestObject('Page_Hazard Record test_automation_record/div_Close alertRecord Saved'),12)
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Home'))

