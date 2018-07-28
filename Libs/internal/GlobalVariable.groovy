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
     * <p></p>
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
     * <p>Profile default : CP-Hazard, CP-OMS</p>
     */
    public static Object G_MAKE_MAS_title
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['G_image_path' : '/Users/jcfu/Katalon Studio/HCI_Group/cp_hazard.sikuli/', 'G_MAKE_MAS_url' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'G_timeout' : 30, 'G_wait_s' : 2, 'G_wait_m' : 5, 'G_wait_l' : 10, 'smartcard_login_button' : 'G_image_path+\'smartcard_login_button.png\'', 'G_userPin' : '10051965', 'G_dagger_server_url' : 'https://dig-it-dev.nas.nasa.gov/dig_it-server/services/', 'G_git_hash_ver' : 'debf133', 'G_permitted_browser' : 'Firefox/(?![123456789]\\.)|Trident/[78]|Chrome|Safari', 'G_tag_ver' : '21303', 'userPin2' : '108676523', 'userPin3' : '10062016', 'cp_oms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_oms_dev/', 'cp_hazard_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/react_cp_hazard_dev/', 'cp_lms_dev' : 'https://mas-dev.nas.nasa.gov/MAKE-MAS/mas/cp_lms_dev/', 'G_MAKE_MAS_title' : 'CP-OMS'])
        
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
