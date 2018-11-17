import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//takingScreenshot()
takingScreenshot('abc')
takingScreenshot('abc','hello')
def takingScreenshot(screenshotname,def hello=null){
if (screenshotname.equals(null) ||screenshotname.equals('')){
	screenshotname='screenshot'
	
}
println screenshotname
println hello
}