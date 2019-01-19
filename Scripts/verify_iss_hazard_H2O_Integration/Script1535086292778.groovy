if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//H2O Integration - e.g. record 27228 Ctl-8

if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) && !(GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss'))) {
	WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')
	GlobalVariable.userPin2 = 'SKIP'
	return null
}
int retry_count = 0;
int maxTries = 1;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

String recordID='27228'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabControls&gv=group'
WebUI.navigateToUrl(siteURL)

//if (GlobalVariable.G_MAKE_MAS_url.contains('react')){
if (GlobalVariable.G_MAKE_MAS_url.contains('react')||GlobalVariable.G_MAKE_MAS_url.contains('raining')||GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss')){
		
	// react code
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_react_iss_hazard/div_Controls'),35)
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Controls'))
	
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'),22)
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'))
	
	//WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/span_Ctl-8'))
	//WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/div_Ctl-8'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_27228_react_iss_hazard/span_Ctl-8'),10)
	CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
	WebUI.click(findTestObject('Page_Record_27228_react_iss_hazard/a_OCAD record_number'))
}else{
	// old code
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/div_Controls'),35)
	
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/div_Controls'))
	
	// click on the control ID: ctl-8
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/span_Ctl-8'),22)
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/span_Ctl-8'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_27228_iss_hazard/div_Controls ID'),15)
	
	WebUI.waitForElementVisible(findTestObject('Page_Record_27228_iss_hazard/a_OCAD 123001'),10)
	CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
	WebUI.click(findTestObject('Page_Record_27228_iss_hazard/a_OCAD 123001'))

}
// take care the new windows for OCAD login
WebUI.delay(2)
WebUI.switchToWindowIndex(1)
WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8)
WebUI.switchToWindowIndex(0)
WebUI.closeWindowIndex(1)
/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}