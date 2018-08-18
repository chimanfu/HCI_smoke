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
 * search for keyword defined from search_term with search option as 'all' in the simple search field'
 * 
 * Steps:
 * 
 * enter search_term='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
 * select All option
 * do a quick search
 * verify list of search result with records found
 * is should show records from the search_term
 * 
 */

int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////
CustomKeywords.'helper.login.LoginHelper.login'()
if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	println('this is doctree')
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Document Tree/img_System Logo'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/img_System Logo'))
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Document Tree/input_search'), 'DSG-PLAN-001')
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_SEARCH'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/div_1 result for DSG-PLAN-001'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_1 result for DSG-PLAN-001'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/span_DSG-PLAN-001'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/div_DSG Implementation Plan'))
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/span_DSG-PLAN-001'))
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_edit details'))
	return
}else if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ARC JET/input_keywords'), 10)
	WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_keywords'), 'ALL')
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Search'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_Showing results for ALL'))
	
	String recordName=GlobalVariable.recordName1
	WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_keywords'), recordName)
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Search'))
	
	WebUI.click(findTestObject('Page_ARC JET/div_Showing results for RecordSeries'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/td_AHF 306 Pre-test Pyrometer'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ARC JET/button_Save'),5)
	return

}
/////////////////////////////////

String search_term='1,2,3,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'

WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
WebUI.waitForPageLoad(5)
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
WebUI.click(findTestObject('Page_Main Page/bt_Search'))
try {
	if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),20)){
		println('a_EditSearch is present')
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),20)
	}
} catch (Exception e) {
	e.printStackTrace()
	if (WebUI.verifyAlertPresent(1,FailureHandling.OPTIONAL)){
		String alertText=WebUI.getAlertText()
		WebUI.acceptAlert()
		println('accept alert='+alertText)
	}
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
	WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),20)
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'),10)

WebUI.waitForElementVisible(findTestObject('Page_Record List/li_Content_test_automation_record'),15)

if (WebUI.waitForElementVisible(findTestObject('Page_Record List/a_test_automation_record'),2)){
	WebUI.click(findTestObject('Object Repository/Page_Record List/a_test_automation_record'))	
}
try{
	if (WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/div_test_automation_record'),10)){
		WebUI.click(findTestObject('Page_Record test_automation_record/div_test_automation_record'))
	}	
} catch (Exception e) {
	e.printStackTrace()
	WebUI.delay(1)
}

//WebUI.click(findTestObject('Page_Record test_automation_record/button_Save Changes'))

//WebUI.waitForElementVisible(findTestObject('Page_Record test_automation_record/div_Close alertRecord Saved'),12)
//WebUI.delay(1)
//WebUI.click(findTestObject('Page_Main Page/a_Home'))
	/////////////////////////////////////////////////////////////////////////////
	} catch (Exception e) {
		// handle exception
		e.printStackTrace()
		if (++retry_count == maxTries) throw e;
		println('Retry:'+retry_count+' rerun failed case now...')
	}
}

