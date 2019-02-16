
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.List

import com.kms.katalon.core.testobject.TestObject

import org.openqa.selenium.WebElement


def static "question.CustomDatabase.executeQuery"(
    	String connectionUrl	
     , 	String query	) {
    (new question.CustomDatabase()).executeQuery(
        	connectionUrl
         , 	query)
}

def static "kramp.Internal_Linking.select_PRNT_1_GROUP_PRNT_1"() {
    (new kramp.Internal_Linking()).select_PRNT_1_GROUP_PRNT_1()
}

def static "kramp.Internal_Linking.verify_goto_Parent_Linking_Group"() {
    (new kramp.Internal_Linking()).verify_goto_Parent_Linking_Group()
}

def static "kramp.Internal_Linking.select_TAB_Group_Linking_Parent"() {
    (new kramp.Internal_Linking()).select_TAB_Group_Linking_Parent()
}

def static "kramp.Internal_Linking.select_TAB_Basic_Information"() {
    (new kramp.Internal_Linking()).select_TAB_Basic_Information()
}

def static "kramp.Internal_Linking.select_test_suite"(
    	String testSuiteName	) {
    (new kramp.Internal_Linking()).select_test_suite(
        	testSuiteName)
}

def static "kramp.Internal_Linking.select_TAB_Groups"() {
    (new kramp.Internal_Linking()).select_TAB_Groups()
}

def static "kramp.Internal_Linking.waitTestObject"(
    	String testobject	) {
    (new kramp.Internal_Linking()).waitTestObject(
        	testobject)
}

def static "kramp.Internal_Linking.reuse_linked_parent_save_changes"(
    	String linked_parent	) {
    (new kramp.Internal_Linking()).reuse_linked_parent_save_changes(
        	linked_parent)
}

def static "kramp.Internal_Linking.select_TAB_Group_Linking_Child"() {
    (new kramp.Internal_Linking()).select_TAB_Group_Linking_Child()
}

def static "kramp.Internal_Linking.delete_group_save_changes"() {
    (new kramp.Internal_Linking()).delete_group_save_changes()
}

def static "kramp.Internal_Linking.done_save_changes"() {
    (new kramp.Internal_Linking()).done_save_changes()
}

def static "kramp.Internal_Linking.unlink_parent_group_save_changes"() {
    (new kramp.Internal_Linking()).unlink_parent_group_save_changes()
}

def static "kramp.Internal_Linking.toggle_linkedPaperClip"() {
    (new kramp.Internal_Linking()).toggle_linkedPaperClip()
}

def static "kramp.Internal_Linking.unlink_child_group_save_changes"() {
    (new kramp.Internal_Linking()).unlink_child_group_save_changes()
}

def static "kramp.Internal_Linking.save_changes"() {
    (new kramp.Internal_Linking()).save_changes()
}

def static "com.common.utils.SetDesiredCapability.chrome"(
    	List desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).chrome(
        	desiredCapabilities)
}

def static "com.common.utils.SetDesiredCapability.firefox"(
    	Object desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).firefox(
        	desiredCapabilities)
}

def static "com.common.utils.SetDesiredCapability.ie"(
    	Object desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).ie(
        	desiredCapabilities)
}

def static "helper.javascript.JavaScriptHelper.appendBrowserLogs"() {
    (new helper.javascript.JavaScriptHelper()).appendBrowserLogs()
}

def static "helper.javascript.JavaScriptHelper.executeScript"(
    	String script	) {
    (new helper.javascript.JavaScriptHelper()).executeScript(
        	script)
}

def static "helper.javascript.JavaScriptHelper.executeScriptOnTestObject"(
    	String string	
     , 	TestObject testObject	) {
    (new helper.javascript.JavaScriptHelper()).executeScriptOnTestObject(
        	string
         , 	testObject)
}

def static "helper.javascript.JavaScriptHelper.executeAndReturnValue"(
    	String script	
     , 	TestObject testObject	) {
    (new helper.javascript.JavaScriptHelper()).executeAndReturnValue(
        	script
         , 	testObject)
}

def static "question.CustomJsonParser.jsonExtractor"(
    	String response	) {
    (new question.CustomJsonParser()).jsonExtractor(
        	response)
}

def static "question.VerifyAllElements.scrollAndVerfiyElement"(
    	String tagName	) {
    (new question.VerifyAllElements()).scrollAndVerfiyElement(
        	tagName)
}

