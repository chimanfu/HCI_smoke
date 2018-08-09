package hci_smoke_test
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

class common {
	/*
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
	 */
	//package com.linked;

	@Keyword
	def checkLinksBrokenOnCurrentPage() {

		KeywordLogger log = new KeywordLogger()
		//private WebDriver driver;
		int invalidLinksCount;

		//WebUI.openBrowser('http://google.com')
		//driver = new FirefoxDriver();
		WebDriver driver = DriverFactory.getWebDriver()
		//driver.get("http://google.com");

		try {
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"));
			log.logInfo("Total no. of links are "
					+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						//verifyURLStatus(url);
						log.logInfo("Found URL = "+url);
						HttpClient client = HttpClientBuilder.create().build();
						HttpGet request = new HttpGet(url);
						try {
							HttpResponse response = client.execute(request);
							// verifying response code and The HttpStatus should be 200 if not,
							// increment invalid link count
							////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
							int code=response.getStatusLine().getStatusCode()
							if (code != 200){
								log.logError("Response code="+code+", Broken URL = "+url);
								invalidLinksCount++;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						invalidLinksCount++;
						log.logError("Response code="+code+", Broken URL = "+url);
					}
				}
			}

			log.logError("Total no. of invalid links are "
					+ invalidLinksCount);

		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
		}


		/*if (driver != null)
		 driver.quit();*/

	}


	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}