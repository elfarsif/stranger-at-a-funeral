Feature: Game Grid

  Scenario: Grid is empty
    Given I have no grid
    When I create a grid
    Then the grid is 20, 15

  Scenario: Add a character to grid
    Given I have a grid and a character
    When I add a character to the grid
    Then the grid at 0, 0 is not empty
    When I remove the character from the grid
    Then the grid at 0, 0 is empty

