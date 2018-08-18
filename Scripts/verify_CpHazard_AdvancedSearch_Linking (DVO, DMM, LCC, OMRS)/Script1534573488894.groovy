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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.KeyModifier
if (!GlobalVariable.G_MAKE_MAS_url.contains('cp_hazard')) {
	return
}
// get record 6505 
CustomKeywords.'helper.login.LoginHelper.login'()

println('advanced search on SLS Integrated Cause')
WebUI.click(findTestObject('Page_Search for records/a_Advanced Search'))

WebUI.click(findTestObject('Page_Search for records/select_product_SLS Integrated Cause'))

WebUI.click(findTestObject('Page_Search for records/input_Search'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record List/a_record_1'),10)
WebUI.click(findTestObject('Object Repository/Page_Record List/a_record_1'))

WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/div_Verifications'),10)
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/div_Verifications'))

WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/img_link_icon_1'),10)
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/img_link_icon_1'))

WebUI.waitForElementClickable(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'),5)
Screen s = new Screen()

println('check DMM linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.UP)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-DMM Linkable Fields'),10)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'DVO', true)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-DMM search results'))

println('check DVO linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_Cradle Linkable Fields'),10)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'LCC', true)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/button_Linked'))

println('check LCC linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-LMS Linkable Fields'),10)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-LMS search results'))

println('check OMRS linking')
WebUI.click(findTestObject('Page_SLS Integrated Causes Record_1/label_Verification Traceability Type'))
WebUI.delay(1)
s.type(Key.SPACE)
WebUI.delay(1)
s.type(Key.DOWN)
WebUI.delay(1)
s.type(Key.SPACE)
//WebUI.selectOptionByValue(findTestObject('Page_SLS Integrated Causes Record_1/select_---DMMDVOLCCOMRS'), 'OMRS', true)
WebUI.waitForElementVisible(findTestObject('Page_SLS Integrated Causes Record_1/label_CP-OMS Linkable Fields'),10)
s.type(Key.TAB)
s.type('Transmission\n')
WebUI.delay(1)
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Cause 6505 Erroneous Transmiss/span_CP-OMS search results'))


s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
