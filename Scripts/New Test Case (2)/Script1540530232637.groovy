import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions
import org.sikuli.script.Screen as Screen
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;
import internal.GlobalVariable as GlobalVariable

/*String a = "Hello|World|yes";
String[] str;
str = a.split('\\|');

for( String value : str )
	println(value);
return*/
	
group_names='_NASA|HP_Boeing_inwork<'
xml_page_contents='<token>1541531886-b07f231d2a4eb7768ba4b62523e7528b</token>\n<group id="90">HP_Boeing_inwork</group>\n<group id="91">HP_Boeing_read</group>\n<group id="457">_NASA</group>'

String[] group_name_list;
group_name_list = group_names.split('\\|');

/*int currentTab = WebUI.getWindowIndex()
WebUI.waitForElementNotClickable(findTestObject('Object Repository/Page_Record_Created/a_XML'), 10)
WebUI.click(findTestObject('Object Repository/Page_Record_Created/a_XML'))
WebUI.delay(1)
WebUI.switchToWindowIndex(currentTab+1)
String xml_page_contents=WebUI.getText(findTestObject('Object Repository/Page_Record_Created/all_XML_contents'))
WebUI.closeWindowIndex(currentTab + 1)
WebUI.switchToWindowIndex(currentTab)*/
for( String group_name : group_name_list ){
	println(group_name);
	if (xml_page_contents.contains(group_name)){
		println 'PASS: Group ' + group_name + ': Found in XML doc'
	}else{
		println 'FAIL: Group ' + group_name + ': Not Found in XML doc'
		throw new AssertionError('FAIL: Group ' + group_name + ': Not Found in XML doc')
	}
}

