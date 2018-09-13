import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'helper.login.LoginHelper.login'()
CustomKeywords.'kramp.Internal_Linking.select_TAB_Basic_Information'()

// On Core Fields
WebUI.click(findTestObject('Page_record_G2G_linking/div_Core Fields'))

// set status to READ-ONLY
WebUI.click(findTestObject('Page_record_G2G_linking/label_Status'))
WebUI.selectOptionByValue(findTestObject('Page_record_G2G_linking/select_Status'), 'EDITABLE', true)

CustomKeywords.'kramp.Internal_Linking.save_changes'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Basic_Information'()