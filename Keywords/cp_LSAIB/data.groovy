package cp_LSAIB

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
	String LSAIB_Export_EM_1='LSAIB/LSAIB_Export_EM-1'
	String LSAIB_Export_AA_2='LSAIB/LSAIB_Export_AA-2'

	def get(name,row,def expected_results=null){
		println 'expected_results for LSAIB Export='+expected_results
		switch(expected_results) {
			case 'EM-1':
				expected_results=LSAIB_Export_EM_1
				break
			case 'AA-2':
				expected_results=LSAIB_Export_AA_2
				break
			case '':
				expected_results=LSAIB_Export_EM_1
				break
			case null:
				expected_results=LSAIB_Export_EM_1
				break
			default:
				expected_results=LSAIB_Export_EM_1
				break
		}
		println 'expected_results='+expected_results
		switch(name) {
			case 'Title':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'LSAIB Revision':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Product Number':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'CI/CSCI':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'As-Delivered NHA':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Product Title':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Product Revision':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'CR Number':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Directive Status':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Review Status':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Approving Directive':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'GSDO OPE':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Sensitivity':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Change Type':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Change':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Change Driver':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Program/Element':
				return(findTestData(expected_results).getValue(name, row)).trim()


			case 'OTRR Milestone':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Item Status':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Reference Information':
				return(findTestData(expected_results).getValue(name, row)).trim()

			case 'Doc Type':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Verification':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'IPCA CI ID':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Audit ID':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Created':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Created By':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Modified':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Modified By':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Board Date':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Item Type':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Path':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()
			case 'Link':
				return(findTestData(expected_results).getValue(name, row)).trim()




			default:
				println("The name is unknown");
				break;
		}
	}
}


