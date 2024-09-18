package socialTest.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import socialTest.StateContainer;
import org.junit.Assert;

public class LikePostSteps {
    @Given("A post {string} is made")
    public void a_post_has_been_made(String post) {
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostPage().makePost(post);
    }
    @Given("A post {string} is made and liked")
    public void a_post_has_been_made_and_liked(String post) {
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostPage().makePost(post);
        StateContainer.getMainPage().likePost(post);
    }
    @When("The user double clicks on picture {string}")
    public void the_user_likes_an_unliked_picture_post(String post) {
        StateContainer.getMainPage().likePicturePost(post);
    }
    @When("The user clicks on heart on {string}")
    public void the_user_likes_an_unliked_post(String post) {
        StateContainer.getMainPage().likePost(post);
    }

    @Then("The hearth icon becomes red at post {string}")
    public void the_hearth_icon_becomes_red(String post) {
        Assert.assertTrue(StateContainer.getMainPage().isPostLiked(post));
    }
    @Then("The hearth icon becomes white at post {string}")
    public void the_hearth_icon_becomes_white(String post) {
        Assert.assertFalse(StateContainer.getMainPage().isPostLiked(post));
    }
}
