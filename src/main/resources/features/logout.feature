Feature: logout
  Scenario: logout
    Given We are logged in with "test" : "test" credentials
    When We click logout button
    Then Page changes to login page