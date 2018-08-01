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

/*WebUI.openBrowser('')

WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

WebUI.click(findTestObject('Page_Login/input_login_btn'))

WebUI.click(findTestObject('Page_Access Launchpad/input_SCLOGIN'))*/
//CustomKeywords.'helper.login.LoginHelper.login'()

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
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		println('going to add a short description in title field, then create a new record with ttile '+search_term)
		WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)
		
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