def static "question.UniqueScreenShot.takeScreenShot"(
    	String path	
     , 	String name	) {
    (new question.UniqueScreenShot()).takeScreenShot(
        	path
         , 	name)
}

def static "reusableComponents.VerifyDataInWebTable.verify_expText_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_expText_In_Colum_Table(
        	tableObject
         , 	expText
         , 	expTextColNum)
}

def static "reusableComponents.VerifyDataInWebTable.verify_Deleted_ExpText_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_Deleted_ExpText_In_Colum_Table(
        	tableObject
         , 	expText
         , 	expTextColNum)
}

def static "reusableComponents.VerifyDataInWebTable.verify_MultipleTexts_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText1	
     , 	int expText1ColNum	
     , 	String expText2	
     , 	int expText2ColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_MultipleTexts_In_Colum_Table(
        	tableObject
         , 	expText1
         , 	expText1ColNum
         , 	expText2
         , 	expText2ColNum)
}

def static "reusableComponents.VerifyDataInWebTable.EditDelete_Click_Operation_In_WebTable"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	
     , 	String clickOperation	
     , 	int clickOperationColNum	
     , 	String clickAttribute	) {
    (new reusableComponents.VerifyDataInWebTable()).EditDelete_Click_Operation_In_WebTable(
        	tableObject
         , 	expText
         , 	expTextColNum
         , 	clickOperation
         , 	clickOperationColNum
         , 	clickAttribute)
}

def static "reusableComponents.VerifyDataInWebTable.Peform_AnchorClick_Operation_In_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	
     , 	int clickOperationColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).Peform_AnchorClick_Operation_In_Table(
        	tableObject
         , 	expText
         , 	expTextColNum
         , 	clickOperationColNum)
}

def static "question.GetMetrics.getAlarmsCountfromGA"() {
    (new question.GetMetrics()).getAlarmsCountfromGA()
}

def static "reusableComponents.Verify_Text_In_WebElement.verifyTextInWebelement"(
    	TestObject objectto	
     , 	String expText	) {
    (new reusableComponents.Verify_Text_In_WebElement()).verifyTextInWebelement(
        	objectto
         , 	expText)
}

def static "helper.login.LoginHelper.loginMailCatcher"() {
    (new helper.login.LoginHelper()).loginMailCatcher()
}

def static "helper.login.LoginHelper.loginVPN"() {
    (new helper.login.LoginHelper()).loginVPN()
}

def static "helper.login.LoginHelper.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new helper.login.LoginHelper()).addGlobalVariable(
        	name
         , 	value)
}

def static "helper.login.LoginHelper.checkHomePageExist"(
    	String site_url	) {
    (new helper.login.LoginHelper()).checkHomePageExist(
        	site_url)
}

def static "helper.login.LoginHelper.switch_to_training"() {
    (new helper.login.LoginHelper()).switch_to_training()
}

def static "helper.login.LoginHelper.login"() {
    (new helper.login.LoginHelper()).login()
}

def static "helper.login.LoginHelper.check_restore_pages_popup"() {
    (new helper.login.LoginHelper()).check_restore_pages_popup()
}

def static "helper.login.LoginHelper.check_accept_alert"() {
    (new helper.login.LoginHelper()).check_accept_alert()
}

def static "helper.login.LoginHelper.login"(
    	String site_url	) {
    (new helper.login.LoginHelper()).login(
        	site_url)
}

def static "helper.login.LoginHelper.smartcard_login_new"() {
    (new helper.login.LoginHelper()).smartcard_login_new()
}

def static "helper.login.LoginHelper.smartcard_login"() {
    (new helper.login.LoginHelper()).smartcard_login()
}

def static "kramp.Groups.select_TAB_Groups"() {
    (new kramp.Groups()).select_TAB_Groups()
}

def static "kramp.Groups.create_3_static_groups"() {
    (new kramp.Groups()).create_3_static_groups()
}

def static "kramp.Groups.delete_3_static_groups"() {
    (new kramp.Groups()).delete_3_static_groups()
}

def static "ip_permissions.utils.get_record_id"() {
    (new ip_permissions.utils()).get_record_id()
}

def static "ip_permissions.utils.search_record_title"() {
    (new ip_permissions.utils()).search_record_title()
}

def static "ip_permissions.utils.search_attachment"(
    	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).search_attachment(
        	user_name
         , 	product)
}

