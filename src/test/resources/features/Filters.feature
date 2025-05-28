@ITSC
@Filters
Feature: Filters

  # Get onto the page
  Background:
    And I navigate to the Software Choices home page
    Then I am on the Software Choices home page
    And I am presented with a list of 4 vendors
    And There are no selected and enabled filters excluding extra pricing options and overseas property option

  # Search bar
  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    Then I click on the search button
    Then I am presented with a list of vendors matching 'test software vendor name one'

  # Pricing checkboxes
  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
    Then I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Type of software checkboxes
  Scenario: User filters for Software for record keeping
    When I select the 'Record keeping' checkbox
    Then I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with bridging
    When I select the 'Bridging' checkbox
    Then I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Software compatibility checkboxes
  Scenario: User filters for VAT
    When I select the 'VAT' checkbox
    Then I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Accessibility features checkboxes
  Scenario: User filters for compatible with Blindness or impaired vision accessibility features
    And I select the 'Blindness or impaired vision' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Deafness or impaired hearing accessibility features
    And I select the 'Deafness or impaired hearing' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Motor or physical difficulties accessibility features
    And I select the 'Motor or physical difficulties' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Cognitive impairments accessibility features
    And I select the 'Cognitive impairments' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Accounting period checkboxes
  Scenario: User filters for compatible with 6th April to 5th April
    And I select the '6th April to 5th April' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with 1st April to 31st March
    And I select the '1st April to 31st March' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Business income sources
  Scenario: User filters for compatible with Self-employment
    And I select the 'Self-employment' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with UK property
    And I select the 'UK property' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Foreign property
    And I select the 'Foreign property' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Personal income sources
  Scenario: User filters for compatible with Construction industry scheme (CIS)
    And I select the 'Construction industry scheme (CIS)' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Capital Gains Tax
    And I select the 'Capital Gains Tax' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Employment
    And I select the 'Employment' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Foreign Income
    And I select the 'Foreign Income' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with UK Dividends
    And I select the 'UK Dividends' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with UK interest
    And I select the 'UK interest' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Deductions
  Scenario: User filters for compatible with Charitable giving
    And I select the 'Charitable giving' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with High Income Child Benefit Charge
    And I select the 'High Income Child Benefit Charge' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Student loans
    And I select the 'Student loans' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Voluntary Class 2 National Insurance
    And I select the 'Voluntary Class 2 National Insurance' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Pensions
  Scenario: User filters for compatible with State pension income
    And I select the 'State pension income' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Private pension income
    And I select the 'Private pension income' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  Scenario: User filters for compatible with Payments into a private pension
    And I select the 'Payments into a private pension' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Allowances
  Scenario: User filters for compatible with Marriage Allowance
    And I select the 'Marriage Allowance' checkbox
    And I click on the apply filters button
    Then I am presented with a list of 2 vendors

  # Clear filters
  Scenario: User clears filters
    And I have selected all filters
    And I click on the apply filters button
    Then I am presented with a list of 1 vendors
    And I click the clear all filters link
    And I am presented with a list of 4 vendors
