    
    Feature: Verify Tag Navigation

  Scenario: Verify navigation to Men, Women, and Kids sections
    Given User is on the search navigation page
    When User navigates to Men section
    And User navigates to Women section
    And User navigates to Kids section
    Then User has successfully navigated through Men, Women, and Kids sections
