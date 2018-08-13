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


suiteProperties.put('id', 'Test Suites/smoke_test')

suiteProperties.put('name', 'smoke_test')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/jcfu/Katalon Studio/HCI_Group/Reports/smoke_test/20180812_225525/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/smoke_test', suiteProperties, [new TestCaseBinding('Test Cases/login_basic_checks', 'Test Cases/login_basic_checks',  null), new TestCaseBinding('Test Cases/verify_permittedBrowsers', 'Test Cases/verify_permittedBrowsers',  null), new TestCaseBinding('Test Cases/verify_bad_browser_blurb', 'Test Cases/verify_bad_browser_blurb',  null), new TestCaseBinding('Test Cases/verify_MAS_site_logo', 'Test Cases/verify_MAS_site_logo',  null), new TestCaseBinding('Test Cases/verify_help_documentation_loads', 'Test Cases/verify_help_documentation_loads',  null), new TestCaseBinding('Test Cases/verify_daggr_server', 'Test Cases/verify_daggr_server',  null), new TestCaseBinding('Test Cases/verify_correct_git_hash', 'Test Cases/verify_correct_git_hash',  null), new TestCaseBinding('Test Cases/verify_correct_tag', 'Test Cases/verify_correct_tag',  null), new TestCaseBinding('Test Cases/verify_create_page_loads', 'Test Cases/verify_create_page_loads',  null), new TestCaseBinding('Test Cases/verify_add_new_record_if_not_exist', 'Test Cases/verify_add_new_record_if_not_exist',  null), new TestCaseBinding('Test Cases/verify_run_keyword_search', 'Test Cases/verify_run_keyword_search',  null), new TestCaseBinding('Test Cases/verify_run_saved_search', 'Test Cases/verify_run_saved_search',  null), new TestCaseBinding('Test Cases/verify_generate_PDF_from_record_page', 'Test Cases/verify_generate_PDF_from_record_page',  null), new TestCaseBinding('Test Cases/verify_mail_search_result_to_team_member', 'Test Cases/verify_mail_search_result_to_team_member',  null), new TestCaseBinding('Test Cases/verify_generate_diff_report', 'Test Cases/verify_generate_diff_report',  null), new TestCaseBinding('Test Cases/run_sanityCheck', 'Test Cases/run_sanityCheck',  null)])
