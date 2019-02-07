import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

///////// create a new record for the training site
search_term = 'test_create_record_on_training'
//recordID=search_term
//search_term = 'test'
//if ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training')){
if( ((WebUI.getUrl()).toLowerCase().contains('training')&& (GlobalVariable.G_MAKE_MAS_url).toLowerCase().contains('training') ) || ((WebUI.getUrl()).contains('MAKE-MAS')&& (GlobalVariable.G_MAKE_MAS_url).contains('MAKE-MAS')) ){
		
	WebUI.comment 'this is a training site, so trying to create a new record'
	//WebUI.comment 'navigate to the first create new record link from the list (should be less mandatory required fields), which is '+urls[0]
	//WebUI.navigateToUrl(urls[0])
	//WebUI.refresh()
	WebUI.delay(1)
	
	if((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
		WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_Summary_short_desc'), 'test')		
		WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_Log Number_alias'), 'A12345')	
		WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Save'))
		return
	}
	
	WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_short_desc'),15)
	WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)
	WebUI.delay(1)
	if (GlobalVariable.G_MAKE_MAS_url.contains('ARC-PRACA')){
		WebUI.comment 'check Title_required_field, Business Area_required_field and Reporting Organization_required_field'
		WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/div_Title_required_field'),10)
		
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Title_required_field'))
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Reporting Organization_required_field'))
		WebUI.verifyElementVisible(findTestObject('Page_Enter Record View/div_Business Area_required_field'))
		
	}
		
	if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_component'),2,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Enter Record View/select_component'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_component'), 1,FailureHandling.STOP_ON_FAILURE)
	}
	/*if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/span_mandatory_on_close_filled'),1,FailureHandling.OPTIONAL)){
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_omrs_type'),1,FailureHandling.OPTIONAL)){
			WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_omrs_type'),1,FailureHandling.STOP_ON_FAILURE)
		}
		else if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_record_type'),1,FailureHandling.OPTIONAL)){
			WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_record_type'),1,FailureHandling.STOP_ON_FAILURE)
		}
	}*/
	if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_omrs_type'),1,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Enter Record View/select_omrs_type'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_omrs_type'),1,FailureHandling.STOP_ON_FAILURE)
	}
	else if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_record_type'),1,FailureHandling.OPTIONAL)){
		//WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_record_type'),1,FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_Enter Record View/select_record_type'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_record_type'),1,FailureHandling.STOP_ON_FAILURE)
	}
//	else if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_Group'),1,FailureHandling.OPTIONAL)){
//		WebUI.click(findTestObject('Page_Enter Record View/select_Group'))
//		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_Group'),1,FailureHandling.STOP_ON_FAILURE)
//	}
	else if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_Mission_Object'),1,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Enter Record View/select_Mission_Object'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_Mission_Object'),1,FailureHandling.STOP_ON_FAILURE)
	}
	else if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_LCC_Type'),1,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Enter Record View/select_LCC_Type'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_LCC_Type'),1,FailureHandling.STOP_ON_FAILURE)
	}
	if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_Group'),1,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Page_Enter Record View/select_Group'))
		WebUI.selectOptionByIndex(findTestObject('Page_Enter Record View/select_Group'),1,FailureHandling.STOP_ON_FAILURE)
	}
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'),1,FailureHandling.STOP_ON_FAILURE)){
		WebUI.click(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'))
		int option=2
		if((GlobalVariable.G_MAKE_MAS_url).contains('cp_inventory')
			||(GlobalVariable.G_MAKE_MAS_url).contains('WSTFwebPAPER')
			||(GlobalVariable.G_MAKE_MAS_url).contains('arcjetdb')
			
			||(GlobalVariable.G_MAKE_MAS_url).contains('doctree')) 
		
			option=1
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'), option, FailureHandling.STOP_ON_FAILURE)
	}
	//return
	
	WebUI.delay(1)
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
		KeywordUtil.markWarning("cannot determine the record has been created")
	}
	
}