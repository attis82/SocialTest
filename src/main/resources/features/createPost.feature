Feature: create post

  Scenario: user can upload image
    Given We are logged in with "ati" : "0616" credentials
    When user presses upload button
    Then image appears

  Scenario: user can send post with only description
    Given We are logged in with "ati" : "0616" credentials
    When user enters description
    Then post appears on home feed

  Scenario: user can not send post without description
    Given We are logged in with "ati" : "0616" credentials
    When user sends post with empty description
    Then post not appearing on main feed
