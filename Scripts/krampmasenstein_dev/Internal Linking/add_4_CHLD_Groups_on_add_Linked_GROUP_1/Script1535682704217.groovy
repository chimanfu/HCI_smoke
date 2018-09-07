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


// add_4_CHLD Groups  GROUP_PRNT-1



WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_child_text_NEW_ROW_1'), 'GROUP-1_CHLD-1')

WebUI.click(findTestObject('Page_record_G2G_linking/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_NEW_ROW_3'), 'GROUP_PRNT-1')

WebUI.click(findTestObject('Page_record_G2G_linking/button_Done'))

WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))

WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'))

WebUI.click(findTestObject('Page_record_G2G_linking/button_Add CHLD-2'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_child_text_NEW_ROW_2'),
'GROUP-1_CHLD-2')

WebUI.click(findTestObject('Page_record_G2G_linking/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_NEW_ROW_4'),
'GROUP_PRNT-1')

WebUI.click(findTestObject('Page_record_G2G_linking/button_Done'))

WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))

WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'))


WebUI.click(findTestObject('Page_record_G2G_linking/button_Add CHLD-3'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_child_text_NEW_ROW_3'),
'GROUP-1_CHLD-3')

WebUI.click(findTestObject('Page_record_G2G_linking/a_Add Linked Parent'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_NEW_ROW_5'),
'GROUP_PRNT-1')

WebUI.click(findTestObject('Page_record_G2G_linking/button_Done'))

WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))

// GROUP-1_CHLD-4 on GROUP_PRNT-1
WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'))

WebUI.click(findTestObject('Page_record_G2G_linking/button_Add CHLD-4'))
WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_child_text_NEW_ROW_4'),
'GROUP-1_CHLD-4')
WebUI.click(findTestObject('Page_record_G2G_linking/a_Add Linked Parent'))
WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_NEW_ROW_6'),
'GROUP_PRNT-1')
WebUI.click(findTestObject('Page_record_G2G_linking/button_Done'))
WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
