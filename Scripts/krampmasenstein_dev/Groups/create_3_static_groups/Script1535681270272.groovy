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

// create 3 static groups from krampmasenstein_dev -> Test Suite -> Groups
select_Tab_Basic_Information()
select_test_suite('Groups')
select_Tab_Groups()
create_3_groups()

return


def select_Tab_Basic_Information(){
	// goto Tab: Basic Information
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_Basic Information'))
}
def select_test_suite(String testSuiteName){
	// select test suite: Groups/
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/select_Test Suite'), 15)
	WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Test Suite'), testSuiteName, true)
}
def select_Tab_Groups(){
// goto Tab Groups
	WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
	WebUI.delay(2)
	WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Groups'),10)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Groups'),10)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_Groups'))
}
def create_3_groups(){
	// create 3 (STATIC) groups from Non-Sortable Field Group 
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_Non-Sortable Field Group'),15)
	WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_1'), 'Group1')
	WebUI.click(findTestObject('Page_record_G2G_linking/button_Add STATIC-2'))
	WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_2'), 'Group2')
	WebUI.click(findTestObject('Page_record_G2G_linking/button_Add STATIC-3'))
	WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_3'), 'Group3')
	WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
	WebUI.delay(3)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
}






