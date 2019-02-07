import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.util.KeywordUtil
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration
/*
 * Test IHS ATTACHMENT
 * refer to 
 * https://hci-confluence.arc.nasa.gov/display/MD/IHS+ATTACHMENT
 * https://hci-confluence-old.arc.nasa.gov/display/CxPRA/IHS+ATTACHMENT
 * DESCRIPTION: IHS allows users to upload multiple attachments to a record and gives them ability 
 * to upload, filter and Edit fields within Record Type. 

GOAL: Validate following functionality works for IHS Attachments Feature
-Attachment Display
-Filtering
-Sorting
-Uploading Attachments
-Editing Fields in Attachments Table
-Obsolete
-Related Data Fields
-Error Messages

testcases:
create_new_record
add_attachments
verify_sorting_options
verify_filtering_search
verify_downloading_attachments
verify_search_attachment
verify_edit_attachments
obsolete_attachments
error_handling
add_delete_related_attachments_On_RecordTypeField
reuse_delete_related_attachments_On_RecordTypeField

testcases:
Create_new_record
Create a simple record for Boeing/APAS/Hazard
Verify record created

Add_attachments
run a loop to add/upload certain number (e.g. 15) of random attachments from the list into the record with different file types (e.g.: Doc, PDF, and XLS)'

Verify_sorting_options
test different options of sorting on ascending/descending orders from the attachment table
sort on column: file name, Description, upload date, attachment type, Review Phase, Proprietary Limited Right, IP Access Allowed, Export Control Rating

Verify_filtering_search
test filtering with valid search terms on filename, description, attachment type, export control rating
test filtering with invalid search terms on filename, description, attachment type, export control rating
test filtering with empty search term, should display the full list

Verify_downloading_attachments
test downloading 4 attachments 
need visual check now, will need to implement a function to check the downloaded file name from the download folder

verify_search_attachment
Validate that Attachment can be indexed and searched.
search attachment based on last attachment stored on GlobalVariable.attachment_name and search result should contain the current record id

Verify_edit_attachments
edit Fields in Attachment Table
edit first 2 attachments with new filename, new description and select new attachment type
verify new filenames and new descriptions and new attachment types display correctly

Obsolete_attachments
obsolete first 2 attachments from The Attachments Table 
check "Show Obsolete Attachments" link, then check the list of Obsolete Attachments from the Obsolete attachments table
check "Hide Obsolete Attachments" link, then check The Obsolete attachments table is no longer displayed.

error_handling
error handling: Ensure correct error message is displayed when user tries to save record without filling out require information

add_delete_related_attachments_On_RecordTypeField
add, download and remove field link of related attachment from "Add Attachment to Field" on Record Type Field (Related Data Fields)

reuse_delete_related_attachments_On_RecordTypeField
reuse, download and remove field link of attachment from "Reuse Attachment" on the Record Type Field (Related Data Fields)


 */
//////////////////////////////////
CustomKeywords.'helper.login.LoginHelper.login'()
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev/show_bug.cgi?id=47316#tv=Basic%20Information')
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_hotfix/show_bug.cgi?id=47313#tv=Basic%20Information')

//return
//////////////////////////////////
product='Boeing'
component='APAS'
record_type='Hazard'
record_title='test_attachments'

CustomKeywords.'ip_permissions.utils.create_new_record'(product, record_title, component, record_type)
CustomKeywords.'attachments.utils.add_attachments'(15)
CustomKeywords.'attachments.utils.verify_sorting_options'()
CustomKeywords.'attachments.utils.verify_filtering_search'()
CustomKeywords.'attachments.utils.verify_downloading_attachments'()
CustomKeywords.'attachments.utils.verify_search_attachment'()

CustomKeywords.'attachments.utils.verify_edit_attachments'()
CustomKeywords.'attachments.utils.obsolete_attachments'()
CustomKeywords.'attachments.utils.error_handling'()

CustomKeywords.'attachments.utils.add_delete_related_attachments_On_RecordTypeField'()
CustomKeywords.'attachments.utils.reuse_delete_related_attachments_On_RecordTypeField'()