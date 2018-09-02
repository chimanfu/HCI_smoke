import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
String testsuiteName
String testsuitePath='krampmasenstein_dev/Internal Linking/'

// select_testsuite 'Internal_Linking' from TAB Basic Information of the record to be tested on
WebUI.callTestCase(findTestCase(testsuitePath+'select_testsuite_Internal_Linking'),[('group-to-group-test') : testsuiteName])

/* 
 testsuite: add groups and links
 
 add 2 Parent_Groups (GROUP_PRNT-1, GROUP_PRNT-2)
 add 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-1
 add 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-2
 */
WebUI.callTestCase(findTestCase(testsuitePath+'add_2_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_4_CHLD_Groups_on_reuse_Linked_GROUP_1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_4_CHLD_Groups_on_reuse_Linked_GROUP_2'),[('group-to-group-test') : testsuiteName])

/* 
 testsuite: access group links
 
 access child_group_links GROUP-1_CHLD-[1,2,3,4] from parent group GROUP_PRNT-1
 access_parent_group_link_from child groups GROUP-2_CHLD-[1,2,3,4]
 */
WebUI.callTestCase(findTestCase(testsuitePath+'access_child_group_links_from_PRNT-1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'access_parent_group_link_from_CHLD-groups'),[('group-to-group-test') : testsuiteName])

/*
testsuite: add 6 parent groups GROUP_PRNT-[3,4,5,6,7,8] from child groups
*/
WebUI.callTestCase(findTestCase(testsuitePath+'add_6_G2G_Parent_Groups_from_child_groups'),[('group-to-group-test') : testsuiteName])
	
/*
testsuite: delete groups

delete 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-1
delete 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-2
delete 2 Parent_Groups (GROUP_PRNT-1, GROUP_PRNT-2)
delete 6 parent groups GROUP_PRNT-[3,4,5,6,7,8]
*/
WebUI.callTestCase(findTestCase(testsuitePath+'delete_4_CHLD_Groups_on_reuse_Linked_GROUP_1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_4_CHLD_Groups_on_reuse_Linked_GROUP_2'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_2_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_6_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
