if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.stringtemplate.v4.compiler.CodeGenerator.region_return
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 
 check key message and permitted browsers info of bad_browser_blurb parameter in Admin->NASA Params->bad_browser_blurb
 
 Steps:
 
 goto Admin->NASA Params->bad_browser_blurb
 check bad_browser_blurb parameter with correct message for supporting browsers if running on unsupported browser
 check 2 key messages showing in the html message
	 expected_message='Your browser is not supported by this system.'
	 or
	 expected_message='This application does not support your browser'
	 and
	 expected_message='Please use one of the following'
 check with profile->GlobalVariable.allowedBrowsers for supported browser names from bad_browser_blurb message 
 should support browsers mentioned in the list of GlobalVariable.allowedBrowsers
 how about Edge?
 */
// 7.0 rollout plan 
// https://docs.google.com/spreadsheets/d/1Y-aObiFf3VOppDvePzLnLsVXcxFN6EpnKlqsQHH03AY/edit#gid=1590469616
// default:   IE9+ and FF, Chrome and Safari
// etasksheet: FF, Safari  ?

String supportedBrowser=''
String siteURL=GlobalVariable.G_MAKE_MAS_url

if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
bad_browser_blub_view=siteURL+'/editparams.cgi?section=nasa#bad_browser_blurb_desc'

int retry_count = 0;
int maxTries = 1;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////
//CustomKeywords.'helper.login.LoginHelper.login'()
		
/*if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	siteURL=GlobalVariable.G_MAKE_MAS_url
	if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'admin.cgi')
}else{
	WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'), 60)
	WebUI.click(findTestObject('Page_Main Page/a_Admin'))
	if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
	}
}*/


CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(bad_browser_blub_view)

/*WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'),10)
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))
WebUI.click(findTestObject('Page_Configuration Required Setting/a_NASA Params'))
//WebUI.click(findTestObject('Object Repository/Page_Parameters Index/a_bad_browser_blurb'))
WebUI.click(findTestObject('Object Repository/Page_Configuration NASA Params/dt_bad_browser_blurb'))*/

WebUI.waitForElementClickable(findTestObject('Page_Configuration NASA Params/dd_bad_browser_blurb_message'),15)
WebUI.scrollToElement(findTestObject('Page_Configuration NASA Params/dd_bad_browser_blurb_message'),5)
WebUI.comment 'actual bad_browser_blurb_message from '+bad_browser_blub_view+' is the following...'
bad_browser_blurb_message=WebUI.getText(findTestObject('Page_Configuration NASA Params/dd_bad_browser_blurb_message'))

if (GlobalVariable.G_MAKE_MAS_url.contains('oms')) {
	expected_message='This application does not support your browser'
}else{
	expected_message='Your browser is not supported by this system.'
}
check_message( bad_browser_blurb_message,  expected_message)

expected_message='Please use one of the following'
check_message( bad_browser_blurb_message,  expected_message)

if (!GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	expected_message='Internet Explorer'
	check_message( bad_browser_blurb_message,  expected_message)
	expected_message='Chrome'
	check_message( bad_browser_blurb_message,  expected_message)
	if (!GlobalVariable.G_MAKE_MAS_url.contains('oms') && !GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
		expected_message='images/ie.svg'
		check_message( bad_browser_blurb_message,  expected_message)
		expected_message='images/chrome.svg'
		check_message( bad_browser_blurb_message,  expected_message)
	}
	
}

expected_message='Firefox'
check_message( bad_browser_blurb_message,  expected_message)
if (!GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
	expected_message='Safari'
}
check_message( bad_browser_blurb_message,  expected_message)
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	expected_message='firefox/usage-logo.png'
	check_message( bad_browser_blurb_message,  expected_message)
	expected_message='images/safari.svg'
	check_message( bad_browser_blurb_message,  expected_message)
}else if (!GlobalVariable.G_MAKE_MAS_url.contains('oms') && !GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
	expected_message='images/firefox.svg'
	check_message( bad_browser_blurb_message,  expected_message)
	expected_message='images/safari.svg'
	check_message( bad_browser_blurb_message,  expected_message)
}

