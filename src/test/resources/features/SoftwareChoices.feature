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
    And I am on the additional income page, I select the following incomes and click continue
      | UK interest                  |
      | Construction Industry Scheme |
      | Employment (PAYE)            |
      | UK dividends                 |
      | State pension income         |
      | Private pension incomes      |
      | Foreign dividends            |
      | Foreign interest             |
    And I am on the other items page, I select the following other items and click continue
      | Private pension contributions        |
      | Charitable giving                    |
      | Capital Gains Tax                    |
      | Student Loan                         |
      | Marriage Allowance                   |
      | Voluntary Class 2 National Insurance |
      | High Income Child Benefit Charge     |
    And I am on the accounting period page, I select '6 April to 5 April', and click continue
    And On the search software page, I click on the vendor link: 1
    Then I am on the product details page for vendor: 'test software vendor name one'

  Scenario: User has an unsupported accounting period
    When I am on the business income page, I select the following business income and click continue
      | Self-employment |
    And I am on the additional income page, I select 'None of these' and click continue
    And I am on the other items page, I select 'None of these' and click continue
    And I am on the accounting period page, I select 'Neither of these', and click continue
    And I am on the unsupported accounting period page