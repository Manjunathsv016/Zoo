package zoo_Module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;

public class TC_Zoo_006 extends BaseClass {
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
	public void manageTicketType() {
		dashboardPage.getManageTypeTicket().click();
		String expectedManageTypeTicketTitle = driver.getTitle();
		Assert.assertEquals(ReadData.fromPropertyFile("manageTypeTicketTitle"), expectedManageTypeTicketTitle,
				"Manage type ticket title is not matching propely");
		manageTypePage.getEdit1().click();
		manageTypePage.getTicketCost().clear();
		String ticketCostTextField = ReadData.fromPropertyFile("ticketCost").toString();
		manageTypePage.getTicketCost().sendKeys(ticketCostTextField,Keys.ENTER);

		Alert updatedTicketPopUp = driver.switchTo().alert();
		String actualUpdateTicketPopUpMsg = ReadData.fromPropertyFile("updateTicketPopUp").toString();
		String expectedUpdatedTicketPopUpMsg = updatedTicketPopUp.getText();
		updatedTicketPopUp.accept();
		Assert.assertEquals(actualUpdateTicketPopUpMsg, expectedUpdatedTicketPopUpMsg,
				"Ticket Is not updated successfully");
		Reporter.log("Successfully Updated the Ticket Type",true);
	}

}
