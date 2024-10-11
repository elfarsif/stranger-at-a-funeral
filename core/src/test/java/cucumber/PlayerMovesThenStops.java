package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovesThenStops {
    Game game;
    Character character;
    MovementHandler movementHandler;

    @Given("the player is moving right")
    public void thePlayerIsMovingRight() {
        Map map = new HouseMap();
        character = new Character();
        movementHandler = new MovementHandler(character);
        game = new Game(map,character,movementHandler);
        movementHandler.isMoving = true;
    }

    @When("the player stops moving")
    public void thePlayerStopsMoving() {
        movementHandler.isMoving = false;
    }

    @Then("the player animation is standing")
    public void thePlayerAnimationIsStanding() {
        assertThat(character.getCurrentAssetFileName().contains("Standing")).isTrue();
    }
}
