package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;
import io.github.elfarsif.model.map.HouseMap;
import io.github.elfarsif.model.map.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PlayerMovesStepDefinitions {
    Game game;
    Character character;
    Sprite sprite;

    @Given("there is a player and playable character")
    public void given() {
        Map map = new HouseMap();
        sprite = mock(Sprite.class);
        character = new Character(sprite);
        MovementHandler movementHandler = new MovementHandler(character);
        game = new Game(map,character,movementHandler);
    }

    @When("the player moves up")
    public void when() {
        game.move(character,"up");
    }

    @Then("the translateY function is called with 1")
    public void then() {
        verify(sprite, times(1)).translateY(1);
    }

    @And("the player animation is walking up")
    public void thePlayerAnimationIsWalkingUp() {
        assertThat(character.getCurrentAssetFileName().contains("Up")).isTrue();
        assertThat(character.getAssetFiles().size()).isEqualTo(6);
    }

    @When("the player moves down")
    public void thePlayerMovesDown() {
        game.move(character,"down");
    }

    @Then("the translateY function is called with -1")
    public void theTranslateYFunctionIsCalledWith() {
        verify(sprite, times(1)).translateY(-1);
    }

    @And("the player animation is walking down")
    public void thePlayerAnimationIsWalkingDown() {
        assertThat(character.getCurrentAssetFileName().contains("Down")).isTrue();
    }

    @When("the player moves left")
    public void thePlayerMovesLeft() {
        game.move(character, "left");
    }

    @Then("the translateX function is called with -1")
    public void theTranslateXFunctionIsCalledWith() {
        verify(sprite, times(1)).translateX(-1);
    }

    @And("the player animation is walking left")
    public void thePlayerAnimationIsWalkingLeft() {
        assertThat(character.getCurrentAssetFileName().contains("Left")).isTrue();
        assertThat(character.getAssetFiles().size()).isEqualTo(6);
    }

    @When("the player moves right")
    public void thePlayerMovesRight() {
        game.move(character,"right");
    }

    @Then("the translateX function is called with 1")
    public void theTranslateXFunctionIsCalledWithOne() {
        verify(sprite, times(1)).translateX(1);
    }

    @And("the player animation is walking right")
    public void thePlayerAnimationIsWalkingRight() {
        assertThat(character.getCurrentAssetFileName().contains("Right")).isTrue();
        assertThat(character.getAssetFiles().size()).isEqualTo(6);
    }


}
