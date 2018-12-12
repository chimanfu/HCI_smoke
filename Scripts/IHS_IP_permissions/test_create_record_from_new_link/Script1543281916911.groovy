import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;

import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable as GlobalVariable

/*New Record from Regular Create Page (New link) @Kristle

Prereqs

Account for users set up correctly

Code setup

Set permissions for users

Steps

Go to create page Boeing

Verify ECR checkboxes

Hit create button

Verify XML

Verify Flags

Verify ECR checkboxes

Repeat above for Khrunichev*/

KeywordUtil.logInfo 'Test: Create Record from Regular Create Page'
//CustomKeywords.'helper.login.LoginHelper.login'()
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
GlobalVariable.G_wait_s=1
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)
////////////////////////////////////////////////////////////////////////////////////
boolean run_loading_record_on_users=false
//new_record_url=new_record_url+product
KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
for (row = 1; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	CustomKeywords.'helper.login.LoginHelper.login'()
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user ('+row+')**********'
	try{
		product='Boeing'
		component='APAS'
		record_type='Hazard'
		expected_results='us_general'
		create_record_from_new_link(product,component,record_type,expected_results,row,run_loading_record_on_users)
		if (run_loading_record_on_users) loading_record_on_users(product,row)
		
		product='Khrunichev'
		component='EPS'
		record_type='Hazard'
		expected_results='partner_general'
		create_record_from_new_link(product,component,record_type,expected_results,row,run_loading_record_on_users)
		if (run_loading_record_on_users) loading_record_on_users(product,row)
		
		// end session
		//CustomKeywords.'ip_permissions.utils.end_session'()
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_create_record')
		KeywordUtil.markFailed('ERROR: adding new records on US or Partner products for user ('+row+')\n' +e.message)
	}
	
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user ('+row+')**********'
	
// !!!!! test
//if (row ==2) break
// !!!!! test
}
////////////////////////////////////////////////////////////////////////////////////

def loading_record_on_users(product,sheet){
	String siteURL=WebUI.getUrl()
	siteURL=siteURL.substring(0,siteURL.lastIndexOf('#tv='))

	GlobalVariable.recordName2=siteURL
	KeywordUtil.logInfo 'getting current record url='+GlobalVariable.recordName2
	'check_record_created should generate record url in GlobalVariable.recordName2'
	// test loading existing record on all users
	String ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
	String expected_results
	KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
	if (product.equals('Boeing'))
		expected_results='IHS_IP_permissions/expected_results_record_loading/us/expected_results_records_us (1) - Copy ('+sheet+')'
	else
		expected_results='IHS_IP_permissions/expected_results_record_loading/partner/expected_results_records_partner (1) - Copy ('+sheet+')'
	String user_name_createRecord=CustomKeywords.'ip_permissions.data.get'('user_name',sheet,ip_test_user_list)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',sheet,ip_test_user_list)
	String info='verify loading record on different users for product:'+product+', record created by '+user_name_createRecord+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
	KeywordUtil.logInfo('expected_results='+expected_results)
	String user_name
	for (int row = 1; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
		user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row,ip_test_user_list)
		user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row,ip_test_user_list)
		KeywordUtil.logInfo('user_name='+user_name)
		KeywordUtil.logInfo('user_email='+user_email)
		try{
		//////////////////////////////////////////////////////////////////////
			
		CustomKeywords.'ip_permissions.utils.impersonate'(user_email,info)
		KeywordUtil.logInfo '---------- Start loading new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	
		String name_expected_results=CustomKeywords.'ip_permissions.data.get'('name_expected_results',row,expected_results)
		String checkboxes_selected=CustomKeywords.'ip_permissions.data.get'('checkboxes_selected',row,expected_results)
		String checkboxes_disabled=CustomKeywords.'ip_permissions.data.get'('checkboxes_disabled',row,expected_results)
		String checkboxes_visible=CustomKeywords.'ip_permissions.data.get'('checkboxes_visible',row,expected_results)
		String record_not_visible=CustomKeywords.'ip_permissions.data.get'('record_not_visible',row,expected_results)
		String xml=CustomKeywords.'ip_permissions.data.get'('xml',row,expected_results)
		String group_names=CustomKeywords.'ip_permissions.data.get'('group_names',row,expected_results)
		String flags=CustomKeywords.'ip_permissions.data.get'('flags',row,expected_results)
		
		KeywordUtil.logInfo('name_expected_results='+name_expected_results)
		KeywordUtil.logInfo('checkboxes_selected='+checkboxes_selected)
		KeywordUtil.logInfo('checkboxes_disabled='+checkboxes_disabled)
		KeywordUtil.logInfo('checkboxes_visible='+checkboxes_visible)
		KeywordUtil.logInfo('record_not_visible='+record_not_visible)
		KeywordUtil.logInfo('xml='+xml)
		KeywordUtil.logInfo('flags='+flags)
		if (StringUtils.isNullOrEmpty(user_name)){
			KeywordUtil.markWarning('empty row found in user name field: '+user_name)
			//throw new AssertionError('ERROR: empty row found as '+user_name)
		}
		if (!name_expected_results.equals(user_name)){
			throw new AssertionError('ERROR: name in expected_results not matched with user_name in international_partner_permissions_test_user_list: '+name_expected_results+' and '+user_name)
		}
		// navigate to the new record
		KeywordUtil.logInfo ('current record url='+GlobalVariable.recordName2)
		WebUI.navigateToUrl(GlobalVariable.recordName2)
		WebUI.delay(4)
		if (! WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'), 20, FailureHandling.OPTIONAL)) {
				KeywordUtil.markFailed("cannot find Home tab clickable")
			}
		if (! WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Main Page/a_Home'), 20, FailureHandling.OPTIONAL)) {
				KeywordUtil.markFailed("cannot find Home tab visible")
			}
		// verify result
		if (record_not_visible.toLowerCase().equals('x')){
			KeywordUtil.logInfo 'record should not be visisble by the user: '+user_name
			if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Error/div_alert_not authorized to access record'),10, FailureHandling.OPTIONAL)) {
				KeywordUtil.markPassed('PASS: record is not visisble by the user: '+user_name)
			}else{
				KeywordUtil.markFailed('PASS: record is not visisble by the user: '+user_name)
			}
		}else{
			CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
			CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
			CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
			//if (user_name_createRecord.equals(user_name))
			CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
			CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
			CustomKeywords.'ip_permissions.utils.search_attachment'(user_name,product)
				
		}
		KeywordUtil.logInfo '---------- Done loading new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
		} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_loading_record')
		KeywordUtil.markFailed('ERROR: loading record for user ('+user_name+')\n' +e.message)
		}
		
		// !!!!! test
		//if (row ==2) break
		// !!!!! test
	}
	
}

