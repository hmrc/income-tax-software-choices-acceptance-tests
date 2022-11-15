@ITSC
@Glossary
@Beta
Feature: Glossary

  Background:
    Given On the feature switch page I check features
      | Beta Features        |
      | Income and Deduction |
    And I navigate to the Software Choices home page
    And I click on the test software vendor name one link
    And I click on the glossary link

  Scenario: User searches for a term on the glossary page
    When On the glossary page, I enter 'HMRC' into the search bar
    And On the glossary page, I wait for the list to update
    Then On the glossary page, I am presented with only rows which match 'HMRC'
