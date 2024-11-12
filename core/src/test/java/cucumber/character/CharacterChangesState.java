package cucumber.character;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Map;
import io.github.elfarsif.character.Character;
import io.github.elfarsif.character.CharacterState;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class CharacterChangesState {
    Character character;

    @Given("The character is standing")
    public void theCharacterIsStanding() {
        Map map = new Map();
        character = new Character(map);
    }

    @When("I change the state of the character to walking")
    public void iChangeTheStateOfTheCharacterToWalking() {
        character.setCharacterState(CharacterState.WALKING);
    }

    @Then("the character should not be standing")
    public void theCharacterShouldNotBeStanding() {
        assertThat(character.getCharacterState()).isNotEqualTo(CharacterState.STANDING);
    }
}