def static "ip_permissions.utils.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new ip_permissions.utils()).addGlobalVariable(
        	name
         , 	value)
}

def static "ip_permissions.utils.write_failed_result"(
    	Object col1	
     , 	Object col3	) {
    (new ip_permissions.utils()).write_failed_result(
        	col1
         , 	col3)
}

def static "ip_permissions.utils.testing"() {
    (new ip_permissions.utils()).testing()
}

def static "ip_permissions.utils.check_users_permissions"() {
    (new ip_permissions.utils()).check_users_permissions()
}

def static "ip_permissions.utils.create_new_users_with_permissions"() {
    (new ip_permissions.utils()).create_new_users_with_permissions()
}

def static "ip_permissions.utils.del_attachment_from_record"() {
    (new ip_permissions.utils()).del_attachment_from_record()
}

def static "ip_permissions.utils.add_attachments"(
    	Object num_attachments	) {
    (new ip_permissions.utils()).add_attachments(
        	num_attachments)
}

def static "ip_permissions.utils.add_verify_attachment_flags"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	
     , 	Object info	) {
    (new ip_permissions.utils()).add_verify_attachment_flags(
        	list_of_flags
         , 	user_name
         , 	product
         , 	info)
}

def static "ip_permissions.utils.verify_attachment_partner_flags_after_save"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	
     , 	Object info	) {
    (new ip_permissions.utils()).verify_attachment_partner_flags_after_save(
        	list_of_flags
         , 	user_name
         , 	product
         , 	info)
}

def static "ip_permissions.utils.check_edit_attachment_flags"(
    	Object list_of_flags	) {
    (new ip_permissions.utils()).check_edit_attachment_flags(
        	list_of_flags)
}

def static "ip_permissions.utils.verify_attachment_partner_flags_before_save"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	
     , 	Object info	) {
    (new ip_permissions.utils()).verify_attachment_partner_flags_before_save(
        	list_of_flags
         , 	user_name
         , 	product
         , 	info)
}

def static "ip_permissions.utils.validate_attachment_flags"(
    	Object checkboxes_selected	
     , 	Object checkboxes_disabled	
     , 	Object checkboxes_visible	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).validate_attachment_flags(
        	checkboxes_selected
         , 	checkboxes_disabled
         , 	checkboxes_visible
         , 	user_name
         , 	product)
}

def static "ip_permissions.utils.create_record_from_template"(
    	Object record_title	
     , 	Object product	
     , 	Object component	
     , 	Object export_control_rating	
     , 	Object proprietary_limited_rights	
     , 	Object record_not_visible	) {
    (new ip_permissions.utils()).create_record_from_template(
        	record_title
         , 	product
         , 	component
         , 	export_control_rating
         , 	proprietary_limited_rights
         , 	record_not_visible)
}

def static "ip_permissions.utils.create_version_clone_record"() {
    (new ip_permissions.utils()).create_version_clone_record()
}

def static "ip_permissions.utils.create_clone_record"() {
    (new ip_permissions.utils()).create_clone_record()
}

def static "ip_permissions.utils.edit_product"(
    	Object new_product	
     , 	Object new_component	) {
    (new ip_permissions.utils()).edit_product(
        	new_product
         , 	new_component)
}

def static "ip_permissions.utils.create_record_from_record"(
    	Object record_title	) {
    (new ip_permissions.utils()).create_record_from_record(
        	record_title)
}

def static "ip_permissions.utils.closeExtraWindowTabs"() {
    (new ip_permissions.utils()).closeExtraWindowTabs()
}

def static "ip_permissions.utils.verify_partner_flags"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).verify_partner_flags(
        	list_of_flags
         , 	user_name
         , 	product)
}

def static "ip_permissions.utils.end_session"() {
    (new ip_permissions.utils()).end_session()
}

def static "ip_permissions.utils.generate_unique_title"(
    	Object product	) {
    (new ip_permissions.utils()).generate_unique_title(
        	product)
}

def static "ip_permissions.utils.impersonate"(
    	Object email	
     , 	Object info	) {
    (new ip_permissions.utils()).impersonate(
        	email
         , 	info)
}

def static "ip_permissions.utils.create_record_through_VTL"(
    	Object product	
     , 	Object record_title	
     , 	Object component	
     , 	Object record_type	
     , 	Object verification_status	) {
    (new ip_permissions.utils()).create_record_through_VTL(
        	product
         , 	record_title
         , 	component
         , 	record_type
         , 	verification_status)
}

