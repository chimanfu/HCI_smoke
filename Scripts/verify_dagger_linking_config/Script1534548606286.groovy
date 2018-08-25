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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys
import com.mysql.jdbc.StringUtils;

//if (GlobalVariable.G_dagger_server_url.)
println('G_dagger_server_url='+GlobalVariable.G_dagger_server_url)
if (StringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url)){
	println('do not need to run this test')
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Page_Main Page/a_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))
// checking daggr linking parameters

if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Linking Params'),6)){
	println('not found a_DAggr Linking Params, skip the test')
	return
}

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Linking Params'))

// check daggr_linking_user
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration DAggr Linking Pa/dd_The DAggr user who will be'),5)
expected_value_daggr_linking_user='mas_vmdb'
println('check daggr_linking_user value from daggr_linking_user parameter')
value_daggr_linking_user=WebUI.getAttribute(findTestObject('Page_Configuration DAggr Linking Pa/input_daggr_linking_user'), 'value')
println('actual value of permittedBrowsers = '+value_daggr_linking_user)
WebUI.verifyMatch(value_daggr_linking_user, expected_value_daggr_linking_user, false)
println('matched with expected permittedBrowsers value = '+expected_value_daggr_linking_user)

// check daggr_linking_enabled
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration DAggr Linking Pa/dt_daggr_linking_enabled'),1)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration DAggr Linking Pa/input_daggr_linking_enabled'),1)

// check daggr_create_update_link_disabled
WebUI.waitForElementVisible(findTestObject('Page_Configuration DAggr Linking Pa/input_daggr_create_update_link_disabled'),1)



