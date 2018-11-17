if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * verify value of the permittedBrowsers parameter from Admin->Administrative Policies with the expected value in site profile
 * 
 * Steps:
 * 
 * goto Admin link from Home page
 * select Parameters link
 * select Administrative Policies link
 * select permittedBrowsers parameter
 * verify message
 * verify actual value of permittedBrowsers with GlobalVariable.G_permitted_browser
 */
// 7.0 rollout plan
// https://docs.google.com/spreadsheets/d/1Y-aObiFf3VOppDvePzLnLsVXcxFN6EpnKlqsQHH03AY/edit#gid=1590469616
// default:   Firefox/(?![123456789]\.)|Trident/[78]|Chrome|Safari
// etasksheet: Firefox/(?![123456789]\.)|Safari   ?

/*CustomKeywords.'helper.login.LoginHelper.login'()
if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	String siteURL=GlobalVariable.G_MAKE_MAS_url
	if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'admin.cgi')
}else{
	WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'), 60)
	WebUI.click(findTestObject('Page_Main Page/a_Admin'))
	if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
	}
}
WebUI.waitForElementClickable(findTestObject('Page_Administer your installation/a_Parameters'),6)
WebUI.click(findTestObject('Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_Administrative Policies'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Configuration Administrative Policies/dd_The browsers that this system support'),15)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration Administrative Policies/dt_permittedBrowsers'),10)
WebUI.click(findTestObject('Object Repository/Page_Configuration Administrative Policies/dt_permittedBrowsers'))
WebUI.waitForElementVisible(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'),10)*/

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
permittedBrowsers_view=siteURL+'/editparams.cgi?section=admin#permittedBrowsers_desc'
CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(permittedBrowsers_view)

WebUI.waitForElementClickable(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'),15)
WebUI.scrollToElement(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'),5)
WebUI.click(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'))

WebUI.comment('check permittedBrowsers value from permittedBrowsers parameter')
value_permittedBrowsers=WebUI.getAttribute(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'), 'value')
WebUI.comment('actual value of permittedBrowsers = '+value_permittedBrowsers)

// 7.0 rollout value
String expected_value_permittedBrowsers='Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari'
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	expected_value_permittedBrowsers='Firefox/(?![123456789]\\.)|Safari'
}
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
	expected_value_permittedBrowsers='Firefox/(?![123456789]\\.)|MSIE 9|Trident/[567]|Chrome'
}

if (GlobalVariable.G_MAKE_MAS_url.contains('raining') || (!GlobalVariable.G_MAKE_MAS_url.contains('dev'))) {
	WebUI.verifyMatch(value_permittedBrowsers, expected_value_permittedBrowsers, false)
	WebUI.comment('matched with expected permittedBrowsers value = '+expected_value_permittedBrowsers)
	return
}
if (!GlobalVariable.G_MAKE_MAS_url.contains('training')) {
	WebUI.verifyMatch(value_permittedBrowsers, GlobalVariable.G_permitted_browser, false)
	WebUI.comment('matched with expected permittedBrowsers value = '+GlobalVariable.G_permitted_browser)
}else{
	WebUI.comment 'GlobalVariable.G_permitted_browser='+GlobalVariable.G_permitted_browser
}

/*if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
}*/

