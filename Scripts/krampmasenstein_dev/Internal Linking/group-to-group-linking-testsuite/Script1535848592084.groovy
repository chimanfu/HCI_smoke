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

/* 
 * TEST SUITE: group-to-group-linking-testsuite
 * 
 * verify group to group linking features from test suite 'Internal Linking' in krampmasenstein_dev
 * verify add groups, delete groups, link groups, unlink groups among parent and child groups
 * fill in ALL fields contents and link records on a parent group (try out all fields automation)
 * 
 * testcases: setup test on krampmasenstein_dev
 * create a record (or reuse record 7081) in krampmasenstein_dev
 * select testsuite 'Internal_Linking' from TAB 'Basic Information' of the record to be tested on
 * 
 * testcases: add parent and child groups by using ‘reuse linked parent’ and ‘add linked parent’
 * add 2 parent groups (GROUP_PRNT-1, GROUP_PRNT-2)
 * add 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to parent group GROUP_PRNT-1
 * add 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to parent group GROUP_PRNT-2
 * add 6 parent groups GROUP_PRNT-[3,4,5,6,7,8] from child groups GROUP-1_CHLD-[1,2,3] and GROUP-2_CHLD-[1,2,3]
 * 
 * testcases: fill in all fields contents in groups
 * fill in ALL fields contents and link records on a parent group 
 * fill in ALL fields contents and link records on a child group 
 * 
 * testcases: access group links between parent and child groups
 * access child_group_links GROUP-1_CHLD-[1,2,3,4] from parent group GROUP_PRNT-1
 * access_parent_group_link_from child groups GROUP-2_CHLD-[1,2,3,4]
 * 
 * testcases: unlink child and parent groups
 * unlink 4 child groups from parent group
 * unlink 4 parent groups from child groups
 * 
 * testcases: delete child and parent groups
 * delete 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-1
 * delete 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-2
 * delete 2 Parent_Groups (GROUP_PRNT-1, GROUP_PRNT-2)
 * delete 6 parent groups GROUP_PRNT-[3,4,5,6,7,8]
 * 
 */

// select testsuite 'Internal_Linking' from TAB 'Basic Information' of the record to be tested on
WebUI.callTestCase(findTestCase(testsuitePath+'select_testsuite_Internal_Linking'),[('group-to-group-test') : testsuiteName])

return

/* 
 testsuite: add parent and child groups and reuse links with groups
 
 add 2 Parent_Groups (GROUP_PRNT-1, GROUP_PRNT-2)
 add 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-1
 add 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-2
 add 6 parent groups GROUP_PRNT-[3,4,5,6,7,8] from child groups with 'Add Linked Parent'
 */
WebUI.callTestCase(findTestCase(testsuitePath+'add_2_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_4_CHLD_Groups_on_reuse_Linked_GROUP_1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_4_CHLD_Groups_on_reuse_Linked_GROUP_2'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_6_G2G_Parent_Groups_from_child_groups'),[('group-to-group-test') : testsuiteName])

/* 
 testsuite: access group links between parent and child groups
 
 access child_group_links GROUP-1_CHLD-[1,2,3,4] from parent group GROUP_PRNT-1
 access_parent_group_link_from child groups GROUP-2_CHLD-[1,2,3,4]
 */
WebUI.callTestCase(findTestCase(testsuitePath+'access_child_group_links_from_PRNT-1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'access_parent_group_link_from_CHLD-groups'),[('group-to-group-test') : testsuiteName])

// fill in ALL fields contents and link_records_on a parent and child group (try out all fields automation)
WebUI.callTestCase(findTestCase(testsuitePath+'add_ALL_fields_contents_link_records_on_parent_group'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'add_ALL_fields_contents_link_records_on_child_group'),[('group-to-group-test') : testsuiteName])

/* 
 testsuite: unlink child and parent groups
 
 unlink 4 child groups from parent group
 unlink 4 parent groups from child groups
 */
WebUI.callTestCase(findTestCase(testsuitePath+'unlink_4_child_groups_from_parent_group'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'unlink_4_parent_groups_from_child_groups'),[('group-to-group-test') : testsuiteName])
/*
testsuite: delete child and parent groups

delete 4 child groups GROUP-1_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-1
delete 4 child groups GROUP-2_CHLD-[1,2,3,4] and reuse linked to GROUP_PRNT-2
delete 2 Parent_Groups (GROUP_PRNT-1, GROUP_PRNT-2)
delete 6 parent groups GROUP_PRNT-[3,4,5,6,7,8]
*/
WebUI.callTestCase(findTestCase(testsuitePath+'delete_4_CHLD_Groups_on_reuse_Linked_GROUP_1'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_4_CHLD_Groups_on_reuse_Linked_GROUP_2'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_2_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
WebUI.callTestCase(findTestCase(testsuitePath+'delete_6_G2G_Parent_Groups'),[('group-to-group-test') : testsuiteName])
