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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))

WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_New'))

WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_New blank record'))

WebUI.click(findTestObject('Page_Enter Record/a_AdAstraRocketCompany'))

WebUI.setText(findTestObject('Object Repository/Page_Enter Record Ad Astra Rocket C/input_short_desc'), 'test')

WebUI.selectOptionByValue(findTestObject('Page_Enter Record Ad Astra Rocket C/select_from_list'), 
    'Safety Data Package', true)

WebUI.click(findTestObject('Object Repository/Page_Enter Record Ad Astra Rocket C/input_commit'))

WebUI.closeBrowser()