def create_record_from_new_link(product,component,record_type,expected_results,row,run_loading_record_on_users){
	try{
	String user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row)
	KeywordUtil.logInfo('expected_results='+expected_results)
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	String info='verify creating record from new link for product:'+product+', record created by '+user_name+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
	
	//////////////////////////////////////////////////////////////////////
	// for each user, perform these actions
	CustomKeywords.'ip_permissions.utils.impersonate'(user_email,info)
	//////////////////////////////////////////////////////////////////////

	KeywordUtil.logInfo '---------- Start adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'

	String name_expected_results=CustomKeywords.'ip_permissions.data.get'('name_expected_results',row,expected_results)
	String checkboxes_selected=CustomKeywords.'ip_permissions.data.get'('checkboxes_selected',row,expected_results)
	String checkboxes_disabled=CustomKeywords.'ip_permissions.data.get'('checkboxes_disabled',row,expected_results)
	String checkboxes_visible=CustomKeywords.'ip_permissions.data.get'('checkboxes_visible',row,expected_results)
	String record_not_visible=CustomKeywords.'ip_permissions.data.get'('record_not_visible',row,expected_results)
	String xml=CustomKeywords.'ip_permissions.data.get'('xml',row,expected_results)
	String group_names=CustomKeywords.'ip_permissions.data.get'('group_names',row,expected_results)
	String flags=CustomKeywords.'ip_permissions.data.get'('flags',row,expected_results)
	
	KeywordUtil.logInfo('name_expected_results='+name_expected_results)
	KeywordUtil.logInfo('checkboxes_selected='+checkboxes_selected)
	KeywordUtil.logInfo('checkboxes_disabled='+checkboxes_disabled)
	KeywordUtil.logInfo('checkboxes_visible='+checkboxes_visible)
	KeywordUtil.logInfo('record_not_visible='+record_not_visible)
	KeywordUtil.logInfo('xml='+xml)
	KeywordUtil.logInfo('flags='+flags)
	if (StringUtils.isNullOrEmpty(user_name)){
		KeywordUtil.markWarning('empty row found in user name field: '+user_name)
		//throw new AssertionError('ERROR: empty row found as '+user_name)
	}
	if (!name_expected_results.equals(user_name)){
		throw new AssertionError('ERROR: name in expected_results not matched with user_name in international_partner_permissions_test_user_list: '+name_expected_results+' and '+user_name)
	}
	String record_title=CustomKeywords.'ip_permissions.utils.generate_unique_title'(product)
	KeywordUtil.logInfo('record_title='+record_title)
	CustomKeywords.'ip_permissions.utils.create_new_record'(product, record_title, component, record_type)
	if (!run_loading_record_on_users){
		// verify result
		CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)	
		CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
		//CustomKeywords.'ip_permissions.utils.search_attachment'(user_name,product)
		
	}
	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_create_record')
		KeywordUtil.markFailed('ERROR: create_record_from_new_link for user ('+row+')\n' +e.message)
	}
}