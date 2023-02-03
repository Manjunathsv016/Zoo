package zoo_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;
import pom_repo.HomePage;

public class TC_Zoo_001 extends BaseClass {
	@Test
	public void login(){
		//Step 1:Clicking on Admin Nav Bar;
		homePage.getAdminNavBar().click();
		String expectedLoginPageTitle = driver.getTitle();
		Assert.assertEquals(ReadData.fromPropertyFile("actualLoginPageTitle"), expectedLoginPageTitle,
				"LoginPageTitle is not matching properly");
		Reporter.log("Landed Successfully to the Login Page of the Application",true);

		//Step 2:Entering valid credtials in LoginPage.
		String userNameData = ReadData.fromPropertyFile("userNameData").toString();
		sip.getUsernameTextField().sendKeys(userNameData,Keys.TAB);
		String enteredUserData = sip.getUsernameTextField().getAttribute("value");
		Assert.assertEquals(userNameData, enteredUserData, "Username data is not entered properly");

		String passwordData = ReadData.fromPropertyFile("passwordData").toString();
		sip.getPasswordTextField().sendKeys(passwordData);
		String enteredPasswordData = sip.getPasswordTextField().getAttribute("value");
		Assert.assertEquals(passwordData, enteredPasswordData, "Password data is not entered properly");

		sip.getSubmitButton().click();
		Reporter.log("Successfully clicked on Submit Button",true);
		String expectedDashboardTitle = driver.getTitle();
		String actualDashboardTitle = ReadData.fromPropertyFile("actualDashboardTitle").toString();
		Assert.assertEquals(actualDashboardTitle, expectedDashboardTitle, 
				"DashBoard Title is not matching properly");
		Reporter.log("Landed Successfully to the DashBoard Page of the Application",true);
	}
}
