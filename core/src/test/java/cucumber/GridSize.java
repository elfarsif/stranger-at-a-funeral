package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.Grid;

import static org.assertj.core.api.Assertions.assertThat;

public class GridSize {
    Grid grid;

    @Given("I have no grid")
    public void iHaveNoGrid() {
    }

    @When("I create a grid")
    public void iCreateAGrid() {
        grid = new Grid();
    }

    @Then("the grid is {int}, {int}")
    public void theGridIs(int width, int height) {
        assertThat(grid.getSize()).isEqualTo(new int[]{width, height});
    }
}
