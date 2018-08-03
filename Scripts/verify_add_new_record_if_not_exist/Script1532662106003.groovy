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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

//CustomKeywords.'helper.login.LoginHelper.login'()

Screen s = new Screen()
///////////////
search_term='test_automation_record'
println('will create a new record ONLY if not already exists')
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
WebUI.click(findTestObject('Page_Main Page/bt_Search'))
String url=GlobalVariable.G_MAKE_MAS_url
if (url.contains('MAKE-MAS')){
	println('The URL is a test instance')
}else{
	println('The URL is NOT a test instance, so should not create new record on production site')
	return null
}
if (WebUI.getText(findTestObject('Page_Record List/div_Displaying_how_many_found')).contains('0 of 0')){
	println('0 of 0 record found with search term='+search_term)
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record List/div_No records found.'),FailureHandling.OPTIONAL)){
		println('No record found with search term='+search_term)
		println('will add a new record with tile ='+search_term)
		
		WebUI.click(findTestObject('Page_Main Page/a_New'))
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_hazard')){
			println 'this is cp_hazard'		
			WebUI.click(findTestObject('Page_Select Record Type/a_Hazard'))
			WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_EGSHazards'))
		}else if ((GlobalVariable.G_MAKE_MAS_url).contains('cp_oms')){
			println 'this is cp_oms'
		
		}else if ((GlobalVariable.G_MAKE_MAS_url).contains('arc_praca')){
			println 'this is arc_praca'
			WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_20gCentrifuge'))		
			WebUI.selectOptionByValue(findTestObject('Page_Enter Record 20g Centrifuge/select_options'),
				'AF - Aviation Systems Division', true)
		}else if ((GlobalVariable.G_MAKE_MAS_url).contains('iss_hazard')){
			println 'this is iss_hazard'
			
			WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_New blank record'))		
			WebUI.click(findTestObject('Object Repository/Page_Enter Record/a_AdAstraRocketCompany'))
			/*
			WebUI.waitForElementVisible(findTestObject('Page_Enter Record Ad Astra Rocket C/select_from_list'),5)
			WebUI.selectOptionByLabel(findTestObject('Page_Enter Record Ad Astra Rocket C/select_from_list'),
				'.*Ha.*',true)
			
			WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_Create New Record'),5)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.ArrowDown+Keys.Enter)
			
			
			
			WebUI.waitForElementVisible(findTestObject('Page_Enter Record Ad Astra Rocket C/select_from_list'),5)
			WebUI.selectOptionByIndex(findTestObject('Page_Enter Record Ad Astra Rocket C/select_from_list'),
				2)*/
			//WebUI.delay(1)
		}
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		println('going to add a short description in title field, then create a new record with ttile '+search_term)
		
		if ((GlobalVariable.G_MAKE_MAS_url).contains('iss_hazard')){
			WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)
			println 'this is iss_hazard'
			WebUI.delay(1)
			s.type(Key.TAB)
			s.type(Key.TAB)
			WebUI.delay(1)
			s.type(Key.DOWN)
			WebUI.delay(2)
			s.type(Key.DOWN)
			WebUI.delay(1)
			s.type(Key.DOWN)
			WebUI.delay(2)
			s.type(Key.SPACE)
			WebUI.delay(3)
			//WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term+Keys.TAB+Keys.TAB+Keys.DOWN+Keys.DOWN+Keys.DOWN+Keys.ENTER)
			/*
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.TAB))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.TAB))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ARROW_DOWN))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ARROW_DOWN))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ENTER))
			*/
			
		
			
		}else{
			WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)
		}
		WebUI.click(findTestObject('Page_Enter Record View/input_Create New Record'))
		
		WebUI.waitForElementVisible(findTestObject('Page_Record View - test_automation_record/div_Record Title'), 
		    20)
		
		WebUI.waitForElementVisible(findTestObject('Page_Record View - test_automation_record/div_test_automation_record'), 
		    5)
		
	}else{
		println('found records with search term='+search_term)
	}
}else{
	println('found records with search term='+search_term)
	println('do not need to create new record')
}



//WebUI.closeBrowser()

