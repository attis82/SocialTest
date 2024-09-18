Feature: Dark mode
  Scenario Outline: switch to dark mode
    Given We are logged in with "test" : "test" credentials
      And We are on the <page> page
      And We are in light mode
    When We click dark mode button
    Then Page changes to dark mode
    Examples:
    | page |
    | main |
    | login |
    | signup |

  Scenario: switch back to light mode
    Given We are logged in with "test" : "test" credentials
    And We are on the main page
    And We are in dark mode
    When We click dark mode button
    Then Page changes to light mode
  Scenario: refresh keeps light mode
    Given We are logged in with "test" : "test" credentials
    And We are on the main page
    And We are in light mode
    When We refresh the page
    Then Page changes to light mode
  Scenario: refresh keeps dark mode
    Given We are logged in with "test" : "test" credentials
      And We are on the main page
      And We are in dark mode
    When We refresh the page
    Then Page changes to dark mode
