import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.python.antlr.PythonParser.else_clause_return
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable

boolean add_for_training_sites=true
boolean add_for_production_sites=false
user_pin='10051965'
user_email='joseph.fu@nasa.gov'
user_name='Joseph Fu'
user_uupic='739534374'
cclist=''

/*
# Create an array of MAS production & training sites [0,1]
# [0] = the site's base URL
# [1] = the permissiong group ID for disallow_record_modification
# note that [1] is DIFFERENT on each site (on top of that, SSMA currently doesn't even have it)
mas_sites=[
	# Begin production sites, be VERY certain to provide the disallow_record_modification group ID
	# You can find the ID by navigating to "/editgroups.cgi" and then clicking on disallow_record_modification
	# The resulting page will list the group ID in the URL (e.g. "?action=changeform&group=19")
*/
List<String[]> production_sites = Arrays.asList(
	// ARC PRACA
	["https://mas.nasa.gov/ARC-PRACA", "156"],
	// ArcJet DB
	["https://mas.nasa.gov/arcjetdb", "19"],
	// CP-Doctree
	["https://mas.nasa.gov/doctree", "19"],
	// CP-DMM
	["https://mas.nasa.gov/cpdmm", "22"],
	// CP-FMEA/CIL
	["https://cxfmea-cil.nasa.gov", "54"],
	// CP-GMIP
	["https://cxgmip.nasa.gov", "31"],
	// CP-Hazard
	["https://cxhazard.nasa.gov", "75"],
	// CP-Inventory
	["https://mas.nasa.gov/Inventory", "21"],
	// CP-LMS
	["https://cplms.nasa.gov", "22"],
	// CP-OMS
	["https://cpoms.nasa.gov", "21"],
	// CP-PRACA
	["https://cxpraca.nasa.gov", "207"],
	// CPID
	["https://mas.nasa.gov/cpid", "22"],
	// eCoFR
	["http://ecofr.nasa.gov", "22"],
	// eTaskWorkSheet
	["https://mas.nasa.gov/etasksheet", "22"],
	// EVAT
	//["https://mas.nasa.gov/EVAT", "21"],
	// FIQS (MAS)
	["https://mas.nasa.gov/FIQS", "22"],
	// ISS FMEA
	["https://fmea.iss.nasa.gov", "136"],
	// ISS Hazard
	["https://hazard.iss.nasa.gov", "20"],
	// ISS OCAD
	["https://ocad.iss.nasa.gov", "21"],
	// ISS PART
	["https://part.iss.nasa.gov", "439"],
	// MCaRD
	["https://mas.nasa.gov/mcard", "22"],
	// pracaBugs (doesn't need disallow)
	["https://mas.nasa.gov/pracaBugs", ""],
	// PRACTIS
	["https://mas.nasa.gov/PRACTIS", "21"],
	// SIMS
	["https://mas.nasa.gov/sims", "33"],
	// SSMA
	["https://mas.nasa.gov/ssma", ""],
	// StaffTrac
	["https://stafftrac.arc.nasa.gov", "22"],
	// WSTF webPAPER
	["https://mas.nasa.gov/WSTFwebPAPER", "20"],
	// RHEO
	["https://mas.nasa.gov/rheo", "22"]
)

List<String> training_sites = Arrays.asList(
	"https://mas.nasa.gov/ARC-PRACATraining",
	"https://mas.nasa.gov/arcjetdbTraining",
	"https://mas.nasa.gov/doctreeTraining",
	"https://mas.nasa.gov/cpdmmTraining",
	"https://mas.nasa.gov/cxFmeaTraining",
	"https://mas.nasa.gov/cxgmip_training",
	"https://cxhazard.nasa.gov/training",
	"https://mas.nasa.gov/Inventory_Training",
	"https://cplms.nasa.gov/training",
	"https://cpoms.nasa.gov/training",
	"https://mas.nasa.gov/pracaTraining",
	"https://mas.nasa.gov/cpidTraining",
	"https://ecofr.nasa.gov/training",
	"https://mas.nasa.gov/etasksheetTraining",
	//"https://mas.nasa.gov/EVATTraining",
	"https://mas.nasa.gov/FIQSTraining",
	"https://fmea.iss.nasa.gov/training",
	"https://hazard.iss.nasa.gov/training",
	"https://ocad.iss.nasa.gov/training",
	"https://part.iss.nasa.gov/training",
	"https://mas.nasa.gov/mcardTraining",
	"https://mas.nasa.gov/PRACTISTraining",
	"https://mas.nasa.gov/simsTraining",
	"https://mas.nasa.gov/stafftracTraining",
	"https://mas.nasa.gov/WSTFwebPAPER-training",
	"https://mas.nasa.gov/rheoTraining"
	);

GlobalVariable.G_userPin=user_pin

