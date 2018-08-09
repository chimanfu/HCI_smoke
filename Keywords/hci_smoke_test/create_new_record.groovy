package hci_smoke_test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable
//import internal.GlobalVariable
//import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.logging.LogEntries as LogEntries
import org.openqa.selenium.logging.LogEntry as LogEntry
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import internal.GlobalVariable as GlobalVariable

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class create_new_record {


	public void appendBrowserLogs() {
		WebDriver driver = DriverFactory.getWebDriver()

		LogEntries logs = driver.manage().logs().get('browser')
		System.out.println('*** js script message ***')

		for (LogEntry logEntry : logs) {
			if (logEntry.getMessage().toLowerCase().contains('error')) {
				System.err.println('Error Message in Console:' + logEntry.getMessage())
			} else if (logEntry.getMessage().toLowerCase().contains('warning')) {
				System.out.println('Warning Message in Console:' + logEntry.getMessage())
			} else {
				System.out.println('Information Message in Console:' + logEntry.getMessage())
			}
		}
		System.out.println('*** js script message ***')
	}

	@Keyword
	public void iss_hazard(){

		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AdAstraRocketCompany'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AISolutions'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AirbusDefenceandSpaceGmbH'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Alcatel'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AlphaSpaceTestResearchAllian'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ARESCorporation'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ASI'))
		appendBrowserLogs()

		return

		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Astrium'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AxiomSpace'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BarriosTechnologyInc.'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Bigelow'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Bionetics'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BIOSERVE'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Boeing'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BoeingPayloads'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_bSpace'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BusinessIntegra'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CalmTechnologiesInc.'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoMissionContract'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoVATVESA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoVCargoDragonSpaceX'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoVCRS2SierraNV'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoVCygnusOrbital'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CargoVHTVJAXA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CASIS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CNES'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ControlledDynamicsInc'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CrewVCrewDragonSpaceX'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CrewVCST100Boeing'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CrewVDreamChaserSierraNV'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CrewVOrionLMCO'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CSA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_DesMoinesCollege'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_DLR'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_DoDJSC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Dynetics'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EADS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ESTECESA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EVAGFE'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_HNUPhotonics'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Honeywell'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_IntuitiveMachines'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ISSLiionBatteriesPWR'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_JAMSSAmericaInc.'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_JAXA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_JETS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_JSCZR'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_KayserItaliaSRL'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_KBRWyle'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Khrunichev'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_KSCFEP'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_L3CincinnatiElectronics'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LASP'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LockheedMartin'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MadeinSpace'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MAPIFlightLeads'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MassachusettsInstituteofTech'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MDA(CSA)'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MDASpaceSystems'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MEITechnologiesInc.'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MSGIntegration'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MunizEngineering'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NANORACKSLLC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAARC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAGRC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAGSFC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAHQ'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAJPL'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAJSC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAKSC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASALaRC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASALaunchServicesProgram'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASALeRC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAMSFC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAWFF'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NASAWSTF'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NRSTPPayloads'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Oceaneering'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OdysseySpaceResearch'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OklahomaStateUniversity'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OrbitalPayloads'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Orbitec'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PSRP_Archive'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_QinetiQNA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISBarrios'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISBioserve'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISBoeing'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISCraig'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISCSS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISLeidos'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISMEI'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISOceaneering'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISSNCOrbitec'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISTBE'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISTechMasters'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISTechshot'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISUTAS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISWyle'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_REMISZin'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_RobonautMobilityUnit'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_RSA'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Sabatier'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SEOPS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SiliconGraphicsInternational'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SouthwestResearchInstitute'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SpaceTango'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_STaARS1'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_STPPayloads'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TBEHouston'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TBEMSFC'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TechshotInc.'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TerminalVelocityAerospace'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ThalesAleniaSpace'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ThinkSpaceConsulting'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TissueGenesisInc'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TSIS'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UAB'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UniversityofMaine'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UniversityofNebraskaLincoln'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_USAF'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UTCAerospaceSystems'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Voxa'))
		appendBrowserLogs()
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ZINTechnologiesInc.'))
		appendBrowserLogs()
	}
}