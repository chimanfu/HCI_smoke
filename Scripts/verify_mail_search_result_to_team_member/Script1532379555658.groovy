if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/*
 * verify mail is being sent for any search result to any team member
 * 
 * Steps:
 * 
 * type search_term='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
 * search for records
 * click EmailSearchResults button
 * enter sendToAdrress='joseph.fu@nasa.gov'
 * click send button
 * verify sent message confirmation
 * check email in outlook with the following contents:
 * 
 * example:
 * [SSMA] Link to SSMA search results
 * 
 * Joseph Fu shared the saved search Link to SSMA search results with you:
 * View the search results here: 
 * https://mas.nasa.gov/ssma/buglist.cgi?luid=8CC75BD4-9D0D-11E8-AF64-C1A86CDEDDFA
 * 	
*/

int retry_count = 0;
int maxTries = 3;
while(true){
try {
/////////////////////////////////////////////////////////////////////////////


if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	WebUI.comment("Skip this testcase")
	GlobalVariable.userPin2='SKIP'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()
String sendToAdrress='joseph.fu@nasa.gov'
//String search_term='10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500'
String search_term='1,3,10,11,12,15,18,20,40,50,70,80,100,200,300'
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) {
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/a_SavedSearches'),25)
	WebUI.click(findTestObject('Page_Main Page/a_SavedSearches'))
	WebUI.click(findTestObject('Page_Main Page/a_My Records'))
}else{
	WebUI.waitForElementVisible(findTestObject('Page_Main Page/input_quicksearch'),25)
	//WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	if (WebUI.waitForElementVisible(findTestObject('Page_Main Page/select_search_option'),2))
		WebUI.selectOptionByValue(findTestObject('Page_Main Page/select_search_option'), '.ll', true)
	WebUI.waitForPageLoad(5)
	WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)
	WebUI.click(findTestObject('Page_Main Page/bt_Search'))	
	//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/a_test_automation_record'),10)
}
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record List/label_EmailSearchResults'),30)
WebUI.click(findTestObject('Object Repository/Page_Record List/label_EmailSearchResults'))

WebUI.setText(findTestObject('Object Repository/Page_Record List/input_em_to'), sendToAdrress)
WebUI.click(findTestObject('Object Repository/Page_Record List/button_Send'))

//WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Record List/div_Email sent to user address'),30)
emailSentMsg=WebUI.getText(findTestObject('Object Repository/Page_Record List/div_Email sent to user address'))
if (emailSentMsg.contains(sendToAdrress)){
	WebUI.comment('mail sent successfully, found sendToAdrress : '+sendToAdrress)
}else{
	WebUI.comment('mail not sent, as not found sendToAdrress : '+sendToAdrress)
	throw new AssertionError('ERROR: mail not sent, as not found sendToAdrress : '+sendToAdrress)
}

/////////////////////////////////////////////////////////////////////////////
break} catch (Exception e) {
	e.printStackTrace()
	if (++retry_count == maxTries) throw e;
	WebUI.comment('Retry:'+retry_count+' rerun failed case now...')
	String cmd = "pkill -f Chrome"
	Runtime.getRuntime().exec(cmd)
	
}
}