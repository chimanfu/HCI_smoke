import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable
/*New Record Through VTL (ISS Hazard only) @Max Simpson
Prerequisites:

Account for users set up correctly

Code Setup:

User permissions configured correctly

Steps:

Go to create page through boeing and krunichev

Create a cause

Create verification and set closure status to closed to VTL, and save

Change record status to review then phase III approved

Click save

Navigate to newly created VTI (will see session expiration popup)

Verify partner flags

Verify ECR checkboxes

Verify XML

Repeat for Khrunichev

*/

KeywordUtil.logInfo 'Test: Create Record Through VTL (ISS Hazard only)'
//CustomKeywords.'helper.login.LoginHelper.login'()
ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'
//GlobalVariable.G_wait_s=1
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('failed_issue_count',0)

int start_on_user_id=1 // default should be 1
////////////////////////////////////////////////////////////////////////////////////

KeywordUtil.logInfo('Iterate through test users in '+ip_test_user_list)
////////////////////
//'replace the for statement with these lines for running only certain users from the users_list'
//def users_list=[4,6,7,10,12,15] // main user list
//for (row in users_list) println 'run test on user='+row
//for (row in users_list){
////////////////////

for (row = start_on_user_id; row <= findTestData(ip_test_user_list).getRowNumbers(); row++){
	CustomKeywords.'helper.login.LoginHelper.login'()
	KeywordUtil.logInfo '********** Staring adding new records on US and Partner products for user ('+row+')**********'
	try{
		product='Boeing'
		component='APAS'
		record_type='Cause'
		expected_results='us_VTL'
		create_record_from_VTL(product,component,record_type,expected_results,row)
		
		product='Khrunichev'
		component='C&DH'
		record_type='Cause'
		expected_results='partner_VTL'
		create_record_from_VTL(product,component,record_type,expected_results,row)
		
		// end session
		//CustomKeywords.'ip_permissions.utils.end_session'()
	} catch (Exception e) {
		//e.printStackTrace()
		//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
		KeywordUtil.markFailed('ERROR: adding new records on US or Partner products for user ('+row+')\n' +e.message)
		//WebUI.refresh()
	}
	KeywordUtil.logInfo '********** Done adding new records on US and Partner products for user ('+row+')**********'
	
// !!!!! test
//if (row ==3) break
// !!!!! test
}

////////////////////////////////////////////////////////////////////////////////////

def create_record_from_VTL(product,component,record_type,expected_results,row){
	String user_name=CustomKeywords.'ip_permissions.data.get'('user_name',row,)
	String user_email=CustomKeywords.'ip_permissions.data.get'('user_email',row,)
	KeywordUtil.logInfo('expected_results='+expected_results)
	KeywordUtil.logInfo('user_name='+user_name)
	KeywordUtil.logInfo('user_email='+user_email)
	String info='verify create_record_from_VTL, on product: '+product+', record created by '+user_name+'\n'+'expected_results using spreadsheet: '+expected_results+'\n'
	
	try{
		
		//////////////////////////////////////////////////////////////////////
		
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
		//try {
		// for each user, perform these actions
		
		//////////////////////////////////////////////////////////////////////
		// for each user, perform these actions
		CustomKeywords.'ip_permissions.utils.impersonate'(user_email,info)
		//////////////////////////////////////////////////////////////////////
	
		String record_title=CustomKeywords.'ip_permissions.utils.generate_unique_title'(product)
		KeywordUtil.logInfo('record_title='+record_title)
		String verification_status='Closed to VTL'
		//CustomKeywords.'ip_permissions.utils.create_new_record'(product, record_title, component, record_type)
		String record_id=CustomKeywords.'ip_permissions.utils.create_record_through_VTL'(product,record_title, component, record_type,verification_status)
		
		//verify can see record (record load), check that's correct
		KeywordUtil.logInfo('record_not_visible='+record_not_visible)
		if (record_not_visible.toLowerCase().equals('x')){
			KeywordUtil.markWarning('warning: record_not_visible=x, test may fail')
		}
		// verify result
		CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
		CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
		CustomKeywords.'ip_permissions.utils.verify_attachment_partner_flags_after_save'(flags,user_name,product)
		
		/*if (record_not_visible.equals('X')){
			KeywordUtil.markFailed( '!FAIL: ' + user_name + ' is NOT supposed to be able to see ' + 'record_key' + '\'s record ' + record_id + ' and can.')
		}else{
			// verify result
			CustomKeywords.'ip_permissions.utils.verify_partner_flags'(flags,user_name,product)
			CustomKeywords.'ip_permissions.utils.validate_ECR_checkboxes'(checkboxes_selected,checkboxes_disabled,checkboxes_visible,user_name,product)
			CustomKeywords.'ip_permissions.utils.verify_XML_element'(group_names,user_name,product)
			CustomKeywords.'ip_permissions.utils.add_verify_attachment_flags'(flags,user_name,product)
		}*/
		/*} catch (Exception e) {
			e.printStackTrace()
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_Something_wrong')
			if (record_not_visible.equals('true')){
				KeywordUtil.markFailed 'Need to confrim the behavior is correct +++++PASS: User cannot see record?\n'
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/Session Expiration'),1,FailureHandling.OPTIONAL)){
					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_Session_Expiration')
					KeywordUtil.markWarning("seeing Session_Expiration")
				}
			}else{
				KeywordUtil.markWarning('!FAIL: ' + user_name + ' is supposed to be able to see ' + 'record_key' + '\'s record ' + record_id + ' and can see.')
			}
			KeywordUtil.markFailed(GlobalVariable.recordName1+'_Something_wrong')
			WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
			WebUI.refresh()
			//WebUI.closeBrowser()
		}*/
	
	KeywordUtil.logInfo '---------- Done adding new record for product:'+product+' on user:'+user_name+', email:'+user_email+' ----------'
	} catch (Exception e) {
	//e.printStackTrace()
	//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_create_record')
	KeywordUtil.markFailed(info+'\nERROR: create_record_from_VTL\n' +e.message)
	//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	//WebUI.refresh(FailureHandling.OPTIONAL)
	CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()
	CustomKeywords.'helper.login.LoginHelper.login'()
}
}

