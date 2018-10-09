if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * Only for ISS OCAD, Check linked controls widget (using record 123001)
 * 
 */

// login to ocad and access record #123001
// check Linked ISS Hazard Controls on the record
// check ISS Hazard Controls status
// select on CTRL ID: Ctl-8 from the record
// open a new tab on record #27228 from iss_hazard (will ask for login)
// select OCAD #123001
// open a new tab on record 123001 from ocad
// verify for record #123001 exists for OCAD 

if (!GlobalVariable.G_MAKE_MAS_url.contains('ocad')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}

String siteURL
int retry_count = 0;
int maxTries = 2;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()
if (GlobalVariable.G_MAKE_MAS_url.contains('training')){
	recordID='124368'
	WebUI.comment 'for training site, will use recordID:'+recordID
}else{
	 recordID='123001'
	 WebUI.comment 'for production site, will use recordID:'+recordID
}

siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Information%20%26%20Evaluation'
WebUI.navigateToUrl(siteURL)
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/ocad_dev/show_bug.cgi?id=123001#tv=Information%20%26%20Evaluation')

// login to ocad and access record 123001
// check Linked ISS Hazard Controls
WebUI.waitForElementVisible(findTestObject('Page_Record_123001_General/div_Linked ISS Hazard Controls'),25)
WebUI.click(findTestObject('Page_Record_123001_General/div_Linked ISS Hazard Controls'))


// check ISS Hazard Controls: 1
WebUI.waitForElementVisible(findTestObject('Page_Record_123001_General/span_ISS Hazard Controls 1'),25)
WebUI.click(findTestObject('Page_Record_123001_General/span_ISS Hazard Controls 1'))


// select on CTRL ID: Ctl-8 from ocad
WebUI.click(findTestObject('Page_Record_123001_General/a_Ctl-8'))

// open a new tab on record 27228 from iss_hazard
WebUI.delay(3)
WebUI.switchToWindowIndex(1)

// take care the login page from iss_hazard
if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),5,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Page_Login/input_login_btn'))
}
// select OCAD #123001 or #124368

if (recordID=='123001'){
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_27228_iss_hazard/a_OCAD 123001'),20)
	WebUI.click(findTestObject('Object Repository/Page_Record_27228_iss_hazard/a_OCAD 123001'))
}else if (recordID=='124368'){
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_27228_iss_hazard/a_OCAD 124368'),20)
	WebUI.click(findTestObject('Object Repository/Page_Record_27228_iss_hazard/a_OCAD 124368'))
}


// open a new tab on record 123001 from ocad
WebUI.delay(3)
WebUI.switchToWindowIndex(2)
// wait for record exists for OCAD #123001
WebUI.waitForElementVisible(findTestObject('Page_Record_123001_General/strong_OCAD_Record_number_title'),30)


WebUI.switchToWindowIndex(0)
WebUI.closeWindowIndex(2)
WebUI.closeWindowIndex(1)
/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}