package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLead extends BaseClass {

	public String leadName;

	@When("Click on Email")
	public void clickEmail() {
		// Click on Email xpath
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}

	@Then("Email field should be displayed")
	public void verifyEmailField() {
		Assert.assertTrue(driver.findElement(By.name("emailAddress")).isDisplayed());
	}
	
	@When("Enter email as {string}")
	public void enterEmail(String email) {
		// Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys(email);
	}

	@Then("Capture the name of the lead")
	public void captureLeadName() {
		leadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
	}

	@When("Click on Create Lead button")
	public void clickCreateLead() throws InterruptedException  {
		// Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(3000);
	}

	@Then("Verify duplicated lead")
	public void verifyDuplicatedLead() {
		// Confirm the duplicated lead name is same as captured name
		String dupLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Assert.assertEquals(leadName, dupLeadName);
		
	}

	



}
