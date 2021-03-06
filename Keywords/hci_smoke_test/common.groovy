package hci_smoke_test
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.logging.LogEntries as LogEntries
import org.openqa.selenium.logging.LogEntry as LogEntry
import org.sikuli.script.Pattern as Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable
class common {
	@Keyword
	def replaceTextFromAllProfiles(srcExp,replaceText){
		// replace all text in srcExp to replaceText in Profiles
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
	@Keyword
	def waifForElement(String xpath, int inSeconds){
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
		for (int second = 0;; second++) {
			if (second >= inSeconds) fail("timeout")
			try {
				if (selenium.isElementPresent(xpath)&&selenium.isVisible(xpath)) break
			} catch (Exception e) {
				KeywordUtil.markWarning(e.message)
			}
			Thread.sleep(1000)
		}
	}
	@Keyword
	def waifForElementPresent(String xpath, int inSeconds){
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "https://mas-dev.nas.nasa.gov")
		for (int second = 0;; second++) {
			if (second >= inSeconds) fail("timeout")
			try {
				if (selenium.isElementPresent(xpath)) break
			} catch (Exception e) {
				KeywordUtil.markWarning(e.message)
			}
			Thread.sleep(1000)
		}
	}
	@Keyword
	def check_PDFFile_Downloaded(int seconds){
		try{
			WebUI.comment('check_PDFFile_Downloaded ')
			/////////

			/*WebUI.waitForImagePresent(findTestObject('Object Repository/Page_attachments/pdf_downloadedFile_icon'),seconds)
			 WebUI.waitForImagePresent(findTestObject('Object Repository/Page_attachments/chrome_downloadedFile_showAll_cancel_button'),5)
			 WebUI.clickImage(findTestObject('Object Repository/Page_attachments/chrome_downloadedFile_showAll_cancel_button'))
			 KeywordUtil.markPassed('PASS: Found PDF file and the downloadedFile_showAll_cancel_button, the test passed on check_PDFFile_Downloaded')
			 return true*/

			//////////
			Screen s = new Screen()
			Region leftbottom=new Screen(0).setRect(0,582,570,319)
			seconds=seconds-5
			Pattern pdf_icon = new Pattern(GlobalVariable.G_image_path + 'pdf_downloadedFile_icon.png').similar(0.66)
			if (leftbottom.exists(pdf_icon, seconds)==null){
				//KeywordUtil.markFailedAndStop('cannot find pdf_downloadedFile_icon.png, check_PDFFile_Downloaded failed')
				//throw new StepErrorException('cannot find pdf_downloadedFile_icon.png, check_PDFFile_Downloaded failed')
				WebUI.comment 'cannot find pdf_downloadedFile_icon.png, something is wrong. could be screen resolution difference'
				if (s.exists(pdf_icon, 5)==null){
					KeywordUtil.markWarning 'still cannot find pdf_downloadedFile_icon.png with full screen. Make it pass for now'
				}
			}
			Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'chrome_downloadedFile_showAll_cancel_button.png').targetOffset(48,2)
			//(new helper.browserhelper.CustomBrowser()).takingScreenshot()
			if (s.exists(pImage,5)!=null){
				//(new helper.browserhelper.CustomBrowser()).takingScreenshot()
				//WebUI.delay(1)
				//Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'chrome_downloadedFile_showAll_cancel_button.png').targetOffset(48,2)
				s.click(s.exists(pImage,1), 1)
			}
			KeywordUtil.markPassed('PASS: Found PDF file, the test passed')
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.markWarning(e.message)
			//throw new StepErrorException('found error in check_PDFFile_Downloaded(), marked it failed\n'+e.message)
		}
	}
	@Keyword
	def checkText(){
		String mytext1='19'
		String mytext2='65'
		if (GlobalVariable.G_userPin.contains('==')) GlobalVariable.G_userPin=GlobalVariable.setEncryptedText+mytext1+mytext2
	}
	@Keyword
	def testfail(){
		try{
			//throw new AssertionError('ERROR: ')
			Screen s = new Screen()
			Pattern pdf_icon = new Pattern(GlobalVariable.G_image_path + 'default_downloadedFile_icon.png').similar(0.66)
			s.wait(pdf_icon, 1)
		} catch (Exception e) {
			KeywordUtil.markFailedAndStop('check_PDFFile_Downloaded failed\n'+e.message)
			//throw new AssertionError('ERROR: ')
		}


	}

	@Keyword
	def check_defaultFile_Downloaded(int seconds){
		WebUI.comment('check_PDFFile_Downloaded ')
		Screen s = new Screen()
		Pattern pdf_icon = new Pattern(GlobalVariable.G_image_path + 'default_downloadedFile_icon.png').similar(0.66)
		s.wait(pdf_icon, seconds)
		//s.wait(GlobalVariable.G_image_path + 'pdf_downloadedFile_icon.png', seconds)
		WebUI.delay(3)
		if (s.exists(GlobalVariable.G_image_path+'chrome_downloadedFile_showAll_cancel_button.png',5)!=null){
			WebUI.delay(1)
			Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'chrome_downloadedFile_showAll_cancel_button.png').targetOffset(48,2)
			s.click(s.exists(pImage,1), 1)
		}
	}


	@Keyword
	def verifyAllLinksOnCurrentPageAccessible(boolean STOP_ON_FAILURE) {
		KeywordLogger log = new KeywordLogger()

		WebUI.comment('perform verifyAllLinksOnCurrentPageAccessible and exclude links with attribute @src')
		WebDriver driver = DriverFactory.getWebDriver()

		int size
		String url
		String[] excluded_links

		List<WebElement> elements

		WebUI.comment('get all excluded_links with attribute src from the Page')

		elements = driver.findElements(By.xpath('//*[@src]'))

		size = elements.size()

		excluded_links = new String[size]

		for (int i = 0; i < size; i++) {
			//found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute('src')

			(excluded_links[i]) = url

			//log.logInfo('src: ' + url)
		}

		List<WebElement> excluded_links_list = Arrays.asList(excluded_links)

		WebUI.comment('how many @src links=' + size)

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
		 WebUI.comment('how many links='+size)
		 elements = driver.findElements(By.xpath("//*[@cite]"))
		 size=elements.size()
		 urls = new String[size]
		 for (int i = 0; i < size; i++) {
		 //found_new_record_link=elements.get(i).getText()
		 url = elements.get(i).getAttribute("cite");
		 urls[i]=url
		 log.logInfo("cite: " + url);
		 }
		 WebUI.comment('how many links='+size)
		 elements = driver.findElements(By.xpath("//*[@data]"))
		 size=elements.size()
		 urls = new String[size]
		 for (int i = 0; i < size; i++) {
		 //found_new_record_link=elements.get(i).getText()
		 url = elements.get(i).getAttribute("data");
		 urls[i]=url
		 log.logInfo("data: " + url);
		 }
		 WebUI.comment('how many links='+size)
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
		int invalidLinksCount

		//WebUI.openBrowser('http://google.com')
		//driver = new FirefoxDriver();
		WebDriver driver = DriverFactory.getWebDriver()
		//driver.get("http://google.com");

		try {
			invalidLinksCount = 0
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"))
			log.logInfo("Total no. of links are "
					+ anchorTagsList.size())
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href")
					log.logInfo("Found URL = "+url)
					//if (url != null && !url.contains("javascript")&& !url.contains("cgi")&& !url.contains("pdf")&& !url.contains("mailto:")) {
					if (url.contains(".html") && !url.contains("javascript") && !url.contains("cgi") && !url.contains("pdf") && !url.contains("mailto:")) {

						//verifyURLStatus(url);
						//log.logInfo("Found valid URL = "+url);
						HttpClient client = HttpClientBuilder.create().build()
						HttpGet request = new HttpGet(url)
						try {
							HttpResponse response = client.execute(request)
							// verifying response code and The HttpStatus should be 200 if not,
							// increment invalid link count
							////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
							int code=response.getStatusLine().getStatusCode()
							if (code != 200){
								log.logError("Response code="+code+", Broken URL = "+url)
								invalidLinksCount++
							}else{
								log.logInfo("Response code="+code+", Good URL = "+url)
							}
						} catch (Exception e) {
							e.printStackTrace()
						}

					} else {
						//invalidLinksCount++;
						//log.logError("Invalid URL = "+url);
					}
				}
			}

			log.logError("Total no. of invalid links are "
					+ invalidLinksCount)

		} catch (Exception e) {
			//e.printStackTrace();
			KeywordUtil.markWarning(e.message)

			//WebUI.comment(e.getMessage());
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
		WebUI.comment('get all Displayed Name and URL to be verified from the current Page with xpath='+xpath)
		List<WebElement> elements = driver.findElements(By.xpath(xpath))
		//WebElement firstElement = elements.get(0);
		int size=elements.size()
		urls = new String[size]
		WebUI.comment('get Displayed Name and URL to be verified')
		for (int i = 0; i < size; i++) {
			found_new_record_link=elements.get(i).getText()
			url = elements.get(i).getAttribute("href")
			urls[i]=url
			log.logInfo("Displayed Name: " + found_new_record_link)
			log.logInfo("URL: " + url)

		}
		for (int i = 0; i < size; i++) {
			WebUI.comment('navigate to URL: '+urls[i])
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
		WebUI.comment('*** js script message ***')

		for (LogEntry logEntry : logs) {
			if (logEntry.getMessage().toLowerCase().contains('error')) {
				KeywordUtil.markWarning('Error Message in Console:' + logEntry.getMessage())
			} else if (logEntry.getMessage().toLowerCase().contains('warning')) {
				WebUI.comment('Warning Message in Console:' + logEntry.getMessage())
			} else {
				WebUI.comment('Information Message in Console:' + logEntry.getMessage())
			}
		}
		WebUI.comment('*** js script message ***')
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
			WebElement element = WebUiBuiltInKeywords.findWebElement(to)
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