def static "ip_permissions.utils.navigate_VTI_ID"() {
    (new ip_permissions.utils()).navigate_VTI_ID()
}

def static "ip_permissions.utils.approve_record"() {
    (new ip_permissions.utils()).approve_record()
}

def static "ip_permissions.utils.create_new_record"(
    	Object product	
     , 	Object record_title	
     , 	Object component	
     , 	Object record_type	) {
    (new ip_permissions.utils()).create_new_record(
        	product
         , 	record_title
         , 	component
         , 	record_type)
}

def static "ip_permissions.utils.check_record_created"() {
    (new ip_permissions.utils()).check_record_created()
}

def static "ip_permissions.utils.check_user_enabled_permissions"(
    	Object user_name	
     , 	Object info	) {
    (new ip_permissions.utils()).check_user_enabled_permissions(
        	user_name
         , 	info)
}

def static "ip_permissions.utils.validate_ECR_checkboxes"(
    	Object checkboxes_selected	
     , 	Object checkboxes_disabled	
     , 	Object checkboxes_visible	
     , 	Object user_name	
     , 	Object product	
     , 	Object info	) {
    (new ip_permissions.utils()).validate_ECR_checkboxes(
        	checkboxes_selected
         , 	checkboxes_disabled
         , 	checkboxes_visible
         , 	user_name
         , 	product
         , 	info)
}

def static "ip_permissions.utils.write_failed_result"(
    	Object col1	) {
    (new ip_permissions.utils()).write_failed_result(
        	col1)
}

def static "ip_permissions.utils.write_failed_result"() {
    (new ip_permissions.utils()).write_failed_result()
}

def static "ip_permissions.utils.add_verify_attachment_flags"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).add_verify_attachment_flags(
        	list_of_flags
         , 	user_name
         , 	product)
}

def static "ip_permissions.utils.verify_attachment_partner_flags_after_save"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).verify_attachment_partner_flags_after_save(
        	list_of_flags
         , 	user_name
         , 	product)
}

def static "ip_permissions.utils.verify_attachment_partner_flags_before_save"(
    	Object list_of_flags	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).verify_attachment_partner_flags_before_save(
        	list_of_flags
         , 	user_name
         , 	product)
}

def static "ip_permissions.utils.impersonate"(
    	Object email	) {
    (new ip_permissions.utils()).impersonate(
        	email)
}

def static "ip_permissions.utils.check_user_enabled_permissions"(
    	Object user_name	) {
    (new ip_permissions.utils()).check_user_enabled_permissions(
        	user_name)
}

def static "ip_permissions.utils.validate_ECR_checkboxes"(
    	Object checkboxes_selected	
     , 	Object checkboxes_disabled	
     , 	Object checkboxes_visible	
     , 	Object user_name	
     , 	Object product	) {
    (new ip_permissions.utils()).validate_ECR_checkboxes(
        	checkboxes_selected
         , 	checkboxes_disabled
         , 	checkboxes_visible
         , 	user_name
         , 	product)
}

def static "reusableComponents.VerifyDrodownValues_AlphabeticalOrder.verifyOptionsInDropdownInAphabeticalOrder"(
    	TestObject objectto	) {
    (new reusableComponents.VerifyDrodownValues_AlphabeticalOrder()).verifyOptionsInDropdownInAphabeticalOrder(
        	objectto)
}

def static "com.common.utils.ScreenShot.takeScreenShot"(
    	String path	
     , 	String name	) {
    (new com.common.utils.ScreenShot()).takeScreenShot(
        	path
         , 	name)
}

def static "helper.navigate.NavigationHelper.navigateToMenuItem"(
    	String menuName	) {
    (new helper.navigate.NavigationHelper()).navigateToMenuItem(
        	menuName)
}

def static "question.RandomEmail.getEmail"(
    	String suffix	
     , 	String prefix	) {
    (new question.RandomEmail()).getEmail(
        	suffix
         , 	prefix)
}

def static "hci_smoke_test.common.replaceTextFromAllProfiles"(
    	Object srcExp	
     , 	Object replaceText	) {
    (new hci_smoke_test.common()).replaceTextFromAllProfiles(
        	srcExp
         , 	replaceText)
}

def static "hci_smoke_test.common.waifForElement"(
    	String xpath	
     , 	int inSeconds	) {
    (new hci_smoke_test.common()).waifForElement(
        	xpath
         , 	inSeconds)
}

