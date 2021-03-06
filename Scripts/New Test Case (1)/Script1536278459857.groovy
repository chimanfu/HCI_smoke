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
	def add_verify_attachment_flags(list_of_flags,user_name,product){

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'),5)
		WebUI.click(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'))

		'enter values for 3 required fields'
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'), 'ITAR', true)

		WebUI.click(findTestObject('Object Repository/Page_Record_Created/span_International Partner Designation'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))
		WebUI.check(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))

		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'), 'TBD', true)

		'add attachment to input_Add New Attachment'
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add New Attachment'),10)
		WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), '/Users/jcfu/Katalon Studio/HCI_Group/Data Files/IHS_IP_permissions/expected_results_partner.xlsx')
		//WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments'),10)
		WebUI.delay(1)
		//WebUI.click(findTestObject('Object Repository/Page_Enter Record View/label_Add New Attachment'))
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/select_attachment_type'),10)
		WebUI.click(findTestObject('Page_Enter Record View/select_attachment_type'))
		WebUI.selectOptionByValue(findTestObject('Page_Enter Record View/select_attachment_type'), 'Comments Sheet', true)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/select_review_phase'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record View/select_review_phase'), 'Non-Phase Specific', true)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/select_proprietary_limited_right'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record View/select_proprietary_limited_right'), 'TBD', true)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/select_ip_access_allowed'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record View/select_ip_access_allowed'), 'Yes', true)

		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/select_export_control_rating'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record View/select_export_control_rating'), 'ITAR', true)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/label_Export Control Rating'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Enter Record View/select_export_control_rating'),10)

		//validate_attachment_flags(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
		verify_attachment_partner_flags_before_save(list_of_flags,user_name,product)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(5)
		check_record_created()
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)
		verify_attachment_partner_flags_after_save(list_of_flags,user_name,product)

	}
	@Keyword
	def verify_attachment_partner_flags_after_save(list_of_flags,user_name,product){
		boolean test_failed=false
		//String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected "GRANTED ACCESS" Flags='+list_of_flags+'\n'
		String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected "visible and checked" Flags from attachment after save ='+list_of_flags+'\n'
		String all_logMsg=logMsg
		try{
			'check flags from attachments after save'
			if (list_of_flags.contains('CSA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag CSA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag CSA from attachment after adding attachment into record')
				}else{
					all_logMsg=all_logMsg+('not found flag CSA from attachment after adding attachment into record')
					test_failed=true
				}
			}
			if (list_of_flags.contains('ESA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag ESA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag ESA from attachment after adding attachment into record')
				}else{
					all_logMsg=all_logMsg+('not found flag ESA from attachment after adding attachment into record')
					test_failed=true
				}
			}
			if (list_of_flags.contains('JAXA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag JAXA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag JAXA from attachment after adding attachment into record')
				}else{
					all_logMsg=all_logMsg+('not found flag JAXA from attachment after adding attachment into record')
					test_failed=true
				}
			}
			if (list_of_flags.contains('RSA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag RSA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag RSA from attachment after adding attachment into record')
				}else{
					all_logMsg=all_logMsg+('not found flag RSA from attachment after adding attachment into record')
					test_failed=true
				}
			}

		} catch (Exception e) {
			KeywordUtil.logInfo "cannot check flag from attachments"
			KeywordUtil.logInfo (e)
		}


		if (test_failed){
			KeywordUtil.markFailed(all_logMsg)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')
		}
		else{
			KeywordUtil.markPassed(all_logMsg)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')

		}
		KeywordUtil.logInfo( 'Done: verify_attachment_partner_flags_after_save()')
	}
	@Keyword
	def verify_attachment_partner_flags_before_save(list_of_flags,user_name,product){
		boolean test_failed=false
		String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected "visible and checked" Flags from attachment before save ='+list_of_flags+'\n'
		String all_logMsg=logMsg
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5) ){
			KeywordUtil.logInfo ('found save button, so the record page is displayed')
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_find_record')
			KeywordUtil.markFailedAndStop("cannot determine the record page is displayed")
		}
		/////////
		if (list_of_flags.contains('CSA')){
			if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
				all_logMsg=all_logMsg+'CSA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with CSA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with CSA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'CSA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'CSA Flag not displayed as expected\n'
		}
		/////////
		/////////
		if (list_of_flags.contains('ESA')){
			if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
				all_logMsg=all_logMsg+'ESA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with ESA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with ESA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'ESA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'ESA Flag not displayed as expected\n'
		}
		/////////
		/////////
		if (list_of_flags.contains('JAXA')){
			if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
				all_logMsg=all_logMsg+'JAXA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with JAXA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with JAXA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'JAXA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'JAXA Flag not displayed as expected\n'
		}
		/////////
		/////////
		if (list_of_flags.contains('RSA')){
			if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
				all_logMsg=all_logMsg+'RSA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with RSA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.verifyElementChecked(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with RSA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'RSA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'RSA Flag not displayed as expected\n'
		}
		/////////
		if (test_failed){
			KeywordUtil.markFailed(all_logMsg)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')
		}
		else{
			KeywordUtil.markPassed(all_logMsg)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')

		}
		KeywordUtil.logInfo( 'Done: verify_partner_flags()')
	}

	@Keyword
	def validate_attachment_flags(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product){
		String logMsg_checkboxes_selected=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_selected="'+checkboxes_selected+'"\n'
		String logMsg_checkboxes_disabled=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_disabled="'+checkboxes_disabled+'"\n'
		String logMsg_checkboxes_visible= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_visible="'+checkboxes_visible+'"\n'
		String logMsg_checkboxes= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\n'

		String all_logMsg_checkboxes=logMsg_checkboxes
		KeywordUtil.logInfo('attachment_flags_selected='+checkboxes_selected)
		KeywordUtil.logInfo('attachment_flags_disabled='+checkboxes_disabled)
		KeywordUtil.logInfo('attachment_flags_visible='+checkboxes_visible)
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


		KeywordUtil.logInfo "\ndetects attachment flags status of visibility, disabled/enabled, and selection"
		KeywordUtil.logInfo "CSA Flag"
		try {
			WebElement CSA_checkbox=driver.findElement(By.id('ip_flag_CSA_NEW_ATT_ROW_0'))
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
		KeywordUtil.logInfo "\nRSA Flag"
		try{
			WebElement RSA_checkbox=driver.findElement(By.id('ip_flag_RSA_NEW_ATT_ROW_0'))
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
		KeywordUtil.logInfo "\nESA Flag"
		try{
			WebElement ESA_checkbox=driver.findElement(By.id('ip_flag_ESA_NEW_ATT_ROW_0'))
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
		KeywordUtil.logInfo "\nJAXA Flag"
		try{
			WebElement JAXA_checkbox = driver.findElement(By.id('ip_flag_JAXA_NEW_ATT_ROW_0'))
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

		Set selected_checkboxes_set = new HashSet()
		selected_checkboxes_set.addAll(selected_checkboxes)
		Set disabled_checkboxes_set = new HashSet()
		disabled_checkboxes_set.addAll(disabled_checkboxes)
		Set visible_checkboxes_set = new HashSet()
		visible_checkboxes_set.addAll(visible_checkboxes)
		boolean runScreenshot=false
		if ((checkboxes_selected_set.isEmpty())&&(selected_checkboxes_set.isEmpty())){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_selected_set and selected_attachment_flags_set are Empty')
		}else if (checkboxes_selected_set.equals(selected_checkboxes_set)){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_selected_set = selected_attachment_flags_set')
		}else if (checkboxes_selected_set[0].length()==0 && selected_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_selected_set=[] and selected_attachment_flags_set=[]')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: selected_attachment_flags values NOT MATCH\nexpected:'+checkboxes_selected_set+'\nactual:'+selected_checkboxes_set+'\n'

			//KeywordUtil.markFailed(logMsg_checkboxes_selected+'ERROR: checkboxes_selected_set NOT = selected_checkboxes_set\nexpected:"'+checkboxes_selected_set+'"\nactual:"'+selected_checkboxes_set+'"\n')
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_selected')
			runScreenshot=true
		}
		if (checkboxes_disabled_set.isEmpty()&&disabled_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_disabled_set and disabled_attachment_flags_set are Empty')
		}else if (checkboxes_disabled_set.equals(disabled_checkboxes_set)){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_disabled_set = disabled_attachment_flags_set')
		}else if (checkboxes_disabled_set[0].length()==0 && disabled_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_disabled_set=[] and disabled_attachment_flags_set=[]')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: disabled_attachment_flags values NOT MATCH\nexpected:'+checkboxes_disabled_set+'\nactual:'+disabled_checkboxes_set+'\n'

			//KeywordUtil.markFailed(logMsg_checkboxes_disabled+'ERROR: checkboxes_disabled_set NOT = disabled_checkboxes_set\nexpected:'+checkboxes_disabled_set+'\nactual:'+disabled_checkboxes_set+'\n')
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_disabled')
			runScreenshot=true
		}
		if (checkboxes_visible_set.isEmpty()&&visible_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_visible_set and visible_attachment_flags_set are Empty')
		}else if (checkboxes_visible_set.equals(visible_checkboxes_set)){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_visible_set = visible_attachment_flags_set')
		}else if (checkboxes_visible_set[0].length()==0 && visible_checkboxes_set.isEmpty()){
			KeywordUtil.markPassed(all_logMsg_checkboxes+ 'attachment_flags_visible_set=[] and visible_attachment_flags_set=[]')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: visible_attachment_flags values NOT MATCH\nexpected:'+checkboxes_visible_set+'\nactual:'+visible_checkboxes_set+'\n'
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_visible')

			//KeywordUtil.markFailed(logMsg_checkboxes_visible+'ERROR: checkboxes_visible_set NOT = visible_checkboxes_set\nexpected:'+checkboxes_visible_set+'\nactual:'+visible_checkboxes_set+'\n')
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_visible')
			runScreenshot=true
		}
		if (runScreenshot){
			KeywordUtil.markFailed(all_logMsg_checkboxes)
			//WebUI.delay(1)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_attachment_flags_status')
			//WebUI.delay(1)
		}
	}


	@Keyword
	def create_record_from_template(record_title,product,component,export_control_rating,proprietary_limited_rights){
		// Create record from template
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'),10)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'),10)

		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'))

		//select first option of bug template from the list and use the selected template
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Select Template/input_first_bugid_selection'),10)
		WebUI.click(findTestObject('Object Repository/Page_Select Template/input_first_bugid_selection'))
		WebUI.click(findTestObject('Object Repository/Page_Select Template/button_Use Selected Template'))

		// fill out the fields and create a record
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record/input_Title_short_desc'),6)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record/input_Title_short_desc'), record_title)
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record/select_product'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Page_Enter Record/select_product'))
			WebUI.selectOptionByValue(findTestObject('Page_Enter Record/select_product'), product, true)
		}
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record/select_component'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Page_Enter Record/select_component'))
			WebUI.selectOptionByValue(findTestObject('Page_Enter Record/select_component'), component, true)
		}
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record/select_export_control_rating'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Page_Enter Record/select_export_control_rating'))
			WebUI.selectOptionByValue(findTestObject('Page_Enter Record/select_export_control_rating'), export_control_rating, true)
		}
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record/select_proprietary_limited_rights'),5,FailureHandling.STOP_ON_FAILURE)){
			WebUI.click(findTestObject('Page_Enter Record/select_proprietary_limited_rights'))
			WebUI.selectOptionByValue(findTestObject('Page_Enter Record/select_proprietary_limited_rights'), proprietary_limited_rights, true)
		}
		WebUI.click(findTestObject('Object Repository/Page_Enter Record/input_Create'))
		WebUI.delay(5)
		//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		check_record_created()
		KeywordUtil.markPassed('done create_record_from_template')
	}


	@Keyword
	def create_version_clone_record(){
		//WebUI.refresh()
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),10)
		WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),12)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
		try{
			//WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'))
		}catch (Exception e) {
			WebUI.refresh()
			WebUI.delay(10)
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),10)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),12)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'))
		}

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/input_Version'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Version'))
		WebUI.delay(5)
		//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		check_record_created()
		KeywordUtil.markPassed('done create_version_clone_record')
	}
	@Keyword
	def create_clone_record(){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_Clone This Record'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_Clone This Record'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Clone'))
		//WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_record_link'))
		String siteURL=WebUI.getUrl()
		WebUI.switchToWindowIndex(0)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
		WebUI.navigateToUrl(siteURL)
		WebUI.delay(5)
		//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		check_record_created()
		KeywordUtil.markPassed('done create_clone_record')
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
		WebUI.delay(5)
		check_record_created()
	}
	@Keyword
	def verify_XML_element(group_names,user_name,product){
		//group_names='_NASA|RSA<'
		String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected group_names in XML='+group_names+'\n'
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
				//WebUI.delay(1)
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_check_group_xml')
				//WebUI.delay(1)
			}
		}
		WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),8,FailureHandling.OPTIONAL)

	}
	@Keyword
	def verify_partner_flags(list_of_flags,user_name,product){
		boolean test_failed=false
		String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected "GRANTED ACCESS" Flags='+list_of_flags+'\n'
		String all_logMsg=logMsg
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5) ){
			KeywordUtil.logInfo ('found save button, so the record page is displayed')
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_find_record')
			KeywordUtil.markFailedAndStop("cannot determine the record page is displayed")
		}
		if (list_of_flags.contains('CSA')){
			if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 'title')).contains('GRANTED ACCESS'))
				all_logMsg=all_logMsg+'CSA: GRANTED ACCESS as expected\n'
			else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with CSA: GRANTED ACCESS.\n'
				//KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with CSA: GRANTED ACCESS.\n')
				//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_CSA_GRANTED_ACCESS')
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with CSA: GRANTED ACCESS.\n'

					//KeywordUtil.markFailed(logMsg+'ERROR: displayed invalid flag with CSA: GRANTED ACCESS.')
					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_CSA_GRANTED_ACCESS')
					test_failed=true
				}
				else
					all_logMsg=all_logMsg+'CSA: GRANTED ACCESS Not displayed (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'CSA Flag not displayed as expected\n'
		}
		if (list_of_flags.contains('ESA') ){
			if ( (WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 'title')).contains('GRANTED ACCESS'))
				all_logMsg=all_logMsg+'ESA: GRANTED ACCESS as expected\n'
			else{
				//KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with ESA: GRANTED ACCESS.')
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with ESA: GRANTED ACCESS.\n'
				//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_ESA_GRANTED_ACCESS')
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 'title')).contains('GRANTED ACCESS')){
					//KeywordUtil.markFailed(logMsg+'ERROR: displayed invalid flag with ESA: GRANTED ACCESS.')
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with ESA: GRANTED ACCESS.\n'

					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_ESA_GRANTED_ACCESS')
					test_failed=true
				}
				else
					all_logMsg=all_logMsg+'ESA: GRANTED ACCESS Not displayed (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'ESA Flag not displayed as expected\n'
		}
		if (list_of_flags.contains('JAXA') ){
			if ( (WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 'title')).contains('GRANTED ACCESS'))
				all_logMsg=all_logMsg+'JAXA: GRANTED ACCESS as expected'
			else{
				//KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with JAXA: GRANTED ACCESS.')
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with JAXA: GRANTED ACCESS.\n'
				//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_JAXA_GRANTED_ACCESS')
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with JAXA: GRANTED ACCESS.\n'

					//KeywordUtil.markFailed(logMsg+'ERROR: displayed invalid flag with JAXA: GRANTED ACCESS.')
					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_JAXA_GRANTED_ACCESS')
					test_failed=true
				}
				else
					all_logMsg=all_logMsg+'JAXA: GRANTED ACCESS Not displayed (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'JAXA Flag not displayed as expected\n'
		}
		if (list_of_flags.contains('RSA')  ){
			if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 'title')).contains('GRANTED ACCESS'))
				all_logMsg=all_logMsg+'RSA: GRANTED ACCESS as expected'
			else{
				//KeywordUtil.markFailed(logMsg+'ERROR: Cannot find flag with RSA: GRANTED ACCESS.')
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with RSA: GRANTED ACCESS.\n'
				//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_RSA_GRANTED_ACCESS')
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with RSA: GRANTED ACCESS.\n'
					//KeywordUtil.markFailed(logMsg+'ERROR: displayed invalid flag with RSA: GRANTED ACCESS.')
					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_RSA_GRANTED_ACCESS')
					test_failed=true
				}
				else
					all_logMsg=all_logMsg+'RSA: GRANTED ACCESS Not displayed (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'RSA Flag not displayed as expected\n'
		}
		if (test_failed){
			KeywordUtil.markFailed(all_logMsg)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')
		}
		else{
			KeywordUtil.markPassed(all_logMsg)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')

		}
		KeywordUtil.logInfo( 'Done: verify_partner_flags()')
	}

	@Keyword
	def end_session(){
		try{
			if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),3,FailureHandling.OPTIONAL)){
				WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
				KeywordUtil.markPassed 'done end_session'
			}else{
				KeywordUtil.markFailed("not found 'end session' link, cannot end_session")
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
				//WebUI.closeBrowser()
			}
		}catch (Exception e) {
			KeywordUtil.markFailed("ERROR: cannot end_session..."+e.message)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
			//WebUI.closeBrowser()
		}

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
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),1,FailureHandling.OPTIONAL)){
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
			if (WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating')).contains(email)){
				KeywordUtil.markPassed 'it is being impersonating user: '+email
				return
			}else{
				println 'current impersonating user:'+WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'))
				println 'need to impersonating user: '+email
			}
		}
		if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),1,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
		}
		WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'), 16)
		WebUI.click(findTestObject('Page_Main Page/a_Admin'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Administer your installation/a_Users'),10)
		WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))

		WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), email+'\n')
		WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))
		check_enabled_flags(email)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'),5)
		WebUI.click(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Begin sudo session/input_Begin Session'),5)

		WebUI.click(findTestObject('Object Repository/Page_Begin sudo session/input_Begin Session'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),8)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),2)
		if (WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating')).contains(email)){
			KeywordUtil.markPassed 'it is being impersonating user: '+email
		}else{
			throw new AssertionError('ERROR: cannot impersonating user: '+email)
		}
	}
	@Keyword
	def create_record_through_VTL(product,record_title, component, record_type,verification_status){

		create_new_record(product, record_title, component, record_type)

		//create verification and change verification status to 'Closed to VTL'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/div_Verifications_TAB'),10)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Verifications_TAB'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Verification Title'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Verification Title'),'Verification_'+record_title)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/select_verification_status'),10)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/select_verification_status'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Enter Record View/select_verification_status'), verification_status, true)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
		KeywordUtil.markPassed('Done create_record_through_VTL with title='+'Verification_'+record_title+',verification_status='+verification_status)
		WebUI.delay(4)
		check_record_created()
		//approve record, change record status to REVIEW, then change record status to 'PHASE III APPROVED'
		approve_record()

		//navigate to VTI (Verification Tracking Item)
		return navigate_VTI_ID()


	}
	@Keyword
	def navigate_VTI_ID(){
		//goto verification tab
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/div_Verifications_TAB'),12)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Verifications_TAB'))
		if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Closed to VTL_link'),5)){
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Closed to VTL_link'))
		}
		//int currentTab = WebUI.getWindowIndex()
		WebUI.delay(1)
		String VTI_ID=''
		if (!WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_VTI_link'),8,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Verifications_TAB'))
			WebUI.delay(2)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_VTI_link'),10)
		}
		String VTI_siteURL=WebUI.getAttribute(findTestObject('Object Repository/Page_Record_Created/a_VTI_link'), 'href')
		KeywordUtil.logInfo 'VTI_siteURL='+VTI_siteURL
		VTI_ID=VTI_siteURL.substring(VTI_siteURL.lastIndexOf('id=')+3)
		KeywordUtil.logInfo 'VTI_ID='+VTI_ID
		//		String siteURL=GlobalVariable.G_MAKE_MAS_url
		//		if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
		//		String VTI_siteURL=siteURL+'show_bug.cgi?id='+VTI_ID
		//String VTI_siteURL=VTI_ID
		//WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_VTI_link'))
		//		WebUI.switchToWindowIndex(currentTab+1)
		//		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),10)
		//		String VTI_siteURL=WebUI.getUrl()
		//		WebUI.switchToWindowIndex(currentTab)
		//		WebUI.closeWindowIndex(currentTab+1)
		WebUI.navigateToUrl(VTI_siteURL)
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),10)
		return VTI_ID
	}
	@Keyword
	def approve_record(){
		KeywordUtil.logInfo 'Go to approvals and concurrences tab'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Record Status'),10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Record Status'),2)

		// change record status to REVIEW
		String record_status='REVIEW'
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/select_record_status'),10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_record_status'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_record_status'), record_status, true)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(4)
		check_record_created()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
		WebUI.delay(1)
		// change record status to 'PHASE III APPROVED'
		record_status='PHASE III APPROVED'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/select_record_status'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_record_status'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_record_status'), record_status, true)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(4)
		check_record_created()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
		WebUI.delay(1)
	}
	@Keyword
	def create_new_record(product, record_title, component, record_type){
		String logMsg='\nproduct='+product+', record_title='+record_title+', component='+component+', record_type='+record_type+'\n'
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
		WebUI.delay(8)
		check_record_created()
	}
	@Keyword
	def check_record_created(){
		// check record is created
		String recordID=''
		String logMsg=''
		boolean check_record_created_failed=true
		int i=0
		while (check_record_created_failed){
			try{
				if(WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),25) ){
					KeywordUtil.logInfo ('found save button, so the record has been created successfully'+logMsg)
				}else{
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
					KeywordUtil.markFailed("cannot determine the record has been created")
				}
				WebUI.waitForPageLoad(60, FailureHandling.STOP_ON_FAILURE)
				//WebUI.waitForAngularLoad(60, FailureHandling.STOP_ON_FAILURE)
				//WebUI.waitForJQueryLoad(60, FailureHandling.STOP_ON_FAILURE)
				if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),30,FailureHandling.CONTINUE_ON_FAILURE)){
					recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'))
					KeywordUtil.markPassed ('record title: "'+recordID+'" has been created successfully'+logMsg)
					check_record_created_failed=false
				}
				if( WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'),15,FailureHandling.CONTINUE_ON_FAILURE)){
					recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'))
					KeywordUtil.markPassed ('record ID and status: "'+recordID+'" has been created successfully'+logMsg)
					check_record_created_failed=false
					break
				}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'))
					KeywordUtil.markPassed ('record ID and status: "'+recordID+'" has been created successfully'+logMsg)
					check_record_created_failed=false
					break
				}
			} catch (Exception e) {
				KeywordUtil.logInfo "continue..."
				WebUI.delay(2)
				i++
				if (i>7)
					KeywordUtil.markFailedAndStop("cannot determine the record has been created")
				break
			}
		}
	}
	@Keyword
	def check_enabled_flags(user_name){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'),5)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Preferences/input_parameter_checked'),6)
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type = 'checkbox' and @checked = 'checked']"));
		int size=elements.size()
		String enabled_flags='\nEnabled(Checked) Parameters For the User: '+user_name+'\n'
		String parameter_enabled=''
		for (int i = 0; i < size; i++) {
			parameter_enabled = elements.get(i).getAttribute("class");
			enabled_flags=enabled_flags+parameter_enabled+'\n'
		}
		KeywordUtil.logInfo(enabled_flags)
		GlobalVariable.userPin3=enabled_flags
		return enabled_flags
	}


	@Keyword
	def validate_ECR_checkboxes(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product){
		String logMsg_checkboxes_selected=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_selected="'+checkboxes_selected+'"\n'
		String logMsg_checkboxes_disabled=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_disabled="'+checkboxes_disabled+'"\n'
		String logMsg_checkboxes_visible= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected checkboxes_visible="'+checkboxes_visible+'"\n'
		String logMsg_checkboxes= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\n'

		String all_logMsg_checkboxes=logMsg_checkboxes
		all_logMsg_checkboxes=all_logMsg_checkboxes+('expected checkboxes_selected='+checkboxes_selected+'\n')+('expected checkboxes_disabled='+checkboxes_disabled+'\n')+('expected checkboxes_visible='+checkboxes_visible+'\n')
		//KeywordUtil.logInfo('expected checkboxes_selected='+checkboxes_selected+'\n')
		//KeywordUtil.logInfo('expected checkboxes_disabled='+checkboxes_disabled+'\n')
		//KeywordUtil.logInfo('expected checkboxes_visible='+checkboxes_visible+'\n')
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

		KeywordUtil.logInfo 'Go to approvals and concurrences tab'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Record Status'),10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Record Status'),2)

		KeywordUtil.logInfo "\nBrowser detects checkbox visibility, disabled/enabled, and selection"
		KeywordUtil.logInfo "CSA checkbox"
		try {
			WebElement CSA_checkbox=driver.findElement(By.id('_NASA|CSA'))
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
			WebElement RSA_checkbox=driver.findElement(By.id('_NASA|RSA'))
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
			WebElement ESA_checkbox=driver.findElement(By.id('_NASA|ESA'))
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
			WebElement JAXA_checkbox = driver.findElement(By.id('_NASA|JAXA'))
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

			if (! ITAR_checkbox.isEnabled()){
				KeywordUtil.logInfo "  - disabled"
				disabled_checkboxes.add("ITAR")
			}
			if (ITAR_checkbox.isSelected()){
				KeywordUtil.logInfo "  - selected"
				selected_checkboxes.add("ITAR")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo "  - not visible"
		}
		KeywordUtil.logInfo "\nHP_Boeing_inwork checkbox"
		try{
			WebElement HP_Boeing_inwork_checkbox = driver.findElement(By.id('HP_Boeing_inwork'))
			KeywordUtil.logInfo "  - visible"
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
		boolean test_failed=false
		if ((checkboxes_selected_set.isEmpty())&&(selected_checkboxes_set.isEmpty())){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_selected_set and selected_checkboxes_set are Empty\n')
		}else if (checkboxes_selected_set.equals(selected_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_selected_set = selected_checkboxes_set\n')
		}else if (checkboxes_selected_set[0].length()==0 && selected_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_selected_set=[] and selected_checkboxes_set=[]\n')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: selected_checkboxes values NOT MATCH\nexpected:'+checkboxes_selected_set+'\nactual:'+selected_checkboxes_set+'\n'
			test_failed=true
		}
		if (checkboxes_disabled_set.isEmpty()&&disabled_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_disabled_set and disabled_checkboxes_set are Empty\n')
		}else if (checkboxes_disabled_set.equals(disabled_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_disabled_set = disabled_checkboxes_set\n')
		}else if (checkboxes_disabled_set[0].length()==0 && disabled_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_disabled_set=[] and disabled_checkboxes_set=[]\n')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: disabled_checkboxes values NOT MATCH\nexpected:'+checkboxes_disabled_set+'\nactual:'+disabled_checkboxes_set+'\n'
			test_failed=true
		}
		if (checkboxes_visible_set.isEmpty()&&visible_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_visible_set and visible_checkboxes_set are Empty\n')
		}else if (checkboxes_visible_set.equals(visible_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_visible_set = visible_checkboxes_set\n')
		}else if (checkboxes_visible_set[0].length()==0 && visible_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('checkboxes_visible_set=[] and visible_checkboxes_set=[]\n')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: visible_checkboxes values NOT MATCH\nexpected:'+checkboxes_visible_set+'\nactual:'+visible_checkboxes_set+'\n'
			test_failed=true
		}

		if (test_failed){
			KeywordUtil.markFailed(all_logMsg_checkboxes)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_status')
		}
		else{
			KeywordUtil.markPassed(all_logMsg_checkboxes)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_status')

		}
	}
}
