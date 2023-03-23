package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class SidebarButtonsSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public SidebarButtonsSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	

	@When("user clicks Greetings! button")
	public void user_clicks_greetings_button() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.clickSidebarGreetings();
	}
	@Then("greetings form is displayed")
	public void greetings_form_is_displayed() {
		welcome.SidebarGreetingsForm_isDisplayed();
		utility.driverTeardown(driver);
	}
	
	@When("user clicks Registration form button")
	public void user_clicks_registration_form_button() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.clickSidebarRegister();
	}
	@Then("registratio form is displayed")
	public void registratio_form_is_displayed() {
		welcome.SidebarRegisterForm_isDisplayed();
		utility.driverTeardown(driver);
	}
	
	@When("user clicks Site statue button")
	public void user_clicks_site_statue_button() throws InterruptedException {
		welcome = utility.getWelcomePage();
		welcome.clickSidebarStatue();
	}
	@Then("statue form is displayed")
	public void statue_form_is_displayed() {
		welcome.SidebarStatueForm_isDisplayed();
		utility.driverTeardown(driver);
	}

}