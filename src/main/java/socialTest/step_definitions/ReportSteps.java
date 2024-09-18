package socialTest.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import org.junit.Assert;

public class ReportSteps {
    @When("The user reports post {string}")
    public void the_user_reports_post(String post) {
        StateContainer.getMainPage().reportPost(post,0);
    }

    @Then("A popup shows that the report was successful")
    public void successful_popup() {
        String expectedPopupText = "Your report was successful!";
        boolean isPopupTextEquals = StateContainer.getMainPage().reportAlertTextEquals(expectedPopupText);
        Assert.assertTrue("Popup text should be: "+expectedPopupText, isPopupTextEquals);
    }

    @Then("A popup shows that the report was already made")
    public void aPopupShowsThatTheReportWasAlreadyMade() {
        String expectedPopupText = "You already reported this post!";
        boolean isPopupTextEquals = StateContainer.getMainPage().reportAlertTextEquals(expectedPopupText);
        Assert.assertTrue("Popup text should be: "+expectedPopupText, isPopupTextEquals);
    }

    @When("The user reports post {string} twice")
    public void theUserReportsPostTwice(String post) {
        StateContainer.getMainPage().reportPostTwice(post);
    }
}
