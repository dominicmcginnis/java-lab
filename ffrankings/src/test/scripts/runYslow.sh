#!/bin/sh

CDN_LIST='"pbs.twimg.com, static.ak.facebook.com, fbstatic-a.akamaihd.net, cn.brcdn.com, cache15.stubhubstatic.com, cache14.stubhubstatic.com, cache13.stubhubstatic.com, cache12.stubhubstatic.com, cache11.stubhubstatic.com, cache1.stubhubstatic.com"'
THRESHOLD='{"ynumreq" : "B", "ycsstop" : "B", "yjsbottom" : "B", "yminify" : "B", "yno404" : "A"}'

die () {
    echo >&2 "$@"
    exit 1
}

[ "$#" -eq 4 ] || die "The following arguments required <path_to_yslow.js> <url> <path_to_results> <report_name>, $# provided;"


YSLOW_LOC=$1
URL=$2
REPORT_LOC=$3

REPORT_NAME=$4
REPORT=$REPORT_LOC/yslow-$REPORT_NAME.xml


mkdir $REPORT_LOC

COMMAND="phantomjs $YSLOW_LOC/yslow.js -f junit -i grade --cdns $CDN_LIST -t '$THRESHOLD' $URL"

echo "Running $COMMAND"
$COMMAND > $REPORT
sed -i ".bak" "/FAIL to load undefined/d" $REPORT
rm $REPORT.bak
