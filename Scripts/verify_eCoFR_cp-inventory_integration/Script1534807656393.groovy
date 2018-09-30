if (GlobalVariable.userPin2.equals('SKIP')) return
import static org.junit.Assert.*
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver

if (!GlobalVariable.G_MAKE_MAS_url.contains('cofr')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}

String searchTerm="criterion"
String baseUrl = "https://www.katalon.com/"

String recordID='76'
String siteURL=GlobalVariable.G_MAKE_MAS_url
baseUrl=siteURL
if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
siteURL=siteURL+'show_bug.cgi?id='+recordID+'#tv=Products'
WebDriver driver
WebUI.comment('check cp-inventory integration in eCoFR')
WebUI.comment('directly go to record 76 and open Products Tab')
WebUI.comment('check cp-inventory integration on record 76->Products Tab->Mapped Product: Search for Record ID field with searchTerm: '+searchTerm)
WebUI.comment('check cp-inventory integration on record 76->Products Tab->Compliance Products: Search for Record ID field with searchTerm: '+searchTerm)

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////
CustomKeywords.'helper.login.LoginHelper.login'()

driver = DriverFactory.getWebDriver()
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(siteURL)
//Screen s = new Screen()
//selenium = new WebDriverBackedSelenium(driver, baseUrl)
//def driver = DriverFactory.getWebDriver()
WebUI.comment('directly go to record 76 and open Products Tab')
//selenium.open("https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/show_bug.cgi?id=76#tv=Products")

//searchTerm="criterion"
WebUI.comment('check cp-inventory integration on record 76->Products Tab->Mapped Product: Search for Record ID field with searchTerm: '+searchTerm)
CustomKeywords.'hci_smoke_test.common.waifForElement'("id=cf_mapped_id_NEW_ROW_1",25)
selenium.click("id=cf_mapped_id_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(1)
selenium.typeKeys("id=cf_mapped_id_NEW_ROW_1", searchTerm)
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
//s.type(Key.ENTER)
selenium.typeKeys("id=cf_mapped_id_NEW_ROW_1", Key.ENTER)
selenium.waitForPageToLoad("80000")
CustomKeywords.'hci_smoke_test.common.waifForElement'("//div[@id='digIt_title_find']//span",80)
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(2)
// check the create link
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'),40)
CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'))
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),10)

WebUI.comment('check cp-inventory integration on record 76->Products Tab->Compliance Products: Search for Record ID field with searchTerm: '+searchTerm)
selenium.click("id=cf_compliance_id_NEW_ROW_1")
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
selenium.typeKeys("id=cf_compliance_id_NEW_ROW_1", searchTerm)
selenium.waitForPageToLoad("30000")
WebUI.delay(2)
selenium.typeKeys("id=cf_compliance_id_NEW_ROW_1", Key.ENTER)
//s.type(Key.ENTER)
selenium.waitForPageToLoad("80000")

WebUI.comment('verify CP-inventory search results')
CustomKeywords.'hci_smoke_test.common.waifForElement'("//div[@id='digIt_title_find']//span",80)
selenium.click("//div[@id='digIt_title_find']//span")
WebUI.delay(5)
// check the create link
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'),40)
CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
WebUI.click(findTestObject('Page_Record_6505_cp_hazard/button_Create Link'))
WebUI.waitForElementClickable(findTestObject('Page_Record_6505_cp_hazard/button_Linked'),10)

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}