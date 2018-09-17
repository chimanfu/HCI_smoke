package kramp

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

public class Notifications {
	@Keyword
	def compare_dateTime_mailTriggered_mailRecevied(String triggered_notification_dateTime, String received_mail_dateTime){
		String format="EEEEEEEE, dd MMM yyyy h:mm:ss aaa"
		SimpleDateFormat sdf = new SimpleDateFormat(format)
		println 'triggered_notification_dateTime='+triggered_notification_dateTime
		println 'received_mail_dateTime='+received_mail_dateTime
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		Date D_triggered_notification_dateTime = sdf.parse(triggered_notification_dateTime)
		Date D_received_mail_dateTime = sdf.parse(received_mail_dateTime)

		if ( D_received_mail_dateTime.after(D_triggered_notification_dateTime)){
			System.out.println("Correct: received_mail_dateTime is after triggered_notification_dateTime")
			System.out.println(received_mail_dateTime+" is after "+triggered_notification_dateTime)
			return true
		}else if ( D_received_mail_dateTime.before(D_triggered_notification_dateTime)){
			System.out.println("Wrong: received_mail_dateTime is before triggered_notification_dateTime")
			System.out.println(received_mail_dateTime+" is before "+triggered_notification_dateTime)
			return false
		}else if ( D_received_mail_dateTime.equals(D_triggered_notification_dateTime)){
			System.out.println("Correct: received_mail_dateTime is equals triggered_notification_dateTime")
			System.out.println(received_mail_dateTime+" is equals "+triggered_notification_dateTime)
			return true
		}
	}
	@Keyword
	def search_notifications_mailcatcher(String mail_From_expected, String mail_To_expected, String mail_Subject_expected, String mail_Triggered_time){

		// approximate the mail_Triggered_time to the hour. e.g. approx_mail_Triggered_time=Saturday, 15 Sep 2018 1:
		String approx_mail_Triggered_time=mail_Triggered_time.substring(0,mail_Triggered_time.indexOf(':')+1)

		// construct the xpath with all the conditions
		String mails_expected="/html[@class='mailcatcher js ']/body/nav[@id='messages']/table/tbody/tr[td[1][contains(text(),'"+
				mail_From_expected+"')]][td[2][contains(text(),'"+
				mail_To_expected+"')]][td[3][contains(text(),'"+
				mail_Subject_expected+"')]][td[4][contains(text(),'"+
				approx_mail_Triggered_time+"')]]"

		WebUI.comment'search for all mails with these conditions in xpath:\n'+mails_expected

		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.xpath(mails_expected))
		int mails_matched_size=elements.size()
		String[] mail_ids = new String[mails_matched_size]
		WebUI.comment'Found '+mails_matched_size+' mail(s) that matched the initial search conditions with approx date/time (NOT actual exact date/time) of mail_Triggered_time '
		String mail_allFields_contents
		String mail_id
		String mail_From
		String mail_To
		String mail_Subject
		String mail_Received_actual
		String mailcatcher_url='https://dig-it-dev.nas.nasa.gov/mailcatcher/'
		int found_expected_mail_count=0
		if (mails_matched_size>0) {
			WebUI.comment("Found Mail MESSAGEs: ")
			for (int i = 0; i < mails_matched_size; i++) {
				// get the contents of each field for each marched mail
				mail_allFields_contents=elements.get(i).getText()
				mail_id=elements.get(i).getAttribute('data-message-id')
				mail_From=elements.get(i).findElement(By.xpath("./td[1]")).getText()
				mail_To=elements.get(i).findElement(By.xpath("./td[2]")).getText()
				mail_Subject=elements.get(i).findElement(By.xpath("./td[3]")).getText()
				mail_Received_actual=elements.get(i).findElement(By.xpath("./td[4]")).getText()
				if (mail_From.contains(mail_From_expected) && mail_To.contains(mail_To_expected) && mail_Subject.contains(mail_Subject_expected)){
					// print all the contents of the marched mails
					println 'mail_allFields_contents='+mail_allFields_contents
					println 'mail_id='+mail_id
					println 'mail_From='+mail_From
					println 'mail_To='+mail_To
					println 'mail_Subject='+mail_Subject
					println 'mail_Received_actual='+mail_Received_actual
					if (compare_dateTime_mailTriggered_mailRecevied(mail_Triggered_time,mail_Received_actual)){
						// get the mail id into the list only if it also passed the compare_dateTime function
						mail_ids[found_expected_mail_count]=mail_id
						println 'PASS: found expected mail with exact date/time matched. The mail_id='+mail_id
						++found_expected_mail_count
					}

				}
			}
			if (found_expected_mail_count>0){
				println 'Actual found_expected_mail_count='+found_expected_mail_count
			}
		}
		// verify actual message contents for all the mail ids stored in the list mail_ids that matched all conditions
		// navigate to the message urls
		for (int i = 0; i < found_expected_mail_count; i++) {
			mail_id=mail_ids[i]
			println('matched mail id: '+mail_id)
			WebUI.navigateToUrl(mailcatcher_url+'messages/'+mail_id+'.html')
			WebUI.navigateToUrl(mailcatcher_url+'messages/'+mail_id+'.plain')
			WebUI.navigateToUrl(mailcatcher_url+'messages/'+mail_id+'.source')
			//WebUI.navigateToUrl(mailcatcher_url)
			WebUI.waitForPageLoad(60)

		}
		return found_expected_mail_count

	}


}
