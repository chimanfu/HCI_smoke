package helper.browserhelper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.testcase.TestCase
import internal.GlobalVariable
import com.kms.katalon.core.context.TestCaseContext as testCaseContext
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

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
			String todaysDate = today.format('MM_dd_yy');
			String nowTime = today.format('hh_mm_ss');
			String screenshotPath=getReportFolder+"/screenshot_"+ todaysDate +"-" + nowTime +".PNG"
			//WebUI.takeScreenshot(screenshotPath);
			// This code will capture screenshot of current screen
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					
			// This will store screenshot on Specific location
			ImageIO.write(image, "png", new File(screenshotPath));
			println('screen shot in '+screenshotPath)
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
			String screenshotPath=getReportFolder+"/"+testStatus+"-"+testcaseName
			//WebUI.takeScreenshot(screenshotPath);
			// This code will capture screenshot of current screen
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					
			// This will store screenshot on Specific location
			ImageIO.write(image, "png", new File(screenshotPath));
			println('screen shot in '+screenshotPath)
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}
	
	/*
	 @Keyword
	 public void testCaseStatus() {
	 String tc_id=TestCaseContext
	 println 'testcase ID = '+TestCase.
	 println 'testcase name = '+TestCase.getName()
	 println 'testcase variables = '+TestCase.getVariables()
	 }
	 */
}
