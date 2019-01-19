import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;


/*New Record through Cloning @Adeline
Prereqs

Account for users set up correctly

Pre-existing record to be cloned (Boeing & Khrunichev)

Code setup

Set permissions for users

Steps

Create new Boeing record

Click Clone

Verify Partner flags

Verify XML

Verify ECR checkboxes

Repeat above for Khrunichev*/

KeywordUtil.logInfo 'Test: Create New Record through Cloning'
//CustomKeywords.'helper.login.LoginHelper.login'()
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
//GlobalVariable.G_wait_s=1
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)

////////////////////////////////////////////////////////////////////////////////////

KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
////////////////////
//'replace the for statement with these lines for running only certain users from the users_list'
//def users_list=[4,6,7,10,12,15] // main user list
//for (row in users_list) println 'run test on user='+row
//for (row in users_list){
////////////////////

for (row = 1; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	CustomKeywords.'helper.login.LoginHelper.login'()
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user ('+row+')**********'
	try{
	product='Boeing'
	component='APAS'
	record_type='Hazard'
	expected_results='us_general'
	create_record_from_clone_record(product,component,record_type,expected_results,row)
	
	product='Khrunichev'
	component='EPS'
	record_type='Hazard'
	expected_results='partner_general'
	create_record_from_clone_record(product,component,record_type,expected_results,row)

	// end session
	//CustomKeywords.'ip_permissions.utils.end_session'()
	} catch (Exception e) {
		//e.printStackTrace()
		(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
		KeywordUtil.markFailed('ERROR: adding new records on US or Partner products for user ('+row+')\n' +e.message)
	}
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user ('+row+')**********'
	
// !!!!! test
//if (row ==2) break
// !!!!! test
}
////////////////////////////////////////////////////////////////////////////////////

def create_record_from_clone_record(product,component,record_type,expected_results,row){
	try{
	String user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row,)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row,)
	KeywordUtil.logInfo('expected_results='+expected_results)
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	String info='verify create_record_from_clone_record, on product: '+product+', record created by '+user_name+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
	
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
	CustomKeywords.'ip_permissions.utils.create_clone_record'()
	// verify result
	CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
	CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
	
	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
	//e.printStackTrace()
	(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
	KeywordUtil.markFailed('ERROR: create_record_from_new_link for user ('+row+')\n' +e.message)
	}
}
