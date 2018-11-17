package ip_permissions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class data {
	String ip_test_user_list='IHS_IP_permissions/international_partner_permissions_test_user_list'

	String expected_results_us_general='IHS_IP_permissions/expected_results_us (general)'
	String expected_results_us_VTL='IHS_IP_permissions/expected_results_us (VTL)'
	String expected_results_us_product='IHS_IP_permissions/expected_results_us (product)'
	String expected_results_us_template='IHS_IP_permissions/expected_results_us (template)'

	String expected_results_partner_general='IHS_IP_permissions/expected_results_partner (general)'
	String expected_results_partner_VTL='IHS_IP_permissions/expected_results_partner (VTL)'
	String expected_results_partner_product='IHS_IP_permissions/expected_results_partner (product)'
	String expected_results_partner_template='IHS_IP_permissions/expected_results_partner (template)'

	def get(name,row,def expected_results=null){
		println 'expected_results='+expected_results
		switch(expected_results) {
			case 'us_general':
				expected_results=expected_results_us_general
				break
			case 'us_VTL':
				expected_results=expected_results_us_VTL
				break
			case 'us_product':
				expected_results=expected_results_us_product
				break
			case 'us_template':
				expected_results=expected_results_us_template
				break
			case 'partner_general':
				expected_results=expected_results_partner_general
				break
			case 'partner_VTL':
				expected_results=expected_results_partner_VTL
				break
			case 'partner_product':
				expected_results=expected_results_partner_product
				break
			case 'partner_template':
				expected_results=expected_results_partner_template
				break
			case '':
				expected_results=ip_test_user_list
				break
			case null:
				expected_results=ip_test_user_list
				break
			default:
				expected_results=expected_results
				break
		}
		println 'expected_results='+expected_results
		switch(name) {
			case 'user_name':
				return(findTestData(expected_results).getValue('Name', row)).trim()
			case 'user_email':
				return(findTestData(expected_results).getValue('Email', row)).trim()
			case 'name_expected_results':
				return(findTestData(expected_results).getValue('Names', row)).trim()

			case 'checkboxes_selected':
				return(findTestData(expected_results).getValue('checkboxes_selected', row)).trim()
			case 'checkboxes_disabled':
				return(findTestData(expected_results).getValue('checkboxes_disabled', row)).trim()

			case 'checkboxes_visible':
				return(findTestData(expected_results).getValue('checkboxes_visible', row)).trim()

			case 'record_not_visible':
				return(findTestData(expected_results).getValue('record_not_visible', row)).trim()

			case 'xml':
				return(findTestData(expected_results).getValue('xml', row)).trim()

			case 'flags':
				return(findTestData(expected_results).getValue('flags', row)).trim()

			case 'group_names':
				return(findTestData(expected_results).getValue('xml', row)).trim()
			default:
				println("The value is unknown");
				break;
		}
	}
}
