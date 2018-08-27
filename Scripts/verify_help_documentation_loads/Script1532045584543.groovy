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

/*
 * verify help page (user guide) is being loaded without issue.
 * will dynamically check all links in Help Page (User Guide)
 * 
 * Steps:
 * 
 * click Help tab from Home page
 * switch window to Help page
 * perform verifyAllLinksOnCurrentPageAccessible() to verify all links are not broken 
 * 		will report any links that are not accessible.
 * 		will fail the test if STOP_ON_FAILURE=true
 * 
 * dynamically get and check all links in from Table of Contents of Help Page (User Guide)
 * 		verify all links are accessible
 * 		verify all links from Table of Contents are working fine in the Help doc
 */

if ((GlobalVariable.G_MAKE_MAS_url).contains('ssma')){
	println('do not need to run this test')
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()
int currentTab = WebUI.getWindowIndex()

if ((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_Help'))
	WebUI.switchToWindowIndex(currentTab+1)
	
	println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
	boolean STOP_ON_FAILURE=false
	CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)
	
	println('verify all Displayed Name and URL from Table Of Contents to be verified from the current Page of Help Page (User Guide)')
	String xpath="//div[@class='toc']//a"
	CustomKeywords.'hci_smoke_test.common.navigateAllLinks_ByXpath'(xpath)
	
	WebUI.closeWindowIndex(currentTab + 1)
	WebUI.switchToWindowIndex(currentTab)
	return
}

WebUI.click(findTestObject('Page_Main Page/a_Help'))

WebUI.delay(1)
//GlobalVariable.G_MAKE_MAS_title
try{
	WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
}catch (Exception e) {
	println('cannot switch window ' + e.getMessage())
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
	WebUI.switchToWindowIndex(currentTab+1)
}

WebUI.delay(1)
if (WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h1_User Guide'),5))
	WebUI.click(findTestObject('Page_Help User Guide/h1_User Guide'))
// need dynamically check all links in Help Page (User Guide)

println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
boolean STOP_ON_FAILURE=false
CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)


//println('check Links are accessible and without Broken links (http return code != 200) On Current Page of Help Page (User Guide)')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()

println('verify all Displayed Name and URL from Table Of Contents to be verified from the current Page of Help Page (User Guide)')
String xpath="//div[@class='toc']//a"
CustomKeywords.'hci_smoke_test.common.navigateAllLinks_ByXpath'(xpath)

try {
	WebUI.closeWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' User Guide')
}
catch (Exception e) {
	println('cannot close window ' + e.getMessage())

	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
	WebUI.closeWindowIndex(currentTab + 1)
}

try {
	WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' Main Page')
}
catch (Exception e) {
	println('cannot switch window ' + e.getMessage())

	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
	WebUI.switchToWindowIndex(currentTab)
}


return
////////////////////////////////////////////////////////////

//WebUI.waitForPageLoad(5)

if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
	println 'this is cp_hazard'
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h1_User Guide'),25)
	WebUI.click(findTestObject('Page_Help User Guide/h1_User Guide'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/a_Entering Editing and Viewing'),25)
	WebUI.click(findTestObject('Page_Help User Guide/a_Entering Editing and Viewing'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/a_Searching Records'),25)
	WebUI.click(findTestObject('Page_Help User Guide/a_Searching Records'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/a_Charts'),25)
	WebUI.click(findTestObject('Page_Help User Guide/a_Charts'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/a_Preferences and Privileges'),15)
	WebUI.click(findTestObject('Page_Help User Guide/a_Preferences and Privileges'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/a_Approvals and Release of Rec'),15)
	WebUI.click(findTestObject('Page_Help User Guide/a_Approvals and Release of Rec'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h3_Table of Contents'),25)
	WebUI.click(findTestObject('Page_Help User Guide/h3_Table of Contents'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h3_Entering Editing and Viewing'),25)
	WebUI.click(findTestObject('Page_Help User Guide/h3_Entering Editing and Viewing'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h3_Searching Records'),25)
	WebUI.click(findTestObject('Page_Help User Guide/h3_Searching Records'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h3_Charts'),25)
	WebUI.click(findTestObject('Page_Help User Guide/h3_Charts'))
	
	WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h3_Preferences and Privileges'),15)
	WebUI.click(findTestObject('Page_Help User Guide/h3_Preferences and Privileges'))
}
else if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_oms')){
	println 'this is cp_oms'
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h1_CP-OMS User Guide'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Entering Editing and Viewing'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Entering Editing and Viewin'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Searching Records'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Searching Records'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Charts'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Charts'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Preferences and Privileges'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Settings and Permissions'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/a_Approval of Records'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/h2_Record Approval'))
	
	//WebUI.click(findTestObject('Object Repository/Page_CP-OMS User Guide/html_CP-OMS User Guidekatalonf'))	
	
}
try {
    WebUI.closeWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' User Guide')
}
catch (Exception e) {
    println('cannot close window ' + e.getMessage())

    //throw new AssertionError('ERROR: Unable to verify alert present: ', e)
    WebUI.closeWindowIndex(currentTab + 1)
} 

try {
    WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' Main Page')
}
catch (Exception e) {
    println('cannot switch window ' + e.getMessage())

    //throw new AssertionError('ERROR: Unable to verify alert present: ', e)	
    WebUI.switchToWindowIndex(currentTab)
}
//WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' Main Page')
//WebUI.click(findTestObject('Page_Main Page/a_Home'))






