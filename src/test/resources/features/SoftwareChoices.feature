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
  Scenario: User filters for a free trail
    When I select the 'Free trial' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Free trial'

  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
    And I click to apply filters
    Then I am presented with a list of vendors which provide 'Free version'

  # Business type checkboxes


  # Compatible with checkboxes


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