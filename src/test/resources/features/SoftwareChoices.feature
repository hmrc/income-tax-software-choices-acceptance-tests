@ITSC

Feature: Software Choices

  # Get onto the page
  Background:
    Given I navigate to the Software Choices home page
    Then I am on the Software Choices home page

  # Search bar
  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    And I wait for the software vendor list to update
    Then I am presented with a list of vendors matching 'test software vendor name one'

  # Pricing checkboxes
  Scenario: User filters for a free trial
    When I select the 'Free trial' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Free trial'

  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Free version'

  # Business type checkboxes
  Scenario: User filters for a individual
    When I select the 'Individual' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Individual'

  Scenario: User filters for a agent
    When I select the 'Agent' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Agent'

  # Compatible with checkboxes
  Scenario: User filters for compatible with Microsoft Windows
    When I select the 'Microsoft' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Microsoft'

  Scenario: User filters for compatible with Mac OS
    When I select the 'Mac OS' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Mac OS'



  # Mobile app checkboxes


  # Software type checkboxes


  # Software compatibility checkboxes
  # will have to test differently to the rest as this information isn't on the vendor detail

  # Accessibility needs checkboxes


  # Clear filters
  Scenario: User clears filters
    Given I have selected all filters
    When I click to clear filters
    Then There are no selected filters