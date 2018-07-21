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

//WebUI.openBrowser('')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
/*
try{
	// check if alert is showing
	if (WebUI.verifyAlertPresent(1)){
		WebUI.acceptAlert()
		alertText=WebUI.getAlertText()
		println('alertText='+alertText)
	}
}
catch (Exception e) {
	println('ERROR: Unable to verify alert present: ' + e.getMessage())
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
   }
*/
WebUI.click(findTestObject('Page_CP-Hazard Main Page/a_Help'))

WebUI.switchToWindowTitle('CP-Hazard User Guide')

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h1_User Guide (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Entering Editing and Viewing (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Searching Records (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Charts (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Preferences and Privileges (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/a_Approvals and Release of Rec (1)'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Table of Contents (1)'))
WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Entering Editing and Viewin'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Searching Records'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Charts'))

WebUI.click(findTestObject('Object Repository/Page_CP-Hazard User Guide/h3_Preferences and Privileges'))

WebUI.closeWindowTitle('CP-Hazard User Guide')

WebUI.switchToWindowTitle('CP-Hazard Main Page')

WebUI.click(findTestObject('Page_CP-Hazard Main Page/a_Home'))






