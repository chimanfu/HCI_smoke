import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Parent'()

// select parent group: PRNT-1  GROUP_PRNT-1
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_PRNT-1  GROUP_PRNT-1'))


///////////////
WebUI.scrollToElement(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/span_G2G Parent Record Link RecordLevel Field'),10)
// G2G Parent Record Link (Record Level) Field:
WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_RecordLevel_field'), 10)

WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_RecordLevel_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_RecordLevel_field'), Keys.chord(Keys.ENTER))

// G2G Parent Record Link (Autocomplete) Field:

WebUI.waitForElementClickable(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_Autocomplete_field'), 10)
WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_Autocomplete_field'), '7080')
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Page_--- 7081 test_automation_recor/input_g2g_parent_record_link_Autocomplete_field'), Keys.chord(Keys.ENTER))



