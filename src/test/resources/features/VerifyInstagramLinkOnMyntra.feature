
Feature: Verify Instagram Link on Myntra

  Scenario: Verify Instagram link on Myntra
    Given User is on the Myntra homepage
    When User clicks on the Instagram link
    Then Instagram page is displayed with the title containing "Instagram"