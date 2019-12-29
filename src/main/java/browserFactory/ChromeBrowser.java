package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements BrowserDriver{

    public WebDriver getDriver() throws Exception {
        setDriverBinaryPath();
        return new ChromeDriver();
        }


    public void setDriverBinaryPath() {
        WebDriverManager.chromedriver().setup();

    }
}
    