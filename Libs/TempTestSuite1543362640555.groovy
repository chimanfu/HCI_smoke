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


suiteProperties.put('id', 'Test Suites/IHS_IP_permissions_test/test_create_cause_from_hazard')

suiteProperties.put('name', 'test_create_cause_from_hazard')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/jcfu/Katalon Studio/HCI_Group/Reports/IHS_IP_permissions_test/test_create_cause_from_hazard/20181127_155040/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/IHS_IP_permissions_test/test_create_cause_from_hazard', suiteProperties, [new TestCaseBinding('Test Cases/IHS_IP_permissions/test_create_cause_from_hazard', 'Test Cases/IHS_IP_permissions/test_create_cause_from_hazard',  null)])
