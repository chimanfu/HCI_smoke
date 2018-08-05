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

//package com.linked;

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

KeywordLogger log = new KeywordLogger()
	//private WebDriver driver;
	 int invalidLinksCount;


	 WebUI.openBrowser('http://google.com')
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
	

		if (driver != null)
			driver.quit();
	

	public void verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
				invalidLinksCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
