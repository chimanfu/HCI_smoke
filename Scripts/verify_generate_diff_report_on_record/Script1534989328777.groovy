if (GlobalVariable.testrun_status.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('cofr')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('dex')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * check generate diff PDF report is working if the snapshot feature exists in the record page
 * 
 * Steps:
 * 
 * for production sites:
 * 		do not modify or create snasphot on records
 * 		need a list of records that already set up for diff reports (with snapshots)
 * 		may not allow to take snapshot
 * 		only allow to generate pdf diff report
 * 
 * for dev/test sites:
 * 		get the record with name 'test_automation_record'
 * 		make some changes on the record
 * 		create snapshot (should save the record automatically)
 * 		click on PDF link 
 * 		PDF dialog popup with 'Show changes relative to the version:'
 * 		select a version from the snapshots
 * 		click 'Generate PDF' to create a pdf file
 * 		check pdf file is generated correctly
 */

WebUI.comment 'randomly to run this test or not (0 or 1), should already covered similiar case in verify_generate_diff_report_on_advancedSearch'
if ((int) (Math.random()+0.5)){
	WebUI.comment('perform test this time')
}
else{
	WebUI.comment 'will skip running it this time to save time'
	return
}

int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()
String recordName_forDiffReport

recordName_forDiffReport=GlobalVariable.recordName1
if (recordName_forDiffReport.trim().equals("") || recordName_forDiffReport.trim().equals(null)){
	recordName_forDiffReport='test_automation_record'
}

/*if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	return
}
if ((GlobalVariable.G_MAKE_MAS_url).contains('sims')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	return
}
if ((GlobalVariable.G_MAKE_MAS_url).contains('ocad')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	return
}
if ((GlobalVariable.G_MAKE_MAS_url).contains('fiqs')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	return
}
if ((GlobalVariable.G_MAKE_MAS_url).contains('evat')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	return
}*/
if ((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	println('do not need to run generate diff report test as no snapshot feature in record')
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()


WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordName_forDiffReport)

WebUI.click(findTestObject('Page_Main Page/bt_Search'))
WebUI.delay(2)
try{
	if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_record_1'),7)){
		WebUI.click(findTestObject('Page_Record List/a_record_1'))
	}
	if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_test_automation_record'),1)){
		WebUI.click(findTestObject('Page_Record List/a_test_automation_record'))
	}
}catch (Exception e) {
	e.printStackTrace()
	WebUI.comment 'OK to continue'
}
/*WebUI.click(findTestObject('Page_Record test_automation_record/a_Create Record Snapshot'))

WebUI.setText(findTestObject('Page_Record test_automation_record/input_xml_version_description'), recordName_forDiffReport)

WebUI.click(findTestObject('Page_Record test_automation_record/button_Create Snapshot'))

WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Save Changes'),20)*/

//WebUI.click(findTestObject('Page_Record test_automation_record/button_Save Changes'))

//WebUI.delay(2)
if (WebUI.waitForElementVisible(findTestObject('Page_Record test_automation_record/a_Create Record Snapshot'), 2)){
	println('found Snapshot link so it can do diff report')
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF') ,35)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_Record test_automation_record/a_PDF'))
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),8)
	if (WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/select_diff_report_version'),6)){
		WebUI.selectOptionByValue(findTestObject('Page_Record test_automation_record/select_diff_report_version'), '1', true)
		WebUI.delay(1)
	}else{
		WebUI.comment 'WARNING: Not found select_diff_report_version, the record may not have snapshots'
	}
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),5)
	WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
	WebUI.delay(5)
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(10)
	WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),10)
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),3)
	
}else{
	println('Not found Snapshot link so it cannot do diff report')
}
//WebUI.click(findTestObject('Page_Record test_automation_record/a_Home'))
/////////////////////////////////////////////////////////////////////////////
break
} catch (Exception e) {
// handle exception
e.printStackTrace()
if (++retry_count == maxTries) throw e;
WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
}
}
