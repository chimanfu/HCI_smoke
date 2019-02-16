if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

//if (GlobalVariable.G_dagger_server_url.)
println('G_dagger_server_url='+GlobalVariable.G_dagger_server_url)
if (StringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url)){
	println('do not need to run this test')
	WebUI.comment 'Skip this testcase as no dagger server defined for this site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
	return
}
String siteURL
int retry_count = 0;
int maxTries = 2;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()


if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
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
}
//WebUI.click(findTestObject('Page_Main Page/a_Admin'))
WebUI.waitForElementClickable(findTestObject('Page_Administer your installation/a_Parameters'),10)
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))
// checking daggr linking parameters

if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Linking Params'),4,FailureHandling.OPTIONAL)){
	println('not found a_DAggr Linking Params, skip the test')
	return
}
WebUI.scrollToElement(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Linking Params'),10)
WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Linking Params'))

// check daggr_linking_user
WebUI.waitForElementVisible(findTestObject('Page_Configuration DAggr Linking Params/dd_The DAggr user who will be'),5)
expected_value_daggr_linking_user='mas_vmdb'
println('check daggr_linking_user value from daggr_linking_user parameter')
value_daggr_linking_user=WebUI.getAttribute(findTestObject('Page_Configuration DAggr Linking Params/input_daggr_linking_user'), 'value')
println('actual value of permittedBrowsers = '+value_daggr_linking_user)
WebUI.verifyMatch(value_daggr_linking_user, expected_value_daggr_linking_user, false)
println('matched with expected permittedBrowsers value = '+expected_value_daggr_linking_user)

// check daggr_linking_enabled
WebUI.waitForElementVisible(findTestObject('Page_Configuration DAggr Linking Params/dt_daggr_linking_enabled'),1)
WebUI.waitForElementVisible(findTestObject('Page_Configuration DAggr Linking Params/input_daggr_linking_enabled'),1)

// check daggr_create_update_link_disabled
WebUI.waitForElementVisible(findTestObject('Page_Configuration DAggr Linking Params/input_daggr_create_update_link_disabled'),1)

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	//Runtime.getRuntime().exec(cmd)
	
}
}

