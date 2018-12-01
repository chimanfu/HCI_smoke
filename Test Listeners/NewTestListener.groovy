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
		GlobalVariable.userPin2='RUN'
		//GlobalVariable.G_image_path='opencv_images/'
		//redefine the ActivID ActivClient pin (keychain pin) for the machine when using smartcard to login
		//GlobalVariable.G_userPin='12345678'
		//GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'
		GlobalVariable.G_image_path= (new File("Include/opencv_images/").absolutePath)+'/'
		WebUI.comment 'Execution Profile: '+RunConfiguration.getExecutionProfile()
		String testcaseName=testCaseContext.getTestCaseId()
		WebUI.comment 'Testcase: '+testcaseName
		GlobalVariable.recordName1=testcaseName.substring(testcaseName.lastIndexOf('/')+1)
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
			}
		}	
		if (GlobalVariable.userPin3.equals('SKIP')){
			log.logNotRun("NOT run testcase: "+testcaseName)
			GlobalVariable.userPin2='SKIP'
		}
		//println testCaseContext.getTestCaseVariables()
		//String cmd = "pkill -f Chrome"
		//Runtime.getRuntime().exec(cmd)
		//String cmd="killall -9 chromedriver"
		//Runtime.getRuntime().exec(cmd)
		//CustomKeywords.'helper.login.LoginHelper.login'()
		WebUI.comment('---------------------------------------------------------------------------------------------------------------------------------')		
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def testListenerAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.comment '---------------------------------------------------------------------------------------------------------------------------------'
		//WebUI.comment 'userPin2: '+ GlobalVariable.userPin2
		def driver = DriverFactory.getWebDriver()
		if (GlobalVariable.userPin2.equals('SKIP')){
			WebUI.comment 'testcase is skipped'
			//GlobalVariable.userPin2='RUN'
			return
		}
		//println testCaseContext.getTestCaseId()
		String testcaseName=testCaseContext.getTestCaseId()
		testcaseName=testcaseName.substring(testcaseName.lastIndexOf('/')+1)
		
		println 'testcaseName: '+testcaseName
		//String yourValue = WebUI.callTestCase(findTestCase(testCaseContext.getTestCaseId(),[key1:value1]))
		//WebUI.comment 'yourValue: '+yourValue
		WebUI.comment 'Test Status: '+ testCaseContext.getTestCaseStatus()
		if (GlobalVariable.userPin2.equals('ScreenshotTaken')){
			println 'Screenshot Taken'
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

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.comment 'TestSuite Name: '+ testSuiteContext.getTestSuiteId()
		String cmd = "pkill -f Chrome"
		//String cmd = 'while pgrep Chrome ; do pkill Chrome ; done'
		Runtime.getRuntime().exec(cmd)
		cmd="killall -9 chromedriver"
		Runtime.getRuntime().exec(cmd)
		println('killed all processes of Chrome and chromedriver before running test')
		
		Screen s = new Screen();
		//GlobalVariable.G_image_path='opencv_images/'
		//GlobalVariable.G_image_path='/Users/jcfu/Katalon Studio/HCI_Group/Include/opencv_images/'
		GlobalVariable.G_image_path= (new File("Include/opencv_images/").absolutePath)+'/'
		GlobalVariable.G_wait_s=0 // failed_case count from running the test suite
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