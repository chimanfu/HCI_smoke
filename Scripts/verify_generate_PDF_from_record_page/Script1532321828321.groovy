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
 * verify PDF is being generated correctly for a record
 * 
 * Steps:
 * 
 * search for existing records with recordName_for_PDFReport='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
 * select the first record found from the list
 * click 'Create PDF' link
 * click 'Generate PDF' button
 * verify PDF is generated 
 */

CustomKeywords.'helper.login.LoginHelper.login'()
String recordName_for_PDFReport
//recordName_for_PDFReport='test_automation_record'

//recordName_for_PDFReport=GlobalVariable.recordName1
recordName_for_PDFReport='1,2,3,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'

/*if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run generate PDF report test')
	return
}*/
/*
WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_test_automation_record'),10)
WebUI.click(findTestObject('Page_Main Page/a_test_automation_record'))
*/
WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
WebUI.waitForPageLoad(5)
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordName_for_PDFReport)
WebUI.click(findTestObject('Page_Main Page/bt_Search'))

//WebUI.waitForElementVisible(findTestObject('Page_Record List/li_Content_test_automation_record'),15)
//WebUI.click(findTestObject('Object Repository/Page_Record List/li_Content_test_automation_record'))
WebUI.delay(1)
println('if more than 1 record found, then select the first record first')
if (WebUI.waitForElementVisible(findTestObject('Page_Record List/a_record_1'),5)){
	WebUI.click(findTestObject('Page_Record List/a_record_1'))
}
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),15)
WebUI.click(findTestObject('Page_Record test_automation_record/a_PDF'))

if (WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),4)){
	WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
}
WebUI.delay(5)
WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),10)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),10)

