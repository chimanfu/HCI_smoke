import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

boolean found_input_fields=false
boolean found_select_menu=false

CustomKeywords.'helper.login.LoginHelper.login'()
CustomKeywords.'kramp.Internal_Linking.select_TAB_Basic_Information'()

// On Core Fields
WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// check current status is set to READ-ONLY
WebUI.click(findTestObject('Page_record_G2G_linking/label_Status'))
WebUI.verifyOptionSelectedByValue(findTestObject('Page_record_G2G_linking/select_Status'), 'READ-ONLY', false, 10)

WebDriver driver = DriverFactory.getWebDriver()

// check the Basic Information TAB

input_tag_xpath="//input[@type='text' or @type='checkbox']"
List<WebElement> elements = driver.findElements(By.xpath(input_tag_xpath));
int list_size=elements.size()
if (list_size>0) {
	//KeywordUtil.markWarning("Found input fields ")
	for (int i = 0; i < list_size; i++) {
		input_field_name=elements.get(i).getAttribute("name")
		if (!(input_field_name.contains('quicksearch') || input_field_name.contains('cc') || input_field_name.contains('assigned_to'))){
			KeywordUtil.markWarning("Found input field name: "+input_field_name);
			found_input_fields=true
		}
	}
	//KeywordUtil.markFailedAndStop("Found input fields in page but it shouldn't")
}else{
	KeywordUtil.logInfo("Not found input fields ")
}

select_tag_xpath="//select[ @type = 'select' ]"
elements = driver.findElements(By.xpath(select_tag_xpath));
list_size=elements.size()
if (list_size>0) {
	//KeywordUtil.markWarning("Found select_menu ")
	for (int i = 0; i < list_size; i++) {
		select_menu_name=elements.get(i).getAttribute("name")
		if (!(select_menu_name.contains('bug_status'))){
			KeywordUtil.markWarning("Found select_menu name: "+select_menu_name);
			found_select_menu=true
		}
	}
	//KeywordUtil.markFailedAndStop("Found select_menu in page but it shouldn't")
}else{
	KeywordUtil.logInfo("Not found select_menu ")
}

if (found_input_fields&&found_select_menu){
	KeywordUtil.markFailedAndStop("Found input fields and select_menu in page but it shouldn't")
}else if (found_input_fields){
	KeywordUtil.markFailedAndStop("Found input fields in page but it shouldn't")
}else if (found_select_menu){
	KeywordUtil.markFailedAndStop("Found select_menu in page but it shouldn't")
}else{
	KeywordUtil.markPassed("Not Found input fields or select_menu in page so it is in read-only mode")
}