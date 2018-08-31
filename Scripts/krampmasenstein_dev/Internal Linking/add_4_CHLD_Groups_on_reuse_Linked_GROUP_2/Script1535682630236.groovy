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

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.switchToWindowIndex(0)
//test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Basic%20Information'
String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'
WebUI.navigateToUrl(test_automation_record_G2G_linking)


// add child group GROUP-2_CHLD-1 and link to reuse linked parent GROUP_PRNT-2
WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-5'),5)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-5'))
WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_5'), 'GROUP-2_CHLD-1')
// reuse linked parent: GROUP_PRNT-2
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Reuse Linked Parent'))
// filter selection to only GROUP_PRNT-2
WebUI.setText(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_groupLinkFilter'), 'GROUP_PRNT-2\n')
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'),10)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'))
// save the change
WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Link selected Parent Linking Group'))
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'),15)


// add child group GROUP-2_CHLD-2 and link to reuse linked parent GROUP_PRNT-2
WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-6'),5)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-6'))
WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_6'), 'GROUP-2_CHLD-2')
// reuse linked parent: GROUP_PRNT-2
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Reuse Linked Parent'))
// filter selection to only GROUP_PRNT-2
WebUI.setText(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_groupLinkFilter'), 'GROUP_PRNT-2\n')
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'),10)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'))
// save the change
WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Link selected Parent Linking Group'))
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'),15)


// add child group GROUP-2_CHLD-3 and link to reuse linked parent GROUP_PRNT-2
WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))
WebUI.delay(1)
waitTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-7')
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-7'))
WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_7'), 'GROUP-2_CHLD-3')
// reuse linked parent: GROUP_PRNT-2
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Reuse Linked Parent'))
// filter selection to only GROUP_PRNT-2
WebUI.setText(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_groupLinkFilter'), 'GROUP_PRNT-2\n')
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'),10)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'))
// save the change
WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Link selected Parent Linking Group'))
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'),15)


// add child group GROUP-2_CHLD-4 and link to reuse linked parent GROUP_PRNT-2
WebUI.navigateToUrl(test_automation_record_G2G_linking)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'),20)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Group Linking (Child)'))
WebUI.delay(1)
waitTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-8')
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Add CHLD-8'))
WebUI.setText(findTestObject('Page_--- 7081 test_automation_recor/input_cf_g2g_child_text_NEW_ROW_8'), 'GROUP-2_CHLD-4')
// reuse linked parent: GROUP_PRNT-2
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/a_Reuse Linked Parent'))
// filter selection to only GROUP_PRNT-2
WebUI.setText(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_groupLinkFilter'), 'GROUP_PRNT-2\n')
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'),10)
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/input_saveVersion'))
// save the change
WebUI.click(findTestObject('Page_--- 7081 test_automation_recor/button_Link selected Parent Linking Group'))
WebUI.click(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/button_Save Changes'))
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_--- 7081 test_automation_recor/div_Close alertRecord Saved'),15)



def waitTestObject(String testobject){
	try{
		WebUI.waitForAngularLoad(10)
		WebUI.waitForJQueryLoad(10)
		WebUI.waitForElementPresent(findTestObject(testobject),5)
		WebUI.waitForElementVisible(findTestObject(testobject),5)
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