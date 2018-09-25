import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

println('Only for iss_fmea: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_fmea')  &&  !GlobalVariable.G_MAKE_MAS_url.contains('fmea.iss')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 2769')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_fmea_dev/show_bug.cgi?id=2769#tv=Basic%20FMEA')
String recordID='2769'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Basic%20FMEA'
WebUI.navigateToUrl(siteURL)

println('from the Basic FMEA Tab')
WebUI.verifyElementPresent(findTestObject('Page_Record_2769_FMEA/div_Basic FMEA'),25)
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_Basic FMEA'))


WebUI.maximizeWindow()
if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Cause - Record 6505  Erroneous/div_The linked fields note'),5)){
	WebUI.comment 'already have a VMDB linked record'
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	return
}
WebUI.scrollToElement(findTestObject('Page_Record_2769_FMEA/span_VMDB Linkable Fields'), 3)

println('verify VMDB Linkable Fields')
WebUI.verifyElementPresent(findTestObject('Page_Record_2769_FMEA/span_VMDB Linkable Fields'),10)
WebUI.delay(1)

println('click on ORU Part Number field to open up search')
WebUI.click(findTestObject('Page_Record_2769_FMEA/input_cf_oruassemblynum'))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input_cf_oruassemblynum'), Keys.chord(Keys.ENTER))
println('check Current Dataset search result')
WebUI.verifyElementPresent(findTestObject('Page_Record_2769_FMEA/span_Current Dataset search result'),30)

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

