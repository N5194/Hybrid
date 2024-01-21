
    Feature: Verify Search on H&M Product Page

  Scenario: Verify searching for H&M products
    Given User is on the H&M Product Page
    When User enters H&M in the search box and presses ENTER
    Then Search results for "H&M" are displayed