    
    Feature: Verify RayBan product filter

  Scenario: Verify product filter functionality
    Given user is on the RayBan search page
    When user enters "rayban" and hits Enter
    And user clicks on the gender filter
    And user clicks on the price filter
    Then user should see filtered results
    
