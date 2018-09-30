import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl('https://mas.nasa.gov/ARC-PRACATraining/enter_bug.cgi?product=20g%20Centrifuge')

if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_2769_FMEA/input_for_uber_search_field'),5){
	WebUI.setText(findTestObject('Object Repository/Page_Record_2769_FMEA/input_for_uber_search_field'), 'link')
	WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input_for_uber_search_field'), Keys.chord(Keys.ENTER))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_2769_FMEA/div_Search Results'),10)
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
return
}