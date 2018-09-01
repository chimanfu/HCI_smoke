
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.util.List

import org.openqa.selenium.WebElement


def static "question.CustomDatabase.executeQuery"(
    	String connectionUrl	
     , 	String query	) {
    (new question.CustomDatabase()).executeQuery(
        	connectionUrl
         , 	query)
}

def static "kramp.Internal_Linking.waitTestObject"(
    	String testobject	) {
    (new kramp.Internal_Linking()).waitTestObject(
        	testobject)
}

def static "kramp.Internal_Linking.reuse_linked_parent_save_changes"(
    	String linked_parent	) {
    (new kramp.Internal_Linking()).reuse_linked_parent_save_changes(
        	linked_parent)
}

def static "kramp.Internal_Linking.select_TAB_Group_Linking_Child"() {
    (new kramp.Internal_Linking()).select_TAB_Group_Linking_Child()
}

def static "kramp.Internal_Linking.delete_group_save_changes"() {
    (new kramp.Internal_Linking()).delete_group_save_changes()
}

def static "kramp.Internal_Linking.refreshBrowser"() {
    (new kramp.Internal_Linking()).refreshBrowser()
}

def static "kramp.Internal_Linking.clickElement"(
    	TestObject to	) {
    (new kramp.Internal_Linking()).clickElement(
        	to)
}

def static "kramp.Internal_Linking.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new kramp.Internal_Linking()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "com.common.utils.SetDesiredCapability.chrome"(
    	List desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).chrome(
        	desiredCapabilities)
}

def static "com.common.utils.SetDesiredCapability.firefox"(
    	Object desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).firefox(
        	desiredCapabilities)
}

def static "com.common.utils.SetDesiredCapability.ie"(
    	Object desiredCapabilities	) {
    (new com.common.utils.SetDesiredCapability()).ie(
        	desiredCapabilities)
}

def static "helper.javascript.JavaScriptHelper.appendBrowserLogs"() {
    (new helper.javascript.JavaScriptHelper()).appendBrowserLogs()
}

def static "helper.javascript.JavaScriptHelper.executeScript"(
    	String script	) {
    (new helper.javascript.JavaScriptHelper()).executeScript(
        	script)
}

def static "helper.javascript.JavaScriptHelper.executeScriptOnTestObject"(
    	String string	
     , 	TestObject testObject	) {
    (new helper.javascript.JavaScriptHelper()).executeScriptOnTestObject(
        	string
         , 	testObject)
}

def static "helper.javascript.JavaScriptHelper.executeAndReturnValue"(
    	String script	
     , 	TestObject testObject	) {
    (new helper.javascript.JavaScriptHelper()).executeAndReturnValue(
        	script
         , 	testObject)
}

def static "question.CustomJsonParser.jsonExtractor"(
    	String response	) {
    (new question.CustomJsonParser()).jsonExtractor(
        	response)
}

def static "question.VerifyAllElements.scrollAndVerfiyElement"(
    	String tagName	) {
    (new question.VerifyAllElements()).scrollAndVerfiyElement(
        	tagName)
}

def static "question.UniqueScreenShot.takeScreenShot"(
    	String path	
     , 	String name	) {
    (new question.UniqueScreenShot()).takeScreenShot(
        	path
         , 	name)
}

def static "reusableComponents.VerifyDataInWebTable.verify_expText_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_expText_In_Colum_Table(
        	tableObject
         , 	expText
         , 	expTextColNum)
}

def static "reusableComponents.VerifyDataInWebTable.verify_Deleted_ExpText_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_Deleted_ExpText_In_Colum_Table(
        	tableObject
         , 	expText
         , 	expTextColNum)
}

def static "reusableComponents.VerifyDataInWebTable.verify_MultipleTexts_In_Colum_Table"(
    	TestObject tableObject	
     , 	String expText1	
     , 	int expText1ColNum	
     , 	String expText2	
     , 	int expText2ColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).verify_MultipleTexts_In_Colum_Table(
        	tableObject
         , 	expText1
         , 	expText1ColNum
         , 	expText2
         , 	expText2ColNum)
}

