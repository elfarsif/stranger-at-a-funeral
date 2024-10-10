package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

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
        game = new Game(map,character);
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
        assertThat(game.getCharacter().getCurrentAssetFileName().contains("Up")).isTrue();
        assertThat(game.getCharacter().getAssetFiles().size()).isEqualTo(6);
    }

    @When("the player moves down")
    public void thePlayerMovesDown() {
        game.moveDown(sprite);
    }

    @Then("the translateY function is called with -1")
    public void theTranslateYFunctionIsCalledWith() {
        verify(sprite, times(1)).translateY(-1);
    }

    @And("the player animation is walking down")
    public void thePlayerAnimationIsWalkingDown() {
        assertThat(game.getCharacter().getCurrentAssetFileName().contains("Down")).isTrue();
    }

    @When("the player moves left")
    public void thePlayerMovesLeft() {
        game.moveLeft(sprite);
    }

    @Then("the translateX function is called with -1")
    public void theTranslateXFunctionIsCalledWith() {
        verify(sprite, times(1)).translateX(-1);
    }

    @And("the player animation is walking left")
    public void thePlayerAnimationIsWalkingLeft() {
        assertThat(game.getCharacter().getCurrentAssetFileName().contains("Left")).isTrue();
        assertThat(game.getCharacter().getAssetFiles().size()).isEqualTo(6);
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
        assertThat(game.getCharacter().getCurrentAssetFileName().contains("Right")).isTrue();
        assertThat(game.getCharacter().getAssetFiles().size()).isEqualTo(6);
    }


}
