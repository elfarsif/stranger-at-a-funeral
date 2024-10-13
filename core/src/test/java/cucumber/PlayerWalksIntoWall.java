package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;
import io.github.elfarsif.model.gdx.CollisionWrapper;
import io.github.elfarsif.model.gdx.MapObjectExtractor;
import io.github.elfarsif.model.map.HouseMap;
import io.github.elfarsif.model.map.Map;
import io.github.elfarsif.model.map.Wall;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PlayerWalksIntoWall {
    Character character;
    Wall wall;
    Collision collision;
    MapObjectExtractor mapObjectExtractor;
    CollisionWrapper collisionWrapper;

    @Given("there is a character and a wall")
    public void thereIsACharacterAndAWall() {
        character = new Character();
        Map map = new HouseMap();
        mapObjectExtractor = mock(MapObjectExtractor.class);
        collisionWrapper = mock(CollisionWrapper.class);
        wall = new Wall(map, mapObjectExtractor);

        verifyWallsAreExtractedFromTiledMap();


    }

    private void verifyWallsAreExtractedFromTiledMap() {
        wall.initializeCollisionObjects();
        verify(mapObjectExtractor,times((1))).extract();
    }

    @When("the character walks into the wall")
    public void theCharacterWalksIntoTheWall() {
        collision = new Collision(character, wall, collisionWrapper);
    }

    @Then("the character cant move past the wall")
    public void theCharacterCantMovePastTheWall() {
        collision.isValid();
        verify(collisionWrapper,times(1)).checkCharacterOverlapsWall();
    }

}

