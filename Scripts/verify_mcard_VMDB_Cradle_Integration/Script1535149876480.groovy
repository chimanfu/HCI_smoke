if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

if (!(GlobalVariable.G_MAKE_MAS_url.contains('mcard'))) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}
int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 256 -> Verification tab from search: Monitored Condition record type')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/mcard_dev/show_bug.cgi?id=256#tv=Verification')

recordID='256'
siteURL=GlobalVariable.G_MAKE_MAS_url
//baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Verification'
// goto recordID and Verifications TAB
WebUI.navigateToUrl(siteURL)

println 'select Verification Tab'
WebUI.waitForElementClickable(findTestObject('Page_Record_256_mcard/div_Verification'),25)
WebUI.click(findTestObject('Page_Record_256_mcard/div_Verification'))

println 'wait for SLS Cradle Linkable Field'
WebUI.waitForElementClickable(findTestObject('Page_Record_256_mcard/span_SLS Cradle Linkable Field'),10)
WebUI.click(findTestObject('Page_Record_256_mcard/span_SLS Cradle Linkable Field'))

println 'enter dvo_number 100 from search field of Applicable DVO'
WebUI.click(findTestObject('Page_Record_256_mcard/label_Applicable DVO'))
WebUI.setText(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), '100')
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), Keys.chord(Keys.ENTER))

println 'verify SLS Cradle search results'
WebUI.waitForElementVisible(findTestObject('Page_Record_256_mcard/span_SLS Cradle search results'),10)
WebUI.click(findTestObject('Page_Record_256_mcard/span_SLS Cradle search results'))

'click on create link button'
WebUI.click(findTestObject('Page_Record_256_mcard/button_Create Link'))

'verify the record is linked and can be edited'
WebUI.click(findTestObject('Page_Record_256_mcard/button_Linked'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Record_256_mcard/a_Edit'))
WebUI.delay(1)
WebUI.setText(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), '')

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}

