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


//CustomKeywords.'helper.login.LoginHelper.login'()


WebUI.click(findTestObject('Page_Main Page/a_Help'))
WebUI.delay(1)
//GlobalVariable.G_MAKE_MAS_title
WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
WebUI.delay(1)
//WebUI.waitForPageLoad(5)

if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
	println 'this is cp_hazard'
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/h1_User Guide'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h1_User Guide'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Entering Editing and Viewing'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Entering Editing and Viewing'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Searching Records'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Searching Records'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Charts'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Charts'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Preferences and Privileges'),15)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Preferences and Privileges'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Approvals and Release of Rec'),15)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Approvals and Release of Rec'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Table of Contents'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Table of Contents'))
	
	WebUI.waitForElementClickable(findTestObject('Page_CP-Hazard User Guide/h3_Entering Editing and Viewing'),25)
	WebUI.click(findTestObject('Page_CP-Hazard User Guide/h3_Entering Editing and Viewing'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Searching Records'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Searching Records'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Charts'),25)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Charts'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Preferences and Privileges'),15)
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Preferences and Privileges'))
}
else if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_oms')){
	println 'this is cp_oms'
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h1_CP-OMS User Guide'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Entering Editing and Viewing'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Entering Editing and Viewin'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Searching Records'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Searching Records'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Charts'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Charts'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Preferences and Privileges'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Settings and Permissions'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Approval of Records'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Record Approval'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	
	
}
WebUI.closeWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' Main Page')

//WebUI.click(findTestObject('Page_Main Page/a_Home'))