/////////////////////////////////////////////////////////////////////////////////////////////////
if (add_for_production_sites){
println 'will perform add_for_production_sites'

size=size=production_sites.size()
println 'total sites='+size

//// testing ////
/*for (int i = 0; i < size; i++) {
	
	println('production_site='+production_sites.get(i)[0]);
	println('group ID='+production_sites.get(i)[1]);
	CustomKeywords.'helper.login.LoginHelper.login'(production_sites.get(i)[0])
	//CustomKeywords.'helper.login.LoginHelper.login'(production_sites.get(i)[0]+'/editusers.cgi?action=add')
	//WebUI.navigateToUrl(production_sites.get(i)[0]+'/editusers.cgi?action=add')
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'),3,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Object Repository/Page_CP-Hazard Main Page/a_sandbox instance'))
	}
	else{
		println production_sites.get(i)[0]+' does not have sandbox instance'
		if (production_sites.get(i)[0].contains('mas.nasa.gov')){
			if (production_sites.get(i)[0].contains('Inventory')){
				training_site_url=production_sites.get(i)[0]+'_Training'
			}else if (production_sites.get(i)[0].contains('WSTFwebPAPER')){
				training_site_url=production_sites.get(i)[0]+'-training'
			}else{		
				training_site_url=(production_sites.get(i)[0]+'Training')
			}
		}else{
			training_site_url=(production_sites.get(i)[0]+'/training')
		}
		WebUI.navigateToUrl(training_site_url)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_404 Not Found/h1_Not Found'), 1,FailureHandling.STOP_ON_FAILURE)
		
	}
		
}
return*/
//// testing ////

baseUrl="http://www.nasa.gov"
driver = DriverFactory.getWebDriver()
selenium = new WebDriverBackedSelenium(driver,baseUrl)
for (int i = 0; i < size; i++) {
	println('production_site='+production_sites.get(i)[0]);
	println('group ID='+production_sites.get(i)[1]);
	
	// login to the site, then navigate to the add user view
	CustomKeywords.'helper.login.LoginHelper.login'(production_sites.get(i)[0])	
	WebUI.navigateToUrl(production_sites.get(i)[0]+'/editusers.cgi?action=add')
	
	add_user( user_email,  user_name,  user_uupic,  cclist)
		
	// provision disallow_record_modification (only if provided, e.g. for production, but not training)
	// the group ID for this particular permission varies by system, <sarcasm> hooray! </sarcasm>
	selenium.waitForPageToLoad('30000')
	WebUI.delay(2)
	selenium.click('id=group_'+production_sites.get(i)[1])
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Add user/input_update_button'),5)
	WebUI.click(findTestObject('Object Repository/Page_Add user/input_update_button'))
	
}

}

/////////////////////////////////////////////////////////////////////////////////////////////////

if (add_for_training_sites){
println 'will perform add_for_training_sites'
size=size=training_sites.size()
println 'total sites='+size
//GlobalVariable.G_userPin=user_pin

//// for testing ////
for (int i = 0; i < size; i++) {
	println('training_site='+training_sites.get(i));
	//CustomKeywords.'helper.login.LoginHelper.login'(training_sites.get(i)+'/editusers.cgi?action=add')	
	if (!CustomKeywords.'helper.login.LoginHelper.login'(training_sites.get(i)))
		println 'cannot login to training_site:'+training_sites.get(i)
	//WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_404 Not Found/h1_Not Found'), 1,FailureHandling.STOP_ON_FAILURE)
	
}
return
//// for testing ////

for (int i = 0; i < size; i++) {
	println('training_site='+training_sites.get(i));
	
	// login to the site, then navigate to the add user view
	CustomKeywords.'helper.login.LoginHelper.login'(training_sites.get(i)+'/editusers.cgi?action=add')
	//WebUI.navigateToUrl(training_sites.get(i)+'/editusers.cgi?action=add')
	
	add_user( user_email,  user_name,  user_uupic,  cclist)
}

}
/////////////////////////////////////////////////////////////////////////////////////////////////

def add_user(String user_email, String user_name, String user_uupic, String cclist){
	// should be in add user page already
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Add user/input_Email_login'), 10)
	WebUI.verifyElementNotVisible(findTestObject('Page_Missing or Invalid User/b_You made an invalid entry'), FailureHandling.STOP_ON_FAILURE)
	// fill in the values for the user
	WebUI.setText(findTestObject('Object Repository/Page_Add user/input_Email_login'), user_email)
	WebUI.setText(findTestObject('Object Repository/Page_Add user/input_Preferred name'), user_name)
	WebUI.setText(findTestObject('Object Repository/Page_Add user/input_UUPIC_extern_id'), user_uupic)
	if (!cclist.equals(''))
		WebUI.setText(findTestObject('Object Repository/Page_Add user/input_send_email_cclist'), cclist)
	
	// add it
	WebUI.click(findTestObject('Object Repository/Page_Add user/input_Add_button'))
	// add admin permission and confirm it
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Add user/input_admin_permission_button'),5)
	WebUI.click(findTestObject('Object Repository/Page_Add user/input_admin_permission_button'))
	WebUI.click(findTestObject('Object Repository/Page_Add user/input_bless_button'))
	
	// verify it is OK?

}