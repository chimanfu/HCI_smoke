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
import org.openqa.selenium.Keys as Keys
import org.sikuli.script.Key as Key
import org.sikuli.script.Screen as Screen

Screen s = new Screen()

//sikuli_image_path="/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/"
//WebUI.openBrowser()
//WebUI.waitForPageLoad(30)
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
//WebUI.navigateToUrl(GlobalVariable.G_cp_hazard_url)
if (WebUI.waitForElementPresent(findTestObject('Page_Configuration NASA Params/a_Home'), 1, FailureHandling.OPTIONAL)) {
    //s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',10)
    WebUI.navigateToUrl(GlobalVariable.G_cp_hazard_url)
    println('found home link, login to cp_hazard succeeded!')
	
    WebUI.waitForPageLoad(30)

    if (WebUI.verifyAlertPresent(1, FailureHandling.OPTIONAL)) {
        alertText = WebUI.getAlertText()

        WebUI.acceptAlert()

        println('accept alert=' + alertText)
    }
	WebUI.waitForPageLoad(4)
	println('perform some basic checks on the menu items from the CP-Hazard Main Page...')
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Home'))
	
	WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_New'))
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Charts'))
	
	WebUI.click(findTestObject('Object Repository/Page_Generate Chart/a_Advanced Search'))
	
	WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Signatures'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_SavedSearches'))
	
	WebUI.click(findTestObject('Object Repository/Page_Request Queue/a_Subscriptions'))
	
	WebUI.click(findTestObject('Object Repository/Page_Set up subscriptions/a_Settings'))
	
	WebUI.click(findTestObject('Object Repository/Page_User Preferences/a_Admin'))
	
	WebUI.click(findTestObject('Page_Administer your installation/a_Home'))
	WebUI.click(findTestObject('Object Repository/Page_Search for records/a_Help'))
	WebUI.switchToWindowTitle('CP-Hazard User Guide')
	WebUI.closeWindowTitle('CP-Hazard User Guide')
	WebUI.switchToWindowTitle('CP-Hazard Main Page')
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
WebUI.openBrowser()
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

s.wait(GlobalVariable.G_image_path + 'cp_hazard_logo.png', 10)