def static "hci_smoke_test.common.waifForElementPresent"(
    	String xpath	
     , 	int inSeconds	) {
    (new hci_smoke_test.common()).waifForElementPresent(
        	xpath
         , 	inSeconds)
}

def static "hci_smoke_test.common.check_PDFFile_Downloaded"(
    	int seconds	) {
    (new hci_smoke_test.common()).check_PDFFile_Downloaded(
        	seconds)
}

def static "hci_smoke_test.common.checkText"() {
    (new hci_smoke_test.common()).checkText()
}

def static "hci_smoke_test.common.testfail"() {
    (new hci_smoke_test.common()).testfail()
}

def static "hci_smoke_test.common.check_defaultFile_Downloaded"(
    	int seconds	) {
    (new hci_smoke_test.common()).check_defaultFile_Downloaded(
        	seconds)
}

def static "hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible"(
    	boolean STOP_ON_FAILURE	) {
    (new hci_smoke_test.common()).verifyAllLinksOnCurrentPageAccessible(
        	STOP_ON_FAILURE)
}

def static "hci_smoke_test.common.checkLinksBrokenOnCurrentPage"() {
    (new hci_smoke_test.common()).checkLinksBrokenOnCurrentPage()
}

def static "hci_smoke_test.common.navigateAllLinks_ByXpath"(
    	String xpath	) {
    (new hci_smoke_test.common()).navigateAllLinks_ByXpath(
        	xpath)
}

def static "hci_smoke_test.common.appendBrowserLogs"() {
    (new hci_smoke_test.common()).appendBrowserLogs()
}

def static "hci_smoke_test.common.refreshBrowser"() {
    (new hci_smoke_test.common()).refreshBrowser()
}

def static "hci_smoke_test.common.clickElement"(
    	TestObject to	) {
    (new hci_smoke_test.common()).clickElement(
        	to)
}

def static "hci_smoke_test.common.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new hci_smoke_test.common()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "reusableComponents.DatepickerHandler.handleDatepicker"(
    	TestObject calender	
     , 	String exp_Date	
     , 	String exp_Month	
     , 	String exp_Year	) {
    (new reusableComponents.DatepickerHandler()).handleDatepicker(
        	calender
         , 	exp_Date
         , 	exp_Month
         , 	exp_Year)
}

def static "reusableComponents.VerifyExpectedAndActualOptionsInDropdown.VerifyExpectedAndActual"(
    	TestObject objectto	
     , 	List listOfOptions	) {
    (new reusableComponents.VerifyExpectedAndActualOptionsInDropdown()).VerifyExpectedAndActual(
        	objectto
         , 	listOfOptions)
}

def static "reusableComponents.HighlightElement.run"(
    	TestObject objectto	) {
    (new reusableComponents.HighlightElement()).run(
        	objectto)
}

def static "kramp.Notifications.compare_dateTime_mailTriggered_mailRecevied"(
    	String triggered_notification_dateTime	
     , 	String received_mail_dateTime	) {
    (new kramp.Notifications()).compare_dateTime_mailTriggered_mailRecevied(
        	triggered_notification_dateTime
         , 	received_mail_dateTime)
}

def static "kramp.Notifications.search_notifications_mailcatcher"(
    	String mail_From_expected	
     , 	String mail_To_expected	
     , 	String mail_Subject_expected	
     , 	String mail_Triggered_time	) {
    (new kramp.Notifications()).search_notifications_mailcatcher(
        	mail_From_expected
         , 	mail_To_expected
         , 	mail_Subject_expected
         , 	mail_Triggered_time)
}

def static "reusableComponents.webTable.Edit_Delete_Update_Anchor_actions"(
    	String ExpectedRowName	
     , 	int Column	
     , 	int AchorLink	) {
    (new reusableComponents.webTable()).Edit_Delete_Update_Anchor_actions(
        	ExpectedRowName
         , 	Column
         , 	AchorLink)
}

def static "reusableComponents.webTable.GetText_From_WebTable"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).GetText_From_WebTable(
        	ExpectedRowName
         , 	Column)
}

def static "reusableComponents.webTable.GetText_From_WebTable_Organisation"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).GetText_From_WebTable_Organisation(
        	ExpectedRowName
         , 	Column)
}

def static "reusableComponents.webTable.Selecting_CheckBox_From_WebTable"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).Selecting_CheckBox_From_WebTable(
        	ExpectedRowName
         , 	Column)
}

