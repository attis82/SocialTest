Feature: The user can report a post so if its against the rules it can be deleted
  Scenario: The user reports for a randomly chosen reason.
    Given We are logged in with "asd" : "12345" credentials
    And A post "QA anyádat" is made
    When The user reports post "QA anyádat"
    Then A popup shows that the report was successful

  Scenario:  The user reports a post a second time another alert shows
    Given We are logged in with "asd" : "12345" credentials
    And A post "Bémeg" is made
    When The user reports post "Bémeg" twice
    Then A popup shows that the report was already made