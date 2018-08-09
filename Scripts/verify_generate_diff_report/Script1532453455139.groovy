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
 * for production sites:
 * 		do not modify or create snasphot on records
 * 		need a list of records that already set up for diff reports (with snapshots)
 * 		may not allow to take snapshot
 * 		only allow to generate pdf diff report
 * 
 * for dev/test sites:
	 * get the record with name 'test_automation_record'
	 * make some changes on the record
	 * create snapshot (should save the record automatically)
	 * click on PDF link 
	 * PDF dialog popup with 'Show changes relative to the version:'
	 * select a version from the snapshots
	 * click 'Generate PDF' to create a pdf file
	 * check pdf file is generated correctly
 */
//CustomKeywords.'helper.login.LoginHelper.login'()
String recordName_forDiffReport
// for dev sites
if ((GlobalVariable.G_MAKE_MAS_url).contains('MAKE-MAS')){
	recordName_forDiffReport='test_automation_record'
}
else{
	// for production sites
	recordName_forDiffReport=GlobalVariable.recordName1
}



if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run generate diff report test')
	return
}
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordName_forDiffReport)

WebUI.click(findTestObject('Page_Main Page/bt_Search'))

WebUI.click(findTestObject('Page_Record List/a_test_automation_record'))

WebUI.click(findTestObject('Page_Record test_automation_record/a_Create Record Snapshot'))

WebUI.setText(findTestObject('Page_Record test_automation_record/input_xml_version_description'), recordName_forDiffReport)

WebUI.click(findTestObject('Page_Record test_automation_record/button_Create Snapshot'))

WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Save Changes'),20)
//WebUI.click(findTestObject('Page_Record test_automation_record/button_Save Changes'))

//WebUI.delay(2)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Hazard PDF') ,40)
WebUI.delay(5)
WebUI.click(findTestObject('Page_Record test_automation_record/a_Hazard PDF'))
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Page_Record test_automation_record/select_diff_report_version'), '1', true)
WebUI.delay(1)
WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
WebUI.delay(4)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),25)
//WebUI.click(findTestObject('Page_Record test_automation_record/a_Home'))
