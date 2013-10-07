#!/bin/bash

#Start Mongo
cd /c/dev/dev_tools/mongo/mongodb-win32-x86_64-2.0.0/bin
./mongod --dbpath=../data/db &

#Start Tomcat
cd /c/dev/dev_tools/apache-tomcat-7.0.22/bin
./startup.sh &


