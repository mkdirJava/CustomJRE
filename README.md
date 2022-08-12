# CustomRuntime: Java 9 Playground

---

Prerequisites

1.  Maven 
2.  Java 17 installed

Aim:

1. To see what it looks like to develop Jars that are java 9 compliant
2. To build a minimalist JRE that has a http server

Run this command to build and run the custom JRE runtime.
Note this is a http server

```aidl
    ./createCustomJRE.sh <choice of port> 
```

There is also a script for running this as a normal java SE application

```aidl
    ./runAsNormalJar.sh
```