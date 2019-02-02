if (GlobalVariable.testrun_status.equals('SKIP')) return
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

if ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training')){
	WebUI.comment 'this is a training site, so trying to add a comment and save it'
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Signature and Closure_TAB'),5)
	WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Signature and Closure_TAB'))
	WebUI.setText(findTestObject('Object Repository/Page_Record_Created/textarea_comment'), 'my new comment')
	if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5)){
		WebUI.comment ('found save button, and click on it')
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
	}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/input_Save Changes'),1)){
		WebUI.comment ('found save button, and click on it')
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Save Changes'))
	}

}