package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class LogoutSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public LogoutSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	
	@When("user clicks {string} button")
	public void user_clicks_button(String string) throws InterruptedException {
		logged = utility.getLoggedPage();
		logged.clickSiteIconX();
		logged.clickLogout();
	}
	@Then("user is navigated to the welcome page")
	public void user_is_navigated_to_the_welcome_page() throws InterruptedException {
		welcome = utility.getWelcomePage();
		utility.driverTeardown(driver);
	}


}