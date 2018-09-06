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
import org.openqa.selenium.Keys as Keys
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen;


println('Only for iss_fmea: select Attachments & References tab -> create link')
if (!GlobalVariable.G_MAKE_MAS_url.contains('iss_fmea')) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}
int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


searchTerm='link'
CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 2769 -> Attachments & References Tab')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_fmea_dev/show_bug.cgi?id=2769#tv=Attachments%20%26%20References')
WebUI.maximizeWindow()
WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/label_Create link'), 25)
WebUI.scrollToElement(findTestObject('Page_Record_2769_FMEA/label_Create link'), 25)

println('get the create link field and get ready to search content')
WebUI.click(findTestObject('Page_Record_2769_FMEA/label_Create link'))
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_Search content...'))

println('enter the search term: '+searchTerm)
WebUI.setText(findTestObject('Page_Record_2769_FMEA/input'), searchTerm)
WebUI.delay(2)
println('get the first record')
WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input'), Keys.chord(Keys.ENTER))
WebUI.delay(5)
println('verify first record exist')
if (!WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/div_record_1'),12))
	WebUI.sendKeys(findTestObject('Page_Record_2769_FMEA/input'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

println('try out the trash link icon on/off')
WebUI.waitForElementClickable(findTestObject('Page_Record_2769_FMEA/div_trash'),12)
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_trash'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Record_2769_FMEA/div_trash'))

CustomKeywords.'helper.browserhelper.CustomBrowser.not_save_exit'()


/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}