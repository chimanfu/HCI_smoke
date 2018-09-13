import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Basic_Information'()

// On Core Fields
WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// Status
WebUI.click(findTestObject('Page_record_G2G_linking/label_Status'))

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Status'), 'READ-ONLY', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Status'), 'EDITABLE', true)

// Classification
WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Classification'), 'Classification 2', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Classification'), 'Classification 1', true)

// Product
WebUI.click(findTestObject('Page_record_G2G_linking/label_Product'))

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Product'), 'Product 1.2', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Product'), 'Product 1.1', true)

WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// Component
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/label_Component'), 10)

WebUI.click(findTestObject('Page_record_G2G_linking/label_Component'))

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Component'), 'Component 1.1.1', true)

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Component'), 'Component 1.1.2', true)

WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// Analyst
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/label_Analyst'), 10)

WebUI.click(findTestObject('Page_record_G2G_linking/label_Analyst'))

WebUI.click(findTestObject('Page_record_G2G_linking/a_(edit)'))

WebUI.clearText(findTestObject('Page_record_G2G_linking/input_Analyst_assigned_to'))

WebUI.setText(findTestObject('Page_record_G2G_linking/input_Analyst_assigned_to'), 'joseph.fu')

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Page_record_G2G_linking/input_Analyst_assigned_to'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// Record Color
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/label_Record_Color'), 10)

WebUI.click(findTestObject('Page_record_G2G_linking/label_Record_Color'))

WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Record_color'), 'Black', true)

CustomKeywords.'kramp.Internal_Linking.save_changes'()