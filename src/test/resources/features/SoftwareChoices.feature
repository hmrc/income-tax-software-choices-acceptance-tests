@ITSC
@SoftwareChoices
Feature: Software Choices

  Background:
    Given I navigate to the business income page

  Scenario: User answers pre-search questions and finds out more information about software vendor 1
    When I am on the business income page, I select the following business income and click continue
      | Self-employment  |
      | UK property      |
      | Foreign property |
    And On the additional income page, I select the following incomes and click continue
      | UK interest                  |
      | Construction Industry Scheme |
      | Employment (PAYE)            |
      | UK dividends                 |
      | State pension income         |
      | Private pension incomes      |
      | Foreign dividends            |
      | Foreign interest             |
    And On the search software page, I click on the vendor link: 1
    Then I am on the product details page for vendor: 'test software vendor name one'
