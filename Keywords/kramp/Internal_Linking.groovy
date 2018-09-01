package kramp
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


class Internal_Linking {
	@Keyword
	def waitTestObject(String testobject){
		try{
			WebUI.waitForAngularLoad(10)
			WebUI.waitForJQueryLoad(10)
			WebUI.waitForElementPresent(findTestObject(testobject),10)
			WebUI.waitForElementVisible(findTestObject(testobject),10)
			WebUI.waitForElementClickable(findTestObject(testobject),5)
		}
		catch(Exception e)
		{
			WebUI.waitForAngularLoad(10)
			WebUI.waitForJQueryLoad(10)
			WebUI.waitForElementPresent(findTestObject(testobject),5)
			WebUI.waitForElementVisible(findTestObject(testobject),5)
			WebUI.waitForElementClickable(findTestObject(testobject),5)
		}
		
	}
	@Keyword
	def reuse_linked_parent_save_changes(String linked_parent){
		// reuse linked parent: linked_parent
		WebUI.click(findTestObject('Page_G2G_linking_record/a_Reuse Linked Parent'))
		// filter selection to only linked_parent
		WebUI.setText(findTestObject('Page_G2G_linking_record/input_groupLinkFilter'), linked_parent+'\n')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/input_saveVersion'),10)
		WebUI.click(findTestObject('Page_G2G_linking_record/input_saveVersion'))
		// save the change
		WebUI.click(findTestObject('Page_G2G_linking_record/button_Link selected Parent Linking Group'))
		WebUI.click(findTestObject('Page_G2G_linking_record/button_Save Changes'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Close alertRecord Saved'),15)
		}
	@Keyword
	def select_TAB_Group_Linking_Child() {
		String test_automation_record_G2G_linking = GlobalVariable.G_MAKE_MAS_url+'/show_bug.cgi?id='+GlobalVariable.recordName1
		WebUI.navigateToUrl(test_automation_record_G2G_linking)
		//WebUI.navigateToUrl(test_automation_record_G2G_linking+'#tv=Group%20Linking%20(Child)')
		WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Group Linking (Child)'),15)
		WebUI.click(findTestObject('Page_G2G_linking_record/div_Group Linking (Child)'))
	}
	@Keyword
	def delete_group_save_changes(){
		WebUI.click(findTestObject('Page_G2G_linking_record/span_(Delete)'))
		WebUI.click(findTestObject('Page_G2G_linking_record/button_Save Changes'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Close alertRecord Saved'),15)
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