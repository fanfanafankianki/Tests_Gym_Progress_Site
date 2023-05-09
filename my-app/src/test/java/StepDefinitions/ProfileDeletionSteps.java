package StepDefinitions;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import StepDefinitions.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;


public class ProfileDeletionSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public ProfileDeletionSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}
	
	@Given("user clicked Training1")
	public void user_clicked_training1() throws InterruptedException {
		logged = utility.getLoggedPage();
	    logged.clickSidebarProfileTrainingHistoryObject();
	}
	
	@When("user clicks Delete this history record! and clicks Ok in first and second checkbox")
	public void user_clicks_delete_this_history_record_and_clicks_ok_in_first_and_second_checkbox() throws InterruptedException {
	    logged.clickSidebarProfileTrainingHistoryObjectDateDelete();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        Thread.sleep(2000);
        // prze³¹cz siê na drugi alert i zaakceptuj go
        alert = driver.switchTo().alert();
        alert.accept();
	}


	@When("user clicks Delete Profile")
	public void user_clicks_delete_profile() throws InterruptedException {
	    logged.clickSidebarProfileDeleteProfile();
	}
	
	@When("user clicks Delete Profile and clicks Ok in first and second checkbox")
	public void user_clicks_delete_profile_and_clicks_ok_in_first_and_second_checkbox() throws InterruptedException {
		logged = utility.getLoggedPage();
	    logged.clickSidebarProfileDeleteProfile();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        Thread.sleep(2000);
        // prze³¹cz siê na drugi alert i zaakceptuj go
        alert = driver.switchTo().alert();
        alert.accept();
	}
	
	@Given("user clicking Training1")
	public void user_clicking_training1() throws InterruptedException {
		logged = utility.getLoggedPage();
		logged.clickSidebarProfileTraining();
	}
	
	@When("user clicks Delete this training! and clicks Ok in first and second checkbox")
	public void user_clicks_delete_this_training_and_clicks_ok_in_first_and_second_checkbox() throws InterruptedException {
		logged.clickSiteIconX();
		logged.clickSidebarProfileTrainingDelete();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        Thread.sleep(2000);
        // prze³¹cz siê na drugi alert i zaakceptuj go
        alert = driver.switchTo().alert();
        alert.accept();
	}

	@Then("user is redirected to logged page and profile name is not displayed")
	public void user_is_redirected_to_logged_page_and_profile_name_is_not_displayed() {
		logged.isProfileNotDisplayed();
		utility.driverTeardown(driver);
	}
	
	@Then("user is redirected to logged page training name is not displayed")
	public void user_is_redirected_to_logged_page_training_name_is_not_displayed() {
		logged.isProfileTrainingNotDisplayed();
		utility.driverTeardown(driver);
	}

}