//s = ['a', 'b', 'c', 'c'] as Set<String>
//println s
/*checkboxes_selected='10,20,30'
checkboxes_selected2='10,20,30'
String[] checkboxes_selected_list = checkboxes_selected.split(',');
Set<String> checkboxes_selected_set = new HashSet<String>(Arrays.asList(checkboxes_selected_list));

String[] checkboxes_selected_list2 = checkboxes_selected2.split(',');
Set<String> checkboxes_selected_set2 = new HashSet<String>(Arrays.asList(checkboxes_selected_list2));
println checkboxes_selected_set.equals(checkboxes_selected_set2)
return*/
/*
def validate_ECR_checkboxes(checkboxes_selected,checkboxes_disabled,checkboxes_visible){
	
WebUI.comment('checkboxes_selected='+checkboxes_selected)
WebUI.comment('checkboxes_disabled='+checkboxes_disabled)
WebUI.comment('checkboxes_visible='+checkboxes_visible)
String[] checkboxes_selected_list = checkboxes_selected.split(',');
Set<String> checkboxes_selected_set = new HashSet<String>(Arrays.asList(checkboxes_selected_list));
String[] checkboxes_disabled_list = checkboxes_disabled.split(',');
Set<String> checkboxes_disabled_set = new HashSet<String>(Arrays.asList(checkboxes_disabled_list));
String[] checkboxes_visible_list = checkboxes_visible.split(',');
Set<String> checkboxes_visible_set = new HashSet<String>(Arrays.asList(checkboxes_visible_list));

List<String> visible_checkboxes = new ArrayList<String>();
List<String> disabled_checkboxes = new ArrayList<String>();
List<String> selected_checkboxes = new ArrayList<String>();
WebDriver driver
driver = DriverFactory.getWebDriver()


println 'Go to approvals and concurrences tab'
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'),10)
WebUI.click(findTestObject('Object Repository/Page_Record_Created/div_Approvals and Concurrences'))

print "\nBrowser detects checkbox visibility, disabled/enabled, and selection"

/////
print "CSA checkbox:"
try {
	WebElement CSA_checkbox=driver.findElement(By.id('OR_GROUPS_CSA'))
	print "  - visible"
	visible_checkboxes.add("CSA");
	
	if (! CSA_checkbox.isEnabled()){
		print "  - disabled"
		disabled_checkboxes.add("CSA")
	}
	if (CSA_checkbox.isSelected()){
		print "  - selected"
		selected_checkboxes.add("CSA")
	}
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}
/////
print "\nRSA checkbox"
try{
	WebElement RSA_checkbox=driver.findElement(By.id('OR_GROUPS_RSA'))
	print "  - visible"
	visible_checkboxes.add("RSA")

	if (! RSA_checkbox.isEnabled()){
		print "  - disabled"
		disabled_checkboxes.add("RSA")
	}
	if (RSA_checkbox.isSelected()){
		print "  - selected"
		selected_checkboxes.add("RSA")
	}
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}

print "\nESA checkbox"
try{
	WebElement ESA_checkbox=driver.findElement(By.id('OR_GROUPS_ESA'))
	print "  - visible"
	visible_checkboxes.add("ESA")

	if (! ESA_checkbox.isEnabled()){
		print "  - disabled"
		disabled_checkboxes.add("ESA")
	}
	if (ESA_checkbox.isSelected()){
		print "  - selected"
		selected_checkboxes.add("ESA")
	}
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}
	
print "\nJAXA checkbox"
try{
	WebElement JAXA_checkbox = driver.findElement(By.id('OR_GROUPS_JAXA'))
	print "  - visible"
	visible_checkboxes.add("JAXA")

	if (! JAXA_checkbox.isEnabled()){
		print "  - disabled"
		disabled_checkboxes.add("JAXA")
	}
	if (JAXA_checkbox.isSelected()){
		print "  - selected"
		selected_checkboxes.add("JAXA")
	}
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}

print "\nITAR checkbox"
try{
	WebElement ITAR_checkbox = driver.findElement(By.id('ITAR*'))
	print "  - visible"
	visible_checkboxes.add("ITAR")
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}

print "\nHP_Boeing_inwork checkbox"
try{
	WebElement HP_Boeing_inwork_checkbox = driver.findElement(By.id('HP_Boeing_inwork'))
	print "  -visible"
	visible_checkboxes.add("HP_Boeing_inwork")

	if (! HP_Boeing_inwork_checkbox.isEnabled()){
		print "  - disabled"
		disabled_checkboxes.add("HP_Boeing_inwork")
	}
	if (HP_Boeing_inwork_checkbox.isSelected()){
		print "  - selected"
		selected_checkboxes.add("HP_Boeing_inwork")
	}
} catch (Exception e) {
	print "  - not visible"
	//e.printStackTrace()
}

Set selected_checkboxes_set = new HashSet();
selected_checkboxes_set.addAll(selected_checkboxes);
Set disabled_checkboxes_set = new HashSet();
disabled_checkboxes_set.addAll(disabled_checkboxes);
Set visible_checkboxes_set = new HashSet();
visible_checkboxes_set.addAll(visible_checkboxes);

if (checkboxes_selected_set.equals(selected_checkboxes_set)){
	println 'checkboxes_selected_set = selected_checkboxes_set'
}else{
	throw new AssertionError('ERROR: checkboxes_selected_set NOT = selected_checkboxes_set\n'+checkboxes_selected_set+'\n'+selected_checkboxes_set+'\n')
}
if (checkboxes_disabled_set.equals(disabled_checkboxes_set)){
	println 'checkboxes_disabled_set = disabled_checkboxes_set'
}else{
	throw new AssertionError('ERROR: checkboxes_disabled_set NOT = disabled_checkboxes_set\n'+checkboxes_disabled_set+'\n'+disabled_checkboxes_set+'\n')
}
if (checkboxes_visible_set.equals(visible_checkboxes_set)){
	println 'checkboxes_visible_set = visible_checkboxes_set'
}else{
	throw new AssertionError('ERROR: checkboxes_visible_set NOT = visible_checkboxes_set\n'+checkboxes_visible_set+'\n'+visible_checkboxes_set+'\n')
}
}
*/