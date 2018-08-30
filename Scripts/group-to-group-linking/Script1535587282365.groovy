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

// inside the record: test_automation_record_G2G_linking

// create 3 groups
//select_Tab_Basic_Information()
//select_test_suite('Groups')
//select_Tab_Groups()
//create_3_groups()
//delete_3_groups()

// group to group linking
select_Tab_Basic_Information()
select_test_suite('Internal Linking')
add_2_G2G_Parent_Groups()
//delete_2_G2G_Parent_Groups()

return


def delete_2_G2G_Parent_Groups(){
	// delete 2 G2G Parent Groups 'GROUP_PRNT-1', 'GROUP_PRNT-2'
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'),20)
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_PRNT-1  GROUP_PRNT-1'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
	
	WebUI.delay(3)
	WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information')
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'),20)
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_PRNT-2  GROUP_PRNT-2'),20)
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_PRNT-2  GROUP_PRNT-2'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
	WebUI.delay(3)
}


def add_2_G2G_Parent_Groups(){
	// add 2 G2G Parent Groups 'GROUP_PRNT-1', 'GROUP_PRNT-2'
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'),20)
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Parent)'))
	
	WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_1'), 'GROUP_PRNT-1')
	
	//WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add PRNT-2'))
	
	WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_2'), 'GROUP_PRNT-2')
	
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
	
	WebUI.delay(4)
}
def select_Tab_Basic_Information(){
	// goto Tab: Basic Information
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_Basic Information'),25)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/div_Basic Information'))
}
def select_test_suite(String testSuiteName){
	// select test suite: Groups/
	WebUI.scrollToElement(findTestObject('Page_--- 7081 test_automation_recor/select_Test Suite'), 15)
	WebUI.selectOptionByValue(findTestObject('Page_--- 7081 test_automation_recor/select_Test Suite'), testSuiteName, true)
}
def select_Tab_Groups(){
// goto Tab Groups
	WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
	WebUI.delay(2)
	WebUI.waitForElementVisible(findTestObject('Page_--- 7081 test_automation_recor/div_Groups'),10)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_Groups'),10)
	WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Groups'))
}
def create_3_groups(){
	// create 3 (STATIC) groups from Non-Sortable Field Group 
	WebUI.scrollToElement(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Non-Sortable Field Group'),15)
	WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_groups_static_text_NE'), 'Group1')
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Add STATIC-2'))
	WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_groups_static_text_NE_1'), 'Group2')
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Add STATIC-3'))
	WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_groups_static_text_NE_2'), 'Group3')
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Save Changes'))
	WebUI.delay(3)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_Basic Information'),25)
}
def delete_3_groups(){
	// delete the 3 (STATIC) groups from Non-Sortable Field Group 
	def driver = DriverFactory.getWebDriver()
	String baseUrl = "https://www.katalon.com/"
	selenium = new WebDriverBackedSelenium(driver, baseUrl)
	WebUI.click(findTestObject('Page_Administer your installation/a_Home'))
	selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Groups")
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_Basic Information'),25)
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Non-Sortable Field Group'),15)
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
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Save Changes'))
	WebUI.delay(3)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_Basic Information'),25)
	
	//WebUI.scrollToElement(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Non-Sortable Field Group'),15)
	/*//WebUI.scrollToElement(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-1 Group1'))
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'),5)
	WebUI.delay(10)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-2 Group2'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-2 Group2'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-3 Group3'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/div_STATIC-3 Group3'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/span_(Delete)'))
	*/
}

return




