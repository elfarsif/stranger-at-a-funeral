package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInGame {
    Game game;
    Map map;
    Character character;

    @Given("there is no game")
    public void given() {
        map = new HouseMap();
        character = new Character();
    }

    @When("the game has started")
    public void when() {
        game = new Game(map,character);
    }

    @Then("there is a player in the game")
    public void then() {
        assertThat(game.getCharacter()).isNotNull();
    }

    @Then("the player is a Player object")
    public void then2(){
        assertThat(game.getCharacter()).isInstanceOf(Character.class);
    }

    @Then("the playable character asset is standing")
    public void thenAsset() {
        String assetFileName = game.getCharacter().getCurrentAssetFileName();

        assertThat(assetFileName).isEqualTo("mainCharacter/playerDownStanding1.png");
    }

    @Then("the game map is the main house")
    public void thenHouse(){
        map = game.getMap();
        String assetFileName = map.getAssetFileName();
        assertThat(assetFileName).isEqualTo("tilemaps/main_house_interior.tmx");
    }

    @And("the playable character is standing in the main house")
    public void thePlayableCharacterIsStandingInTheMainHouse() {

        game.setCharacterInHouse();
        assertThat(game.getCharacter().getX())
            .isEqualTo((float)7.5*16);
        assertThat(game.getCharacter().getY())
            .isEqualTo((float)5*16);
    }
}
