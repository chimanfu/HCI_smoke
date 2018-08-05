package tools

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit

import org.frontendtest.components.ImageComparison
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Wait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.constants.StringConstants
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

public class WebUICustomKeywords {

	/**
	 * Upload a file
	 */
	@Keyword
	def fileUploader(TestObject to, String filePath) {
		WebUI.click(to)
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
	}


	/**
	 * Click Location on screen
	 */
	@Keyword
	def clickLocation(Integer xCord, Integer yCord) {
		Robot robot = new Robot();
		robot.delay(1000);
		robot.mouseMove(xCord, yCord);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(300);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
	}


	/**
	 * Click Object Location on screen
	 */
	@Keyword
	def clickObject(TestObject to1, Integer xCord, Integer yCord) {
		Robot robot = new Robot();
		robot.delay(1000);
		robot.mouseMove(xCord, yCord);
		robot.delay(1000);
		WebUI.click(to1)
	}


	/**
	 * Highlight Object on screen
	 */
	@Keyword
	def highlightElement(TestObject to) {
		try{
			WebElement ele = WebUiCommonHelper.findWebElement(to,15)
			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver();
				js.executeScript("arguments[0].style.border='4px solid red'", ele);
				Thread.sleep(1000);
				js.executeScript("arguments[0].style.border=''", ele);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	/**
	 * Clear a text field
	 */
	@Keyword
	def ClearTextField(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(to, Keys.chord(Keys.DELETE))
	}


	/**
	 * Set Browser Zoom Level
	 */
	@Keyword
	def zoomBrowser(int zoomLevel) {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor)driver
		js.executeScript("document.body.style.zoom = " + zoomLevel/100 )
	}


	/**
	 * Compare Screenshots
	 */
	@Keyword
	def compareImage(String imgOriginal, String imgToCompareWithOriginal, String imgOutputDifferences)	{
		KeywordLogger logger = new KeywordLogger()
		ImageComparison imageComparison = new ImageComparison(20,20,0.05)
		Map<String, String> attributes = new HashMap<>()
		if(imageComparison.fuzzyEqual(imgOriginal,imgToCompareWithOriginal,imgOutputDifferences)) {
			KeywordUtil.markPassed("Images are fuzzy-equal.")
		}
		else {
			attributes.put(StringConstants.XML_LOG_ATTACHMENT_PROPERTY, imgOutputDifferences)
			KeywordUtil.markFailed("Images are NOT fuzzy-equal.")
			logger.logFailed("Images are NOT fuzzy-equal.", attributes)
		}
	}

	/**
	 * Compare Screenshots Not Equal
	 */
	@Keyword
	def compareImageNotEqual(String imgOriginal, String imgToCompareWithOriginal, String imgOutputDifferences)	{
		KeywordLogger logger = new KeywordLogger()
		ImageComparison imageComparison = new ImageComparison(20,20,0.05)
		Map<String, String> attributes = new HashMap<>()
		if(imageComparison.fuzzyEqual(imgOriginal,imgToCompareWithOriginal,imgOutputDifferences)) {
			KeywordUtil.markFailed("Images match, but should not.")
			logger.logFailed("Images match, but should not.", attributes)
		}
		else {
			attributes.put(StringConstants.XML_LOG_ATTACHMENT_PROPERTY, imgOutputDifferences)
			KeywordUtil.markPassed("Images successfully do not match.")
		}
	}


	/**
	 * Click an element using JS
	 */
	@Keyword
	def clickUsingJS(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}


	/**
	 * Click and Scroll
	 */
	@Keyword
	def waitForElementScrollandClick(TestObject to) {
		WebElement element = WebUiCommonHelper.findWebElement(to, 15)
		if (WebUiBuiltInKeywords.waitForElementClickable(to, 15))	{
			WebUI.click(to)
		} else {
			WebUiBuiltInKeywords.scrollToElement(to, 15)
			WebUI.delay(2)
			WebUI.click(to)
		}
	}


	/**
	 * Resize Browser
	 */
	@Keyword
	def resizeBrowser(Integer xCord, Integer yCord) {
		Dimension d = new Dimension(xCord,yCord);
		//Resize current window to the set dimension
		DriverFactory.webDriver.manage().window().setSize(d);
	}


	/**
	 * Set Browser Position
	 */
	@Keyword
	def setBrowser(Integer xCord, Integer yCord) {
		Point p = new Point(xCord,yCord);
		//Resize current window to the set position
		DriverFactory.webDriver.manage().window().setPosition(p);
	}


	/**
	 * Sleep (milliseconds)
	 */
	@Keyword
	def Sleep(int time) {
		Thread.sleep(time)
	}



	/**
	 * Verify Partial Element Text
	 */
	@Keyword
	boolean verifyPartialElementText(TestObject to, String text) {
		WebElement element = WebUiCommonHelper.findWebElement(to, 15)
		String actualString = element.getText()
		if (actualString.contains(text))	{
			KeywordUtil.markPassed("Element contains correct text")
		} else {
			KeywordUtil.markFailed("Element does not contain correct text")
		}
	}


	/**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */
	@Keyword
	def isElementPresent(TestObject to, int timeout){
		//Use Katalon built-in function to find elements with time out 1 seconds
		List<WebElement> elements = WebUiBuiltInKeywords.findWebElements(to, timeout)
		return elements.size() > 0
	}


	/**
	 * Find by locator
	 */
	@Keyword
	def byLocator(final By locator) {
		def driver = DriverFactory.getWebDriver();
		println "Get element by locator: " + locator.toString();
		final long startTime = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring( StaleElementReferenceException.class ) ;
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		while ( (System.currentTimeMillis() - startTime) < 91000 ) {
			println "Searching for element. Try number " + tries++;
			try {
				we = wait.until(ExpectedConditions.presenceOfElementLocated( locator ) );
				found = true;
				break;
			} catch ( StaleElementReferenceException e ) {
				println "Stale element: " + e.getMessage() ;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if ( found ) {
			println "Found element after waiting for " + totalTime + " milliseconds.";
		} else {
			println "Failed to find element after " + totalTime + " milliseconds.";
		}
		return we;
	}


	/**
	 * Generate a random email address
	 * String Mail = CustomKeywords.'tools.WebUICustomKeywords.getEmail'('test', 'gmail.com')
	 * println Mail
	 * Output Example: test350@gmail.com
	 */
	@Keyword
	public String getEmail(String suffix,String prefix){
		int randomNo = (int)(Math.random() * 1000);
		return suffix + randomNo + "@" + prefix;
	}

	
	/**
	 * Kill any left over running Chrome process
	 */
	@Keyword
	def killProcess() {
	 Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f")
	 Runtime.getRuntime().exec("taskkill /im chrome.exe /f")
	 //Runtime.getRuntime().exec("taskkill /im excel.exe /f")
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


	/**
	 * Get all cells of HTML table row
	 * @param row a WebElement instance represent for HTML table row
	 * @param tagName HTML column tag name, usually is TD/TH
	 * @return All cells inside HTML table row
	 */
	@Keyword
	def List<WebElement> getHtmlTableColumns(WebElement row, String tagName) {
		List<WebElement> selectedColumns = row.findElements(By.tagName(tagName))
		return selectedColumns
	}


	/**
	 * Get text of a cell which is identified by row index and column index 
	 * @param rowIndex Index of row, start at 1 
	 * @param columnIndex Index of column, start at 1 
	 * @return Value of specific cell 
	 */
	@Keyword
	def getCellText(TestObject table, int rowIndex, int columnIndex) {
		WebElement eTable = WebUiBuiltInKeywords.findWebElement(table);
		WebElement row = eTable.findElements(By.tagName("tr")).get(rowIndex - 1);
		List&lt;WebElement&gt; cells = row.findElements(By.tagName("td"));
		WebElement element = cells.get(columnIndex - 1)
		return element.getText()
	}


	/**
	 * Verify Dropdown values are in Alphabetical order
	 */
	@Keyword
	public static void verifyOptionsInDropdownInAphabeticalOrder(element) {
		Select ele = new Select(element)
		List<String> expectedOptions = new ArrayList<>()
		List<String> actualOptions = new ArrayList<>()
		for (WebElement option : ele.getOptions()) {
			System.out.println("Dropdown options are: " + option.getText())
			actualOptions.add(option.getText())
			expectedOptions.add(option.getText())
		}
		Collections.sort(actualOptions)
		System.out.println("Numbers of options present in the dropdown: " + actualOptions.size())
		Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray())
		System.out.println("Yes Dropdown values are in Alphabetical order")
	}


	/**
	 * Verify Expected And Actual Options In Dropdown
	 */
	@Keyword
	public static void VerifyExpectedAndActual(TestObject objectto, List<String> listOfOptions) {
		try {
			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
			Select ele = new Select(element);
			List<String> expectedOptions = listOfOptions;
			List<String> actualOptions = new ArrayList<String>();
			for (WebElement option : ele.getOptions()) {

				actualOptions.add(option.getText());
			}
			Collections.sort(actualOptions)
			Collections.sort(expectedOptions)
			Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}
}

