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
import com.mysql.jdbc.StringUtils;
String logMessage=''
def checkLogMessage(String checklogMessage,String logMessage){
	//checklogMessage='Checking for attachment indexer.'
	if (logMessage.contains(checklogMessage)){
		println('found log message : '+checklogMessage)
	}else{
		println('not found log message : '+checklogMessage)
		throw new AssertionError('ERROR: not found log message : '+checklogMessage)
	}
}
Screen s = new Screen()


/*
WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))
*/

println('Run sanity checks to locate problems in your database. This may take several tens of minutes depending on the size of your installation. ')
println('You can also automate this check by running sanitycheck.pl from a cron job. A notification will be sent per email to the specified user if errors are detected.')

//GlobalVariable.G_image_path="/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/"
// smoke testcase: run_sanityCheck
//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
WebUI.waitForPageLoad(60)
WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_Admin'))
//WebUI.waitForPageLoad(5)
try {
	// it may crash selenium by clciking on the Sanity Check link or it may wait for the page load forever.
	// will workaround it by clicking on the anityCheck_link.png with opencv image recognation feature
	/*
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'), 60)
	WebUI.delay(1)
    WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'))
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
println('verify sanity check is working and without new issue.')
WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_now running sanity checks'), 90)
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_now running sanity checks'), 100)
//WebUI.delay(1)
//WebUI.click(findTestObject('Page_Sanity Check/p_output_log_message.rs'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_Sanity check completed'), 160)
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_Sanity check completed'), 200)
WebUI.delay(1)

// print out all log message
logMessage=WebUI.getText(findTestObject('Object Repository/Page_Sanity Check/p_output_log_message'))
println(logMessage)

// check log message
/*expectedlogMessage='Checking for attachment indexer.'
checkLogMessage(expectedlogMessage,logMessage)

expectedlogMessage='Checking for unindexed attachments...'
checkLogMessage(expectedlogMessage,logMessage)*/

println('check expected log message')
for (row = 1; row <= findTestData('sanity_check_log').getRowNumbers(); row++){
	//checkLogMessage(findTestData('sanity_check_log').getValue('log_message', row),logMessage)
	String expected_log_message=(findTestData('sanity_check_log').getValue('expected_log_message', row)).trim()
	//println('expected_log_message='+expected_log_message)
	if (!StringUtils.isNullOrEmpty(expected_log_message)){
		if (! logMessage.contains(expected_log_message)){
			println('not found expected log message : '+expected_log_message)
			throw new AssertionError('ERROR: not found expected log message : '+expected_log_message)
		}
	}
	/*else{
	   println('isNullOrEmpty')
	}*/
}
println('all expected log messages found in actual sanity check log output')

/*
if (logMessage.contains(checklogMessage)){
	println('found log message : '+checklogMessage)
}else{
	println('not found log message : '+checklogMessage)
	throw new AssertionError('ERROR: not found log message : '+checklogMessage)
}
*/
//WebUI.click(findTestObject('Page_Sanity Check/p_Sanity check completed'))

//WebUI.click(findTestObject('Object Repository/Page_Sanity Check/a_Home'))

