Feature: Verify Navigation on Myntra

  Scenario: User verifies navigation links on Myntra
    Given the user on the Myntra website
    When the user hovers over the "Men" link
    Then the "Men" link should be displayed

    When the user hovers over the "Women" link
    Then the "Women" link should be displayed

    When the user hovers over the "Kids" link
    Then the "Kids" link should be displayed
