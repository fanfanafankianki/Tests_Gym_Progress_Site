package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.TestContext;
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
		logged.clickSiteIconX();
		logged.clickSidebarAddProfileTextSend();
	}
	
	@Then("new profile is created")
	public void new_profile_is_created() {
	    logged.clickSidebarProfile();
	}
	
	@Then("profile have (.*) inserted by user$")
	public void profile_have_profilename_inserted_by_user(String profilename) {
	    logged.isTextPresentInProfile(profilename);
		utility.driverTeardown(driver);
	}

	@When("user clicks Add training button")
	public void user_clicks_add_training_button() throws InterruptedException {
		logged = utility.getLoggedPage();
		logged.clickSidebarProfileAddTraining();
	}
	
	@When("user insert training informations into textboxes")
	public void user_insert_training_informations_into_textboxes() {
		logged.clickSiteIconX();
		logged.addTrainingToProfile("Training1","Exercise1","Exercise2","Exercise3");
	}
	
	@Then("new training is created")
	public void new_training_is_created() {
	    logged.isTextPresentInProfile("Training1");
		utility.driverTeardown(driver);
	}
	
	@When("user clicks trening1 button")
	public void user_clicks_trening1_button() throws InterruptedException {
		logged = utility.getLoggedPage();
		Thread.sleep(1000);
		logged.clickSiteIconX();
		logged.clickSidebarProfileTraining();
	}
	
	@When("user insert training history informations into chooseboxes")
	public void user_insert_training_history_informations_into_chooseboxes() {
		logged.chooseSidebarProfileTrainingWeightAndReps();
	}
	
	@When("user clicks Send button")
	public void user_clicks_send_button() {
		logged.clickSidebarProfileTrainingSend();
	}
	
	@Then("user is redirected to logged page")
	public void user_is_redirected_to_logged_page() throws InterruptedException {
		Thread.sleep(200);
		logged = utility.getLoggedPage();
		utility.driverTeardown(driver);
	}

	
}