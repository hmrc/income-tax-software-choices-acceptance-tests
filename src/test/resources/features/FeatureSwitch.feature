@ITSC
@JUSTIN

Feature: Feature Switch

  # Get onto the page
  Background:
    Given I navigate to the Feature Switch page
    Then I am on the Feature Switch page

  Scenario: User checks the Beta Features checkbox
    When I check the 'Beta Features' check box
    And I click to update the Feature Switches
    Then I wait for the page to return
    And The 'Beta Features' check box is checked

  Scenario: User unchecks the Beta Features checkbox
    When I uncheck the 'Beta Features' check box
    And I click to update the Feature Switches
    Then I wait for the page to return
    And The 'Beta Features' check box is unchecked
