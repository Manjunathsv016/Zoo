package zoo_Module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;

public class TC_Zoo_002 extends BaseClass {
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
	public void updateProfile() {
		//Step 3:Clicking on Admin Drop down to update profile.
		adminPage.getAdminDropDown().click();
		adminPage.getProfileLink().click();
		String expectedAdminProfilePageTitle = driver.getTitle();
		Assert.assertEquals(ReadData.fromPropertyFile("actualAdminProfilePageTitle"), expectedAdminProfilePageTitle, 
				"Admin Profile Page Tilte is not Matching correctly");

		//Step 4:Entering Data to Update Profile
		adminPage.getAdminNameTextField().clear();
		String adminName = ReadData.fromPropertyFile("adminName").toString();
		adminPage.getAdminNameTextField().sendKeys(adminName,Keys.TAB);
		String enteredAdminName = adminPage.getAdminNameTextField().getAttribute("value");
		Assert.assertEquals(adminName, enteredAdminName, "admin Name Data is not entered Properly");
		//adminPage.getUserNameTextField().clear();
		adminPage.getContactNumberTextField().clear();
		String contactNumber = ReadData.fromPropertyFile("contactNumber").toString();
		adminPage.getContactNumberTextField().sendKeys(contactNumber,Keys.TAB);
		String enteredContactNumber = adminPage.getContactNumberTextField().getAttribute("value");
		Assert.assertEquals(contactNumber, enteredContactNumber, "Contact Number Data is not entered Properly");
		adminPage.getEmailAddressTextField().clear();
		String emailAddressData = ReadData.fromPropertyFile("emailId").toString();
		adminPage.getEmailAddressTextField().sendKeys(emailAddressData,Keys.TAB);
		String enteredEmailAddress = adminPage.getEmailAddressTextField().getAttribute("value");
		Assert.assertEquals(emailAddressData, enteredEmailAddress, "Email address Data is not entered Properly");
		
		adminPage.getUpdateButton().click();
		Alert profileUpdated = driver.switchTo().alert();
		profileUpdated.accept();
		Reporter.log("Successfully Updated the Admin profile",true);
	}
}
