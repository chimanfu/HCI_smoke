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


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
 
import javax.imageio.ImageIO;
 
def CaptureScreenshot (){
 
	try {
		// This code will capture screenshot of current screen
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				
		// This will store screenshot on Specific location
		ImageIO.write(image, "png", new File("/Users/jcfu/CurrentScreenshot.png"));
	 	
	} catch (Exception e) {
		e.printStackTrace()
	}

 
}

//CaptureScreenshot()
return

CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.click(findTestObject('Page_Document Tree/img_System Logo'))

WebUI.click(findTestObject('Object Repository/Page_Document Tree/a_TREE'))

WebUI.click(findTestObject('Object Repository/Page_Document Tree/div_UPDATE TREE'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '5', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Document Tree/select_Show All'), '2', true)

WebUI.click(findTestObject('Object Repository/Page_Select Program/img'))

WebUI.click(findTestObject('Object Repository/Page_Select Program/a_NEW RECORD'))

WebUI.click(findTestObject('Page_Document Tree/img_System Logo'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/div_SEARCH'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Document Tree/a_Download to PDF'))



