import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_record_G2G_linking/div_CHLD-1 GROUP-1_CHLD-1'))

//////////////
// G2G Child Free Text (URL) Field:
WebUI.click(findTestObject('Page_record_G2G_linking/label_G2G Parent Free Text URL Field'))
WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_text_url_field'),
	'child url field')
//////////////
// G2G Child Large Text Field:
WebUI.setText(findTestObject('Page_record_G2G_linking/textarea_G2G Parent Large Text'), 'G2G Child Large Text field')

//////////////

// add content to G2G Child Large Text RTF field
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_cf_g2g_parent_large_text_RTF_Field'),
	10)

WebUI.click(findTestObject('Page_record_G2G_linking/div_cf_g2g_parent_large_text_RTF_Field'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/body_G2G Parent Large Text RTF'),	10)

WebUI.setText(findTestObject('Page_record_G2G_linking/body_G2G Parent Large Text RTF'), 'G2G Child Large RTF field')


//////////////
// select options from 3 drop down menus
WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/label_G2G Parent Select Field'),10)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_data'),	'Option 2', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_other_data'),  'Option 3', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_g2g_parent_select_radio_data'), 'Option 1', true)

///////////////
// G2G Child Multiselect Field:
WebUI.click(findTestObject('Page_record_G2G_linking/span_G2G Parent Multiselect Field'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselect_Option3'))

// G2G Child Multiselect (Checkbox) Field:
WebUI.click(findTestObject('Page_record_G2G_linking/span_G2G Parent Multiselect Checkbox Field'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option1'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option2'))

WebUI.click(findTestObject('Page_record_G2G_linking/input_cf_g2g_parent_multiselectCheckbox_Option3'))

///////////////
WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/span_G2G Parent Record Link RecordLevel Field'),10)
WebUI.delay(1)
// G2G Child Record Link (Record Level) Field:
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), 10)
//WebUI.delay(1)
WebUI.setText(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_RecordLevel_field'), Keys.chord(Keys.ENTER))

// G2G Child Record Link (Autocomplete) Field:
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), 10)
//WebUI.delay(1)
WebUI.setText(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_record_G2G_linking/input_g2g_parent_record_link_Autocomplete_field'), Keys.chord(Keys.ENTER))

/////////////

CustomKeywords.'kramp.Internal_Linking.save_changes'()

return



