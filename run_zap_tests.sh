#!/bin/bash

echo "Running ZAP tests"
sbt -Dbrowser=remote-chrome -Denvironment=local "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner"
