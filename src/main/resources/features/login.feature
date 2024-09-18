Feature: login

  Scenario: the user can log in with valid credentials
    Given We are on the login page
    When The user enters valid credentials
      | username | asd   |
      | password | 12345 |
    Then Page changes to main page

  Scenario: the user can not log in with invalid credentials
    Given We are on the login page
    When The user enters invalid credentials
      | username | invalidUsername |
      | password | invalidPassword |
    Then The page shows a popup
    ## The page stuck in loading screen

  Scenario: the page alerts the user if an input field is left empty
    Given We are on the login page
    When The user leaves username or password field empty
    Then The site puts cursor in first empty input field