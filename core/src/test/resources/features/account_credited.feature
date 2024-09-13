Feature: Character movement

  Scenario: Character is in normal state
    Given I have no character
    When the character is created
    Then they are in the normal state
