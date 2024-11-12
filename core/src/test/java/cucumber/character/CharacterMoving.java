package cucumber.character;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Map;
import io.github.elfarsif.character.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterMoving {
    Character character;

    @Given("I have a character at {int}, {int}")
    public void iHaveACharacterAt(int x, int y) {
        Map map = new Map();
        character = new Character(map);
        character.setPosition(x, y);
    }

    @When("I move right")
    public void iMoveRight() {
        character.move("right");
    }

    @Then("the character should be at {int}, {int}")
    public void theCharacterShouldBeAt(int x, int y) {
        int[] expectedPosition = {x, y};
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @When("I move left")
    public void iMoveLeft() {
        character.move("left");
    }

    @When("I move up")
    public void iMoveUp() {
        character.move("up");
    }

    @When("I move down")
    public void iMoveDown() {
        character.move("down");
    }

}
