package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Grid;
import io.github.elfarsif.character.Character;

import static org.assertj.core.api.Assertions.assertThat;

public class GridAddCharacter {
    Grid grid;
    Character character;

    @Given("I have a grid and a character")
    public void iHaveAGrid() {
        grid = new Grid();
        character = new Character();
    }

    @When("I add a character to the grid")
    public void iAddACharacterToTheGrid() {
        grid.addCharacter(character);
    }

    @Then("the grid at {int}, {int} is not empty")
    public void theGridHasACharacter(int x, int y) {
        assertThat(grid.getTile(x, y)).isNotEqualTo(0);
    }

    @When("I remove the character from the grid")
    public void iRemoveTheCharacterFromTheGrid() {
        grid.removeCharacter(character);
    }

    @Then("the grid at {int}, {int} is empty")
    public void theGridAtIsEmpty(int x, int y) {
        assertThat(grid.getTile(x, y)).isEqualTo(0);
    }
}
