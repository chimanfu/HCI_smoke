import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// ? found connection reset in VMDB Linkable Field of Part Number: 100 ?

println('Only for iss_fmea: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()
String recordID='8265'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID
WebUI.navigateToUrl(siteURL)

if ( GlobalVariable.G_MAKE_MAS_url.contains('react')){
	// react code
	WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/div_Basic Information'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_8265_react_iss_hazard/div_Hardware'),15)
	
	WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/label_VMDB Linkable Fields'))
	
	WebUI.setText(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), '100')
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), Keys.chord(
			Keys.ENTER))
	
	
}else{
	// old code
	WebUI.waitForElementVisible(findTestObject('Page_Record_8265_iss_hazard/div_Basic Information'),25)
	
	WebUI.click(findTestObject('Page_Record_8265_iss_hazard/div_Basic Information'))
	
	WebUI.scrollToElement(findTestObject('Page_Record_8265_iss_hazard/label_Part Number'), 3)
	
	WebUI.click(findTestObject('Page_Record_8265_iss_hazard/label_Part Number'))
	
	WebUI.setText(findTestObject('Page_Record_8265_iss_hazard/input_cf_rh_part_number_0'), '100')
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('Page_Record_8265_iss_hazard/input_cf_rh_part_number_0'), Keys.chord(
	        Keys.ENTER))
	
	WebUI.waitForElementVisible(findTestObject('Page_Record_8265_iss_hazard/div_VMDB search results'),15)
	WebUI.click(findTestObject('Page_Record_8265_iss_hazard/div_VMDB search results'))

}
// check VMDB errors
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/errorMsg_sqlQuerySQLParser'),2)){
	KeywordUtil.markFailedAndStop("ERROR: found error message -> sqlQuery:SQLParser.parse: malformed sql")
	throw new AssertionError('ERROR: found error message -> sqlQuery:SQLParser.parse: malformed sql')
}
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_8265_iss_hazard/span_Connection reset'),1)){
	KeywordUtil.markFailedAndStop("ERROR: found Connection reset from search result")
	throw new AssertionError('ERROR: found Connection reset from search result')
}
if (WebUI.waitForElementVisible(findTestObject('Page_Record_2769_FMEA/div_error_DAGGR_server_not_configured'),1)){
	KeywordUtil.markFailedAndStop("ERROR: DAGGR_server_not_configured")
	throw new AssertionError('ERROR: DAGGR_server_not_configured')
}

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
