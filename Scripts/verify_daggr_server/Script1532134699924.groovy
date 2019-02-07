if (GlobalVariable.testrun_status.equals('SKIP')) return
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

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
daggrvmdb_params_view=siteURL+'/editparams.cgi?section=daggrvmdb'

// from 7.0 rollout plan 
// https://docs.google.com/spreadsheets/d/1Y-aObiFf3VOppDvePzLnLsVXcxFN6EpnKlqsQHH03AY/edit#gid=1530393706
// https://docs.google.com/spreadsheets/d/1u-ohOXLdBl8p1QdTVoAGBiLad9Z3KA1QNH1rnIR55PE/edit#gid=0
Production_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server/services/'
Training_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-training/services/'

//https://fmea.iss.nasa.gov
https://mas.nasa.gov/ARC-PRACA/editparams.cgi?section=daggrvmdb
if (siteURL.contains('fmea.iss')||siteURL.contains('ocad.iss')){
	Production_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-vmdb/services/'
	Training_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-training-vmdb/services/'
}
if (siteURL.contains('part.iss')
	||siteURL.contains('hazard.iss')
	||siteURL.contains('ocad')
	||siteURL.contains('react_iss_hazard')){
	Production_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-vmdb/services/'
	Training_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-vmdb-training/services/'
}
if (siteURL.contains('react_iss_hazard')){
	Production_site_dagger_server= 'https://dig-it-dev.nas.nasa.gov/dig_it-server-vmdb/services/'
	//Training_site_dagger_server= 'https://cptrace.nasa.gov/dig_it-server-vmdb-training/services/'
}


WebUI.comment('G_dagger_server_url='+GlobalVariable.G_dagger_server_url)
if (StringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url)){
	WebUI.comment('do not need to run this test as daggr_server parameter is empty in Admin page so the site has no daggr_server integration')
	WebUI.comment 'check daggrvmdb_params_view'+daggrvmdb_params_view
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
	return
}

daggr_server_view=siteURL+'/editparams.cgi?section=daggrvmdb#daggr_server_desc'

int retry_count = 0;
int maxTries = 2;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

/*CustomKeywords.'helper.login.LoginHelper.login'()

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
WebUI.waitForElementClickable(findTestObject('Page_Administer your installation/a_Parameters'),6)
WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))
WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Params'))
WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dt_daggr_server'))
WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dd_The URL of the DAggr server'))*/

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(daggr_server_view)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration DAggr Params/input_daggr_server'), 15)
value_dagger_server=WebUI.getAttribute(findTestObject('Object Repository/Page_Configuration DAggr Params/input_daggr_server'), 'value')

WebUI.comment('value of actual value_dagger_server = '+value_dagger_server)
WebUI.comment 'check daggrvmdb_params_view'+daggrvmdb_params_view
if ((siteURL.contains('MAKE-MAS')) && (siteURL.contains('dev')) && (!siteURL.contains('react_iss_hazard'))) {
	WebUI.comment 'this is a dev site, most likey using GlobalVariable.G_dagger_server_url: '+GlobalVariable.G_dagger_server_url
	WebUI.verifyMatch(value_dagger_server, GlobalVariable.G_dagger_server_url, false)
	//WebUI.comment 'matched with actual dagger_server_url value = '+value_dagger_server
}else{
	if (!GlobalVariable.G_MAKE_MAS_url.contains('raining')) {
		WebUI.comment 'this is a production site, most likey using: '+Production_site_dagger_server
		WebUI.verifyMatch(value_dagger_server, Production_site_dagger_server, false)
		//WebUI.comment 'matched with actual dagger_server_url value = '+value_dagger_server
	}else{
		WebUI.comment 'this is a training site, most likey using: '+Training_site_dagger_server
		WebUI.verifyMatch(value_dagger_server, Training_site_dagger_server, false)
		//WebUI.comment 'matched with actual dagger_server_url value ='+value_dagger_server
	}
}
WebUI.comment 'PASS: matched with actual dagger_server_url value = '+value_dagger_server
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
