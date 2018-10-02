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
 * check correct tag at the bottom
 * check for this format:
 * 		About RHEO rev 9756b6b develop HEAD (21366)
 * need a way to verify the expected correct tag (may only require in production sites
 * for example:
 * 	https://docs.google.com/spreadsheets/d/1ouQAmhtSV9Z1pxPs1gGEtkUhc4Dd4Fap6hCJFfXXDyk/edit#gid=0
 *
 */

GlobalVariable.G_tag_ver='master 7.0'
WebUI.comment  'for 7.0 rollout, expected correct tag = '+GlobalVariable.G_tag_ver
//refer to https://docs.google.com/spreadsheets/d/1Y-aObiFf3VOppDvePzLnLsVXcxFN6EpnKlqsQHH03AY/edit#gid=1051137565

CustomKeywords.'helper.login.LoginHelper.login'()
WebUI.scrollToElement(findTestObject('Page_Main Page/div_About-git-hash'),20)
// WebUI.click(findTestObject('Page_Main Page/div_About-git-hash'))
 
 footer_message=WebUI.getText(findTestObject('Page_Main Page/div_About-git-hash'))
 

 println('expected G_tag_ver='+GlobalVariable.G_tag_ver)
 if (footer_message.contains(GlobalVariable.G_tag_ver)){
	 println('G_tag_ver is OK, found expected G_tag_ver in '+footer_message)
 }else{
	 println('WARNING: G_tag_ver is not matched, NOT found expected correct tag '+GlobalVariable.G_tag_ver+' in the actual footer message found in cp-hazard main page: '+footer_message)
	 throw new AssertionError('ERROR: G_tag_ver is wrong, expected correct tag = '+GlobalVariable.G_tag_ver+', check actual footer message: '+footer_message)
 }