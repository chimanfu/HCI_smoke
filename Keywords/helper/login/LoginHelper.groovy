package helper.login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

//import MobileBuiltInKeywords as Mobile
//import WSBuiltInKeywords as WS
//import WebUiBuiltInKeywords as WebUI
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern as Pattern
/**
 * Open browser
 * Open Bugzila --> Get from Global variable
 * Click on File Bug link
 * Provide Username and Password
 * Click on Login
 * */

/*
 * Will read value from Global variable
 * Will accept the argument from the script
 * 
 * */

public class LoginHelper {


	@Keyword
	public void loginVPN(){


		Screen s = new Screen();
		WebUI.openBrowser('')
		WebUI.navigateToUrl('http://vpn.nasa.gov/')

		try{
			WebUI.switchToWindowIndex(0)
			WebUI.closeWindowIndex(1)
			WebUI.delay(1)
			WebUI.switchToWindowIndex(0)
			WebUI.delay(1)
		}catch (Exception e) {
			WebUI.switchToWindowIndex(0)
		}

		//WebUI.waitForElementVisible(findTestObject('Page_Access Launchpad/input_SCLOGIN'),15)
		//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))

		if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),20,FailureHandling.OPTIONAL)){
			//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
			WebUI.waitForPageLoad(6)
			WebUI.delay(1)

			s.wait(GlobalVariable.G_image_path+'smartcard_login_button.png',16)
			s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')

			if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
				//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
				s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
			}else if (s.exists(GlobalVariable.G_image_path+'smartcard_login_button.png',1)!=null){
				s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
				if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
					//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
					s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
				}
			}
			WebUI.delay(5)
			s.type(GlobalVariable.G_userPin+"\n")

			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'),15)
			WebUI.click(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'))
			WebUI.delay(1)
			s.type('\n')
		}
	}

	@Keyword
	public boolean checkHomePageExist(){
		try{
			if ( WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'), 1, FailureHandling.OPTIONAL)) {
				//if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Configuration NASA Params/a_Home'),1,FailureHandling.OPTIONAL)){
				//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
				//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				WebUI.switchToWindowIndex(0)
				WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				WebUI.comment('found home link, login to MAKE_MAS url succeeded! on '+GlobalVariable.G_MAKE_MAS_url)
				WebUI.waitForPageLoad(30)
				if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
					String alertText=WebUI.getAlertText()
					WebUI.acceptAlert()
					WebUI.comment('accept alert='+alertText)
				}
				WebUI.comment('*** Already in Home Page, do not need to login ***')
				return true
			}else if (GlobalVariable.G_MAKE_MAS_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Page_Document Tree/a_TREE'), 1, FailureHandling.OPTIONAL)){
				WebUI.comment('found Tree link, login to MAKE_MAS url succeeded! on '+GlobalVariable.G_MAKE_MAS_url)
				WebUI.switchToWindowIndex(0)
				WebUI.waitForPageLoad(30)

				if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
					String alertText=WebUI.getAlertText()
					WebUI.acceptAlert()
					WebUI.comment('accept alert='+alertText)
				}
				WebUI.comment('*** Already in Home Page, do not need to login ***')
				WebUI.switchToWindowIndex(0)
				return true
			}else if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'), 1, FailureHandling.OPTIONAL)){
				WebUI.comment('found button_New Task Worksheet, login to MAKE_MAS url succeeded! on '+GlobalVariable.G_MAKE_MAS_url)
				WebUI.switchToWindowIndex(0)
				WebUI.waitForPageLoad(30)
				if (WebUI.waitForAlert(1,FailureHandling.OPTIONAL)){
					String alertText=WebUI.getAlertText()
					WebUI.acceptAlert()
					WebUI.comment('accept alert='+alertText)
				}
				WebUI.comment('*** Already in Home Page, do not need to login ***')
				WebUI.switchToWindowIndex(0)
				return true
			}
			WebUI.comment('*** need to login ***')
			return false
		}catch (Exception e) {
			WebUI.comment('cannot checkHomePageExist')
			return false
		}
	}
	@Keyword
	public void login(){
		/*try{
			//WebUI.switchToDefaultContent()
			WebUI.switchToWindowIndex(0)
			//WebUI.closeWindowIndex(1)
			//WebUI.switchToWindowIndex(0)
		}catch (Exception e) {
			//WebUI.switchToWindowIndex(0)
			WebUI.comment('cannot switchToWindowIndex(0)')
		}
		*/		
		if (checkHomePageExist()){
			WebUI.comment('done checkHomePageExist, already in Home page')
			return null
		}

		String cmd = "pkill -f Chrome"
		Runtime.getRuntime().exec(cmd)
		//cmd="killall -9 chromedriver"
		//Runtime.getRuntime().exec(cmd)
		WebUI.comment('killed all processes of Chrome before running test')

		Screen s = new Screen();
		
		try{
			WebUI.openBrowser('')
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
			WebUI.closeWindowIndex(1)
			WebUI.switchToWindowIndex(0)
			
			//WebUI.switchToWindowIndex(0)
			
			//WebUI.delay(1)
			//WebUI.switchToWindowIndex(0)
			//WebUI.delay(1)
		}catch (Exception e) {
			WebUI.switchToWindowIndex(0)
		}
		WebUI.maximizeWindow()
		// check if the restore pages is showing (restore_pages_cancel_button.png)
		if (s.exists(GlobalVariable.G_image_path+'restore_pages_cancel_button.png',1)!=null){
			WebUI.delay(1)
			//s.click(GlobalVariable.G_image_path+'restore_pages_cancel_button.png')
			//WebUI.delay(1)
			Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'restore_pages_cancel_button.png').targetOffset(145,-6)
			//r=s.exists(pImage,1);
			s.click(s.exists(pImage,1), 1)
		}
		if (checkHomePageExist()){
			WebUI.comment('done checkHomePageExist')
			return null
		}
		WebUI.comment('checking input_login_btn')
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
			//WebUI.waitForElementVisible(findTestObject('Page_Access Launchpad/input_SCLOGIN'),15)
			//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
		}
		if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),15,FailureHandling.OPTIONAL)){
			//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
			WebUI.waitForPageLoad(6)
			WebUI.delay(1)
			WebUI.comment('found on input_SCLOGIN')
			s.wait(GlobalVariable.G_image_path+'smartcard_login_button.png',15)
			s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')

			if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',3)!=null){
				//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
				s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
			}else if (s.exists(GlobalVariable.G_image_path+'smartcard_login_button.png',1)!=null){
				s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
				if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
					//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
					s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
				}
			}
			WebUI.delay(5)
			s.type(GlobalVariable.G_userPin+"\n")
		}
		if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn in 2nd attempt')
		}
		// check if alert is showing
		if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
			String alertText=WebUI.getAlertText()
			WebUI.acceptAlert()
			WebUI.comment('accept alert='+alertText)
		}
		// check if the restore pages is showing (restore_pages_cancel_button.png)
		/*if (s.exists(GlobalVariable.G_image_path+'restore_pages_cancel_button.png',1)!=null){
		 WebUI.delay(1)
		 //s.click(GlobalVariable.G_image_path+'restore_pages_cancel_button.png')
		 //WebUI.delay(1)
		 Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'restore_pages_cancel_button.png').targetOffset(145,-6)
		 //r=s.exists(pImage,1);
		 s.click(s.exists(pImage,1), 1)
		 }*/
		if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),10,FailureHandling.OPTIONAL)){
			//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
			if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
				s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',20)
				WebUI.comment('found cp_hazard_logo')
				WebUI.comment('found home link and cp_hazard_logo, login to cp_hazard succeeded!')
			}

			//WebUI.waitForPageLoad(30)
			WebUI.comment('*** Done Login ***')
		}
	}

	@Keyword
	public void loginIntoApplication(String applicationUrl,String Username,String Password){

		WebUI.openBrowser(applicationUrl)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Object Repository/Bugzilla/HomePage/FlieBugLink'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/Bugzilla/HomePage/FlieBugLink'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/Bugzilla/LoginPage/LoginBtn'), GlobalVariable.TimeOut)

		WebUI.sendKeys(findTestObject('Object Repository/Bugzilla/LoginPage/UsernameTxtBox'), Username)
		WebUI.sendKeys(findTestObject('Object Repository/Bugzilla/LoginPage/PasswordTxtBox'), Password)
		WebUI.click(findTestObject('Object Repository/Bugzilla/LoginPage/LoginBtn'))
		WebUI.delay(1)
	}

	@Keyword
	public void loginIntoApplicationWith(){
		loginIntoApplication(GlobalVariable.ApplicationUrl,GlobalVariable.Username,GlobalVariable.Password)
	}

	@Keyword
	public void logoutFromApplication(){
		WebUI.waitForElementVisible(findTestObject('Object Repository/Bugzilla/HomePage/LogoutBtn'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/Bugzilla/HomePage/LogoutBtn'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Bugzilla/HomePage/FlieBugLink'), GlobalVariable.TimeOut)
		WebUI.closeBrowser()
	}
}
