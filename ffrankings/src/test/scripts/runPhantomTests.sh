#!/bin/sh

# Should also consider phantomas - http://calendar.perfplanet.com/2013/phantomas/
$1/runYslow.sh $1 $2 $3 $4
$1/runLoadreport.sh $1 $2 $3 $4

