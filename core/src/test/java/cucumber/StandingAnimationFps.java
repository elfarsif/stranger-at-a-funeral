package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.PlayableCharacter;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StandingAnimationFps {
    PlayableCharacter playableCharacter;
    PlayableCharacter mockCharacter;
    float delta;

    @Given("the delta is {float}, the timeAccumulator is {float}, and the frameDuration is {float}")
    public void theDeltaIsTheTimeAccumulatorIsAndTheFrameDurationIs(float delta, float timeAccumulator, float frameDuration) {
        playableCharacter = new PlayableCharacter();
        mockCharacter = Mockito.spy(playableCharacter);
        mockCharacter.setTimeAccumulator(timeAccumulator);
        mockCharacter.setFrameDuration(frameDuration);
        this.delta = delta;
    }

    @When("a playable character is updated with delta")
    public void aPlayableCharacterIsUpdatedWithDelta() {
        mockCharacter.updateTexture(delta);
    }

    @Then("the next assets is shown and the timeAccumulator is reset")
    public void theUpdateTextureIsCalledAndTimeAccumulatorIsReset() {
        assertThat(mockCharacter.getTimeAccumulator()).isEqualTo(0);
        verify(mockCharacter,times(1)).updateTexture();
    }
}
