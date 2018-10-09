if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable
/*

run sanity check from Admin->'Sanity Check' to capture any unexpected errors from the site

Steps:

click 'Admin' link
select 'Sanity Check' link
check acceptable errors in red (alert)
	only check after seeing....OK, now running sanity checks.
	compare it with the list of acceptable errors from Data Files->sanity_check_log
	will fail test if see unexpected alert messages
check important expected log messages such as...
	OK, now running sanity checks.
	Sanity check completed.

*
*/
KeywordLogger log = new KeywordLogger()
if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')) {
	KeywordUtil.markWarning("WSTFwebPAPER as it is taking very long time to run sanity check. It will get stuck in 'Checking for unsent mail'")
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()


String logMessage=''
Screen s = new Screen()
String siteURL
log.logInfo('Run sanity checks to locate problems in your database. This may take several tens of minutes depending on the size of your installation. ')
log.logInfo('You can also automate this check by running sanitycheck.pl from a cron job. A notification will be sent per email to the specified user if errors are detected.')

WebUI.waitForPageLoad(180)
if (GlobalVariable.G_MAKE_MAS_url.contains('doctree')) {
	siteURL=GlobalVariable.G_MAKE_MAS_url
	if (!siteURL.endsWith('/')) siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'admin.cgi')
}else{
	WebUI.waitForElementClickable(findTestObject('Page_Main Page/a_Admin'), 60)
	WebUI.click(findTestObject('Page_Main Page/a_Admin'))
	
	if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
		try {
			WebUI.delay(1)
			WebUI.switchToWindowIndex(1)
		} catch (Exception e) {
			e.printStackTrace()
		}	
	}
}
try {
	// it may crash selenium by clciking on the Sanity Check link or it may wait for the page load forever.
	// will workaround it by clicking on the anityCheck_link.png with opencv image recognation feature
	
	WebUI.delay(2)
	if (WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'), 30,FailureHandling.OPTIONAL)){
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'), 5)
		WebUI.delay(2)
	    WebUI.click(findTestObject('Object Repository/Page_Administer your installation/a_Sanity Check'))
	}else{
	    s.wait(GlobalVariable.G_image_path + 'sanityCheck_link.png', 20)
	    s.click(GlobalVariable.G_image_path + 'sanityCheck_link.png')
	    WebUI.delay(1)
	    s.click(GlobalVariable.G_image_path + 'sanityCheck_link.png')
	    WebUI.delay(1)
	}
}
catch (Exception e) {
    WebUI.comment('Unable to find sanity check link: ' + e.getMessage()) 
	//throw new AssertionError('ERROR: Unable to verify alert present: ', e)
} 
int waitTime=200
if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')) {
	waitTime=60
}

WebUI.delay(3)
log.logInfo('verify sanity check is working and without new issue.')
if (WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_now running sanity checks'), waitTime,FailureHandling.OPTIONAL)){
	WebUI.scrollToElement(findTestObject('Page_Sanity Check/p_now running sanity checks'), 10)
}else{
	WebUI.comment 'Not found: now running sanity checks'
	if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')) {
		WebUI.comment 'Not found: now running sanity checks, OK for WSTFwebPAPER as it is taking very long time to run sanity check'
	}
}
//WebUI.delay(1)
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sanity Check/h1_A system error has occurred'), 12,FailureHandling.OPTIONAL)){
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Sanity Check/h1_A system error has occurred'), 5)
	log.logError('found A system error has occurred')
	throw new AssertionError('ERROR: found A system error has occurred ')	
}

if (WebUI.waitForElementVisible(findTestObject('Page_Sanity Check/p_Sanity check completed'), waitTime,FailureHandling.OPTIONAL)){
	WebUI.scrollToElement(findTestObject('Page_Sanity Check/p_Sanity check completed'), waitTime,FailureHandling.STOP_ON_FAILURE)
}else{
	WebUI.comment 'Not found Sanity check completed'
	if (GlobalVariable.G_MAKE_MAS_url.contains('WSTFwebPAPER')) {
		WebUI.comment 'Not found Sanity check completed, OK for WSTFwebPAPER as it is taking very long time to run sanity check'
	}
}
//WebUI.waitForElementClickable(findTestObject('Page_Sanity Check/p_Sanity check completed'), 200)
//WebUI.delay(1)

//alertMessages=WebUI.getText(findTestObject('Object Repository/Page_Sanity Check/p_alert_messages'))
//WebUI.comment(alertMessages)
//alerts_Search_Xpath="//p[@class = 'alert' and not(contains(., 'attachment'))]"

'acceptable alert errors below, construct alerts_Search_Xpath to ignore the following alert messages'
acceptedAlert1="attachment"
acceptedAlert2="non-open status"
acceptedAlert3="Invalid flag"
acceptedAlert4="that have changes but no mail sent for at least"
acceptedAlert5="Dfile.encoding=UTF-8 -jar /usr/share/java/"
acceptedAlert6="/usr/local/bin/tesseract --version failed"
acceptedAlert7="Bad profile email address"
acceptedAlert8="Bad value"
acceptedAlert9="Builtin field cc is not set"
acceptedAlert10="contains an html comment"
acceptedAlert11="(Bugzilla_Wanted) related to non exsistant releventField"
acceptedAlert12="Records found marked resolved duplicate and not on duplicates table"

