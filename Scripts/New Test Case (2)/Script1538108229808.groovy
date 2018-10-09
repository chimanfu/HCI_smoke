import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl('https://mas.nasa.gov/ARC-PRACATraining/enter_bug.cgi?product=20g%20Centrifuge')

//// newly added
	

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Search updated/a_joe_search'),6)
WebUI.click(findTestObject('Object Repository/Page_Search updated/a_joe_search'))


if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/span_search_records_found'),10,FailureHandling.OPTIONAL)){
	WebUI.comment 'found search record as '+WebUI.getText(findTestObject('Object Repository/Page_Record List/span_search_records_found'))
}else if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/div_No records found.'),1,FailureHandling.OPTIONAL)){
	WebUI.comment 'No records found for search term='+search_term
	KeywordUtil.markFailedAndStop('No records found for search term='+search_term)
}
//////////////////////
// verify joe_search is working
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),10)

// verify edit search is working
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'))
WebUI.click(findTestObject('Object Repository/Page_Search for records/input_Search'))
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'))

// verify cancel save search is working
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/button_Cancel'),10)
WebUI.click(findTestObject('Object Repository/Page_Record List joe_search/button_Cancel'))

//////////////////////
WebUI.delay(1)
	