#!/bin/bash

listeningPort=$1

# delete the custom JRE if it exists
[ -d "customjre" ] && rm -rf customjre

# Build the jars in this multi module project
mvn clean package

# Create the custom JRE
echo "building a custom JRE"

jlink --module-path ./output_jars --add-modules module.one,module.two,module.three --strip-debug --compress=2 --no-header-files --no-man-pages --output customjre

echo "The size of the new JRE is:"
du -sh ./customjre/
echo "The size of the standard JRE is:"
du -sh $JAVA_HOME

echo "The Application is a web server and is listening on port ${listeningPort}"
echo "RAN THE MODULE AND THE OUTPUT IS:"
echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

# Run the module and its main class
export PORT=$listeningPort
./customjre/bin/java --module module.one/com.mkdirjava.Entry
