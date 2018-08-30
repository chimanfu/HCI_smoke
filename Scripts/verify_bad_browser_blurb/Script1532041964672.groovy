if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*
 
 check key message and permitted browsers info of bad_browser_blurb parameter in Admin->NASA Params->bad_browser_blurb
 
 Steps:
 
 goto Admin->NASA Params->bad_browser_blurb
 check bad_browser_blurb parameter with correct message for supporting browsers if running on unsupported browser
 check 2 key messages showing in the html message
	 string1='Your browser is not supported by this system.'
	 or
	 string1='This application does not support your browser'
	 and
	 string1='Please use one of the following'
 check with profile->GlobalVariable.allowedBrowsers for supported browser names from bad_browser_blurb message 
 should support browsers mentioned in the list of GlobalVariable.allowedBrowsers
 how about Edge?
 */
 


int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'),25)
WebUI.click(findTestObject('Page_Main Page/a_Admin'))
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.delay(1)
	WebUI.switchToWindowIndex(1)
}
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'),10)
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Page_Configuration Required Setting/a_NASA Params'))

//WebUI.click(findTestObject('Object Repository/Page_Parameters Index/a_bad_browser_blurb'))

WebUI.click(findTestObject('Object Repository/Page_Configuration NASA Params/dt_bad_browser_blurb'))

bad_browser_blurb_message=WebUI.getText(findTestObject('Object Repository/Page_Configuration NASA Params/dd_The message that users will'))

string1='Your browser is not supported by this system.'
if (bad_browser_blurb_message.contains(string1)){
	KeywordUtil.markPassed('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	KeywordUtil.logInfo('Try again, NOT found string: '+string1)
	string1='This application does not support your browser'
	if (bad_browser_blurb_message.contains(string1)){
		KeywordUtil.markPassed('bad_browser_blurb_message is OK, found string: '+string1)
	}else{
		KeywordUtil.markFailed('bad_browser_blurb_message is wrong, NOT found string: '+string1)
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	}
}

string1='Please use one of the following'
if (bad_browser_blurb_message.contains(string1)){
	KeywordUtil.markPassed('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	KeywordUtil.markFailed('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

for (String supportedBrowserName : GlobalVariable.allowedBrowsers) {
	KeywordUtil.logInfo('expected supported browser - '+supportedBrowserName)
	if (bad_browser_blurb_message.contains(supportedBrowserName)){
		KeywordUtil.markPassed('bad_browser_blurb_message is OK, found supportedBrowserName: '+supportedBrowserName)
	}else{
		KeywordUtil.markFailed('bad_browser_blurb_message is wrong, NOT found supportedBrowserName: '+supportedBrowserName)
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	}
	
}
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
}
return

////////////////////////////////////////////////////////////////////////////////////////////////
string1='Internet Explorer'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

string1='Firefox'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

string1='Safari'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	//throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	println('WARNING: safari may not be supported in '+GlobalVariable.G_MAKE_MAS_url)
}

string1='Chrome'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

string1='If you have an ACES machine and are not able to upgrade your browser, please contact'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

//WebUI.click(findTestObject('Object Repository/Page_Configuration NASA Params/a_Home'))
/////////////////////////////////////////////////////////////////////////////
break
} catch (Exception e) {
// handle exception
e.printStackTrace()
if (++retry_count == maxTries) throw e;
println('Retry:'+retry_count+' rerun failed case now...')
}
}
