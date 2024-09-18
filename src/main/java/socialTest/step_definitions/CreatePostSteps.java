package socialTest.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import socialTest.URLS;
import org.junit.Assert;

public class CreatePostSteps {

    String description = "";

    @When("user presses upload button")
    public void user_presses_upload_button() {
        description = "test" + System.currentTimeMillis();
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostPage().createPost(description);
    }

    @Then("image appears")
    public void image_appears() {
        Assert.assertTrue(StateContainer.getMainPage().imageIsPresent(description));
    }

    @When("user enters description")
    public void user_enters_description() {
        description = "test" + System.currentTimeMillis();
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostPage().makePost(description);
    }

    @Then("post appears on home feed")
    public void post_appears_on_home_feed() {
        Assert.assertTrue(StateContainer.getMainPage().isPresent("ati: " + description));
    }

    @When("user sends post with empty description")
    public void user_sends_post_with_empty_description() {
        description = "test" + System.currentTimeMillis();
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostPage().makePost(description);
    }

    @Then("post not appearing on main feed")
    public void post_not_appearing_on_main_feed() {
        Assert.assertEquals(URLS.POST.getUrl(), StateContainer.getCurrentUrl());
    }




}
