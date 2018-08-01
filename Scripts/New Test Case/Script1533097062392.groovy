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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/arc_praca_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))

/////////
WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_20gCentrifuge'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_ADEPTSR1'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_AdvancedRodentHabitat'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_AirborneSciencesUASProjects'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_ArcJet'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_Astrobee'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_ATD1'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_AVA'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_BioNutrients'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_BioSentinel'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CAP'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CellScience'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CHOMPTT'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_COAST'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CodeQS(SystemSafetyandMissio'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CodeRM(AppliedManufacturing)'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_CSP'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_EcAMSat'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_EDSN'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_EEL'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_FruitFly'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_GEOCAMSPACE'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_HECC'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_ISSPayloads'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_LADEE'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_LADEEORT'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_MEDLI'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_MEDLI2MISP'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_NLAS'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_NODES'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_OOREOS'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_OrionDFI'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_PathfinderTechnologyDemonstr'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_PhoneSat'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_PowerCell'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_ResourceProspector'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_SOFIAProject'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_SPHERES'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_SporeSat'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_TechEdSat'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_TPSADP'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record TPS ADP/a_New'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_UTPWindTunnel'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_VMS'))

WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_WetLab'))



WebUI.click(findTestObject('Page_ARC PRACA Main Page/a_New'))

WebUI.click(findTestObject('Page_Enter Record/a_20gCentrifuge'))

WebUI.selectOptionByValue(findTestObject('Page_Enter Record 20g Centrifuge/select_options'), 
    'AF - Aviation Systems Division', true)

WebUI.closeBrowser()

