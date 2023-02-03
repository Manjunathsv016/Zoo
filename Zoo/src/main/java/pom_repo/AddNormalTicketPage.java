package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNormalTicketPage {
	
	public AddNormalTicketPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="visitorname")
	private WebElement visitorName;
	
	@FindBy(id="noadult")
	private WebElement NoOfAdult;
	
	@FindBy(id="nochildren")
	private WebElement NoOfChildren;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Submit;

	public WebElement getVisitorName() {
		return visitorName;
	}

	public WebElement getNoOfAdult() {
		return NoOfAdult;
	}

	public WebElement getNoOfChildren() {
		return NoOfChildren;
	}

	public WebElement getSubmit() {
		return Submit;
	}

}
