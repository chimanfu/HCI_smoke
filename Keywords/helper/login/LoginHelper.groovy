package helper.login

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.sikuli.script.Pattern as Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable


public class LoginHelper {
	def kill_chrome(){
		String cmd
		if (System.getProperty('os.name').contains('Mac')){
			cmd = "pkill -f Chrome"
		}else{
			cmd = 'taskkill /IM chrome.exe /F'
		}
		Runtime.getRuntime().exec(cmd)
		WebUI.comment('killed all processes of Chrome')
	}
	@Keyword
	public void loginMailCatcher(){
		try{
			String mailcatcher_url='https://dig-it-dev.nas.nasa.gov/mailcatcher/'
			try{
				WebUI.navigateToUrl(mailcatcher_url)
				WebUI.maximizeWindow()
				WebUI.switchToWindowIndex(0)
				WebUI.switchToDefaultContent()
				WebUI.waitForPageLoad(60)
				if ( WebUI.waitForElementClickable(findTestObject('Page_MailCatcher/a_MailCatcher_heading'),5,FailureHandling.OPTIONAL)) {
					WebUI.comment 'already in MailCatcher'
					WebUI.delay(5)
					return
				}
			}catch (Exception e) {
				//WebUI.switchToWindowIndex(0)
				KeywordUtil.markWarning(e.message)
			}
			try{


				//String cmd = "pkill -f Chrome"
				//Runtime.getRuntime().exec(cmd)
				//WebUI.comment('killed all processes of Chrome before running test')
				//WebUI.delay(2)
				//WebUI.openBrowser('')
				WebUI.navigateToUrl(mailcatcher_url)
				WebUI.maximizeWindow()
				//WebUI.delay(2)
				WebUI.switchToWindowIndex(0)
				WebUI.switchToDefaultContent()
				WebDriver driver = DriverFactory.getWebDriver()
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())
				WebUI.comment("No. of tabs: " + tabs.size())
				int tabs_number=tabs.size()
				while (tabs_number>1){
					WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
					tabs_number--
				}
			}catch (Exception e) {
				KeywordUtil.markWarning(e.message)
				WebUI.delay(2)
				WebUI.switchToWindowIndex(0)
				e.printStackTrace()
			}
			//Screen s = new Screen()
			WebUI.comment 'Access Launchpad login'
			smartcard_login()
			/*if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),20,FailureHandling.OPTIONAL)){
			 //WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
			 WebUI.waitForPageLoad(6)
			 WebUI.delay(1)
			 s.wait(GlobalVariable.G_image_path+'smartcard_login_button.png',16)
			 s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
			 if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
			 s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
			 }else if (s.exists(GlobalVariable.G_image_path+'smartcard_login_button.png',1)!=null){
			 s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
			 if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
			 s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
			 }
			 }
			 if (s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',4)!=null){
			 WebUI.comment('found on pin_field_activID, so enter the PIN for the user')
			 s.type(GlobalVariable.G_userPin+"\n")
			 }else{
			 WebUI.comment('Not found on pin_field_activID, still enter the PIN for the user just in case')
			 s.type(GlobalVariable.G_userPin+"\n")
			 }
			 }*/
			WebUI.waitForElementNotClickable(findTestObject('Page_MailCatcher/a_MailCatcher_heading'),15)
			WebUI.comment('successfully logint to mailcatcher')
		}catch (Exception e) {
			WebUI.comment('something wrong when trying to login to mailcatcher')
			KeywordUtil.markWarning(e.message)
		}
	}

	@Keyword
	public void loginVPN(){
		Screen s = new Screen()
		boolean useAnyConnect=false
		WebUI.comment 'running loginVPN'
		try{
			if (useAnyConnect){
				/////// AnyConnect
				WebUI.comment 'Will connect VPN with Cisco AnyConnect'
				// disconnect
				Runtime.getRuntime().exec('/opt/cisco/anyconnect/bin/vpn disconnect')

				// connect
				String cmd = 'open "/Applications/Cisco/Cisco AnyConnect Secure Mobility Client.app" &'
				Runtime.getRuntime().exec(cmd)

				if (s.exists(GlobalVariable.G_image_path+'AnyConnect_connect.png',10)!=null){
					s.click(GlobalVariable.G_image_path+'AnyConnect_connect.png')
				}
				if (s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',5)!=null){
					s.type(GlobalVariable.G_userPin+"\n")
				}
				if (s.exists(GlobalVariable.G_image_path+'AnyConnect_Accept.png',8)!=null){
					s.click(GlobalVariable.G_image_path+'AnyConnect_Accept.png')
				}
				if (s.exists(GlobalVariable.G_image_path+'AnyConnect_Up_icon.png',12)!=null){
					WebUI.comment 'AnyConnect is Up'
				}
				else{
					WebUI.comment 'AnyConnect may not be Up'
				}
				GlobalVariable.userPin2='SKIP'
				return
				///////
			}
			WebUI.comment 'login to VPN on Pulse Secure'
			Region righttop=new Screen(0).setRect(805,0,635,235)
			WebUI.comment 'will disconnect VPN first if it already connected'
			try{
				if (righttop.exists(GlobalVariable.G_image_path+'securePulseVPN_connected_icon.png',5)!=null){
					righttop.click(GlobalVariable.G_image_path+'securePulseVPN_connected_icon.png')
					WebUI.delay(1)
					righttop.wait(GlobalVariable.G_image_path+'vpn_selection.png',5)
					righttop.click(GlobalVariable.G_image_path+'vpn_selection.png')
					righttop.wait(GlobalVariable.G_image_path+'disconnect.png',5)
					righttop.click(GlobalVariable.G_image_path+'disconnect.png')
				}
			}catch (Exception e) {
				KeywordUtil.markWarning(e.message)
				e.printStackTrace()
			}
			WebUI.openBrowser('')
			WebUI.navigateToUrl('http://vpn.nasa.gov/')
			try{
				WebUI.switchToWindowIndex(0)
				WebUI.switchToDefaultContent()
				WebUI.maximizeWindow()

				WebDriver driver = DriverFactory.getWebDriver()
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())
				WebUI.comment("No. of tabs: " + tabs.size())
				int tabs_number=tabs.size()
				while (tabs_number>1){
					WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
					tabs_number--
				}
			}catch (Exception e) {
				KeywordUtil.markWarning(e.message)
				WebUI.switchToWindowIndex(0)
				e.printStackTrace()

			}

			check_restore_pages_popup()
			//WebUI.waitForElementVisible(findTestObject('Page_Access Launchpad/input_SCLOGIN'),15)
			//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
			WebUI.comment 'Access Launchpad login'
			if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),20,FailureHandling.OPTIONAL)){
				// run the smartcard login
				smartcard_login()
				//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
				/*WebUI.waitForPageLoad(6)
				 WebUI.delay(1)
				 ///////////
				 for (int i = 0; i <3; i++) {
				 if (s.exists(GlobalVariable.G_image_path+'smartcard_login_button.png',5)!=null){
				 s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
				 }
				 if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',5)!=null){
				 s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
				 }
				 if (s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',5)!=null){
				 WebUI.comment('found on pin_field_activID, so enter the PIN for the user')
				 s.type(GlobalVariable.G_userPin+"\n")
				 break
				 }else{
				 WebUI.comment('Not found on pin_field_activID, still enter the PIN for the user just in case')
				 s.type(GlobalVariable.G_userPin+"\n")
				 break
				 }
				 }*/
				WebUI.delay(5)
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'),7,FailureHandling.OPTIONAL)){
					WebUI.delay(1)
					WebUI.click(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'))
					WebUI.delay(1)
					s.type('\n')
				}else{
					if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ames Research Center - Confirm/input_Last Access Time_btnCont'),5,FailureHandling.OPTIONAL)){
						WebUI.click(findTestObject('Object Repository/Page_Ames Research Center - Confirm/input_Last Access Time_btnCont'))
					}
					if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'),20,FailureHandling.OPTIONAL)){
						WebUI.delay(1)
						WebUI.click(findTestObject('Object Repository/Page_Pulse Connect Secure - Home/input_btnNCStart'))
						WebUI.delay(1)
						s.type('\n')
					}
				}
			}
		}catch (Exception e) {
			WebUI.comment('something wrong when trying to do VPN login')
			KeywordUtil.markWarning(e.message)
		}
	}
	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell1 = new GroovyShell()
		MetaClass mc = shell1.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}
	def get_main_page_title(){
		String main_page_title = WebUI.getWindowTitle()
		addGlobalVariable('main_page_title',main_page_title)
		String site_name_title=main_page_title.substring(0,main_page_title.lastIndexOf(' Main Page'))
		addGlobalVariable('site_name_title',site_name_title)
		println "site_name_title='"+site_name_title+"'"
	}
	@Keyword
	public boolean checkHomePageExist(String site_url){
		try{
			if (site_url.equals(null) ||site_url.equals('')){
				site_url=GlobalVariable.G_MAKE_MAS_url
			}
			if ( WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'), 1, FailureHandling.OPTIONAL)) {
				WebUI.switchToWindowIndex(0,FailureHandling.OPTIONAL)
				//WebUI.navigateToUrl(site_url,FailureHandling.OPTIONAL)
				WebUI.comment('found home link, login to MAKE_MAS url succeeded! on '+site_url)
				WebUI.waitForPageLoad(30,FailureHandling.OPTIONAL)
				// check if alert is showing
				check_accept_alert()
				if (!WebUI.getUrl().contains(site_url)) {
					WebUI.navigateToUrl(site_url)
				}else{
					WebUI.comment('*** Already in Home Page, do not need to login ***')
					get_main_page_title()
					return true
				}

			}else if (site_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Page_Document Tree/a_TREE'), 1, FailureHandling.OPTIONAL)){
				WebUI.comment('found Tree link, login to MAKE_MAS url succeeded! on '+site_url)
				WebUI.switchToWindowIndex(0,FailureHandling.OPTIONAL)
				WebUI.waitForPageLoad(30,FailureHandling.OPTIONAL)
				// check if alert is showing
				check_accept_alert()
				if (!WebUI.getUrl().contains(site_url)) {
					WebUI.navigateToUrl(site_url)
				}else{
					WebUI.comment('*** Already in Home Page, do not need to login ***')
					WebUI.switchToWindowIndex(0,FailureHandling.OPTIONAL)
					get_main_page_title()
					return true
				}
			}else if (site_url.contains('etasksheet') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'), 1, FailureHandling.OPTIONAL)){
				WebUI.comment('found button_New Task Worksheet, login to MAKE_MAS url succeeded! on '+site_url)
				WebUI.switchToWindowIndex(0,FailureHandling.OPTIONAL)
				WebUI.waitForPageLoad(30,FailureHandling.OPTIONAL)
				// check if alert is showing
				check_accept_alert()
				if (!WebUI.getUrl().contains(site_url)) {
					WebUI.navigateToUrl(site_url)
				}else{
					WebUI.comment('*** Already in Home Page, do not need to login ***')
					WebUI.switchToWindowIndex(0,FailureHandling.OPTIONAL)
					get_main_page_title()
					return true
				}
			}
			WebUI.comment('*** need to login ***')
			return false
		}catch (Exception e) {
			WebUI.comment('Something wrong!!! cannot perform checkHomePageExist()\n'+e.message)
			return false
		}
	}

	@Keyword
	public void switch_to_training(){
		if (WebUI.getUrl().contains('raining')){
			WebUI.comment 'aleady in training site'
			GlobalVariable.G_MAKE_MAS_url=WebUI.getUrl()
			return
		}
		String training_site_url=''
		String siteURL
		if((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
			GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/etasksheetTraining'
			GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/etasksheetTraining/page.cgi'
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
			if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6,FailureHandling.OPTIONAL)){
				WebUI.click(findTestObject('Page_Login/input_login_btn'))
				WebUI.comment('clicked on input_login_btn')
			}
			check_accept_alert()
			return
		}
		if((GlobalVariable.G_MAKE_MAS_url).contains('doctree')){
			GlobalVariable.G_MAKE_MAS_url='https://mas.nasa.gov/doctreeTraining'
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
			if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6,FailureHandling.OPTIONAL)){
				WebUI.click(findTestObject('Page_Login/input_login_btn'))
				WebUI.comment('clicked on input_login_btn')
			}
			check_accept_alert()
			return
		}
		if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree') && WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),5,FailureHandling.OPTIONAL)){
			//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
			WebUI.click(findTestObject('Object Repository/Page_Main Page/a_Home'))
			WebUI.comment('found Home TAB, launch Home page now')
		}else{
			WebUI.comment('cannot find Home page, launch site url instead')
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
		}
		if (!GlobalVariable.G_MAKE_MAS_url.contains('doctree'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),15)

		//if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'),3,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'))
			WebUI.delay(2)
			training_site_url=WebUI.getUrl()
			GlobalVariable.G_MAKE_MAS_url=training_site_url
			WebUI.comment 'GlobalVariable.G_MAKE_MAS_url='+GlobalVariable.G_MAKE_MAS_url
			if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6,FailureHandling.OPTIONAL)){
				WebUI.click(findTestObject('Page_Login/input_login_btn'))
				WebUI.comment('clicked on input_login_btn')
			}
		}else{
			WebUI.comment 'It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have sandbox instance in Home page, try something else'
			WebUI.comment GlobalVariable.G_MAKE_MAS_url+' does not have sandbox instance'
			siteURL=GlobalVariable.G_MAKE_MAS_url
			if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
			GlobalVariable.G_MAKE_MAS_url=siteURL
			if (GlobalVariable.G_MAKE_MAS_url.contains('mas.nasa.gov')){
				if (GlobalVariable.G_MAKE_MAS_url.contains('Inventory')){
					training_site_url=GlobalVariable.G_MAKE_MAS_url+'_Training'
				}else if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')){
					training_site_url=GlobalVariable.G_MAKE_MAS_url+'-training'
				}else{
					training_site_url=(GlobalVariable.G_MAKE_MAS_url+'Training')
				}
			}else{
				training_site_url=(GlobalVariable.G_MAKE_MAS_url+'/training')
			}
			WebUI.navigateToUrl(training_site_url)

			if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_404 Not Found/h1_Not Found'), 3,FailureHandling.OPTIONAL)){
				WebUI.comment 'It seems '+GlobalVariable.G_MAKE_MAS_url+' does not have training site and cannot find the a_sandbox instance in Home page, will skip all the testcases from the testsuite (smoke_test_with_trainings) as it only runs for training site'
				GlobalVariable.userPin3='SKIP'
			}

			GlobalVariable.G_MAKE_MAS_url=training_site_url
			if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),6,FailureHandling.OPTIONAL)){
				WebUI.click(findTestObject('Page_Login/input_login_btn'))
				WebUI.comment('clicked on input_login_btn')
			}
			check_accept_alert()

		}

	}

	@Keyword
	def login(){
		if (checkHomePageExist()){
			WebUI.comment('done checkHomePageExist, already in Home page')
			return null
		}
		String site_url=GlobalVariable.G_MAKE_MAS_url
		String cmd = "pkill -f Chrome"
		//String cmd = 'while pgrep Chrome ; do pkill Chrome ; done'
		//		Runtime.getRuntime().exec(cmd)
		//WebUI.comment('killed all processes of Chrome before running test')
		////////////////// new //////////////////
		//cmd="killall -9 chromedriver"
		//Runtime.getRuntime().exec(cmd)
		//WebUI.comment('killed all processes of chromedriver before running test')
		//WebUI.delay(1)
		////////////////// new //////////////////
		try{
			//WebUI.openBrowser('')
			WebUI.navigateToUrl(site_url)
			//WebUI.delay(1)
			WebUI.maximizeWindow()
			WebUI.switchToWindowIndex(0)
			WebUI.switchToDefaultContent()
			WebDriver driver = DriverFactory.getWebDriver()
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())
			WebUI.comment("No. of tabs: " + tabs.size())
			int tabs_number=tabs.size()
			while (tabs_number>1){
				WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
				tabs_number--
			}
		}catch (Exception e) {
			//WebUI.switchToWindowIndex(0)
			//WebUI.delay(1)
			KeywordUtil.markWarning(e.message)
			WebUI.openBrowser('')
			WebUI.navigateToUrl(site_url,FailureHandling.STOP_ON_FAILURE)
			//WebUI.maximizeWindow()
		}
		check_restore_pages_popup()
		if (checkHomePageExist()){
			WebUI.comment('done checkHomePageExist')
			return null
		}
		// add new check for 'sudo cookie is invalid.' for IP permission test
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Invalid Sudo Cookie/b_You made an invalid entry.'),1,FailureHandling.OPTIONAL)){
			WebUI.comment('found - You made an invalid entry, sudo cookie is invalid, refresh the page now')
			WebUI.refresh()
		}

		WebUI.comment('checking input_login_btn')
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),8,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
			WebUI.delay(1)
			if (checkHomePageExist()){
				WebUI.comment('done checkHomePageExist')
				return null
			}
		}
		smartcard_login_new()
		//smartcard_login()

		if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn in 2nd attempt')
		}
		// check if alert is showing
		check_accept_alert()
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		WebUI.comment 'Need to try again as it failed to login to site URL '+site_url
		kill_chrome()
		WebUI.openBrowser('')
		WebUI.navigateToUrl(site_url)
		WebUI.maximizeWindow()
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),7,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
			if (checkHomePageExist(site_url)){
				WebUI.comment('done checkHomePageExist')
				return true
			}
		}
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		WebUI.comment 'try the old way to do smartcard_login'
		smartcard_login()
		if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn in 2nd attempt')
		}
		// check if alert is showing
		check_accept_alert()
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		return false
	}
	@Keyword
	def check_restore_pages_popup(){

		// check if the restore pages popup is showing (restore_pages_cancel_button.png)
		try{
			String os_name=System.getProperty('os.name')
			WebUI.comment 'OS name: '+os_name
			if ( os_name.contains('Mac')){

				Screen s = new Screen()
				if (s.exists(GlobalVariable.G_image_path+'restore_pages_cancel_button.png',1)!=null){
					WebUI.delay(1)
					//s.click(GlobalVariable.G_image_path+'restore_pages_cancel_button.png')
					//WebUI.delay(1)
					Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'restore_pages_cancel_button.png').targetOffset(145,-6)
					//r=s.exists(pImage,1);
					s.click(s.exists(pImage,1), 1)
				}
			}else{
				WebUI.comment 'Only run on Mac'
			}
		}catch (Exception e) {
			WebUI.comment 'opencv: not found restore_pages_cancel_button'
			WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/restore_pages_cancel_button'),1)
			//WebUI.click(findTestObject('Object Repository/Page_Login/restore_pages_cancel_button'))
			//WebUI.comment 'clicked on restore_pages_cancel_button'
		}

	}
	@Keyword
	def check_accept_alert(){
		// check if acceptable alert is showing
		String alertText
		try{
			if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
				alertText=WebUI.getAlertText()
				WebUI.acceptAlert()
				WebUI.comment('accept alert='+alertText)
				if (alertText.contains('Please enter one or more search terms first.')){
					WebUI.comment 'acceptable alert'
				}else{
					KeywordUtil.markFailed('alertText "'+alertText+'" may not be acceptable')
				}
			}
		}catch (Exception e) {
			//WebUI.switchToWindowIndex(0)
			WebUI.delay(2)
			KeywordUtil.markWarning(e.message)
			WebUI.openBrowser('')
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url,FailureHandling.OPTIONAL)
			WebUI.delay(2)
			WebUI.maximizeWindow()
			if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
				alertText=WebUI.getAlertText()
				WebUI.acceptAlert()
				WebUI.comment('accept alert='+alertText)
				if (alertText.contains('Please enter one or more search terms first.')){
					WebUI.comment 'acceptable alert'
				}else{
					KeywordUtil.markFailed('alertText "'+alertText+'" may not be acceptable')
				}
			}
		}

	}

	@Keyword
	public boolean login(String site_url){

		/*if (checkHomePageExist()){
		 WebUI.comment('done checkHomePageExist, already in Home page')
		 return null
		 }
		 String cmd = "pkill -f Chrome"
		 Runtime.getRuntime().exec(cmd)
		 WebUI.comment('killed all processes of Chrome before running test')*/
		////////////////// new //////////////////
		//cmd="killall -9 chromedriver"
		//Runtime.getRuntime().exec(cmd)
		//WebUI.comment('killed all processes of chromedriver before running test')
		//WebUI.delay(1)
		////////////////// new //////////////////
		//Screen s = new Screen()

		try{
			//WebUI.openBrowser('')
			WebUI.navigateToUrl(site_url)
			//WebUI.delay(2)
			//WebUI.maximizeWindow()
			//WebUI.closeWindowIndex(1)
			WebUI.switchToWindowIndex(0)
			WebUI.switchToDefaultContent()
			/*WebDriver driver = DriverFactory.getWebDriver()
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())
			 WebUI.comment("No. of tabs: " + tabs.size())
			 int tabs_number=tabs.size()
			 while (tabs_number>1){
			 WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
			 tabs_number--
			 }*/
		}catch (Exception e) {
			WebUI.openBrowser('')
			WebUI.navigateToUrl(site_url)
			//WebUI.delay(2)
			WebUI.maximizeWindow()
			//WebUI.closeWindowIndex(1)
			WebUI.switchToWindowIndex(0)
			WebUI.switchToDefaultContent()
			WebDriver driver = DriverFactory.getWebDriver()
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())
			WebUI.comment("No. of tabs: " + tabs.size())
			int tabs_number=tabs.size()
			while (tabs_number>1){
				WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
				tabs_number--
			}
			check_restore_pages_popup()
		}

		WebUI.comment('checking input_login_btn')
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),7,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
			if (checkHomePageExist(site_url)){
				WebUI.comment('done checkHomePageExist')
				return true
			}
		}
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		smartcard_login_new()
		//smartcard_login()

		if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn in 2nd attempt')
		}
		// check if alert is showing
		check_accept_alert()
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		WebUI.comment 'Need to try again as it failed to login to site URL '+site_url
		kill_chrome()
		WebUI.openBrowser('')
		WebUI.navigateToUrl(site_url)
		WebUI.maximizeWindow()
		if (WebUI.waitForElementVisible(findTestObject('Page_Login/input_login_btn'),7,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn')
			if (checkHomePageExist(site_url)){
				WebUI.comment('done checkHomePageExist')
				return true
			}
		}
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		WebUI.comment 'try the old way to do smartcard_login'
		smartcard_login()
		if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Page_Login/input_login_btn'))
			WebUI.comment('clicked on input_login_btn in 2nd attempt')
		}
		// check if alert is showing
		check_accept_alert()
		if (checkHomePageExist(site_url)){
			WebUI.comment('done checkHomePageExist')
			return true
		}
		return false
	}
	@Keyword
	def smartcard_login_new(){
		// take care the smartcard login sequence
		String os_name=System.getProperty('os.name')
		WebUI.comment 'OS name: '+os_name
		if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),17,FailureHandling.OPTIONAL)){
			WebUI.delay(1)
			try{
				WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),5,FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(1)
				WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
				WebUI.delay(1)
				WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
				WebUI.comment 'clicked on Page_Login/smartcard_login_button'
				/////////////////////////////////////
				WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),8,FailureHandling.STOP_ON_FAILURE)
				WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
				WebUI.comment 'clicked on acceptCert_ok_button'
				/////////////////////////////////////
				WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/pin_field_empty'),5,FailureHandling.OPTIONAL)
				WebUI.comment 'found pin_field_empty'
				WebUI.delay(1)
				WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/pin_field_empty'),5,FailureHandling.OPTIONAL)
				WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
				WebUI.delay(1)
				WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
				WebUI.comment 'typed PIN in pin_field_empty'
				WebUI.comment 'the login should be done and suceesfully, need to check the Home page exists?'
			}catch (Exception e) {
				WebUI.comment 'something wrong in launchpad login'
				e.printStackTrace()

			}
		}else{
			WebUI.comment 'Not found Launchpad login button, maybe OK'
		}
		return

	}
	@Keyword
	def smartcard_login(){
		// take care the smartcard login sequence
		String os_name=System.getProperty('os.name')
		WebUI.comment 'OS name: '+os_name
		if ( ! os_name.contains('Mac')){
			WebUI.comment 'this is not a Mac machine, so could be Windows'
			if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),17,FailureHandling.OPTIONAL)){
				WebUI.delay(1)
				try{
					WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),5,FailureHandling.STOP_ON_FAILURE)
					WebUI.delay(1)
					WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
					WebUI.delay(1)
					WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
					WebUI.comment 'clicked on Page_Login/smartcard_login_button'
					/////////////////////////////////////
					WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),8,FailureHandling.STOP_ON_FAILURE)
					WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
					WebUI.comment 'clicked on acceptCert_ok_button'
					/////////////////////////////////////
					WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/pin_field_empty'),5,FailureHandling.OPTIONAL)
					WebUI.comment 'found pin_field_empty'
					WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
					WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
					WebUI.comment 'typed PIN in pin_field_empty'
					WebUI.comment 'the login should be done and suceesfully, need to check the Home page exists?'
				}catch (Exception e) {
					WebUI.comment 'something wrong in launchpad login'
					e.printStackTrace()

				}
			}else{
				WebUI.comment 'Not found Launchpad login button, maybe OK'
			}
			return
		}
		//////////////////////////////////////////////////////////////////
		// only run if OS is Mac
		if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),17,FailureHandling.OPTIONAL)){
			try{
				Screen s = new Screen()
				//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
				WebUI.waitForPageLoad(6)
				WebUI.delay(1)
				WebUI.comment('found button input_SCLOGIN from Access Launchpad')
				Pattern smartcard_login_button = new Pattern(GlobalVariable.G_image_path + 'smartcard_login_button.png').similar(0.6)
				Pattern acceptCert_ok_button = new Pattern(GlobalVariable.G_image_path + 'acceptCert_ok_button.png').similar(0.6)
				for (int i = 0; i <3; i++) {
					if (s.exists(smartcard_login_button,(5-i*2))!=null){
						s.click(smartcard_login_button)
						WebUI.comment 'openCV: found smartcard_login_button and click on it'
					}else{
						WebUI.comment '!!! openCV: not found smartcard_login_button'
						try {
							WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),1,FailureHandling.STOP_ON_FAILURE)
							WebUI.comment 'found Page_Login/smartcard_login_button'
							WebUI.delay(3)
							WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
							WebUI.delay(1)
							WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
							WebUI.comment 'clicked on Page_Login/smartcard_login_button'
						} catch (Exception e) {
							WebUI.comment '!!! waitForImagePresent: not found Page_Login/smartcard_login_button'
							e.printStackTrace()
						}
					}
					if (s.exists(acceptCert_ok_button,(7-i*2))!=null){
						s.click(acceptCert_ok_button)
						WebUI.comment 'openCV: found acceptCert_ok_button and clicked on it'
						WebUI.delay(1)
					}else{
						WebUI.comment '!!! openCV: not found acceptCert_ok_button, try again'
						if (s.exists(smartcard_login_button,(5-i*2))!=null){
							s.click(smartcard_login_button)
							WebUI.comment 'openCV: found smartcard_login_button and click on it'
							if (s.exists(acceptCert_ok_button,(5-i*2))!=null){
								WebUI.comment 'openCV: found acceptCert_ok_button and clicked on it'
								s.click(acceptCert_ok_button)
							}
						}else{
							try {
								WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),1,FailureHandling.STOP_ON_FAILURE)
								WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
								WebUI.comment 'clicked on Page_Login/acceptCert_ok_button'
							} catch (Exception e) {
								WebUI.comment '!!! waitForImagePresent: not found Page_Login/acceptCert_ok_button'
								e.printStackTrace()
							}
						}
					}

					//WebUI.delay(1)
					if ((s.exists(smartcard_login_button,1)!=null)||
					(s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',(5-i*2))!=null)||
					(s.exists(GlobalVariable.G_image_path+'activID_ActivClient.png',1)!=null)||
					(s.exists(GlobalVariable.G_image_path+'pin_field_empty.png',1)!=null)
					){
						WebUI.comment 'openCV: found smartcard_login_button at the end of login sequence'
						if (s.exists(GlobalVariable.G_image_path+'pin_field_activID.png',(5-i*2))!=null){
							WebUI.comment('found on pin_field_activID, so enter the PIN for the user')
							s.type(GlobalVariable.G_userPin+"\n")
							break
						}else if (s.exists(GlobalVariable.G_image_path+'activID_ActivClient.png',1)!=null){
							WebUI.comment('found activID_ActivClient, so enter the PIN for the user')
							WebUI.delay(1)
							s.type(GlobalVariable.G_userPin+"\n")
							break
						}else if (s.exists(GlobalVariable.G_image_path+'pin_field_empty.png',1)!=null){
							WebUI.comment('found pin_field_empty, so enter the PIN for the user')
							s.type(GlobalVariable.G_userPin+"\n")
							break
						}else{
							WebUI.comment('Not found pin_field_empty, still enter the PIN for the user just in case')
							s.type(GlobalVariable.G_userPin+"\n")
							break
						}
					}else if (checkHomePageExist()){
						WebUI.comment('done checkHomePageExist')
						return null
					}

					else{
						WebUI.comment '!!! openCV: not found smartcard_login_button at the end of login sequence'
						try{
							WebUI.delay(1)
							WebUI.waitForImagePresent(findTestObject('Page_Login/smartcard_login_button'),5,FailureHandling.STOP_ON_FAILURE)
							WebUI.delay(1)
							WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
							WebUI.delay(1)
							WebUI.clickImage(findTestObject('Page_Login/smartcard_login_button'))
							WebUI.comment 'clicked on Page_Login/smartcard_login_button'
							/////////////////////////////////
							WebUI.waitForImagePresent(findTestObject('Page_Login/acceptCert_ok_button'),5,FailureHandling.STOP_ON_FAILURE)
							WebUI.clickImage(findTestObject('Page_Login/acceptCert_ok_button'))
							WebUI.comment 'clicked on acceptCert_ok_button'
							/////////////////////////////////
							WebUI.waitForImagePresent(findTestObject('Object Repository/Page_Login/pin_field_empty'),10,FailureHandling.OPTIONAL)
							WebUI.comment 'found pin_field_empty'
							WebUI.clickImage(findTestObject('Page_Login/pin_field_empty'))
							WebUI.typeOnImage(findTestObject('Page_Login/pin_field_empty'), GlobalVariable.G_userPin+"\n")
							WebUI.comment 'typed PIN in pin_field_empty'
						} catch (Exception e) {
							WebUI.comment 'not found Page_Login/pin_field_empty'
							e.printStackTrace()
							if (s.exists(GlobalVariable.G_image_path+'activID_ActivClient.png',(5-i*2))!=null){
								WebUI.comment('found activID_ActivClient, so enter the PIN for the user')
								WebUI.delay(1)
								s.type(GlobalVariable.G_userPin+"\n")
								break
							}else if (s.exists(GlobalVariable.G_image_path+'pin_field_empty.png',1)!=null){
								WebUI.comment('found pin_field_empty, so enter the PIN for the user')
								s.type(GlobalVariable.G_userPin+"\n")
								break
							}else{
								WebUI.comment('Not found pin_field_empty, still enter the PIN for the user just in case')
								s.type(GlobalVariable.G_userPin+"\n")
								break
							}
						}
					}
				}
			}catch (Exception e) {
				KeywordUtil.markFailedAndStop(e.message)
			}
		}
	}
}

