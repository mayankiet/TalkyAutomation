package pages;

import drivers.DriverProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TalkyPage extends BasePage {

	@FindBy(css = ".create-room-form-input")
	private WebElement roomField;

	@FindBy(css = ".create-room-form-button.button.button-default.button-undefined")
	private WebElement startChat;

	@FindBy(css = ".sc-iwsKbI.sc-jKJlTe.hsPRMM")
	private WebElement joinTheCall;

	@FindBy(css = ".sc-dnqmqq.bDmzHR")
	private WebElement chatBox;

	@FindBy(css = ".sc-bxivhb.fVksPc")
	private WebElement messageBox;

	@FindBy(xpath = "//span[text() = 'Allow camera access']")
	private WebElement allowCamera;

	@FindBy(xpath = "//span[text() = 'Allow microphone access']")
	private WebElement allowMicrophone;
	
	public TalkyPage() {
		driver = DriverProvider.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void enterRoomAndStartChat(){
		roomField.sendKeys("Conf room");
		startChat.click();
	}

	public void clickJoinTheCall(){
		joinTheCall.click();
	}

	public void clickOnChatBox(){
		chatBox.click();
	}

	public void allowCamera(){
		allowCamera.click();
	}


	public void allowMicrophone(){
		allowMicrophone.click();
	}

	public void acceptAllowPopUp(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public void verifyBothUserInSameRoom(String room1, String room2){
		Assert.assertEquals(room1, room2, "Both users are not landed on same room");
	}
}
