package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLeads extends BaseClass {

	public String parentWindow;
	public Alert alert;

	public void getParentWindow() {
		// get parent window handle
		parentWindow = driver.getWindowHandle();
	}

	@When("Click From lead")
	public void clickFromLead() {
		// click from lead
		driver.findElement(By.xpath("//span[text()='From Lead']/ancestor::tr//img")).click();
	}

	@When("Select {string} lead")
	public void selectLeads(String str) throws InterruptedException {
		selectLead(Integer.parseInt(str));
	}

	@When("Click To lead")
	public void clickToLead() {
		// click to lead
		driver.findElement(By.xpath("//span[text()='To Lead']/ancestor::tr//img")).click();
	}

	@Then("Confirmation alert should be displayed")
	public void confirmAlert() {
		alert = driver.switchTo().alert();
	}

	@When("Click ok in alert")
	public void acceptAlert() throws InterruptedException {
		alert.accept();
		Thread.sleep(3000);

	}

	public void selectLead(int i) throws InterruptedException {

		WebElement eleLeadId = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[" + i + "]//a"));
		System.out.println(eleLeadId.getText());

		if (eleLeadId.isEnabled())
			eleLeadId.click();
		// switch to parentWindow
		driver.switchTo().window(parentWindow);
	}

	@Then("Find Leads page should open in new window")
	public void switchWindow() {
		getParentWindow();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
	}

}
