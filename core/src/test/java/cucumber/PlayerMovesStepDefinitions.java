package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PlayerMovesUp {
    Game game;
    Sprite sprite;

    @Given("there is a player")
    public void given() {
        game = new Game();
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
}
