#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2
HEADLESS=$3
TAGS=$4

sbt scalafmtCheckAll scalafmtSbtCheck
sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" -Dbrowser.option.headless="${HEADLESS:=true}" test testReport
