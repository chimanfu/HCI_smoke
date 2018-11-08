if (GlobalVariable.userPin2.equals('SKIP')) return
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

CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

WebUI.comment 'verify loading of Metrics page from the Metrics TAB if it is available'
/*
verify loading of Metrics page from the Metrics TAB if it is available, it will 
1. click on the Metrics TAB
2. do a simple filter search 
3. select 'OPEN DISSENTS' from the review metrics'
4. verify 'Dissenting Opinion record' appears from Metric Details
*/

if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_eCoFR Main Page/a_Metrics'),1, FailureHandling.OPTIONAL)){
	WebUI.comment 'found Metrics TAB, going to check the Metrics page loading'
	WebUI.click(findTestObject('Object Repository/Page_eCoFR Main Page/a_Metrics'))
	
	if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_eCoFR Metrics/select_Mission'),18)){
		WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_eCoFR Metrics/select_Mission'),12)
		WebUI.delay(1)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_eCoFR Metrics/select_Mission'),1,FailureHandling.STOP_ON_FAILURE)
		
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_eCoFR Metrics/select_Review'), 1,FailureHandling.STOP_ON_FAILURE)
		
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_eCoFR Metrics/select_Organization'), 1,FailureHandling.STOP_ON_FAILURE)
		
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_eCoFR Metrics/select_Groups'), 1,FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_eCoFR Metrics/div_OPEN DISSENTS_metrics'),8)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_eCoFR Metrics/div_OPEN DISSENTS_metrics'),8)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Page_eCoFR Metrics/div_OPEN DISSENTS_metrics'))
		//WebUI.delay(1)
		//WebUI.click(findTestObject('Object Repository/Page_eCoFR Metrics/div_OPEN DISSENTS_metrics'))
		//WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_eCoFR Metrics/span_Dissenting Opinion record'),8)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_eCoFR Metrics/span_Dissenting Opinion record'),2)
		WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
		
	}
}else{
	WebUI.comment 'NOT found Metrics TAB, will not check the Metrics page loading'

}

