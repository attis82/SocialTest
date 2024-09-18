package socialTest.pages.real;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageTemplate {
    public static final String URL = "http://localhost:5173/login";

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(), 'Sign up now')]")
    private WebElement signUpBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(URL, driver, wait);
    }

    public void goToSignUp() {
        signUpBtn.click();
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public boolean isFieldInFocus(String fieldName) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = (WebElement) executor.executeScript("return document.activeElement;");
        if (fieldName.equals("username")) {
            return element.equals(this.username);
        } else if (fieldName.equals("password")) {
            return element.equals(this.password);
        }
        return false;
    }
}
