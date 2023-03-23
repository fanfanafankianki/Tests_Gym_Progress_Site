package StepDefinitions;


import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class ProfileVisibilitySteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public ProfileVisibilitySteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}

	@Given("user clicks Chart button")
	public void user_clicks_chart_button() throws InterruptedException {
		logged = utility.getLoggedPage();
		logged.clickSidebarProfileCharts();
	}
	
	@When("user clicks Training1")
	public void user_clicks_training1() {
		logged.clickSidebarProfileChartsObject();
	}
	
	@When("user clicks <exercisename>")
	public void user_clicks_exercisename() {
		logged.clickSidebarProfileChartsObjectExercise();
	}
	
	@Then("chart is displayed")
	public void chart_is_displayed() {
		logged.checkSidebarProfileChartsObjectExerciseChart_is_displayed();
		utility.driverTeardown(driver);
	}
	
	@Given("user clicks Training history button")
	public void user_clicks_training_history_button() throws InterruptedException {
		logged = utility.getLoggedPage();
		Thread.sleep(1500);
		logged.clickSidebarProfileTrainingHistory();
	}
	
	@When("user click trainingname")
	public void user_click_training() {
		logged.clickSidebarProfileTrainingHistoryObject();
	}
	
	@When("user clicks training date")
	public void user_clicks_training_date() {
		logged.clickSidebarProfileTrainingHistoryObjectDate();
	}
	
	@Then("history table is displayed")
	public void history_table_is_displayed() {
		logged.checkSidebarProfileHistoryObjectDateTable_is_displayed();
		utility.driverTeardown(driver);
	}


	

}