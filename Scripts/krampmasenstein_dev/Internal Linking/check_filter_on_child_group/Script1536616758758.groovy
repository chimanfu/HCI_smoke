import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'helper.login.LoginHelper.login'()

// open a child group
CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_record_G2G_linking/div_CHLD-1 GROUP-1_CHLD-1'))

// select 'Reuse Linked Parent' link
WebUI.click(findTestObject('Page_record_G2G_linking/a_Reuse Linked Parent'))
	
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/h4_Link Parent Linking Group'),10)

// check filter on unmatched search term
WebUI.setText(findTestObject('Page_record_G2G_linking/input_groupLinkFilter'), 'unmatch\n')

WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_msg_Showing 0 of 2 unmatched'),10)


// check filter on matched search term
WebUI.setText(findTestObject('Page_record_G2G_linking/input_groupLinkFilter'), 'group\n')

WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_msg_Showing 2 of 2 matched'),10)


// cancel the dialog
WebUI.click(findTestObject('Page_record_G2G_linking/button_Cancel'))