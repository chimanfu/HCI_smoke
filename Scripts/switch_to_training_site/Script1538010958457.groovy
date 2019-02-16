import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

//CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()
String training_site_url=''
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
if (siteURL.contains('mas.nasa.gov')){
	if (siteURL.contains('Inventory')){
		training_site_url=siteURL+'_Training'
	}else if (siteURL.contains('WSTFwebPAPER')){
		training_site_url=siteURL+'-training'
	}else{
		training_site_url=(siteURL+'Training')
	}
}else{
	training_site_url=siteURL+'/training'
}
if (siteURL.contains('cxfmea-cil')){
	training_site_url='https://mas.nasa.gov/cxFmeaTraining'
}
if (siteURL.contains('stafftrac')){
	training_site_url='https://mas.nasa.gov/stafftracTraining/'
}
String cmd = "pkill -f Chrome"
//Runtime.getRuntime().exec(cmd)
//WebUI.comment('killed all processes of Chrome before running test')

GlobalVariable.G_MAKE_MAS_url=training_site_url
//CustomKeywords.'helper.login.LoginHelper.login'(GlobalVariable.G_MAKE_MAS_url)
CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_404 Not Found/h1_Not Found'), 3,FailureHandling.OPTIONAL)){
	KeywordUtil.markWarning('It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have training site, try to find the sandbox link inside the Home page of '+siteURL)
	//GlobalVariable.userPin3='SKIP'
	GlobalVariable.G_MAKE_MAS_url=siteURL
	CustomKeywords.'helper.login.LoginHelper.login'()
	//CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
}else{
	KeywordUtil.markPassed("should be already login to the training site")
	return
}
/*WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
	WebUI.click(findTestObject('Page_Login/input_login_btn'))
	WebUI.comment('clicked on input_login_btn')
}
return*/
/*if((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/etasksheetTraining'
	GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/etasksheetTraining/page.cgi'
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')
	}
	return
}
else if((GlobalVariable.G_MAKE_MAS_url).contains('doctree')){
	GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/doctreeTraining'
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')
	}
	return
}*/
if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),5,FailureHandling.OPTIONAL)){
	//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)	
	WebUI.click(findTestObject('Object Repository/Page_Main Page/a_Home'))
	WebUI.comment('found Home TAB, launch Home page now')
}else{
	WebUI.comment('cannot find Home page, launch site url instead')
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
}
if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),15)
	
	//if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'),3,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'))
	WebUI.delay(5)
	training_site_url=WebUI.getUrl()
	GlobalVariable.G_MAKE_MAS_url=training_site_url
	println 'GlobalVariable.G_MAKE_MAS_url='+GlobalVariable.G_MAKE_MAS_url
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')
		if (WebUI.getUrl().contains('raining')){
			KeywordUtil.markPassed("should be already login to the training site")
			return
		}
	}
}
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
GlobalVariable.userPin3='SKIP'
KeywordUtil.markFailedAndStop("should be already login to the training site")


/*else{
	WebUI.comment 'It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have sandbox instance in Home page, try something else'
	println GlobalVariable.G_MAKE_MAS_url+' does not have sandbox instance'
	siteURL=GlobalVariable.G_MAKE_MAS_url
	if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
	GlobalVariable.G_MAKE_MAS_url=siteURL
	if (GlobalVariable.G_MAKE_MAS_url.contains('mas.nasa.gov')){
		if (GlobalVariable.G_MAKE_MAS_url.contains('Inventory')){
			training_site_url=GlobalVariable.G_MAKE_MAS_url+'_Training'
		}else if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')){
			training_site_url=GlobalVariable.G_MAKE_MAS_url+'-training'
		}else{
			training_site_url=(GlobalVariable.G_MAKE_MAS_url+'Training')
		}
	}else{
		training_site_url=(GlobalVariable.G_MAKE_MAS_url+'/training')
	}
	WebUI.navigateToUrl(training_site_url)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_404 Not Found/h1_Not Found'), 3,FailureHandling.OPTIONAL)){
		WebUI.comment 'It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have training site and cannot find the a_sandbox instance in Home page, will skip all the testcases from the testsuite (smoke_test_with_trainings) as it only runs for training site'
		GlobalVariable.userPin3='SKIP'
	}
	GlobalVariable.G_MAKE_MAS_url=training_site_url
	println 'GlobalVariable.G_MAKE_MAS_url='+GlobalVariable.G_MAKE_MAS_url
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')
	}
}*/