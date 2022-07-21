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
* MongoDB (*[See Persistence](#Persistence)*)
* HMRC Service manager (*[Install Service-Manager](https://github.com/hmrc/service-manager/wiki/Install#install-service-manager)*)
* Browser drivers (*[Browser drivers](#Browser-drivers)*)

## How to start

### Before running any tests

Start the services `./scripts/run_services`

Params:
* Additional sm parameters such as `--offline` can be added if desired

### Scripts

#### Running the Journey tests
```
./scripts/run_tests
```

Params:
* `-t=@customTag` or `--tags=@customTag` to specify which tags to run, add `~` in from of the tag to ignore these tests (Default value `@ITSA`).
* `-b=chrome` or `--browser=chrome` to specify a browser (By default run tests in a headless environment).
* `--staging` to run tests against the staging environment.
* `--qa` to run tests against the QA environment.

Example:

*Run tests with custom tag in the Chrome browser against the staging environment.*
```
./scripts/run_tests --tags=@customTag --browser=chrome --staging
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

More details [here](./docs/acceptance-tests.md#Installing-local-driver-binaries)

## Persistence

Data is stored as key/value in Mongo DB. See json reads/writes implementations (especially tests) for details.

To connect to the mongo db provided by docker (recommended) please use

```
docker exec -it mongo-db mongosh
```

Various commands are available.  Start with `show dbs` to see which databases are populated.
