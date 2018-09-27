if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

/*
 * check value of daggr_server parameter from Admin->Parameters->DAggr Params
 * 
 * Steps:
 * 
 * goto Admin->Parameters->DAggr Params
 * check value of daggr_server from profile (G_dagger_server_url)
 * will skip test if G_dagger_server_url is empty
 * 
 */



//if (GlobalVariable.G_dagger_server_url.)
WebUI.comment('G_dagger_server_url='+GlobalVariable.G_dagger_server_url)
if (StringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url)){
	WebUI.comment('do not need to run this test')
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Page_Main Page/a_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Params'))

WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dt_daggr_server'))

WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dd_The URL of the DAggr server'))

value_dagger_server=WebUI.getAttribute(findTestObject('Object Repository/Page_Configuration DAggr Params/input_daggr_server'), 'value')


WebUI.comment('value of actual value_dagger_server = '+value_dagger_server)

//GlobalVariable.G_dagger_server_url='https://dig-it-dev.nas.nasa.gov/dig_it-server/services/'
//WebUI.verifyMatch(value_dagger_server, GlobalVariable.G_dagger_server_url, false)

if (!GlobalVariable.G_MAKE_MAS_url.contains('training')) {
	WebUI.verifyMatch(value_dagger_server, GlobalVariable.G_dagger_server_url, false)
	WebUI.comment('matched with expected dagger_server_url value = '+GlobalVariable.G_dagger_server_url)
}else{
	WebUI.comment 'GlobalVariable.G_dagger_server_url='+GlobalVariable.G_dagger_server_url
}
//WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/a_Home'))

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}
