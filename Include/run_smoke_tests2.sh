#!/bin/bash

echo set the HOME variable to your home directory where the test project HCI_Group located 
echo need to change to your own user name for the home directory
HOME="/Users/jcfu"

echo This is your katalon test project path
echo "$HOME/Katalon Studio/HCI_Group/HCI_Group.prj"

echo keep machine from sleeping before running test
if pgrep -x "caffeinate" > /dev/null
then
    echo "caffeinate already running"
else
    echo "caffeinate Stopped, run it now"
    caffeinate -dim&
fi

#echo run katalon studio app in ~/Desktop/
#cd ~/Desktop/

echo run katalon studio app in /Applications/
cd /Applications/

echo make sure using absolute path for -projectPath

#echo run all smoke tests on all dev sites 
#./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/smoke_test_collection_dev_ALL" 

#echo run all smoke tests on all production sites
#./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/smoke_test_collection_production_ALL"

#######################
echo run all smoke tests on production and training sites for 7.0 rollout

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_0" 

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_A"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_B"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_C"

./Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -consoleLog -projectPath="$HOME/Katalon Studio/HCI_Group/HCI_Group.prj" -retry=0 -testSuiteCollectionPath="Test Suites/7.0_Rollout/smoke_test_production_Group_D"
#######################

echo let the machine to rest after test run
killall -9 caffeinate

