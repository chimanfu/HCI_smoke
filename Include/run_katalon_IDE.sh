#!/bin/bash

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
    java -jar /Users/jcfu/Downloads/jenkins.war &
fi

echo launch katalon IDE from ~/Desktop/
#cd /Applications/
cd ~/Desktop/
./Katalon\ Studio.app/Contents/MacOS/katalon &
