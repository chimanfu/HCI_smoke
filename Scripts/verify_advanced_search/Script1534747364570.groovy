if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// verify to be able to use advanced search to get a list of records that have snapshots taken already
//
// do a advanced search on 
//		select Search by change
//		select option 'xml snapshot' if exists, otherwise exit the test
//			add before date: '2018-08-20'
//			click search button
// verify the searchTitle_XML Snapshot in the search return list

if (GlobalVariable.G_MAKE_MAS_url.contains('etasksheet')) {
	println 'do not need to run this test'
	return
}
WebUI.comment 'randomly to run this test or not (0 or 1), should already covered similiar case in advancedSearch related testcase verify_generate_diff_report_on_advancedSearch'
if ((int) (Math.random()+0.5)){
	WebUI.comment('perform test this time')
}
else{
	WebUI.comment 'will skip running it this time to save time'
	return
}
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'),10)
WebUI.click(findTestObject('Object Repository/Page_OCAD Main Page/a_Advanced Search'))

WebUI.waitForElementClickable(findTestObject('Page_Search for records/div_Search by change'),6)
WebUI.click(findTestObject('Page_Search for records/div_Search by change'))

if (WebUI.waitForElementVisible(findTestObject('Page_Search for records/input_select_option_xmlversion'),5)){
	WebUI.comment("found option 'xml snapshot' from the Search by change field")
	
	WebUI.click(findTestObject('Page_Search for records/input_select_option_xmlversion'))

	WebUI.setText(findTestObject('Page_Search for records/input_chfieldto_display'), '2018-08-20')

	WebUI.click(findTestObject('Page_Search for records/input_Search'))

	// verify the searchTitle_XML Snapshot in the search return list
	WebUI.waitForElementVisible(findTestObject('Page_Record List/strong_searchTitle_XML Snapshot'),6)

} else{
	WebUI.comment("not found option 'xml snapshot' from the Search by change field")
}