import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;

import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable as GlobalVariable

/*New Record from Regular Create Page (New link) @Kristle

PASS: creating records from new link on products Boing/Khrunichev by 17 users, all verifications passed. 

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

int start_on_user_id=1 // default should be 1

CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)
////////////////////////////////////////////////////////////////////////////////////
//boolean run_loading_record_on_users=false
boolean run_search_record_title_and_attachment=false
KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
////////////////////
/*
Abyssinian 1
Cyprus 2
Manx 3
Nebelung 4
Norwegian Forest Cat 5
Peterbald 6
Scottish Fold 7
Selkirk Rex 8
Snowshoe 9
Sokoke 10
Turkish Van 11
Shaquille Oneil 12
Michael Jordan 13
Michael Jackson 14
Miguel 15
Monica 16
*/
//def users_list=[13]
//for (row in users_list) println 'run test on user='+row
//for (row in users_list){
////////////////////

for (row = start_on_user_id; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	CustomKeywords.'helper.login.LoginHelper.login'()
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user ('+row+')**********'
	try{
		product='Boeing'
		component='APAS'
		record_type='Hazard'
		expected_results='us_general'
		create_record_from_new_link(product,component,record_type,expected_results,row,run_search_record_title_and_attachment)
		
		product='Khrunichev'
		component='EPS'
		record_type='Hazard'
		expected_results='partner_general'
		create_record_from_new_link(product,component,record_type,expected_results,row,run_search_record_title_and_attachment)
		
		// end session
		//CustomKeywords.'ip_permissions.utils.end_session'()
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_create_record')
		KeywordUtil.markFailed('ERROR: adding new records on US or Partner products for user ('+row+')\n' +e.message)
	}
	
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user ('+row+')**********'
	
// !!!!! test
//if (row ==1) break
// !!!!! test
}
////////////////////////////////////////////////////////////////////////////////////

def create_record_from_new_link(product,component,record_type,expected_results,row,run_search_record_title_and_attachment){
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
	
	// verify result
	CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)	
	CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
	if (run_search_record_title_and_attachment){
		CustomKeywords.'ip_permissions.utils.search_attachment'(user_name,product)
		CustomKeywords.'ip_permissions.utils.search_record_title'()
	}

	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_create_record')
		KeywordUtil.markFailed('ERROR: create_record_from_new_link for user ('+row+')\n' +e.message)
	}
}