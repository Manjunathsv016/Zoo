package zoo_Module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;

public class TC_Zoo_003 extends BaseClass {
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
	public void addAnimal() {

		dashboardPage.getAnimaldetails().click();
		dashboardPage.getAddAnimalsdetails().click();
		
		//Step 3:Adding Animals.
		String animalName = ReadData.fromPropertyFile("animalName").toString();
		addAnimalPage.getAnimalName().sendKeys(animalName,Keys.TAB);
		String enteredAnimalName = addAnimalPage.getAnimalName().getAttribute("value");
		Assert.assertEquals(animalName, enteredAnimalName, "Animal Name Data is not entered correctly");

		addAnimalPage.getUploadImage().sendKeys("C:\\Images\\Lion.jpeg");

		String cageNumberTextField = ReadData.fromPropertyFile("cageNumber").toString();
		addAnimalPage.getCageNumber().sendKeys(cageNumberTextField,Keys.TAB);
		String enteredCageNumber = addAnimalPage.getCageNumber().getAttribute("value");
		Assert.assertEquals(cageNumberTextField, enteredCageNumber, "Cage Number Data is not entered correctly");
		String actualFeedNumber = ReadData.fromPropertyFile("feedNumber").toString();
		addAnimalPage.getFeedNumber().sendKeys(actualFeedNumber,Keys.TAB);
		String enteredFeedNumber = addAnimalPage.getFeedNumber().getAttribute("value");
		Assert.assertEquals(actualFeedNumber, enteredFeedNumber, "Feed Number Data is not entered correctly");

		String breedTextField = ReadData.fromPropertyFile("breed").toString();
		addAnimalPage.getBreed().sendKeys(breedTextField,Keys.TAB);		
		String enteredBreedName = addAnimalPage.getBreed().getAttribute("value");
		Assert.assertEquals(breedTextField, enteredBreedName, "Breed Data is not entered correctly");
		String actualdescription = ReadData.fromPropertyFile("description").toString();
		addAnimalPage.getDescription().sendKeys(actualdescription);
		String enteredDescription = addAnimalPage.getDescription().getAttribute("value");
		Assert.assertEquals(actualdescription, enteredDescription, "Description is not entered correctly");

		addAnimalPage.getSubmitButton().click();

		Alert animalAdded = driver.switchTo().alert();
		String confirmAddAnimal = ReadData.fromPropertyFile("addAnimalPopUp").toString();
		String popUpMsg = animalAdded.getText();
		animalAdded.accept();
		Assert.assertEquals(confirmAddAnimal, popUpMsg, "Animal is not added Successfully");
		Reporter.log("Successfully Added the Animal",true);
	}
}
