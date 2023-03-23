package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class RegisterSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public RegisterSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	
	@When("user enter invalid (.*) and (.*) and (.*)$")
	public void user_enter_invalid_username_and_email_and_password(String username, String email, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterRegisterUsername(username);
		welcome.enterRegisterEmail(email);
		welcome.enterRegisterPassword(password);
	}

	@When("user enter valid (.*) and (.*) and (.*)$")
	public void user_enter_valid_username_and_email_and_password(String username, String email, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.enterRegisterUsername(username);
		welcome.enterRegisterEmail(email);
		welcome.enterRegisterPassword(password);
	}
	
	@When("user clicks register checkbox")
	public void user_clicks_register_checkbox() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.clickCheckboxRegister();
	}

	@And("click on register button")
	public void click_on_register_button() throws InterruptedException {
		welcome.clickRegister();
		Thread.sleep(4000);

	}

	@And("welcome page is displayed")
	public void welcome_page_is_displayed() throws InterruptedException {
		welcome = utility.getWelcomePage();
	}
	
	@Then("register error text is not displayed")
	public void register_error_text_is_not_displayed() throws InterruptedException {
		welcome = utility.getWelcomePage();
		Thread.sleep(1);
		welcome.registerErrorIsNotDisplayed();
		utility.driverTeardown(driver);
	}
	
	@Then("register error text is displayed")
	public void register_error_text_is_displayed() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.registerErrorIsDisplayed();
		utility.driverTeardown(driver);
	}
}