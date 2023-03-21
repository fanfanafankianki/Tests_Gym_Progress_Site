package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoggedPage;
import pages.WelcomePage;

public class RegisterStepsPwrTrckrSite {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public RegisterStepsPwrTrckrSite(StepDefinitions.SeleniumUtility utility) {
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
		welcome = utility.getWelcomePage();
		welcome.enterUsername("Habiba");
		welcome.enterPassword("Kebaby123");
	}

	@When("user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterUsername(username);
		welcome.enterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		welcome.clickLogin();
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