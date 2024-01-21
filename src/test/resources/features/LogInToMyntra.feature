 Feature: Myntra Login Feature

  Scenario: Verify Myntra Login Page
    Given I am on the Myntra login page
    When I click the login button
    When I click the sign-up link
    When I enter my mobile number "9156482884"
    When I click the submit button
    Then I should see the result
    