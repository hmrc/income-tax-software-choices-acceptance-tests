# income-tax-software-choices-acceptance-tests

This repo contains the acceptance tests for the income tax software choices frontend service.

- [Prerequisites](#Prerequisites)
- [Running the tests](#Running-the-tests)


## Prerequisites

Start the services `sm2 --start ITSA_SOFTWARE_CHOICES_ALL`
* Additional sm parameters such as `--offline` can be added if desired

## Running the tests

### Run all tests
```bash
./run_tests.sh
```
```
./run_tests.sh <browser> <environment> <headless> <optional tag>
```

**Running tests without headless mode**

In order to run the tests in non-headless mode, you can set the third parameter to the script as false.

```bash
./run_tests.sh chrome local false
```

### Run a set of tests

You can run a set of tests using tags, for example with the tag `<TagName>`
```
./run_tags.sh chrome local true TagName
```

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```
