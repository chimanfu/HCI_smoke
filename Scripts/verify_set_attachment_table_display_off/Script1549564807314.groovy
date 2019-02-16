if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling as FailureHandling

/*
 * verify if attachment_table_display parameter is set to OFF from Admin->Attachments,
 * then the table display for attachments should be disabled in record
 * 
 * Steps:
 * 
 * goto Admin link from Home page
 * select Admin->Attachments
 * set attachment_table_display to OFF
 * create a record
 * add a new attachment
 * verify he table display for attachments should be disabled in record
 */

// check site is OK to run test
String siteURL=WebUI.getUrl()
if ((siteURL.contains('raining') || (siteURL.contains('dev'))) && (siteURL.contains('hazard'))) {
	WebUI.comment('OK to continue this test on hazard site')
}else return

siteURL=GlobalVariable.G_MAKE_MAS_url
if ((siteURL.contains('raining') || (siteURL.contains('dev'))) && (siteURL.contains('hazard'))) {	
	WebUI.comment('OK to continue this test on hazard site')	
}else return

WebUI.comment('this test will only run on site that is either training or dev and the site is hazard')

// directly goto attachment#attachment_table_display_desc link
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
attachment_table_display_view=siteURL+'/editparams.cgi?section=attachment#attachment_table_display_desc'
CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(attachment_table_display_view)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration Attachments/dt_attachment_table_display'),15)
WebUI.scrollToElement(findTestObject('Object Repository/Page_Configuration Attachments/dt_attachment_table_display'),15)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration Attachments/input_attachment_table_display-off'),5)

//WebUI.comment('check current value from attachment_table_display parameter')
//value_attachment_table_display=WebUI.getAttribute(findTestObject('Page_Configuration Attachments/input_attachment_table_display-off'), 'value')
//WebUI.comment('current value of attachment_table_display = '+value_attachment_table_display)

// attachment_table_display default should be ON, 
// check the current setting is OFF in attachment_table_display-off radio button (not checked)
if (WebUI.verifyElementNotChecked(findTestObject('Page_Configuration Attachments/input_attachment_table_display-off'), 1)){
	WebUI.click(findTestObject('Object Repository/Page_Configuration Attachments/input_attachment_table_display-off'))
	//WebUI.delay(1)
	WebUI.verifyElementChecked(findTestObject('Object Repository/Page_Configuration Attachments/input_attachment_table_display-off'), 3)
	WebUI.click(findTestObject('Object Repository/Page_Configuration Attachments/input_Save Changes'))
}else{
	WebUI.comment('WARNING: attachment_table_display aleady in ON state, test may fail')
}

// verfiy it's working
// attachment_table_display should be already in OFF state

// add new record for product=Boeing
new_record_view=siteURL+'/enter_bug.cgi?product=Boeing'
WebUI.navigateToUrl(new_record_view)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Create New Record'),15)

// check these buttons will not exist 
// button: Add Attachment to Field
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Enter Record View/input_Add Attachment to Field'), 5, FailureHandling.STOP_ON_FAILURE)

// button: Add More Attachments
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_attachments/input_Add More Attachments'), 5, FailureHandling.STOP_ON_FAILURE)