def static "com.jira.components.JSelect.selectByText"(
    	TestObject o	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	o
         , 	optionText)
}

def static "com.jira.components.JSelect.selectByText"(
    	String labelSelect	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	labelSelect
         , 	optionText)
}

def static "com.jira.components.JSelect.selectByText"(
    	WebElement el	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	el
         , 	optionText)
}

def static "helper.excel.ExcelHelper.writeTOExcelFile"(
    	String excelPath	
     , 	String sheetName	
     , 	String value	
     , 	int rowNo	
     , 	int colNo	) {
    (new helper.excel.ExcelHelper()).writeTOExcelFile(
        	excelPath
         , 	sheetName
         , 	value
         , 	rowNo
         , 	colNo)
}

def static "question.UniqueSelection.SelectCheckBox"() {
    (new question.UniqueSelection()).SelectCheckBox()
}

def static "attachments.utils.add_attachments_all"() {
    (new attachments.utils()).add_attachments_all()
}

def static "attachments.utils.isFileDownloaded"(
    	String downloadPath	
     , 	String fileName	
     , 	Object delayTime	) {
    (new attachments.utils()).isFileDownloaded(
        	downloadPath
         , 	fileName
         , 	delayTime)
}

def static "attachments.utils.verify_search_attachment"() {
    (new attachments.utils()).verify_search_attachment()
}

def static "attachments.utils.get_record_id"() {
    (new attachments.utils()).get_record_id()
}

def static "attachments.utils.reuse_delete_related_attachments_On_RecordTypeField"() {
    (new attachments.utils()).reuse_delete_related_attachments_On_RecordTypeField()
}

def static "attachments.utils.add_delete_related_attachments_On_RecordTypeField"() {
    (new attachments.utils()).add_delete_related_attachments_On_RecordTypeField()
}

def static "attachments.utils.error_handling"() {
    (new attachments.utils()).error_handling()
}

def static "attachments.utils.obsolete_attachments"() {
    (new attachments.utils()).obsolete_attachments()
}

def static "attachments.utils.add_attachments"(
    	Object num_attachments	) {
    (new attachments.utils()).add_attachments(
        	num_attachments)
}

def static "attachments.utils.save_changes_and_time"() {
    (new attachments.utils()).save_changes_and_time()
}

def static "attachments.utils.save_changes"() {
    (new attachments.utils()).save_changes()
}

def static "attachments.utils.verify_edit_attachments"() {
    (new attachments.utils()).verify_edit_attachments()
}

def static "attachments.utils.verify_downloading_attachments"() {
    (new attachments.utils()).verify_downloading_attachments()
}

def static "attachments.utils.verify_filtering_search"() {
    (new attachments.utils()).verify_filtering_search()
}

def static "attachments.utils.verify_sorting_options"() {
    (new attachments.utils()).verify_sorting_options()
}

def static "attachments.utils.isFileDownloaded"(
    	String downloadPath	
     , 	String fileName	) {
    (new attachments.utils()).isFileDownloaded(
        	downloadPath
         , 	fileName)
}

def static "question.ClickAnyLink.wrapperClick"(
    	String linkName	) {
    (new question.ClickAnyLink()).wrapperClick(
        	linkName)
}

def static "helper.browserhelper.CustomBrowser.openBrowser"() {
    (new helper.browserhelper.CustomBrowser()).openBrowser()
}

def static "helper.browserhelper.CustomBrowser.openBrowserWithUrl"(
    	String url	) {
    (new helper.browserhelper.CustomBrowser()).openBrowserWithUrl(
        	url)
}

def static "helper.browserhelper.CustomBrowser.closeBrowser"() {
    (new helper.browserhelper.CustomBrowser()).closeBrowser()
}

def static "helper.browserhelper.CustomBrowser.takingScreenshot"(
    	String screenshotname	) {
    (new helper.browserhelper.CustomBrowser()).takingScreenshot(
        	screenshotname)
}

def static "helper.browserhelper.CustomBrowser.takingScreenshotStatus"(
    	String testcaseName	
     , 	String testStatus	) {
    (new helper.browserhelper.CustomBrowser()).takingScreenshotStatus(
        	testcaseName
         , 	testStatus)
}

def static "helper.browserhelper.CustomBrowser.not_save_exit"() {
    (new helper.browserhelper.CustomBrowser()).not_save_exit()
}

