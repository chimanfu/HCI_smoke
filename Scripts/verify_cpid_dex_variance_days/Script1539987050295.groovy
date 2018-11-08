if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

if (!(GlobalVariable.G_MAKE_MAS_url.contains('cpid')) && !(GlobalVariable.G_MAKE_MAS_url.contains('dex'))){
	println 'skip the test, only test the Variance of days in cpid and dex'
	GlobalVariable.userPin2 = 'SKIP'
	return null
	
}

String siteURL=GlobalVariable.G_MAKE_MAS_url
CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

if (GlobalVariable.G_MAKE_MAS_url.contains('cpid')){
	recordID='1258' // cpid
}else{
	recordID='45'  // dex
}

Variance_days='365'
Baselined_Variance_days='18'

if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Basic%20Information'

WebUI.navigateToUrl(siteURL)

if (GlobalVariable.G_MAKE_MAS_url.contains('dex')){
	//////// dex
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Variance/input_Requestor Need Date'), 10)
	WebUI.clearText(findTestObject('Object Repository/Page_Record_Variance/input_Requestor Need Date'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Page_Record_Variance/input_Requestor Need Date'), '2019-12-12')
	
	WebUI.setText(findTestObject('Object Repository/Page_Record_Variance/input_Provider Expected Delivery Date'), '2018-12-12')
	
	WebUI.setText(findTestObject('Object Repository/Page_Record_Variance/input_Adjusted Delivery Date'), '2018-12-12')
	
	WebUI.click(findTestObject('Object Repository/Page_Record_Variance/div_Variance from Need Date'))
	Variance_days_actual=WebUI.getText(findTestObject('Page_Record_Variance/div_Variance from Need Date'))
	if (Variance_days_actual.contains(Variance_days)){
		println 'Variance value matched on '+Variance_days
	}else{
		println 'Variance value not matched, actual value is '+Variance_days_actual+ ', expected to be '+Variance_days
		throw new AssertionError('ERROR: Variance value not matched, actual value is '+Variance_days_actual+ ', expected to be '+Variance_days)
	}
}else{
	///////// cpid
	WebUI.scrollToElement(findTestObject('Page_Record_Variance/input_Need Date'), 10)
	WebUI.clearText(findTestObject('Page_Record_Variance/input_Need Date'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Page_Record_Variance/input_Need Date'), '2019-12-12')
	
	WebUI.setText(findTestObject('Page_Record_Variance/input_Original Need Date'), '2019-12-12')
	
	WebUI.setText(findTestObject('Page_Record_Variance/input_Baselined Delivery Date'), '2018-12-30')
	
	WebUI.setText(findTestObject('Page_Record_Variance/input_Expected Delivery Date'), '2018-12-12')
	
	WebUI.click(findTestObject('Page_Record_Variance/div_Variance'))
	Variance_days_actual=WebUI.getText(findTestObject('Page_Record_Variance/div_Variance'))
	if (Variance_days_actual.contains(Variance_days)){
		println 'Variance value matched on '+Variance_days
	}else{
		println 'Variance value not matched, actual value is '+Variance_days_actual+ ', expected to be '+Variance_days
		throw new AssertionError('ERROR: Variance value not matched, actual value is '+Variance_days_actual+ ', expected to be '+Variance_days)
	}
	
	Baselined_Variance_days_actual=WebUI.getText(findTestObject('Page_Record_Variance/div_Baselined Variance'))
	if (Baselined_Variance_days_actual.contains(Baselined_Variance_days)){
		println 'Baselined_Variance value matched on '+Baselined_Variance_days
	}else{
		println 'Baselined_Variance value not matched, actual value is '+Baselined_Variance_days_actual+ ', expected to be '+Baselined_Variance_days
		throw new AssertionError('ERROR: Baselined_Variance value not matched, actual value is '+Baselined_Variance_days_actual+ ', expected to be '+Variance_days)
	}
}

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
return