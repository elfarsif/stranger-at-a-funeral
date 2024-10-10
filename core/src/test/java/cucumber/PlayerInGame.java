package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.model.Game;
import io.github.elfarsif.model.Map;
import io.github.elfarsif.model.PlayableCharacter;
import io.github.elfarsif.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInGame {
    Game game;
    Map map;
    Player player;
    PlayableCharacter playableCharacter;

    @Given("there is no game")
    public void given() {
        player = new Player();
        map = new Map();
    }

    @When("the game has started")
    public void when() {
        game = new Game(player,map);
    }

    @Then("there is a player in the game")
    public void then() {
        assertThat(game.getPlayer()).isNotNull();
    }

    @Then("the player is a Player object")
    public void then2(){
        assertThat(game.getPlayer()).isInstanceOf(Player.class);
    }

    @Then("the playable character asset is standing")
    public void thenAsset() {
        player = game.getPlayer();
        playableCharacter = new PlayableCharacter();
        game.getPlayer().setPlayableCharacter(playableCharacter);
        String assetFileName = game.getPlayer().getPlayableCharacter().getCurrentAssetFileName();

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
        assertThat(game.getPlayer().getPlayableCharacter().getX())
            .isEqualTo((float)7.5*16);
        assertThat(game.getPlayer().getPlayableCharacter().getY())
            .isEqualTo((float)5*16);
    }
}
