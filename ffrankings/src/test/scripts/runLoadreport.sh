#!/bin/sh


die () {
    echo >&2 "$@"
    exit 1
}

[ "$#" -eq 4 ] || die "The following arguments required <path_to_loadreport.js> <url> <path_to_results> <report_name>, $# provided;"


LOADREPORT_LOC=$1
URL=$2
REPORT_NAME=$4
REPORT_LOC=$3

mkdir $REPORT_LOC

COMMAND="phantomjs $LOADREPORT_LOC/loadreport.js $URL performance junit $REPORT_LOC $REPORT_NAME $LOADREPORT_LOC/config.json"

echo "Running $COMMAND"
$COMMAND 
