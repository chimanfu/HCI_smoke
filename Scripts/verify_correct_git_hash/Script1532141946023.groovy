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

/*
 * check git hash at the bottom
 * check for this format:
 * 		About RHEO rev 9756b6b develop HEAD (21366)
 * need a way to verify the expected git hash (may only require in production sites
 * for example:
 * 	https://docs.google.com/spreadsheets/d/1ouQAmhtSV9Z1pxPs1gGEtkUhc4Dd4Fap6hCJFfXXDyk/edit#gid=0
 * 
 */
WebUI.click(findTestObject('Page_Main Page/div_About-git-hash'))

git_hash_ver=WebUI.getText(findTestObject('Page_Main Page/div_About-git-hash'))

//WebUI.verifyMatch(GlobalVariable.G_git_hash_ver, git_hash_ver, false)
println('expected git_hash_ver='+GlobalVariable.G_git_hash_ver)
if (git_hash_ver.contains(GlobalVariable.G_git_hash_ver)){
	println('git_hash_ver is OK, found expected git_hash_ver in '+git_hash_ver)
}else{
	println('git_hash_ver is not matched, NOT found expected git_hash_ver '+GlobalVariable.G_git_hash_ver+' in the actual footer message found in cp-hazard main page: '+git_hash_ver)
	//throw new AssertionError('ERROR: git_hash_ver is wrong, check message: '+git_hash_ver)
}
