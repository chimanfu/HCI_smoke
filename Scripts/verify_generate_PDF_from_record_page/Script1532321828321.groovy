if (GlobalVariable.userPin2.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


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
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'),25)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))
	//WebUI.verifyTextPresent('Preparing doctree', false)
	// check file download
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(50)
	
	//WebUI.delay(5)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/select_Show All'), 10)
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '5', true)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'),25)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'),10)
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))
	//WebUI.verifyTextPresent('Preparing doctree', false)
	// check file download
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(50)
	return
}else if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.setText(findTestObject('Object Repository/Page_ARC JET/input_keywords'), 'IHF')
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Search'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_Showing results for ALL'))
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),15)
	println('click on the PDF icon elment of series of worksheets from the first record of all the records')
	//WebUI.click(findTestObject('Object Repository/Page_ARC JET/img_AHF 307'))
	List<WebElement> elements = driver.findElements(By.xpath("//img[@src = 'extensions/arcjet/web/css/img/pdf_multi.png' and @class = 'pdf']"));
	WebElement firstElement = elements.get(0);
	firstElement.click()
	//WebUI.waitForElementPresent(findTestObject('Page_ARC JET/span_Preparing PDF'),10)
	//WebUI.waitForElementNotPresent(findTestObject('Page_ARC JET/span_Preparing PDF'),60)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(50)
	
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
	
	//WebUI.waitForElementPresent(findTestObject('Page_ARC JET/span_Preparing PDF'),10)
	//WebUI.waitForElementNotPresent(findTestObject('Page_ARC JET/span_Preparing PDF'),20)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(220)
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'),100)
	return

}
WebUI.comment 'verify PDF report will be generated successfully and check pdf file downloaded'
String recordName_for_PDFReport='1,3,10,11,12,14,15,18,20,40,50,70,80,100,200,300,400'
//recordName_for_PDFReport='test_automation_record'
//recordName_for_PDFReport=GlobalVariable.recordName1
//recordName_for_PDFReport='1,2,3,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
//recordName_for_PDFReport='1,3,10,11,12,14,15,18,20,40,50,70,80,100,200,300,400'
/*if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run generate PDF report test')
	return
}*/
/*
WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_test_automation_record'),10)
WebUI.click(findTestObject('Page_Main Page/a_test_automation_record'))
*/
WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),25)
//WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
if (WebUI.waitForElementVisible(findTestObject('Page_Main Page/select_search_option'),2))
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
if (WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),15)){
	String siteURL=WebUI.getUrl()
	siteURL=siteURL.substring(0,siteURL.lastIndexOf('#tv='))
	GlobalVariable.recordName2=siteURL
	KeywordUtil.markPassed 'current record url='+GlobalVariable.recordName2
	WebUI.click(findTestObject('Page_Record test_automation_record/a_PDF'))
	if (WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/button_Generate PDF'),10)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Page_Record test_automation_record/button_Generate PDF'))
	}
	CustomKeywords.'hci_smoke_test.common.check_PDFFile_Downloaded'(15)
}else{
	WebUI.comment('not found PDF link, so the site may not support PDF generation')
}
/*WebUI.waitForElementPresent(findTestObject('Page_Record test_automation_record/a_Home'),10)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_Home'),10)*/
KeywordUtil.markPassed('PASS: Found PDF file, the test passed')

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}
