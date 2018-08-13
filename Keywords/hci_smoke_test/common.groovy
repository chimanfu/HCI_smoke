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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.logging.LogEntries as LogEntries
import org.openqa.selenium.logging.LogEntry as LogEntry
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.Keys as Keys

class common {
	@Keyword
	def verifyAllLinksOnCurrentPageAccessible(boolean STOP_ON_FAILURE) {
		KeywordLogger log = new KeywordLogger()
	
		println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with attribute @src')
		WebDriver driver = DriverFactory.getWebDriver()
		
		int size
		String url
		String[] excluded_links
		
		List<WebElement> elements
		
		println('get all excluded_links with attribute src from the Page')
		
		elements = driver.findElements(By.xpath('//*[@src]'))
		
		size = elements.size()
		
		excluded_links = new String[size]
		
		for (int i = 0; i < size; i++) {
			//found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute('src')
		
			(excluded_links[i]) = url
		
			log.logInfo('src: ' + url)
		}
		
		List<WebElement> excluded_links_list = Arrays.asList(excluded_links)
		
		println('how many @src links=' + size)
		
		/*
		elements = driver.findElements(By.xpath("//*[@href]"))
		 //elements= driver.findElements(By.tagName("a"));
		size=elements.size()
		urls = new String[size]
		for (int i = 0; i < size; i++) {
			//found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute("href");
			urls[i]=url
			//log.logInfo("href: " + url);
		
		}
		println('how many links='+size)
		elements = driver.findElements(By.xpath("//*[@cite]"))
		size=elements.size()
		urls = new String[size]
		for (int i = 0; i < size; i++) {
			//found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute("cite");
			urls[i]=url
			log.logInfo("cite: " + url);
		
		}
		println('how many links='+size)
		elements = driver.findElements(By.xpath("//*[@data]"))
		size=elements.size()
		urls = new String[size]
		for (int i = 0; i < size; i++) {
			//found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute("data");
			urls[i]=url
			log.logInfo("data: " + url);
		
		}
		println('how many links='+size)
		*/
		if (STOP_ON_FAILURE)
			WebUI.verifyAllLinksOnCurrentPageAccessible(false, excluded_links_list, FailureHandling.STOP_ON_FAILURE)
		else
			WebUI.verifyAllLinksOnCurrentPageAccessible(false, excluded_links_list,FailureHandling.OPTIONAL)
		
		
	}
	

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
					log.logInfo("Found URL = "+url);
					//if (url != null && !url.contains("javascript")&& !url.contains("cgi")&& !url.contains("pdf")&& !url.contains("mailto:")) {
					if (url.contains(".html") && !url.contains("javascript") && !url.contains("cgi") && !url.contains("pdf") && !url.contains("mailto:")) {

						//verifyURLStatus(url);
						//log.logInfo("Found valid URL = "+url);
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
							}else{
								log.logInfo("Response code="+code+", Good URL = "+url);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						//invalidLinksCount++;
						//log.logError("Invalid URL = "+url);
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
	def navigateAllLinks_ByXpath(String xpath) {
		KeywordLogger log = new KeywordLogger()
		//String xpath="//div[@class='toc'']//a"
		String url
		String[] urls
		String found_new_record_link
		WebDriver driver = DriverFactory.getWebDriver()
		println('get all Displayed Name and URL to be verified from the current Page with xpath='+xpath)
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		//WebElement firstElement = elements.get(0);
		int size=elements.size()
		urls = new String[size]
		println('get Displayed Name and URL to be verified')
		for (int i = 0; i < size; i++) {
			found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute("href");
			urls[i]=url
			log.logInfo("Displayed Name: " + found_new_record_link);
			log.logInfo("URL: " + url);

		}
		for (int i = 0; i < size; i++) {
			println('navigate to URL: '+urls[i])
			WebUI.navigateToUrl(urls[i])
			//driver.navigate().to(url)
			appendBrowserLogs()
			//WebUI.click(findTestObject('Page_Main Page/a_New'))

		}

	}

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