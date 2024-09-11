package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.character.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterDownMovement {
    Character character;

    @Given("I am standing above the bottom of the screen")
    public void givenIHaveACharacter() {
        character = new Character();
    }

    @When("I press the down arrow key")
    public void whenIPressTheDownArrowKey() {
        character.moveDown();
    }

    @Then("the character moves down")
    public void thenTheCharacterMovesDown() {
        assertThat(character.getPositionY()).isLessThan(1);
    }
}
