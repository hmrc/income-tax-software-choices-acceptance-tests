@ITSC
@Beta
Feature: Software Choices

  # Get onto the page
  Background:
    Given On the feature switch page I check features
      | Beta Features |
    And I navigate to the Software Choices home page
    Then I am on the Software Choices home page
    And I am presented with a list of 4 vendors
    And There are no selected and enabled filters excluding extra pricing options and overseas property option

  # Search bar
  Scenario: User searches for a software vendor through the search bar
    When I enter 'test software vendor one' into the search bar
    Then I am presented with a list of vendors matching 'test software vendor name one'

  # Pricing checkboxes
  Scenario: User filters for a free version
    Given I open the 'Pricing' accordion fold
    And I select the 'Free version' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Income type checkboxes
  Scenario: User filters for sole trader
    Given I open the 'Suitable for' accordion fold
    And I select the 'Sole trader' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for UK property
    Given I open the 'Suitable for' accordion fold
    And I select the 'UK property' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Business type checkboxes
  Scenario: User filters for a individual
    Given I open the 'Business type' accordion fold
    And I select the 'Individual' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for a agent
    Given I open the 'Business type' accordion fold
    And I select the 'Agent' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Operating system checkboxes
  Scenario: User filters for operating system Microsoft Windows
    Given I open the 'Operating system' accordion fold
    And I select the 'Microsoft' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for operating system Mac OS
    Given I open the 'Operating system' accordion fold
    And I select the 'Mac OS' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Mobile app checkboxes
  Scenario: User filters for compatible with Android
    Given I open the 'Mobile app' accordion fold
    And I select the 'Android' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for compatible with Apple iOS
    Given I open the 'Mobile app' accordion fold
    And I select the 'Apple iOS' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Software type checkboxes
  Scenario: User filters for software type browser based
    Given I open the 'Software type' accordion fold
    And I select the 'Browser based' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for software type application based
    Given I open the 'Software type' accordion fold
    And I select the 'Application based' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Software for checkboxes
  Scenario: User filters for Software for record keeping
    Given I open the 'Software for' accordion fold
    And I select the 'Record keeping' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page
    And The page contains the label for 'Record keeping'

  Scenario: User filters for compatible with bridging
    Given I open the 'Software for' accordion fold
    And I select the 'Bridging' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page
    And The page contains the label for 'Bridging'

  # Software compatibility checkboxes
  Scenario: User filters for VAT
    Given I open the 'Software compatibility' accordion fold
    And I select the 'VAT' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Language checkboxes
  Scenario: User filters for Welsh
    Given I open the 'Language' accordion fold
    And I select the 'Welsh' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 1 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  # Accessibility features checkboxes
  Scenario: User filters for compatible with Impaired vision and blindness accessibility features
    Given I open the 'Accessibility features' accordion fold
    And I select the 'Impaired vision and blindness' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for compatible with Deafness and impaired hearing accessibility features
    Given I open the 'Accessibility features' accordion fold
    And I select the 'Deafness and impaired hearing' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for compatible with Motor difficulties accessibility features
    Given I open the 'Accessibility features' accordion fold
    And I select the 'Motor difficulties' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page

  Scenario: User filters for compatible with Cognitive impairments accessibility features
    Given I open the 'Accessibility features' accordion fold
    And I select the 'Cognitive impairments' checkbox
    And I wait for the magic javascript
    Then I am presented with a list of 2 vendors
    And I click on the vendor link: 1
    Then I am on the product details page
