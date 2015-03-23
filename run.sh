#!/usr/bin/env bash

# example of the run script for running the word count

# first I'll load all my dependencies
apt-get install openjdk-7-jdk openjdk-7-jre

# next I'll make sure that all my programs (written in Python in this example) have the proper permissions
chmod a+x ./src/WordCount.java
chmod a+x ./src/MedianCal.java

# finally I'll execute my programs, with the input directory wc_input and output the files in the directory wc_output
javac ./src/WordCount.java
javac ./src/MedianCal.java

java ./src/WordCount ./wc_input ./wc_output/wc_result.txt
java ./src/MedianCal ./wc_input ./wc_output/med_result.txt