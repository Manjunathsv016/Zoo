package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTypePage {
	public ManageTypePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='1']/..//a[text()='Edit']")
	private WebElement edit1;
	
	@FindBy(xpath="//td[text()='2']/..//a[text()='Edit']")
	private WebElement edit2;
	
	@FindBy(xpath="//td[text()='3']/..//a[text()='Edit']")
	private WebElement edit3;
	
	@FindBy(xpath="//td[text()='4']/..//a[text()='Edit']")
	private WebElement edit4;
	
	@FindBy(id = "tprice")
	private WebElement ticketCost;

	public WebElement getTicketCost() {
		return ticketCost;
	}

	public WebElement getEdit1() {
		return edit1;
	}

	public WebElement getEdit2() {
		return edit2;
	}

	public WebElement getEdit3() {
		return edit3;
	}

	public WebElement getEdit4() {
		return edit4;
	}

}
