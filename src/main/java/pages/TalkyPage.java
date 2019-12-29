package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkyPage extends BasePage {

	@FindBy(css = ".create-room-form-input")
	private WebElement roomField;

	@FindBy(css = ".create-room-form-button.button.button-default.button-undefined")
	private WebElement startChat;

	@FindBy(css = ".sc-iwsKbI.sc-jKJlTe.hsPRMM")
	private WebElement joinTheCall;
	
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
}
