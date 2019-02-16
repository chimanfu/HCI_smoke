if (GlobalVariable.testrun_status.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('raining')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('MAKE-MAS')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) return
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

String siteURL=GlobalVariable.G_MAKE_MAS_url
if (siteURL.endsWith('/')) siteURL=siteURL.substring(0,siteURL.lastIndexOf('/'))
loginblurb_view=siteURL+'/editparams.cgi?section=core#loginblurb_desc'
/*
checking loginblurb_script loginblurb_script for the announce.cgi javascript code

<script>
$(document).ready(function () {
    let $lb = $('#login-blurb');
    if ($lb.length !== 0) {
        $.get('announce.cgi', function( data ) {
            $lb.prepend( data );
        });
    }
});
</script>

the script is not the same in
https://cplms.nasa.gov/editparams.cgi?section=core#loginblurb_desc
https://cpoms.nasa.gov/editparams.cgi?section=core#loginblurb_desc
*/
CustomKeywords.'helper.login.LoginHelper.login'()
//CustomKeywords.'helper.login.LoginHelper.switch_to_training'()

WebUI.navigateToUrl(loginblurb_view)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Configuration Required Setting/textarea_loginblurb'), 15)
String loginblurb_script_actual=WebUI.getText(findTestObject('Object Repository/Page_Configuration Required Setting/textarea_loginblurb'))
String loginblurb_script_expected="<script type=\"text/javascript\"> \$(document).ready(function () { let \$lb = \$('#login-blurb'); if (\$lb.length !== 0) { \$.get('announce.cgi', function( data ) { \$lb.append( data ); }); } }); </script>"
String loginblurb_script_expected2="\$(document).ready(function () { let \$lb = \$('#login-blurb'); if (\$lb.length !== 0) { \$.get('announce.cgi', function( data ) { \$lb.prepend( data ); }); } }); </script>"

loginblurb_script_expected=loginblurb_script_expected.replaceAll(" ", "")
loginblurb_script_expected2=loginblurb_script_expected2.replaceAll(" ", "")
loginblurb_script_actual=loginblurb_script_actual.trim().replaceAll("\\s+", " ").replaceAll(" ", "")
WebUI.comment 'loginblurb_script_actual='+loginblurb_script_actual
WebUI.comment 'loginblurb_script_expected='+loginblurb_script_expected
if (loginblurb_script_actual.contains(loginblurb_script_expected)) {
	WebUI.comment 'PASS: loginblurb parameter contains the login-blurb script as '+loginblurb_script_expected
}else if (loginblurb_script_actual.contains(loginblurb_script_expected2)) {
	WebUI.comment 'PASS: loginblurb parameter contains the login-blurb script as '+loginblurb_script_expected2
		
}else{
	throw new AssertionError('ERROR: NOT found loginblurb parameter contains the actual login-blurb script, check it please \n'+'loginblurb_script_expected='+loginblurb_script_expected+'\n'+'loginblurb_script_actual='+loginblurb_script_actual)
}


