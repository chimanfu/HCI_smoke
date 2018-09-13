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

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Parent'()

// select parent group: PRNT-1  GROUP_PRNT-1
WebUI.click(findTestObject('Page_record_G2G_linking/div_PRNT-2  GROUP_PRNT-2'))

// waitFor Element Not Present on all the input fields and select menu

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_NEW_ROW_1'),1)
WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_url_field'),1)
//WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/body_G2G Parent Large Text RTF'),1)
WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_data'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_other_data'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_radio_data'),1)
WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'),1)

WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'),1)
WebUI.waitForElementNotPresent(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'),1)
return