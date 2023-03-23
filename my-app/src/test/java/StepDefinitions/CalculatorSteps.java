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
	
	@Given("user is on logged page")
	public void user_is_on_logged_page() throws InterruptedException {
		driver=utility.getDriver();
		driver.navigate().to("http://localhost/Gym_Site/welcome.php");
		welcome = utility.getWelcomePage();
		welcome.enterLoginUsername("Bartek");
		welcome.enterLoginPassword("Bartek");
		welcome.clickLogin();
		Thread.sleep(1000);
		logged = utility.getLoggedPage();
	}
	
	@When("user clicks BMI Calculator")
	public void user_clicks_bmi_calculator() {
		logged.clickSidebarBMICalculator();
	}
	@When("user inputs {int} and {int}")
	public void user_inputs_weight_and_height(Integer weight, Integer height) {
		logged.sendKeys_SidebarBMICalculator_Weight_Text(weight);
		logged.sendKeys_SidebarBMICalculator_Height_Text(height);
	}
	@When("user clicks Calculate BMI button")
	public void user_clicks_calculate_bmi_button() {
		logged.clickSidebarBMICalculatorTextSend();
	}
	@Then("BMI Calculator answer is displayed")
	public void bmi_calculator_answer_is_displayed() {
		logged.SidebarBMICalculatorAnswerIsDisplayed();
		utility.driverTeardown(driver);
	}

	@When("user clicks Calories Calculator")
	public void user_clicks_calories_calculator() {
		logged.clickSidebarCaloriesCalculator();
	}
	
	@When("user inputs {int} and {int} and {int}")
	public void user_inputs_weight_and_height_and_age(Integer weight, Integer height, Integer age) {
		logged.sendKeys_SidebarCaloriesCalculator_Weight_Text(weight);
		logged.sendKeys_SidebarCaloriesCalculator_Height_Text(height);
		logged.sendKeys_SidebarCaloriesCalculator_Age_Text(age);
	}

	@When("user chooses sex and activity in dropbox$")
	public void user_chooses_sex_and_activity_in_dropbox() {
	    logged.choose_SidebarCaloriesCalculator_Sex();
	    logged.choose_SidebarCaloriesCalculator_Activity();
	}
	
	@When("user clicks Calculate your caloric needs button")
	public void user_clicks_calculate_your_caloric_needs_button() {
		logged.clickSidebarCaloriesCalculatorTextSend();
	}
	
	@Then("Calories Calculator answer is displayed")
	public void calories_calculator_answer_is_displayed() {
		logged.SidebarCaloriesCalculatorAnswerIsDisplayed();
		utility.driverTeardown(driver);
	}
	    
	@When("user clicks FFMI Calculator")
	public void user_clicks_ffmi_calculator() {
		logged.clickSidebarFFMICalculator();
	}
	@When("user clicks Calculate FFMI button")
	public void user_clicks_calculate_ffmi_button() {
		logged.clickSidebarFFMICalculatorTextSend();
	}

	@When("user input {int} and {int} and {int}")
	public void user_input_weight_and_height_and_fat(Integer weight, Integer height, Integer fat) {
		logged.sendKeys_SidebarFFMICalculator_Weight_Text(weight);
		logged.sendKeys_SidebarFFMICalculator_Height_Text(height);
		logged.sendKeys_SidebarFFMICalculator_Fat_Text(fat);
	}
	@Then("FFMI Calculator answer is displayed")
	public void ffmi_calculator_answer_is_displayed() {
		logged.SidebarFFMICalculatorAnswerIsDisplayed();
		utility.driverTeardown(driver);
	}


}