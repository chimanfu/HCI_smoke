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

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Page_Main Page/a_Admin'))
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.delay(1)
	WebUI.switchToWindowIndex(1)
}
WebUI.click(findTestObject('Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_Administrative Policies'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Configuration Administrative Policies/dd_The browsers that this system support'),15)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration Administrative Policies/dt_permittedBrowsers'),10)
WebUI.click(findTestObject('Object Repository/Page_Configuration Administrative Policies/dt_permittedBrowsers'))
WebUI.waitForElementVisible(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'),10)
WebUI.scrollToElement(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'),10)
WebUI.click(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'))

WebUI.comment('check permittedBrowsers value from permittedBrowsers parameter')
value_permittedBrowsers=WebUI.getAttribute(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'), 'value')
WebUI.comment('actual value of permittedBrowsers = '+value_permittedBrowsers)

if (!GlobalVariable.G_MAKE_MAS_url.contains('training')) {
	WebUI.verifyMatch(value_permittedBrowsers, GlobalVariable.G_permitted_browser, false)
	WebUI.comment('matched with expected permittedBrowsers value = '+GlobalVariable.G_permitted_browser)
}else{
	WebUI.comment 'GlobalVariable.G_permitted_browser='+GlobalVariable.G_permitted_browser
}

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.switchToWindowIndex(1)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
}

