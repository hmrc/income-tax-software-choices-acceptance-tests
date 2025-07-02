# Income-Tax-Software-Choices-Acceptance-Tests

This repo contains the acceptance tests for the income tax subscription service.

- [Prerequisites](#Prerequisites)
- [Running the tests](#Running-the-tests)
- [How to use](#How-to-use)


## Prerequisites

Start the services `sm2 --start ITSA_SOFTWARE_CHOICES_ALL`
* Additional sm parameters such as `--offline` can be added if desired

## Running the tests

#### Running the Journey tests
```
./run_tests.sh
```

**Running a set of tests**

Many of the tests are tagged with feature set tags such as `@Filters`

To run a single tag:
```
./run_tests.sh chrome local true @desiredTag
```

To run multiple tags:

```
./run_tests.sh chrome local true "@Filters or @SoftwareChoices"
./run_tests.sh chrome local true "@Filters and @SoftwareChoices"
```

**Running tests without headless mode**

In order to run the tests in non-headless mode, you can set the third parameter to the script as false.

```
./run_tests.sh chrome local false
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

