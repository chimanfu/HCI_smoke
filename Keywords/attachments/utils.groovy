package attachments

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import groovy.io.FileType
import java.io.File
public class utils {
	@Keyword
	def add_attachments_all(){
		KeywordUtil.logInfo 'add/upload attachments'
		KeywordUtil.logInfo "will add all attachments into the record "
		def list = []
		def dir=new File("/Users/jcfu/Desktop/attachments_all/")
		dir.eachFileRecurse (FileType.FILES) { file ->
		  list << file
		}
		//WebUI.refresh(FailureHandling.OPTIONAL)
		//WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),30)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),5)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'))
	
		'enter values for 3 required fields before adding attachments'
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'), 'ITAR', true)
	
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/span_International Partner Designation'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))
		WebUI.check(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))
	
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'), 'TBD', true)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)
		String number=0
		// loop to add num_attachments of attachment from get_random_attachment()
		String attachment_name
		list.each {
			attachment_name=it.toString()
			println 'attachment_name='+attachment_name
			KeywordUtil.logInfo 'add attachment from the Add New Attachment button, will randomly pick the attachment from "Data Files/IHS_IP_permissions/attachments/"'
			//WebUI.delay(1)
			WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add New Attachment'),10)
			//WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), '/Users/jcfu/Katalon Studio/HCI_Group/Data Files/IHS_IP_permissions/expected_results_partner.xlsx')
			//(new ip_permissions.utils()).get_random_attachment()
			KeywordUtil.logInfo('will add attachment into record with '+attachment_name+'\n')
			//String path=new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
			WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), attachment_name)
			// check file size limit
			if (attachment_name.contains('584MB')){
				KeywordUtil.logInfo("check file size limit")
				WebUI.waitForElementVisible(findTestObject('Object Repository/Page_attachments/h4_Maximum upload size exceeded'),5)
				String reached_maximum_warning_message=WebUI.getText(findTestObject('Object Repository/Page_attachments/div_reached_maximum_warning_message'))
				if (reached_maximum_warning_message.contains('Archive_584MB.zip')){
					WebUI.click(findTestObject('Object Repository/Page_attachments/button_OK'))
					KeywordUtil.markPassed('found fileName:'+attachment_name+' in reached_maximum_warning_message')
				}else{
					// failed
					KeywordUtil.markFailed('Not found fileName:'+attachment_name+' in reached_maximum_warning_message')
				}
			}else{
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments'),10)
			//WebUI.delay(1)
			//WebUI.click(findTestObject('Object Repository/Page_Enter Record View/label_Add New Attachment'))
			KeywordUtil.logInfo 'need to fill out all the required fields for adding attachment'
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
			// take care the Description for the attachment
			WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Description_field'), 'test_attachment '+attachment_name)
			}
		}
		//save_changes_and_time()
	}
	
	@Keyword
	public boolean isFileDownloaded(String downloadPath, String fileName,def delayTime=5) {
		// check file downloaded successfully in downloadPath, and it'll delete the file 'fileName' if exists in downloadPath, default to wait for 5 seconds
		WebUI.delay(delayTime)
		int retry_count = 0;
		int maxTries = 10;
		boolean rerun=true
		while(rerun) {

			File dir = new File(downloadPath);
			File[] dirContents = dir.listFiles();
			String lastAttempt = '';

			if (dirContents.length > 0) {
				for (int i = 0; i < dirContents.length; i++) {
					if (dirContents[i].getName().equals(fileName)) {
						// File has been found, it can now be deleted:
						println 'file found and will be deleted: '+dirContents[i]
						//WebUI.delay(1)
						if (dirContents[i].delete()){
							KeywordUtil.markPassed('"'+fileName+'" exist in default download dir: ' + downloadPath + ', and was deleted')
							rerun=false
							return true;
						}else{
							KeywordUtil.markFailed('"'+fileName+'" exist in default download dir: ' + downloadPath+ ', but cannot be deleted')
							rerun=false
							return false;
						}
					}
					lastAttempt = dirContents[i].getName().equals(fileName);
				}
				if (lastAttempt != fileName) {
					KeywordUtil.markWarning('"'+fileName+'" does not exist in default download dir: ' + downloadPath)
					//throw new AssertionError('"'+fileName+'" does not exist in default download dir: ' + downloadPath)

					//return false;
				}
			}
			//return false;
			//break
			WebUI.delay(1)
			if (++retry_count == maxTries) {
				rerun=false
				throw new AssertionError('"'+fileName+'" does not exist in default download dir: ' + downloadPath)
			}
			WebUI.comment('Retry:'+retry_count+' rerun isFileDownloaded now...')

		}
	}

	@Keyword
	def verify_search_attachment(){
		// Validate that Attachment can be indexed and searched.
		// will get a search term randomly by get_random_search_term
		// will get the record id by the current record showing
		// search attachment based on last attachment stored on GlobalVariable.attachment_name and search result should contain the current record id if found
		// will open the record and download the attachment if it matches in the search term
		boolean search_found_expected=true
		boolean OCR_attachment_delay=false
		//(new ip_permissions.utils()).addGlobalVariable('attachment_name','Full Text Search - Word.docx')
		// using GlobalVariable.attachment_name to determine search_found_expected status
		if (GlobalVariable.attachment_name.contains('Blank')) search_found_expected=false
		if (GlobalVariable.attachment_name.contains('OCR')) OCR_attachment_delay=true
		//if (GlobalVariable.attachment_name.contains('image')) search_found_expected=false
		String info='\nAlready added attachment into record with "'+GlobalVariable.attachment_name+'"\n'

		String search_term=(new ip_permissions.utils()).get_random_search_term()
		String record_id=(new ip_permissions.utils()).get_record_id()
		//print '!!! record_id='+record_id
		WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
		WebUI.waitForElementClickable(findTestObject('Page_Main Page/input_quicksearch'),15)
		if (OCR_attachment_delay) {
			WebUI.delay(8)
			info=info+'\nAdded delay for search, OCR attachments may need more time to create search index\n'
		}
		if (WebUI.waitForElementVisible(findTestObject('Page_Main Page/select_search_option'),2))
			WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
		WebUI.waitForPageLoad(60)
		WebUI.waitForElementClickable(findTestObject('Page_Main Page/bt_Search'),5)
		// OCR attachments may need more time to create search index

		WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
		WebUI.click(findTestObject('Page_Main Page/bt_Search'))

		try{
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),20)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'),20)
			if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/li_Search_Content'),20)){
				KeywordUtil.logInfo("found li_Search_Content")
			}
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Displaying_result'),60)

			//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Record List/li_Search_Content'), 'text', search_term, 10)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/a_ID_column'),10)
			if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_descending order'),1)){
				println 'already in descending order'
			}else if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_ascending order'),1)){
				WebUI.click(findTestObject('Object Repository/Page_Record List/a_ID_ascending order'))
				WebUI.delay(2)
				WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_descending order'),10)
			}
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Displaying_result'),60)
			//WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_ascending a_record_id_link'),15)
			//WebUI.waitForElementVisible(findTestObject('Page_Record List/a_ID_ascending a_record_id_link'),15)
			//WebUI.waitForElementClickable(findTestObject('Page_Record List/a_ID_ascending a_record_id_link'),15)
			def record_link = WebUI.modifyObjectProperty(findTestObject('Page_Record List/a_record_id_link'), 'text', 'equals', record_id, true)
			KeywordUtil.logInfo ('start looking for record_link')
			if (search_found_expected){
				if (WebUI.waitForElementPresent(record_link, 10,FailureHandling.OPTIONAL)){
					WebUI.click(record_link)
					/// start looking for attachment link
					WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/div_Attachments_Label'),10,FailureHandling.OPTIONAL)
					WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments_Label'),10,FailureHandling.OPTIONAL)
					def attachment_link = WebUI.modifyObjectProperty(findTestObject('Object Repository/Page_Record_Created/a_attachment_link'), 'text', 'equals', GlobalVariable.attachment_name, true)
					if (WebUI.waitForElementPresent(attachment_link, 10,FailureHandling.OPTIONAL)){
						//println 'PASS: found attachment_link'
						WebUI.click(attachment_link)
						KeywordUtil.markPassed (info+'\nPASS: search_attachment found attachment link "'+GlobalVariable.attachment_name+'" in record:'+record_id+' with the search term as => '+search_term)
					}else{
						//println 'ERROR: Not found attachment_link'
						KeywordUtil.markFailed (info+'\nERROR: search_attachment NOT found attachment link "'+GlobalVariable.attachment_name+'" in record:'+record_id+' with the search term as => '+search_term+'\n')
						//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_'+user_name+'_'+product+'_search_attachment')
					}
					/// end looking for attachment link
				}else{
					KeywordUtil.markFailed (info+'\nERROR: search_attachment NOT found record:'+record_id+' with the search term as => '+search_term+'\n')
					//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_'+user_name+'_'+product+'_search_attachment')
				}
			}else{
				if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_record_id_link'),5,FailureHandling.OPTIONAL)){
					if (!WebUI.waitForElementNotPresent(record_link, 5,FailureHandling.OPTIONAL)){
						KeywordUtil.markFailed (info+'\nERROR: search_attachment found record:'+record_id+' with the search term as => '+search_term+'\n')
						//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_'+user_name+'_'+product+'_search_attachment')
					}else{
						KeywordUtil.markPassed (info+'\nPASS: search_attachment NOT found record:'+record_id+' with the search term as => '+search_term)
					}
				}else{
					KeywordUtil.markPassed (info+'\nPASS: search_attachment NOT found record:'+record_id+' with the search term as => '+search_term)
				}

			}
			KeywordUtil.logInfo ('done looking for record_link')
		} catch (Exception e) {
			KeywordUtil.markFailed (info+'\nERROR: search_attachment Failed to find record:'+record_id+' with the search term as => '+search_term+'\n'+e.printStackTrace())
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.testcaseName+'_'+user_name+'_'+product+'_search_attachment')
		}
	}


	@Keyword
	def get_record_id(){
		// will get the record id by the current record showing
		String siteURL=WebUI.getUrl()
		siteURL=siteURL.substring(0,siteURL.lastIndexOf('#tv='))
		(new ip_permissions.utils()).addGlobalVariable('recordURL',siteURL)
		String record_id=GlobalVariable.recordURL.substring(GlobalVariable.recordURL.lastIndexOf('id=')+3)
		(new ip_permissions.utils()).addGlobalVariable('record_id',record_id)
		KeywordUtil.logInfo( 'current record url='+GlobalVariable.recordURL)
		KeywordUtil.logInfo( 'current record id='+GlobalVariable.record_id)
	}
	@Keyword
	def reuse_delete_related_attachments_On_RecordTypeField(){
		KeywordUtil.logInfo 'reuse, download and remove field link of attachment from "Reuse Attachment" on the Record Type Field (Related Data Fields)'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_Reuse Attachment'),4)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_Reuse Attachment'))
		// select first attachment from the list
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_Related_Attachments_reuse_checkbox1'),4)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_Related_Attachments_reuse_checkbox1'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
		// check attachment file link exists
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'),5)
		// download attachment
		WebUI.click(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'))
		// remove field link of attachment
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/img_unlink_attachment'),5)
		WebUI.click(findTestObject('Object Repository/Page_attachments/img_unlink_attachment'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
		// verify related_attachment_link not exist
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'),1)
	}
	@Keyword
	def add_delete_related_attachments_On_RecordTypeField(){
		WebUI.refresh() // may need refresh
		KeywordUtil.logInfo 'add, download and remove field link of related attachment from "Add Attachment to Field" on Record Type Field (Related Data Fields)'
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add Attachment to Field'),10)
		(new ip_permissions.utils()).get_random_attachment()
		String path=new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
		WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add Attachment to Field'), path+'/'+GlobalVariable.attachment_name)
		WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/select_attachment_type'),10)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/select_attachment_type'),10)
		WebUI.delay(1)
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
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Description_field'), 'test_attachment_On_Related Data Field')
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
		// check attachment file link exists
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'),5)
		// download attachment
		WebUI.click(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'))
		// remove field link of attachment
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/img_unlink_attachment'),5)
		WebUI.click(findTestObject('Object Repository/Page_attachments/img_unlink_attachment'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
		// verify related_attachment_link not exist
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_attachments/a_related_attachment_link'),1)
	}

	@Keyword
	def error_handling(){
		KeywordUtil.logInfo 'error handling: Ensure correct error message is displayed when user tries to save record without filling out require information'
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add New Attachment'),10)
		(new ip_permissions.utils()).get_random_attachment()
		String path=new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
		WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), path+'/'+GlobalVariable.attachment_name)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments'),10)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		KeywordUtil.logInfo 'check A pop up error message is displayed, informing user of the required fields one each attachment that must be filled out to save the record. '
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_attachments/h4_Save Failed'),5)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_attachments/ul_Attachment fields Error_Msgs'),5)
		String errors=WebUI.getText(findTestObject('Object Repository/Page_attachments/ul_Attachment fields Error_Msgs'))
		KeywordUtil.logInfo 'verify keywords from the error messages from the popup: '+errors
		WebUI.verifyTextPresent('Attachment Type (for attachment ', false)
		WebUI.verifyTextPresent('Review Phase (for attachment ', false)
		WebUI.verifyTextPresent('Proprietary / Limited Rights (for attachment ', false)
		WebUI.verifyTextPresent('IP Access Allowed? (for attachment ', false)
		WebUI.verifyTextPresent('Export Control Rating - Attachments (for attachment ', false)

		//close the error popup
		
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/button_Close'),1)){
			WebUI.click(findTestObject('Object Repository/Page_attachments/button_Close'))
			
		}else if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/button_Okay'),1)){
			WebUI.click(findTestObject('Object Repository/Page_attachments/button_Okay'))
			
		}
		
		// close the New Attachment table
		WebUI.click(findTestObject('Object Repository/Page_attachments/div_New Attachment_delete'))
		save_changes()

	}
	@Keyword
	def obsolete_attachments(){
		// verify obsolete attachments
		// obsolete first 2 attachments from The Attachments Table
		// check "Show Obsolete Attachments" link, then check the list of Obsolete Attachments from the Obsolete attachments table
		// check "Hide Obsolete Attachments" link, then check The Obsolete attachments table is no longer displayed.
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/div_Linked records'),10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_isobsole_checkbox1'),5)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_isobsole_checkbox1'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_isobsole_checkbox2'),5)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_isobsole_checkbox2'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),15)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
		// verify new filename and description not present after save
		WebUI.verifyTextNotPresent('newFileName1',false)
		WebUI.verifyTextNotPresent('newFileName2',false)
		WebUI.verifyTextNotPresent('newDescription1',false)
		WebUI.verifyTextNotPresent('newDescription2',false)

		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)

		// check obsolete attachments
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/div_Show Obsolete Attachments_link'),4)
		WebUI.click(findTestObject('Object Repository/Page_attachments/div_Show Obsolete Attachments_link'))
		// verify new filename and description present
		WebUI.delay(2)
		WebUI.verifyTextPresent('newFileName1',false)
		WebUI.verifyTextPresent('newFileName2',false)
		WebUI.verifyTextPresent('newDescription1',false)
		WebUI.verifyTextPresent('newDescription2',false)
		//WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/div_Hide Obsolete Attachments_link'),4)
		WebUI.click(findTestObject('Object Repository/Page_attachments/div_Hide Obsolete Attachments_link'))
		WebUI.delay(2)
		// verify new filename and description not present
		WebUI.verifyTextNotPresent('newFileName1',false)
		WebUI.verifyTextNotPresent('newFileName2',false)
		WebUI.verifyTextNotPresent('newDescription1',false)
		WebUI.verifyTextNotPresent('newDescription2',false)
	}

	@Keyword
	def add_attachments(num_attachments){
		KeywordUtil.logInfo 'add/upload attachments'
		KeywordUtil.logInfo 'add run a loop to add/upload certain number (e.g. 15) of random attachments from the list into the record with different file types (e.g.: Doc, PDF, and XLS)'
		KeywordUtil.logInfo "will add ${num_attachments} attachments into the record "

		//WebUI.refresh(FailureHandling.OPTIONAL)
		//WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Main Page/a_Home'),30)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Main Page/a_Home'),5)
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Main Page/a_Home'),1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_8265_react_iss_hazard/div_Basic Information'))

		'enter values for 3 required fields before adding attachments'
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_export_control_rating'), 'ITAR', true)

		WebUI.click(findTestObject('Object Repository/Page_Record_Created/span_International Partner Designation'))
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))
		WebUI.check(findTestObject('Object Repository/Page_Record_Created/input_Not Applicable'))

		WebUI.click(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Record_Created/select_cf_proprietary_limited_rights'), 'TBD', true)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/label_Add New Attachment'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/label_Add New Attachment'),10)
		String number=0
		// loop to add num_attachments of attachment from get_random_attachment()
		1.upto(num_attachments) {
			KeywordUtil.logInfo 'add attachment from the Add New Attachment button, will randomly pick the attachment from "Data Files/IHS_IP_permissions/attachments/"'
			//WebUI.delay(1)
			WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add New Attachment'),10)
			//WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), '/Users/jcfu/Katalon Studio/HCI_Group/Data Files/IHS_IP_permissions/expected_results_partner.xlsx')
			(new ip_permissions.utils()).get_random_attachment()
			KeywordUtil.logInfo('will add attachment into record with '+GlobalVariable.attachment_name+'\n')
			String path=new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
			WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), path+'/'+GlobalVariable.attachment_name)
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments'),10)
			//WebUI.delay(1)
			//WebUI.click(findTestObject('Object Repository/Page_Enter Record View/label_Add New Attachment'))
			KeywordUtil.logInfo 'need to fill out all the required fields for adding attachment'
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
			// take care the Description for the attachment
			if (it<10) number='0'+it
			else number=it
			WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Description_field'), 'test_attachment_'+number)

		}
		save_changes()
	}
	@Keyword
	def save_changes_and_time(){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		//WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_time()
	}
	@Keyword
	def save_changes(){
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),6)
		WebUI.click(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'))
		WebUI.delay(6)
		(new ip_permissions.utils()).check_record_save_alert()
	}
	@Keyword
	def verify_edit_attachments(){
		// verify_edit_attachments (Editing Fields in Attachment Table)
		// edit first 2 attachments with new filename, new description and select new attachment type
		// verify new filenames and new descriptions and new attachment types display correctly
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/div_Linked records'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/div_Linked records'),10)
		//////////////////////////
		// edit first attachment
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/img_edit_icon1'),10)
		WebUI.click(findTestObject('Object Repository/Page_attachments/img_edit_icon1'))
		// change to new filename, new description
		String newDescription='newDescription1'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_description_field1'),10)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_description_field1'))
		WebUI.setText(findTestObject('Object Repository/Page_attachments/input_description_field1'),newDescription)
		String newFileName='newFileName1'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_fileName_field1'),5)
		WebUI.setText(findTestObject('Object Repository/Page_attachments/input_fileName_field1'),newFileName)
		// change attachment type
		String newAttachmentType='Drawings'
		WebUI.click(findTestObject('Object Repository/Page_attachments/select_attachment_type1'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_attachments/select_attachment_type1'),newAttachmentType, true)
		//////////////////////////
		// edit second attachment
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/img_edit_icon2'),10)
		WebUI.click(findTestObject('Object Repository/Page_attachments/img_edit_icon2'))
		// change to new filename, new description
		newDescription='newDescription2'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_description_field2'),10)
		WebUI.click(findTestObject('Object Repository/Page_attachments/input_description_field2'))
		WebUI.setText(findTestObject('Object Repository/Page_attachments/input_description_field2'),newDescription)
		newFileName='newFileName2'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_attachments/input_fileName_field2'),5)
		WebUI.setText(findTestObject('Object Repository/Page_attachments/input_fileName_field2'),newFileName)
		// change attachment type
		newAttachmentType='Analysis'
		WebUI.click(findTestObject('Object Repository/Page_attachments/select_attachment_type2'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_attachments/select_attachment_type2'),newAttachmentType, true)
		//////////////////////////
		// save change
		save_changes()

		// verify new filenames and new descriptions and new attachment types display correctly
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link1')
				, 'newFileName1')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link2')
				, 'newFileName2')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_attachments/div_newDescription1')
				, 'newDescription1')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_attachments/div_newDescription2')
				, 'newDescription2')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_attachments/div_newDescription1')
				, 'newDescription1')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_attachments/div_Analysis')
				, 'Analysis')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_attachments/div_Drawings')
				, 'Drawings')
	}
	@Keyword
	def verify_downloading_attachments(){
		// verify_downloading_attachments
		// test downloading 4 attachments (will check the downloaded file name from the download folder and then delete it if exists)
		WebUI.refresh()
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link2'),15)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link2'))
		String home = System.getProperty("user.home");
		String downloadPath = new File(home+"/Downloads/")
		//String downloadPath=new File("/Users/jcfu/Downloads/").absolutePath
		String fileName=WebUI.getText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link2'))
		isFileDownloaded(downloadPath,fileName)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link7'),3)
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link7'))
		fileName=WebUI.getText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link7'))
		isFileDownloaded(downloadPath,fileName)

		if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link9'),3,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link9'))
			fileName=WebUI.getText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link9'))
			isFileDownloaded(downloadPath,fileName)
		}
		if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link15'),3,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link15'))
			fileName=WebUI.getText(findTestObject('Object Repository/Page_Enter Record View/a_fileName_link15'))
			isFileDownloaded(downloadPath,fileName)
		}
	}
	@Keyword
	def verify_filtering_search(){
		// verify_filtering_search on different fields
		// test filtering with valid search terms on filename, description, attachment type, export control rating
		// test filtering with invalid search terms on filename, description, attachment type, export control rating
		// test filtering with empty search term, should display the full list
		String filtering='text search - word'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/a_Text Search - Word'),5)
		WebUI.delay(1)
		filtering='test_attachment_2'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/div_test_attachment_2'),5)
		WebUI.delay(1)
		filtering='Comments Sheet'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/div_Comments Sheet'),5)
		WebUI.delay(1)
		filtering='ITAR'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Enter Record View/div_ITAR'),5)
		// test filering - search term not found (add space in front or behind)
		filtering='text search - word '
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Enter Record View/a_Text Search - Word'),1)
		WebUI.delay(1)
		filtering='test_attachment_2 '
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Enter Record View/div_test_attachment_2'),1)
		WebUI.delay(1)
		filtering=' Comments Sheet'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Enter Record View/div_Comments Sheet'),1)
		WebUI.delay(1)
		filtering=' ITAR'
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Enter Record View/div_ITAR'),1)
		//resume to normal list by empty search term
		filtering=''
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),10)
		WebUI.setText(findTestObject('Object Repository/Page_Enter Record View/input_Filter Attachments_field'),filtering)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Page_Enter Record View/div_ITAR'),1)
		WebUI.refresh()
	}

	@Keyword
	def verify_sorting_options(){
		// verify sorting on attachment table
		// test different options of sorting on ascending/descending orders from the attachment table
		// sort on column: file name, Description, upload date, attachment type, Review Phase, Proprietary Limited Right, IP Access Allowed, Export Control Rating
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/div_Linked records'),20)
		WebUI.scrollToElement(findTestObject('Page_Enter Record View/div_Linked records'),10)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/span_Filename'),5)
		// check Filename column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Filename'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Filename_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Filename'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Filename_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Filename'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Filename_sort-asc'), 4)
		}
		// check Description column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Description'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Description_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Description'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Description_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Description'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Description_sort-asc'), 4)
		}
		// check Upload Date column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Upload Date'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Upload Date_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Upload Date'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Upload Date_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/div_Upload Date'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Upload Date_sort-asc'), 4)
		}
		// check Attachment Type column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Attachment Type'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Attachment Type_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Attachment Type'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Attachment Type_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Attachment Type'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Attachment Type_sort-asc'), 4)
		}
		// check Review Phase column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Review Phase'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Review Phase_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Review Phase'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Review Phase_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Review Phase'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Review Phase_sort-asc'), 4)
		}
		// check Proprietary Limited Rights column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Proprietary Limited Rights'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Proprietary Limited Right_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Proprietary Limited Rights'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Proprietary Limited Right_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Proprietary Limited Rights'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Proprietary Limited Right_sort-asc'), 4)
		}
		// check IP Access Allowed column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_IP Access Allowed'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_IP Access Allowed_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_IP Access Allowed'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_IP Access Allowed_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_IP Access Allowed'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_IP Access Allowed_sort-asc'), 4)
		}
		// check Export Control Rating column of sort-asc or sort-desc
		WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Export Control Rating'))
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_attachments/div_Export Control Rating Attachments_sort-asc'),2,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Export Control Rating'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Export Control Rating Attachments_sort-desc'), 4)
		}else{
			WebUI.click(findTestObject('Object Repository/Page_Enter Record View/span_Export Control Rating'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_attachments/div_Export Control Rating Attachments_sort-asc'), 4)
		}
	}
}
