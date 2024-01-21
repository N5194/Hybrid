    Feature: Verify Mango Brand Products Using Page
    
  Scenario: User verifies Mango brand products using page
    Given the user is on the Mango product search page
    When the user enters MANGO and presses ENTER
    Then the user should see product titles containing "MANGO"