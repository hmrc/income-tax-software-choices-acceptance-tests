@ITSC
@Filters
Feature: Filters

  # Get onto the page
  Background:
    Given I navigate to the software results page
    Then I am on the software results page
    And I am presented with a list of 4 vendors
    And There are no selected and enabled filters excluding extra pricing options and overseas property option

  # Pricing checkboxes
  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
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

  # Clear filters
  Scenario: User clears filters
    And I have selected all filters
    And I click on the apply filters button
    Then I am presented with a list of 1 vendors
    And I click the clear filters link
    And I am presented with a list of 4 vendors
