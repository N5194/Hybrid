
Feature: Verify Latest Offers on Myntra

  Scenario: Verify latest offers on Myntra
    Given User is on the Myntra homepage now
    When User clicks on the Myntra logo
    And User scrolls down 500 pixels
    Then User checks the latest offers list
