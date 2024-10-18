package cucumber.character;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.character.Character;
import io.github.elfarsif.character.CharacterState;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterIsStanding {
    Character character;

    @Given("I have no character")
    public void iHaveNoCharacter() {
    }

    @When("I create a character")
    public void iCreateACharacter() {
        character = new Character();
    }

    @Then("they should be standing")
    public void theyShouldBeStanding() {
        assertThat(character.getCharacterState()).isEqualTo(CharacterState.STANDING);
    }

}
