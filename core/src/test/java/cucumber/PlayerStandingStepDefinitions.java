package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.PlayableCharacter;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerStandingStepDefinitions {
    PlayableCharacter playableCharacter;

    @Given("playable character is currently using {string}")
    public void playableCharacterIsCurrentlyUsing(String firstAsset) {
        playableCharacter = new PlayableCharacter();
        playableCharacter.setCurrentAsserIndex(firstAsset);
        assertThat(playableCharacter.getCurrentAssetFileName()).isEqualTo(firstAsset);
    }

    @When("you update the texture")
    public void youUpdateTheTexture() {
        playableCharacter.updateTexture();
    }

    @Then("the character is currently using {string}")
    public void theCharacterIsCurrentlyUsing(String secondAsset) {
        assertThat(playableCharacter.getCurrentAssetFileName()).isEqualTo(secondAsset);
    }

}
