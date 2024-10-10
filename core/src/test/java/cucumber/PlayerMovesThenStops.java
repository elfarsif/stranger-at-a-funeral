package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Game;
import io.github.elfarsif.model.Map;
import io.github.elfarsif.model.PlayableCharacter;
import io.github.elfarsif.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovesThenStops {
    Game game;

    @Given("the player is moving right")
    public void thePlayerIsMovingRight() {
        Player player = new Player();
        Map map = new Map();
        game = new Game(player,map);
        PlayableCharacter playableCharacter = new PlayableCharacter();
        game.getPlayer().setPlayableCharacter(playableCharacter);
        game.isMoving = true;
    }

    @When("the player stops moving")
    public void thePlayerStopsMoving() {
        game.isMoving = false;
    }

    @Then("the player animation is standing")
    public void thePlayerAnimationIsStanding() {
        assertThat(game.getPlayer().getPlayableCharacter().getCurrentAssetFileName().contains("Standing")).isTrue();
    }
}