def static "reusableComponents.VerifyDataInWebTable.EditDelete_Click_Operation_In_WebTable"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	
     , 	String clickOperation	
     , 	int clickOperationColNum	
     , 	String clickAttribute	) {
    (new reusableComponents.VerifyDataInWebTable()).EditDelete_Click_Operation_In_WebTable(
        	tableObject
         , 	expText
         , 	expTextColNum
         , 	clickOperation
         , 	clickOperationColNum
         , 	clickAttribute)
}

def static "reusableComponents.VerifyDataInWebTable.Peform_AnchorClick_Operation_In_Table"(
    	TestObject tableObject	
     , 	String expText	
     , 	int expTextColNum	
     , 	int clickOperationColNum	) {
    (new reusableComponents.VerifyDataInWebTable()).Peform_AnchorClick_Operation_In_Table(
        	tableObject
         , 	expText
         , 	expTextColNum
         , 	clickOperationColNum)
}

def static "question.GetMetrics.getAlarmsCountfromGA"() {
    (new question.GetMetrics()).getAlarmsCountfromGA()
}

def static "reusableComponents.Verify_Text_In_WebElement.verifyTextInWebelement"(
    	TestObject objectto	
     , 	String expText	) {
    (new reusableComponents.Verify_Text_In_WebElement()).verifyTextInWebelement(
        	objectto
         , 	expText)
}

def static "helper.login.LoginHelper.loginVPN"() {
    (new helper.login.LoginHelper()).loginVPN()
}

def static "helper.login.LoginHelper.checkHomePageExist"() {
    (new helper.login.LoginHelper()).checkHomePageExist()
}

def static "helper.login.LoginHelper.login"() {
    (new helper.login.LoginHelper()).login()
}

def static "helper.login.LoginHelper.loginIntoApplication"(
    	String applicationUrl	
     , 	String Username	
     , 	String Password	) {
    (new helper.login.LoginHelper()).loginIntoApplication(
        	applicationUrl
         , 	Username
         , 	Password)
}

def static "helper.login.LoginHelper.loginIntoApplicationWith"() {
    (new helper.login.LoginHelper()).loginIntoApplicationWith()
}

def static "helper.login.LoginHelper.logoutFromApplication"() {
    (new helper.login.LoginHelper()).logoutFromApplication()
}

def static "reusableComponents.VerifyDrodownValues_AlphabeticalOrder.verifyOptionsInDropdownInAphabeticalOrder"(
    	TestObject objectto	) {
    (new reusableComponents.VerifyDrodownValues_AlphabeticalOrder()).verifyOptionsInDropdownInAphabeticalOrder(
        	objectto)
}

def static "com.common.utils.ScreenShot.takeScreenShot"(
    	String path	
     , 	String name	) {
    (new com.common.utils.ScreenShot()).takeScreenShot(
        	path
         , 	name)
}

def static "helper.navigate.NavigationHelper.navigateToMenuItem"(
    	String menuName	) {
    (new helper.navigate.NavigationHelper()).navigateToMenuItem(
        	menuName)
}

def static "question.RandomEmail.getEmail"(
    	String suffix	
     , 	String prefix	) {
    (new question.RandomEmail()).getEmail(
        	suffix
         , 	prefix)
}

def static "hci_smoke_test.common.waifForElement"(
    	String xpath	
     , 	int inSeconds	) {
    (new hci_smoke_test.common()).waifForElement(
        	xpath
         , 	inSeconds)
}

def static "hci_smoke_test.common.waifForElementPresent"(
    	String xpath	
     , 	int inSeconds	) {
    (new hci_smoke_test.common()).waifForElementPresent(
        	xpath
         , 	inSeconds)
}

def static "hci_smoke_test.common.check_PDFFile_Downloaded"(
    	int seconds	) {
    (new hci_smoke_test.common()).check_PDFFile_Downloaded(
        	seconds)
}

def static "hci_smoke_test.common.verifyAllLinksOnCurrentPageAccessible"(
    	boolean STOP_ON_FAILURE	) {
    (new hci_smoke_test.common()).verifyAllLinksOnCurrentPageAccessible(
        	STOP_ON_FAILURE)
}

def static "hci_smoke_test.common.checkLinksBrokenOnCurrentPage"() {
    (new hci_smoke_test.common()).checkLinksBrokenOnCurrentPage()
}

def static "hci_smoke_test.common.navigateAllLinks_ByXpath"(
    	String xpath	) {
    (new hci_smoke_test.common()).navigateAllLinks_ByXpath(
        	xpath)
}

