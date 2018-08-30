if (GlobalVariable.userPin2.equals('SKIP')) return
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
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern as Pattern

 WebUI.comment('verify the MAS site logo is correct (using OpenCV image recognition library)')
 WebUI.comment('use OpenCV to locate site log image and compare with the expected image')
 WebUI.comment('')
 WebUI.comment('Steps:')
 WebUI.comment('')
 WebUI.comment('look for expected site logo from the Home page')
 WebUI.comment('')
 

 
int retry_count = 0;
int maxTries = 3;
while(true) {
	try {
/////////////////////////////////////////////////////////////////////////////
		CustomKeywords.'helper.login.LoginHelper.login'()
		//WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
		//WebUI.delay(2)
		Screen s = new Screen();
		//GlobalVariable.G_image_path="/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/"
		//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')
		
		if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
			WebUI.comment('look for expected site logo from the Home page')
			//s.wait(GlobalVariable.G_image_path+'cp_hazard_logo.png',20)
			
			Pattern pImage = new Pattern(GlobalVariable.G_image_path + 'cp_hazard_logo.png').similar(0.65)
			//s.click(s.exists(pImage,10), 1)
			s.click(s.exists(pImage,10))
			
			WebUI.comment('found cp_hazard_logo')
		}else{
			WebUI.comment('TBD')
		}
/////////////////////////////////////////////////////////////////////////////
	break
	} catch (Exception e) {
		// handle exception
		e.printStackTrace()	
		if (++retry_count == maxTries) throw e;
		WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
		String cmd = "pkill -f Chrome"
		Runtime.getRuntime().exec(cmd)
		
	}
}

/* retry code here

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}

retry code here */
		