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


current_login_user_email=WebUI.getText(findTestObject('Page_Edit user Joseph Fu joseph.fun/current_login_user_email')).trim()

WebUI.comment('current_login_user_email='+current_login_user_email)

WebUI.click(findTestObject('Object Repository/Page_Edit user Joseph Fu joseph.fun/a_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Administer your installation (/a_Users'))

WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), current_login_user_email+'\n')

WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Edit user Joseph Fu joseph.fun/fieldTitle_disallow_record_modification'),10)


WebUI.verifyElementChecked(findTestObject('Object Repository/Page_Edit user Joseph Fu joseph.fun/input_checkbox_disallow_record_modification'),10)

WebUI.comment('disallow_record_modification already checked')
