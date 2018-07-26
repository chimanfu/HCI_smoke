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
import org.sikuli.script.Key as Key
import org.sikuli.script.Screen as Screen

Screen s = new Screen()

//GlobalVariable.G_image_path="/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/"
// smoke testcase: run_sanityCheck
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
WebUI.waitForPageLoad(50)
WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Admin'))
//WebUI.waitForPageLoad(5)
try {
	/*
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'), 10)
    WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'))
	s.wait(10)
	*/
    s.wait(GlobalVariable.G_image_path + 'sanityCheck_link.png', 20)
    s.click(GlobalVariable.G_image_path + 'sanityCheck_link.png')
    WebUI.delay(1)
    s.click(GlobalVariable.G_image_path + 'sanityCheck_link.png')
    WebUI.delay(1) 
    //s.click(GlobalVariable.G_image_path+'sanityCheck_link.png')
    
}
catch (Exception e) {
    println('ERROR: Unable to find sanity check link: ' + e.getMessage()) //throw new AssertionError('ERROR: Unable to verify alert present: ', e)
} 

//WebUI.click(findTestObject('Object Repository/Page_Sanity Check/html_Sanity Check'))
//WebUI.waitForPageLoad(5)
WebUI.delay(10)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sanity Check/p_OK now running sanity checks'), 90)
//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Sanity Check/p_OK now running sanity checks'), 100)
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/Page_Sanity Check/p_OK now running sanity checks'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_Sanity check completed'), 160)
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_Sanity check completed'), 200)
WebUI.delay(1)
//WebUI.click(findTestObject('Page_Sanity Check/p_Sanity check completed'))

//WebUI.click(findTestObject('Object Repository/Page_Sanity Check/a_Home'))

