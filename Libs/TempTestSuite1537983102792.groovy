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
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/jcfu/Katalon Studio/HCI_Group/Reports/smoke_test/20180926_103142/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/smoke_test', suiteProperties, [new TestCaseBinding('Test Cases/verify_disallow_record_modification_checked', 'Test Cases/verify_disallow_record_modification_checked',  null), new TestCaseBinding('Test Cases/login_basic_checks', 'Test Cases/login_basic_checks',  null), new TestCaseBinding('Test Cases/verify_MAS_site_logo', 'Test Cases/verify_MAS_site_logo',  null), new TestCaseBinding('Test Cases/verify_help_documentation_loads', 'Test Cases/verify_help_documentation_loads',  null), new TestCaseBinding('Test Cases/verify_correct_git_hash', 'Test Cases/verify_correct_git_hash',  null), new TestCaseBinding('Test Cases/verify_correct_tag', 'Test Cases/verify_correct_tag',  null), new TestCaseBinding('Test Cases/verify_record_loading_on_tabs', 'Test Cases/verify_record_loading_on_tabs',  null), new TestCaseBinding('Test Cases/verify_all_new_record_pages_loading', 'Test Cases/verify_all_new_record_pages_loading',  null), new TestCaseBinding('Test Cases/verify_add_new_record_if_not_exist', 'Test Cases/verify_add_new_record_if_not_exist',  null), new TestCaseBinding('Test Cases/verify_run_keyword_search', 'Test Cases/verify_run_keyword_search',  null), new TestCaseBinding('Test Cases/verify_run_saved_search', 'Test Cases/verify_run_saved_search',  null), new TestCaseBinding('Test Cases/verify_advanced_search', 'Test Cases/verify_advanced_search',  null), new TestCaseBinding('Test Cases/verify_linking_config_on_record', 'Test Cases/verify_linking_config_on_record',  null), new TestCaseBinding('Test Cases/verify_mail_search_result_to_team_member', 'Test Cases/verify_mail_search_result_to_team_member',  null), new TestCaseBinding('Test Cases/verify_generate_PDF_from_record_page', 'Test Cases/verify_generate_PDF_from_record_page',  null), new TestCaseBinding('Test Cases/verify_generate_diff_report_on_record', 'Test Cases/verify_generate_diff_report_on_record',  null), new TestCaseBinding('Test Cases/verify_generate_diff_report_on_advancedSearch', 'Test Cases/verify_generate_diff_report_on_advancedSearch',  null), new TestCaseBinding('Test Cases/verify_permittedBrowsers', 'Test Cases/verify_permittedBrowsers',  null), new TestCaseBinding('Test Cases/verify_bad_browser_blurb', 'Test Cases/verify_bad_browser_blurb',  null), new TestCaseBinding('Test Cases/verify_daggr_server', 'Test Cases/verify_daggr_server',  null), new TestCaseBinding('Test Cases/verify_dagger_linking_config', 'Test Cases/verify_dagger_linking_config',  null), new TestCaseBinding('Test Cases/run_sanityCheck', 'Test Cases/run_sanityCheck',  null), new TestCaseBinding('Test Cases/verify_cp_hazard_OMRS-Linking', 'Test Cases/verify_cp_hazard_OMRS-Linking',  null), new TestCaseBinding('Test Cases/verify_cp_hazard_Search_SLSIntegratedCauses', 'Test Cases/verify_cp_hazard_Search_SLSIntegratedCauses',  null), new TestCaseBinding('Test Cases/verify_cp_hazard_DMM-Linking', 'Test Cases/verify_cp_hazard_DMM-Linking',  null), new TestCaseBinding('Test Cases/verify_cp_hazard_DVO-Linking', 'Test Cases/verify_cp_hazard_DVO-Linking',  null), new TestCaseBinding('Test Cases/verify_cp_hazard_LCC-Linking', 'Test Cases/verify_cp_hazard_LCC-Linking',  null), new TestCaseBinding('Test Cases/verify_eCoFR_cp-hazard_integration', 'Test Cases/verify_eCoFR_cp-hazard_integration',  null), new TestCaseBinding('Test Cases/verify_eCoFR_cp-inventory_integration', 'Test Cases/verify_eCoFR_cp-inventory_integration',  null), new TestCaseBinding('Test Cases/verify_eCoFR_CP-LCC_integration', 'Test Cases/verify_eCoFR_CP-LCC_integration',  null), new TestCaseBinding('Test Cases/verify_eCoFR_CP-OMRS_integration', 'Test Cases/verify_eCoFR_CP-OMRS_integration',  null), new TestCaseBinding('Test Cases/verify_iss_fmea_linking_config', 'Test Cases/verify_iss_fmea_linking_config',  null), new TestCaseBinding('Test Cases/verify_iss_fmea_VMDB_Integration', 'Test Cases/verify_iss_fmea_VMDB_Integration',  null), new TestCaseBinding('Test Cases/verify_iss_hazard_H2O_Integration', 'Test Cases/verify_iss_hazard_H2O_Integration',  null), new TestCaseBinding('Test Cases/verify_iss_hazard_VMDB_Integration', 'Test Cases/verify_iss_hazard_VMDB_Integration',  null), new TestCaseBinding('Test Cases/verify_iss_hazard_attachments_return', 'Test Cases/verify_iss_hazard_attachments_return',  null), new TestCaseBinding('Test Cases/verify_iss_ocad_linked_controls_widget', 'Test Cases/verify_iss_ocad_linked_controls_widget',  null), new TestCaseBinding('Test Cases/verify_iss_part_VMDB_Integration', 'Test Cases/verify_iss_part_VMDB_Integration',  null), new TestCaseBinding('Test Cases/verify_mcard_VMDB_Cradle_Integration', 'Test Cases/verify_mcard_VMDB_Cradle_Integration',  null)])
