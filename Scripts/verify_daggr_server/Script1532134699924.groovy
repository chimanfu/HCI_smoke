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
import com.mysql.jdbc.StringUtils;

/*
 * 
 * goto Admin->Parameters->DAggr Params
 * check value of daggr_server from profile (G_dagger_server_url)
 * will skip test if G_dagger_server_url is empty
 * 
 */

//CustomKeywords.'helper.login.LoginHelper.login'()

//if (GlobalVariable.G_dagger_server_url.)
if (!StringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url)){
	println('do not need to run this test')
	return
}
WebUI.click(findTestObject('Page_Main Page/a_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_DAggr Params'))

WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dt_daggr_server'))

WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/dd_The URL of the DAggr server'))

value_dagger_server=WebUI.getAttribute(findTestObject('Object Repository/Page_Configuration DAggr Params/input_daggr_server'), 'value')

println('value of value_dagger_server = '+value_dagger_server)

//GlobalVariable.G_dagger_server_url='https://dig-it-dev.nas.nasa.gov/dig_it-server/services/'
WebUI.verifyMatch(value_dagger_server, GlobalVariable.G_dagger_server_url, false)

//WebUI.click(findTestObject('Object Repository/Page_Configuration DAggr Params/a_Home'))


