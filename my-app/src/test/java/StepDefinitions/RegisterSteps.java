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

public class RegisterSteps {
	
	WebDriver driver = null;
	WelcomePage welcome;
	LoggedPage logged;
	private SeleniumUtility utility;
	private int counter;

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

	    // increment counter
	    counter++;

	    // add counter to username and email
	    String formattedUsername = String.format("%s%d", username, counter);
	    String[] emailParts = email.split("@");
	    String formattedEmail = String.format("%s%d@%s", emailParts[0], counter, emailParts[1]);

	    // enter valid credentials with updated username and email
	    welcome = utility.getWelcomePage();
	    welcome.enterRegisterUsername(formattedUsername);
	    welcome.enterRegisterEmail(formattedEmail);
	    welcome.enterRegisterPassword(password);

	    // write updated counter to file
	    try {
	        FileWriter writer = new FileWriter(counterFile);
	        writer.write(String.valueOf(counter));
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
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