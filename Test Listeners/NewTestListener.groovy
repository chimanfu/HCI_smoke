import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.App;
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import java.util.Map
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

class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	KeywordLogger log = new KeywordLogger()
	
	@BeforeTestCase
	def testListenerBeforeTestCase(TestCaseContext testCaseContext) {
		WebUI.comment 'Execution Profile: '+RunConfiguration.getExecutionProfile()
		WebUI.comment 'Testcase: '+testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseVariables()
		
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
		if (GlobalVariable.userPin2.equals('SKIP')){
			WebUI.comment 'testcase is skipped'
			GlobalVariable.userPin2='RUN'
			return
		}
		//println testCaseContext.getTestCaseId()
		String testcaseName=testCaseContext.getTestCaseId()
		testcaseName=testcaseName.substring(testcaseName.indexOf('/')+1)
		//println testcaseName
		//String yourValue = WebUI.callTestCase(findTestCase(testCaseContext.getTestCaseId(),[key1:value1]))
		//WebUI.comment 'yourValue: '+yourValue
		WebUI.comment 'Test Status: '+ testCaseContext.getTestCaseStatus()
		if (GlobalVariable.userPin2.equals('ScreenshotTaken')){
			println 'Screenshot Taken'
			GlobalVariable.userPin2='RUN'
		}else{
			CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshotStatus'(testcaseName,testCaseContext.getTestCaseStatus())
			GlobalVariable.userPin2='RUN'
			}
		if (!testCaseContext.getTestCaseStatus().equals('PASSED')){
			try{
				WebUI.switchToDefaultContent()
				WebUI.switchToWindowIndex(0)
				int i=0
				while (WebUI.getWindowIndex()>0){
					WebUI.closeWindowIndex(WebUI.getWindowIndex(),FailureHandling.CONTINUE_ON_FAILURE)
					i++
					if (i>5) break
				}
					
				//WebUI.switchToWindowIndex(0)
				//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				//WebUI.closeWindowIndex(1,FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.switchToWindowIndex(0)
			}catch (Exception e) {
				//WebUI.switchToWindowIndex(0)
				//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
				println('cannot closeWindowIndex')
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
		Runtime.getRuntime().exec(cmd)
		cmd="killall -9 chromedriver"
		Runtime.getRuntime().exec(cmd)
		println('killed all processes of Chrome and chromedriver before running test')
		
		Screen s = new Screen();
		
		if (s.exists(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png',1)!=null){
			s.click(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png')
			println('found KatalonNetworkConnections_deny_button and taken care of it')
		}
		//redefine the ActivID ActivClient pin (keychain pin) for the machine when using smartcard to login
		//GlobalVariable.G_userPin='12345678'
		
		
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