package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedPage extends BasePage{

	protected WebDriver driver;
	
	//
	//Elements present only on this page
	//
	
	//Login XPaths
	
	@FindBy(id="")
	@CacheLookup
	WebElement txt_displayed_username;

	@FindBy(id="")
	@CacheLookup
	WebElement txt_displayed_logout;

	//Sidebar XPaths
	
	//Sidebar XPaths for user Profile
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_name;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise1;

	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise2;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise3;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise4;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise5;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise6;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise7;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise8;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise9;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_add;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_training_history;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_training_history_object;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_charts;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_charts_object;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_profile_delete_profile;
	
	//Sidebar always existing XPaths
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_add_profile;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_bmi_calculator;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_calories_calculator;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_ffmi_calculator;
	
	//Constructor checks if you are on the right page 
	public LoggedPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(1000);
		if(!driver.getCurrentUrl().equals("https://localhost/Gym_Site/logged.php")) {
			throw new IllegalStateException("This is not logged page! The current page is " + driver.getCurrentUrl());
		}

	}
	
	//Functions only for this page
	
	public void enterLoginUsername(String username) {
		txt_login_username.sendKeys(username);
	}

	public void enterLoginPassword(String password) {
		txt_login_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}
	
	public void enterRegisterUsername(String username) {
		txt_register_username.sendKeys(username);
	}
	
	public void enterRegisterEmail(String email) {
		txt_register_email.sendKeys(email);
	}

	public void enterRegisterPassword(String password) {
		txt_register_password.sendKeys(password);
	}
	
	public void clickRegister() {
		a_register.click();
	}
	
	public void loginErrorFormIsDisplayed() {
		bad_login_error.isDisplayed();
	}
	public void registerErrorFormIsDisplayed() {
		bad_register_error.isDisplayed();
	}

	public void usernameIsDisplayed() {
		// TODO Auto-generated method stub
		
	}

}