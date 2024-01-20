Feature: Verify Browser Compatibility on Myntra

  Scenario: User verifies browser compatibility on Myntra
    Given user open myntra website
    When the user searches for "Running shoes"
    Then the user should see product items displayed
