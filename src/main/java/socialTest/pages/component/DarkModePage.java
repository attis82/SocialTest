package socialTest.pages.component;

public interface DarkModePage extends ComponentPage {
    void clickDarkModeButton();
    boolean isDark();

    default public void setDarkMode() {
        if (!isDark()) {
            clickDarkModeButton();
        }
    }

    default public void setLightMode() {
        if (isDark()) {
            clickDarkModeButton();
        }
    }

}
