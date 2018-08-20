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

class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	@BeforeTestCase
	def testListenerBeforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
		//String cmd = "pkill -f Chrome"
		//Runtime.getRuntime().exec(cmd)
		//String cmd="killall -9 chromedriver"
		//Runtime.getRuntime().exec(cmd)
		
		
		
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def testListenerAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		if (testCaseContext.getTestCaseStatus().equals('FAILED')){
			try{
				CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
				WebUI.switchToDefaultContent()
				WebUI.switchToWindowIndex(0)
				int i=0
				while (WebUI.getWindowIndex()>0){
					WebUI.closeWindowIndex(WebUI.getWindowIndex(),FailureHandling.CONTINUE_ON_FAILURE)
					i++
					if (i>5) break
				}
					
				WebUI.switchToWindowIndex(0)
				//WebUI.closeWindowIndex(1,FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.switchToWindowIndex(0)
			}catch (Exception e) {
				WebUI.switchToWindowIndex(0)
				println('cannot closeWindowIndex')
			}
		}

	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
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
		
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
}