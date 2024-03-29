@ITSC
@Alpha


Feature: Software Choices (Alpha Version)

  # Get onto the page
  Background:
    Given On the feature switch page I uncheck features
      | Beta Features |
    And I navigate to the Software Choices home page
    Then I am on the Software Choices home page
    And I am presented with an alpha list of 4 vendors

  # Search bar
  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    Then I am presented with an alpha list of vendors matching 'test software vendor name one'

  # Pricing checkboxes
  Scenario: User filters for a free version
    When I select the 'Free version' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Free version'

  Scenario: User filters for a free trial
    Given On the feature switch page I check features
      | Extra Pricing Options |
    And I navigate to the Software Choices home page
    When I select the 'Free trial' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Free trial'

  Scenario: User filters for paid for
    Given On the feature switch page I check features
      | Extra Pricing Options |
    And I navigate to the Software Choices home page
    And I select the 'Paid for' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 1 vendors

  # Income type checkboxes
  Scenario: User filters for sole trader
    When I select the 'Sole trader' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  Scenario: User filters for UK property
    When I select the 'UK property' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  Scenario: User filters for overseas property
    Given On the feature switch page I check features
      | Overseas Property Option |
    And I navigate to the Software Choices home page
    When I select the 'Overseas property' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  # Business type checkboxes
  Scenario: User filters for a individual
    When I select the 'Individual' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Individual'

  Scenario: User filters for a agent
    When I select the 'Agent' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Agent'

  # Compatible with checkboxes
  Scenario: User filters for compatible with Microsoft Windows
    When I select the 'Microsoft' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Microsoft'

  Scenario: User filters for compatible with Mac OS
    When I select the 'Mac OS' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Mac OS'

  # Mobile app checkboxes
  Scenario: User filters for compatible with Android
    When I select the 'Android' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Android'

  Scenario: User filters for compatible with Apple iOS
    When I select the 'Apple iOS' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Apple iOS'

  # Software type checkboxes
  Scenario: User filters for compatible with browser based
    When I select the 'Browser based' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Browser based'

  Scenario: User filters for compatible with application based
    When I select the 'Application based' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Application based'

  # Software for checkboxes
  Scenario: User filters for compatible with record keeping
    When I select the 'Record keeping' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  Scenario: User filters for compatible with bridging
    When I select the 'Bridging' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  # Software compatibility checkboxes
  Scenario: User filters for VAT
    When I select the 'VAT' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of 2 vendors

  # Accessibility features checkboxes
  Scenario: User filters for compatible with Impaired vision and blindness accessibility features
    When I select the 'Impaired vision and blindness' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Impaired vision and blindness'

  Scenario: User filters for compatible with Deafness and impaired hearing accessibility features
    When I select the 'Deafness and impaired hearing' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Deafness and impaired hearing'

  Scenario: User filters for compatible with Motor difficulties accessibility features
    When I select the 'Motor difficulties' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Motor difficulties'

  Scenario: User filters for compatible impairments with Cognitive accessibility features
    When I select the 'Cognitive impairments' checkbox
    And I wait for the magic javascript
    Then I am presented with an alpha list of vendors which provide 'Cognitive impairments'

  # Clear filters
#  Scenario: User clears filters
#    Given I have selected all filters
#    Then There are only selected filters
#    When I click to clear filters
#    Then There are no selected and enabled filters excluding extra pricing options and overseas property option
#    And I am presented with an alpha list of 4 vendors