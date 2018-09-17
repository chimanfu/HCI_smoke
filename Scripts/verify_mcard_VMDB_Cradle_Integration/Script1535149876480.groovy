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

if (!(GlobalVariable.G_MAKE_MAS_url.contains('mcard'))) {
	WebUI.comment 'Skip this testcase as this is a specific testcase for a specific site'
	GlobalVariable.userPin2='SKIP'
	return
}
int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////

CustomKeywords.'helper.login.LoginHelper.login'()

println('directly goto record 256 -> Verification tab from search: Monitored Condition record type')
WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/mcard_dev/show_bug.cgi?id=256#tv=Verification')

println 'select Verification Tab'
WebUI.waitForElementClickable(findTestObject('Page_Record_256_mcard/div_Verification'),25)
WebUI.click(findTestObject('Page_Record_256_mcard/div_Verification'))

println 'wait for SLS Cradle Linkable Field'
WebUI.waitForElementClickable(findTestObject('Page_Record_256_mcard/span_SLS Cradle Linkable Field'),10)
WebUI.click(findTestObject('Page_Record_256_mcard/span_SLS Cradle Linkable Field'))

println 'enter dvo_number 100 from search field of Applicable DVO'
WebUI.click(findTestObject('Page_Record_256_mcard/label_Applicable DVO'))
WebUI.setText(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), '100')
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), Keys.chord(Keys.ENTER))

println 'verify SLS Cradle search results'
WebUI.waitForElementVisible(findTestObject('Page_Record_256_mcard/span_SLS Cradle search results'),10)
WebUI.click(findTestObject('Page_Record_256_mcard/span_SLS Cradle search results'))

'click on create link button'
WebUI.click(findTestObject('Page_Record_256_mcard/button_Create Link'))

'verify the record is linked and can be edited'
WebUI.click(findTestObject('Page_Record_256_mcard/button_Linked'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_Record_256_mcard/a_Edit'))
WebUI.delay(1)
WebUI.setText(findTestObject('Page_Record_256_mcard/input_cf_dvo_number'), '')

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

