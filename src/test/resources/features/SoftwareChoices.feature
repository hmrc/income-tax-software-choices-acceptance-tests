@ITSC
@SoftwareChoices
Feature: Software Choices

  Background:
    And I navigate to the Software Choices home page

  Scenario: User finds out more information about software vendor 1
    Given I am on the Software Choices home page
    When I click on the vendor link: 1
    Then I am on the product details page for vendor: 'test software vendor name one'
