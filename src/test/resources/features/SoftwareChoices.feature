@ITSC
Feature: Software Choices

  # Get onto the page
  Background:
    Given On the feature switch page I check features
      | Beta Features |
    And I navigate to the Software Choices home page
    Then I am on the Software Choices home page
    And I am presented with a list of 4 vendors

  # Search bar
  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    And I wait for the software vendor list to update
    Then I am presented with a list of vendors matching 'test software vendor name one'

  # Pricing checkboxes
  Scenario: User filters for a free trial
    When I select the 'Free trial' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Free trial'

  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Free version'

  # Income type checkboxes
  Scenario: User filters for sole trader
    When I select the 'Sole trader' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Sole trader'

  Scenario: User filters for UK property
    When I select the 'UK property' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'UK property'

  Scenario: User filters for overseas property
    When I select the 'Overseas property' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Overseas property'

  # Business type checkboxes
  Scenario: User filters for a individual
    When I select the 'Individual' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Individual'

  Scenario: User filters for a agent
    When I select the 'Agent' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Agent'

  # Compatible with checkboxes
  Scenario: User filters for compatible with Microsoft Windows
    When I select the 'Microsoft' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Microsoft Windows'

  Scenario: User filters for compatible with Mac OS
    When I select the 'Mac OS' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Mac OS'

  # Mobile app checkboxes
  Scenario: User filters for compatible with Android
    When I select the 'Android' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Android'

  Scenario: User filters for compatible with Apple iOS
    When I select the 'Apple iOS' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'iOS'

  # Software type checkboxes
  Scenario: User filters for compatible with browser based
    When I select the 'Browser based' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Browser based'

  Scenario: User filters for compatible with application based
    When I select the 'Application based' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Application based'

  # Software for checkboxes
  Scenario: User filters for compatible with record keeping
    When I select the 'Record keeping' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Record keeping'

  Scenario: User filters for compatible with bridging
    When I select the 'Bridging' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Bridging'

  # Software compatibility checkboxes
  Scenario: User filters for VAT
    When I select the 'VAT' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'VAT'

  # Accessibility needs checkboxes
  Scenario: User filters for compatible with Visual accessibility needs
    When I select the 'Visual' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Visual'

  Scenario: User filters for compatible with Hearing accessibility needs
    When I select the 'Hearing' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Hearing'

  Scenario: User filters for compatible with Motor accessibility needs
    When I select the 'Motor' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Motor'

  Scenario: User filters for compatible with Cognitive accessibility needs
    When I select the 'Cognitive' checkbox
    And I click to apply filters
    Then I am presented with a list of 2 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Cognitive'

  # Multiple filters
  Scenario: User filters for a free trial AND a free version
    When I select the 'Free trial' checkbox
    When I select the 'Free version' checkbox
    And I click to apply filters
    Then I am presented with a list of 1 vendors
    And I click on the first vendor
    And I wait for the details page to load
    And The page contains the label for 'Free trial'
    And The page contains the label for 'Free version'

  # Clear filters
  Scenario: User clears filters
    Given I have selected all filters
    When I click to clear filters
    Then There are no selected filters
    And I am presented with a list of 4 vendors