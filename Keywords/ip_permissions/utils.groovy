package ip_permissions
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
class utils {
	@Keyword
	def testing(){
		String user_name='xxx'
		String product='yyy'
		String logMsg_checkboxes_selected=''
		KeywordUtil.markFailed(logMsg_checkboxes_selected+'ERROR: checkboxes_selected_set NOT = selected_checkboxes_set\nexpected:"'+'"\nactual:"'+'"\n')
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_selected')
		println 'ending here...'
		}
	@Keyword
	def edit_product(new_product, new_component){
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/select_product'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_product'))
			//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Record_Created/select_product'), 1,FailureHandling.STOP_ON_FAILURE)
			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_product'), new_product, true)
		}
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'))
			//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'), 1,FailureHandling.STOP_ON_FAILURE)
			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'), new_component, true)
		}
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
		KeywordUtil.markPassed('edit product successful to new_product='+new_product+' and new_component='+new_component)
	}
	@Keyword
	def create_record_from_record(record_title){
		//record_title='test_1'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Linked_Causes_Add_New_Record'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Linked_Causes_Add_New_Record'))
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/input_Title_newRecordContainer'),5)
		WebUI.setText(findTestObject('Object Repository/Page_Record_Created/input_Title_newRecordContainer'),record_title)
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
		
		// find the newly created record link
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'),15)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'),15)
		//WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'),5)
		if (WebUI.getText(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause')).contains(record_title)){
			println 'found newly created cause record link with title='+record_title
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Linked Causes'),5)
			WebUI.delay(4)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Linked_Causes_Add_New_Record'),15)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'),15)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'),15)
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_record_link_Cause'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_record_title'),10)
			if (WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_title')).contains(record_title)){
				KeywordUtil.markPassed('page of newly created cause record is displayed with title='+record_title)
				KeywordUtil.markPassed("created cause record from record successfully")
			}else{
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_create_cause_record')			
				KeywordUtil.markFailedAndStop("ERROR: cannot find div_record_title with correct title, so it cannot create cause record from record")			
			}
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_create_cause_record')
			KeywordUtil.markFailedAndStop("ERROR: cannot find a_record_link_Cause with correct title, so it cannot create cause record from record")
		}	
	}
	@Keyword
	def verify_XML_element(group_names,user_name,product){
		//group_names='_NASA|RSA<'
		String logMsg='\n!FAIL: user='+user_name+' on product='+product+',Expected group_names='+group_names+'\n'	
		String[] group_name_list
		group_name_list = group_names.split('\\|')
		int currentTab = WebUI.getWindowIndex()
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_XML'), 10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_XML'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(currentTab+1)	
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/span_group id_tag'),3,FailureHandling.OPTIONAL)
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/span_This XML file does not appear'),5,FailureHandling.OPTIONAL)		
		String xml_page_contents=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/all_XML_contents'))
		WebUI.closeWindowIndex(currentTab + 1)
		WebUI.switchToWindowIndex(currentTab)
		for( String group_name : group_name_list ){
			KeywordUtil.logInfo(group_name)
			if (xml_page_contents.contains(group_name)){
				KeywordUtil.markPassed ('PASS: Group ' + group_name + ': Found in XML doc')
			}else{
				KeywordUtil.markFailed(logMsg+'ERROR: Group ' + group_name + ': Not Found in XML doc')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_check_group_xml')							
			}
		}
	}
	@Keyword
	def verify_partner_flags(list_of_flags,user_name,product){
		String logMsg='\n!FAIL: user='+user_name+' on product='+product+',Expected GRANTED ACCESS Flags='+list_of_flags+'\n'
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5) ){
			KeywordUtil.logInfo ('found save button, so the record page is displayed')
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_find_record')	
			KeywordUtil.markFailedAndStop("cannot determine the record page is displayed")
		}
		if (list_of_flags.contains('CSA')){
			if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 'title')).contains('GRANTED ACCESS'))
				KeywordUtil.markPassed('CSA: GRANTED ACCESS as expected')
			else{
				KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with CSA: GRANTED ACCESS.')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_CSA_GRANTED_ACCESS')
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 'title')).contains('GRANTED ACCESS')){
					KeywordUtil.markFailed(logMsg+'ERROR: displayed flag with CSA: GRANTED ACCESS.')
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_CSA_GRANTED_ACCESS')
				}	
				else
					KeywordUtil.markPassed('CSA: GRANTED ACCESS Not displayed as expected')
			}else
				KeywordUtil.markPassed('CSA Flag not displayed as expected')
		}
		if (list_of_flags.contains('ESA') ){
			if ( (WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 'title')).contains('GRANTED ACCESS'))
				KeywordUtil.markPassed('ESA: GRANTED ACCESS as expected')
			else{
				KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with ESA: GRANTED ACCESS.')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_ESA_GRANTED_ACCESS')
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 'title')).contains('GRANTED ACCESS')){
					KeywordUtil.markFailed(logMsg+'ERROR: displayed flag with ESA: GRANTED ACCESS.')
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_ESA_GRANTED_ACCESS')
				}
				else
					KeywordUtil.markPassed('ESA: GRANTED ACCESS Not displayed as expected')
			}else
				KeywordUtil.markPassed('ESA Flag not displayed as expected')
		}
		if (list_of_flags.contains('JAXA') ){
			if ( (WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 'title')).contains('GRANTED ACCESS'))
				KeywordUtil.markPassed('JAXA: GRANTED ACCESS as expected')
			else{
				KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with JAXA: GRANTED ACCESS.')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_JAXA_GRANTED_ACCESS')
			}			
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 'title')).contains('GRANTED ACCESS')){
					KeywordUtil.markFailed(logMsg+'ERROR: displayed flag with JAXA: GRANTED ACCESS.')
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_JAXA_GRANTED_ACCESS')
				}
				else
					KeywordUtil.markPassed('JAXA: GRANTED ACCESS Not displayed as expected')
			}else
				KeywordUtil.markPassed('JAXA Flag not displayed as expected')
		}
		if (list_of_flags.contains('RSA')  ){
			if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 'title')).contains('GRANTED ACCESS'))
				KeywordUtil.markPassed('RSA: GRANTED ACCESS as expected')
			else{
				KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with RSA: GRANTED ACCESS.')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_RSA_GRANTED_ACCESS')
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 'title')).contains('GRANTED ACCESS')){
					KeywordUtil.markFailed(logMsg+'ERROR: displayed flag with RSA: GRANTED ACCESS.')
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_RSA_GRANTED_ACCESS')
				}
				else
					KeywordUtil.markPassed('RSA: GRANTED ACCESS Not displayed as expected')
			}else
				KeywordUtil.markPassed('RSA Flag not displayed as expected')
		}
		KeywordUtil.markPassed 'Done: verify_partner_flags()'
	}

	@Keyword
	def end_session(){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),5)
		WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
		KeywordUtil.markPassed 'done end_session'
	}
	@Keyword
	def generate_unique_title(product){
		String record_title=''
		Date today = new Date()
		String todaysDate = today.format('MM_dd_yy')
		String nowTime = today.format('hh_mm_ss')
		record_title="IP-Test-"+product+"_"+ todaysDate+'-'+nowTime
		return record_title
	}
	@Keyword
	def impersonate(email){
		if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),1)){
			WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
		}
		WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'), 16)
		WebUI.click(findTestObject('Page_Main Page/a_Admin'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Administer your installation/a_Users'),10)
		WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))

		WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), email+'\n')
		WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'),5)
		WebUI.click(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Begin sudo session/input_Begin Session'),5)

		WebUI.click(findTestObject('Object Repository/Page_Begin sudo session/input_Begin Session'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
		if (WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating')).contains(email)){
			KeywordUtil.markPassed 'it is being impersonating user: '+email
		}else{
			throw new AssertionError('ERROR: cannot impersonating user: '+email)
		}
	}
	@Keyword
	def create_new_record(product, record_title, component, record_type){
		String siteURL=GlobalVariable.G_MAKE_MAS_url
		if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
		String new_record_url=siteURL+'/enter_bug.cgi?product='+product
		/*WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev/index.cgi')
		 WebUI.click(findTestObject('Page_ISS Hazard Main Page/a_New'))
		 WebUI.click(findTestObject('Page_ISS Hazard Main Page/a_New blank record'))
		 WebUI.click(findTestObject('Object Repository/Page_Select Category/a_All'))
		 WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Boeing'))*/
		String recordID=''
		WebUI.navigateToUrl(new_record_url)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record Boeing/input_Title_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record Boeing/input_Title_field'), record_title)

		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record Boeing/select_record_type'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record Boeing/select_record_type'))
			//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Enter Record Boeing/select_record_type'), 1,FailureHandling.STOP_ON_FAILURE)
			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record Boeing/select_record_type'), record_type, true)
		}
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'))
			//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'), 1,FailureHandling.STOP_ON_FAILURE)
			WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record Boeing/select_subsystem_payload'), component, true)
		}
		//WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record Boeing/select_export_control_rating'), 'EAR/15 CFR 730-774', true)

		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record Boeing/div_New Record(INWORK)'),5)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record Boeing/div_New Record(INWORK)'))

		// not save
		//CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
		//return
		// Hit create button
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Create New Record'),5)
		WebUI.click(findTestObject('Page_Enter Record View/input_Create New Record'))

		// check record is created
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),15,FailureHandling.OPTIONAL)){
			recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'))
			KeywordUtil.markPassed (recordID+' has been created successfully')
		}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'),1,FailureHandling.OPTIONAL)){
			recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'))
			KeywordUtil.markPassed (recordID+' has been created successfully')
		}else if( WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'),1,FailureHandling.OPTIONAL)){
			recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'))
			KeywordUtil.markPassed (recordID+' has been created successfully')
		}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),1) ){
			KeywordUtil.markPassed ('found save button, so the record has been created successfully')
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+product+'_create_record')		
			KeywordUtil.markFailedAndStop("cannot determine the record has been created")			
		}
	}
	@Keyword
	def validate_ECR_checkboxes(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product){
		String logMsg_checkboxes_selected='\n!FAIL: user='+user_name+' on product='+product+', Expected checkboxes_selected="'+checkboxes_selected+'"\n'
		String logMsg_checkboxes_disabled='\n!FAIL: user='+user_name+' on product='+product+', Expected checkboxes_disabled="'+checkboxes_disabled+'"\n'
		String logMsg_checkboxes_visible= '\n!FAIL: user='+user_name+' on product='+product+', Expected checkboxes_visible="'+checkboxes_visible+'"\n'
		
		KeywordUtil.logInfo('checkboxes_selected='+checkboxes_selected)
		KeywordUtil.logInfo('checkboxes_disabled='+checkboxes_disabled)
		KeywordUtil.logInfo('checkboxes_visible='+checkboxes_visible)
		String[] checkboxes_selected_list = checkboxes_selected.split(',')
		//Set<String> checkboxes_selected_set = new HashSet<String>(Arrays.asList(checkboxes_selected_list));
		String[] checkboxes_disabled_list = checkboxes_disabled.split(',')
		//Set<String> checkboxes_disabled_set = new HashSet<String>(Arrays.asList(checkboxes_disabled_list));
		String[] checkboxes_visible_list = checkboxes_visible.split(',')
		//Set<String> checkboxes_visible_set = new HashSet<String>(Arrays.asList(checkboxes_visible_list));

		Set<String> checkboxes_selected_set = checkboxes_selected_list
		Set<String> checkboxes_disabled_set = checkboxes_disabled_list
		Set<String> checkboxes_visible_set = checkboxes_visible_list

		List<String> visible_checkboxes = new ArrayList<String>()
		List<String> disabled_checkboxes = new ArrayList<String>()
		List<String> selected_checkboxes = new ArrayList<String>()
		WebDriver driver
		driver = DriverFactory.getWebDriver()
		/*
		 for(String element : visible_checkboxes) {
		 System.out.println(element);
		 }
		 */		
		KeywordUtil.logInfo 'Go to approvals and concurrences tab'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Approval Signatures'),10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approval Signatures'),2)
		
		KeywordUtil.logInfo "\nBrowser detects checkbox visibility, disabled/enabled, and selection"
		KeywordUtil.logInfo "CSA checkbox"
		try {
			WebElement CSA_checkbox=driver.findElement(By.id('OR_GROUPS_CSA'))
			KeywordUtil.logInfo "  - visible"
			visible_checkboxes.add("CSA")

			if (! CSA_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("CSA")
			}
			if (CSA_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("CSA")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nRSA checkbox"
		try{
			WebElement RSA_checkbox=driver.findElement(By.id('OR_GROUPS_RSA'))
			KeywordUtil.logInfo "  - visible"
			visible_checkboxes.add("RSA")

			if (! RSA_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("RSA")
			}
			if (RSA_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("RSA")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nESA checkbox"
		try{
			WebElement ESA_checkbox=driver.findElement(By.id('OR_GROUPS_ESA'))
			KeywordUtil.logInfo "  - visible"
			visible_checkboxes.add("ESA")

			if (! ESA_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("ESA")
			}
			if (ESA_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("ESA")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nJAXA checkbox"
		try{
			WebElement JAXA_checkbox = driver.findElement(By.id('OR_GROUPS_JAXA'))
			KeywordUtil.logInfo "  - visible"
			visible_checkboxes.add("JAXA")

			if (! JAXA_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("JAXA")
			}
			if (JAXA_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("JAXA")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nITAR checkbox"
		try{
			WebElement ITAR_checkbox = driver.findElement(By.id('ITAR*'))
			KeywordUtil.logInfo "  - visible"
			visible_checkboxes.add("ITAR")
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nHP_Boeing_inwork checkbox"
		try{
			WebElement HP_Boeing_inwork_checkbox = driver.findElement(By.id('HP_Boeing_inwork'))
			KeywordUtil.logInfo "  -visible"
			visible_checkboxes.add("HP_Boeing_inwork")

			if (! HP_Boeing_inwork_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("HP_Boeing_inwork")
			}
			if (HP_Boeing_inwork_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("HP_Boeing_inwork")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		Set selected_checkboxes_set = new HashSet()
		selected_checkboxes_set.addAll(selected_checkboxes)
		Set disabled_checkboxes_set = new HashSet()
		disabled_checkboxes_set.addAll(disabled_checkboxes)
		Set visible_checkboxes_set = new HashSet()
		visible_checkboxes_set.addAll(visible_checkboxes)

		if ((checkboxes_selected_set.isEmpty())&&(selected_checkboxes_set.isEmpty())){
			KeywordUtil.markPassed( 'checkboxes_selected_set and selected_checkboxes_set are Empty')
		}else if (checkboxes_selected_set.equals(selected_checkboxes_set)){
			KeywordUtil.markPassed( 'checkboxes_selected_set = selected_checkboxes_set')
		}else if (checkboxes_selected_set[0].length()==0 && selected_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed( 'checkboxes_selected_set=[] and selected_checkboxes_set=Empty')
		}else{
			KeywordUtil.markFailed(logMsg_checkboxes_selected+'ERROR: checkboxes_selected_set NOT = selected_checkboxes_set\nexpected:"'+checkboxes_selected_set+'"\nactual:"'+selected_checkboxes_set+'"\n')
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_selected')
		}
		if (checkboxes_disabled_set.isEmpty()&&disabled_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed( 'checkboxes_disabled_set and disabled_checkboxes_set are Empty')
		}else if (checkboxes_disabled_set.equals(disabled_checkboxes_set)){
			KeywordUtil.markPassed( 'checkboxes_disabled_set = disabled_checkboxes_set')
		}else if (checkboxes_disabled_set[0].length()==0 && disabled_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed( 'checkboxes_disabled_set=[] and disabled_checkboxes_set=Empty')
		}else{
			KeywordUtil.markFailed(logMsg_checkboxes_disabled+'ERROR: checkboxes_disabled_set NOT = disabled_checkboxes_set\nexpected:'+checkboxes_disabled_set+'\nactual:'+disabled_checkboxes_set+'\n')
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_disabled')
		}
		if (checkboxes_visible_set.isEmpty()&&visible_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed( 'checkboxes_visible_set and visible_checkboxes_set are Empty')
		}else if (checkboxes_visible_set.equals(visible_checkboxes_set)){
			KeywordUtil.markPassed( 'checkboxes_visible_set = visible_checkboxes_set')
		}else if (checkboxes_visible_set[0].length()==0 && visible_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed( 'checkboxes_visible_set=[] and visible_checkboxes_set=Empty')
		}else{
			KeywordUtil.markFailed(logMsg_checkboxes_visible+'ERROR: checkboxes_visible_set NOT = visible_checkboxes_set\nexpected:'+checkboxes_visible_set+'\nactual:'+visible_checkboxes_set+'\n')
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_visible')
		}			
	}
}