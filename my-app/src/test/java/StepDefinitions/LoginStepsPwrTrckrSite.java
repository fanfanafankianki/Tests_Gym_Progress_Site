package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepsPwrTrckrSite {
	
	WebDriver driver = null;
	LoginPage login;
	HomePage home;
	private SeleniumUtility utility;
	
	public LoginStepsPwrTrckrSite(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver=utility.getDriver();
		driver.navigate().to("https://lichess.org/login?referrer=/");
	}
	
	@When("user enters unvalid username and password")
	public void user_enters_unvalid_username_and_password() throws InterruptedException {
		login = utility.getLoginPage();
		login.enterUsername("Habiba");
		login.enterPassword("Kebaby123");
	}

	@When("user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
		login = utility.getLoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		login.clickLogin();
		Thread.sleep(4000);

	}

	@Then("user is navigated to the logged page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		logged = utility.getLoggedPage();
	}

	@And("user username is displayed in right corner")
	public void user_username_is_displayed_in_right_corner() {
		logged.usernameIsDisplayed();
		utility.driverTeardown(driver);
	}
}