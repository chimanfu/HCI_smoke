import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'helper.login.LoginHelper.login'()

selection='DMM'
//selection='DVO'
//selection='LCC'
//selection='OMRS'
String recordID='6505'
String siteURL=GlobalVariable.G_MAKE_MAS_url
baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabVerifications&gv=group'

// goto recordID='6505' and Verifications TAB
WebUI.navigateToUrl(siteURL)
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/div_Verifications'))


// select the first entry of VERIF from the list
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/span_VERIF_first_item_1'),20)

WebUI.click(findTestObject('Page_Record_6505_cp_hazard/span_VERIF_first_item_1'))

////////

// select Verification Traceability Type
WebUI.scrollToElement(findTestObject('Page_Record_6505_cp_hazard/label_Verification Traceability Type'),20)

WebUI.selectOptionByValue(findTestObject('Page_Record_6505_cp_hazard/select_Verification Traceability Type'), 
    selection, true)

//////
// enter search term and then create link on the first match
if (!WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),2)){
	// only if it is not already linked
	WebUI.setText(findTestObject('Page_Record_6505_cp_hazard/input_cf_number_field'), 'Transmission')
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('Page_Record_6505_cp_hazard/input_cf_number_field'), Keys.chord(
	        Keys.ENTER))
	
	WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'),40)
	WebUI.click(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),10)
}
////////////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()



if (GlobalVariable.G_MAKE_MAS_url.contains('react')){
	selection='DMM'
	//selection='DVO'
	//selection='LCC'
	//selection='OMRS'
	String recordID='6505'
	String siteURL=GlobalVariable.G_MAKE_MAS_url
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