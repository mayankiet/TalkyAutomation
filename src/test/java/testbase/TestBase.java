package testbase;

import drivers.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TalkyPage;
import utilities.ConfigReader;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    protected ConfigReader configReader;
    protected TalkyPage talkyPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer("chrome").init();
        configReader = new ConfigReader();
        talkyPage = new TalkyPage();
    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   // @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}