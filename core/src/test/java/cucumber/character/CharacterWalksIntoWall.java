package cucumber.character;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Map;
import io.github.elfarsif.Wall;
import io.github.elfarsif.character.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterWalksIntoWall {
    Character character;
    Wall wall;

    @Given("there is a wall at {int}, {int} and a character at {int}, {int}")
    public void thereIsAWallAtAndACharacterAt(int wallX, int wallY, int characterX, int characterY) {
        Map map = new Map();
        character = new Character(map);
        character.setPosition(characterX, characterY);
        wall = new Wall();
        wall.setPosition(wallX, wallY);
        assertThat(wall.getPosition()).isEqualTo(new int[]{wallX, wallY});
    }

    @When("there is a colliding object to the right")
    public void thereIsACollidingObjectToTheRight() {
        boolean isCollidingRight = character.verifyCollisionRight(wall);
        assertThat(isCollidingRight).isTrue();
    }

    @Then("the character is colliding to the right")
    public void theCharacterIsCollidingToTheRight() {
        assertThat(character.isCollidingRight()).isTrue();
    }

    @When("the character moves right")
    public void theCharacterMovesRight() {
        character.move("right");
    }

    @Then("the character should still be at {int}, {int}")
    public void theCharacterShouldStillBeAt(int x, int y) {
        assertThat(character.getPosition()).isEqualTo(new int[]{x, y});
    }

    @When("the character moves left")
    public void theCharacterMovesLeft() {
        character.move("left");
    }

    @Then("the character should not be colliding with right wall")
    public void theCharacterShouldNotBeCollidingWithRightWall() {
        assertThat(character.isCollidingRight()).isFalse();
    }

    @When("there is a colliding object to the left")
    public void thereIsACollidingObjectToTheLeft() {
        boolean isCollidingLeft = character.verifyCollisionLeft(wall);
        assertThat(isCollidingLeft).isTrue();
    }

    @Then("the character is colliding to the left")
    public void theCharacterIsCollidingToTheLeft() {
        assertThat(character.isCollidingLeft()).isTrue();
    }

    @Then("the character should not be colliding with left wall")
    public void theCharacterShouldNotBeCollidingWithLeftWall() {
        assertThat(character.isCollidingLeft()).isFalse();
    }

    @When("there is a colliding object to the top")
    public void thereIsACollidingObjectToTheTop() {
        assertThat(character.verifyCollisionTop(wall)).isTrue();
    }

    @Then("the character is colliding to the top")
    public void theCharacterIsCollidingToTheTop() {
        assertThat(character.isCollidingTop()).isTrue();
    }

    @When("there is a colliding object to the bottom")
    public void theCharacterIsCollidingToTheBottom() {
        assertThat(character.verifyCollisionBottom(wall)).isTrue();
    }

    @Then("the character is colliding to the bottom")
    public void thereIsACollidingObjectToTheBottom() {
        assertThat(character.isCollidingBottom()).isTrue();
    }
}
