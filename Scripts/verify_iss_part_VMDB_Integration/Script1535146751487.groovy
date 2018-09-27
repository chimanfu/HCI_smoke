if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

println('Only for iss_part: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_part') && !GlobalVariable.G_MAKE_MAS_url.contains('part.iss')) {
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

println('directly go to record 7168 which has VMDB integration')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_part_dev/show_bug.cgi?id=7168')
recordID='7168'
siteURL=GlobalVariable.G_MAKE_MAS_url
baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID
// goto recordID
WebUI.navigateToUrl(siteURL)

println 'verify VMDB Linkable Fields'
WebUI.waitForElementVisible(findTestObject('Page_Record_7168_PRACA/span_VMDB Linkable Fields'),10)
WebUI.click(findTestObject('Page_Record_7168_PRACA/span_VMDB Linkable Fields'))

println 'do a quick search on the part number 1F28980'
WebUI.click(findTestObject('Page_Record_7168_PRACA/input_cf_partnumber'))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_Record_7168_PRACA/input_cf_partnumber'), Keys.chord(Keys.ENTER))


println('search list displayed and click on the create link button')
WebUI.waitForElementVisible(findTestObject('Page_Record_7168_PRACA/img_create_23971972'),10)
WebUI.click(findTestObject('Page_Record_7168_PRACA/img_create_23971972'))


println("verify create link is working and showing linking status")
WebUI.waitForElementPresent(findTestObject('Page_Record_7168_PRACA/img_img_cf_partnumber'),5)


/*WebUI.waitForElementPresent(findTestObject('Page_Record_7168_PRACA/div_View part in VMDB'),5)
WebUI.waitForElementPresent(findTestObject('Page_Record_7168_PRACA/div_View drawing in VMDB'),5)*/

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
