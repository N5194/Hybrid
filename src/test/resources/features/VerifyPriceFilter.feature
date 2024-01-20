Feature: Verify Price Filter on Myntra

  Scenario: User searches for Ray-Ban sunglasses with price filter
    Given the user is on the Myntra site
    When the user searches for "Ray-Ban" sunglasses
    And filters results by gender
    And applies a price filter
    Then the user should see "Ray-Ban" sunglasses in the search results within the specified price range
