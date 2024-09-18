Feature: signup
  Scenario: user navigates to sign up page
    Given We are on the login page
    When We click signup button
    Then Page changes to signup page

  Scenario: user fills all mandatory fields and clicks signup button
    Given User on the signup page
    When the user enters valid values to fields
    Then user sees login page

  Scenario: user enters invalid email address missing @ and clicks signup button
    Given email field filled without hashtag
    When User enters email address without hashtag
    Then User can not see login page

  Scenario: user enters invalid email address missing . and clicks signup button
    Given email field filled without dot
    When User enters email address without dot
    Then User can not reach login page

  Scenario: user leaves all fields blank
    Given user is on the sign up page no fields filled
    When user presses signup button
    Then user not forwarded to login page

  Scenario: user signs up with same credentials
    Given user gets to signup page
    When user signs up with same credentials
    Then user will not see login page

  Scenario: user signs up with used email
    Given user is at signup page
    When user types already used email
    Then login page not shown

  Scenario: user signs up with used username
    Given signup page renders
    When user types already used username
    Then login page not rendered