if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * check tag value at the bottom of the page
 * May only necessary if we already know the expected tag value to compare with.
 * May not need to run on dev sites if the tag value is still being changed.
 * 
 * Steps:
 * 
 * check git hash at the bottom
 * check for this format:
 * 		About RHEO rev 9756b6b develop HEAD (21366)
 * need a way to verify the expected git hash (may only require in production sites
 * for example:
 * 	https://docs.google.com/spreadsheets/d/1ouQAmhtSV9Z1pxPs1gGEtkUhc4Dd4Fap6hCJFfXXDyk/edit#gid=0
 *
 */

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.scrollToElement(findTestObject('Page_Main Page/div_About-git-hash'),20)
// WebUI.click(findTestObject('Page_Main Page/div_About-git-hash'))
 
 footer_message=WebUI.getText(findTestObject('Page_Main Page/div_About-git-hash'))
 
 //WebUI.verifyMatch(GlobalVariable.G_git_hash_ver, git_hash_ver, false)
 println('expected git_hash_ver='+GlobalVariable.G_tag_ver)
 if (footer_message.contains(GlobalVariable.G_tag_ver)){
	 println('git_hash_ver is OK, found expected git_hash_ver in '+footer_message)
 }else{
	 println('WARNING: git_hash_ver is not matched, NOT found expected git_hash_ver '+GlobalVariable.G_tag_ver+' in the actual footer message found in cp-hazard main page: '+footer_message)
	 //throw new AssertionError('ERROR: git_hash_ver is wrong, check message: '+git_hash_ver)
 }