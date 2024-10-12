package cucumber;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PlayerWalksIntoWall {
    Character character;
    Wall wall;
    Collision collision;
    WallObjectInitializer wallObjectInitializer;

    @Given("there is a character and a wall")
    public void thereIsACharacterAndAWall() {
        character = new Character();
        Map map = new HouseMap();
        wallObjectInitializer = mock(WallObjectInitializer.class);
        wall = new Wall(map, wallObjectInitializer);

        verifyWallsAreExtractedFromTiledMap();


    }

    private void verifyWallsAreExtractedFromTiledMap() {
        wall.initilizeCollisionObjects();
        verify(wallObjectInitializer,times((1))).initialize();
    }

    @When("the character walks into the wall")
    public void theCharacterWalksIntoTheWall() {
        collision = new Collision();
    }

    @Then("the character cant move past the wall")
    public void theCharacterCantMovePastTheWall() {
        assertThat(collision.isColliding(character, wall)).isTrue();
    }
}

