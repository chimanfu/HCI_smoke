if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.Screen as Screen
import org.sikuli.script.Pattern as Pattern
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.kms.katalon.core.webui.driver.DriverFactory


/*
 * verify PDF is being generated correctly for a record
 * 
 * Steps:
 * 
 * search for existing records with recordName_for_PDFReport='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
 * select the first record found from the list
 * click 'Create PDF' link
 * click 'Generate PDF' button
 * verify PDF is generated 
 */

if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_inventory')){
	println('do not need to run generate PDF report test as no PDF feature in record')
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}

int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

if ((GlobalVariable.G_MAKE_MAS_url).contains('doctree')){
	
	Screen s = new Screen()
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'),25)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))
	//WebUI.verifyTextPresent('Preparing doctree', false)
	// check file download
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(25)
	
	//WebUI.delay(5)
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '5', true)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'),25)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))
	//WebUI.verifyTextPresent('Preparing doctree', false)
	// check file download
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(25)
	return
}else if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_keywords'), 'ALL')
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Search'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_Showing results for ALL'))
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),15)
	println('click on the PDF icon elment of series of worksheets from the first record of all the records')
	//WebUI.click(findTestObject('Object Repository/Page_ARC JET/img_AHF 307'))
	List<WebElement> elements = driver.findElements(By.xpath("//img[@src = 'extensions/arcjet/web/css/img/pdf_multi.png' and @class = 'pdf']"));
	WebElement firstElement = elements.get(0);
	firstElement.click()
	//WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ARC JET/span_Preparing PDF...'),10)
	//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_ARC JET/span_Preparing PDF...'),60)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(60)
	
	WebUI.delay(1)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	println('click on the PDF icon elment of worksheet from the first record of all the records')
	//WebUI.click(findTestObject('Object Repository/Page_ARC JET/img_TW-AHF-307-002'))
	WebUI.delay(2)
	elements = driver.findElements(By.xpath("//img[@src = 'extensions/arcjet/web/css/img/pdf.gif' and @class = 'pdf']"));
	firstElement = elements.get(0);
	try{
		firstElement.click()
		
	}catch (Exception e) {
		WebUI.delay(30)
		firstElement.click()
		e.printStackTrace()
	}
	
	//WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ARC JET/span_Preparing PDF...'),10)
	//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_ARC JET/span_Preparing PDF...'),20)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(200)
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	return

}
WebUI.comment 'verify PDF report will be generated successfully and check pdf file downloaded'
String recordName_for_PDFReport
//recordName_for_PDFReport='test_automation_record'

//recordName_for_PDFReport=GlobalVariable.recordName1
recordName_for_PDFReport='1,2,3,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'

/*if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run generate PDF report test')
	return
}*/
/*
WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_test_automation_record'),10)
WebUI.click(findTestObject('Page_Main Page/a_test_automation_record'))
*/
WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),25)
WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
WebUI.waitForPageLoad(5)
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordName_for_PDFReport)
WebUI.click(findTestObject('Page_Main Page/bt_Search'))

//WebUI.waitForElementVisible(findTestObject('Page_Record List/li_Content_test_automation_record'),15)
//WebUI.click(findTestObject('Object Repository/Page_Record List/li_Content_test_automation_record'))
WebUI.delay(1)
println('if more than 1 record found, then select the first record first')
if (WebUI.waitForElementVisible(findTestObject('Page_Record List/a_record_1'),10)){
	WebUI.click(findTestObject('Page_Record List/a_record_1'))
}
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),15)
WebUI.click(findTestObject('Page_Record test_automation_record/a_PDF'))

if (WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),10)){
	WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
}
WebUI.delay(5)
CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(50)
/*WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),10)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),10)*/


/////////////////////////////////////////////////////////////////////////////
break
} catch (Exception e) {
// handle exception
e.printStackTrace()
if (++retry_count == maxTries) throw e;
println('Retry:'+retry_count+' rerun failed case now...')
}
}
