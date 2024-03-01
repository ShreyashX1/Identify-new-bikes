Feature: Google Login Error Message Capture

  Scenario: Invalid Google Account Login
    Given User returns to main page
    Then User clicks on login button
     And User clicks on google button
    Then User capture the error message
