Feature: Verify H&M Products on Myntra

  Scenario: User searches for H&M products on Myntra
    Given user is on the Myntra website
    When the user searches for "H&M" products
    Then the user should see "H&M" products in the search results
