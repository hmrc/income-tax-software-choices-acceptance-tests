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
    And I am on the other items page, I select the following other items and click continue
      | Private pension contributions        |
      | Charitable giving                    |
      | Capital Gains Tax                    |
      | Student Loan                         |
      | Marriage Allowance                   |
      | Voluntary Class 2 National Insurance |
      | High Income Child Benefit Charge     |
    And On the search software page, I click on the vendor link: 1
    Then I am on the product details page for vendor: 'test software vendor name one'
