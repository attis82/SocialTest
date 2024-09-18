package socialTest.step_definitions;

import io.cucumber.java.en.Given;
import socialTest.StateContainer;
import socialTest.URLS;

public class CredentialSteps {
    @Given("We are logged in with {string} : {string} credentials")
    public void loginAs(String username, String password) {
        StateContainer.get(URLS.LOGIN.getUrl());
        StateContainer.getLoginPage().login(username, password);
        StateContainer.waitForUrl(URLS.MAIN.getUrl()+"/");
    }
}
