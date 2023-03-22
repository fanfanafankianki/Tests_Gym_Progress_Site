package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class CalculatorSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public CalculatorSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}

	@Given("user is on welcome page")
	public void user_is_on_welcome_page() throws InterruptedException {
		driver=utility.getDriver();
		driver.navigate().to("http://localhost/Gym_Site/welcome.php");
	}
	
	@When("user enters invalid username and password")
	public void user_enters_unvalid_username_and_password(String username, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterLoginUsername(username);
		welcome.enterLoginPassword(password);
	}

	@When("user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterLoginUsername(username);
		welcome.enterLoginPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		welcome.clickLogin();
		Thread.sleep(4000);

	}

	@Then("user is navigated to the logged page")
	public void user_is_navigated_to_the_logged_page() throws InterruptedException {
		logged = utility.getLoggedPage();
	}

	@And("user username is displayed in left corner")
	public void user_username_is_displayed_in_left_corner() {
		logged.usernameIsDisplayed();
		utility.driverTeardown(driver);
	}
	
	@Then("login error text is displayed")
	public void login_error_text_is_displayed() throws InterruptedException {
		logged = utility.getLoggedPage();
	}
}