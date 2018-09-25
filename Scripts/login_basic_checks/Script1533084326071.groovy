if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/*
 
Perform some basic checks after login

Steps:

login to site and home page displays
perform some basic checks on the menu toolbar and all links are not broken from the Main Page
	perform verifyAllLinksOnCurrentPageAccessible()
	click on each tab on menu toolbar and verify page is loaded correctly

for example:
in cp_oms_dev:
08-11-2018 04:53:00 PM - [WARNING] - Found 3 inaccessible links [https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/help/help.html, https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/help/CP-OMS_Overview.pdf, https://mas-dev.nas.nasa.gov/help/CP-OMS_Overview.pdf]
08-11-2018 04:53:00 PM - [FAILED] - Some of links on the current page are inaccessible
08-11-2018 04:53:00 PM - [FAILED] - Unable to verify all links on the page 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/index.cgi' are accessible (Root cause: Some of links on the current page are inaccessible)

*/
//Random rand = new Random();


boolean STOP_ON_FAILURE=false

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

KeywordLogger log = new KeywordLogger()

WebUI.waitForPageLoad(4)
WebUI.waitForJQueryLoad(20)

WebUI.comment('perform some basic checks on the menu toolbar and items from the Main Page...')
//WebUI.comment('check Links Broken (http return code != 200) On Current Page of New Record Record')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()


// randomly to run this test verifyAllLinksOnCurrentPageAccessible() or not (0 or 1)
if ((int) (Math.random()+0.5)){
	WebUI.comment('perform verifyAllLinksOnCurrentPageAccessible() and exclude links with src')
	CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)
	
}
else{
	WebUI.comment 'will skip running verifyAllLinksOnCurrentPageAccessible() this time to save time'
}
if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	WebUI.comment('this is doctree, different setting in Home page')
	WebUI.verifyTextPresent('SELECT FROM THE LIST OF PROGRAMS TO POPULATE THE TREE', false)
	WebUI.click(findTestObject('Page_Document Tree/img_System Logo'))
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_TREE'))
	
	WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '5', true)
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '2', true)
	
	WebUI.click(findTestObject('Object Repository/Page_Select Program/img'))
	
	WebUI.click(findTestObject('Object Repository/Page_Select Program/a_NEW RECORD'))
	
	WebUI.click(findTestObject('Page_Document Tree/img_System Logo'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/div_SEARCH'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))
	return
}else if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.comment('this is etasksheet, different setting in Home page')
	int currentTab = WebUI.getWindowIndex()
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_Search'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'))
	
	/*WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_Help'))
	WebUI.switchToWindowIndex(currentTab+1)
	WebUI.closeWindowIndex(currentTab + 1)
	WebUI.switchToWindowIndex(currentTab)*/
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_Admin'))
	
	WebUI.switchToWindowIndex(currentTab+1)
	WebUI.closeWindowIndex(currentTab + 1)
	WebUI.switchToWindowIndex(currentTab)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/a_About'),15)
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_About'))
	
	WebUI.click(findTestObject('Object Repository/Page_About eTask Worksheet Database/a_Charts'))
	
	WebUI.click(findTestObject('Page_Generate Chart/img_System Logo'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ARC JET/a_About'),15)
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_About'))
	
	WebUI.click(findTestObject('Object Repository/Page_About eTask Worksheet Database/a_Home'))
	return
}

WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Home'), 20, FailureHandling.OPTIONAL)
WebUI.comment('found Home link, should be already in Home page and login succeeded!')
WebUI.waitForPageLoad(30)
WebUI.comment('click on each tab on menu toolbar and page is loading correctly')
WebUI.click(findTestObject('Page_Main Page/a_Home'))

if (WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_New'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Main Page/a_New'))

    WebUI.comment('found New Record link from the user menu')
} else {
    log.logWarning('not found New Record link from the user menu toolbar, may need to add element for new record to appear')
}

WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Charts'))

WebUI.click(findTestObject('Object Repository/Page_Generate Chart/a_Advanced Search'))

if (GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
    WebUI.comment('this is iss_hazard')

    WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_VTL'))
}

if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Search for records/a_Signatures'), 1)) {
    WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Signatures'))
}

WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))

WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))

/*if (!(GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard_dev')){
		WebUI.comment 'this is cp_hazard_dev, no Subscriptions tab'
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
WebUI.comment('perform some basic checks on the menu items done!')

return null


/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}