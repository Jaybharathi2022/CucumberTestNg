package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass {

	//public ChromeDriver driver;

	@Given("Open the Chrome Browser")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Load application url as {string}")
	public void loadURL(String url) {
		driver.get(url);
	}

	@Given("Enter username as {string}")
	public void enterUserName(String uName) {
		// enter username
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@Given("Enter password as {string}")
	public void enterPassword(String pwd) {
		// enter password
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on Login button")
	public void clickLogin() {
		// click login
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("HomePage should be displayed")
	public void verifyHomePage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		/*
		 * if (displayed) System.out.println("In Home page"); else
		 * System.out.println("Not in Home Page");
		 */
		
		Assert.assertTrue(displayed);

	
	}

	@But("Error message should be displayed")
	public void verifyErrorMessage() {

		boolean displayed = driver.findElement(By.id("errorDiv")).isDisplayed();
		if (displayed)
			System.out.println(driver.findElement(By.xpath("//div[@id='errorDiv']/p[2]")).getText());
		else
			System.out.println("Error message not displayed");

		
		
	
	}



}
