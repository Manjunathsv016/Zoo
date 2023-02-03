package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseDashboardPage {
	public BaseDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText = "Animals Details")
	private WebElement animaldetails;
	
	@FindBy(linkText = "Add Animals")
	private WebElement addAnimalsdetails;
	
	@FindBy(linkText = "Manage Animals")
	private WebElement manageAnimalsdetails;
	
	@FindBy(partialLinkText  = "Manage Type Ticket")
	private WebElement manageTypeTicket;
	
	@FindBy(linkText = "Normal Ticket")
	private WebElement normalTicket;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicket;
	
	@FindBy(linkText = "Manage Ticket")
	private WebElement manageTicket;
	
	@FindBy(linkText = "Foreigners Ticket")
	private WebElement foreignersTicket;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement foreignersaddTicket;
	
	@FindBy(linkText = "Manage Ticket")
	private WebElement foreignersmanageTicket;
	
	@FindBy(linkText = "Page")
	private WebElement page;
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUs;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUs;
	
	@FindBy(linkText = "Reports")
	private WebElement reports;
	
	@FindBy(linkText = "Normal People Report")
	private WebElement normalPeopleReport;
	
	@FindBy(linkText = "Foreigner People Report")
	private WebElement foreignerPeopleReport;
	
	@FindBy(linkText = "Search")
	private WebElement toSearch;
	
	@FindBy(linkText = "Normal Ticket Search")
	private WebElement toSearchNormalTicket;
	
	@FindBy(linkText = "Foreigner Ticket Search")
	private WebElement toSearchForeignersTicket;

	public WebElement getAnimaldetails() {
		return animaldetails;
	}

	public WebElement getAddAnimalsdetails() {
		return addAnimalsdetails;
	}

	public WebElement getManageAnimalsdetails() {
		return manageAnimalsdetails;
	}

	public WebElement getManageTypeTicket() {
		return manageTypeTicket;
	}

	public WebElement getNormalTicket() {
		return normalTicket;
	}

	public WebElement getAddTicket() {
		return addTicket;
	}

	public WebElement getManageTicket() {
		return manageTicket;
	}

	public WebElement getForeignersTicket() {
		return foreignersTicket;
	}

	public WebElement getForeignersaddTicket() {
		return foreignersaddTicket;
	}

	public WebElement getForeignersmanageTicket() {
		return foreignersmanageTicket;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getNormalPeopleReport() {
		return normalPeopleReport;
	}

	public WebElement getForeignerPeopleReport() {
		return foreignerPeopleReport;
	}

	public WebElement getToSearch() {
		return toSearch;
	}

	public WebElement getToSearchNormalTicket() {
		return toSearchNormalTicket;
	}

	public WebElement getToSearchForeignersTicket() {
		return toSearchForeignersTicket;
	}
}
