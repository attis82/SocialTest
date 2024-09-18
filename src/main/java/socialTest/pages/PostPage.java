package socialTest.pages;

import socialTest.StateContainer;
import socialTest.URLS;
import socialTest.pages.real.PageTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PostPage extends PageTemplate {
    public static final String URL = "http://localhost:5173/post/create";

    @FindBy(id = "description")
    public WebElement descriptionField;

    @FindBy(xpath = "//button[text()='Create Post']")
    public WebElement submitBtn;

    @FindBy(css = "input[type='file']")
    public WebElement imageInputText;


    public PostPage(WebDriver driver, WebDriverWait wait) {
        super(URL, driver, wait);
    }

    public void uploadImage() {
        File file = new File("src/main/resources/nrtc04qqwmpb1.jpg");
        imageInputText.sendKeys(file.getAbsolutePath());
    }

    public void fillDescription(String descriptionText) {
        this.descriptionField.clear();
        this.descriptionField.sendKeys(descriptionText);
    }


    public void makePost(String description) {
        descriptionField.sendKeys(description);
        submitBtn.click();
        StateContainer.waitForUrl(URLS.MAIN.getUrl());
    }

    public void submit() {
        submitBtn.click();
    }

    public void createPost(String description) {
        fillDescription(description);
        uploadImage();
        submit();
    }




}
