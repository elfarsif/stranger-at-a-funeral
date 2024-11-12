Feature: Game Map

  Scenario: Map is empty
    Given I have no map
    When I create a map
    Then the map is 20, 15
    And the map at 0, 0 has a tile
    And the map at 19, 14 has a tile

    And the map at 0, 0 has file location "textures/wood_plank_middle.png"

    Given I have a character at position 20, 15
    When I check the map for a valid character position
    Then the character position should be valid

    Given I have a character at position 10, 33
    When I check the map for a valid character position
    Then the character position should be invalid




#    And that there is a tile at 0, 0

#    When I remove the character from the grid
#    Then the grid at 0, 0 is empty



