if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
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
	WebUI.comment('do not need to run this test, No help available for SSMA -- expected')
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	siteURL=GlobalVariable.G_MAKE_MAS_url
	if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'load_file.cgi?file=help/help.html')
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_DOCTREE User Guide/h1_DOCTREE User Guide'),6)	
	return
}

int currentTab = WebUI.getWindowIndex()

if ((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/a_Help'))
	WebUI.switchToWindowIndex(currentTab+1)
	
	WebUI.comment('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
	boolean STOP_ON_FAILURE=false
	CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)
	
	WebUI.comment('verify all Displayed Name and URL from Table Of Contents to be verified from the current Page of Help Page (User Guide)')
	String xpath="//div[@class='toc']//a"
	CustomKeywords.'hci_smoke_test.common.navigateAllLinks_ByXpath'(xpath)
	
	WebUI.closeWindowIndex(currentTab + 1)
	WebUI.switchToWindowIndex(currentTab)
	return
}

WebUI.click(findTestObject('Page_Main Page/a_Help'))
WebUI.delay(1)
try{
	WebUI.switchToWindowIndex(currentTab+1)
}catch (Exception e) {
	WebUI.comment('cannot switch window ' + e.getMessage())
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
	WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title+' User Guide')
}
WebUI.delay(1)
if (WebUI.waitForElementClickable(findTestObject('Page_Help User Guide/h1_User Guide'),5))
	WebUI.click(findTestObject('Page_Help User Guide/h1_User Guide'))
// need dynamically check all links in Help Page (User Guide)
driver = DriverFactory.getWebDriver()
WebUI.comment('get all help links from the Help Doc Page')
elements = driver.findElements(By.xpath("//div[@class='toc']//a"));
//WebElement firstElement = elements.get(0);
size=elements.size()
WebUI.comment 'found '+size+' links from the Help Doc Page'
urls = new String[size]
for (int i = 0; i < size; i++) {
	//WebUI.comment('get new record link name and url')
	found_link=elements.get(i).getText()
	url = elements.get(i).getAttribute("href");
	urls[i]=url
	WebUI.comment ("found help link name: " + found_link+ "with URL: " + url);
}
WebUI.comment 'use verifyLinksAccessible() to verify all links from the Help Doc Page'
list_urls= Arrays.asList(urls);
WebUI.verifyLinksAccessible(list_urls, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('verify all Displayed Name and URL from Table Of Contents to be verified from the current Page of Help Page (User Guide)')
String xpath="//div[@class='toc']//a"
CustomKeywords.'hci_smoke_test.common.navigateAllLinks_ByXpath'(xpath)

try {
	WebUI.closeWindowIndex(currentTab + 1)
}
catch (Exception e) {
	WebUI.comment('cannot close window ' + e.getMessage())
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
	WebUI.closeWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' User Guide')
	//WebUI.closeWindowIndex(currentTab + 1)
}
try {
	WebUI.switchToWindowIndex(currentTab)
}
catch (Exception e) {
	WebUI.comment('cannot switch window ' + e.getMessage())
	WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' Main Page')
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
}

return
////////////////////////////////////////////////////////////

//WebUI.waitForPageLoad(5)
if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
	WebUI.comment 'this is cp_hazard'
	
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
	WebUI.comment 'this is cp_oms'
	
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
    WebUI.comment('cannot close window ' + e.getMessage())
    //throw new AssertionError('ERROR: Unable to verify alert present: ', e)
    WebUI.closeWindowIndex(currentTab + 1)
} 

try {
    WebUI.switchToWindowTitle(GlobalVariable.G_MAKE_MAS_title + ' Main Page')
}
catch (Exception e) {
    WebUI.comment('cannot switch window ' + e.getMessage())
    //throw new AssertionError('ERROR: Unable to verify alert present: ', e)	
    WebUI.switchToWindowIndex(currentTab)
}