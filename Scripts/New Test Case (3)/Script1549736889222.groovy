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

//CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.openBrowser('')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_hotfix/')
println System.getProperty('os.name')
try{
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),17,FailureHandling.OPTIONAL)){
			WebUI.delay(1)
			WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),5,FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(1)
			WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
			WebUI.delay(1)
			WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
			println 'clicked on Page_Login/smartcard_login_button'
			/////////////////////////////////////
			WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),8,FailureHandling.STOP_ON_FAILURE)
			WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
			println 'clicked on acceptCert_ok_button'
			/////////////////////////////////////
			WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/pin_field_empty'),5,FailureHandling.OPTIONAL)
			println 'found pin_field_empty'
			WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
			WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
			println 'typed PIN in pin_field_empty'
		}else{
			println 'Not found Launchpad login button, maybe OK'
		}
		
	}
}catch (Exception e) {
	println 'something wrong in launchpad login'
	e.printStackTrace()
	
}
return

WebUI.waitForImagePresent(findTestObject('Page_Login/pin_field_empty'),6,FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
return
WebUI.openBrowser('')

WebUI.navigateToUrl('https://search.yahoo.com/search?p=abc&fr=yfp-t&fp=1&toggle=1&cop=mss&ei=UTF-8')

WebUI.setText(findTestObject('Object Repository/Page_abc - Yahoo Search Results/input_Search query_p'), 'abc')

WebUI.click(findTestObject('Object Repository/Page_abc - Yahoo Search Results/input_abc_yui_3_10_0_1_1549737'))

//WebUI.click(findTestObject('Object Repository/Page_abc - Yahoo Search Results/a_Yahoo'))

