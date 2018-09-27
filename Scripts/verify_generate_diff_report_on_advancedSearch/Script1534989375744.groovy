if (GlobalVariable.userPin2.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('cofr')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('dex')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * verify diff report will be generated if the snapshot feature exists by doing a advanced search 
 * on 'Search by change' on option 'xml snapshot' before date: '2018-08-20'
 * 
 * do a advanced search on 
 *		select Search by change
 *		select option 'xml snapshot'
 *		if option not found for select_option xml snapshot so it does not support creating snapshot, so it cannot do diff report
 *		if option found, add before date: '2018-08-20'
 *		click search button
 * verify the searchTitle_XML Snapshot in the search return list
 * if more than 1 record found, then select the first record first		
 * 		click on PDF link
 * 		PDF dialog popup with 'Show changes relative to the version:'
 * 		select a version from the snapshots
 * 		click 'Generate PDF' to create a pdf file
 * 		check pdf file is generated correctly
 */



int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////
CustomKeywords.'helper.login.LoginHelper.login'()


WebUI.click(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'))

WebUI.click(findTestObject('Page_Search for records/div_Search by change'))

if (WebUI.waitForElementVisible(findTestObject('Page_Search for records/input_select_option_xmlversion'),5)){
	
	WebUI.click(findTestObject('Page_Search for records/input_select_option_xmlversion'))

	WebUI.setText(findTestObject('Page_Search for records/input_chfieldto_display'), '2018-08-20')

	WebUI.click(findTestObject('Page_Search for records/input_Search'))

	// verify the searchTitle_XML Snapshot in the search return list
	WebUI.waitForElementVisible(findTestObject('Page_Record List/strong_searchTitle_XML Snapshot'),10)

}else{
	println('Not found select_option xml snapshot so it does not support creating snapshot, so it cannot do diff report')
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}

WebUI.delay(2)
try{
	println('if more than 1 record found, then select the first record first')
	if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_record_1'),10)){
		WebUI.click(findTestObject('Page_Record List/a_record_1'))
	}
	if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_test_automation_record'),1)){
		WebUI.click(findTestObject('Page_Record List/a_test_automation_record'))
	}
	WebUI.delay(2)
}catch (Exception e) {
	e.printStackTrace()
}

if (WebUI.waitForElementVisible(findTestObject('Page_Record test_automation_record/a_Create Record Snapshot'), 15)){
	println('found Snapshot link so it can do diff report')
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF') ,40)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_Record test_automation_record/a_PDF'))
	WebUI.delay(1)
	//WebUI.scrollToElement(findTestObject('Page_Record test_automation_record/a_Home'),10)
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),10)
	WebUI.selectOptionByValue(findTestObject('Page_Record test_automation_record/select_diff_report_version'), '1', true)
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
	WebUI.delay(5)
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(90)
	WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),25)
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),25)
}else{
	println('Not found Snapshot link so it cannot do diff report')
}

/////////////////////////////////////////////////////////////////////////////
break
} catch (Exception e) {
// handle exception
e.printStackTrace()
if (++retry_count == maxTries) throw e;
WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
}
}