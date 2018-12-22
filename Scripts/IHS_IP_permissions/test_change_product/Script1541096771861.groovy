import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;

import internal.GlobalVariable

// automated testcases
//https://hci-confluence-old.arc.nasa.gov/display/automated/Test+cases

/*

site for the test https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_IP_auto_1/ 
https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev

need a special IHS dev site instance for the test?
how to create the users and their permissions? (with the 2 selenium scripts? do I need to create them first before running tests)
can we reuse the test data and user accounts after building new instance?
how to create the pre-existing records for the tests in international_partner_permissions_test_vars.xlsx
what are the differences among the 5 expected results?
what is fields_update_clone.xls?
any taxonomy change?

*/

/*New-like Record Through Changing Product @Max Simpson
 
Prerequisites:

Existing record to change the product

Account for test users set up

Code Setup:

User permissions configured correctly

Steps:

Go to edit record page of existing record

Change product to desired option

Click Save

Verify partner flags

Verify ECR checkboxes

Verify XML*/

KeywordUtil.logInfo 'Test: New-like Record Through Changing Product'
//CustomKeywords.'helper.login.LoginHelper.login'()
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
//GlobalVariable.G_wait_s=1
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)

////////////////////////////////////////////////////////////////////////////////////
int start_on_user_id=1 // default should be 1
KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
for (row = start_on_user_id; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user ('+row+')**********'
	try{
	
	product='Boeing'
	component='APAS'
	new_product='Khrunichev'
	new_component='EPS'
	record_type='Hazard'
	//expected_results='us_product'
	expected_results='partner_product'
	//info='changed product on record from Boeing to Khrunichev'
	CustomKeywords.'helper.login.LoginHelper.login'()
	create_record_from_change_product(product,component,record_type,expected_results,row,new_product, new_component)
	
	product='Khrunichev'
	component='EPS'
	new_product='Boeing'
	new_component='APAS'
	record_type='Hazard'
	//expected_results='partner_product'
	expected_results='us_product'
	//info='changed product on record from Khrunichev to Boeing'
	CustomKeywords.'helper.login.LoginHelper.login'()
	create_record_from_change_product(product,component,record_type,expected_results,row,new_product, new_component)
		
	// end session
	//CustomKeywords.'ip_permissions.utils.end_session'()
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
		KeywordUtil.markFailed('ERROR: adding new records on US or Partner products for user ('+row+')\n' +e.message)
	}
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user ('+row+')**********'
	
// !!!!! test
//if (row ==5) break
// !!!!! test
}
////////////////////////////////////////////////////////////////////////////////////

def create_record_from_change_product(product,component,record_type,expected_results,row,new_product, new_component){
	try{
	String user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row,)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row,)
	KeywordUtil.logInfo('expected_results='+expected_results)
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	String info='verify create_record_from_change_product, record created from product "'+product+'", then changed to product "'+new_product+'", record created by '+user_name+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
	
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
	CustomKeywords.'ip_permissions.utils.edit_product'(new_product, new_component)
	// verify result
	CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,new_product)
	CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,new_product)
	CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,new_product)
	CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,new_product)
	CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,new_product)
	
	
	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
	//e.printStackTrace()
	(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
	KeywordUtil.markFailed('ERROR: create_record_from_new_link for user ('+row+')\n' +e.message)
	}
}
