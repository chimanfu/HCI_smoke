import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/smoke_test_doctree')

suiteProperties.put('name', 'smoke_test_doctree')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/jcfu/Katalon Studio/HCI_Group/Reports/smoke_test_doctree/20180815_210010/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/smoke_test_doctree', suiteProperties, [new TestCaseBinding('Test Cases/login_basic_checks', 'Test Cases/login_basic_checks',  null), new TestCaseBinding('Test Cases/verify_create_page_loads', 'Test Cases/verify_create_page_loads',  null), new TestCaseBinding('Test Cases/verify_generate_PDF_from_record_page', 'Test Cases/verify_generate_PDF_from_record_page',  null), new TestCaseBinding('Test Cases/verify_run_keyword_search', 'Test Cases/verify_run_keyword_search',  null)])
