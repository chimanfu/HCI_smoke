
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.util.List

import org.openqa.selenium.WebElement

import java.lang.Integer

import org.openqa.selenium.By


def static "question.GetMetrics.getAlarmsCountfromGA"() {
    (new question.GetMetrics()).getAlarmsCountfromGA()
}

def static "tools.DragAndDropHelper.dragAndDrop"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	) {
    (new tools.DragAndDropHelper()).dragAndDrop(
        	sourceObject
         , 	destinationObject)
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

def static "reusableComponents.Verify_Text_In_WebElement.verifyTextInWebelement"(
    	TestObject objectto	
     , 	String expText	) {
    (new reusableComponents.Verify_Text_In_WebElement()).verifyTextInWebelement(
        	objectto
         , 	expText)
}

def static "reusableComponents.VerifyDrodownValues_AlphabeticalOrder.verifyOptionsInDropdownInAphabeticalOrder"(
    	TestObject objectto	) {
    (new reusableComponents.VerifyDrodownValues_AlphabeticalOrder()).verifyOptionsInDropdownInAphabeticalOrder(
        	objectto)
}

def static "reusableComponents.VerifyExpectedAndActualOptionsInDropdown.VerifyExpectedAndActual"(
    	TestObject objectto	
     , 	List listOfOptions	) {
    (new reusableComponents.VerifyExpectedAndActualOptionsInDropdown()).VerifyExpectedAndActual(
        	objectto
         , 	listOfOptions)
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

def static "tools.WebUICustomKeywords.fileUploader"(
    	TestObject to	
     , 	String filePath	) {
    (new tools.WebUICustomKeywords()).fileUploader(
        	to
         , 	filePath)
}

def static "tools.WebUICustomKeywords.clickLocation"(
    	Integer xCord	
     , 	Integer yCord	) {
    (new tools.WebUICustomKeywords()).clickLocation(
        	xCord
         , 	yCord)
}

def static "tools.WebUICustomKeywords.clickObject"(
    	TestObject to1	
     , 	Integer xCord	
     , 	Integer yCord	) {
    (new tools.WebUICustomKeywords()).clickObject(
        	to1
         , 	xCord
         , 	yCord)
}

def static "tools.WebUICustomKeywords.highlightElement"(
    	TestObject to	) {
    (new tools.WebUICustomKeywords()).highlightElement(
        	to)
}

def static "tools.WebUICustomKeywords.ClearTextField"(
    	TestObject to	) {
    (new tools.WebUICustomKeywords()).ClearTextField(
        	to)
}

def static "tools.WebUICustomKeywords.zoomBrowser"(
    	int zoomLevel	) {
    (new tools.WebUICustomKeywords()).zoomBrowser(
        	zoomLevel)
}

def static "tools.WebUICustomKeywords.compareImage"(
    	String imgOriginal	
     , 	String imgToCompareWithOriginal	
     , 	String imgOutputDifferences	) {
    (new tools.WebUICustomKeywords()).compareImage(
        	imgOriginal
         , 	imgToCompareWithOriginal
         , 	imgOutputDifferences)
}

def static "tools.WebUICustomKeywords.compareImageNotEqual"(
    	String imgOriginal	
     , 	String imgToCompareWithOriginal	
     , 	String imgOutputDifferences	) {
    (new tools.WebUICustomKeywords()).compareImageNotEqual(
        	imgOriginal
         , 	imgToCompareWithOriginal
         , 	imgOutputDifferences)
}

def static "tools.WebUICustomKeywords.clickUsingJS"(
    	TestObject to	
     , 	int timeout	) {
    (new tools.WebUICustomKeywords()).clickUsingJS(
        	to
         , 	timeout)
}

def static "tools.WebUICustomKeywords.waitForElementScrollandClick"(
    	TestObject to	) {
    (new tools.WebUICustomKeywords()).waitForElementScrollandClick(
        	to)
}

def static "tools.WebUICustomKeywords.resizeBrowser"(
    	Integer xCord	
     , 	Integer yCord	) {
    (new tools.WebUICustomKeywords()).resizeBrowser(
        	xCord
         , 	yCord)
}

def static "tools.WebUICustomKeywords.setBrowser"(
    	Integer xCord	
     , 	Integer yCord	) {
    (new tools.WebUICustomKeywords()).setBrowser(
        	xCord
         , 	yCord)
}

def static "tools.WebUICustomKeywords.Sleep"(
    	int time	) {
    (new tools.WebUICustomKeywords()).Sleep(
        	time)
}

def static "tools.WebUICustomKeywords.verifyPartialElementText"(
    	TestObject to	
     , 	String text	) {
    (new tools.WebUICustomKeywords()).verifyPartialElementText(
        	to
         , 	text)
}

def static "tools.WebUICustomKeywords.isElementPresent"(
    	TestObject to	
     , 	int timeout	) {
    (new tools.WebUICustomKeywords()).isElementPresent(
        	to
         , 	timeout)
}

def static "tools.WebUICustomKeywords.byLocator"(
    	By locator	) {
    (new tools.WebUICustomKeywords()).byLocator(
        	locator)
}

def static "tools.WebUICustomKeywords.getEmail"(
    	String suffix	
     , 	String prefix	) {
    (new tools.WebUICustomKeywords()).getEmail(
        	suffix
         , 	prefix)
}

def static "tools.WebUICustomKeywords.killProcess"() {
    (new tools.WebUICustomKeywords()).killProcess()
}

def static "tools.WebUICustomKeywords.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new tools.WebUICustomKeywords()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "tools.WebUICustomKeywords.getHtmlTableColumns"(
    	WebElement row	
     , 	String tagName	) {
    (new tools.WebUICustomKeywords()).getHtmlTableColumns(
        	row
         , 	tagName)
}

def static "tools.WebUICustomKeywords.getCellText"(
    	TestObject table	
     , 	int rowIndex	
     , 	int columnIndex	) {
    (new tools.WebUICustomKeywords()).getCellText(
        	table
         , 	rowIndex
         , 	columnIndex)
}

def static "tools.WebUICustomKeywords.verifyOptionsInDropdownInAphabeticalOrder"(
    	Object element	) {
    (new tools.WebUICustomKeywords()).verifyOptionsInDropdownInAphabeticalOrder(
        	element)
}

def static "tools.WebUICustomKeywords.VerifyExpectedAndActual"(
    	TestObject objectto	
     , 	List listOfOptions	) {
    (new tools.WebUICustomKeywords()).VerifyExpectedAndActual(
        	objectto
         , 	listOfOptions)
}

def static "hci_smoke_test.create_new_record.iss_hazard"() {
    (new hci_smoke_test.create_new_record()).iss_hazard()
}

def static "question.VerifyAllElements.scrollAndVerfiyElement"(
    	String tagName	) {
    (new question.VerifyAllElements()).scrollAndVerfiyElement(
        	tagName)
}

def static "question.UniqueSelection.SelectCheckBox"() {
    (new question.UniqueSelection()).SelectCheckBox()
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

def static "question.UniqueScreenShot.takeScreenShot"(
    	String path	
     , 	String name	) {
    (new question.UniqueScreenShot()).takeScreenShot(
        	path
         , 	name)
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

def static "tools.TestDataGenerator.getRandomWords"(
    	int a	
     , 	int b	) {
    (new tools.TestDataGenerator()).getRandomWords(
        	a
         , 	b)
}

def static "tools.TestDataGenerator.getRandomParagraphs"(
    	int a	
     , 	int b	) {
    (new tools.TestDataGenerator()).getRandomParagraphs(
        	a
         , 	b)
}

def static "tools.TestDataGenerator.getRandomName"(
    	int a	
     , 	int b	) {
    (new tools.TestDataGenerator()).getRandomName(
        	a
         , 	b)
}

def static "tools.TestDataGenerator.getRandomFemaleName"() {
    (new tools.TestDataGenerator()).getRandomFemaleName()
}

def static "tools.TestDataGenerator.getRandomMaleName"() {
    (new tools.TestDataGenerator()).getRandomMaleName()
}

def static "tools.TestDataGenerator.getRandomFirstName"() {
    (new tools.TestDataGenerator()).getRandomFirstName()
}

def static "tools.TestDataGenerator.getRandomLastName"() {
    (new tools.TestDataGenerator()).getRandomLastName()
}

def static "tools.TestDataGenerator.getRandomCity"() {
    (new tools.TestDataGenerator()).getRandomCity()
}

def static "tools.TestDataGenerator.getRandomStateFull"() {
    (new tools.TestDataGenerator()).getRandomStateFull()
}

def static "tools.TestDataGenerator.getRandomStateAbbr"() {
    (new tools.TestDataGenerator()).getRandomStateAbbr()
}

def static "tools.TestDataGenerator.getRandomCountry"() {
    (new tools.TestDataGenerator()).getRandomCountry()
}

def static "tools.TestDataGenerator.getRandomZipCode"() {
    (new tools.TestDataGenerator()).getRandomZipCode()
}

def static "tools.TestDataGenerator.getRandomPhone"() {
    (new tools.TestDataGenerator()).getRandomPhone()
}

def static "tools.TestDataGenerator.getRandomHeading"(
    	int numberofWords	) {
    (new tools.TestDataGenerator()).getRandomHeading(
        	numberofWords)
}

def static "tools.TestDataGenerator.getRandomHeading_two"(
    	int Wordsfrom	
     , 	int wordstwo	) {
    (new tools.TestDataGenerator()).getRandomHeading_two(
        	Wordsfrom
         , 	wordstwo)
}

def static "tools.TestDataGenerator.getRandomEmail"() {
    (new tools.TestDataGenerator()).getRandomEmail()
}

def static "tools.TestDataGenerator.set_RandomNumber"(
    	long len	) {
    (new tools.TestDataGenerator()).set_RandomNumber(
        	len)
}

def static "tools.TestDataGenerator.set_RandomNumberWithText"(
    	int length	) {
    (new tools.TestDataGenerator()).set_RandomNumberWithText(
        	length)
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

def static "question.ClickAnyLink.wrapperClick"(
    	String linkName	) {
    (new question.ClickAnyLink()).wrapperClick(
        	linkName)
}

def static "question.CustomJsonParser.jsonExtractor"(
    	String response	) {
    (new question.CustomJsonParser()).jsonExtractor(
        	response)
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

def static "question.CustomDatabase.executeQuery"(
    	String connectionUrl	
     , 	String query	) {
    (new question.CustomDatabase()).executeQuery(
        	connectionUrl
         , 	query)
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

def static "tools.pdfReader.ReadPDF"(
    	String PDFURL	) {
    (new tools.pdfReader()).ReadPDF(
        	PDFURL)
}

def static "question.RandomEmail.getEmail"(
    	String suffix	
     , 	String prefix	) {
    (new question.RandomEmail()).getEmail(
        	suffix
         , 	prefix)
}

def static "tools.WebApiCustomKeywords.createBasicAuthProperty"(
    	String usernameAdmin	
     , 	String password	) {
    (new tools.WebApiCustomKeywords()).createBasicAuthProperty(
        	usernameAdmin
         , 	password)
}

def static "tools.WebApiCustomKeywords.updateHttpBody"(
    	String password	
     , 	String emailAddress	
     , 	String displayName	
     , 	String notification	) {
    (new tools.WebApiCustomKeywords()).updateHttpBody(
        	password
         , 	emailAddress
         , 	displayName
         , 	notification)
}

def static "tools.WebApiCustomKeywords.newHttpBody"(
    	String username	
     , 	String password	
     , 	String emailAddress	
     , 	String displayName	
     , 	String notification	) {
    (new tools.WebApiCustomKeywords()).newHttpBody(
        	username
         , 	password
         , 	emailAddress
         , 	displayName
         , 	notification)
}

def static "tools.WebApiCustomKeywords.verifyStatusCode"(
    	TestObject request	
     , 	int expectedStatusCode	) {
    (new tools.WebApiCustomKeywords()).verifyStatusCode(
        	request
         , 	expectedStatusCode)
}

def static "tools.WebApiCustomKeywords.addBasicAuthorizationProperty"(
    	TestObject request	
     , 	String username	
     , 	String password	) {
    (new tools.WebApiCustomKeywords()).addBasicAuthorizationProperty(
        	request
         , 	username
         , 	password)
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

def static "com.ea.utilities.CommonUtilities.CheckDropDownListElementExist"(
    	TestObject object	
     , 	String option	) {
    (new com.ea.utilities.CommonUtilities()).CheckDropDownListElementExist(
        	object
         , 	option)
}

def static "tools.DatabaseUtils.connectDB"(
    	String url	
     , 	String dbname	
     , 	String port	
     , 	String username	
     , 	String password	) {
    (new tools.DatabaseUtils()).connectDB(
        	url
         , 	dbname
         , 	port
         , 	username
         , 	password)
}

def static "tools.DatabaseUtils.executeQuery"(
    	String queryString	) {
    (new tools.DatabaseUtils()).executeQuery(
        	queryString)
}

def static "tools.DatabaseUtils.closeDatabaseConnection"() {
    (new tools.DatabaseUtils()).closeDatabaseConnection()
}

def static "tools.DatabaseUtils.execute"(
    	String queryString	) {
    (new tools.DatabaseUtils()).execute(
        	queryString)
}

def static "helper.navigate.NavigationHelper.navigateToMenuItem"(
    	String menuName	) {
    (new helper.navigate.NavigationHelper()).navigateToMenuItem(
        	menuName)
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

def static "reusableComponents.HighlightElement.run"(
    	TestObject objectto	) {
    (new reusableComponents.HighlightElement()).run(
        	objectto)
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
