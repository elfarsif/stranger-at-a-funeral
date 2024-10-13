package cucumber;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Character;
import io.github.elfarsif.model.Game;
import io.github.elfarsif.model.MovementHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharacterMovesAwayFromWall {
    Character character;
    Object wall;
    Sprite sprite;
    MovementHandler movementHandler;


    @Given("the character is touching a wall")
    public void theCharacterIsTouchingAWall() {
        sprite = mock(Sprite.class);
        character = new Character(sprite);
        movementHandler = new MovementHandler(character);
        character.setIsTouchingObject(true);
    }

    @When("the character moves away from the wall")
    public void theCharacterMovesAwayFromTheWall() {
        movementHandler.moveLeft(character.getSprite());
    }

    @Then("the character is no longer touching the wall")
    public void theCharacterIsNoLongerTouchingTheWall() {
        verify(sprite).translateX(-1);
    }

}
