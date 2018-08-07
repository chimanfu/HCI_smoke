import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.python.antlr.PythonParser.raise_stmt_return
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
 * need a way to dynamically get all the add new record links on the page
 * then open each link to see if there is js error
 */
//CustomKeywords.'helper.login.LoginHelper.login'()

if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
	println 'this is cp_hazard'
	WebUI.click(findTestObject('Page_Main Page/a_New'))
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

}else if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_oms')){
	WebUI.click(findTestObject('Page_Main Page/a_New'))
	println 'this is cp_oms'

}else if ((GlobalVariable.G_MAKE_MAS_url).contains('arc_praca')){
	println 'this is arc_praca'
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_20gCentrifuge'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ADEPTSR1'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AdvancedRodentHabitat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AirborneSciencesUASProjects'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ArcJet'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Astrobee'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ATD1'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AVA'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BioNutrients'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BioSentinel'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CAP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CellScience'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CHOMPTT'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_COAST'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CodeQS(SystemSafetyandMissio'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CodeRM(AppliedManufacturing)'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CSP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EcAMSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EDSN'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EEL'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_FruitFly'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_GEOCAMSPACE'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_HECC'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ISSPayloads'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LADEE'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LADEEORT'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MEDLI'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MEDLI2MISP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NLAS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NODES'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OOREOS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OrionDFI'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PathfinderTechnologyDemonstr'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PhoneSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PowerCell'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ResourceProspector'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SOFIAProject'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SPHERES'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SporeSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TechEdSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TPSADP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record TPS ADP/a_New'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UTPWindTunnel'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_VMS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_WetLab'))
	
}else if ((GlobalVariable.G_MAKE_MAS_url).contains('iss_hazard')){
	println 'this is iss_hazard'
	CustomKeywords.'hci_smoke_test.create_new_record.iss_hazard'()

}