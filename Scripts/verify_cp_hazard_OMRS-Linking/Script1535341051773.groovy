if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable

println 'only run on cp_hazard'
println 'directly goto existing record 6505->Verifications Tab'
println 'select VERIF49'
println 'from Verification Traceability Type:, select OMRS'
println 'enter Transmission as the OMRS number to searh, get the search results'
println 'verify search result of linking works'
println 'takingScreenshot and exit the current state and reload page after popup'

if (!(GlobalVariable.G_MAKE_MAS_url.contains('cp_hazard')) &&  !(GlobalVariable.G_MAKE_MAS_url.contains('cxhazard'))) {
	WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')
	GlobalVariable.userPin2 = 'SKIP'
	CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
	return null
}
WebDriver driver
//def driver = DriverFactory.getWebDriver()
//Screen s = new Screen()
WebDriverBackedSelenium selenium
int retry_count = 0;
int maxTries = 2;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


CustomKeywords.'helper.login.LoginHelper.login'()
if (GlobalVariable.G_MAKE_MAS_url.contains('react')||GlobalVariable.G_MAKE_MAS_url.contains('training')||GlobalVariable.G_MAKE_MAS_url.contains('cxhazard')){

	//selection='DMM'
	//selection='DVO'
	//selection='LCC'
	selection='OMRS'
	 recordID='6505'
	 siteURL=GlobalVariable.G_MAKE_MAS_url
	baseUrl=siteURL
	if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
	siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabVerifications&gv=group'
	
	// goto recordID='6505' and Verifications TAB
	WebUI.navigateToUrl(siteURL)
	WebUI.click(findTestObject('Page_Record_6505_cp_hazard/div_Verifications'))
	
	
	// select the first entry of VERIF from the list
	WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/span_VERIF_first_item_1'),20)
	WebUI.click(findTestObject('Page_Record_6505_cp_hazard/span_VERIF_first_item_1'))
	
	
	// select Verification Traceability Type
	WebUI.scrollToElement(findTestObject('Page_Record_6505_cp_hazard/label_Verification Traceability Type'),20)
	WebUI.selectOptionByValue(findTestObject('Page_Record_6505_cp_hazard/select_Verification Traceability Type'), selection, true)
	
	// enter search term and then create link on the first match
	if (!WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),2)){
		// only if it is not already linked
		WebUI.setText(findTestObject('Page_Record_6505_cp_hazard/input_cf_number_field'), 'Transmission')
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Page_Record_6505_cp_hazard/input_cf_number_field'), Keys.chord(Keys.ENTER))
		WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'),40)
		WebUI.click(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'))
		WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),10)
	}
	
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	return
	
}


/////////////////////////
// get record 6505->Verifications->VERIF49
 baseUrl = "https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group"
//WebUI.navigateToUrl(baseUrl)
 driver = DriverFactory.getWebDriver()
//def driver = DriverFactory.getWebDriver()
//Screen s = new Screen()
// selenium = new WebDriverBackedSelenium(driver,baseUrl)

//*[@id="cfgr_Verifications_list_item_1929070"]

 verification_id='1935140' //from VERIF49 on record 6505
 recordID='6505'
 siteURL=GlobalVariable.G_MAKE_MAS_url
baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabVerifications&gv=group'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(siteURL)

//selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group")

 verifiedRecord="//*[@id='cfgr_Verifications_row_"+verification_id+"_collapsed_display_area_content_title']/span"
verifiedRecord="//*[@id='collapsedSpan_"+verification_id+"' or @id='cfgr_Verifications_row_"+verification_id+"_collapsed']"
// verifiedRecord="//span[@id='cf_omrs_daggr_1935140_link_image_on']/img"
waifForElement(verifiedRecord,160)
WebUI.delay(10)
selenium.click(verifiedRecord)

waifForElement("id=cf_verification_traceability_"+verification_id,60)
WebUI.delay(1)
WebUI.scrollToElement(findTestObject('Page_Record_6505 Erroneous Transmiss/label_Verification Traceabilit'), 3)

selenium.click("id=cf_verification_traceability_"+verification_id)
selenium.select("id=cf_verification_traceability_"+verification_id, "label=OMRS")
if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Cause - Record 6505  Erroneous/div_The linked fields note'),5)){
	WebUI.comment 'already have a OMRS linked record'
}else{
waifForElement("id=cf_omrs_number_"+verification_id,10)
selenium.click("id=cf_omrs_number_"+verification_id)
selenium.type("id=cf_omrs_number_"+verification_id, "Transmission")
WebUI.delay(2)
//s.type(Key.ENTER)
selenium.typeKeys("id=cf_omrs_number_"+verification_id, Keys.chord(Keys.ENTER))
selenium.waitForPageToLoad("60000")
waifForElement('id=daggr_title_search', 35)
selenium.click("id=daggr_title_search")
WebUI.delay(2)
// create link on first record and verify
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/div_search results title'))
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/img_create_recordLink'),10)
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/img_create_recordLink'))
waifForElement('id=img_cf_omrs_number_'+verification_id, 25)
WebUI.delay(2)
}
CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
return
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	 cmd = "pkill -f Chrome"
	//Runtime.getRuntime().exec(cmd)
	
}
}
def waifForElement(String xpath, int inSeconds){
	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
	for (int second = 0;; second++) {
		if (second >= inSeconds) fail("timeout");
		try { if (selenium.isElementPresent(xpath)&&selenium.isVisible(xpath)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
}
