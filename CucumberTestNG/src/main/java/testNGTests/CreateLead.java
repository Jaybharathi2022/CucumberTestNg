package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testNGHelpers.TestBase;

public class CreateLead extends TestBase {

	@BeforeClass
	public void setFileName() {
		fileName="createLead";
	}
	
	@Test(dataProvider = "getData") 
	public void createLead(String compName,String firstName,String lastName) throws InterruptedException {
		
		// click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Lead")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);

		WebElement eleSourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select selectSource = new Select(eleSourceDropDown);

		selectSource.selectByVisibleText("Conference");

		driver.findElement(By.name("submitButton")).click();

		Thread.sleep(5000);

		System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
	}

}
