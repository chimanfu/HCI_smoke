if (GlobalVariable.userPin2.equals('SKIP')) return
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
 * verify mail is being sent for any search result to any team member
 * 
 * Steps:
 * 
 * type search_term='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
 * search for records
 * click EmailSearchResults button
 * enter sendToAdrress='joseph.fu@nasa.gov'
 * click send button
 * verify sent message confirmation
 * check email in outlook with the following contents:
 * 
 * example:
 * [SSMA] Link to SSMA search results
 * 
 * Joseph Fu shared the saved search Link to SSMA search results with you:
 * View the search results here: 
 * https://mas.nasa.gov/ssma/buglist.cgi?luid=8CC75BD4-9D0D-11E8-AF64-C1A86CDEDDFA
 * 	
*/

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()
String sendToAdrress='joseph.fu@nasa.gov'
String search_term='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'

if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/a_SavedSearches'),25)
	WebUI.click(findTestObject('Page_Main Page/a_SavedSearches'))
	WebUI.click(findTestObject('Page_Main Page/a_My Records'))
}else{
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),25)
	WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))	
	//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/a_test_automation_record'),10)
}
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record List/label_EmailSearchResults'),20)
WebUI.click(findTestObject('Object Repository/Page_Record List/label_EmailSearchResults'))

WebUI.setText(findTestObject('Object Repository/Page_Record List/input_em_to'), sendToAdrress)
WebUI.click(findTestObject('Object Repository/Page_Record List/button_Send'))

//WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/div_Email sent to user address'),20)
emailSentMsg=WebUI.getText(findTestObject('Object Repository/Page_Record List/div_Email sent to user address'))
if (emailSentMsg.contains(sendToAdrress)){
	println('mail sent successfully, found sendToAdrress : '+sendToAdrress)
}else{
	println('mail not sent, as not found sendToAdrress : '+sendToAdrress)
	throw new AssertionError('ERROR: mail not sent, as not found sendToAdrress : '+sendToAdrress)
}