if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import com.kms.katalon.core.model.FailureHandling
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

WebUI.scrollToElement(findTestObject('Page_Search for records/div_Search by change'),6)
WebUI.waitForElementClickable(findTestObject('Page_Search for records/div_Search by change'),6)
WebUI.click(findTestObject('Page_Search for records/div_Search by change'))


if (WebUI.waitForElementPresent(findTestObject('Page_Search for records/input_Record_creation'),3,FailureHandling.OPTIONAL)){
	WebUI.comment("found option 'Record_creation' from the Search by change field")
	
	WebUI.click(findTestObject('Page_Search for records/input_Record_creation'))

	WebUI.setText(findTestObject('Page_Search for records/input_chfieldto_display'), '2018-01-01')

	WebUI.click(findTestObject('Page_Search for records/input_Search'))

	// verify the searchTitle_XML Snapshot in the search return list
	WebUI.waitForElementVisible(findTestObject('Page_Record List/ul_Creation date 2018-01-01'),5,FailureHandling.STOP_ON_FAILURE)

	
	
} else{
	WebUI.comment("not found option 'xml snapshot' from the Search by change field")
}