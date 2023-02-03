package Generic_Libraries;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_repo.AddAnimalsPage;
import pom_repo.AddNormalTicketPage;
import pom_repo.BaseAdminPage;
import pom_repo.BaseDashboardPage;
import pom_repo.HomePage;
import pom_repo.ManageAnimalsPage;
import pom_repo.ManageTypePage;
import pom_repo.SignInPage;

public class BaseClass {
	public WebDriver driver;
	public Actions action;
	public WebDriverWait explicitWait;
	public HomePage homePage;
	public SignInPage sip;
	public BaseAdminPage adminPage;
	public BaseDashboardPage dashboardPage;
    public AddAnimalsPage addAnimalPage;
    public ManageAnimalsPage manageAnimalPage;
    public ManageTypePage manageTypePage;
    public AddNormalTicketPage normalTicketPage;

	@Parameters("browserName")

	@BeforeTest
	public void browserSetUp(@Optional("chrome") String bname) {
		// Step1:Launching a browser
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("Empty Chrome Browser is launched Successfully", true);
		} else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Reporter.log("Empty Edge Browser is launched Successfully", true);
		} else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("Empty FireFox Browser is launched Successfully", true);
		} else if (bname.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			Reporter.log("Empty Opera Browser is launched Successfully", true);
		} else {
			throw new InvalidBrowserValueException();
		}
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Reporter.log("Browser Window is maximized", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Step2:Navigating to the url of the application.
		driver.navigate().to(ReadData.fromPropertyFile("url").toString());

		String expectedTitle = driver.getTitle();
		Assert.assertEquals(ReadData.fromPropertyFile("actualHomePageTitle"), expectedTitle,
				"Home Page Is not Displayed");
		Reporter.log("Landed Succesfully to the Home Page of the application", true);
		homePage=new HomePage(driver);
		sip=new SignInPage(driver);
		adminPage=new BaseAdminPage(driver);
		dashboardPage=new BaseDashboardPage(driver);
		addAnimalPage=new AddAnimalsPage(driver);
		manageAnimalPage=new ManageAnimalsPage(driver);
		manageTypePage=new ManageTypePage(driver);
		normalTicketPage=new AddNormalTicketPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void browserTermination() {
		//driver.quit();
	}

}

class InvalidBrowserValueException extends RuntimeException {
	InvalidBrowserValueException() {
		super("Invalid Browser value is passed");
	}
}
