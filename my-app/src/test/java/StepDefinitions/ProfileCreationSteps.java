package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class ProfileCreationSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public ProfileCreationSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}

	@When("user clicks Add New Profile")
	public void user_clicks_add_new_profile() throws InterruptedException {
		logged = utility.getLoggedPage();
		logged.clickSidebarAddProfile();
	}
	
	@When("input profile (.*) into textbox$")
	public void input_profile_testing_testname_into_textbox(String testname) {
		logged.sendKeys_SidebarAddProfileText(testname);
	}
	
	@When("clicks Add new profile button")
	public void clicks_add_new_profile_button() {
		logged.clickSidebarAddProfileTextSend();
	}
	
	@Then("new profile is created")
	public void new_profile_is_created() {
	    logged.clickSidebarProfile();
	}
	
	@Then("profile have (.*) inserted by user$")
	public void profile_have_profilename_inserted_by_user(String profilename) {
	    logged.isTextPresentInProfile(profilename);
	}

}