import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'helper.login.LoginHelper.login'()

if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),10)){
	//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)	
	WebUI.click(findTestObject('Object Repository/Page_Main Page/a_Home'))
	WebUI.comment('found Home TAB, launch Home page now')
}else{
	WebUI.comment('cannot find Home page, launch site url instead')
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
}
if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),15)
	
if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'),5)){
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'))
	WebUI.delay(2)
	training_site_url=WebUI.getUrl()
	GlobalVariable.G_MAKE_MAS_url=training_site_url
	println 'GlobalVariable.G_MAKE_MAS_url='+GlobalVariable.G_MAKE_MAS_url
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')	
	}
}else{
	WebUI.comment 'It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have training site and cannot find the a_sandbox instance in Home page, will skip all the testcases from the testsuite (smoke_test_with_trainings) as it only runs for training site'
	GlobalVariable.userPin3='SKIP'
}