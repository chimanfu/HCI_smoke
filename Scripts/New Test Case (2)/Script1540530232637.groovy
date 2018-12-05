import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
//url='https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev/show_bug.cgi?id=45488'
//String record_id=url.substring(url.lastIndexOf('id=')+3)
record_id='45515'
attachment_name='Full Text Search - Excel.xlsx'
CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Record_Created/div_Attachments_Label'),10,FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/Page_Record_Created/div_Attachments_Label'),10,FailureHandling.OPTIONAL)
					
//def attachment_link1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Page_Record_Created/a_attachment_link'), 'href', 'contains', record_id, true)
def attachment_link = WebUI.modifyObjectProperty(findTestObject('Object Repository/Page_Record_Created/a_attachment_link'), 'text', 'equals', attachment_name, true)

if (WebUI.waitForElementPresent(attachment_link, 10,FailureHandling.OPTIONAL)){
	println 'PASS: found attachment_link'
	WebUI.click(attachment_link)
	KeywordUtil.markPassed ('\nPASS: search_attachment found attachment link in '+record_id+' with the search term as => ')
	
}else{
	println 'ERROR: Not found attachment_link'
	//write_failed_result(info+'\nERROR: search_attachment NOT found attachment link in '+record_id+' with the search term as => '+search_term+'\n'+e.printStackTrace())
	//(new helper.browserhelper.CustomBrowser()).takingScreenshot(GlobalVariable.recordName1+'_'+user_name+'_'+product+'_search_attachment')

}