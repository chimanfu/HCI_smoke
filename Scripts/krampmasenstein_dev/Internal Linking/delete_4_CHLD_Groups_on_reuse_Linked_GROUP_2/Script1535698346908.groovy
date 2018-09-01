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

CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-1 GROUP-2_CHLD-1'))
CustomKeywords.'kramp.Internal_Linking.delete_group_save_changes'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-1 GROUP-2_CHLD-2'))
CustomKeywords.'kramp.Internal_Linking.delete_group_save_changes'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-1 GROUP-2_CHLD-3'))
CustomKeywords.'kramp.Internal_Linking.delete_group_save_changes'()

CustomKeywords.'kramp.Internal_Linking.select_TAB_Group_Linking_Child'()
WebUI.click(findTestObject('Page_G2G_linking_record/div_CHLD-1 GROUP-2_CHLD-4'))
CustomKeywords.'kramp.Internal_Linking.delete_group_save_changes'()