def static "helper.grid.GridHelper.GetValueFromGrid"(
    	TestObject baseTestObject	
     , 	int rowIndex	
     , 	int colIndex	) {
    (new helper.grid.GridHelper()).GetValueFromGrid(
        	baseTestObject
         , 	rowIndex
         , 	colIndex)
}

def static "helper.grid.GridHelper.getValueOrClickOnColumn"(
    	TestObject baseTestObject	
     , 	int rowIndex	
     , 	int colIndex	
     , 	String type	) {
    (new helper.grid.GridHelper()).getValueOrClickOnColumn(
        	baseTestObject
         , 	rowIndex
         , 	colIndex
         , 	type)
}

def static "randomData.TestDataGenerator.getRandomParagraphs"(
    	int a	
     , 	int b	) {
    (new randomData.TestDataGenerator()).getRandomParagraphs(
        	a
         , 	b)
}

def static "randomData.TestDataGenerator.getRandomName"(
    	int a	
     , 	int b	) {
    (new randomData.TestDataGenerator()).getRandomName(
        	a
         , 	b)
}

def static "randomData.TestDataGenerator.getRandomFemaleName"() {
    (new randomData.TestDataGenerator()).getRandomFemaleName()
}

def static "randomData.TestDataGenerator.getRandomMaleName"() {
    (new randomData.TestDataGenerator()).getRandomMaleName()
}

def static "randomData.TestDataGenerator.getRandomFirstName"() {
    (new randomData.TestDataGenerator()).getRandomFirstName()
}

def static "randomData.TestDataGenerator.getRandomLastName"() {
    (new randomData.TestDataGenerator()).getRandomLastName()
}

def static "randomData.TestDataGenerator.getRandomCity"() {
    (new randomData.TestDataGenerator()).getRandomCity()
}

def static "randomData.TestDataGenerator.getRandomHeading"(
    	int numberofWords	) {
    (new randomData.TestDataGenerator()).getRandomHeading(
        	numberofWords)
}

def static "randomData.TestDataGenerator.getRandomHeading_two"(
    	int Wordsfrom	
     , 	int wordstwo	) {
    (new randomData.TestDataGenerator()).getRandomHeading_two(
        	Wordsfrom
         , 	wordstwo)
}

def static "randomData.TestDataGenerator.getRandomEmail"() {
    (new randomData.TestDataGenerator()).getRandomEmail()
}

def static "randomData.TestDataGenerator.set_RandomNumber"(
    	long len	) {
    (new randomData.TestDataGenerator()).set_RandomNumber(
        	len)
}

def static "randomData.TestDataGenerator.set_RandomNumberWithText"(
    	int length	) {
    (new randomData.TestDataGenerator()).set_RandomNumberWithText(
        	length)
}

def static "randomData.TestDataGenerator.getRandomPhoneNumberINDIA"() {
    (new randomData.TestDataGenerator()).getRandomPhoneNumberINDIA()
}

def static "randomData.TestDataGenerator.getRandom_Mailiantor_Email"() {
    (new randomData.TestDataGenerator()).getRandom_Mailiantor_Email()
}

def static "com.jira.utils.CustomGlobalVariable.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new com.jira.utils.CustomGlobalVariable()).addGlobalVariable(
        	name
         , 	value)
}

def static "hci_smoke_test.performance.get_average_scripting_time_loadingPage"(
    	int reload_times	
     , 	String pageName	) {
    (new hci_smoke_test.performance()).get_average_scripting_time_loadingPage(
        	reload_times
         , 	pageName)
}

def static "question.VerifyInItemGrid.verifyItemInTheGrid"(
    	TestObject topDropDown	
     , 	int dropDownItemCount	
     , 	TestObject gridItemTestObject	) {
    (new question.VerifyInItemGrid()).verifyItemInTheGrid(
        	topDropDown
         , 	dropDownItemCount
         , 	gridItemTestObject)
}

def static "question.VerifyInItemGrid.multipleTestObject"(
    	String str	
     , 	TestObject objectOne	
     , 	TestObject objectTwo	
     , 	TestObject ObjectThree	) {
    (new question.VerifyInItemGrid()).multipleTestObject(
        	str
         , 	objectOne
         , 	objectTwo
         , 	ObjectThree)
}

def static "hci_smoke_test.create_new_record.iss_hazard"() {
    (new hci_smoke_test.create_new_record()).iss_hazard()
}
