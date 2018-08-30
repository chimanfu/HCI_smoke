if (GlobalVariable.userPin2.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang3.StringUtils
import com.mysql.jdbc.StringUtils as myStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.KeyModifier as KeyModifier
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	verify linking configuration is functioning by looking into one record and creating a link record in the Linked Records setting 
//  from one of the Tabs
//
// 
// 'directly goto the record id defined from the site profile'
// 'dynamically get all Tabs from the Record Page'
// '	click on each tab to look for Linked Records setting'
// '	create link by entering search content: system'
// '	select one record from the search list and link it'
// '	check the record is linked successfully'
// 'exit and reload the page without saving the change from the record'
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*'only run on sites that aleady have dagger_server defined, except gmip'
println('G_dagger_server_url='+GlobalVariable.G_dagger_server_url)
if (myStringUtils.isNullOrEmpty(GlobalVariable.G_dagger_server_url) && !GlobalVariable.G_MAKE_MAS_url.contains('gmip')){
	println('do not need to run this test')
	WebUI.comment 'Skip this testcase as no dagger server defined for this site'
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}*/

CustomKeywords.'helper.login.LoginHelper.login'()


println 'directly goto the record id from site profile'
String recordID=GlobalVariable.recordName1
String siteURL=GlobalVariable.G_MAKE_MAS_url
if (recordID.trim().equals("") || recordID.trim().equals(null)){
	recordID='test_automation_record'
}
if (StringUtils.isNumeric(recordID)){
	if (!siteURL.endsWith('/'))
	siteURL=siteURL+'/'
	WebUI.navigateToUrl(siteURL+'show_bug.cgi?id='+recordID)
}

else{
	// if recordID is not number
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
	WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), recordID)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))
	
}

WebUI.waitForPageLoad(30)
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Page_Record test_automation_record/a_PDF'),25)
WebDriver driver = DriverFactory.getWebDriver()

println('get all Tabs from the Record Page')
println 'click on each tab to look for Linked Records setting'
println 'create link by entering search content '
println 'select one record from the search list and link it'
println 'check the record is linked successfully'
List<WebElement> elements = driver.findElements(By.xpath("//div[@class='labelAndIcon']/div[@class='tablabel']"));
int size=elements.size()
println('size='+size)
for (int i = 0; i < size; i++) {
	KeywordUtil.logInfo("Record Tab Name: " + elements.get(i).getText());
	elements.get(i).click()
	if (WebUI.waitForElementVisible(findTestObject('Page_Record_contents/div_Linked records'),5)){
		WebUI.click(findTestObject('Page_Record_contents/label_Create link'))
		
		WebUI.click(findTestObject('Page_Record_contents/div_Search content...'))
		
		WebUI.setText(findTestObject('Page_Record_contents/input_create_link_search'), 'system')
		
		WebUI.sendKeys(findTestObject('Page_Record_contents/input_create_link_search'), Keys.chord(Keys.ENTER))
		
		WebUI.waitForElementVisible(findTestObject('Page_Record_contents/div_Record_selected'),20)
		
		WebUI.click(findTestObject('Page_Record_contents/div_Record_selected'))
		
		// check the record is linked
		WebUI.waitForElementVisible(findTestObject('Page_Record_contents/div_trash'),5)
		WebUI.click(findTestObject('Page_Record_contents/div_trash'))
		
		WebUI.click(findTestObject('Page_Record_contents/div_trash'))
		break
	}
		

}

CustomKeywords.'helper.browserhelper.CustomBrowser.takingScreenshot'()
GlobalVariable.userPin2='ScreenshotTaken'
// open the current window which will trigger the popup
Screen s = new Screen()
s.type("w", KeyModifier.CMD)
WebUI.delay(1)
s.type('\n')
return





