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

if (!(GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard'))) {
    WebUI.comment('Skip this testcase as this is a specific testcase for a specific site')

    WebUI.comment('Skip this testcase')

    GlobalVariable.userPin2 = 'SKIP'

    return null
}

CustomKeywords.'helper.login.LoginHelper.login'()

String recordID = '8265'

String siteURL = GlobalVariable.G_MAKE_MAS_url

if (!(siteURL.endsWith('/'))) {
    siteURL = (siteURL + '/')
}

siteURL = ((siteURL + 'show_bug.cgi?id=') + recordID)

WebUI.navigateToUrl(siteURL)

WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/div_Basic Information'))

WebUI.scrollToElement(findTestObject('Page_Record_8265_react_iss_hazard/div_Hardware'),15)

WebUI.click(findTestObject('Page_Record_8265_react_iss_hazard/label_VMDB Linkable Fields'))

WebUI.setText(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), '500')

WebUI.sendKeys(findTestObject('Page_Record_8265_react_iss_hazard/input_cf_rh_part_number_NEW_RO'), Keys.chord(
        Keys.ENTER))

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/errorMsg_sqlQuerySQLParser'),5)){
	throw new AssertionError('ERROR: found error Msg -> sqlQuery:SQLParser.parse: malformed sql')
}
