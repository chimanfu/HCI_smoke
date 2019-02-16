if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ? found connection reset in VMDB Linkable Field of Part Number: 100 ?
println('Only for iss_fmea: Basic FMEA tab -> VMDB Integration')

if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) && !(GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss'))) {
    WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')
    GlobalVariable.userPin2 = 'SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
    return null
}
String recordID = '8265'

String siteURL = GlobalVariable.G_MAKE_MAS_url

if (!(siteURL.endsWith('/'))) {
	siteURL = (siteURL + '/')
}

siteURL = ((siteURL + 'show_bug.cgi?id=') + recordID)
int retry_count = 0;
int maxTries = 1;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.navigateToUrl(siteURL)

//if (GlobalVariable.G_MAKE_MAS_url.contains('react')) {
if (GlobalVariable.G_MAKE_MAS_url.contains('react')||GlobalVariable.G_MAKE_MAS_url.contains('raining')||GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss')){
		
    // react code
    WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/div_Basic Information'))

    WebUI.scrollToElement(findTestObject('Page_Record_8265_react_iss_hazard/div_Hardware'), 15)

    WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/label_VMDB Linkable Fields'))

    WebUI.setText(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), '100')

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), Keys.chord(Keys.ENTER)) // old code
} else {
    WebUI.waitForElementVisible(findTestObject('Page_Record_8265_iss_hazard/div_Basic Information'), 25)

    WebUI.click(findTestObject('Page_Record_8265_iss_hazard/div_Basic Information'))

    WebUI.scrollToElement(findTestObject('Page_Record_8265_iss_hazard/label_Part Number'), 3)

    WebUI.click(findTestObject('Page_Record_8265_iss_hazard/label_Part Number'))

    WebUI.setText(findTestObject('Page_Record_8265_iss_hazard/input_cf_rh_part_number_0'), '100')

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('Page_Record_8265_iss_hazard/input_cf_rh_part_number_0'), Keys.chord(Keys.ENTER))

    WebUI.waitForElementVisible(findTestObject('Page_Record_8265_iss_hazard/div_VMDB search results'), 30)
	WebUI.delay(1)
    WebUI.click(findTestObject('Page_Record_8265_iss_hazard/div_VMDB search results'))
}
//'click on create link button'
//WebUI.click(findTestObject('Page_Record_256_mcard/button_Create Link'))
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_contents/button_Create Link'),10)){
	//WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/img_Create_Link_button'))
	WebUI.click(findTestObject('Object Repository/Page_Record_contents/button_Create Link'))
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	return
}
// check VMDB errors
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/errorMsg_sqlQuerySQLParser'), 
    1)) {
    KeywordUtil.markFailedAndStop('ERROR: found error message -> sqlQuery:SQLParser.parse: malformed sql')
    throw new AssertionError('ERROR: found error message -> sqlQuery:SQLParser.parse: malformed sql')
}

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_8265_iss_hazard/span_Connection reset'), 1)) {
    KeywordUtil.markWarning('Warning: found Connection reset from search result')
    //throw new AssertionError('ERROR: found Connection reset from search result')
	return
	
}

if (WebUI.waitForElementVisible(findTestObject('Page_Record_2769_FMEA/div_error_DAGGR_server_not_configured'), 1)) {
    KeywordUtil.markFailedAndStop('ERROR: DAGGR_server_not_configured')
    throw new AssertionError('ERROR: DAGGR_server_not_configured')
}


CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	//Runtime.getRuntime().exec(cmd)
	
}
}