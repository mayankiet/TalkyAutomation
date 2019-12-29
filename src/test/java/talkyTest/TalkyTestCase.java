package talkyTest;

import annotations.Author;
import annotations.TestCaseNotes;
import annotations.Tester;
import drivers.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TalkyTestCase extends TestBase{

    public WebDriver driver1;

    @BeforeTest
    public void startSecondInstance() throws Exception {
        driver1 = new DriverInitializer("chrome").init();
    }
	
    @Author(name = Tester.Mayank)
    @TestCaseNotes(Steps = "")
    @Test
    public void verifyUserShouldAbleToSearchProductAsGuest() throws Exception {
	    navigateTo(configReader.getBaseUrl());
        talkyPage.enterRoomAndStartChat();
        talkyPage.clickJoinTheCall();

        Thread.sleep(5000);
        driver1.get(configReader.getBaseUrl());
        talkyPage.enterRoomAndStartChat();
        talkyPage.clickJoinTheCall();
    }
}
