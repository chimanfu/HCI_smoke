import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.StringUtils;

import internal.GlobalVariable

println 'check_record_created should generate record url in GlobalVariable.recordName2'
//CustomKeywords.'helper.login.LoginHelper.login'()
String siteURL='https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_IP_auto_1/show_bug.cgi?id=7'
//String siteURL=WebUI.getUrl()
//siteURL=siteURL.substring(0,siteURL.lastIndexOf('#tv='))
		
GlobalVariable.recordName2=siteURL
KeywordUtil.logInfo 'current record url='+GlobalVariable.recordName2
CustomKeywords.'helper.login.LoginHelper.login'()

CustomKeywords.'ip_permissions.utils.closeExtraWindowTabs'()

