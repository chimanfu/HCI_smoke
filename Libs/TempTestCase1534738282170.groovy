import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())


RunConfiguration.setExecutionSettingFile('/var/folders/7z/2461lv392kb9sc0jhqtcqlbmp18sj6/T/Katalon/Test Cases/verify_CpHazard_AdvancedSearch_Linking (DVO, DMM, LCC, OMRS)/20180819_211122/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/verify_CpHazard_AdvancedSearch_Linking (DVO, DMM, LCC, OMRS)', new TestCaseBinding('Test Cases/verify_CpHazard_AdvancedSearch_Linking (DVO, DMM, LCC, OMRS)',[:]), FailureHandling.STOP_ON_FAILURE , false)
    