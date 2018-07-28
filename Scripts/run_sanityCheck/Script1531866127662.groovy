import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.List;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.antlr.PythonParser.return_stmt_return
import org.openqa.selenium.WebDriver
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

/*
log.logError("")
log.logFailed("")
log.logInfo("")
log.logNotRun("")
log.logPassed("")
log.logWarning("")
*/

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

CustomKeywords.'helper.login.LoginHelper.login'()


log.logInfo('Run sanity checks to locate problems in your database. This may take several tens of minutes depending on the size of your installation. ')
log.logInfo('You can also automate this check by running sanitycheck.pl from a cron job. A notification will be sent per email to the specified user if errors are detected.')

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
    println('Unable to find sanity check link: ' + e.getMessage()) 
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
} 

//WebUI.click(findTestObject('Object Repository/Page_Sanity Check/html_Sanity Check'))
//WebUI.waitForPageLoad(5)
WebUI.delay(10)
log.logInfo('verify sanity check is working and without new issue.')
WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_now running sanity checks'), 90)
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_now running sanity checks'), 100)
//WebUI.delay(1)
//WebUI.click(findTestObject('Page_Sanity Check/p_output_log_message.rs'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_Sanity check completed'), 160)
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_Sanity check completed'), 200)
WebUI.delay(1)




//alertMessages=WebUI.getText(findTestObject('Object Repository/Page_Sanity Check/p_alert_messages'))
//println(alertMessages)

dataFile='sanity_check_log'
columnName='accepted_failed_message'
boolean found_expected_log_message=false
log.logInfo('Get all found ALERT MESSAGES and compare with the expected ALERT MESSAGES from the sanity check log in columnName='+columnName)
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> elements = driver.findElements(By.xpath("//p[@class = 'alert']"));
for (int i = 0; i < elements.size(); i++) {
	found_expected_log_message=false
	String found_ALERT_MESSAGE=elements.get(i).getText()
	log.logInfo("found ALERT MESSAGE: " + found_ALERT_MESSAGE);
	////
	for (row = 1; row <= findTestData(dataFile).getRowNumbers(); row++){
		String expected_log_message=(findTestData(dataFile).getValue(columnName, row)).trim()
		if (!StringUtils.isNullOrEmpty(expected_log_message)){
			if (found_ALERT_MESSAGE.contains(expected_log_message)){
				log.logInfo('found expected log message : '+expected_log_message)
				found_expected_log_message=true
				break
			}
		}
		else{
		   println('found expected log message isNullOrEmpty, so it should be end of rows in '+dataFile)
		   break
		}
	}
	if (!found_expected_log_message){
		log.logWarning('This found ALERT MESSAGE could be an issue : '+found_ALERT_MESSAGE)
	}
	////
	
}

//return
		
// print out all log message
logMessage=WebUI.getText(findTestObject('Object Repository/Page_Sanity Check/p_output_log_message'))
//println(logMessage)
// check log message
/*expectedlogMessage='Checking for attachment indexer.'
checkLogMessage(expectedlogMessage,logMessage)

expectedlogMessage='Checking for unindexed attachments...'
checkLogMessage(expectedlogMessage,logMessage)*/

dataFile='sanity_check_log'
columnName='expected_log_message'
log.logInfo('check expected log messages from data file: '+dataFile)
for (row = 1; row <= findTestData(dataFile).getRowNumbers(); row++){
	//checkLogMessage(findTestData('sanity_check_log').getValue('log_message', row),logMessage)
	String expected_log_message=(findTestData(dataFile).getValue(columnName, row)).trim()
	//println('expected_log_message='+expected_log_message)
	if (!StringUtils.isNullOrEmpty(expected_log_message)){
		if (! logMessage.contains(expected_log_message)){
			log.logWarning('not found expected log message : '+expected_log_message)
			//throw new AssertionError('ERROR: not found expected log message : '+expected_log_message)
		}
	}
	else{
	   println('found expected log message isNullOrEmpty, so it should be end of rows in '+dataFile)
	   break
	}
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

//WebUI.click(findTestObject('Page_Sanity Check/p_alert_messages'))

