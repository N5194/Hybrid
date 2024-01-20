Feature: Verify Add To Cart for Headphones

  Scenario: User adds headphones to the cart on Myntra
    Given User is on the Myntra website
    When User searches for "headphones"
    And User clicks on a specific headphone
    And User adds the headphone to the cart
    And User goes to the cart and verifies the added product
    Then User closes the browser
