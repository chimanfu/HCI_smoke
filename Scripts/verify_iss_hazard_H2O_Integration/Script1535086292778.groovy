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

//H2O Integration - e.g. record 27228 Ctl-8
if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard'))) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

String recordID='27228'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabControls&gv=group'
WebUI.navigateToUrl(siteURL)

if (GlobalVariable.G_MAKE_MAS_url.contains('react')){
	// react code
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_react_iss_hazard/div_Controls'),35)
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Controls'))
	
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'),22)
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'))
	
	//WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/span_Ctl-8'))
	//WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_27228_react_iss_hazard/span_Ctl-8'),10)
	
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/a_OCAD 123001'))
}else{
	// old code
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/div_Controls'),35)
	
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/div_Controls'))
	
	// click on the control ID: ctl-8
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/span_Ctl-8'),22)
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/span_Ctl-8'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_27228_iss_hazard/div_Controls ID'),15)
	
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/a_OCAD 123001'),10)
	
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/a_OCAD 123001'))

}
// take care the new windows for OCAD login
WebUI.delay(2)
WebUI.switchToWindowIndex(1)
WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8)
WebUI.switchToWindowIndex(0)
WebUI.closeWindowIndex(1)