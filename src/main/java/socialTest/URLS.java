package socialTest;

import socialTest.pages.PostPage;
import socialTest.pages.real.LoginPage;
import socialTest.pages.real.MainPage;
import socialTest.pages.real.PageTemplate;
import socialTest.pages.real.SignupPage;

public enum URLS {
    MAIN(MainPage.class),
    LOGIN(LoginPage.class),
    SIGNUP(SignupPage.class),
    POST(PostPage.class);
    private final Class<? extends PageTemplate> pageClass;
    private URLS(Class<? extends PageTemplate> pageClass) {
        this.pageClass = pageClass;
    }
    public String getUrl() {
        try {
            return (String) this.pageClass.getDeclaredField("URL").get(null);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public Class<? extends PageTemplate> getPageClass() {
        return pageClass;
    }

    public static String getUrlByName(String name) {
        String cleanName = name.strip().toUpperCase();
        return URLS.valueOf(cleanName).getUrl();
    }

    public static Class<? extends PageTemplate> getPageClassByName(String name) {
        String cleanName = name.strip().toUpperCase();
        return URLS.valueOf(cleanName).getPageClass();
    }
}
