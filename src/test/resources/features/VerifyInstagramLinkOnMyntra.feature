Feature: Verify Instagram Link on Myntra

  Scenario: User verifies the Instagram link on Myntra
    Given the user is open the Myntra website
    When the user scrolls down the page
    And clicks on the Instagram link
    And switches to the Instagram login page
    Then the user should see the Instagram page with the title containing 'Instagram'

