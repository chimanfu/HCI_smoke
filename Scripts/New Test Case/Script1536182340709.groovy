import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

//KeywordUtil.logInfo ('current record url='+GlobalVariable.recordName2)
//WebUI.navigateToUrl(GlobalVariable.recordName2)

/*
WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments'),10)
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_contents/input_obsolete_checkbox'),5)){
	WebUI.click(findTestObject('Object Repository/Page_Record_contents/input_obsolete_checkbox'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
	WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
	//WebUI.delay(6)
	//check_record_save_alert()
}

if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
	all_logMsg=all_logMsg+'PASS: CSA Flag visible and checked as expected\n'
}else{
	all_logMsg=all_logMsg+'ERROR: Cannot find flag with CSA: visible and checked\n'
	test_failed=true
}*/
WebUI.verifyElementChecked(findTestObject('Page_IP_Permissions/checkbox_edit_attachment_CSA_Flag'),10)
WebUI.verifyElementNotChecked(findTestObject('Page_IP_Permissions/checkbox_edit_attachment_ESA_Flag'),10)
WebUI.verifyElementNotChecked(findTestObject('Page_IP_Permissions/checkbox_edit_attachment_RSA_Flag'),10)
WebUI.verifyElementNotChecked(findTestObject('Page_IP_Permissions/checkbox_edit_attachment_JAXA_Flag'),10)

