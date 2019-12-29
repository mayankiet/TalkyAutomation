package talkyTest;

import annotations.Author;
import annotations.TestCaseNotes;
import annotations.Tester;
import drivers.DriverInitializer;
import drivers.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testbase.TestBase;
import org.testng.Assert;

public class TalkyTestCase extends TestBase{

    public WebDriver driver1 = DriverProvider.getDriver();
	
    @Author(name = Tester.Mayank)
    @TestCaseNotes(Steps = "1. Go to the url" +
            "2. Choose the room name and start the chat" +
            "3. Allow microphone and camera." +
            "4. Join the call." +
            "5. Repeat the same steps, same room name as point 2 from another browser instance (other user)." +
            "6. Give a success if both the clients get connected.")
    @Test
    public void verifyUserShouldGetConnectedOnTalkyCall() throws Exception {
	    navigateTo(configReader.getBaseUrl());
        talkyPage.enterRoomAndStartChat();
        talkyPage.allowCamera();
        talkyPage.acceptAllowPopUp();
        talkyPage.allowMicrophone();
        talkyPage.acceptAllowPopUp();
        talkyPage.clickJoinTheCall();
        talkyPage.clickOnChatBox();
        String roomLink1 = driver.getCurrentUrl();

        driver1 = new DriverInitializer("chrome").init();
        driver1.get(configReader.getBaseUrl());
        driver1.manage().window().maximize();
        String secondWindow = driver1.getWindowHandle();
        driver1.switchTo().window(secondWindow);
        talkyPage.enterRoomAndStartChat();
        talkyPage.allowCamera();
        talkyPage.acceptAllowPopUp();
        talkyPage.allowMicrophone();
        talkyPage.acceptAllowPopUp();
        talkyPage.clickJoinTheCall();
        talkyPage.clickOnChatBox();
        String roomLink2 = driver1.getCurrentUrl();

        talkyPage.verifyBothUserInSameRoom(roomLink1, roomLink2);

    }
}
