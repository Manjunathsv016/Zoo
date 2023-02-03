package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseAdminPage {
	public BaseAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement adminDropDown;

	@FindBy(linkText = "Profile")
	private WebElement profileLink;

	@FindBy(linkText = "Settings")
	private WebElement settingsLink;

	@FindBy (linkText = "Log Out")
	private WebElement logOutLink;

	@FindBy(id = "adminname")
	private WebElement adminNameTextField;

	@FindBy(id="username")
	private WebElement userNameTextField;

	@FindBy(id="contactnumber")
	private WebElement contactNumberTextField;

	@FindBy(id="email")
	private WebElement emailAddressTextField;

	@FindBy(id="regdate")
	private WebElement registrationDateTextField;

	@FindBy(name = "submit")
	private WebElement updateButton;

	public WebElement getAdminNameTextField() {
		return adminNameTextField;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getContactNumberTextField() {
		return contactNumberTextField;
	}

	public WebElement getEmailAddressTextField() {
		return emailAddressTextField;
	}

	public WebElement getRegistrationDateTextField() {
		return registrationDateTextField;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getAdminDropDown() {
		return adminDropDown;
	}

	public WebElement getProfileLink() {
		return profileLink;
	}

	public WebElement getSettingsLink() {
		return settingsLink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}
}
