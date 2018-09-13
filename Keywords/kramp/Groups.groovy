package kramp

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

public class Groups {
	@Keyword
	def select_TAB_Groups(){
		// goto Tab Groups
		WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
		WebUI.delay(2)
		WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Groups'),10)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Groups'),10)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_Groups'))
	}
	@Keyword
	def create_3_static_groups(){
		// create 3 (STATIC) groups from Non-Sortable Field Group
		WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/div_Non-Sortable Field Group'),15)
		WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_1'), 'Group1')
		WebUI.click(findTestObject('Page_record_G2G_linking/button_Add STATIC-2'))
		WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_2'), 'Group2')
		WebUI.click(findTestObject('Page_record_G2G_linking/button_Add STATIC-3'))
		WebUI.setText(findTestObject('Page_record_G2G_linking/input_cf_groups_static_text_NEW_ROW_3'), 'Group3')
		//CustomKeywords.'kramp.Internal_Linking.save_changes'()
		//	WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
		//	WebUI.delay(3)
		//	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
	}
	@Keyword
	def delete_3_static_groups(){
		WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-1 Group1'))

		WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)2'))
		
		WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-2 Group2'))
		
		WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)3'))
		
		WebUI.click(findTestObject('Page_record_G2G_linking/div_STATIC-3 Group3'))
		
		WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)4'))
		
	}
}
