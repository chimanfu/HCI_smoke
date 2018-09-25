import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'('something')
return
WebUI.openBrowser('')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7080#tv=Fields')

WebUI.setText(findTestObject('Object Repository/Page_Black 7080 test_automation_rec/input_Free Text Field_cf_text'), 'hello 212345')

WebUI.closeBrowser()

