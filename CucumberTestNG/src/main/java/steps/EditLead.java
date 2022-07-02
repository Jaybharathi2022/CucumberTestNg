package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass {

	public WebElement eleCompanyName;

	@When("Enter firstName as {string}")
	public void enterFirstName(String fName) {
		// Enter first name
		driver.findElement(By.xpath("//div[@id='findLeads']//input[@name='firstName']")).sendKeys(fName);
	}

	@When("Clear company name")
	public void clearCompName() {

		eleCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));

		eleCompanyName.clear();

	}
	
	@Then("Company name should be cleared")
	public void verifyClear() {
		
	}

	@When("Update company name to {string}")
	public void enterCompName(String cName) {
		eleCompanyName.sendKeys(cName);
	}
	
	@When("Click on update {string} button")
	public void clickUpdate(String update) throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='"+update+"']")).click();
		Thread.sleep(3000);
	}
	
	@Then("Verify {string}  is updated")
	public void verifyUpdsate(String updName) {
		boolean contains = driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(updName);
		Assert.assertTrue(contains);
	}
	
	@Then("{string} edit Page should be displayed")
	public void verifyPage(String pageName)
	{
		
		Assert.assertEquals(driver.getTitle(), "opentaps CRM");
		
	}

	

}