def static "hci_smoke_test.common.appendBrowserLogs"() {
    (new hci_smoke_test.common()).appendBrowserLogs()
}

def static "hci_smoke_test.common.refreshBrowser"() {
    (new hci_smoke_test.common()).refreshBrowser()
}

def static "hci_smoke_test.common.clickElement"(
    	TestObject to	) {
    (new hci_smoke_test.common()).clickElement(
        	to)
}

def static "hci_smoke_test.common.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new hci_smoke_test.common()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "reusableComponents.DatepickerHandler.handleDatepicker"(
    	TestObject calender	
     , 	String exp_Date	
     , 	String exp_Month	
     , 	String exp_Year	) {
    (new reusableComponents.DatepickerHandler()).handleDatepicker(
        	calender
         , 	exp_Date
         , 	exp_Month
         , 	exp_Year)
}

def static "reusableComponents.VerifyExpectedAndActualOptionsInDropdown.VerifyExpectedAndActual"(
    	TestObject objectto	
     , 	List listOfOptions	) {
    (new reusableComponents.VerifyExpectedAndActualOptionsInDropdown()).VerifyExpectedAndActual(
        	objectto
         , 	listOfOptions)
}

def static "reusableComponents.HighlightElement.run"(
    	TestObject objectto	) {
    (new reusableComponents.HighlightElement()).run(
        	objectto)
}

def static "reusableComponents.webTable.Edit_Delete_Update_Anchor_actions"(
    	String ExpectedRowName	
     , 	int Column	
     , 	int AchorLink	) {
    (new reusableComponents.webTable()).Edit_Delete_Update_Anchor_actions(
        	ExpectedRowName
         , 	Column
         , 	AchorLink)
}

def static "reusableComponents.webTable.GetText_From_WebTable"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).GetText_From_WebTable(
        	ExpectedRowName
         , 	Column)
}

def static "reusableComponents.webTable.GetText_From_WebTable_Organisation"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).GetText_From_WebTable_Organisation(
        	ExpectedRowName
         , 	Column)
}

def static "reusableComponents.webTable.Selecting_CheckBox_From_WebTable"(
    	String ExpectedRowName	
     , 	int Column	) {
    (new reusableComponents.webTable()).Selecting_CheckBox_From_WebTable(
        	ExpectedRowName
         , 	Column)
}

def static "com.jira.components.JSelect.selectByText"(
    	TestObject o	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	o
         , 	optionText)
}

def static "com.jira.components.JSelect.selectByText"(
    	String labelSelect	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	labelSelect
         , 	optionText)
}

def static "com.jira.components.JSelect.selectByText"(
    	WebElement el	
     , 	String optionText	) {
    (new com.jira.components.JSelect()).selectByText(
        	el
         , 	optionText)
}

def static "helper.excel.ExcelHelper.writeTOExcelFile"(
    	String excelPath	
     , 	String sheetName	
     , 	String value	
     , 	int rowNo	
     , 	int colNo	) {
    (new helper.excel.ExcelHelper()).writeTOExcelFile(
        	excelPath
         , 	sheetName
         , 	value
         , 	rowNo
         , 	colNo)
}

def static "question.UniqueSelection.SelectCheckBox"() {
    (new question.UniqueSelection()).SelectCheckBox()
}

def static "question.ClickAnyLink.wrapperClick"(
    	String linkName	) {
    (new question.ClickAnyLink()).wrapperClick(
        	linkName)
}

def static "helper.browserhelper.CustomBrowser.openBrowser"() {
    (new helper.browserhelper.CustomBrowser()).openBrowser()
}

def static "helper.browserhelper.CustomBrowser.openBrowserWithUrl"(
    	String url	) {
    (new helper.browserhelper.CustomBrowser()).openBrowserWithUrl(
        	url)
}

def static "helper.browserhelper.CustomBrowser.closeBrowser"() {
    (new helper.browserhelper.CustomBrowser()).closeBrowser()
}

def static "helper.browserhelper.CustomBrowser.takingScreenshot"() {
    (new helper.browserhelper.CustomBrowser()).takingScreenshot()
}

