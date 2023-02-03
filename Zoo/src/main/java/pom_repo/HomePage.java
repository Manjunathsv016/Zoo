package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Animals")
	private WebElement animalNavBar;

	@FindBy(linkText = "Admin")
	private WebElement adminNavBar;

	public WebElement getAnimalNavBar() {
		return animalNavBar;
	}

	public WebElement getAdminNavBar() {
		return adminNavBar;
	}	
}

