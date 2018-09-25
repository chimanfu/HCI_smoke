import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase
import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.App;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
/*
class NewTestListener {
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
		
	}

	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		
	}

	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
				
	}

	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
		println testSuiteContext.getStatus()
		
	}
}
*/
/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */

@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	// Put your code here.
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	cmd="killall -9 chromedriver"
	Runtime.getRuntime().exec(cmd)
	println('killed all processes of Chrome and chromedriver before running test')
	
	/*List desiredCapabilities = []
	desiredCapabilities.add("--start-maximized")
	desiredCapabilities.add("--disable-infobars")
	desiredCapabilities.add("--user-data-dir=/Users/jcfu/Library/Application Support/Google/Chrome")
	desiredCapabilities.add("--profile-directory=Default")
	CustomKeywords.'com.common.utils.SetDesiredCapability.chrome'(desiredCapabilities)*/
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = true) // Please change skipped to be false to activate this method.
def tearDown() {
	// Put your code here.
	//WebUI.closeBroswer()
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = true) // Please change skipped to be false to activate this method.
def setupTestCase() {
	println('*** SetupTestCase started ***')
	//println testCaseContext.getTestCaseId()
	Screen s = new Screen();
	
	if (s.exists(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png',1)!=null){
		s.click(GlobalVariable.G_image_path+'KatalonNetworkConnections_deny_button.png')
	}
	if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'), 1, FailureHandling.OPTIONAL)) {
	//if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Configuration NASA Params/a_Home'),1,FailureHandling.OPTIONAL)){
		//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
		WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
		println('found home link, login to MAKE_MAS url succeeded! on '+GlobalVariable.G_MAKE_MAS_url)
		WebUI.waitForPageLoad(30)
		if (WebUI.verifyAlertPresent(1,FailureHandling.OPTIONAL)){
			String alertText=WebUI.getAlertText()
			WebUI.acceptAlert()
			println('accept alert='+alertText)
		}
		println('*** SetupTestCase done ***')
		return
	}
	
	CustomKeywords.'helper.browserhelper.CustomBrowser.openBrowser'()
	//WebUI.openBrowser('')
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
		// cp hazard login
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
	}
	if (WebUI.verifyAlertPresent(1,FailureHandling.OPTIONAL)){
		alertText=WebUI.getAlertText()
		WebUI.acceptAlert()
		println('accept alert='+alertText)
	}
	// check if the restore pages is showing (restore_pages_cancel_button.png)
		if (s.exists(GlobalVariable.G_image_path+'restore_pages_cancel_button.png',1)!=null){
			WebUI.delay(1)
			s.click(GlobalVariable.G_image_path+'restore_pages_cancel_button.png')
		}
	
	if (WebUI.waitForElementClickable(findTestObject('Page_Access Launchpad/input_SCLOGIN'),30,FailureHandling.OPTIONAL)){
		//WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		App.focus('Chrome')
		s.wait(GlobalVariable.G_image_path+'smartcard_login_button.png',35)
		s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
		try {
			s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
			s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
		} catch (Exception e) {
			e.printStackTrace()
		}
		
		WebUI.delay(1)
		if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',12)!=null){
			//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
			s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
		}else if (s.exists(GlobalVariable.G_image_path+'smartcard_login_button.png',1)!=null){
			s.click(GlobalVariable.G_image_path+'smartcard_login_button.png')
			if (s.exists(GlobalVariable.G_image_path+'acceptCert_ok_button.png',10)!=null){
				//s.wait(GlobalVariable.G_image_path+'acceptCert_ok_button.png',15)
				s.click(GlobalVariable.G_image_path+'acceptCert_ok_button.png')
			}
		}
		
		WebUI.delay(4)
		s.type(GlobalVariable.G_userPin+"\n")
		//Runtime.getRuntime().exec("osascript Desktop/typeText.scpt")
		//WebUI.clickImage(findTestObject('Object Repository/Page_Access Launchpad/smartcard_login_button'))
		//WebUI.delay(2)
		//WebUI.clickImage(findTestObject('Object Repository/Page_Access Launchpad/cert_ok_button'))
		//WebUI.delay(2)
		//WebUI.acceptAlert()
	}
	
	
	if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'),1,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Login/input_login_btn'))
	}
	// check if alert is showing
	if (WebUI.verifyAlertPresent(1,FailureHandling.OPTIONAL)){
		alertText=WebUI.getAlertText()
		WebUI.acceptAlert()			
		println('accept alert='+alertText)
	}
	if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),10,FailureHandling.OPTIONAL)){
		//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
		if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
			s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',20)
			println('found cp_hazard_logo')
			println('found home link and cp_hazard_logo, login to cp_hazard succeeded!')
		}
		
		//WebUI.waitForPageLoad(30)
		println('*** SetupTestCase done ***')
	}else{
		println('*** SetupTestCase failed ***')
	}
	WebUI.waitForPageLoad(30)
}

/**
 * Run after each test case ends.
 */

@TearDownTestCase(skipped = true) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	println('*** TearDownTestCase ***')
	// Put your code here.
	CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
	//CustomKeywords.'helper.browserhelper.CustomBrowser.testCaseStatus'()
	/*
	println 'testcase ID = '+TestCase.getTestCaseId()
	println 'testcase status = '+TestCase.getTestCaseStatus()
	println 'testcase variables = '+TestCase.getTestCaseVariables()
	*/
	println('*** TearDownTestCase ***')
}

@TearDownIfError(skipped = true) // Please change skipped to be false to activate this method.
def tearDownIfError() {
	// Put your code here.
	println('*** tearDownIfError ***')
	CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
	try{
		WebUI.switchToDefaultContent()
		WebUI.switchToWindowIndex(0)
		WebUI.closeWindowIndex(1)
		//WebUI.switchToWindowIndex(0)
	}catch (Exception e) {
		//WebUI.switchToWindowIndex(0)
		println('cannot closeWindowIndex')
	}
	//CustomKeywords.'helper.browserhelper.CustomBrowser.testCaseStatus'()
	println('*** tearDownIfError ***')
}
@TearDownIfFailed(skipped = true) // Please change skipped to be false to activate this method.
def tearDownIfFailed() {
	// Put your code here.
	println('*** tearDownIfFailed ***')
	CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
	try{
		WebUI.switchToDefaultContent()
		WebUI.switchToWindowIndex(0)
		WebUI.closeWindowIndex(1)
		//WebUI.switchToWindowIndex(0)
	}catch (Exception e) {
		//WebUI.switchToWindowIndex(0)
		println('cannot closeWindowIndex')
	}
	//CustomKeywords.'helper.browserhelper.CustomBrowser.testCaseStatus'()
	println('*** tearDownIfFailed ***')
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */