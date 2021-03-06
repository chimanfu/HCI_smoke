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
	def select_PRNT_1_GROUP_PRNT_1(){
		//WebUI.refresh()
		//String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'
		//WebUI.navigateToUrl(test_automation_record_G2G_linking)
		//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Group%20Linking%20(Parent)')

		//WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'),20)
		//WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'))
		// pull down Parent Linking Group: PRNT-1  GROUP_PRNT-1
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_PRNT-1  GROUP_PRNT-1'),10)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_PRNT-1  GROUP_PRNT-1'))
		WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/label_G2G Parent Field Link Field'),20)
	}
	@Keyword
	def verify_goto_Parent_Linking_Group(){
		//WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_PRNT-2'),5)
		WebUI.click(findTestObject('Page_record_G2G_linking/span_PRNT-2'))
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Parent Linking Group'),10)
	}
	@Keyword
	def select_TAB_Group_Linking_Parent() {
		String test_automation_record_G2G_linking = GlobalVariable.G_MAKE_MAS_url+'/show_bug.cgi?id='+GlobalVariable.recordName1
		WebUI.navigateToUrl(test_automation_record_G2G_linking)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'),20)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'))
	}
	@Keyword
	def select_TAB_Basic_Information(){
		String test_automation_record_G2G_linking = GlobalVariable.G_MAKE_MAS_url+'/show_bug.cgi?id='+GlobalVariable.recordName1
		WebUI.navigateToUrl(test_automation_record_G2G_linking)
		// goto Tab: Basic Information
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Basic Information'),25)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_Basic Information'))
	}
	@Keyword
	def select_test_suite(String testSuiteName){
		// select test suite: Groups/
		WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/select_Test Suite'), 15)
		WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Test Suite'), testSuiteName, true)
	}

	@Keyword
	def select_TAB_Groups(){
		// goto Tab Groups
		WebUI.scrollToElement(findTestObject('Page_Administer your installation/a_Home'),10)
		WebUI.delay(2)
		WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Groups'),10)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Groups'),10)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_Groups'))
	}

	@Keyword
	def waitTestObject(String testobject){
		try{
			WebUI.waitForAngularLoad(10)
			WebUI.waitForJQueryLoad(10)
			WebUI.waitForElementPresent(findTestObject(testobject),10)
			WebUI.waitForElementVisible(findTestObject(testobject),10)
			WebUI.waitForElementClickable(findTestObject(testobject),5)
		}
		catch(Exception e) {
			KeywordUtil.markWarning(e.message)
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
		WebUI.click(findTestObject('Page_record_G2G_linking/a_Reuse Linked Parent'))
		// filter selection to only linked_parent
		WebUI.setText(findTestObject('Page_record_G2G_linking/input_groupLinkFilter'), linked_parent+'\n')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/input_saveVersion'),10)
		WebUI.click(findTestObject('Page_record_G2G_linking/input_saveVersion'))
		// save the change
		WebUI.click(findTestObject('Page_record_G2G_linking/button_Link selected Parent Linking Group'))
		//		WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
		//		WebUI.delay(5)
		//		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Close alertRecord Saved'),15)
		save_changes()
	}
	@Keyword
	def select_TAB_Group_Linking_Child() {
		String test_automation_record_G2G_linking = GlobalVariable.G_MAKE_MAS_url+'/show_bug.cgi?id='+GlobalVariable.recordName1
		WebUI.navigateToUrl(test_automation_record_G2G_linking)
		//WebUI.navigateToUrl(test_automation_record_G2G_linking+'#tv=Group%20Linking%20(Child)')
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'),15)
		WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Child)'))
	}
	@Keyword
	def delete_group_save_changes(){
		WebUI.click(findTestObject('Page_record_G2G_linking/span_(Delete)'))
		save_changes()
		//		WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
		//		WebUI.delay(5)
		//		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Close alertRecord Saved'),15)
	}
	@Keyword
	def done_save_changes(){
		WebUI.click(findTestObject('Page_record_G2G_linking/button_Done'))
		save_changes()
	}
	@Keyword
	def unlink_parent_group_save_changes(){
		WebUI.click(findTestObject('Page_record_G2G_linking/div_dataCardHeaderClip linked'))
		//WebUI.click(findTestObject('Page_record_G2G_linking/div_dataCardHeaderClip unlinked'))
		//WebUI.click(findTestObject('Page_record_G2G_linking/div_dataCardHeaderClip linked'))
		save_changes()
	}
	@Keyword
	def toggle_linkedPaperClip(){
		// unlink
		WebUI.click(findTestObject('Page_record_G2G_linking/span_flLink_linkedPaperClip'))

		// link
		WebUI.click(findTestObject('Page_record_G2G_linking/span_flLink_unLinkedPaperClip'))
	}
	@Keyword
	def unlink_child_group_save_changes(){
		WebUI.click(findTestObject('Page_record_G2G_linking/span_flLink_linkedPaperClip'))
		WebUI.click(findTestObject('Page_record_G2G_linking/span_(UNSAVED)'))
		save_changes()
	}
	@Keyword
	def save_changes(){
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/button_Save Changes'),5)
		(new helper.browserhelper.CustomBrowser()).takingScreenshot()
		WebUI.click(findTestObject('Page_record_G2G_linking/button_Save Changes'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Close alertRecord Saved'),20)
		WebUI.delay(2)
	}
}