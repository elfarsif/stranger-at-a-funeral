package cucumber;

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

    @Given("there is no game")
    public void given() {
        game = new Game();
    }

    @When("the game has started")
    public void when() {
        game.start();
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
        Player player = game.getPlayer();
        PlayableCharacter playableCharacter = new PlayableCharacter();
        String assetFileName = playableCharacter.getAssetFileName();

        assertThat(assetFileName).isEqualTo("mainCharacter/playerDownStanding1.png");
    }

    @Then("the game map is the main house")
    public void thenHouse(){
        Map map = game.getMap();
        String assetFileName = map.getAssetFileName();
        assertThat(assetFileName).isEqualTo("tilemaps/main_house_interior.tmx");
    }


}
