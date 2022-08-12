#!/bin/bash

mvn clean package
native-image -cp ./output_jars/module_one-1.0-SNAPSHOT.jar:./output_jars/module_two-1.0-SNAPSHOT.jar:./output_jars/module_three-1.0-SNAPSHOT.jar --enable-http --add-modules jdk.httpserver --no-fallback com.mkdirjava.Entry

export PORT=$1
echo "running application on ${PORT}"

./com.mkdirjava.entry
