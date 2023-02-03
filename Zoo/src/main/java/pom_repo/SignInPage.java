package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
public SignInPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id = "username")
private WebElement usernameTextField;

@FindBy(id = "password")
private WebElement passwordTextField;

@FindBy(id = "form_submit")
private WebElement submitButton;

public WebElement getUsernameTextField() {
	return usernameTextField;
}

public WebElement getPasswordTextField() {
	return passwordTextField;
}

public WebElement getSubmitButton() {
	return submitButton;
}
}
