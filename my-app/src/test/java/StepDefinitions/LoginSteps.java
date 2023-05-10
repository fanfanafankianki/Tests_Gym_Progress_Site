package StepDefinitions;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import StepDefinitions.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WelcomePage;
import pages.LoggedPage;

public class LoginSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	
	public LoginSteps(StepDefinitions.SeleniumUtility utility) {
		this.utility=utility;
		this.driver=utility.driver;
	}

	@Given("user is on welcome page")
	public void user_is_on_welcome_page() throws InterruptedException {
		driver=utility.getDriver();
		driver.navigate().to("http://localhost/Gym_Site/welcome.php");
	}
	
	@When("user enters invalid (.*) and (.*)$")
	public void user_enters_invalid_username_and_password(String username, String password) throws InterruptedException {
		welcome = utility.getWelcomePage();
		
		welcome.enterLoginUsername(username);
		welcome.enterLoginPassword(password);
	}

	@When("user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
	    // Create file if not exists
	    File counterFile = new File("src/test/java/StepDefinitions/counter.txt");
	    if (!counterFile.exists()) {
	        try {
	            counterFile.createNewFile();
	            FileWriter writer = new FileWriter(counterFile);
	            writer.write("0");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // read counter from file
	    int counter = 0;
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(counterFile));
	        String line = reader.readLine();
	        if (line != null) {
	            counter = Integer.parseInt(line.trim());
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // add counter to username and password
	    String formattedUsername = String.format("%s%d", username, counter);

	    // enter valid credentials with updated username and password
	    welcome = utility.getWelcomePage();
	    welcome.enterLoginUsername(formattedUsername);
	    welcome.enterLoginPassword(password);
	}


	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		welcome.clickSiteIconX();
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
		welcome.loginErrorFormIsDisplayed();
		utility.driverTeardown(driver);
	}
}