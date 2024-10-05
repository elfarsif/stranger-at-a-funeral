package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Game;
import io.github.elfarsif.model.PlayableCharacter;
import io.github.elfarsif.model.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PlayerMovesStepDefinitions {
    Game game;
    Sprite sprite;

    @Given("there is a player and playable character")
    public void given() {
        game = new Game();
        Player player = new Player();
        PlayableCharacter playableCharacter = new PlayableCharacter();
        player.setPlayableCharacter(playableCharacter);
        game.setPlayer(player);
        sprite = mock(Sprite.class);
    }

    @When("the player moves up")
    public void when() {
        game.moveUp(sprite);
    }

    @Then("the translateY function is called with 1")
    public void then() {
        verify(sprite, times(1)).translateY(1);
    }

    @And("the player animation is walking up")
    public void thePlayerAnimationIsWalkingUp() {
        assertThat(game.getPlayer().getPlayableCharacter().getCurrentAssetFileName().contains("Up")).isTrue();
        assertThat(game.getPlayer().getPlayableCharacter().getAssetFiles().size()).isEqualTo(6);
    }

    @When("the player moves down")
    public void thePlayerMovesDown() {
        game.moveDown(sprite);
    }

    @Then("the translateY function is called with -1")
    public void theTranslateYFunctionIsCalledWith() {
        verify(sprite, times(1)).translateY(-1);
    }

    @When("the player moves left")
    public void thePlayerMovesLeft() {
        game.moveLeft(sprite);
    }

    @Then("the translateX function is called with -1")
    public void theTranslateXFunctionIsCalledWith() {
        verify(sprite, times(1)).translateX(-1);
    }

    @When("the player moves right")
    public void thePlayerMovesRight() {
        game.moveRight(sprite);
    }

    @Then("the translateX function is called with 1")
    public void theTranslateXFunctionIsCalledWithOne() {
        verify(sprite, times(1)).translateX(1);
    }

    @And("the player animation is walking right")
    public void thePlayerAnimationIsWalkingRight() {
        assertThat(game.getPlayer().getPlayableCharacter().getCurrentAssetFileName().contains("Right")).isTrue();
        assertThat(game.getPlayer().getPlayableCharacter().getAssetFiles().size()).isEqualTo(6);
    }


}
