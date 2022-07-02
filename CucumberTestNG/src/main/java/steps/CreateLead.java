package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass {

	@When("Click on {string} link")
	public void clickLink(String option) {

		driver.findElement(By.linkText(option)).click();

	}

	@Then("{string} Page should be displayed")
	public void verifyPage(String pageName) {

		//System.out.println("Page displayed " + pageName +" Title : "
		//+driver.getTitle());
		boolean contains = driver.getTitle().contains(pageName);
		Assert.assertTrue(contains);
		/*
		 * if (driver.getTitle().contains(pageName)) System.out.println("In " +
		 * pageName); else System.out.println("Not in "+pageName);
		 */
	}

	@When("Enter Company name as {string}")
	public void enterCompanyName(String compName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
	}

	@When("Enter First name as {string}")
	public void enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@When("Enter Last name as {string}")
	public void enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@When("Click on create lead button")
	public void clickCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}

}
