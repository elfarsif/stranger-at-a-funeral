package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;
import io.github.elfarsif.model.map.HouseMap;
import io.github.elfarsif.model.map.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInGame {
    Game game;
    Map map;
    Character character;
    MovementHandler movementHandler;

    @Given("there is no game")
    public void given() {
        map = new HouseMap();
        character = new Character();
        movementHandler = new MovementHandler(character);
    }

    @When("the game has started")
    public void when() {
        game = new Game(map,character,movementHandler);
    }

    @Then("there is a player in the game")
    public void then() {
        assertThat(character).isNotNull();
    }

    @Then("the player is a Player object")
    public void then2(){
        assertThat(character).isInstanceOf(Character.class);
    }

    @Then("the playable character asset is standing")
    public void thenAsset() {
        String assetFileName = character.getCurrentAssetFileName();

        assertThat(assetFileName).isEqualTo("mainCharacter/playerDownStanding1.png");
    }

    @Then("the game map is the main house")
    public void thenHouse(){
        String assetFileName = map.getAssetFileName();
        assertThat(assetFileName).isEqualTo("tilemaps/main_house_interior.tmx");
    }

    @And("the playable character is standing in the main house")
    public void thePlayableCharacterIsStandingInTheMainHouse() {
        map.addCharacter(character);
        assertThat(character.getX())
            .isEqualTo((float)7.5*16);
        assertThat(character.getY())
            .isEqualTo((float)5*16);
    }
}
