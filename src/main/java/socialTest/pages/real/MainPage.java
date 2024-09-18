package socialTest.pages.real;

import org.openqa.selenium.By;
import socialTest.pages.component.DarkModePage;
import socialTest.pages.component.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MainPage extends PageTemplate implements DarkModePage, LogoutPage {
    public static final String URL = "http://localhost:5173";
    @FindBy(className = "App")
    private WebElement AppDiv;

    @FindBy(className = "darkLightBtn")
    private WebElement darkLightButton;

    @FindBy(xpath = "//span[contains(text(), 'Create new Post')]")
    private WebElement createPostButton;

    @FindBy(xpath = "//div[@class='onePost']")
    private List<WebElement> sectionList;

    @FindBy(tagName = "p")
    private List<WebElement> paragraphs;

    @FindBy(className = "images")
    private List<WebElement> images;

    @FindBy(xpath = "//button[contains(text(),'Report post') and @class='reportButton']")
    private WebElement reportPostButton;
    @FindBy(xpath = "//button[@class='reportReasonsBtn']")
    private List<WebElement> reportReasonsBtnList;
    @FindBy(xpath = "//div[@class='Toastify']")
    private WebElement toastifyAlertPopup;

    @FindBy(className = "logOutBtn")
    private WebElement logoutButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(URL, driver, wait);
    }

    @Override
    public boolean isDark() {
        return AppDiv.getAttribute("id").equals("dark");
    }

    @Override
    public void clickDarkModeButton() {
        click(darkLightButton);
    }

    @Override
    public void clickLogoutButton() {
        click(logoutButton);
    }

    public void likePost(String postDescription) {
        WebElement post = findPost(postDescription);
        if (post != null) {
            WebElement likeButton = post.findElement(By.xpath("//*[@class='heart']"));
            likeButton.click();
        } else {
            System.out.println("Post not found");
        }
    }

    public void likePicturePost(String postDescription) {
        WebElement post = findPost(postDescription);
        Actions actions = new Actions(driver);
        if (post != null) {
            WebElement picture = post.findElement(By.xpath("//*[@class='picture']"));
            String src = picture.getAttribute("src");
            if (src != null && !src.isEmpty()) {
                actions.doubleClick(picture).perform();
            } else {
                System.out.println("Picture not uploaded for the post");
            }
        } else {
            System.out.println("Post not found");
        }
    }

    public boolean isPostLiked(String postDescription) {
        WebElement post = findPost(postDescription);
        if (post != null) {
            WebElement likeButton = post.findElement(By.xpath("//*[@class='heart']"));
            WebElement pathElement = likeButton.findElement(By.tagName("path"));
            String fillValue = pathElement.getAttribute("fill");
            return "#F44336".equals(fillValue);
        } else {
            return false;
        }
    }

    public void clickCreatePostButton() {
        createPostButton.click();
    }

    public void reportPost(String postDescription, int delay) {
        clickThreeDotsFromPost(postDescription);
        reportPostButton.click();
        int randomIndex = (int) (Math.random() * reportReasonsBtnList.size());
        clickAndWaitFor(delay,reportReasonsBtnList.get(randomIndex));
    }

    public void reportPostTwice(String postDescription) {
        reportPost(postDescription, 6);
        reportPostButton.click();
        int randomIndex = (int) (Math.random() * reportReasonsBtnList.size());
        reportReasonsBtnList.get(randomIndex).click();
    }



    public void clickThreeDotsFromPost(String postDescription) {
        WebElement post = findPost(postDescription);
        WebElement threeDots = post.findElement(By.xpath(".//button[contains(text(),'...')]"));
        threeDots.click();
    }

    private WebElement findPost(String postDescription) {
        for (WebElement post : sectionList) {
            if (post.getText().contains(postDescription)) {
                return post;
            }
        }
        System.out.println("Did not found post!");
        return null;
    }

    public boolean reportAlertTextEquals(String expectedText) {
        fluentWait.until(driver -> {
            WebElement element = driver.findElement(By.xpath("//div[@class='Toastify']"));
            if (element.getText().equals(expectedText)) {
                return element;
            }
            return null;
        });
        return toastifyAlertPopup.getText().equals(expectedText);
    }


    public boolean isPresent(String postDescription) {
        return paragraphs.stream().anyMatch(p -> p.getAttribute("innerText").equals(postDescription));
    }

    public boolean imageIsPresent(String imgAlt){
        return images.stream().anyMatch(i -> i.getAttribute("alt").equals(imgAlt));
    }
}
