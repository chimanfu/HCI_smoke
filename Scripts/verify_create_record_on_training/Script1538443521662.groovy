import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

///////// create a new record for the training site
search_term = 'test_create_record_on_training'
//search_term = 'test'
if ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training')){
	WebUI.comment 'this is a training site, so trying to create a new record'
	//WebUI.comment 'navigate to the first create new record link from the list (should be less mandatory required fields), which is '+urls[0]
	//WebUI.navigateToUrl(urls[0])
	WebUI.delay(1)
	WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_short_desc'),15)
	WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)

	if (GlobalVariable.G_MAKE_MAS_url.contains('ARC-PRACA')){
		WebUI.comment 'check Title_required_field, Business Area_required_field and Reporting Organization_required_field'
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Title_required_field'))
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Reporting Organization_required_field'))
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Business Area_required_field'))
		
	}
		
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/span_component_required'),2,FailureHandling.OPTIONAL)){
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record 20g Centrifuge/select_component'), 1,FailureHandling.STOP_ON_FAILURE)
	}
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/span_mandatory_on_close_filled'),1,FailureHandling.OPTIONAL)){
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/select_omrs_type'),1,FailureHandling.OPTIONAL)){
			WebUI.selectOptionByIndex(findTestObject('Object Repository/select_omrs_type'),1,FailureHandling.STOP_ON_FAILURE)
		}
	}
	
	WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Create New Record'),5)
	WebUI.click(findTestObject('Page_Enter Record View/input_Create New Record'))
	// check record is created
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),15,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'))
		WebUI.comment (recordID+' has been created successfully')
	}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'),1,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'))
		WebUI.comment (recordID+' has been created successfully')
	}else if( WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'),1,FailureHandling.OPTIONAL)){
		recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'))
		WebUI.comment (recordID+' has been created successfully')
	}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),1) ){
		WebUI.comment ('found save button, so the record has been created successfully')
	}else{
		KeywordUtil.markFailedAndStop("cannot determine the record has been created")
	}
	
}