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

    When the player moves left
    Then the translateX function is called with -1

    When the player moves right
    Then the translateX function is called with 1

  Scenario Outline: Player standing animation
    Given playable character is currently using "<initialAsset>"
    When you update the texture
    Then the character is currently using "<updatedAsset>"

    Examples:
      |description                |initialAsset                                               |updatedAsset|
      |first asset change|mainCharacter/playerDownStanding1.png|mainCharacter/playerDownStanding2.png    |
      |second asset change     |mainCharacter/playerDownStanding2.png|mainCharacter/playerDownStanding3.png    |
      |last asset change        |mainCharacter/playerDownStanding5.png|mainCharacter/playerDownStanding6.png    |
      |loop asset to first      |mainCharacter/playerDownStanding6.png|mainCharacter/playerDownStanding1.png    |

  Scenario: Player standing animation fps
    Given the delta is 0.017426183, the timeAccumulator is 0.140937225, and the frameDuration is 0.15
    When a playable character is updated with delta
    Then the update texture is called and time accumulator is reset

