package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Game;

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
}
