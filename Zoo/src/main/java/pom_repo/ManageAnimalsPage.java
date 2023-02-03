package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAnimalsPage {
	
	public ManageAnimalsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='1']/..//a[text()='Edit']")
	private WebElement Edit1;
	
	@FindBy(xpath="//td[text()='1']/..//a[text()='Delete']")
	private WebElement Delete1;

	@FindBy(xpath="//td[text()='2']/..//a[text()='Edit']")
	private WebElement Edit2;
	
	@FindBy(xpath="//td[text()='2']/..//a[text()='Delete']")
	private WebElement  Delete2;
	
	@FindBy (xpath="//td[text()='3']/..//a[text()='Edit']")
	private WebElement Edit3;
	
	@FindBy(xpath="//td[text()='3']/..//a[text()='Delete']")
	private WebElement Delete3;
	
	@FindBy(xpath="//td[text()='4']/..//a[text()='Edit']")
	private WebElement Edit4;
	
	@FindBy(xpath="//td[text()='4']/..//a[text()='Delete']")
	private WebElement Delete4;
	
	@FindBy(xpath="//td[text()='5']/..//a[text()='Edit']")
	private WebElement Edit5;
	
	@FindBy(xpath="//td[text()='5']/..//a[text()='Delete']")
	private WebElement Delete5;
	
	@FindBy(xpath="//td[text()='6']/..//a[text()='Edit']")
	private WebElement Edit6;
	
	@FindBy(xpath="//td[text()='6']/..//a[text()='Delete']")
	private WebElement Delete6;
	
	@FindBy(xpath="//td[text()='7']/..//a[text()='Edit']")
	private WebElement Edit7;
	
	@FindBy(xpath="//td[text()='7']/..//a[text()='Delete']")
	private WebElement Delete7;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateButton;

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getEdit1() {
		return Edit1;
	}

	public WebElement getDelete1() {
		return Delete1;
	}

	public WebElement getEdit2() {
		return Edit2;
	}

	public WebElement getDelete2() {
		return Delete2;
	}

	public WebElement getEdit3() {
		return Edit3;
	}

	public WebElement getDelete3() {
		return Delete3;
	}

	public WebElement getEdit4() {
		return Edit4;
	}

	public WebElement getDelete4() {
		return Delete4;
	}

	public WebElement getEdit5() {
		return Edit5;
	}

	public WebElement getDelete5() {
		return Delete5;
	}

	public WebElement getEdit6() {
		return Edit6;
	}

	public WebElement getDelete6() {
		return Delete6;
	}

	public WebElement getEdit7() {
		return Edit7;
	}

	public WebElement getDelete7() {
		return Delete7;
	}
}


