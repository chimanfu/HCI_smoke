import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
//if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) return
WebUI.comment('only run this for production sites to make sure disallow_record_modification parameter is checked')

CustomKeywords.'helper.login.LoginHelper.login'()

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')){
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ARC JET/div_current_login_user_email'),10)
	current_login_user_email=WebUI.getText(findTestObject('Object Repository/Page_ARC JET/div_current_login_user_email'))
	current_login_user_email=current_login_user_email.substring(0, current_login_user_email.indexOf('|')).trim()
	
}else{
	WebUI.waitForElementVisible(findTestObject('Page_Edit user info/current_login_user_email'),10)
	current_login_user_email=WebUI.getText(findTestObject('Page_Edit user info/current_login_user_email')).trim()
}

WebUI.comment('current_login_user_email='+current_login_user_email)

if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Edit user info/a_Admin'),5)){
	WebUI.comment('Admin tab/link not exists, so no need to run this test')
	return
}
WebUI.click(findTestObject('Object Repository/Page_Edit user info/a_Admin'))

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	try {
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
	} catch (Exception e) {
		e.printStackTrace()
	}
}
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))

WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), current_login_user_email+'\n')

WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Edit user info/fieldTitle_disallow_record_modification'),10)

String url = GlobalVariable.G_MAKE_MAS_url


if (url.contains('MAKE-MAS')) {
	println('The URL contains MAKE-MAS, so it is a test OR dev instance')
	WebUI.comment('it does not care if disallow_record_modification already checked or not')
} else {
	WebUI.comment('The URL does not contain MAKE-MAS, so it is NOT a test instance, so should not create new record on production site')
	WebUI.verifyElementChecked(findTestObject('Object Repository/Page_Edit user info/input_checkbox_disallow_record_modification'),5)

	WebUI.comment('disallow_record_modification already checked so it is good to go')
}
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	try {
		WebUI.switchToWindowIndex(1)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	} catch (Exception e) {
		e.printStackTrace()
	}
}
