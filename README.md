# Income-Tax-Software-Choices-Acceptance-Tests

This repo contains the acceptance tests for the income tax subscription service.

* [Quick start](#Quick-start)
 - [Prerequisites](#Prerequisites)
 - [How to start](#How-to-start)
 - [How to use](#How-to-use)
* [Step defs](#Step-defs)
* [Browser drivers](#Browser-drivers)
* [Persistence](#Persistence)

# Quick start

## Prerequisites

* [sbt](http://www.scala-sbt.org/)
* Either [docker-selenium-grid](https://github.com/hmrc/docker-selenium-grid) or [local-selenium-grid](https://github.com/hmrc/local-selenium-grid)
* HMRC Service manager (*[Install Service-Manager](https://github.com/hmrc/service-manager/wiki/Install#install-service-manager)*)

Also, possibly:
* Chromedriver

Chromedriver can be downloaded from https://chromedriver.chromium.org/downloads or installed with `brew install --cask chromedriver` and should be placed on your path.

You will need to "trust" chromedriver. Open with ctrl-click in Finder and follow the instructions.

## How to start

### Before running any tests

1. Start the services `sm2 --start ITSA_SOFTWARE_CHOICES_ALL`
* Additional sm parameters such as `--offline` can be added if desired

2. Start your chosen selenium grid by going to the repository and running the `./start.sh` script.

### Scripts

#### Running the Journey tests
```
./run_tests.sh
```

## How to use

### Choose which features to test
Add custom tags to features or scenarios.

* Tag a feature:
  *testName.feature*
```
@ITSA
@CustomTag
Feature: Description
# ...
```

* Tag a scenario:
  *testName.feature*
```
@ITSA
Feature: Description

@CustomTag
Scenario: Description
# ...
```

## Step defs

### Format

* We should try to keep things consistent throughout the feature files where possible
* Step definition parameters should be surrounded by single quotes
* Buttons in step definitions should be surrounded by doubles quotes
* Any step definition that doesn't contain an affinity group should work for both Agent and Individual features

```
I am on the 'Agent' Eligibility Terms page and click "Accept and continue"
```

## Browser drivers
### macOS
With Homebrew (*[Install Homebrew](https://github.com/Homebrew/install#install-homebrew-on-macos-or-linux)*):
```shell
# Chrome browser
brew install --cask chromedriver 
# Firefox browser
brew install geckodriver
```
