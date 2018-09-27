if (GlobalVariable.userPin2.equals('SKIP')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * check git hash at the bottom of the page
 * May only necessary if we already know the expected git hash value to compare with.
 * May not need to run on dev sites if the git hash value is still being changed.
 * 
 * Steps:
 * 
 * check for this format:
 * 		About RHEO rev 9756b6b develop HEAD (21366)
 * need a way to verify the expected git hash (may only require in production sites)
 * for example:
 * 	https://docs.google.com/spreadsheets/d/1ouQAmhtSV9Z1pxPs1gGEtkUhc4Dd4Fap6hCJFfXXDyk/edit#gid=0
 * 
 */
CustomKeywords.'helper.login.LoginHelper.login'()

WebUI.scrollToElement(findTestObject('Page_Main Page/div_About-git-hash'),20)

git_hash_ver=WebUI.getText(findTestObject('Page_Main Page/div_About-git-hash'))

//WebUI.verifyMatch(GlobalVariable.G_git_hash_ver, git_hash_ver, false)
println('expected git_hash_ver='+GlobalVariable.G_git_hash_ver)
if (git_hash_ver.contains(GlobalVariable.G_git_hash_ver)){
	println('git_hash_ver is OK, found expected git_hash_ver in '+git_hash_ver)
}else{
	println('git_hash_ver is not matched, NOT found expected git_hash_ver '+GlobalVariable.G_git_hash_ver+' in the actual footer message found in cp-hazard main page: '+git_hash_ver)
	//throw new AssertionError('ERROR: git_hash_ver is wrong, check message: '+git_hash_ver)
}
