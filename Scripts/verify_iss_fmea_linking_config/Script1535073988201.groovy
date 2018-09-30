if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


println('Only for iss_fmea: select Attachments & References tab -> create link')

if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_fmea')  &&  !GlobalVariable.G_MAKE_MAS_url.contains('fmea.iss')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}
int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


searchTerm='link'
CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 2769 -> Attachments & References Tab')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_fmea_dev/show_bug.cgi?id=2769#tv=Attachments%20%26%20References')

String recordID='2769'
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'

if (!GlobalVariable.G_MAKE_MAS_url.contains('dev')) {
	siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabAttachments___References&gv=group'
}else{
	siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Attachments%20%26%20References'
}
WebUI.navigateToUrl(siteURL)
WebUI.maximizeWindow()

if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_2769_FMEA/input_for_uber_search_field'),5)){
	WebUI.comment 'found input_for_uber_search_field'
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_2769_FMEA/input_for_uber_search_field'),5)
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Page_Record_2769_FMEA/input_for_uber_search_field'), 'link')
	WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input_for_uber_search_field'), Keys.chord(Keys.ENTER))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_2769_FMEA/div_Search Results'),10)
	WebUI.delay(1)
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	return
}
if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Cause - Record 6505  Erroneous/div_The linked fields note'),1)){
	WebUI.comment 'already have a VMDB linked record'
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	return
}


WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/label_Create link'), 25)
WebUI.scrollToElement(findTestObject('Page_Record_2769_FMEA/label_Create link'), 25)

println('get the create link field and get ready to search content')
WebUI.click(findTestObject('Page_Record_2769_FMEA/label_Create link'))
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_Search content...'))

println('enter the search term: '+searchTerm)
WebUI.setText(findTestObject('Page_Record_2769_FMEA/input'), searchTerm)
WebUI.delay(2)
println('get the first record')
WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input'), Keys.chord(Keys.ENTER))
WebUI.delay(5)
println('verify first record exist')
if (!WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/div_record_1'),12))
	WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

println('try out the trash link icon on/off')
WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/div_trash'),12)
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_trash'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_trash'))

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