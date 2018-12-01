if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

if (!GlobalVariable.G_MAKE_MAS_url.contains('raining')) {
	WebUI.comment 'only run this test on training, skip the test as it is not a training site'
	GlobalVariable.userPin2 = 'SKIP'
	return null
}
if (GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss')) {
	WebUI.navigateToUrl('https://hazard.iss.nasa.gov/training/show_bug.cgi?id=27671#tv=tabApprovals_and_Concurrences&gv=group')
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/select_record_status'), 
	    'INWORK', true)
	WebUI.click(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/input_save_changes'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/span_Linked Record Status'),5)
	WebUI.click(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/span_Linked Record Status'))
	
	Linked_Record_Status_contents=WebUI.getText(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/div_Linked Record Status contents'))
	Linked_Record_Status_contents=Linked_Record_Status_contents.trim().replaceAll("\\s+", " ")
	WebUI.comment 'Linked_Record_Status_contents: \n'+Linked_Record_Status_contents
	expected_message='You are about to change Record 27671 - Improper Manufacturing from PHASE III APPROVED to INWORK'
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='The following checked records will have their statuses automatically changed on save:'
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Hazard Record 27674 - Structural Failure of the Acoustic Mulit-Purpose Crew Transfer Bag (MTCB) • From PHASE III APPROVED to REVIEW'
	check_message( Linked_Record_Status_contents,  expected_message)
}else if (GlobalVariable.G_MAKE_MAS_url.contains('cplms')) {
	WebUI.navigateToUrl('https://cplms.nasa.gov/training/show_bug.cgi?id=972#tv=Workflow')
	// need to make sure the current record status is PRELIMINARY in record 972, it should trigger the auto save popup by changing From PRELIMINARY to REVIEW
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/select_record_status'),
		'REVIEW', true)
	WebUI.click(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/button_Save Changes'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/h4_Linked Record Status'),5)
	WebUI.click(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/h4_Linked Record Status'))
	Linked_Record_Status_contents=WebUI.getText(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/div_Linked Record Status contents'))
	Linked_Record_Status_contents=Linked_Record_Status_contents.trim().replaceAll("\\s+", " ")
	WebUI.comment 'Linked_Record_Status_contents: \n'+Linked_Record_Status_contents
	
	expected_message='You are about to change record 972 - test_create_record_on_training from PRELIMINARY to REVIEW'
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='The following checked records will have their statuses automatically changed on save:'
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 957 - Hypers LCC test From PRELIMINARY to REVIEW '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='The following records will stay in their current status: '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 41 - MPS LH2 Ullage Pressure Terminate Replenish Anomaly DRAFT '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 1 - FC Single Board Computer Temperature Anomaly APPROVED '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 829 - CSE Propellant Valve Hydraulic Temperature Anomaly DRAFT'
	check_message( Linked_Record_Status_contents,  expected_message)
	
}else if (GlobalVariable.G_MAKE_MAS_url.contains('cpoms')) {
	WebUI.navigateToUrl('https://cpoms.nasa.gov/training/show_bug.cgi?id=5819#tv=Workflow')
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Cause - Record 27671  Improper/select_record_status'),
		'REVIEW', true)
	WebUI.click(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/button_Save Changes'))
	WebUI.delay(1)
	WebUI.waitForElementPresent(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/h4_Linked Record Status'),10)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/h4_Linked Record Status'),5)
	WebUI.click(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/h4_Linked Record Status'))
	Linked_Record_Status_contents=WebUI.getText(findTestObject('Object Repository/Page_LCN 972 test_create_record_on_/div_Linked Record Status contents'))	
	Linked_Record_Status_contents=Linked_Record_Status_contents.trim().replaceAll("\\s+", " ")
	WebUI.comment 'Linked_Record_Status_contents: \n'+Linked_Record_Status_contents
	
	expected_message='You are about to change record 5819 - test_create_record_on_training from PRELIMINARY to REVIEW '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='The following checked records will have their statuses automatically changed on save: '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 156 - Verify Abort Motor/ACM S&A Safing Pin Removed - PAD From PRELIMINARY to REVIEW '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='The following records will stay in their current status: '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 1595 - Launch Countdown SM Prop System Activation APPROVED '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 5271 - LH FTS Safe and Arm Abbreviated Test DRAFT '
	check_message( Linked_Record_Status_contents,  expected_message)
	expected_message='Record 2000 - Track and document the CM Battery C1b contactor cycles APPROVED'
	check_message( Linked_Record_Status_contents,  expected_message)
	
}else{
	WebUI.comment 'only test on oms, lms, iss_hazard, skip the test for other sites'
}

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
return

def check_message(String Linked_Record_Status_contents, String expected_message){
	if (Linked_Record_Status_contents.contains(expected_message)){
		KeywordUtil.markPassed('Linked_Record_Status_contents is OK, found string: '+expected_message)
	}else{
		KeywordUtil.logInfo('Try again, NOT found string: '+expected_message)
		//expected_message='This application does not support your browser'
		if (Linked_Record_Status_contents.contains(expected_message)){
			KeywordUtil.markPassed('Linked_Record_Status_contents is OK, found string: '+expected_message)
		}else{
			KeywordUtil.markFailed('ERROR: Linked_Record_Status_contents is wrong, NOT found expected string: "'+expected_message+'", please check actual Linked_Record_Status_contents: '+Linked_Record_Status_contents)
			//throw new AssertionError('ERROR: Linked_Record_Status_contents is wrong, NOT found expected string: "'+expected_message+'", please check actual Linked_Record_Status_contents: '+Linked_Record_Status_contents)
		}
	}
}
