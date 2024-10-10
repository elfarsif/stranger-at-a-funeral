package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovesThenStops {
    Game game;

    @Given("the player is moving right")
    public void thePlayerIsMovingRight() {
        Map map = new HouseMap();
        Character character = new Character();
        game = new Game(map,character);
        game.isMoving = true;
    }

    @When("the player stops moving")
    public void thePlayerStopsMoving() {
        game.isMoving = false;
    }

    @Then("the player animation is standing")
    public void thePlayerAnimationIsStanding() {
        assertThat(game.getCharacter().getCurrentAssetFileName().contains("Standing")).isTrue();
    }
}
