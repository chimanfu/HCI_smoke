if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'do a advanced search on SLS Integrated Cause'
'from the search list of records, select the first record to open and verify'
'open the Verifications Tab'
if (!(GlobalVariable.G_MAKE_MAS_url.contains('cp_hazard')) &&  !(GlobalVariable.G_MAKE_MAS_url.contains('cxhazard'))) {
	WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')
	GlobalVariable.userPin2 = 'SKIP'
	return null
}

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


CustomKeywords.'helper.login.LoginHelper.login'()

println('advanced search on SLS Integrated Cause')
WebUI.click(findTestObject('Page_Search for records/a_Advanced Search'))
WebUI.click(findTestObject('Page_Search for records/select_product_SLS Integrated Cause'))
WebUI.click(findTestObject('Page_Search for records/input_Search'))

println 'from the search list, select the first record to open and verify'
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record List/a_record_1'),25)
WebUI.click(findTestObject('Object Repository/Page_Record List/a_record_1'))

println 'open the Verifications Tab'
WebUI.waitForElementClickable(findTestObject('Page_Record_1_SLS Integrated_Causes/div_Verifications'),10)
WebUI.click(findTestObject('Page_Record_1_SLS Integrated_Causes/div_Verifications'))
WebUI.delay(2)

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}