package cucumber.character;

import io.github.elfarsif.Map;
import io.github.elfarsif.character.Character;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.character.CharacterState;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTextureStanding {
    Character character;

    @Given("I have a  new character")
    public void iHaveANewCharacter() {
        Map map = new Map();
        character = new Character(map);

    }

    @When("the character is standing")
    public void theCharacterIsStanding() {
        character.setCharacterState(CharacterState.STANDING);
    }

    @Then("current texture filename should be {string}")
    public void currentTextureFilenameShouldBe(String filename) {
        String actualFileName = character.getCurrentTextureFileName();
        assertThat(actualFileName).isEqualTo(filename);

    }

    @When("the character updates its texture")
    public void theCharacterUpdatesItsTexture() {
        character.updateTexture();
    }

    @Then("texture should be {string}")
    public void textureShouldBe(String expectedFilename) {
        assertThat(character.getCurrentTextureFileName()).isEqualTo(expectedFilename);
    }
}
