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
import org.openqa.selenium.Keys

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Parent'()

// select parent group: PRNT-1  GROUP_PRNT-1
WebUI.click(findTestObject('Page_record_G2G_linking/div_PRNT-1  GROUP_PRNT-1'))
//////////////
// G2G Parent Free Text (URL) Field:
WebUI.click(findTestObject('Page_record_G2G_linking/label_G2G Parent Free Text URL Field'))
WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_url_field'), 
    'url field')
//////////////
// G2G Parent Large Text Field:
WebUI.setText(findTestObject('Page_record_G2G_linking/textarea_G2G Parent Large Text'), 'G2G Parent Large Text field')

//////////////

// add content to G2G Parent Large Text RTF field
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_cf_g2g_parent_large_text_RTF_Field'), 
    10)

WebUI.click(findTestObject('Page_record_G2G_linking/div_cf_g2g_parent_large_text_RTF_Field'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/body_G2G Parent Large Text RTF'), 
    10)

WebUI.setText(findTestObject('Page_record_G2G_linking/body_G2G Parent Large Text RTF'), 'G2G Parent Large RTF field')


//////////////
// select options from 3 drop down menus
WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/label_G2G Parent Select Field'),10)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_data'), 
    'Option 2', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_other_data'), 
    'Option 3', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_radio_data'), 
    'Option 1', true)

///////////////
// G2G Parent Multiselect Field:
WebUI.click(findTestObject('Page_record_G2G_linking/span_G2G Parent Multiselect Field'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'))

// G2G Parent Multiselect (Checkbox) Field:
WebUI.click(findTestObject('Page_record_G2G_linking/span_G2G Parent Multiselect Checkbox Field'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option3'))

///////////////
WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/span_G2G Parent Record Link RecordLevel Field'),10)
WebUI.delay(1)
// G2G Parent Record Link (Record Level) Field:
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), 10)
//WebUI.delay(1)
WebUI.setText(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), Keys.chord(Keys.ENTER))

// G2G Parent Record Link (Autocomplete) Field:
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), 10)
//WebUI.delay(1)
WebUI.setText(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), Keys.chord(Keys.ENTER))

/////////////

CustomKeywords.'kramp.Internal_Linking.save_changes'()


