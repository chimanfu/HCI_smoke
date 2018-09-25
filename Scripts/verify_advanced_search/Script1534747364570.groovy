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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.KeyModifier
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import com.thoughtworks.selenium.Selenium

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

// verify to be able to use advanced search to get a list of records that have snapshots taken already
//
// do a advanced search on 
//		select Search by change
//		select option 'xml snapshot' if exists, otherwise exit the test
//			add before date: '2018-08-20'
//			click search button
// verify the searchTitle_XML Snapshot in the search return list

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	println 'do not need to run this test'
	return
}
WebUI.comment 'randomly to run this test or not (0 or 1), should already covered similiar case in advancedSearch related testcase verify_generate_diff_report_on_advancedSearch'
if ((int) (Math.random()+0.5)){
	WebUI.comment('perform test this time')
}
else{
	WebUI.comment 'will skip running it this time to save time'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'),10)
WebUI.click(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'))

WebUI.waitForElementClickable(findTestObject('Page_Search for records/div_Search by change'),6)
WebUI.click(findTestObject('Page_Search for records/div_Search by change'))

if (WebUI.waitForElementVisible(findTestObject('Page_Search for records/input_select_option_xmlversion'),5)){
	WebUI.comment("found option 'xml snapshot' from the Search by change field")
	
	WebUI.click(findTestObject('Page_Search for records/input_select_option_xmlversion'))

	WebUI.setText(findTestObject('Page_Search for records/input_chfieldto_display'), '2018-08-20')

	WebUI.click(findTestObject('Page_Search for records/input_Search'))

	// verify the searchTitle_XML Snapshot in the search return list
	WebUI.waitForElementVisible(findTestObject('Page_Record List/strong_searchTitle_XML Snapshot'),6)

} else{
	WebUI.comment("not found option 'xml snapshot' from the Search by change field")
}