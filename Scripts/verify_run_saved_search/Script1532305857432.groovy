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
 * verify saved search feature is working as expected
 * 
 * Steps:
 * 
 * click on Saved Searches
 * select 'My Records' to verify it's pre-existed
 * enter search_term into keyword search field
 * click Search button
 * click on 'Save Search'
 * type saveSearchName='joe_search'
 * click Save button
 * click on Saved Searches
 * select 'joe_search'
 * verify records shown
 * select 'Forget Search' link
 * verify notification_message that search search 'joe_search' is gone
 */

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

String search_term='1,2,3,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
String saveSearchName='joe_search'
WebUI.waitForElementVisible(findTestObject('Page_Main Page/a_SavedSearches'),10)
WebUI.click(findTestObject('Page_Main Page/a_SavedSearches'))

WebUI.click(findTestObject('Page_Main Page/a_My Records'))

WebUI.delay(1)

WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)

WebUI.click(findTestObject('Page_Main Page/bt_Search'))

WebUI.click(findTestObject('Page_Record List/label_SaveSearch'))

WebUI.setText(findTestObject('Page_Record List/input_newqueryname'), saveSearchName)

WebUI.click(findTestObject('Page_Record List/button_Save'))

WebUI.click(findTestObject('Page_Search created/a_SavedSearches'))

WebUI.click(findTestObject('Page_Search created/a_joe_search'))

//////////////////////
// verify joe_search is working
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),10)

// verify edit search is working
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'))
WebUI.click(findTestObject('Object Repository/Page_Search for records/input_Search'))
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'))

// verify cancel save search is working
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/button_Cancel'),10)
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/button_Cancel'))
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_SavedSearches'))
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_joe_search'))
//////////////////////
WebUI.delay(1)

// verify delete save search is working
WebUI.click(findTestObject('Page_Record List joe_search/a_ForgetSearch'))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('Page_Search is gone/div_search_notification_message'))

println('verified visible of the search_notification_message "OK, the joe_search search is gone." ')

WebUI.click(findTestObject('Object Repository/Page_Search is gone/a_SavedSearches'))

WebUI.verifyElementNotPresent(findTestObject('Page_Search created/a_joe_search'),2)

println('not found joe_seach from saved search, so it is deleted sucessfully')

//WebUI.click(findTestObject('Object Repository/Page_Search is gone/a_Home'))




