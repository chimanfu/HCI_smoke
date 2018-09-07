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

url = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev'
//WebUI.refresh()
// directly navigate to the record: test_automation_record_G2G_linking
test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'

def select_PRNT_1_GROUP_PRNT_1(){
	//WebUI.refresh()
	String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'
	WebUI.navigateToUrl(test_automation_record_G2G_linking)
	//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Group%20Linking%20(Parent)')
	
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'),20)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_Group Linking (Parent)'))
	// pull down Parent Linking Group: PRNT-1  GROUP_PRNT-1
	WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/div_PRNT-1  GROUP_PRNT-1'),10)
	WebUI.click(findTestObject('Page_record_G2G_linking/div_PRNT-1  GROUP_PRNT-1'))
	WebUI.scrollToElement(findTestObject('Page_record_G2G_linking/label_G2G Parent Field Link Field'),20)
	}
CustomKeywords.'helper.login.LoginHelper.login'()
//WebUI.switchToWindowIndex(0)

select_PRNT_1_GROUP_PRNT_1()
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_CHLD-1 GROUP-1_CHLD-1'),10)
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/span_CHLD-1 GROUP-1_CHLD-1'),10)
WebUI.delay(1)
WebUI.click(findTestObject('Page_record_G2G_linking/span_CHLD-1 GROUP-1_CHLD-1'))
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Child Linking Group'),15)

select_PRNT_1_GROUP_PRNT_1()
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_CHLD-2 GROUP-1_CHLD-2'),10)
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/span_CHLD-2 GROUP-1_CHLD-2'),10)
WebUI.delay(1)
WebUI.click(findTestObject('Page_record_G2G_linking/span_CHLD-2 GROUP-1_CHLD-2'))
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Child Linking Group'),15)

select_PRNT_1_GROUP_PRNT_1()
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_CHLD-3 GROUP-1_CHLD-3'),10)
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/span_CHLD-3 GROUP-1_CHLD-3'),10)
WebUI.delay(1)
WebUI.click(findTestObject('Page_record_G2G_linking/span_CHLD-3 GROUP-1_CHLD-3'))
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Child Linking Group'),15)

select_PRNT_1_GROUP_PRNT_1()
WebUI.waitForElementClickable(findTestObject('Page_record_G2G_linking/span_CHLD-4 GROUP-1_CHLD-4'),10)
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/span_CHLD-4 GROUP-1_CHLD-4'),10)
WebUI.delay(1)
WebUI.click(findTestObject('Page_record_G2G_linking/span_CHLD-4 GROUP-1_CHLD-4'))
WebUI.waitForElementVisible(findTestObject('Page_record_G2G_linking/div_Child Linking Group'),15)



