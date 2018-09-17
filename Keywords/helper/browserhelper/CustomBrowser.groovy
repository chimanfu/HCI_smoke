package helper.browserhelper

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import org.sikuli.script.KeyModifier as KeyModifier
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class CustomBrowser {

	@Keyword
	public void openBrowser(){
		WebUI.openBrowser("")
		WebUI.waitForPageLoad(GlobalVariable.G_timeout)
		WebUI.maximizeWindow()
		WebUI.switchToDefaultContent()
		try{
			WebUI.switchToWindowIndex(0)
			WebUI.closeWindowIndex(1)
			//WebUI.delay(1)
			WebUI.switchToWindowIndex(0)
			//WebUI.delay(1)
		}catch (Exception e) {
			KeywordUtil.markWarning(e.message)
			WebUI.switchToWindowIndex(0)
		}
	}

	@Keyword
	public void openBrowserWithUrl(String url){
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.G_timeout)
		WebUI.maximizeWindow()
	}

	@Keyword
	public void closeBrowser(){
		/**
		 * 1. Check for the frame
		 * 2. Check for the parent browser window
		 * 3. Close the browser
		 * 
		 * */
		WebUI.switchToDefaultContent()
		WebUI.switchToWindowIndex(0)
		WebUI.closeBrowser()
	}
	/*
	 @Keyword
	 public void takingScreenshot1(){
	 try {
	 Date data = new Date(System.currentTimeMillis())
	 SimpleDateFormat formatarDate = new SimpleDateFormat('yyyyMMddHHmmss')
	 WebUI.takeScreenshot(('C:\\screenshot\\screenshot_' + formatarDate.format(data)) + '.png')
	 }
	 catch (Exception e) {
	 e.printStackTrace()
	 }
	 }*/

	@Keyword
	public void takingScreenshot(){
		try {
			//import com.kms.katalon.core.configuration.RunConfiguration

			String getReportFolder=RunConfiguration.getReportFolder()

			println('getReportFolder='+getReportFolder)
			Date today = new Date()
			String todaysDate = today.format('MM_dd_yy')
			String nowTime = today.format('hh_mm_ss')
			String screenshotPath=getReportFolder+"/screenshot_"+ todaysDate +"-" + nowTime +".png"

			try{
				WebUI.takeScreenshot(screenshotPath)
			}
			catch (Exception e) {
				WebUI.comment('use Robot to capture screenshot of current screen')
				KeywordUtil.markWarning(e.message)
				// This code will capture screenshot of current screen
				BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()))

				// This will store screenshot on Specific location
				ImageIO.write(image, "png", new File(screenshotPath))
			}
			WebUI.comment('screenshot in '+screenshotPath)
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}
	@Keyword
	public void takingScreenshotStatus(String testcaseName, String testStatus){
		try {
			//import com.kms.katalon.core.configuration.RunConfiguration

			String getReportFolder=RunConfiguration.getReportFolder()
			//String testcaseName=testCaseContext.getTestCaseId()
			println('getReportFolder='+getReportFolder)
			//Date today = new Date()
			//String todaysDate = today.format('MM_dd_yy');
			//String nowTime = today.format('hh_mm_ss');
			//String screenshotPath=getReportFolder+"/"+testStatus+"-"+testcaseName+"-"+ todaysDate +"-" + nowTime +".PNG"
			String screenshotPath=getReportFolder+"/"+testStatus+"-"+testcaseName+".png"
			try{
				WebUI.takeScreenshot(screenshotPath)
			}
			catch (Exception e) {
				WebUI.comment('use Robot to capture screenshot of current screen')
				KeywordUtil.markWarning(e.message)
				// capture screenshot of current screen
				BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()))

				// store screenshot on Specific location
				ImageIO.write(image, "png", new File(screenshotPath))
			}
			WebUI.comment('screenshot in '+screenshotPath)
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}


	@Keyword
	public void not_save_exit() {
		println('takingScreenshot and exit the current state and reload page after popup')
		Screen s = new Screen()
		takingScreenshot()
		GlobalVariable.userPin2 = 'ScreenshotTaken'
		// take care the popup and un-save it
		s.type('w', KeyModifier.CMD)
		WebUI.delay(1)
		s.type('\n')

	}

}