if (GlobalVariable.G_MAKE_MAS_url.contains('oms')) {
	expected_message='If you are not able to upgrade your browser, please contact the'
}else{
	expected_message='If you have an ACES machine and are not able to upgrade your browser, please contact the '
}
check_message( bad_browser_blurb_message,  expected_message)
expected_message='href="https://aces.ndc.nasa.gov/itsupport.html"'
check_message( bad_browser_blurb_message,  expected_message)
expected_message='ESD help desk'
check_message( bad_browser_blurb_message,  expected_message)
expected_message='If you believe your browser is being incorrectly blocked, please contact the '
check_message( bad_browser_blurb_message,  expected_message)
expected_message='="mailto:praca-admin@nas.nasa.gov?subject=My Browser is being blocked incorrectly'
check_message( bad_browser_blurb_message,  expected_message)

/*if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
	return
}*/
return
////////////////////////////////////////////////////////////////////
for (String supportedBrowserName : GlobalVariable.allowedBrowsers) {
	KeywordUtil.logInfo('expected supported browser - '+supportedBrowserName)
	check_message( bad_browser_blurb_message,  supportedBrowserName)
	
	/*if (bad_browser_blurb_message.contains(supportedBrowserName)){
		KeywordUtil.markPassed('bad_browser_blurb_message is OK, found supportedBrowserName: '+supportedBrowserName)
	}else{
		KeywordUtil.markFailed('bad_browser_blurb_message is wrong, NOT found supportedBrowserName: '+supportedBrowserName)
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	}*/
	
}
supportedBrowser='Safari'
WebUI.comment('according to 7.0 rollout plan, it should support Safari now')
if (!(GlobalVariable.G_MAKE_MAS_url).contains('dev')) {
	check_message( bad_browser_blurb_message,  supportedBrowser)
}

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
	return
}


return

////////////////////////////////////////////////////////////////////////////////////////////////
expected_message='Internet Explorer'
if (bad_browser_blurb_message.contains(expected_message)){
	WebUI.comment('bad_browser_blurb_message is OK, found string: '+expected_message)
}else{
	WebUI.comment('bad_browser_blurb_message is wrong, NOT found string: '+expected_message)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

expected_message='Firefox'
if (bad_browser_blurb_message.contains(expected_message)){
	WebUI.comment('bad_browser_blurb_message is OK, found string: '+expected_message)
}else{
	WebUI.comment('bad_browser_blurb_message is wrong, NOT found string: '+expected_message)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

expected_message='Safari'
if (!GlobalVariable.G_MAKE_MAS_url.contains('dev')) {
	if (bad_browser_blurb_message.contains(expected_message)){
		WebUI.comment('bad_browser_blurb_message is OK, found string: '+expected_message)
	}else{
		WebUI.comment('bad_browser_blurb_message is wrong, NOT found string: '+expected_message)
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
		//WebUI.comment('WARNING: safari may not be supported in '+GlobalVariable.G_MAKE_MAS_url)
	}
}


expected_message='Chrome'
if (bad_browser_blurb_message.contains(expected_message)){
	WebUI.comment('bad_browser_blurb_message is OK, found string: '+expected_message)
}else{
	WebUI.comment('bad_browser_blurb_message is wrong, NOT found string: '+expected_message)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

expected_message='If you have an ACES machine and are not able to upgrade your browser, please contact'
if (bad_browser_blurb_message.contains(expected_message)){
	WebUI.comment('bad_browser_blurb_message is OK, found string: '+expected_message)
}else{
	WebUI.comment('bad_browser_blurb_message is wrong, NOT found string: '+expected_message)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

//WebUI.click(findTestObject('Object Repository/Page_Configuration NASA Params/a_Home'))
/////////////////////////////////////////////////////////////////////////////
break
} catch (Exception e) {
// handle exception
e.printStackTrace()
if (++retry_count == maxTries) throw e;
WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
}
}

def check_message(String bad_browser_blurb_message, String expected_message){
	if (bad_browser_blurb_message.contains(expected_message)){
		KeywordUtil.markPassed('bad_browser_blurb_message is OK, found string: '+expected_message)
	}else{
		KeywordUtil.logInfo('Try again, NOT found string: '+expected_message)
		//expected_message='This application does not support your browser'
		if (bad_browser_blurb_message.contains(expected_message)){
			KeywordUtil.markPassed('bad_browser_blurb_message is OK, found string: '+expected_message)
		}else{
			KeywordUtil.markFailed('ERROR: bad_browser_blurb_message is wrong, \nNOT found expected string: "'+expected_message+'"\n\nplease check actual bad_browser_blurb_message below: '+bad_browser_blurb_message)
			//throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, NOT found expected string: "'+expected_message+'", please check actual bad_browser_blurb_message: '+bad_browser_blurb_message)
		}
	}
}