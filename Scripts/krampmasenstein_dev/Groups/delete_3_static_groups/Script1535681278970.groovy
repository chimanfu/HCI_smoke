import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

CustomKeywords.'helper.login.LoginHelper.login'()
CustomKeywords.'kramp.Internal_Linking.select_TAB_Basic_Information'()
CustomKeywords.'kramp.Groups.select_TAB_Groups'()
CustomKeywords.'kramp.Groups.delete_3_static_groups'()
CustomKeywords.'kramp.Internal_Linking.save_changes'()

/*WebUI.switchToWindowIndex(0)
url = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev'

// directly navigate to the record: test_automation_record_G2G_linking 
test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information'
WebUI.navigateToUrl(test_automation_record_G2G_linking)
*/

// delete 3 static groups from krampmasenstein_dev -> Test Suite -> Groups
//select_Tab_Basic_Information()
//select_test_suite('Groups')
//select_Tab_Groups()
//delete_3_groups()

return


/*def select_Tab_Basic_Information(){
	// goto Tab: Basic Information
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_Basic Information'))
}
def select_test_suite(String testSuiteName){
	// select test suite: Groups/
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/select_Test Suite'), 15)
	WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Test Suite'), testSuiteName, true)
}*/
def select_Tab_Groups(){
	// goto Tab Groups
	WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
	WebUI.delay(2)
	WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Groups'),10)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Groups'),10)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_Groups'))
}
def delete_3_groups(){
	// delete the 3 (STATIC) groups from Non-Sortable Field Group 
	String baseUrl = "https://www.katalon.com/"
	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
	
	WebUI.click(findTestObject('Page_Administer your installation/a_Home'))
	selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Groups")
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Non-Sortable Field Group'),15)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[2]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-1'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-1'])[1]/following::span[3]")
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[3]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-2'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-2'])[1]/following::span[3]")
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Free Text Field:'])[4]/following::div[8]")
	CustomKeywords.'hci_smoke_test.common.waifForElement'("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-3'])[1]/following::span[3]",5)
	selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='STATIC-3'])[1]/following::span[3]")
	
	CustomKeywords.'kramp.Internal_Linking.save_changes'()
	
	//WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_Non-Sortable Field Group'),15)
	/*//WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_STATIC-1 Group1'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-1 Group1'))
	WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_(Delete)'),5)
	WebUI.delay(10)
	WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_STATIC-2 Group2'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-2 Group2'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)'))
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_STATIC-3 Group3'),15)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-3 Group3'))
	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_(Delete)'),5)
	WebUI.delay(5)
	WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)'))
	*/
}





