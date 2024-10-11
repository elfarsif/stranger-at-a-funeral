package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerStandingStepDefinitions {
    Character character;

    @Given("playable character is currently using {string}")
    public void playableCharacterIsCurrentlyUsing(String firstAsset) {
        character = new Character();
        character.setCurrentAsserIndex(firstAsset);
        assertThat(character.getCurrentAssetFileName()).isEqualTo(firstAsset);
    }

    @When("you update the texture")
    public void youUpdateTheTexture() {
        character.updateTexture();
    }

    @Then("the character is currently using {string}")
    public void theCharacterIsCurrentlyUsing(String secondAsset) {
        assertThat(character.getCurrentAssetFileName()).isEqualTo(secondAsset);
    }

}
