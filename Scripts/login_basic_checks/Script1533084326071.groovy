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

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys
import org.sikuli.script.Key as Key
import org.sikuli.script.Screen as Screen

/*
login to site and home page
check Links Broken (http return code != 200) On Home Page 
check Home page elements/links
click on each tab on toolbar

*/


KeywordLogger log = new KeywordLogger()
Screen s = new Screen()

CustomKeywords.'helper.login.LoginHelper.login'()

/*WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
WebUI.click(findTestObject('Page_Login/input_login_btn'))
WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))*/

if (WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_Home'), 20, FailureHandling.OPTIONAL)) {
    //s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
    //WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
    println('found Home link, should be already in Home page and login succeeded!')
	
    WebUI.waitForPageLoad(30)

    if (WebUI.verifyAlertPresent(1, FailureHandling.OPTIONAL)) {
        alertText = WebUI.getAlertText()
        WebUI.acceptAlert()
        println('accept alert=' + alertText)
    }
	WebUI.waitForPageLoad(4)
	println('perform some basic checks on the menu toolbar and items from the Main Page...')
	
	println('check Links Broken (http return code != 200) On Current Page of New Record Record')
	CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
	
	WebUI.click(findTestObject('Page_Main Page/a_Home'))
	
	if (WebUI.waitForElementPresent(findTestObject('Page_Main Page/a_New'), 2, FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Page_Main Page/a_New'))
		println('found New Record link from the user menu')
	}else{
		log.logWarning('not found New Record link from the user menu toolbar, may need to add element for new record to appear')
	}
	
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Charts'))
	
	WebUI.click(findTestObject('Object Repository/Page_Generate Chart/a_Advanced Search'))
	if ((GlobalVariable.G_MAKE_MAS_url).contains('iss_hazard')){
		println 'this is iss_hazard'
		WebUI.click(findTestObject('Object Repository/Page_ISS Hazard Main Page/a_VTL'))
	}
	WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Signatures'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_Subscriptions'))
	
	WebUI.click(findTestObject('Object Repository/Page_Set up subscriptions/a_Settings'))
	
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
    //println('*** SetupTestCase done ***')

    return null
}
println('not found home link, so needs to login first')
try {
    // cp hazard login
    WebUI.click(findTestObject('Page_Login/input_login_btn'))

    // check if alert is showing
    if (WebUI.verifyAlertPresent(1)) {
        WebUI.acceptAlert()

        alertText = WebUI.getAlertText()

        println('alertText=' + alertText)
    }
}
catch (Exception e) {
    println('ERROR: Unable to verify alert present: ' + e.getMessage()) //throw new AssertionError('ERROR: Unable to verify alert present: ', e)
} 

// smart card login
try {
    if (WebUI.waitForElementPresent(findTestObject('Page_Access Launchpad/input_SCLOGIN'), 5)) {
        //WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
        WebUI.waitForPageLoad(5)

        //WebUI.delay(2)
        s.wait(GlobalVariable.G_image_path + 'smartcard_login_button.png', 10)

        s.click(GlobalVariable.G_image_path + 'smartcard_login_button.png')

        s.wait(GlobalVariable.G_image_path + 'acceptCert_ok_button.png', 10)

        s.click(GlobalVariable.G_image_path + 'acceptCert_ok_button.png')

        WebUI.delay(2)

        s.type('10051965\n') //Runtime.getRuntime().exec("osascript Desktop/typeText.scpt")
        //WebUI.clickImage(findTestObject('Object Repository/Page_Access Launchpad/smartcard_login_button'))
        //WebUI.delay(2)
        //WebUI.clickImage(findTestObject('Object Repository/Page_Access Launchpad/cert_ok_button'))
        //WebUI.delay(2)
        //WebUI.acceptAlert()
    }
}
catch (Exception e) {
    println('ERROR: Unable to complete smart card login: ' + e.getMessage()) //throw new AssertionError('ERROR: Unable to Page_Access Launchpad/input_SCLOGIN: ', e)
} 

//WebUI.delay(1)
//WebUI.waitForPageLoad(30)
//WebUI.wait
//WebUI.switchToWindowIndex(2)
//WebUI.acceptAlert()
//WebUI.clickImage(findTestObject('Object Repository/Page_Access Launchpad/cert_ok_button'))
WebUI.openBrowser('')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

// cp hazard login
try {
    if (WebUI.waitForElementPresent(findTestObject('Page_Login/input_login_btn'), 1)) {
        WebUI.click(findTestObject('Page_Login/input_login_btn'))
    }
    
    // check if alert is showing
    if (WebUI.verifyAlertPresent(1)) {
        WebUI.acceptAlert()

        alertText = WebUI.getAlertText()

        println('alertText=' + alertText)
    }
}
catch (Exception e) {
    println('not found input_login_btn' + e.getMessage()) //throw new AssertionError('ERROR: Unable to verify alert present: ', e)
} 

//s.wait(GlobalVariable.G_image_path + 'cp_hazard_logo.png', 10)


