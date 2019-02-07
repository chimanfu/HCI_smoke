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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//println 'my pin='+GlobalVariable.G_userPin
//return

def currentDir = new File("/Users/jcfu/Katalon Studio/HCI_Group/Profiles");
def backupFile;
def fileText;

//Replace the contents of the list below with the
//extensions to search for
def exts = [".txt", ".glbl"]

//Replace the value of srcExp to a String or regular expression
//to search for.
def srcExp = "cp_hazard.sikuli"

//Replace the value of replaceText with the value new value to
//replace srcExp
//def replaceText = "FeyTxQmCiApXDlExS+ye4A=="
def replaceText = "my_image_path"
currentDir.eachFileRecurse(
  {file ->
	for (ext in exts){
	  if (file.name.endsWith(ext)) {
		fileText = file.text;
		backupFile = new File('/Users/jcfu/Desktop/Profiles_new/'+file.name);
		backupFile.write(fileText);
		fileText = fileText.replaceAll(srcExp, replaceText)
		file.write(fileText);
	  }
	}
  }
)
return

WebUI.setEncryptedText('FeyTxQmCiApXDlExS+ye4A==')

String fileName='Full Text Search - Word.docx'
String downloadPath=new File("/Users/jcfu/Downloads/").absolutePath

//isFileDownloaded(downloadPath,fileName)

public boolean isFileDownloaded(String downloadPath, String fileName) {
// check file downloaded successfully or not, and it'll delete the file found if exists
	File dir = new File(downloadPath);
	File[] dirContents = dir.listFiles();
	String lastAttempt = '';

	if (dirContents.length > 0) {
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				println 'file will be deleted: '+dirContents[i]
				dirContents[i].delete();
				KeywordUtil.markPassed('"'+fileName+'" exist in default download dir: ' + downloadPath + ', and was deleted')
				return true;
			}
			lastAttempt = dirContents[i].getName().equals(fileName);
		}
		if (lastAttempt != fileName) {
			KeywordUtil.markFailed('"'+fileName+'" does not exist in default download dir: ' + downloadPath)
			return false;
		}
	}
	return false;
}
//CustomKeywords.'helper.login.LoginHelper.login'()

//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_hotfix/show_bug.cgi?id=47313#tv=Basic%20Information')

def search_attachment(){

	// search attachment bassed on last GlobalVariable.attachment_name and search result should contain the current record id
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
	print '!!! record_id='+record_id
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
