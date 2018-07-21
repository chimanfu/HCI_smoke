package helper.javascript

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

//import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.logging.LogEntries as LogEntries
import org.openqa.selenium.logging.LogEntry as LogEntry
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

//WebUI.openBrowser('http://only-testing-blog.blogspot.com/2015/01/table-with-checkbox.html')

//appendBrowserLogs()
/*
 void appendBrowserLogs() {
 WebDriver driver = DriverFactory.getWebDriver()
 LogEntries logs = driver.manage().logs().get('browser')
 for (LogEntry logEntry : logs) {
 if (logEntry.getMessage().toLowerCase().contains('error')) {
 System.err.println('Error Message in Console:' + logEntry.getMessage())
 } else if (logEntry.getMessage().toLowerCase().contains('warning')) {
 System.out.println('Warning Message in Console:' + logEntry.getMessage())
 } else {
 System.out.println('Information Message in Console:' + logEntry.getMessage())
 }
 }
 }  
 */
public class JavaScriptHelper {


	// To get implementation for webdriver api from KS
	WebDriver driver = DriverFactory.getWebDriver()

	//To get the instance of Java Script executor interface
	JavascriptExecutor executor = ((JavascriptExecutor)driver)

	@Keyword
	public void appendBrowserLogs() {
		WebDriver driver = DriverFactory.getWebDriver()

		LogEntries logs = driver.manage().logs().get('browser')
		System.out.println('*** js script message ***')

		for (LogEntry logEntry : logs) {
			if (logEntry.getMessage().toLowerCase().contains('error')) {
				System.err.println('Error Message in Console:' + logEntry.getMessage())
			} else if (logEntry.getMessage().toLowerCase().contains('warning')) {
				System.out.println('Warning Message in Console:' + logEntry.getMessage())
			} else {
				System.out.println('Information Message in Console:' + logEntry.getMessage())
			}
		}
		System.out.println('*** js script message ***')
	}

	@Keyword
	public void executeScript(String script){
		KeywordUtil.logInfo("[Java Script ] : " + script)
		executor.executeScript(script)
	}

	@Keyword
	public void executeScriptOnTestObject(String string,TestObject testObject){
		// Converting test object to webelement
		KeywordUtil.logInfo("[Java Script ] : " + string)
		try{
			WebElement element = WebUiCommonHelper.findWebElement(testObject, GlobalVariable.TimeOut)
			executor.executeScript(string, element)
		}catch(Exception ex){
			KeywordUtil.markErrorAndStop("[Custom Keyword Error] : " + ex.toString())
		}


	}

	@Keyword
	public Object executeAndReturnValue(String script,TestObject testObject){
		WebElement element = WebUiCommonHelper.findWebElement(testObject, GlobalVariable.TimeOut)
		// Will execute the js and retrun the value also
		return executor.executeScript(script, element)
	}

}
