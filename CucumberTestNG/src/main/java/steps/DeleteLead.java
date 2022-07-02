package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLead extends BaseClass {

	public String firstLead;

	@When("Click on the {string} link")
	public void clickLink(String input) {
		driver.findElement(By.xpath("//span[text()='" + input + "']")).click();
	}

	@Then("Phone Number text field should be displayed")
	public void verifyField() {
		boolean displayed = driver.findElement(By.xpath("//div[@class='x-plain-bwrap']//input[@name='phoneNumber']"))
				.isDisplayed();
		Assert.assertTrue(displayed);

	}

	@When("Enter phone number")
	public void enterPhoneNum() {
		driver.findElement(By.xpath("//div[@class='x-plain-bwrap']//input[@name='phoneNumber']")).sendKeys("99");
	}

	@When("Click on {string} button")
	public void clickButton(String text) {
		driver.findElement(By.xpath("//button[text()='"+text+"']")).click();
	}

	@Then("Lead List should be displayed")
	public void verifyLeadList() {
		boolean displayed = driver.findElement(By.xpath("//span[text()='Lead List']")).isDisplayed();
		Assert.assertTrue(displayed);

	}

	@When("Click on first lead")
	public void clickFirst() {
		WebElement eleFirstLead = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"));
		firstLead = eleFirstLead.getText();

		// Click First Resulting lead
		eleFirstLead.click();
	}

	@When("Enter lead id")
	public void enterLeadId() {
		driver.findElement(By.name("id")).sendKeys(firstLead);
	}

	@Then("Lead should not be displayed")
	public void verifyLeadDeleted() {
		System.out.println("----------");
		String leadDisplayed = driver.findElement(By.xpath("//div[@class ='x-paging-info']")).getText();
		System.out.println(leadDisplayed);
		Assert.assertEquals(leadDisplayed, "");
	}

}
