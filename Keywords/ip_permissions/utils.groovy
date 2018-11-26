package ip_permissions
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
	def check_users_permissions(){
		String url = GlobalVariable.G_MAKE_MAS_url
		if ((url.contains('MAKE-MAS')) && (url.contains('dev'))) {
			WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
		} else {
			KeywordUtil.logInfo('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not check new user on production site')
			return null
		}
		url=WebUI.getUrl()
		WebUI.comment 'now checking the URL from the current page from browser: '+url
		if (url.contains('MAKE-MAS') && url.contains('dev')) {
			WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
		} else {
			KeywordUtil.logInfo('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not check new user on production site')
			return null
		}
		String ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list2'
		KeywordUtil.logInfo('will check existing test users in '+ip_test_user_list)
		String status,user_name,user_email,permission,checked_status, expected_permissions
		boolean test_failed=false
		WebDriver driver
		driver = DriverFactory.getWebDriver()
		for (int row = 2; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
			user_name=findTestData(ip_test_user_list).getValue(1, row).trim()
			user_email=findTestData(ip_test_user_list).getValue(2, row).trim()
			// goto user view
			WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Admin'), 16)
			WebUI.click(findTestObject('Page_Main Page/a_Admin'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Administer your installation/a_Users'),10)
			WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))
			// search for user
			WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), user_email+'\n')
			WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))

			status='Checked on existing user = '
			status=status+ user_name + ', '
			status=status+ user_email+ '\n'

			expected_permissions=check_user_enabled_permissions(user_name,'check actual user permissions from the user permission view from the site')

			status=status+ 'From the spreadsheet '+ip_test_user_list
			status=status+ ' with expected permission:\n'
			for (int permission_col = 3; permission_col <= findTestData(ip_test_user_list).getColumnNumbers(); permission_col++){
				permission=findTestData(ip_test_user_list).getValue(permission_col, 1).trim()
				checked_status=findTestData(ip_test_user_list).getValue(permission_col, row).trim()
				if (checked_status.toLowerCase().equals('x')){
					//if (permission.equals('PARTNER_RSA')) permission='A_PARTNER_RSA'
					//if (permission.equals('PARTNER_JAXA')) permission='A_PARTNER_JAXA'
					//if (permission.equals('US_Person')) permission='U.S._Persons'
					//driver.findElement(By.className(permission)).click()
					status=status+permission+'\n'
					if (!expected_permissions.contains(permission)){
						if (permission.equals('US_Person')) {
							if (!expected_permissions.contains('U.S._Persons'))
								test_failed=true
						}else
							test_failed=true
					}

				}
			}
			if (test_failed)
				KeywordUtil.markFailed(status+'\n'+expected_permissions+'\n')
			else
				KeywordUtil.markPassed(status)

			//KeywordUtil.markPassed(status)
		}
	}
	@Keyword
	def create_new_users_with_permissions(){
		String url = GlobalVariable.G_MAKE_MAS_url
		if ((url.contains('MAKE-MAS')) && (url.contains('dev'))) {
			WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
		} else {
			KeywordUtil.logInfo('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not create new user on production site')
			return null
		}
		url=WebUI.getUrl()
		WebUI.comment 'now checking the URL from the current page from browser: '+url
		if (url.contains('MAKE-MAS') && url.contains('dev')) {
			WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
		} else {
			KeywordUtil.logInfo('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not create new user on production site')
			return null
		}
		boolean test_failed=false
		String ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list2'
		KeywordUtil.logInfo('will create new test users in '+ip_test_user_list)
		String status,user_name,user_email,permission,checked_status
		WebDriver driver
		driver = DriverFactory.getWebDriver()
		for (int row = 2; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
			user_name=findTestData(ip_test_user_list).getValue(1, row).trim()
			user_email=findTestData(ip_test_user_list).getValue(2, row).trim()
			// add user
			WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Admin'), 16)
			WebUI.click(findTestObject('Page_Main Page/a_Admin'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Administer your installation/a_Users'),10)
			WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))

			// add user
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Search users/a_add a new user'),6)
			WebUI.click(findTestObject('Object Repository/Page_Search users/a_add a new user'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Add user/input_Email'),6)
			WebUI.setText(findTestObject('Object Repository/Page_Add user/input_Email'), user_email)
			WebUI.setText(findTestObject('Object Repository/Page_Add user/input_name'), user_name)
			WebUI.click(findTestObject('Object Repository/Page_Add user/input_add'))
			//println 'added new user='+user_name+', '+user_email
			//println 'going to add permission to the new user'
			status='Added new user = '
			status=status+ user_name + ', '
			status=status+ user_email+ '\n'
			status=status+ 'with checked permission:\n'

			//WebElement element
			for (int permission_col = 3; permission_col <= findTestData(ip_test_user_list).getColumnNumbers(); permission_col++){
				permission=findTestData(ip_test_user_list).getValue(permission_col, 1).trim()
				//status=status+ 'permission='+permission+','
				checked_status=findTestData(ip_test_user_list).getValue(permission_col, row).trim()
				//status=status+ 'checked_status='+checked_status+' \n'
				//println status
				// check permission if checked_status=x
				if (checked_status.toLowerCase().equals('x')){
					try{
						if (permission.equals('PARTNER_RSA')) permission='A_PARTNER_RSA'
						if (permission.equals('PARTNER_JAXA')) permission='A_PARTNER_JAXA'
						driver.findElement(By.className(permission)).click()
						status=status+permission+'\n'
					} catch (Exception e) {
						if (permission.equals('US_Person')){
							status=status+"!!! Not found Permission: "+permission
							permission='U.S._Persons'
							try{
								driver.findElement(By.className(permission)).click()
								status=status+', found Permission: '+permission+'\n'
							} catch (Exception e1) {
								status=status+ "!!! No Permission Named: "+permission+'\n'
								test_failed=true
							}
						}else{
							status=status+ "!!! No Permission Named: "+permission+'\n'
							test_failed=true
						}
					}
				}
			}
			// save change for adding permissions to user
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Edit user info/input_update'),6)
			WebUI.click(findTestObject('Object Repository/Page_Edit user info/input_update'))
			WebUI.delay(1)
			check_user_enabled_permissions(user_name,'check actual user permissions after creating new user')
			if (test_failed)
				KeywordUtil.markFailed(status)
			else
				KeywordUtil.markPassed(status)
		}
	}
	@Keyword
	def add_verify_attachment_flags(list_of_flags,user_name,product,def info=null){
		WebUI.refresh(FailureHandling.OPTIONAL)
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),50)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),50)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),20)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'),6)
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
		verify_attachment_partner_flags_before_save(list_of_flags,user_name,product,info)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		check_record_save_alert()
		check_record_created()
		check_record_save_alert()
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)
		verify_attachment_partner_flags_after_save(list_of_flags,user_name,product,info)

	}
	def check_record_save_alert(){
		int i=5
		while (i>0)
			try{
				WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),30,FailureHandling.OPTIONAL)
				WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20,FailureHandling.OPTIONAL)
				KeywordUtil.markPassed "found alert Record Saved"
				break
			} catch (Exception e) {
				i--
				KeywordUtil.logInfo "cannot find alert Record Saved, try again"
				KeywordUtil.logInfo (e)
				WebUI.delay(5)
			}
	}
	@Keyword
	def verify_attachment_partner_flags_after_save(list_of_flags,user_name,product, def info=null){
		boolean test_failed=false
		//String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'\nExpected "GRANTED ACCESS" Flags='+list_of_flags+'\n'
		String all_logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected "visible and checked" Flags from attachment level after save ='+list_of_flags+'\n'
		//String all_logMsg=logMsg
		if (info!=null) all_logMsg=all_logMsg+info+'\n'
		if (GlobalVariable.userPin3.contains('PARTNER_RSA')) list_of_flags=list_of_flags+',RSA'
		if (GlobalVariable.userPin3.contains('PARTNER_JAXA')) list_of_flags=list_of_flags+',JAXA'
		try{
			'check flags from attachments after save'
			if (list_of_flags.contains('CSA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag CSA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag CSA from attachment after adding attachment into record\n')
				}else{
					all_logMsg=all_logMsg+('not found flag CSA from attachment after adding attachment into record\n')
					test_failed=true
				}
			}else
				all_logMsg=all_logMsg+('not found flag CSA from attachment after adding attachment into record\n')
			if (list_of_flags.contains('ESA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag ESA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag ESA from attachment after adding attachment into record\n')
				}else{
					all_logMsg=all_logMsg+('not found flag ESA from attachment after adding attachment into record\n')
					test_failed=true
				}
			}else
				all_logMsg=all_logMsg+('not found flag ESA from attachment after adding attachment into record\n')
			if (list_of_flags.contains('JAXA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag JAXA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag JAXA from attachment after adding attachment into record\n')
				}else{
					all_logMsg=all_logMsg+('not found flag JAXA from attachment after adding attachment into record\n')
					test_failed=true
				}
			}else
				all_logMsg=all_logMsg+('not found flag JAXA from attachment after adding attachment into record\n')
			if (list_of_flags.contains('RSA')){
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_flag RSA'),1,FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+('found flag RSA from attachment after adding attachment into record\n')
				}else{
					all_logMsg=all_logMsg+('not found flag RSA from attachment after adding attachment into record\n')
					test_failed=true
				}
			}else
				all_logMsg=all_logMsg+('not found flag RSA from attachment after adding attachment into record\n')

		} catch (Exception e) {
			KeywordUtil.logInfo "cannot check flag from attachments after save"
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
	def verify_attachment_partner_flags_before_save(list_of_flags,user_name,product,def info=null){
		boolean test_failed=false
		String all_logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected "visible and checked" Flags from attachment level before save ='+list_of_flags+'\n'
		if (info!=null) all_logMsg=all_logMsg+info+'\n'
		if (GlobalVariable.userPin3.contains('PARTNER_RSA')) list_of_flags=list_of_flags+',RSA'
		if (GlobalVariable.userPin3.contains('PARTNER_JAXA')) list_of_flags=list_of_flags+',JAXA'
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5) ){
			KeywordUtil.logInfo ('found save button, so the record page is displayed')
		}else{
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_cannot_find_record')
			KeywordUtil.markFailedAndStop("cannot determine the record page is displayed")
		}
		/////////
		if (list_of_flags.contains('CSA')){
			if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
				all_logMsg=all_logMsg+'CSA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with CSA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_CSA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with CSA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'CSA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'CSA Flag not displayed as expected\n'
		}
		/////////
		if (list_of_flags.contains('ESA')){
			if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
				all_logMsg=all_logMsg+'ESA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with ESA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_ESA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with ESA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'ESA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'ESA Flag not displayed as expected\n'
		}
		/////////
		if (list_of_flags.contains('JAXA')){
			if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
				all_logMsg=all_logMsg+'JAXA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with JAXA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_JAXA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with JAXA: visible and checked\n'
					test_failed=true
				}else
					all_logMsg=all_logMsg+'JAXA: Flag visible (Flag unchecked) as expected\n'
			}else
				all_logMsg=all_logMsg+'JAXA Flag not displayed as expected\n'
		}
		/////////

		if (list_of_flags.contains('RSA')){
			if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
				all_logMsg=all_logMsg+'RSA: Flag visible and checked as expected\n'
			}else{
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with RSA: visible and checked\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'), 1,FailureHandling.CONTINUE_ON_FAILURE)){
				if (WebUI.waitForElementHasAttribute(findTestObject('Page_Enter Record View/checkbox_attachment_RSA_Flag'), 'checked', 1, FailureHandling.OPTIONAL)){
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
		String logMsg_checkboxes_selected=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected checkboxes_selected="'+checkboxes_selected+'"\n'
		String logMsg_checkboxes_disabled=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected checkboxes_disabled="'+checkboxes_disabled+'"\n'
		String logMsg_checkboxes_visible= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected checkboxes_visible="'+checkboxes_visible+'"\n'
		String logMsg_checkboxes= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\n'

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
			//KeywordUtil.markFailed(logMsg_checkboxes_visible+'ERROR: checkboxes_visible_set NOT = visible_checkboxes_set\nexpected:'+checkboxes_visible_set+'\nactual:'+visible_checkboxes_set+'\n')
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_checkboxes_visible')
			runScreenshot=true
		}
		if (runScreenshot){
			KeywordUtil.markFailed(all_logMsg_checkboxes)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_attachment_flags_status')
		}
	}

	@Keyword
	def create_record_from_template(record_title,product,component,export_control_rating,proprietary_limited_rights,record_not_visible){
		String logMsg='\nproduct='+product+', record_title='+record_title+', component='+component+', export_control_rating='+export_control_rating+', proprietary_limited_rights='+proprietary_limited_rights+'\n'
		String siteURL=GlobalVariable.G_MAKE_MAS_url
		if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
		String Create_record_from_template_url=siteURL+'/select_template.cgi'
		WebUI.navigateToUrl(Create_record_from_template_url)
		// Create record from template
		/*WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'),10)
		 WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'),10)
		 WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_Create record from template'))
		 */
		//select first option of bug template from the list and use the selected template
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Select Template/input_first_bugid_selection'),10)
		WebUI.click(findTestObject('Object Repository/Page_Select Template/input_first_bugid_selection'))
		WebUI.click(findTestObject('Object Repository/Page_Select Template/button_Use Selected Template'))
		if (record_not_visible.toLowerCase().equals('x')){
			if (WebUI.waitForElementPresent(findTestObject('Page_Missing or Invalid User/b_You made an invalid entry'),5,FailureHandling.OPTIONAL)){
				KeywordUtil.markPassed('found "You made an invalid entry", record is not visible as expected, done create_record_from_template\n'+logMsg)
				return
			}else{
				KeywordUtil.markFailed('NOT found "You made an invalid entry", record should not be visible')
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_record_visible')
				return
			}
		}else{
			KeywordUtil.logInfo('continue to create record from template')
		}
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
		check_record_created()
		KeywordUtil.markPassed('done create_record_from_template\n'+logMsg)
	}

	@Keyword
	def create_version_clone_record(){
		//WebUI.refresh()
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),50)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),50)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),20)
		//WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),20)
		WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),12)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
		try{
			//WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'),6)
			WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_Create a new version'))
		}catch (Exception e) {
			WebUI.refresh(FailureHandling.OPTIONAL)
			WebUI.delay(10)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),20)
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
		if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/select_product'),7,FailureHandling.STOP_ON_FAILURE)){
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
		WebUI.delay(2)
		check_record_created()
		check_record_save_alert()
		KeywordUtil.markPassed('edit product successful to new_product='+new_product+' and new_component='+new_component)
	}
	@Keyword
	def create_record_from_record(record_title){
		//record_title='test_1'
		WebUI.refresh(FailureHandling.OPTIONAL)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Linked_Causes_Add_New_Record'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Linked_Causes_Add_New_Record'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/input_Title_newRecordContainer'),5)
		WebUI.setText(findTestObject('Object Repository/Page_Record_Created/input_Title_newRecordContainer'),record_title)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(4)
		check_record_save_alert()
		check_record_created()
		check_record_save_alert()

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
		WebUI.delay(6)
		check_record_created()
	}
	def
	@Keyword closeExtraWindowTabs(){
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.switchToWindowIndex(0)
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		KeywordUtil.logInfo("No. of tabs: " + tabs.size());
		int tabs_number=tabs.size()
		while (tabs_number>1){
			WebUI.closeWindowIndex(tabs_number-1,FailureHandling.CONTINUE_ON_FAILURE)
			tabs_number--
		}
		WebUI.switchToWindowIndex(0)
	}
	def verify_XML_element(group_names,user_name,product){
		//group_names='_NASA|RSA<'
		boolean test_failed=false
		String all_logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected group_names in XML doc = '+group_names+'\n'
		String[] group_name_list
		group_name_list = group_names.split('\\|')
		int currentTab = WebUI.getWindowIndex()
		String xml_page_contents
		//WebDriver driver = DriverFactory.getWebDriver()
		int i=5
		while (i>0){
			try{
				WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/a_XML'), 10)
				WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/a_XML'), 10)
				WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_XML'))
				WebUI.delay(1)
				WebUI.switchToWindowIndex(currentTab+1)
				//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/span_group id_tag'),3,FailureHandling.OPTIONAL)
				//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/span_This XML file does not appear'),5,FailureHandling.OPTIONAL)
				xml_page_contents=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/all_XML_contents'))
				WebUI.closeWindowIndex(currentTab + 1)
				WebUI.switchToWindowIndex(currentTab)
				break
			}catch (Exception e) {
				closeExtraWindowTabs()
				WebUI.delay(1)
				i--
			}
		}
		for( String group_name : group_name_list ){
			KeywordUtil.logInfo(group_name)
			if (xml_page_contents.contains(group_name)){
				all_logMsg=(all_logMsg+'PASS: Group "' + group_name + '" Found in XML doc\n')
			}else{
				all_logMsg=(all_logMsg+'ERROR: Group "' + group_name + '" Not Found in XML doc\n')
				test_failed=true
			}
		}
		if (test_failed){
			KeywordUtil.markFailed(all_logMsg)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')
		}
		else{
			KeywordUtil.markPassed(all_logMsg)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')
		}
		WebUI.delay(1)
		if (! WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'), 60, FailureHandling.OPTIONAL)) {
			KeywordUtil.markFailed("cannot find Home tab clickable")
		}
		if (! WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Main Page/a_Home'), 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markWarning("cannot find Home tab visible")
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_flag_status')

		}
	}
	@Keyword
	def verify_partner_flags(list_of_flags,user_name,product){
		boolean test_failed=false
		String logMsg=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected record level "GRANTED ACCESS" permission Flags='+list_of_flags+'\n'
		String all_logMsg=logMsg
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),5) ){
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
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_CSA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with CSA: GRANTED ACCESS.\n'
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
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with ESA: GRANTED ACCESS.\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_ESA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with ESA: GRANTED ACCESS.\n'
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
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with JAXA: GRANTED ACCESS.\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_JAXA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with JAXA: GRANTED ACCESS.\n'
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
				all_logMsg=all_logMsg+'ERROR: Cannot find flag with RSA: GRANTED ACCESS.\n'
				test_failed=true
			}
		}else{
			if (WebUI.waitForElementPresent(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 1,FailureHandling.OPTIONAL)){
				if ((WebUI.getAttribute(findTestObject('Page_Record_Created/flag_IP_ACCESS_RSA'), 'title')).contains('GRANTED ACCESS')){
					all_logMsg=all_logMsg+'ERROR: displayed invalid flag with RSA: GRANTED ACCESS.\n'
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
			if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),15,FailureHandling.OPTIONAL)){
				WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),3)
				WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),7)
				KeywordUtil.markPassed 'done end_session'
			}else{
				KeywordUtil.markFailed("not found 'end session' link, cannot end_session")
				(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
				//WebUI.closeBrowser()
			}
		}catch (Exception e) {
			KeywordUtil.markFailed("ERROR: cannot end_session...\n"+e.message)
			(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
			WebUI.closeBrowser()
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
	def impersonate(email,def info=null){
		//WebUI.refresh()
		closeExtraWindowTabs()
		if (WebUI.waitForAlert(1,FailureHandling.CONTINUE_ON_FAILURE)){
			String alertText=WebUI.getAlertText()
			WebUI.acceptAlert()
			WebUI.comment('accept alert='+alertText)
			KeywordUtil.markWarning('alertText "'+alertText+'" may not be acceptable')
		}
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),4,FailureHandling.OPTIONAL)){
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),5)
			if (WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating')).contains(email)){
				KeywordUtil.markPassed 'it is being impersonating user: '+email
				return
			}else{
				println 'current impersonating user:'+WebUI.getText(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'))
				println 'need to impersonating user: '+email
			}
		}
		try{
			if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'),1,FailureHandling.OPTIONAL)){
				WebUI.waitForElementClickable(findTestObject('Page_ISS Hazard Main Page/a_end session'),8)
				WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
			}
		} catch (Exception e) {
			WebUI.delay(5)
			WebUI.waitForElementClickable(findTestObject('Page_ISS Hazard Main Page/a_end session'),8)
			WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_end session'))
		}
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Sudo session started/b_impersonating'),8)

		WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Admin'), 16)
		WebUI.click(findTestObject('Page_Main Page/a_Admin'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Administer your installation/a_Users'),10)
		WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Users'))
		// search for user
		WebUI.setText(findTestObject('Object Repository/Page_Search users/input_matching_matchstr'), email+'\n')
		WebUI.click(findTestObject('Object Repository/Page_Select user/a_user_email_selection'))
		if (info!=null)
			check_user_enabled_permissions(email,info)
		else
			check_user_enabled_permissions(email)
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
		check_record_created()
		check_record_save_alert()
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
		WebUI.refresh()
		KeywordUtil.logInfo 'Go to approvals and concurrences tab'
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),20)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),20)
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
		check_record_save_alert()
		check_record_created()
		check_record_save_alert()
		WebUI.delay(1)
		// change record status to 'PHASE III APPROVED'
		record_status='PHASE III APPROVED'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/select_record_status'),10)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_record_status'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_record_status'), record_status, true)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),2)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(4)
		check_record_save_alert()
		check_record_created()
		check_record_save_alert()
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record test_automation_record/div_Close alertRecord Saved'),20)
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
				WebUI.waitForPageLoad(80, FailureHandling.OPTIONAL)
				if(WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),25) ){
					KeywordUtil.logInfo ('found save button, so the record has been created successfully'+logMsg)
				}else{
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
					KeywordUtil.markFailed("cannot determine the record has been created")
				}
				if(WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),25) ){
					KeywordUtil.logInfo ('found save button, so the record has been created successfully'+logMsg)
				}else{
					(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
					KeywordUtil.markFailed("cannot determine the record has been created")
				}
				WebUI.waitForPageLoad(80, FailureHandling.OPTIONAL)
				//WebUI.waitForAngularLoad(60, FailureHandling.STOP_ON_FAILURE)
				//WebUI.waitForJQueryLoad(60, FailureHandling.STOP_ON_FAILURE)
				if (! WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'), 60, FailureHandling.OPTIONAL)) {
					KeywordUtil.markWarning("cannot find Home tab clickable")
				}
				if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),35,FailureHandling.CONTINUE_ON_FAILURE)){
					if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'),30,FailureHandling.CONTINUE_ON_FAILURE)){
						recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/div_record_name_title'))
						KeywordUtil.markPassed ('record title: "'+recordID+'" has been created successfully'+logMsg)
						check_record_created_failed=false
					}
				}
				if( WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'),35,FailureHandling.CONTINUE_ON_FAILURE)){
					recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/strong_Record_ID_status'))
					KeywordUtil.markPassed ('record ID and status: "'+recordID+'" has been created successfully'+logMsg)
					check_record_created_failed=false
					if (recordID.length()>1)
						break
				}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'),1,FailureHandling.CONTINUE_ON_FAILURE)){
					recordID=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/b_Record_number_created'))
					KeywordUtil.markPassed ('record ID and status: "'+recordID+'" has been created successfully'+logMsg)
					check_record_created_failed=false
					if (recordID.length()>1)
						break
				}
				if (! WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'), 50, FailureHandling.OPTIONAL)) {
					KeywordUtil.markFailed("cannot find Home tab clickable")
				}
				if (! WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Main Page/a_Home'), 30, FailureHandling.OPTIONAL)) {
					KeywordUtil.markFailed("cannot find Home tab visible")
				}
			} catch (Exception e) {
				KeywordUtil.logInfo "continue..."
				WebUI.delay(2)
				i++
				if (i>10){
					KeywordUtil.markFailedAndStop("cannot determine the record has been created")
					break
				}
			}
		}
		String siteURL=WebUI.getUrl()
		siteURL=siteURL.substring(0,siteURL.lastIndexOf('#tv='))
		GlobalVariable.recordName2=siteURL
		KeywordUtil.markPassed 'current record url='+GlobalVariable.recordName2
	}
	@Keyword
	def check_user_enabled_permissions(user_name,def info=null){
		String user_enabled_permissions=''
		if (info!=null){
			user_enabled_permissions=info
		}
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Edit user info/a_Impersonate this user'),5)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Preferences/input_parameter_checked'),6)
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type = 'checkbox' and @checked = 'checked']"));
		int size=elements.size()

		user_enabled_permissions=user_enabled_permissions+'\nEnabled(Checked) permissions For the User: '+user_name+'\n'
		String parameter_enabled=''
		for (int i = 0; i < size; i++) {
			parameter_enabled = elements.get(i).getAttribute("class");
			user_enabled_permissions=user_enabled_permissions+parameter_enabled+'\n'
		}
		KeywordUtil.logInfo(user_enabled_permissions)
		GlobalVariable.userPin3=user_enabled_permissions
		return user_enabled_permissions
	}
	@Keyword
	def validate_ECR_checkboxes(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product,def info=null){
		String logMsg_checkboxes_selected=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+'on record='+GlobalVariable.recordName2+'\nExpected checkboxes_selected="'+checkboxes_selected+'"\n'
		String logMsg_checkboxes_disabled=GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected checkboxes_disabled="'+checkboxes_disabled+'"\n'
		String logMsg_checkboxes_visible= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n'+'\nExpected checkboxes_visible="'+checkboxes_visible+'"\n'
		String logMsg_checkboxes= GlobalVariable.userPin3+'\nTestcase: '+GlobalVariable.recordName1+'\nuser='+user_name+' on product='+product+' on record='+GlobalVariable.recordName2+'\n\n'
		if (info!=null) logMsg_checkboxes=logMsg_checkboxes+info+'\n'
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
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: selected_checkboxes values MATCH\n')
		}else if (checkboxes_selected_set.equals(selected_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: selected_checkboxes values MATCH\n')
		}else if (checkboxes_selected_set[0].length()==0 && selected_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: selected_checkboxes values MATCH\n')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: selected_checkboxes values NOT MATCH\nexpected:'+checkboxes_selected_set+'\nactual:'+selected_checkboxes_set+'\n'
			test_failed=true
		}
		if (checkboxes_disabled_set.isEmpty()&&disabled_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: disabled_checkboxes values MATCH\n')
		}else if (checkboxes_disabled_set.equals(disabled_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: disabled_checkboxes values MATCH\n')
		}else if (checkboxes_disabled_set[0].length()==0 && disabled_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: disabled_checkboxes values MATCH\n')
		}else{
			all_logMsg_checkboxes=all_logMsg_checkboxes+'\nERROR: disabled_checkboxes values NOT MATCH\nexpected:'+checkboxes_disabled_set+'\nactual:'+disabled_checkboxes_set+'\n'
			test_failed=true
		}
		if (checkboxes_visible_set.isEmpty()&&visible_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: visible_checkboxes values MATCH\n')
		}else if (checkboxes_visible_set.equals(visible_checkboxes_set)){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: visible_checkboxes values MATCH\n')
		}else if (checkboxes_visible_set[0].length()==0 && visible_checkboxes_set.isEmpty()){
			all_logMsg_checkboxes=all_logMsg_checkboxes+('\nPASS: visible_checkboxes values MATCH\n')
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
