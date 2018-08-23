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

// do a advanced search on 
//		select Search by change
//		select option 'xml snapshot'
//		add before date: '2018-08-20'
//		click search button
// verify the searchTitle_XML Snapshot in the search return list

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'))

WebUI.click(findTestObject('Page_Search for records/div_Search by change'))

WebUI.click(findTestObject('Page_Search for records/input_select_option_xmlversion'))

WebUI.setText(findTestObject('Page_Search for records/input_chfieldto_display'), '2018-08-20')

WebUI.click(findTestObject('Page_Search for records/input_Search'))

// verify the searchTitle_XML Snapshot in the search return list
WebUI.waitForElementVisible(findTestObject('Page_Record List/strong_searchTitle_XML Snapshot'),10)

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
	WebUI.selectOptionByValue(findTestObject('Page_Record test_automation_record/select_diff_report_version'), '1', true)
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
	WebUI.delay(5)
	WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),25)
	WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),25)
}else{
	println('Not found Snapshot link so it cannot do diff report')
}