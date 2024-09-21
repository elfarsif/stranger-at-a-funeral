package cucumber;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.github.elfarsif.Door;
import io.github.elfarsif.Map;
import io.github.elfarsif.MapManager;
import io.github.elfarsif.character.Character;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CharaterStepDefinitions {

    Character character;

    @Given("I am in the main house")
    public void given() {
        TmxMapLoader loader = mock(TmxMapLoader.class);
        MapManager mapManager = new MapManager(loader);
        verify(mapManager.loader).load("tilemaps/main_house_interior.tmx");

    }

    @When("I get to the door")
    public void when() {
        Character character = mock(Character.class);

        TiledMap tiledMap = mock(TiledMap.class);
        Map map = new Map(tiledMap);

        MapObject mapObject = mock(MapObject.class);
        Door door = new Door(mapObject);


        Collision collision = new Collision(character, map, door);
//        assertThat(collision.isColliding()).isEqualTo(true);
    }

    @Then("they are in the normal state")
    public void then() {
        assertThat(1).isEqualTo(1);
        //then he should be in the ship
    }


    public void testMap(){

        assertThat(1).isEqualTo(1);
    }

}
