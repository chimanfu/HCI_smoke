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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.stringtemplate.v4.compiler.CodeGenerator.region_return
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.switchToWindowIndex(0)
String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information'
WebUI.navigateToUrl(test_automation_record_G2G_linking)

//add_4_CHLD_Groups_on_add_Linked_GROUP_2()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-5'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_5'), 'GROUP-2_CHLD-1')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_7'), 'GROUP_PRNT-2')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Done'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))

WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))


WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-6'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_6'),
	'GROUP-2_CHLD-2')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_8'),
	'GROUP_PRNT-2')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Done'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))


WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))


WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-7'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_7'),
	'GROUP-2_CHLD-3')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_9'),
	'GROUP_PRNT-2')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Done'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))


WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))


WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-8'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_8'),
	'GROUP-2_CHLD-4')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_parent_text_NEW_ROW_10'),
	'GROUP_PRNT-2')

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Done'))

WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
