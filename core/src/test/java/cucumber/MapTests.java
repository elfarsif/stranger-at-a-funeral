package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Map;
import io.github.elfarsif.Tile;
import io.github.elfarsif.character.Character;
import static org.assertj.core.api.Assertions.assertThat;

public class MapTests {
    Map map;
    Character character;
    boolean isValidPosition;

    @Given("I have no map")
    public void iHaveNoGrid() {
    }

    @When("I create a map")
    public void iCreateAGrid() {
        map = new Map();
    }

    @Then("the map is {int}, {int}")
    public void theGridIs(int width, int height) {
        assertThat(map.getSize()).isEqualTo(new int[]{width, height});
    }

    @And("the map at {int}, {int} has a tile")
    public void theGridAtHasATile(int x, int y) {
        Tile tile = map.getTile(x, y);
        assertThat(tile).isNotNull();
    }

    @And("the map at {int}, {int} has file location {string}")
    public void theMapAtHasFileLocation(int x, int y, String fileLocation) {
        assertThat(map.getTile(x,y).getFileLocation()).isEqualTo(fileLocation);
    }

    @Given("I have a character at position {int}, {int}")
    public void iHaveACharacterAtWithPixelSize(int x, int y) {
        character = new Character(map);
        character.setPosition(x, y);
    }

    @When("I check the map for a valid character position")
    public void iCheckTheMapForAValidCharacterPosition() {
        isValidPosition =  map.isValidPosition(character);
    }

    @Then("the character position should be valid")
    public void theCharacterPositionShouldBeValid() {
        assertThat(isValidPosition).isTrue();
    }

    @Then("the character position should be invalid")
    public void theCharacterPositionShouldBeInvalid() {
        assertThat(isValidPosition).isFalse();
    }
}
