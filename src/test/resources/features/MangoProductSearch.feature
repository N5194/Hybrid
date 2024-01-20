Feature: Verify MANGO Brand Products

  Scenario: User verifies MANGO brand products on Myntra
    Given User is open url Myntra website
    When User searches for "MANGO" brand products
    Then User verifies that all displayed products belong to the "MANGO" brand
    And User closes the browser