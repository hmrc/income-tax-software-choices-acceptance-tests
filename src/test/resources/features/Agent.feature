@ITSC
@Agent

Feature: Agent journey

  Scenario: An agent uses the software choices tool and views details about software vendor 1
    Given I navigate to the index route

    When I am on the user type page, I select 'As an agent' and click continue
    And On the search software page, I click on the vendor link: 1
    Then I am on the product details page for vendor: 'test software vendor name one'
