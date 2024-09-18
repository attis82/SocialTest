Feature: like post
  Scenario: The user likes an unliked post by clicking on heart
    Given We are logged in with "asd" : "12345" credentials
    And A post "new post" is made
    When The user clicks on heart on "new post"
    Then The hearth icon becomes red at post "new post"

  Scenario: The user likes an unliked post by double clicking on the picture
    Given We are logged in with "asd" : "12345" credentials
    And A post "new picture" is made
    When The user double clicks on picture "new picture"
    Then The hearth icon becomes red at post "new picture"

  Scenario: The user unlikes a liked post by double clicking on the picture
    Given We are logged in with "asd" : "12345" credentials
    And A post "another new picture" is made and liked
    When The user double clicks on picture "another new picture"
    Then The hearth icon becomes white at post "another new picture"

  Scenario: The user unlikes a liked post by clicking on heart
    Given We are logged in with "asd" : "12345" credentials
    And A post "another new post" is made and liked
    When The user clicks on heart on "another new post"
    Then The hearth icon becomes white at post "another new post"