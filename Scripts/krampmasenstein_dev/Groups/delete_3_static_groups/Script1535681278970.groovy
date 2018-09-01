import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.switchToWindowIndex(0)
url = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev'

// directly navigate to the record: test_automation_record_G2G_linking 
test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information'
WebUI.navigateToUrl(test_automation_record_G2G_linking)


// delete 3 static groups from krampmasenstein_dev -> Test Suite -> Groups
select_Tab_Basic_Information()
select_test_suite('Groups')
select_Tab_Groups()
delete_3_groups()

return


def select_Tab_Basic_Information(){
	// goto Tab: Basic Information
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Basic Information'),25)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_Basic Information'))
}
def select_test_suite(String testSuiteName){
	// select test suite: Groups/
	WebUI.scrollToElement(findTestObject('Page_G2G_linking_record/select_Test Suite'), 15)
	WebUI.selectOptionByValue(findTestObject('Page_G2G_linking_record/select_Test Suite'), testSuiteName, true)
}
def select_Tab_Groups(){
// goto Tab Groups
	WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
	WebUI.delay(2)
	WebUI.waitForElementVisible(findTestObject('Page_G2G_linking_record/div_Groups'),10)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Groups'),10)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_Groups'))
}
def delete_3_groups(){
	// delete the 3 (STATIC) groups from Non-Sortable Field Group 
	String baseUrl = "https://www.katalon.com/"
	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
	
	WebUI.click(findTestObject('Page_Administer your installation/a_Home'))
	selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Groups")
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Basic Information'),25)
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Non-Sortable Field Group'),15)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[2]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-1'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-1'])[1]/following::span[3]")
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[3]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-2'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-2'])[1]/following::span[3]")
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[4]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-3'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-3'])[1]/following::span[3]")
	//WebUI.delay(2)
	//WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
	WebUI.click(findTestObject('Page_G2G_linking_record/button_Save Changes'))
	WebUI.delay(3)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Basic Information'),25)
	
	//WebUI.scrollToElement(findTestObject('Page_G2G_linking_record/div_Non-Sortable Field Group'),15)
	/*//WebUI.scrollToElement(findTestObject('Page_G2G_linking_record/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_STATIC-1 Group1'))
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/span_(Delete)'),5)
	WebUI.delay(10)
	WebUI.click(findTestObject('Page_G2G_linking_record/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_G2G_linking_record/div_STATIC-2 Group2'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_STATIC-2 Group2'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_G2G_linking_record/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_G2G_linking_record/div_STATIC-3 Group3'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_STATIC-3 Group3'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_G2G_linking_record/span_(Delete)'))
	*/
}





