package socialTest.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        StateContainer.getLoginPage().goToSignUp();
    }

    @When("The user enters valid credentials")
    public void enterValidCredentials(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String username = data.get("username");
        String password = data.get("password");
        StateContainer.getLoginPage().login(username, password);
    }

    @When("The user enters invalid credentials")
    public void enterInvalidCredentials(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String username = data.get("username");
        String password = data.get("password");
        StateContainer.getLoginPage().login(username, password);
    }

    @When("The user leaves username or password field empty")
    public void leaveUsernameOrPasswordFieldEmpty() {
        StateContainer.getLoginPage().login("", "");
    }

    @Then("The site puts cursor in first empty input field")
    public void cursorInFirstEmptyInputField() {
        String message = "When the user leaves empty an input field and try to submit, the site throw the cursor into the first empty input field.";
        Assert.assertTrue(message, StateContainer.getLoginPage().isFieldInFocus("username"));
    }

    @Then("The page shows a popup")
    public void pageShowsPopup() {
        Assert.assertTrue("An alert should pop up when user tries to log in with invalid credentials.", StateContainer.alertIsPresent());
    }
}
