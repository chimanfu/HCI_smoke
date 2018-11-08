import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.sikuli.script.Pattern as Pattern
import org.sikuli.script.Screen
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable as GlobalVariable

GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'

String cmd = "pkill -f Chrome"
Runtime.getRuntime().exec(cmd)
Screen s = new Screen()
WebUI.openBrowser('')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
WebUI.delay(2)
WebUI.maximizeWindow()
WebUI.switchToWindowIndex(0)
WebUI.switchToDefaultContent()
if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Page_Login/input_login_btn'))
	WebUI.delay(1)
	if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),20,FailureHandling.OPTIONAL)){
		println 'Access Launchpad login: found Page_Access Launchpad/input_SCLOGIN'
		//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
		/*baseUrl = "https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev/show_bug.cgi?id=6505#tv=tabVerifications&gv=group"
		driver = DriverFactory.getWebDriver()
		selenium = new WebDriverBackedSelenium(driver,baseUrl)
		selenium.waitForPageToLoad('3000')
		selenium.click("//input[@id = 'SCLOGIN' and @type = 'button' and @title = 'Insert your smart card and click here']")*/
		
		try {
			WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),12,FailureHandling.STOP_ON_FAILURE)
			println 'found Page_Login/smartcard_login_button'
			WebUI.delay(3)
			WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
			WebUI.delay(1)
			WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
			println 'clicked on Page_Login/smartcard_login_button'
		} catch (Exception e) {
			println 'not found Page_Login/smartcard_login_button'
			e.printStackTrace()
		}

		try {
			WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),5,FailureHandling.STOP_ON_FAILURE)
			WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
			println 'clicked on acceptCert_ok_button'
		} catch (Exception e) {
			println 'not found Page_Login/acceptCert_ok_button'
			e.printStackTrace()
		}
		try{
			WebUI.waitForImagePresent(findTestObject('Page_Login/pin_field_empty'),6,FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(1)
			WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
			WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
		} catch (Exception e) {
			println 'not found Page_Login/pin_field_empty'
			e.printStackTrace()
			// enter the pin using OpenCV
			if (s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',4)!=null){
				WebUI.comment('found on pin_field_activID, so enter the PIN for the user')
				s.type(GlobalVariable.G_userPin+"\n")
			}else if (s.exists(GlobalVariable.G_image_path+'activID_ActivClient.png',1)!=null){
				println('found on activID_ActivClient, so enter the PIN for the user')
				s.type(GlobalVariable.G_userPin+"\n")
			}else if (s.exists(GlobalVariable.G_image_path+'pin_field_empty.png',1)!=null){
				println('found on pin_field_empty, so enter the PIN for the user')
				s.type(GlobalVariable.G_userPin+"\n")
			}else{
				println('Not found on pin_field_empty, still enter the PIN for the user just in case')
				s.type(GlobalVariable.G_userPin+"\n")
			}
		}	
		
	}
	return
}
//Screen s = new Screen()
GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'

Pattern smartcard_login_button = new Pattern(GlobalVariable.G_image_path + 'smartcard_login_button.png').similar(0.6)
if (s.exists(smartcard_login_button, 10)!=null){
	s.click(smartcard_login_button)
}else{
	println 'not found smartcard_login_button'
}
Pattern acceptCert_ok_button = new Pattern(GlobalVariable.G_image_path + 'acceptCert_ok_button.png').similar(0.6)
if (s.exists(acceptCert_ok_button,5)!=null){
	s.click(acceptCert_ok_button)
	WebUI.delay(1)
}else{
	println 'not found acceptCert_ok_button'
}