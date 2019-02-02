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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
analytics_site_view=siteURL+'/editparams.cgi?section=nasa#analytics_site_url_desc'


CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(analytics_site_view)

if (!WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration NASA Params/input_analytics_site_name'),5)){
	KeywordUtil.markWarning('input_analytics_site_name not found in Page_Configuration NASA Params')
	return
}
WebUI.scrollToElement(findTestObject('Object Repository/Page_Configuration NASA Params/input_analytics_site_name'),6)
analytics_site_name=WebUI.getAttribute(findTestObject('Object Repository/Page_Configuration NASA Params/input_analytics_site_name'), 'value')
if (analytics_site_name.contains('nasa.gov')){
	WebUI.comment 'if there is value "nasa.gov" in analytics_site_name='+analytics_site_name+', then continue to check the value of analytics_site_url'
	analytics_site_url=WebUI.getAttribute(findTestObject('Object Repository/Page_Configuration NASA Params/input_analytics_site_url'), 'value')
	if (siteURL.contains('raining')){
		analytics_site_url_expected='//analytics.nas.nasa.gov/piwik-dev/'
	}else{
		analytics_site_url_expected='//analytics.nas.nasa.gov/piwik/'
	}
	WebUI.verifyMatch(analytics_site_url,analytics_site_url_expected, false)
	//throw new AssertionError('ERROR: not matched analytics_site_url_expected and analytics_site_url')
	
}else{
	WebUI.comment 'Not found "nasa.gov" in analytics_site_name='+analytics_site_name+', do not need to check the value of analytics_site_url'
}



