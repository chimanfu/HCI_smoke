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
import groovy.io.FileType
import java.io.File
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_hotfix/show_bug.cgi?id=44031#tv=Basic%20Information')


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/button_Save Changes'),10)
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> elements = driver.findElements(By.xpath("//div[@class='personLink']/span[@class='PersonContainer']/span[@class='input-group']/input[@type = 'text' and @class = 'form-control ui-autocomplete-input']"));
int size=elements.size()
String search_name='joseph.fu@nasa.'
String found_name
WebUI.comment('number of person fields found on page = '+size)
for (int i = 0; i < size; i++) {
	if(	elements.get(i).isDisplayed()){
		//elements.get(i).click()
		elements.get(i).sendKeys(search_name+'\n')
		WebUI.delay(2)
		elements.get(i).sendKeys('\n')
		WebUI.delay(1)
		found_name=elements.get(i).getAttribute("value")
		if (found_name.contains(search_name)){
			KeywordUtil.markPassed 'name found in person field '+i+': '+found_name+', it matches with the search name: '+search_name
		}else{
			KeywordUtil.markFailed 'name found in person field '+i+': '+found_name+', it does not matche with the search name: '+search_name
		
		}
	}
}	
return

if (attachment_name.contains('584MB')){
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_attachments/h4_Maximum upload size exceeded'),5)
	String reached_maximum_warning_message=WebUI.getText(findTestObject('Object Repository/Page_attachments/div_reached_maximum_warning_message'))
	if (reached_maximum_warning_message.contains(attachment_name)){
		WebUI.comment('found fileName:'+attachment_name+' in reached_maximum_warning_message')
		WebUI.click(findTestObject('Object Repository/Page_attachments/button_OK'))
	}else{
	// failed
	}
}

def list = []

//def dir=new File("Data Files/IHS_IP_permissions/attachments/")
def dir=new File("/Users/jcfu/Desktop/attachments_all/")
//def dir = new File("path_to_parent_dir")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}
list.each {
	println it.toString()
  }
return



def add_attachments_all(){
	KeywordUtil.logInfo 'add/upload attachments'
	KeywordUtil.logInfo "will add all attachments into the record "
	String[] list
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
		println attachment_name
		KeywordUtil.logInfo 'add attachment from the Add New Attachment button, will randomly pick the attachment from "Data Files/IHS_IP_permissions/attachments/"'
		//WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_Enter Record View/input_Add New Attachment'),10)
		//WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), '/Users/jcfu/Katalon Studio/HCI_Group/Data Files/IHS_IP_permissions/expected_results_partner.xlsx')
		//(new ip_permissions.utils()).get_random_attachment()
		KeywordUtil.logInfo('will add attachment into record with '+attachment_name+'\n')
		String path=new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
		WebUI.uploadFile(findTestObject('Page_Enter Record View/input_Add New Attachment'), path+'/'+attachment_name)
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
	save_changes()
}

main_page_title = WebUI.getWindowTitle()
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('main_page_title',main_page_title)
site_name_title=main_page_title.substring(0,main_page_title.lastIndexOf(' Main Page'))
CustomKeywords.'ip_permissions.utils.addGlobalVariable'('site_name_title',site_name_title)
println "site_name_title='"+site_name_title+"'"
return

String cmd = "pkill -f Chrome"
Runtime.getRuntime().exec(cmd)
WebUI.closeBrowser()
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.closeBrowser()

return

//println 'my pin='+GlobalVariable.G_userPin
//return

def replaceTextFromAllProfiles(srcExp,replaceText){
	// replace text in srcExp to replaceText in Profiles
	def currentDir = new File("/Users/jcfu/Katalon Studio/HCI_Group/Profiles");
	def backupFile;
	def fileText;

	//Replace the contents of the list below with the
	//extensions to search for
	def exts = [".txt", ".glbl"]

	//Replace the value of srcExp to a String or regular expression
	//to search for.
	//def srcExp = "cp_hazard.sikuli"

	//Replace the value of replaceText with the value new value to
	//replace srcExp
	//def replaceText = "FeyTxQmCiApXDlExS+ye4A=="
	//def replaceText = "my_image_path"
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
}
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