def static "helper.browserhelper.CustomBrowser.takingScreenshotStatus"(
    	String testcaseName	
     , 	String testStatus	) {
    (new helper.browserhelper.CustomBrowser()).takingScreenshotStatus(
        	testcaseName
         , 	testStatus)
}

def static "helper.grid.GridHelper.GetValueFromGrid"(
    	TestObject baseTestObject	
     , 	int rowIndex	
     , 	int colIndex	) {
    (new helper.grid.GridHelper()).GetValueFromGrid(
        	baseTestObject
         , 	rowIndex
         , 	colIndex)
}

def static "helper.grid.GridHelper.getValueOrClickOnColumn"(
    	TestObject baseTestObject	
     , 	int rowIndex	
     , 	int colIndex	
     , 	String type	) {
    (new helper.grid.GridHelper()).getValueOrClickOnColumn(
        	baseTestObject
         , 	rowIndex
         , 	colIndex
         , 	type)
}

def static "randomData.TestDataGenerator.getRandomParagraphs"(
    	int a	
     , 	int b	) {
    (new randomData.TestDataGenerator()).getRandomParagraphs(
        	a
         , 	b)
}

def static "randomData.TestDataGenerator.getRandomName"(
    	int a	
     , 	int b	) {
    (new randomData.TestDataGenerator()).getRandomName(
        	a
         , 	b)
}

def static "randomData.TestDataGenerator.getRandomFemaleName"() {
    (new randomData.TestDataGenerator()).getRandomFemaleName()
}

def static "randomData.TestDataGenerator.getRandomMaleName"() {
    (new randomData.TestDataGenerator()).getRandomMaleName()
}

def static "randomData.TestDataGenerator.getRandomFirstName"() {
    (new randomData.TestDataGenerator()).getRandomFirstName()
}

def static "randomData.TestDataGenerator.getRandomLastName"() {
    (new randomData.TestDataGenerator()).getRandomLastName()
}

def static "randomData.TestDataGenerator.getRandomCity"() {
    (new randomData.TestDataGenerator()).getRandomCity()
}

def static "randomData.TestDataGenerator.getRandomHeading"(
    	int numberofWords	) {
    (new randomData.TestDataGenerator()).getRandomHeading(
        	numberofWords)
}

def static "randomData.TestDataGenerator.getRandomHeading_two"(
    	int Wordsfrom	
     , 	int wordstwo	) {
    (new randomData.TestDataGenerator()).getRandomHeading_two(
        	Wordsfrom
         , 	wordstwo)
}

def static "randomData.TestDataGenerator.getRandomEmail"() {
    (new randomData.TestDataGenerator()).getRandomEmail()
}

def static "randomData.TestDataGenerator.set_RandomNumber"(
    	long len	) {
    (new randomData.TestDataGenerator()).set_RandomNumber(
        	len)
}

def static "randomData.TestDataGenerator.set_RandomNumberWithText"(
    	int length	) {
    (new randomData.TestDataGenerator()).set_RandomNumberWithText(
        	length)
}

def static "randomData.TestDataGenerator.getRandomPhoneNumberINDIA"() {
    (new randomData.TestDataGenerator()).getRandomPhoneNumberINDIA()
}

def static "randomData.TestDataGenerator.getRandom_Mailiantor_Email"() {
    (new randomData.TestDataGenerator()).getRandom_Mailiantor_Email()
}

def static "com.jira.utils.CustomGlobalVariable.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new com.jira.utils.CustomGlobalVariable()).addGlobalVariable(
        	name
         , 	value)
}

def static "question.VerifyInItemGrid.verifyItemInTheGrid"(
    	TestObject topDropDown	
     , 	int dropDownItemCount	
     , 	TestObject gridItemTestObject	) {
    (new question.VerifyInItemGrid()).verifyItemInTheGrid(
        	topDropDown
         , 	dropDownItemCount
         , 	gridItemTestObject)
}

def static "question.VerifyInItemGrid.multipleTestObject"(
    	String str	
     , 	TestObject objectOne	
     , 	TestObject objectTwo	
     , 	TestObject ObjectThree	) {
    (new question.VerifyInItemGrid()).multipleTestObject(
        	str
         , 	objectOne
         , 	objectTwo
         , 	ObjectThree)
}

def static "hci_smoke_test.create_new_record.iss_hazard"() {
    (new hci_smoke_test.create_new_record()).iss_hazard()
}
