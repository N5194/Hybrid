Feature: Myntra Login Page Verification

  Scenario: Verify Myntra Login Page
    Given User opens the Myntra website to LogIn
    When User clicks on the login button
    And User clicks on the login via OTP option
    And User enters the mobile number "9156482884"
    And User clicks on the submit button
    Then User should be on the Myntra login page