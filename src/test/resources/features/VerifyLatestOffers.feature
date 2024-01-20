Feature: Verify Latest Offers on Myntra

  Scenario: User verifies the latest offers on Myntra
    Given user on the Myntra website
    When the user clicks on the Myntra logo
    And scrolls down the page
    And clicks on the subscribe icon for latest offers
    Then the user should see non-empty latest offers

