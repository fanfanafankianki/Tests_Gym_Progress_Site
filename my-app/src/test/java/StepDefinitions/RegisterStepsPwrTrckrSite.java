package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class RegisterStepsPwrTrckrSite {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public RegisterStepsPwrTrckrSite(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	
	@When("user enters invalid (.*) and (.*) and (.*)$")
	public void user_enters_invalid_username_and_email_and_password(String username, String email, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterRegisterUsername(username);
		welcome.enterRegisterEmail(email);
		welcome.enterRegisterPassword(password);
	}

	@When("user enters valid (.*) and (.*) and (.*)$")
	public void user_enters_valid_username_and_email_and_password(String username, String email, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterRegisterUsername(username);
		welcome.enterRegisterEmail(email);
		welcome.enterRegisterPassword(password);
	}

	@And("click on register button")
	public void click_on_register_button() throws InterruptedException {
		welcome.clickRegister();
		Thread.sleep(4000);

	}

	@Then("user is navigated to the welcome page")
	public void user_is_navigated_to_the_welcome_page() throws InterruptedException {
		logged = utility.getLoggedPage();
	}

	@And("welcome page is displayed")
	public void welcome_page_is_displayed() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.imgIsDisplayed();
		utility.driverTeardown(driver);
	}
	
	@Then("register error text is displayed")
	public void register_error_text_is_displayed() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.registerErrorIsDisplayed();
		utility.driverTeardown(driver);
	}
}