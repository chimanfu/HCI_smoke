if (GlobalVariable.testrun_status.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//CustomKeywords.'helper.login.LoginHelper.login'()

// assume it's already in Create New Record view

//boolean is_new_record=true   // test on new record or existing record for the person fields
new_record_person_field="//div[@id='create_fields']/div[@id='field_set_Basic_Information']//input[@autocomplete = 'off']"
created_record_person_field="//div[@class='personLink']/span[@class='PersonContainer']/span[@class='input-group']/input[@type = 'text' and @class = 'form-control ui-autocomplete-input']"
String xpath_person_field
if (is_new_record) {
	xpath_person_field=new_record_person_field
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/input_Create New Record'),10,FailureHandling.STOP_ON_FAILURE)
	
}else {
	xpath_person_field=created_record_person_field
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),10,FailureHandling.STOP_ON_FAILURE)
	
}
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> elements = driver.findElements(By.xpath(xpath_person_field))
int size=elements.size()
String search_name='joseph.fu@nasa.'
String found_name
WebUI.comment('number of person fields found on page = '+size)
for (int i = 0; i < size; i++) {
	if(	elements.get(i).isDisplayed()){
		//elements.get(i).click()
		elements.get(i).clear()
		elements.get(i).sendKeys(search_name)
		WebUI.delay(2)
		elements.get(i).sendKeys('\n')
		WebUI.delay(1)
		found_name=elements.get(i).getAttribute("value")
		if (found_name.contains(search_name)){
			KeywordUtil.markPassed 'name found in person field '+i+': '+found_name+', it matches with the search name: '+search_name
		}else{
			KeywordUtil.markFailed 'name found in person field '+i+': '+found_name+', it does not matche with the search name: '+search_name
		
		}
	}
}	
// should not save the change
CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
