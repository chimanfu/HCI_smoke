if (GlobalVariable.testrun_status.equals('SKIP')) return
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

//WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Title_mandatory_field'))
//
//WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Reporting Organization_mandatory_field'))
//
//WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Business Area_mandatory_field'))

// goto Signature and Closure_TAB, then check the Empty Mandatory Fields (26) and Completed Mandatory Field (1)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Signature and Closure_TAB'),5)
WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Signature and Closure_TAB'))
// Empty Mandatory Fields (26)
WebUI.verifyElementVisible(findTestObject('Page_Record_Created/span_Empty Mandatory Fields (26)'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Responsible Organization'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Problem Type'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_ARC Criticality'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Business Area Criticality'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Problem Description'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Occurrence Date'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Occurrence Location'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Defect'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Specific Defect'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Previous Occurrence'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Detection Date'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Detected During'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Analysis POC'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Incident Type'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Reported Date'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Injuries Involved'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Detailed Description'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Recorded By'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Verification(s) - Verification Completed'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Verification(s) - Verification Comment'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Disposition(s) - Disposition Type'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Disposition(s) - Serial Numbers'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Disposition(s) - Remedial  ActionDisposition'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Disposition(s) - MRB Required'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Disposition(s) - MRB Rationale'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Problem Closeout Summary'))

// Completed Mandatory Field (1)
WebUI.verifyElementVisible(findTestObject('Page_Record_Created/span_Completed Mandatory Field (1)'))
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Report Type'),2)){
	WebUI.click(findTestObject('Page_Record_Created/span_Completed Mandatory Field (1)'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Report Type'),2)
}
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Report Type'))