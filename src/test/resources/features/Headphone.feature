
    Feature: Add Headphone to Cart Feature

  Scenario: Verify adding a headphone to the cart
    Given I am on the headphone search page
    When I enter and search for the product
    And I add the headphone to the cart
    Then I should see the product in the cart