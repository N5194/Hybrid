Feature: Wish List - Add Product

  Scenario: Verify adding a product to the wish list
    Given User opens Myntra website
    When User hovers over the navigation menu
    And User clicks on the wish list option
    And User clicks on a product
    Then User adds the product to the wish list