import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_dev/show_bug.cgi?id=147#tv=tabBasic_Information&gv=group")
selenium.click("id=attachment_table_display_0_info")

// check pdf attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s135826']/span",5)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_pdf",5)

// check doc attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s135515']/span",5)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_vnd_openxmlformats-officedocument_wordprocessingml_document",5)

// check powerpoint attachment
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//span[@id='s53312']/span",15)
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("css=div.attach_left.application_vnd_ms-powerpoint",15)

//wait for 'Add More Attachments' button
CustomKeywords.'hci_smoke_test.common.waifForElementPresent'("//div[@id='template_1']/span/input[@id='attachment_file_input_1']",25)
//selenium.click("//div[@id='template_1']/span/input[@id='attachment_file_input_1']")

