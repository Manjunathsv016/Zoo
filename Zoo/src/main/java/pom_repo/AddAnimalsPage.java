package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAnimalsPage {
	public AddAnimalsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="aname")
	private WebElement AnimalName;
	
	@FindBy(id="image")
	private WebElement uploadImage;
	
	@FindBy(id="cnum")
	private WebElement cageNumber;
	
	@FindBy(id="fnum")
	private WebElement feedNumber;
	
	@FindBy(id="breed")
	private WebElement breed;
	
	@FindBy(id="desc")
	private WebElement description;
	
	@FindBy(name = "submit")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAnimalName() {
		return AnimalName;
	}

	public WebElement getUploadImage() {
		return uploadImage;
	}

	public WebElement getCageNumber() {
		return cageNumber;
	}

	public WebElement getFeedNumber() {
		return feedNumber;
	}

	public WebElement getBreed() {
		return breed;
	}

	public WebElement getDescription() {
		return description;
	}
	
}
