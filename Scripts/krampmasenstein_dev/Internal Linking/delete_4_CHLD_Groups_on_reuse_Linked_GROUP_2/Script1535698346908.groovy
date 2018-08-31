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

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.switchToWindowIndex(0)

//test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information'
String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'

WebUI.navigateToUrl(test_automation_record_G2G_linking)


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'), 
    20)

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_CHLD-1 GROUP-2_CHLD-1'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'), 
    15)

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_CHLD-1 GROUP-2_CHLD-2'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'), 
    15)

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_CHLD-1 GROUP-2_CHLD-3'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'), 
    15)

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_CHLD-1 GROUP-2_CHLD-4'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_(Delete)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'), 
    15)




