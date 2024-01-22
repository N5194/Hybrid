#Feature: Verify Price Filter on Myntra
#
  #Scenario: User searches for Ray-Ban sunglasses with price filter
    #Given the user is on the Myntra site
    #When the user searches for "Ray-Ban" sunglasses
    #And filters results by gender
    #And applies a price filter
    #Then the user should see "Ray-Ban" sunglasses in the search results within the specified price range
    
    Feature: Verify RayBan product filter

  Scenario: Verify product filter functionality
    Given user is on the RayBan search page
    When user enters "rayban" and hits Enter
    And user clicks on the gender filter
    And user clicks on the price filter
    Then user should see filtered results
    
