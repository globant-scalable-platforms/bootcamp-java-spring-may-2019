#!/usr/bin/env bash

# Compile projects
echo "------ Compiling Parent ------"
sudo ./ParentProject/gradlew build

echo "------ Compiling Child ------"
sudo ./ChildProject/gradlew build

# Execute project
echo "------ Executing TestMain from jar ------"
java -jar ChildProject/build/libs/ChildProject.jar
