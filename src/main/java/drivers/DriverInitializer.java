package drivers;

import browserFactory.ChromeBrowser;
import browserFactory.FirefoxBrowser;
import org.openqa.selenium.WebDriver;
import utilities.Browsers;

public class DriverInitializer {

    private String browser;

    public DriverInitializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() throws Exception {

        WebDriver webDriver = null;

        if (Browsers.FIREFOX.equals(browser)) {
            webDriver = new FirefoxBrowser().getDriver();
        } else {
            webDriver = new ChromeBrowser().getDriver();
        }

        DriverProvider.setDriver(webDriver);
        return webDriver;
    }

}