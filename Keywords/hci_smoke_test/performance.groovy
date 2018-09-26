package hci_smoke_test

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
import org.sikuli.script.App
import org.sikuli.script.KeyModifier
import org.sikuli.script.Screen
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class performance {


	@Keyword
	def get_average_scripting_time_loadingPage(int reload_times, String pageName){
		// Simple Peformance tests
		// based on Kevin's approach in https://docs.google.com/document/d/1DGDvkmqTtdsYkrLHaBTcbuaxA2YwBpaHIjuLLTVVj4k/edit#heading=h.qpkrro43rjvj

		/*
		 steps:
		 navigated to the page (record view, tab view, sanity check) that performance test will be run on
		 launch the devtool from Chrome
		 switch to Performance TAB
		 perform task to start profiling and reload page (how many times?)
		 get the scripting time on each page loading
		 get the average of all page loading times on (how many times?)
		 TBD:
		 set verification criteria?
		 run it on a task (record actions from devtool)
		 */

		//prerequite: should already navigated to the page (record view, tab view, sanity check) that performance test will be run on
		
		WebUI.comment 'will find the loading (scripting) time of '+pageName+' Page by getting average of reloading page '+reload_times+' times'
		//launch the devtool from Chrome
		Screen s = new Screen()
		App.focus('Google Chrome.app')

		if (s.exists(GlobalVariable.G_image_path+'performance_TAB.png',3)==null){
			WebUI.comment 'open devtool on chrome'
			s.type('i', KeyModifier.CMD+KeyModifier.ALT)
			WebUI.delay(1)
		}else{
			WebUI.comment 'devtool already open'
		}
		if (s.exists(GlobalVariable.G_image_path+'WhatsNew_TAB.png',3)!=null){
			s.click(s.find(GlobalVariable.G_image_path+'WhatsNew_TAB.png').right().find(GlobalVariable.G_image_path+'close_button.png'))
		}

		// switch to Performance TAB
		WebUI.comment 'switch to Performance TAB'
		s.wait(GlobalVariable.G_image_path+'performance_TAB.png',5)
		s.click(GlobalVariable.G_image_path+'performance_TAB.png')
		WebUI.delay(1)
		String clip, Scripting_time
		Float total_Scripting_time=0
		//int reload_times=5
		float[] time_load = new float[reload_times]
		for (number in 0..reload_times-1 ) {
			WebUI.comment 'reload page counter:'+(number+1)

			//WebUI.delay(1)
			WebUI.comment 'start profiling and reload page'
			s.type('E', KeyModifier.CMD )
			WebUI.delay(1)
			s.waitVanish(GlobalVariable.G_image_path+'stop_button.png',60)

			WebUI.comment 'get the summary data'
			s.wait(GlobalVariable.G_image_path+'Summary_TAB.png',5)
			//s.click(GlobalVariable.G_image_path+'Summary_TAB.png')

			s.click(s.find(GlobalVariable.G_image_path+'Summary_TAB.png').below(35))
			s.type("a", KeyModifier.CMD)
			WebUI.delay(1)
			s.type("c", KeyModifier.CMD)
			clip = App.getClipboard()
			//clip=clip.encode('ascii', 'ignore')
			clip=clip.replaceAll("[^\\p{ASCII}]", "")

			WebUI.comment "Performance Summary:"
			WebUI.comment clip
			Scripting_time=clip.substring(clip.indexOf('Loading')+7,clip.indexOf('msScripting')).trim()
			Float time_scripting=Float.parseFloat(Scripting_time)
			WebUI.comment 'reload page counter:'+(number+1)+',Scripting_time='+Scripting_time+' ms'
			time_load[number]=time_scripting
			total_Scripting_time=total_Scripting_time+time_scripting
		}

		Float average_Scripting_time=total_Scripting_time/reload_times
		for (number in 0..reload_times-1 ) {

			print 'reload page time '+(number+1)+' = '+time_load[number]+' ms\n'
		}
		WebUI.comment '----------------------------------------------------------------------------------------------------------------'
		WebUI.comment 'Average scripting time of reloading '+pageName+' Page of '+reload_times+' times = '+average_Scripting_time+' ms'
		WebUI.comment '----------------------------------------------------------------------------------------------------------------'
	}
}
