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

//WebUI.navigateToUrl('https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/')

WebUI.click(findTestObject('Page_Main Page/a_Admin'))

WebUI.click(findTestObject('Page_Administer your installation/a_Parameters'))

WebUI.click(findTestObject('Object Repository/Page_Configuration Required Setting/a_Index'))
WebUI.delay(1)
WebUI.waitForElementVisible(findTestObject('Page_Configuration Administrative Policies/dd_The browsers that this system support'),15)
WebUI.waitForElementClickable(findTestObject('Page_Parameters Index/a_permittedBrowsers'),10)
WebUI.click(findTestObject('Page_Parameters Index/a_permittedBrowsers'))
value_permittedBrowsers=WebUI.getAttribute(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'), 'value')
println('value of permittedBrowsers = '+value_permittedBrowsers)

WebUI.verifyMatch(value_permittedBrowsers, GlobalVariable.G_permitted_browser, false)
println('matched')
//*[@id="permittedBrowsers"]
//*[@id="bugzilla-body"]/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr[33]/td[1]/a
//WebUI.click(findTestObject('Page_Configuration Administrative Policies/txt_permittedBrowsers'))


