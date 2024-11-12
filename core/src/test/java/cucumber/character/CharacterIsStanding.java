package cucumber.character;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.character.Character;
import io.github.elfarsif.character.CharacterState;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.elfarsif.Map;

public class CharacterIsStanding {
    Character character;

    @Given("I have no character")
    public void iHaveNoCharacter() {
    }

    @When("I create a character")
    public void iCreateACharacter() {
        Map map = new Map();
        character = new Character(map);
    }

    @Then("they should be standing")
    public void theyShouldBeStanding() {
        assertThat(character.getCharacterState()).isEqualTo(CharacterState.STANDING);
    }


    @And("the character has a map dependency")
    public void theCharacterHasAMapDependency() {
        assertThat(character.getMap()).isNotNull();
    }
}
