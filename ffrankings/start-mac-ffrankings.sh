#!/bin/bash

#Start Mongo
mongod --dbpath=/Users/rmcginnis/opt/mongodb/ffrankings &

#Start Tomcat
~/opt/apache-tomcat-7.0.42/bin/startup.sh &


