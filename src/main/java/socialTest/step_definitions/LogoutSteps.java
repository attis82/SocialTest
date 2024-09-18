package socialTest.step_definitions;

import io.cucumber.java.en.When;
import socialTest.StateContainer;
import socialTest.URLS;

public class LogoutSteps {
    @When("We click logout button")
    public void clickLogoutButton() {
        StateContainer.getMainPage().clickLogoutButton();
        StateContainer.waitForUrl(URLS.LOGIN.getUrl());
    }
}
