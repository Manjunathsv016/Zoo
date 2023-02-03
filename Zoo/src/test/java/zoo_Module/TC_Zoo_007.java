package zoo_Module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;

public class TC_Zoo_007 extends BaseClass {
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void addTicket() {
		dashboardPage.getNormalTicket().click();
		dashboardPage.getAddTicket().click();
		String expectedNormalTicketTitle = driver.getTitle();
		Assert.assertEquals(ReadData.fromPropertyFile("addNormalTicket"), expectedNormalTicketTitle,
				"AddNormalTicket Title is not matching properly");
		Reporter.log("Successfully landed in Add Normal Ticket Page",true);

		normalTicketPage.getVisitorName().clear();
		String actualVisitorName = ReadData.fromPropertyFile("visitorName").toString();
		normalTicketPage.getVisitorName().sendKeys(actualVisitorName);
		String expectedVisitorName = normalTicketPage.getVisitorName().getAttribute("value");
		Assert.assertEquals(actualVisitorName,expectedVisitorName 
				,"Visitor name Data is not entered correctly");

		normalTicketPage.getNoOfAdult().click();
		normalTicketPage.getNoOfAdult().clear();
		String actualNoOfAdults = ReadData.fromPropertyFile("noOfAdults").toString();
		normalTicketPage.getNoOfAdult().sendKeys(actualNoOfAdults);
		String expectedNoOfAdults = normalTicketPage.getNoOfAdult().getAttribute("value");
		Assert.assertEquals(actualNoOfAdults,expectedNoOfAdults
				,"No of Adults Data is not entered correctly");
		
		normalTicketPage.getNoOfChildren().click();
		normalTicketPage.getNoOfChildren().clear();
		String actualNoOfChildren = ReadData.fromPropertyFile("noOfChildren").toString();
		normalTicketPage.getNoOfChildren().sendKeys(actualNoOfChildren);
		String expectedNoOfChildren = normalTicketPage.getNoOfChildren().getAttribute("value");
		Assert.assertEquals(actualNoOfChildren,expectedNoOfChildren
				,"No of Children Data is not entered correctly");
		normalTicketPage.getSubmit().click();
		
		Alert generateTicket = driver.switchTo().alert();
		String expectedGeneratedTicketMsg = generateTicket.getText();
		generateTicket.accept();
		Assert.assertEquals(ReadData.fromPropertyFile("ticketGeneratedMsg"), expectedGeneratedTicketMsg,
				"Ticket is not generated Successfully");
		Reporter.log("Ticket is Generated Successfully",true);
	}
}
