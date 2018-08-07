package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_image_path
     
    /**
     * <p>Profile cofr_dev : PASS smoke test
Profile cp_dmm_dev : PASS smoke test
Profile cp_fmea_cil_dev : PASS smoke test
Profile cp_hazard_dev : PASS smoke test
Profile cp_id_dev : PASS smoke test
Profile cp_inventory_dev : PASS smoke test
Profile cp_praca_dev : PASS smoke test
Profile dex_dev : PASS smoke test
Profile doctree_dev : PASS smoke test
Profile etasksheet_dev2 : PASS smoke test
Profile evat_dev : PASS smoke test
Profile fiqs_dev : PASS smoke test
Profile gmip_dev : PASS smoke test
Profile human_capital_dev : PASS smoke test
Profile iss_fmea_dev : PASS smoke test
Profile iss_hazard_dev : PASS smoke test
Profile iss_part_dev : PASS smoke test
Profile mcard_dev : PASS smoke test
Profile ocad_dev : PASS smoke test
Profile practis_dev : PASS smoke test
Profile react_cp_hazard_dev : PASS smoke test
Profile wstf_dev : PASS smoke test</p>
     */
    public static Object G_MAKE_MAS_url
     
    /**
     * <p></p>
     */
    public static Object G_timeout
     
    /**
     * <p></p>
     */
    public static Object G_wait_s
     
    /**
     * <p></p>
     */
    public static Object G_wait_m
     
    /**
     * <p></p>
     */
    public static Object G_wait_l
     
    /**
     * <p></p>
     */
    public static Object smartcard_login_button
     
    /**
     * <p></p>
     */
    public static Object G_userPin
     
    /**
     * <p></p>
     */
    public static Object G_dagger_server_url
     
    /**
     * <p></p>
     */
    public static Object G_git_hash_ver
     
    /**
     * <p></p>
     */
    public static Object G_permitted_browser
     
    /**
     * <p></p>
     */
    public static Object G_tag_ver
     
    /**
     * <p></p>
     */
    public static Object userPin2
     
    /**
     * <p></p>
     */
    public static Object userPin3
     
    /**
     * <p></p>
     */
    public static Object cp_oms_dev
     
    /**
     * <p></p>
     */
    public static Object cp_hazard_dev
     
    /**
     * <p></p>
     */
    public static Object cp_lms_dev
     
    /**
     * <p>Profile default : CP-Hazard, CP-OMS
Profile arc_praca_dev : CP-Hazard, CP-OMS
Profile cofr_dev : CP-Hazard, CP-OMS
Profile cp_dmm_dev : CP-Hazard, CP-OMS
Profile cp_fmea_cil_dev : CP-Hazard, CP-OMS
Profile cp_hazard_dev : CP-Hazard, CP-OMS
Profile cp_id_dev : CP-Hazard, CP-OMS
Profile cp_inventory_dev : CP-Hazard, CP-OMS
Profile cp_lms_dev : CP-Hazard, CP-OMS
Profile cp_oms_dev : CP-Hazard, CP-OMS
Profile cp_praca_dev : CP-Hazard, CP-OMS
Profile dex_dev : CP-Hazard, CP-OMS
Profile doctree_dev : CP-Hazard, CP-OMS
Profile etasksheet_dev2 : CP-Hazard, CP-OMS
Profile evat_dev : CP-Hazard, CP-OMS
Profile fiqs_dev : CP-Hazard, CP-OMS
Profile gmip_dev : CP-Hazard, CP-OMS
Profile human_capital_dev : CP-Hazard, CP-OMS
Profile iss_fmea_dev : CP-Hazard, CP-OMS
Profile iss_hazard_dev : CP-Hazard, CP-OMS
Profile iss_part_dev : CP-Hazard, CP-OMS
Profile krampmasenstein_dev : CP-Hazard, CP-OMS
Profile mcard_dev : CP-Hazard, CP-OMS
Profile ocad_dev : CP-Hazard, CP-OMS
Profile practis_dev : CP-Hazard, CP-OMS
Profile react_arcjetdb_dev : CP-Hazard, CP-OMS
Profile react_cp_hazard_dev : CP-Hazard, CP-OMS
Profile react_iss_hazard_dev : CP-Hazard, CP-OMS
Profile rheo_dev_qa : CP-Hazard, CP-OMS
Profile rheo_stage : CP-Hazard, CP-OMS
Profile sims_dev : CP-Hazard, CP-OMS
Profile ssma_dev : CP-Hazard, CP-OMS
Profile wstf_dev : CP-Hazard, CP-OMS</p>
     */
    public static Object G_MAKE_MAS_title
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/sims_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'SIMS'])
        allVariables.put('arc_praca_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/arc_praca_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cofr_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cofr_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_dmm_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_dmm_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_fmea_cil_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_fmea_cil_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_hazard_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_hazard_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_id_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_id_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_inventory_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_inventory_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_lms_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('cp_oms_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-OMS'])
        allVariables.put('cp_praca_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_praca_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('dex_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/dex_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('doctree_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/doctree_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('etasksheet_dev2', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/etasksheet_dev2', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('evat_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/evat_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('fiqs_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/fiqs_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('gmip_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/gmip_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('human_capital_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/human_capital_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('iss_fmea_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_fmea_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('iss_hazard_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_hazard_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('iss_part_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/iss_part_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('krampmasenstein_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/krampmasenstein_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'SIMS'])
        allVariables.put('mcard_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/mcard_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('ocad_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/ocad_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('practis_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/practis_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('react_arcjetdb_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_arcjetdb_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('react_cp_hazard_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('react_iss_hazard_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_iss_hazard_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server-vmdb/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[5678]|Chrome', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'ISS Hazard'])
        allVariables.put('rheo_dev_qa', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-stage.nas.nasa.gov/MAKE-MAS/mas/rheo_dev_qa/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'SIMS'])
        allVariables.put('rheo_stage', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/rheo_stage_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'SIMS'])
        allVariables.put('sims_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/sims_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        allVariables.put('ssma_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/ssma_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'SIMS'])
        allVariables.put('wstf_dev', allVariables['default'] + ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/wstf_dev', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : '48654b9', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : 'develop HEAD (21372)', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-Hazard'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        G_image_path = selectedVariables['G_image_path']
        G_MAKE_MAS_url = selectedVariables['G_MAKE_MAS_url']
        G_timeout = selectedVariables['G_timeout']
        G_wait_s = selectedVariables['G_wait_s']
        G_wait_m = selectedVariables['G_wait_m']
        G_wait_l = selectedVariables['G_wait_l']
        smartcard_login_button = selectedVariables['smartcard_login_button']
        G_userPin = selectedVariables['G_userPin']
        G_dagger_server_url = selectedVariables['G_dagger_server_url']
        G_git_hash_ver = selectedVariables['G_git_hash_ver']
        G_permitted_browser = selectedVariables['G_permitted_browser']
        G_tag_ver = selectedVariables['G_tag_ver']
        userPin2 = selectedVariables['userPin2']
        userPin3 = selectedVariables['userPin3']
        cp_oms_dev = selectedVariables['cp_oms_dev']
        cp_hazard_dev = selectedVariables['cp_hazard_dev']
        cp_lms_dev = selectedVariables['cp_lms_dev']
        G_MAKE_MAS_title = selectedVariables['G_MAKE_MAS_title']
        
    }
}
