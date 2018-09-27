if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable

if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) && !(GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss'))) {
	WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')
	GlobalVariable.userPin2 = 'SKIP'
	return null
}
if ( GlobalVariable.G_MAKE_MAS_url.contains('react_iss_hazard')){
	WebUI.comment 'Skip this testcase as react_iss_hazard may not work on attachments'
	throw new AssertionError("react_iss_hazard may not work on adding attachments. Please check it by attaching a file in a record. Found issue....You made an invalid entry.   A value must be set for the 'Attachment Type' field. ")
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

//String recordID='147'
String recordID='43778'
if ((GlobalVariable.G_MAKE_MAS_url.contains('hazard.iss'))){
	recordID='8189'
}

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=tabBasic_Information&gv=group'
WebUI.navigateToUrl(siteURL)

WebUI.scrollToElement(findTestObject('Page_Record_43778_iss_hazard/div_Attachments'),10)

if (WebUI.waitForElementVisible(findTestObject('Page_Record_43778_iss_hazard/a_ppt_icon_attachment'),3)){
	WebUI.click(findTestObject('Page_Record_43778_iss_hazard/a_ppt_icon_attachment'))
	CustomKeywords.'hci_smoke_test.common.check_defaultFile_Downloaded'(100)
}
if (WebUI.waitForElementVisible(findTestObject('Page_Record_43778_iss_hazard/a_doc_icon_attachment'),3)){
	WebUI.click(findTestObject('Page_Record_43778_iss_hazard/a_doc_icon_attachment'))
	CustomKeywords.'hci_smoke_test.common.check_defaultFile_Downloaded'(100)
}
if (WebUI.waitForElementVisible(findTestObject('Page_Record_43778_iss_hazard/a_pdf_icon_attachment'),3)){
	WebUI.click(findTestObject('Page_Record_43778_iss_hazard/a_pdf_icon_attachment'))
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(100)
}
if (WebUI.waitForElementVisible(findTestObject('Page_Record_43778_iss_hazard/a_xls_icon_attachment'),3)){
	WebUI.click(findTestObject('Page_Record_43778_iss_hazard/a_xls_icon_attachment'))
	CustomKeywords.'hci_smoke_test.common.check_defaultFile_Downloaded'(100)
}
return

////////////////////////////
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(siteURL)
selenium.click("id=attachment_table_display_0_info")

// check pdf attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s135826']/span",25)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_pdf",15)

// check doc attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s135515']/span",15)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_vnd_openxmlformats-officedocument_wordprocessingml_document",15)

// check powerpoint attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s53312']/span",15)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_vnd_ms-powerpoint",15)

//wait for 'Add More Attachments' button
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//div[@id='template_1']/span/input[@id='attachment_file_input_1']",25)
//selenium.click("//div[@id='template_1']/span/input[@id='attachment_file_input_1']")

