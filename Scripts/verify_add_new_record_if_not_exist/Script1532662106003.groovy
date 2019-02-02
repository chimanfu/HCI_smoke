if (GlobalVariable.testrun_status.equals('SKIP')) return
if (GlobalVariable.G_MAKE_MAS_url.contains('arcjetdb')) return
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/*
 This test may not need to run if already know which record can do diff report in dev sites
 
 NOT REQUIRED AND will not create new record on production site
 
Only for dev sites
if the site url contains 'MAKE-MAS', then
create a new record 'test_automation_record' if not already exists

need a list of records for production sites that can do search, snapshot or diff report
need a list of sites who can do snapshot, diff report etc...
which sites support dagger_server ?
need a better way to capture git hash and tag on production sites
sanity check only checks after 'OK, now running sanity checks'

*/

KeywordLogger log = new KeywordLogger()

search_term = 'test_automation_record'


String url = GlobalVariable.G_MAKE_MAS_url
WebUI.comment 'now checking the URL from the GlobalVariable.G_MAKE_MAS_url: '+url
if (url.contains('doctree')) {
	WebUI.comment('this is doctree')
	return	
}
if (url.contains('etasksheet')) {
	WebUI.comment('this is doctree')
	return	
}
if ((url.contains('MAKE-MAS')) && (url.contains('dev'))) {
    WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
} else {
    log.logWarning('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not create new record on production site')
    return null
}

if (!(GlobalVariable.addNewRecord)) {
    log.logInfo('The test will not run, as no need to add a new record for smoke test and GlobalVariable.addNewRecord is disabled')

    return null
} else {
    log.logInfo('if the record is not already exists, will add a new record with name=' + search_term)
}

WebUI.comment 'randomly to run this test or not (0 or 1)'
if ((int) (Math.random()+0.5)){
	WebUI.comment('perform test this time')
}
else{
	WebUI.comment 'will skip running it this time to save time'
	return
}

CustomKeywords.'helper.login.LoginHelper.login'()

// final check to make sure it's not production site
url=WebUI.getUrl()
WebUI.comment 'now checking thr URL from the current page from browser: '+url
if (url.contains('MAKE-MAS') && url.contains('dev')) {
	WebUI.comment('The URL contains MAKE-MAS and dev, so it is a test OR dev instance')
} else {
	log.logWarning('The URL does not contain MAKE-MAS and dev, so it is NOT a test instance, so should not create new record on production site')
	return null
}

WebUI.comment('will create a new record ONLY if not already exists')

WebUI.setText(findTestObject('Page_Main Page/input_quicksearch'), search_term)

WebUI.click(findTestObject('Page_Main Page/bt_Search'))

WebUI.waitForElementVisible(findTestObject('Page_Record List/div_Displaying_how_many_found'), 10)

//if (WebUI.getText(findTestObject('Page_Record List/div_Displaying_how_many_found')).contains('0 of 0')){
//WebUI.comment('0 of 0 record found with search term='+search_term)
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Record List/div_No records found.'), FailureHandling.OPTIONAL)) {
    WebUI.comment('No record found with search term=' + search_term)

    WebUI.comment('will add a new record with tile =' + search_term)

    WebUI.click(findTestObject('Page_Main Page/a_New'))

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if (GlobalVariable.G_MAKE_MAS_url.contains('react_cp_hazard_dev')) {
        WebUI.comment('this is react_cp_hazard_dev')

        WebUI.click(findTestObject('Page_Select Record Type/a_Hazard'))
		
        WebUI.click(findTestObject('Page_Enter Record_old/a_EGSHazards')) /*
			WebUI.waitForElementVisible(findTestObject('null'),5)
			WebUI.selectOptionByLabel(findTestObject('null'),
				'.*Ha.*',true)
			
			WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_Create New Record'),5)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.TAB)
			WebUI.sendKeys(Keys.ArrowDown+Keys.Enter)
			
			WebUI.waitForElementVisible(findTestObject('null'),5)
			WebUI.selectOptionByIndex(findTestObject('null'),
				2)*/
        //WebUI.delay(1)
        //String url = elements.get(0).getAttribute("href");
    } else if (GlobalVariable.G_MAKE_MAS_url.contains('cp_oms')) {
        WebUI.comment('this is cp_oms')
    } else if (GlobalVariable.G_MAKE_MAS_url.contains('arc_praca')) {
        WebUI.comment('this is arc_praca')

        WebUI.click(findTestObject('Page_Enter Record_old/a_20gCentrifuge'))

        WebUI.selectOptionByValue(findTestObject('Page_Enter Record View/select_options'), 'AF - Aviation Systems Division', 
            true)
    } else if (GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
        WebUI.comment('this is iss_hazard')

        WebUI.click(findTestObject('Page_Enter Record_old/a_New blank record'))

        WebUI.click(findTestObject('Page_Enter Record_old/a_AdAstraRocketCompany'))
    } else {
        WebDriver driver = DriverFactory.getWebDriver()

        WebUI.comment('get all new record links from the New Record Page')

        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"))

        WebElement firstElement = elements.get(0)

        WebUI.navigateToUrl(firstElement.getAttribute('href'))
		
		if (WebUI.waitForElementVisible(findTestObject('Page_Enter Record View/input_short_desc'), 3)){
			print('ready to create new record')
		}else{
			elements = driver.findElements(By.xpath("//a[contains(@href, 'enter_bug.cgi?')]"))
		
			firstElement = elements.get(0)
		
			WebUI.navigateToUrl(firstElement.getAttribute('href'))
		}
		
		
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    WebUI.comment('going to add a short description in title field, then create a new record with ttile ' + search_term)
	Screen s = new Screen()
    if (GlobalVariable.G_MAKE_MAS_url.contains('iss_hazard')) {
        WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)

        WebUI.comment('this is iss_hazard')

        WebUI.delay(1)

        s.type(Key.TAB)

        s.type(Key.TAB)

        WebUI.delay(1)

        s.type(Key.DOWN)

        WebUI.delay(2)

        s.type(Key.DOWN)

        WebUI.delay(1)

        s.type(Key.DOWN)

        WebUI.delay(2)

        s.type(Key.SPACE)

        WebUI.delay(3) //WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term+Keys.TAB+Keys.TAB+Keys.DOWN+Keys.DOWN+Keys.DOWN+Keys.ENTER)
        /*
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.TAB))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.TAB))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ARROW_DOWN))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ARROW_DOWN))
			WebUI.sendKeys(findTestObject('Page_Enter Record View/input_short_desc'),Keys.chord(Keys.ENTER))
			*/
    } else {
        WebUI.setText(findTestObject('Page_Enter Record View/input_short_desc'), search_term)
    }
    
    WebUI.click(findTestObject('Page_Enter Record View/input_Create New Record'))

    WebUI.waitForElementVisible(findTestObject('Page_Record View - test_automation_record/div_Record Title'), 20,FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Page_Record View - test_automation_record/div_test_automation_record'), 
        5,FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.comment('found records with search term=' + search_term)
}
