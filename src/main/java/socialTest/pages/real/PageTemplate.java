package socialTest.pages.real;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageTemplate {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;
    private final Actions actions;

    public PageTemplate(String url, WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickAndWaitFor(int seconds,WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.click(element).pause(Duration.ofSeconds(seconds)).perform();
    }

    public void input(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(value);
    }
}
