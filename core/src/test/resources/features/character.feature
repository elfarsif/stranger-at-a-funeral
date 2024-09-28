Feature: Player movement

  Scenario: Game start initializes game features
    Given there is no game
    When the game has started
    Then there is a player in the game
    And the player is a Player object
    And the playable character asset is standing
    And the game map is the main house

  Scenario: Player moves
    Given there is a player
    When the player moves up
    Then the translateY function is called with 1

    When the player moves down
    Then the translateY function is called with -1
