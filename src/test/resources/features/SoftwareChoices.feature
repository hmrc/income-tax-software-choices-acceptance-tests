@ITSC

Feature: Software Choices

  Background:
    Given I navigate to the Software Choices home page
    Then I am on the Software Choices home page

  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    And I wait for the software vendor list to update
    Then I am presented with a list of vendors matching 'test software vendor name one'