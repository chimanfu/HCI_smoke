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

//WebUI.refresh()
//WebUI.click(findTestObject('Page_G2G_linking_record/div_Group Linking (Parent)'))
// pull down Parent Linking Group: PRNT-1  GROUP_PRNT-1
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.switchToWindowIndex(0)


select_Tab_Group_Linking_Child()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-5 GROUP-2_CHLD-1'))
verify_goto_Parent_Linking_Group()

select_Tab_Group_Linking_Child()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-6 GROUP-2_CHLD-2'))
verify_goto_Parent_Linking_Group()

select_Tab_Group_Linking_Child()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-7 GROUP-2_CHLD-3'))
verify_goto_Parent_Linking_Group()

select_Tab_Group_Linking_Child()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-8 GROUP-2_CHLD-4'))
verify_goto_Parent_Linking_Group()

def verify_goto_Parent_Linking_Group(){
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_G2G_linking_record/span_PRNT-2'))
	WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Parent Linking Group'),10)
	
}
def select_Tab_Group_Linking_Child() {
    String test_automation_record_G2G_linking = 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081'
    WebUI.navigateToUrl(test_automation_record_G2G_linking)
    WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7081#tv=Group%20Linking%20(Child)')
    WebUI.waitForElementClickable(findTestObject('Page_G2G_linking_record/div_Group Linking (Child)'),15)
	WebUI.click(findTestObject('Page_G2G_linking_record/div_Group Linking (Child)'))
}

