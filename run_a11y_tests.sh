#!/bin/bash

echo "Running a11y tests"
sbt -Dbrowser=remote-chrome -Denvironment=local "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner"
