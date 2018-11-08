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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

/*New Record through RecordLink-Buglist Linking (Colloquially, the "Create Cause From Hazard Feature") @Max Rogers
Prereqs

Account for users set up correctly

Hazard record already created (Boeing & Khrunichev)

Code setup

User permissions set

Steps

Go the the Hazard record page

Click "Create New Cause Record"

Insert a title for the new record

Save changes

Click on the record title

Verify Partner flags

Verify ECR checkboxes

Verify XML*/

KeywordUtil.logInfo 'Test: Create Cause Record through RecordLink From the record ("Create Cause From Hazard Feature")'
CustomKeywords.'helper.login.LoginHelper.login'()
KeywordLogger log = new KeywordLogger()

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
new_record_url=siteURL+'/enter_bug.cgi?product='
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'

expected_results_us_general='IHS_IP_permissions/expected_results_us (general)'
expected_results_us_VTL='IHS_IP_permissions/expected_results_us (VTL)'
expected_results_us_product='IHS_IP_permissions/expected_results_us (product)'
expected_results_us_template='IHS_IP_permissions/expected_results_us (template)'

expected_results_partner_general='IHS_IP_permissions/expected_results_partner (general)'
expected_results_partner_VTL='IHS_IP_permissions/expected_results_partner (VTL)'
expected_results_partner_product='IHS_IP_permissions/expected_results_partner (product)'
expected_results_partner_template='IHS_IP_permissions/expected_results_partner (template)'

String user_name=''
String user_email=''
String record_title=''
String component='APAS'
String record_type='Hazard'
String export_control_rating=''
String product=''
////////////////////////////////////////////////////

//new_record_url=new_record_url+product
log.logInfo('Iterate through test users in '+ip_test_user_list)
for (row = 1; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	
	user_name=(findTestData(ip_test_user_list).getValue('Name', row)).trim()
	user_email=(findTestData(ip_test_user_list).getValue('Email', row)).trim()
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user:'+user_name+', email:'+user_email+' **********'
	
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	//////////////////////////////////////////////////////////////////////
	// for each user, perform these actions
	CustomKeywords.'ip_permissions.utils.impersonate'(user_email)
	//////////////////////////////////////////////////////////////////////
	product='Boeing'
	component='APAS'
	KeywordUtil.logInfo '---------- Start adding new record for US:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	expected_results=expected_results_us_general
	name_expected_results=(findTestData(expected_results).getValue('Names', row)).trim()
	checkboxes_selected=(findTestData(expected_results).getValue('checkboxes_selected', row)).trim()
	checkboxes_disabled=(findTestData(expected_results).getValue('checkboxes_disabled', row)).trim()
	checkboxes_visible=(findTestData(expected_results).getValue('checkboxes_visible', row)).trim()
	record_not_visible=(findTestData(expected_results).getValue('record_not_visible', row)).trim()
	xml=(findTestData(expected_results).getValue('xml', row)).trim()
	group_names=xml
	flags=(findTestData(expected_results).getValue('flags', row)).trim()
	KeywordUtil.logInfo('name_expected_results='+name_expected_results)
	KeywordUtil.logInfo('checkboxes_selected='+checkboxes_selected)
	KeywordUtil.logInfo('checkboxes_disabled='+checkboxes_disabled)
	KeywordUtil.logInfo('checkboxes_visible='+checkboxes_visible)
	KeywordUtil.logInfo('record_not_visible='+record_not_visible)
	KeywordUtil.logInfo('xml='+xml)
	KeywordUtil.logInfo('flags='+flags)
	if (StringUtils.isNullOrEmpty(user_name)){
		log.logWarning('empty row found in user name field: '+user_name)
		//throw new AssertionError('ERROR: empty row found as '+user_name)
	}
	if (!name_expected_results.equals(user_name)){
		throw new AssertionError('ERROR: name in expected_results not matched with user_name in international_partner_permissions_test_user_list: '+name_expected_results+' and '+user_name)
	}
	record_title=CustomKeywords.'ip_permissions.utils.generate_unique_title'(product)
	KeywordUtil.logInfo('record_title='+record_title)
	CustomKeywords.'ip_permissions.utils.create_new_record'(product, record_title, component, record_type)
	CustomKeywords.'ip_permissions.utils.create_record_from_record'('Cause-'+record_title)
	
	// verify result
	CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
	KeywordUtil.logInfo '---------- Done adding new record for US:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	//////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////
	product='Khrunichev'
	component='EPS'
	KeywordUtil.logInfo '---------- Start adding new record for Partner:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	expected_results=expected_results_partner_general
	name_expected_results=(findTestData(expected_results).getValue('Names', row)).trim()
	checkboxes_selected=(findTestData(expected_results).getValue('checkboxes_selected', row)).trim()
	checkboxes_disabled=(findTestData(expected_results).getValue('checkboxes_disabled', row)).trim()
	checkboxes_visible=(findTestData(expected_results).getValue('checkboxes_visible', row)).trim()
	record_not_visible=(findTestData(expected_results).getValue('record_not_visible', row)).trim()
	xml=(findTestData(expected_results).getValue('xml', row)).trim()
	group_names=xml
	flags=(findTestData(expected_results).getValue('flags', row)).trim()
	KeywordUtil.logInfo('name_expected_results='+name_expected_results)
	KeywordUtil.logInfo('checkboxes_selected='+checkboxes_selected)
	KeywordUtil.logInfo('checkboxes_disabled='+checkboxes_disabled)
	KeywordUtil.logInfo('checkboxes_visible='+checkboxes_visible)
	KeywordUtil.logInfo('record_not_visible='+record_not_visible)
	KeywordUtil.logInfo('xml='+xml)
	KeywordUtil.logInfo('flags='+flags)
	if (StringUtils.isNullOrEmpty(user_name)){
		log.logWarning('empty row found in user name field: '+user_name)
		//throw new AssertionError('ERROR: empty row found as '+user_name)
	}
	if (!name_expected_results.equals(user_name)){
		throw new AssertionError('ERROR: name in expected_results not matched with user_name in international_partner_permissions_test_user_list: '+name_expected_results+' and '+user_name)
	}
	record_title=CustomKeywords.'ip_permissions.utils.generate_unique_title'(product)
	KeywordUtil.logInfo('record_title='+record_title)
	CustomKeywords.'ip_permissions.utils.create_new_record'(product, record_title, component, record_type)
	CustomKeywords.'ip_permissions.utils.create_record_from_record'('Cause-'+record_title)
	// verify result
	CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
	CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
	CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
	KeywordUtil.logInfo '---------- Done adding new record for Partner:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	//////////////////////////////////////////////////////////////////////
	
	
	// end session
	CustomKeywords.'ip_permissions.utils.end_session'()
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user:'+user_name+', email:'+user_email+' **********'
	
// !!!!! test
	if (row ==2) break
// !!!!! test
}

