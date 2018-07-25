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
/*
WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
*/

//////


WebUI.click(findTestObject('Page_CP-Hazard Main Page/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Safety Data Package'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Hazard'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Action'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Cause Tree'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

//WebUI.click(findTestObject('Object Repository/Page_Enter Record ES Cause Tree/a_New'))

//WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Cause'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Watch'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_All'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Home'))
CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()



