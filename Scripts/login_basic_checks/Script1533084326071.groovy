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
import java.util.List as List
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.sikuli.script.Key as Key
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

/*
 
Perform some basic checks after login

Steps:

login to site and home page displays
perform some basic checks on the menu toolbar and all links are not broken from the Main Page
	perform verifyAllLinksOnCurrentPageAccessible and exclude links with attribute src
	click on each tab on menu toolbar and page is loading correctly

for example:
in cp_oms_dev:
08-11-2018 04:53:00 PM - [WARNING] - Found 3 inaccessible links [https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/help/help.html, https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/help/CP-OMS_Overview.pdf, https://mas-dev.nas.nasa.gov/help/CP-OMS_Overview.pdf]
08-11-2018 04:53:00 PM - [FAILED] - Some of links on the current page are inaccessible
08-11-2018 04:53:00 PM - [FAILED] - Unable to verify all links on the page 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/index.cgi' are accessible (Root cause: Some of links on the current page are inaccessible)

*/
KeywordLogger log = new KeywordLogger()

Screen s = new Screen()

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Home'), 20, FailureHandling.OPTIONAL)

println('found Home link, should be already in Home page and login succeeded!')

WebUI.waitForPageLoad(30)

if (WebUI.verifyAlertPresent(1, FailureHandling.OPTIONAL)) {
    alertText = WebUI.getAlertText()

    WebUI.acceptAlert()

    println('accept alert=' + alertText)
}

WebUI.waitForPageLoad(4)

println('perform some basic checks on the menu toolbar and items from the Main Page...')
//println('check Links Broken (http return code != 200) On Current Page of New Record Record')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
boolean STOP_ON_FAILURE=false
CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)

//return null

println('click on each tab on menu toolbar and page is loading correctly')
WebUI.click(findTestObject('Page_Main Page/a_Home'))

if (WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_New'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Main Page/a_New'))

    println('found New Record link from the user menu')
} else {
    log.logWarning('not found New Record link from the user menu toolbar, may need to add element for new record to appear')
}

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Charts'))

WebUI.click(findTestObject('Object Repository/Page_Generate Chart/a_Advanced Search'))

if (GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
    println('this is iss_hazard')

    WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_VTL'))
}

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Search for records/a_Signatures'), 1)) {
    WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Signatures'))
}

WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))

WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))

/*if (!(GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard_dev')){
		println 'this is cp_hazard_dev, no Subscriptions tab'
		WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_Subscriptions'))
}*/
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Request Queue/a_Subscriptions'), 1)) {
    WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_Subscriptions'))
}

try {
    WebUI.click(findTestObject('Object Repository/Page_Set up subscriptions/a_Settings'))
}
catch (Exception e) {
    WebUI.click(findTestObject('Page_Set up subscriptions/a_Prefs'))
} 

WebUI.click(findTestObject('Object Repository/Page_User Preferences/a_Admin'))

WebUI.click(findTestObject('Page_Administer your installation/a_Home'))

/*
	WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Help'))

	try{
		WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
		WebUI.closeWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
	}catch (Exception e) {
		WebUI.switchToWindowTitle('Help')
		WebUI.closeWindowTitle('Help')
	}
	
	
	WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' Main Page')
	*/
println('perform some basic checks on the menu items done!')

return null
