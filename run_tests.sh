#!/bin/bash -e

BROWSER=${1:-chrome}
ENVIRONMENT=${2:-local}
HEADLESS=${3:-true}
TAGS=$4

sbt scalafmtCheckAll scalafmtSbtCheck
if [ -z "$TAGS" ]; then
  sbt  -Dbrowser="$BROWSER" -Denvironment="$ENVIRONMENT" -Dbrowser.option.headless="$HEADLESS" test testReport
else
  sbt  -Dbrowser="$BROWSER" -Denvironment="$ENVIRONMENT" -Dbrowser.option.headless="$HEADLESS" "testOnly uk.gov.hmrc.test.ui.specs.* -- -n $TAGS" testReport
fi