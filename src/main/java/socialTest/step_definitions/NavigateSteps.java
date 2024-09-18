package socialTest.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import socialTest.URLS;
import org.junit.Assert;

public class NavigateSteps {
    @Given("We are on the {word} page")
    public void weAreOnPage(String page) {
        String url = URLS.getUrlByName(page);
        StateContainer.get(url);
        StateContainer.getPage(URLS.getPageClassByName(page));
    }

    @Then("Page changes to {word} page")
    public void pageChangesTo(String page) {
        String expectedUrl = URLS.getUrlByName(page);
        StateContainer.waitForUrl(expectedUrl);
        String actualUrl = StateContainer.getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl) || actualUrl.equals(expectedUrl + "/"));
    }

    @When("We refresh the page")
    public void refreshPage() {
        StateContainer.refreshPage();
    }
}
