import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable



CustomKeywords.'helper.login.LoginHelper.login'()

boolean search_found_expected=true
//addGlobalVariable('record_title',"IP-Test-Khrunichev_12_17_18-05_24_18")
search_term='"'+"IP-Test-Khrunichev_12_17_18-05_24_18"+'"'
//search_term='"'+GlobalVariable.record_title+'"'
String info=GlobalVariable.testLog_info+'\nSearch for record with title "'+search_term+'"\n'

WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),15)
WebUI.waitForElementClickable(findTestObject('Page_Main Page/input_quicksearch'),15)
//if (WebUI.waitForElementVisible(findTestObject('Page_Main Page/select_search_option'),2))
//	WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
WebUI.waitForPageLoad(60)
WebUI.waitForElementClickable(findTestObject('Page_Main Page/bt_Search'),5)
WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
WebUI.click(findTestObject('Page_Main Page/bt_Search'))
try{
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/a_EditSearch'),20)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List joe_search/label_SaveSearch'),20)
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/li_Search_Content'),20)){
		KeywordUtil.logInfo("found li_Search_Content")
	}
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record_Created/div_Displaying_result'),30)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/a_ID_column'),10)
	if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_descending order'),1)){
		println 'already in descending order'
	}else if (WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_ascending order'),1)){
		WebUI.click(findTestObject('Object Repository/Page_Record List/a_ID_ascending order'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Page_Record List/a_ID_descending order'),10)
	}

	def record_link = WebUI.modifyObjectProperty(findTestObject('Page_Record List/a_record_id_link'), 'text', 'equals', search_term, true)
	KeywordUtil.logInfo ('start looking for record_link')
	
	if (WebUI.waitForElementPresent(record_link, 10,FailureHandling.OPTIONAL)){
			KeywordUtil.markPassed (info+'\nPASS: found record link with search term as => '+search_term)
	}else{
			write_failed_result(info+'\nERROR: NOT found record link with the search term as => '+search_term+'\n')
	}	
	KeywordUtil.logInfo ('done looking for record_link')
} catch (Exception e) {
	write_failed_result(info+'\nERROR: search_record_title Failed to find record:'+record_id+' with the search term as => '+search_term+'\n'+e.printStackTrace())

}
return


