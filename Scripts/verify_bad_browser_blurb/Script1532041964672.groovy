import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.safari.SafariDriver
import org.stringtemplate.v4.compiler.CodeGenerator.region_return

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
 

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Page_Main Page/a_Admin'))
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.delay(1)
	WebUI.switchToWindowIndex(1)
}
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Page_Configuration Required Setting/a_NASA Params'))

//WebUI.click(findTestObject('Object Repository/Page_Parameters Index/a_bad_browser_blurb'))

WebUI.click(findTestObject('Object Repository/Page_Configuration NASA Params/dt_bad_browser_blurb'))

bad_browser_blurb_message=WebUI.getText(findTestObject('Object Repository/Page_Configuration NASA Params/dd_The message that users will'))

string1='Your browser is not supported by this system.'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('Try again, NOT found string: '+string1)
	string1='This application does not support your browser'
	if (bad_browser_blurb_message.contains(string1)){
		println('bad_browser_blurb_message is OK, found string: '+string1)
	}else{
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	}
}

string1='Please use one of the following'
if (bad_browser_blurb_message.contains(string1)){
	println('bad_browser_blurb_message is OK, found string: '+string1)
}else{
	println('bad_browser_blurb_message is wrong, NOT found string: '+string1)
	throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
}

for (String supportedBrowserName : GlobalVariable.allowedBrowsers) {
	println('expected supported browser - '+supportedBrowserName)
	if (bad_browser_blurb_message.contains(supportedBrowserName)){
		println('bad_browser_blurb_message is OK, found supportedBrowserName: '+supportedBrowserName)
	}else{
		println('bad_browser_blurb_message is wrong, NOT found supportedBrowserName: '+supportedBrowserName)
		throw new AssertionError('ERROR: bad_browser_blurb_message is wrong, check message: '+bad_browser_blurb_message)
	}
	
}
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
}
return

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

