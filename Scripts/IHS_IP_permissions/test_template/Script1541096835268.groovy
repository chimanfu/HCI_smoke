import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

/*New Record Through Standard Hazard Template (ISS Hazard Only) @Max Rogers
Prereqs

Account for users set up correctly

Templates have been created

Code setup

User permissions set

Steps

From the Home page, click the "Create record from template" link

Select which type of template is to be used

Enter a Title for the new record

Enter a Hardware Provider for the new record

Enter a Subsystem/Payload for the new record

Create the record

Verify Partner flags

Verify ECR checkboxes

Verify XML*/

//GlobalVariable.G_MAKE_MAS_url='https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev'

KeywordUtil.logInfo 'Test: Create Record from Regular Create Page'
//CustomKeywords.'helper.login.LoginHelper.login'()
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
//GlobalVariable.G_wait_s=1
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)

////////////////////////////////////////////////////////////////////////////////////

//new_record_url=new_record_url+product
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
	expected_results='us_template'
	export_control_rating='ITAR'
	proprietary_limited_rights='TBD'
	create_record_from_template(product,component,record_type,expected_results,row,export_control_rating,proprietary_limited_rights)
	
	product='Khrunichev'
	component='EPS'
	record_type='Hazard'
	expected_results='partner_template'
	export_control_rating='ITAR'
	proprietary_limited_rights='TBD'
	create_record_from_template(product,component,record_type,expected_results,row,export_control_rating,proprietary_limited_rights)
	
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

def create_record_from_template(product,component,record_type,expected_results,row,export_control_rating,proprietary_limited_rights){
	try{
		String user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row,)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row,)
	KeywordUtil.logInfo('expected_results='+expected_results)
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	String info='verify create_record_from_template, on product: '+product+', record created by '+user_name+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
		
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
	CustomKeywords.'ip_permissions.utils.create_record_from_template'(record_title,product,component,export_control_rating,proprietary_limited_rights,record_not_visible)
	// verify result
	if (!record_not_visible.toLowerCase().equals('x')){
		CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
		CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
		
	}
	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
	//e.printStackTrace()
	(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
	KeywordUtil.markFailed('ERROR: create_record_from_new_link for user ('+row+')\n' +e.message)
}
}