String alerts_Search_Xpath="/html/body[@id='bugzilla_body_tag']/div[@id='bugzilla-body']//p[@class = 'alert' and not(contains(., '"+
acceptedAlert1+"')) and not(contains(., '"+
acceptedAlert2+"')) and not(contains(., '"+
acceptedAlert3+"')) and not(contains(., '"+
acceptedAlert4+"')) and not(contains(., '"+
acceptedAlert5+"')) and not(contains(., '"+
acceptedAlert6+"')) and not(contains(., '"+
acceptedAlert7+"')) and not(contains(., '"+
acceptedAlert8+"')) and not(contains(., '"+
acceptedAlert9+"')) and not(contains(., '"+
acceptedAlert10+"')) and not(contains(., '"+
acceptedAlert11+"')) and not(contains(., '"+
acceptedAlert12+"')) ]"
WebUI.comment('alerts_Search_Xpath='+alerts_Search_Xpath)
dataFile='sanity_check_log'
columnName='accepted_failed_message'
boolean found_expected_log_message=false
boolean found_unexpected_log_message=false
log.logInfo('Get all found ALERT MESSAGES and compare with the expected ALERT MESSAGES from the sanity check log in columnName='+columnName)
WebDriver driver = DriverFactory.getWebDriver()
//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//String found_ALERT_MESSAGE
List<WebElement> elements = driver.findElements(By.xpath(alerts_Search_Xpath));
int alert_size=elements.size()
if (alert_size>0) {
	found_unexpected_log_message=true
	log.logError("Found unexpected ALERT MESSAGE: ")
	//KeywordUtil.markFailed("Found unexpected ALERT MESSAGE: ")
	for (int i = 0; i < alert_size; i++) {
		log.logError(elements.get(i).getText());
		//KeywordUtil.markFailed(elements.get(i).getText())
	}
}
if (found_unexpected_log_message){
	Actions actions = new Actions(driver);
	actions.moveToElement(elements.get(alert_size-1));
	actions.perform();
	throw new AssertionError('ERROR: found more than one unexpected ALERT MESSAGE, such as... '+elements.get(alert_size-1).getText() );
	//KeywordUtil.markFailedAndStop('ERROR: found more than one unexpected ALERT MESSAGE. ' )
}else{
	log.logPassed('PASS: Not found unexpected ALERT MESSAGE. ' );
}
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	try {
		WebUI.switchToWindowIndex(1)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	} catch (Exception e) {
		e.printStackTrace()
	}
}

return
///////////////////////////////////////////////////////////////////////////////////////////////////////
//for (int i = 0; i < elements.size(); i++) {
	//found_unexpected_log_message=true
	//found_ALERT_MESSAGE=elements.get(i).getText()
	
	/*if (found_ALERT_MESSAGE.contains('attachment')){
		continue
	}
	if (found_ALERT_MESSAGE.contains('Records that have changes but no mail sent for at least half an hour')){
		continue
	}*/
	//log.logError(elements.get(i).getText());
	// scroll to the unexpected ALERT MESSAGE
	
	/*Actions actions = new Actions(driver);
	actions.moveToElement(elements.get(i));
	actions.perform();
	throw new AssertionError('ERROR: found unexpected ALERT MESSAGE: ' + found_ALERT_MESSAGE);*/
	
	////
	/*for (row = 1; row <= findTestData(dataFile).getRowNumbers(); row++){
		String expected_log_message=(findTestData(dataFile).getValue(columnName, row)).trim()
		if (!StringUtils.isNullOrEmpty(expected_log_message)){
			if (found_ALERT_MESSAGE.contains(expected_log_message)){
				log.logInfo('found expected log message : '+expected_log_message)
				found_expected_log_message=true
				break
			}
		}
		else{
		   WebUI.comment('found expected log message isNullOrEmpty, so it should be end of rows in '+dataFile)
		   break
		}
	}
	////
	if (!found_expected_log_message){
		log.logWarning('This found ALERT MESSAGE could be an issue : '+found_ALERT_MESSAGE)
	}*/
//}
///////////////////////////////////////////////////////////////////////////////////////////////////////		
// print out all log message
logMessage=WebUI.getText(findTestObject('Object Repository/Page_Sanity Check/p_output_log_message'))
//WebUI.comment(logMessage)
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
	//WebUI.comment('expected_log_message='+expected_log_message)
	if (!StringUtils.isNullOrEmpty(expected_log_message)){
		if (! logMessage.contains(expected_log_message)){
			log.logWarning('not found expected log message : '+expected_log_message)
			//throw new AssertionError('ERROR: not found expected log message : '+expected_log_message)
		}
	}
	else{
	   WebUI.comment('found expected log message isNullOrEmpty, so it should be end of rows in '+dataFile)
	   break
	}
}


WebUI.comment('all expected log messages found in actual sanity check log output')

/*
if (logMessage.contains(checklogMessage)){
	WebUI.comment('found log message : '+checklogMessage)
}else{
	WebUI.comment('not found log message : '+checklogMessage)
	throw new AssertionError('ERROR: not found log message : '+checklogMessage)
}
*/
//WebUI.click(findTestObject('Page_Sanity Check/p_Sanity check completed'))
//WebUI.click(findTestObject('Page_Sanity Check/p_alert_messages'))

def checkLogMessage(String checklogMessage,String logMessage){
	//checklogMessage='Checking for attachment indexer.'
	if (logMessage.contains(checklogMessage)){
		WebUI.comment('found log message : '+checklogMessage)
	}else{
		WebUI.comment('not found log message : '+checklogMessage)
		throw new AssertionError('ERROR: not found log message : '+checklogMessage)
	}
}