if (GlobalVariable.userPin2.equals('SKIP')) return
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
//analytics_site_view=siteURL+'/editparams.cgi?section=nasa#analytics_site_url_desc'
insidergroup_desc=siteURL+'/editparams.cgi?section=groupsecurity#insidergroup_desc'

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.navigateToUrl(insidergroup_desc)

if (!WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Configuration Group Security/dt_insidergroup_desc'),5)){
	KeywordUtil.markWarning('dt_insidergroup_desc not found in Page_Configuration Group Security, so skip the test')
	return
}
WebUI.comment 'checking insidergroup = U.S. Persons'
WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Page_Configuration Group Security/select_insidergroup_option'), 'U.S. Persons', false, 1)
WebUI.comment 'PASS: insidergroup_desc check'





