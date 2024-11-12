package cucumber.character;

import io.cucumber.java.en.And;
import io.github.elfarsif.Map;
import io.github.elfarsif.character.Character;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterStateSetAsNull {
    Character character;
    IllegalArgumentException exception;

    @Given("I have a character")
    public void iHaveACharacter() {
        Map map = new Map();
        character = new Character(map);
    }

    @When("I set the character state to null")
    public void iSetTheCharacterState() {
        //done in the assertion directly
    }

    @Then("then a null character state exception should be thrown")
    public void thenANullCharacterStateExceptionShouldBeThrown() {
        assertThatThrownBy(() -> character.setCharacterState(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @And("the error message should be {string}")
    public void theErrorMessageShouldBe(String message) {
        assertThatThrownBy(() -> character.setCharacterState(null))
            .hasMessage(message);
    }
}
