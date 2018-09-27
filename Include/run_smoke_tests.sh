#!/bin/bash
echo wakeUp Mac now
java -jar ~/Katalon\ Studio/HCI_Group/wakeUpMac_sikuli.jar

echo keep machine from sleeping
if pgrep -x "caffeinate" > /dev/null
then
    echo "caffeinate already running"
else
    echo "caffeinate Stopped, run it now"
    caffeinate -dim&
fi

echo keep jenkins process is running
if ps -Af | grep "jenkins" | grep -v grep | awk '{print$2}' > /dev/null
then
    echo "jenkins already running"
else
    echo "jenkins Stopped, run it now"
    java -jar ~/Katalon\ Studio/HCI_Group/Drivers/jenkins.war &
fi



#echo run katalon 5.7 in /Applications/
#cd /Applications/

echo run katalon 5.7 in ~/Desktop/
cd ~/Desktop/

echo make sure using absolute path for -projectPath

#echo run all smoke tests on dev sites 
#./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/smoke_test_collection_dev_ALL" 

#echo run all smoke tests on production sites
#./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/smoke_test_collection_production_ALL"
#######################
echo run all smoke tests on production and training sites for 7.0 rollout

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_0" 

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_A"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_B"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_C"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="/Users/jcfu/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_D"
#######################



killall -9 caffeinate

echo backup and sync up test scripts
mkdir ~/backup
rsync -av  ~/Katalon\ Studio/HCI_Group/*  ~/backup/
#cp -r ~/Katalon\ Studio/HCI_Group/* ~/backup/
