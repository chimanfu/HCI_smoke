import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*

CustomKeywords.'helper.login.LoginHelper.login'()

//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_csn/show_bug.cgi?id=7191#tv=tabVerifications')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=7191#tv=tabVerifications')
WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/div_Verifications'))
WebUI.delay(1)
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> elements = driver.findElements(By.xpath("id('cfgr_Verifications_dd_list')//span[(contains(text(), 'VERIF'))]"))
int mails_matched_size=elements.size()
println 'mails_matched_size='+mails_matched_size
String[] mail_ids = new String[mails_matched_size]

for (int i = 1; i <= mails_matched_size; i++) {
	//elements.get(i).click()
	WebUI.scrollToElement(findTestObject('Page_Record test_automation_record/a_PDF'),20)
	driver.findElement(By.xpath("id('cfgr_Verifications_dd_list')//span[(contains(text(), 'VERIF"+i+".') or contains(., 'VERIF"+i+".'))]")).click()
	WebUI.delay(5)
	waifForElement("(//div[contains(@class,'yui-u cf_lcc_id field_value')]//img[@src='skins/standard/praca/img2/link_btn.png' and contains(@onclick, 'Daggr.showMenu')])["+i+"]",20)
	driver.findElement(By.xpath("(//div[contains(@class,'yui-u cf_lcc_id field_value')]//img[@src='skins/standard/praca/img2/link_btn.png' and contains(@onclick, 'Daggr.showMenu')])["+i+"]")).click()
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/div_View record_daggr_menu'),10)
	WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/div_View record_daggr_menu'))
	
	try {
		WebUI.delay(2)
		WebUI.switchToWindowIndex(1)
		WebUI.delay(2)
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),4,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
		}
	} catch (Exception e) {
		e.printStackTrace()
	}
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_LCC 100 CSE MOV Leak Anomaly/a_record_creator_name'),15)
	record_creator_email= WebUI.getAttribute(findTestObject('Page_LCC 100 CSE MOV Leak Anomaly/a_record_creator_name'), 'href')
	record_creator_email=record_creator_email.substring(record_creator_email.indexOf(':')+1).trim()
	println 'record_creator_email='+record_creator_email
	
	WebUI.switchToWindowIndex(0)
	WebUI.delay(2)
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
	//WebUI.scrollToElement(findTestObject('Page_Record test_automation_record/a_PDF'),15)
	//WebUI.closeWindowIndex(1)
	WebUI.delay(5)
	
	
	}
return
//WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/span_VERIF1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/img_linked_menu'),10)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/img_linked_menu'),10)
WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/img_linked_menu'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/div_View record_daggr_menu'),10)
WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 7191  kens sec/div_View record_daggr_menu'))

try {
	WebUI.delay(2)
	WebUI.switchToWindowIndex(1)
	if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
		WebUI.comment('clicked on input_login_btn')
	}
} catch (Exception e) {
	e.printStackTrace()
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_LCC 100 CSE MOV Leak Anomaly/a_record_creator_name'),15)
record_creator_email= WebUI.getAttribute(findTestObject('Page_LCC 100 CSE MOV Leak Anomaly/a_record_creator_name'), 'href')
record_creator_email=record_creator_email.substring(record_creator_email.indexOf(':')+1).trim()
println 'record_creator_email='+record_creator_email

WebUI.switchToWindowIndex(0)
WebUI.closeWindowIndex(1)

def waifForElement(String xpath, int inSeconds){
	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
	println 'xpath='+xpath
	for (int second = 0;; second++) {
		if (second >= inSeconds) break;
		try { if (selenium.isElementPresent(xpath)&&selenium.isVisible(xpath)) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
}