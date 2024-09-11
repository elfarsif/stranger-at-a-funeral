package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.elfarsif.character.Character;
import static org.assertj.core.api.Assertions.assertThat;

public class CharaterStepDefinitions {

    Character character;

    @Given("I have no character")
    public void givenAccountBalance() {

    }

    @When("the character is created")
    public void whenAccountIsCredited() {
        character = new Character();
    }

    @Then("they are in the normal state")
    public void thenAccountShouldHaveBalance() {
        assertThat(this.character.getState()).isEqualTo("player.png");
    }


}
