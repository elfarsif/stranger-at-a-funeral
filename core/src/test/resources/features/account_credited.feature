Feature: Character movement

  Scenario: Character is in normal state
    Given I have no character
    When the character is created
    Then they are in the normal state

  Scenario: Charater is moving down
    Given I am standing above the bottom of the screen
    When I press the down arrow key
    Then the character moves down

