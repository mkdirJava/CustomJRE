#!/bin/bash

mvn clean package
export PORT=$1
echo "running application on ${PORT}"
java -cp ./output_jars/module_one-1.0-SNAPSHOT.jar:./output_jars/module_two-1.0-SNAPSHOT.jar:./output_jars/module_three-1.0-SNAPSHOT.jar com.mkdirjava.Entry
