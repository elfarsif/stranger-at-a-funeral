package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PlayerWalksIntoWall {
    Character character;
    Wall wall;
    Collision collision;
    WallObjectInitializer wallObjectInitializer;
    CollisionWrapperGdx collisionWrapperGdx;

    @Given("there is a character and a wall")
    public void thereIsACharacterAndAWall() {
        character = new Character();
        Map map = new HouseMap();
        wallObjectInitializer = mock(WallObjectInitializer.class);
        collisionWrapperGdx = mock(CollisionWrapperGdx.class);
        wall = new Wall(map, wallObjectInitializer);

        verifyWallsAreExtractedFromTiledMap();


    }

    private void verifyWallsAreExtractedFromTiledMap() {
        wall.initilizeCollisionObjects();
        verify(wallObjectInitializer,times((1))).initialize();
    }

    @When("the character walks into the wall")
    public void theCharacterWalksIntoTheWall() {
        collision = new Collision(character, wall, collisionWrapperGdx);
    }

    @Then("the character cant move past the wall")
    public void theCharacterCantMovePastTheWall() {
        collision.isValid();
        verify(collisionWrapperGdx,times(1)).checkCharacterOverlapsWall();
    }
}

