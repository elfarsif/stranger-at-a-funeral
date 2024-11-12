Feature: Character Class

  Scenario: There is a character
    Given I have no character
    When I create a character
    Then they should be standing
    And the character has a map dependency

  Scenario: Character changes State
    Given The character is standing
    When I change the state of the character to walking
    Then the character should not be standing

  Scenario: Character standing sprite texture
    Given I have a  new character
    When the character is standing
    Then current texture filename should be "mainCharacter/standing1.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing2.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing3.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing4.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing5.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing6.png"
    When the character updates its texture
    Then texture should be "mainCharacter/standing1.png"

  Scenario: Character walking
    Given I have a character at 0, 0
    When I move right
    Then the character should be at 1, 0
    When I move left
    Then the character should be at 0, 0
    When I move up
    Then the character should be at 0, 1
    When I move down
    Then the character should be at 0, 0

  Scenario: Character walks into wall to the right
    Given there is a wall at 1, 0 and a character at 0, 0
    When there is a colliding object to the right
    Then the character is colliding to the right

    When the character moves right
    Then the character should still be at 0, 0

    When the character moves left
    Then the character should not be colliding with right wall

    ##Walking into wall to the left
    Given there is a wall at 0, 0 and a character at 1, 0
    When there is a colliding object to the left
    Then the character is colliding to the left

    When the character moves left
    Then the character should still be at 1, 0

    When the character moves right
    Then the character should not be colliding with left wall

    ##Walking into wall to the top
    Given there is a wall at 0, 1 and a character at 0, 0
    When there is a colliding object to the top
    Then the character is colliding to the top

    ##Walking into wall to the bottom
   Given  there is a wall at 0, 0 and a character at 0, 1
   When there is a colliding object to the bottom
   Then the character is colliding to the bottom

    Given I have a character at 0, 0
    When I move left
    Then the character should be at 0, 0


  ##Multiple walls





# Unit Tests
  Scenario: Null Character state
    Given I have a character
    When I set the character state to null
    Then then a null character state exception should be thrown
    And the error message should be "Character State cannot be null"
