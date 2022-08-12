#!/bin/bash

mvn clean package
PORT=$1
java -cp ./output_jars/module_one-1.0-SNAPSHOT.jar:./output_jars/module_two-1.0-SNAPSHOT.jar:./output_jars/module_three-1.0-SNAPSHOT.jar com.mkdirjava.Entry
