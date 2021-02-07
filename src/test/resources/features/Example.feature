@suite

Feature: Example Feature file using Cucumber

  Scenario: search for pen on amazon
    Given I navigate to amazon.com
    When I enter pen into the twotabsearchtextbox field
    And I select the nav-search-submit-button id

