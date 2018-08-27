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

// ? found connection reset in VMDB Linkable Field of Part Number: 100 ?

println('Only for iss_fmea: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()


WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_dev/show_bug.cgi?id=8265')

WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/div_Basic Information'))

WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/label_Part Number'), 3)

WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/label_Part Number'))

WebUI.setText(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/input_cf_rh_part_number_0'), '100')

WebUI.sendKeys(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/input_cf_rh_part_number_0'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Hazard - Record 8265  IVA Crew/div_VMDB search results'))



