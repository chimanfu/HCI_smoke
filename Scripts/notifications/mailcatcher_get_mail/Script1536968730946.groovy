import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.kms.katalon.core.exception.StepErrorException as StepErrorException



//////////////////////////////////////////////////////////////
// do some change to trigger notification on record 7113 and set the triggered_notification_dateTime

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.delay(1)
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7113#tv=Basic%20Information')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Black 7113 test automation rec/a_Analyst_name'), 10)
// get the Analyst email address
Analyst_email= WebUI.getAttribute(findTestObject('Object Repository/Page_Black 7113 test automation rec/a_Analyst_name'), 'href')
Analyst_email=Analyst_email.substring(Analyst_email.indexOf(':')+1).trim()
println 'Analyst_email='+Analyst_email
// get the record name
record_name=WebUI.getText(findTestObject('Object Repository/Page_Black 7113 test automation rec/div_record_name'))
record_name=record_name.substring(0,record_name.indexOf('(edit)')).trim()
println 'record_name='+record_name
// get the record id
record_id='7113'
WebUI.delay(1)
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev/show_bug.cgi?id=7113#tv=Fields')
WebUI.delay(2)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/input_Free Text Field_cf_text'),10)
WebUI.clearText(findTestObject('Page_Record test_automation_record/input_Free Text Field_cf_text'))
// get the current date/time when record is being changed and notification is almost triggered
format="EEEEEEEE, dd MMM yyyy h:mm:ss aaa"
SimpleDateFormat sdf = new SimpleDateFormat(format);
Date date = new Date();
triggered_notification_dateTime= new SimpleDateFormat(format).format(date);
println 'triggered_notification_dateTime='+triggered_notification_dateTime
WebUI.setText(findTestObject('Page_Record test_automation_record/input_Free Text Field_cf_text'), triggered_notification_dateTime)
// should trigger the notification
CustomKeywords.'kramp.Internal_Linking.save_changes'()

//////////////////////////////////////////////////////////////
//all_mails_contents="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr"
//all_mails_From="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr/td[1]"
//all_mails_To="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr/td[2]"
//all_mails_Subject="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr/td[3]"
//all_mails_Received="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr/td[4]"
//mailcatcher_url='https://dig-it-dev.nas.nasa.gov/mailcatcher/'
//WebUI.refresh()
//WebUI.waitForPageLoad(60)
//////////////////////////////////////////////////////////////
// prepare the search conditions for the expected mail notifications

mail_From_expected='example-daemon@mas.nasa.gov'
mail_To_expected=Analyst_email
mail_Subject_expected='[Record '+record_id+'] '+record_name
mail_Triggered_time=triggered_notification_dateTime
/// testing
///mail_Triggered_time='Saturday, 15 Sep 2018 1:47:10 PM'
/// testing

//////////////////////////////////////////////////////////////
// goto mailcatcher UI and run search_notifications_mailcatcher()

CustomKeywords.'helper.login.LoginHelper.loginMailCatcher'()
// run the search_notifications_mailcatcher to find the expected mail from mailcatcher
int mails_matched_size=CustomKeywords.'kramp.Notifications.search_notifications_mailcatcher'(mail_From_expected,mail_To_expected,mail_Subject_expected,mail_Triggered_time)

if (mails_matched_size>0){
	WebUI.comment'PASS: Found mail notification that have matched all the conditions with mail count='+mails_matched_size
}else{
	WebUI.comment'FAIL: NOT Found mail notification that have matched all the conditions. Check the setting and record.'
	throw new StepErrorException('FAIL: NOT Found mail notification that have matched all the conditions. Check the setting and record.')
	
}

//////////////////////////////////////////////////////////////
return
////////////////////////////////////////////////////////////////
// get it from mailcatcher, should do the compare in search_notifications_mailcatcher()
received_mail_dateTime='Saturday, 15 Sep 2018 1:47:11 PM'
println 'received_mail_dateTime='+received_mail_dateTime

CustomKeywords.'kramp.Notifications.compare_dateTime_mailTriggered_mailRecevied'(triggered_notification_dateTime,received_mail_dateTime)

////////////////////////////////////////////////////////////////
// access selected mail from inbox view
WebUI.click(findTestObject('Page_MailCatcher/td_mail_From'))

WebUI.click(findTestObject('Page_MailCatcher/td_mail_To'))

WebUI.click(findTestObject('Page_MailCatcher/td_mail_Subject'))

WebUI.click(findTestObject('Page_MailCatcher/td_mail_Received'))



// view mail message body after opening the mail from inbox view

// message body header
WebUI.click(findTestObject('Page_MailCatcher/dd_msgBody_From'))

WebUI.click(findTestObject('Page_MailCatcher/dd_msgBody_Received'))

WebUI.click(findTestObject('Page_MailCatcher/dd_msgBody_To'))

WebUI.click(findTestObject('Page_MailCatcher/dd_msgBody_Subject'))

// message body content in HTML tab view
WebUI.click(findTestObject('Page_MailCatcher/a_msgBody_HTML_TAB'))

WebUI.click(findTestObject('Page_MailCatcher/img_msgBody_logo'))

WebUI.click(findTestObject('Page_MailCatcher/a_msgBody_person_madeChanges'))

WebUI.click(findTestObject('Page_MailCatcher/a_msgBody_record_link'))

WebUI.click(findTestObject('Page_MailCatcher/a_msgBody_change_history_for_details'))

WebUI.click(findTestObject('Page_MailCatcher/a_msgBody_clicking_here'))





