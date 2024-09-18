package socialTest;

import socialTest.pages.PostPage;
import socialTest.pages.component.DarkModePage;
import socialTest.pages.component.LogoutPage;
import socialTest.pages.real.LoginPage;
import socialTest.pages.real.MainPage;
import socialTest.pages.real.PageTemplate;
import socialTest.pages.real.SignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StateContainer {
    private static final Duration WAIT_DURATION = Duration.ofSeconds(5);
    private static final Duration EXTRA_LAG = Duration.ofSeconds(0);

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static PageTemplate currentPage;

    private static final ClassMap<PageTemplate> pages = new ClassMap<>();


    private static ChromeDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_DURATION);
        ChromiumNetworkConditions conditions = new ChromiumNetworkConditions();
        conditions.setLatency(EXTRA_LAG);
        driver.setNetworkConditions(conditions);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createChromeDriver();
        }
        return driver;
    }

    private static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), WAIT_DURATION);
        }
        return wait;
    }

    public static void quitInstance() {
        if (driver == null) return;
        driver.quit();
        driver = null;
        wait = null;
    }

    public static void waitForUrl(String url) {
        wait = getWait();
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlToBe(url),
            ExpectedConditions.urlToBe(url+"/")
        ));
    }

    public static void get(String url) {
        getDriver().get(url);
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }


    private static <T extends PageTemplate> T getOrCreatePage(Class<T> classType) {
        if (!pages.containsKey(classType)) {
            createPageInstance(classType);
        }
        return (T) pages.get(classType);
    }

    private static <T extends PageTemplate> void  createPageInstance(Class<T> classType) {
        PageTemplate newInstance;
        try {
            newInstance = classType
                .getConstructor(WebDriver.class, WebDriverWait.class)
                .newInstance(getDriver(), getWait());
        } catch  (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
        pages.put(newInstance);

    }

    public static <T extends PageTemplate> T getPage(Class<T> classType) {
        T page = getOrCreatePage(classType);
        currentPage = page;
        return page;
    }

    public static MainPage getMainPage() {
        return getPage(MainPage.class);
    }
    public static LoginPage getLoginPage() {
        return getPage(LoginPage.class);
    }
    public static SignupPage getSignupPage() {
        return getPage(SignupPage.class);
    }
    public static PostPage getPostPage() {
        return getPage(PostPage.class);
    }

    public static DarkModePage getDarkModePage() {
        try {
            return ((DarkModePage) currentPage);
        } catch (ClassCastException e) {
            throw new RuntimeException("Page is not a DarkModePage", e);
        }
    }

    public static LogoutPage getLogoutPage() {
        try {
            return ((LogoutPage) currentPage);
        } catch (ClassCastException e) {
            throw new RuntimeException("Page is not a LogoutPage", e);
        }
    }

    public static boolean alertIsPresent() {
        try{
            WebElement alertPopup = getDriver().findElement(By.xpath("//*[@role='alert']"));
            String alertText = alertPopup.getText();
            System.out.println("Alert found: "+alertText);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void refreshPage() {
        if (driver == null) throw new RuntimeException("Driver not initialized");
        driver.navigate().refresh();
    }
}
