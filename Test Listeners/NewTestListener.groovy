import org.sikuli.script.Screen;

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	KeywordLogger log = new KeywordLogger()
	
	@BeforeTestCase
	def testListenerBeforeTestCase(TestCaseContext testCaseContext) {
		
		/////////////////////////////////////////////////////////////
		//redefine the ActivID ActivClient pin (keychain pin) for the machine when using smartcard to login
		//GlobalVariable.G_userPin='12345678'
		/////////////////////////////////////////////////////////////
		
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','RUN')
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('setEncryptedText','1005')
		(new hci_smoke_test.common()).checkText()
		//GlobalVariable.G_image_path='opencv_images/'
		//GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'
		GlobalVariable.G_image_path= (new File("Include/opencv_images/").absolutePath)+'/'
		GlobalVariable.userPin2='RUN'
		WebUI.comment 'Execution Profile: '+RunConfiguration.getExecutionProfile()
		String testcaseName=testCaseContext.getTestCaseId()
		WebUI.comment 'Testcase name: '+testcaseName
		WebUI.comment 'Site URL: '+GlobalVariable.G_MAKE_MAS_url
		testcaseName=testcaseName.substring(testcaseName.lastIndexOf('/')+1)
		GlobalVariable.recordName1=testcaseName
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testcaseName',testcaseName)
		if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
			if (testcaseName.contains('login_basic_checks') || 
				testcaseName.contains('verify_all_new_record_pages_loading') ||
				testcaseName.contains('verify_generate_PDF_from_record_page') ||
				testcaseName.contains('verify_run_keyword_search') ||
				testcaseName.contains('verify_permittedBrowsers') ||
				testcaseName.contains('verify_dagger_linking_config') ||
				testcaseName.contains('verify_daggr_server') ||
				testcaseName.contains('verify_bad_browser_blurb') ||
				testcaseName.contains('verify_correct_git_hash') ||
				testcaseName.contains('verify_correct_tag') ||
				testcaseName.contains('verify_disallow_record_modification_checked') ||
				testcaseName.contains('verify_help_documentation_loads') ||
				testcaseName.contains('verify_run_saved_search') ||
				testcaseName.contains('verify_run_keyword_search') ||
				testcaseName.contains('verify_mail_search_result_to_team_member') ||
				testcaseName.contains('run_sanityCheck')
				){
				log.logInfo("OK to run testcase: "+testcaseName)
			}else{
				log.logNotRun("NOT run testcase: "+testcaseName)
				GlobalVariable.userPin2='SKIP'
				CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
			}
		}	
		if (GlobalVariable.userPin3.equals('SKIP')){
			log.logNotRun("NOT run testcase: "+testcaseName)
			GlobalVariable.userPin2='SKIP'
			CustomKeywords.'ip_permissions.utils.addGlobalVariable'('testrun_status','SKIP')
		}
		//println testCaseContext.getTestCaseVariables()
		//String cmd = "p3  -f Chrome"
		//Runtime.getRuntime().exec(cmd)
		//String cmd="killall -9 chromedriver"
		//Runtime.getRuntimuuyuyuyuyuyuyuyuyuyuuuyuyuye().exec(cmd)
		//CustomKeywords.'helper.login.LoginHelper.login'()
		WebUI.comment('--------------------------------------TEST RUN Start-------------------------------------------------------------------------------------------')		
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def testListenerAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.comment('--------------------------------------TEST RUN End-------------------------------------------------------------------------------------------')		
		//WebUI.comment 'userPin2: '+ GlobalVariable.userPin2
		
		if (GlobalVariable.userPin2.equals('SKIP')||GlobalVariable.testrun_status.equals('SKIP')){
			WebUI.comment 'testcase is skipped'
			//GlobalVariable.userPin2='RUN'
			return
		}
		def driver = DriverFactory.getWebDriver()
		//println testCaseContext.getTestCaseId()
		String testcaseName=testCaseContext.getTestCaseId()
		testcaseName=testcaseName.substring(testcaseName.lastIndexOf('/')+1)
		WebUI.comment 'Execution Profile: '+RunConfiguration.getExecutionProfile()
		WebUI.comment 'Testcase Name: '+testcaseName
		WebUI.comment 'Site URL: '+GlobalVariable.G_MAKE_MAS_url
		WebUI.comment 'Current URL: '+WebUI.getUrl()
		WebUI.comment 'Test Status: '+ testCaseContext.getTestCaseStatus()
		//String yourValue = WebUI.callTestCase(findTestCase(testCaseContext.getTestCaseId(),[key1:value1]))
		//WebUI.comment 'yourValue: '+yourValue
		if (GlobalVariable.userPin2.equals('ScreenshotTaken')||GlobalVariable.testrun_status.equals('ScreenshotTaken')){
			WebUI.comment 'Screenshot already taken, skip taking Screenshot '
			//GlobalVariable.userPin2='RUN'
		}else{
			CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshotStatus'(testcaseName,testCaseContext.getTestCaseStatus())
			//GlobalVariable.userPin2='RUN'
			}
		if ((!testCaseContext.getTestCaseStatus().equals('PASSED'))|| (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet'))){
			try{
				
				/*int i=0
				while (WebUI.getWindowIndex()>0){
					WebUI.closeWindowIndex(WebUI.getWindowIndex(),FailureHandling.CONTINUE_ON_FAILURE)
					i++
					if (i>6) break
				}*/
				WebUI.switchToDefaultContent()
				WebUI.switchToWindowIndex(0)
				//WebUI.switchToWindowIndex(0)
				//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				//WebUI.closeWindowIndex(1,FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.switchToWindowIndex(0)
				
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				println("No. of tabs: " + tabs.size());
				int tabs_number=tabs.size()
				while (tabs_number>1){
					WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
					tabs_number--
				}
				
			}catch (Exception e) {
				//WebUI.switchToWindowIndex(0)
				//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				println('cannot closeWindowIndex')
				KeywordUtil.markWarning(e.message)
			}
			//WebUI.switchToWindowIndex(0)
			//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
		}
		//WebUI.switchToWindowIndex(0)
		//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)

	}
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
	def kill_chromedriver(){
		String cmd
		if (System.getProperty('os.name').contains('Mac')){
			cmd = "killall -9 chromedriver"
		}else{
			cmd = 'taskkill /IM chromedriver.exe /F'
		}
		Runtime.getRuntime().exec(cmd)
		WebUI.comment('killed all processes of chromedriver')
	}
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.comment 'TestSuite Name: '+ testSuiteContext.getTestSuiteId()
		kill_chrome()
		kill_chromedriver()
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('passed_PDF_diff_report',false)
		CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)
		
		Screen s = new Screen();
		//GlobalVariable.G_image_path='opencv_images/'
		//GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'
		GlobalVariable.G_image_path= (new File("Include/opencv_images/").absolutePath)+'/'
		//GlobalVariable.G_wait_s=0 // failed_case count from running the test suite	
		if (s.exists(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png',1)!=null){
			s.click(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png')
			println('found KatalonNetworkConnections_deny_button and taken care of it')
		}			
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.comment 'TestSuite Name: '+ testSuiteContext.getTestSuiteId()
	}
}