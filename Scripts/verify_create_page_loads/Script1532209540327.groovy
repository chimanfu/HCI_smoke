import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.python.antlr.PythonParser.raise_stmt_return
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import java.util.List
import com.kms.katalon.core.webui.driver.DriverFactory
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.List;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.osgi.framework.AdminPermission
import org.postgresql.translation.messages_bg
import org.python.antlr.PythonParser.return_stmt_return
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

/*
 * verify all links in create New record page are accessible and each add new record link is loading without any errors.
 * 
 * Steps:
 * 
 * click on New link from the Home page
 * On the Page of New Record, perform verifyAllLinksOnCurrentPageAccessible() to verify all links are not broken 
 * 		will report any links that are not accessible.
 * 		will fail the test if STOP_ON_FAILURE=true
 * dynamically get all the add new record links on the page (Page_Select Record Type)
 * 		get new record link name and url
 * 		navigate each link url to open new record page 
 * 		check for js error on each new record page when page is being loaded
 */
KeywordLogger log = new KeywordLogger()

/*if (!(GlobalVariable.addNewRecord)) {
	log.logInfo('The test will not run, as no need to add a new record for smoke test and GlobalVariable.addNewRecord is disabled')

	return null
} else {
	log.logInfo('will verify create page load')
}*/
CustomKeywords.'helper.login.LoginHelper.login'()

String found_new_record_link
String url

println('click New Record link')
if ((GlobalVariable.G_MAKE_MAS_url).contains('doctree')){
	WebUI.click(findTestObject('Page_Document Tree/a_NEW RECORD'))
	WebUI.click(findTestObject('Object Repository/Page_Select Program/a_All'))
}
else if((GlobalVariable.G_MAKE_MAS_url).contains('etasksheet')){
	//WebUI.click(findTestObject('Object Repository/Page_ARC JET/div_logo'))
	WebUI.navigateToUrl(GlobalVariable.G_MAKE_MAS_url)
	WebUI.click(findTestObject('Object Repository/Page_ARC JET/button_New Task Worksheet'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ARC JET/button_Save'),5)
	WebUI.verifyElementVisible(findTestObject('Object Repository/Page_ARC JET/button_Save'))
}
else{
	WebUI.click(findTestObject('Page_Main Page/a_New'))
}
//println('check Links Broken (http return code != 200) On Current Page of New Record Record')
//CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
println('perform verifyAllLinksOnCurrentPageAccessible and exclude links with src')
boolean STOP_ON_FAILURE=false
CustomKeywords.'hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible'(STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()
println('get all new record links from the New Record Page')
List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"));

//WebElement firstElement = elements.get(0);

int size=elements.size()
urls = new String[size]
for (int i = 0; i < size; i++) {
	println('get new record link name and url')
	found_new_record_link=elements.get(i).getText()
	url = elements.get(i).getAttribute("href");
	urls[i]=url
	log.logInfo("found_new_record_link: " + found_new_record_link);
	log.logInfo("with URL: " + url);

}
for (int i = 0; i < size; i++) {
	println('navigate to new record link: '+urls[i])
	WebUI.navigateToUrl(urls[i])
	//driver.navigate().to(url)
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	//WebUI.click(findTestObject('Page_Main Page/a_New'))

}
return
/////////////////////////////////////////////////////////////////////////////////////////////////
if ((GlobalVariable.G_MAKE_MAS_url).contains('react_cp_hazard')){
	println 'this is cp_hazard'
	WebUI.click(findTestObject('Page_Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Safety Data Package'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Hazard'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Action'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Cause Tree'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Cause'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_Watch'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
	
	WebUI.click(findTestObject('Object Repository/Page_Select Record Type/a_All'))
	CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()

}else if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_oms')){
	WebUI.click(findTestObject('Page_Main Page/a_New'))
	println 'this is cp_oms'

}else if ((GlobalVariable.G_MAKE_MAS_url).contains('arc_praca')){
	println 'this is arc_praca'
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_20gCentrifuge'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ADEPTSR1'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AdvancedRodentHabitat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AirborneSciencesUASProjects'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ArcJet'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_Astrobee'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ATD1'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AVA'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BioNutrients'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_BioSentinel'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CAP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CellScience'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CHOMPTT'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_COAST'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CodeQS(SystemSafetyandMissio'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CodeRM(AppliedManufacturing)'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_CSP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EcAMSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EDSN'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EEL'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_FruitFly'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_GEOCAMSPACE'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_HECC'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ISSPayloads'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LADEE'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_LADEEORT'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MEDLI'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_MEDLI2MISP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NLAS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_NODES'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OOREOS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_OrionDFI'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PathfinderTechnologyDemonstr'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PhoneSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_PowerCell'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_ResourceProspector'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SOFIAProject'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SPHERES'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_SporeSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TechEdSat'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_TPSADP'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record TPS ADP/a_New'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_UTPWindTunnel'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_VMS'))
	
	WebUI.click(findTestObject('Object Repository/Page_ARC PRACA Main Page/a_New'))
	WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_WetLab'))
	
}else if ((GlobalVariable.G_MAKE_MAS_url).contains('iss_hazard')){
	println 'this is iss_hazard'
	CustomKeywords.'hci_smoke_test.create_new_record.iss_hazard'()

}else{
	 found_new_record_link
	 url
	WebUI.click(findTestObject('Page_Main Page/a_New'))
	CustomKeywords.'hci_smoke_test.common.checkLinksBrokenOnCurrentPage'()
	//WebDriver driver = DriverFactory.getWebDriver()
	println('get all new record links from the New Record Page')
	elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"));
	size=elements.size()
	urls = new String[size]
	for (int i = 0; i < size; i++) {
		println('get new record link name and url')
		found_new_record_link=elements.get(i).getText()
		url = elements.get(i).getAttribute("href");
		urls[i]=url
		log.logInfo("found_new_record_link: " + found_new_record_link);
		log.logInfo("with URL: " + url);

	}
	for (int i = 0; i < size; i++) {
		println('navigate to new record link: '+urls[i])
		WebUI.navigateToUrl(urls[i])
		//driver.navigate().to(url)
		CustomKeywords.'helper.javascript.JavaScriptHelper.appendBrowserLogs'()
		//WebUI.click(findTestObject('Page_Main Page/a_New'))

	}

}