package socialTest.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import org.junit.Assert;

public class DarkModeSteps {
    @Given("We are in dark mode")
    public void inDarkMode() {
        StateContainer.getDarkModePage().setDarkMode();
    }
    @Given("We are in light mode")
    public void inLightMode() {
        StateContainer.getDarkModePage().setLightMode();
    }

    @When("We click dark mode button")
    public void clickDarkMode() {
        StateContainer.getDarkModePage().clickDarkModeButton();
    }

    @Then("Page changes to dark mode")
    public void verifyDarkMode() {
        Assert.assertTrue(StateContainer.getDarkModePage().isDark());
    }

    @Then("Page changes to light mode")
    public void verifyLightMode() {
        Assert.assertFalse(StateContainer.getDarkModePage().isDark());
    }
}
