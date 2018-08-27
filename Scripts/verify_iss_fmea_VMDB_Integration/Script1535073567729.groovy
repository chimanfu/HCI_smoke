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

println('Only for iss_fmea: Basic FMEA tab -> VMDB Integration')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_fmea')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 2769')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_fmea_dev/show_bug.cgi?id=2769#tv=Basic%20FMEA')

println('from the Basic FMEA Tab')
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/div_Basic FMEA'),15)
WebUI.click(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/div_Basic FMEA'))


WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/span_VMDB Linkable Fields'), 3)

println('verify VMDB Linkable Fields')
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/span_VMDB Linkable Fields'),10)
WebUI.delay(1)

println('click on ORU Part Number field to open up search')
WebUI.click(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/input_cf_oruassemblynum'))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Page_FMEA 2769 MANIFOLD ASSEMBLY VE/input_cf_oruassemblynum'), Keys.chord(Keys.ENTER))
println('check Current Dataset search result')
WebUI.verifyElementPresent(findTestObject('Page_FMEA 2769 MANIFOLD ASSEMBLY VE/span_Current Dataset search result'),5)

println('verify not seeing ERROR: sqlQuery:SQLParser.parse: malformed sql')
WebUI.verifyElementNotVisible(findTestObject('Page_FMEA 2769 MANIFOLD ASSEMBLY VE/em_sqlQuerySQLParser.parse ERROR'))



