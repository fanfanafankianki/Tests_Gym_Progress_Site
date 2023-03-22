package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage{

	protected WebDriver driver;
	
	//Constructor checks if you are on the right page 
	public WelcomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(1000);
		if(!driver.getCurrentUrl().equals("http://localhost/Gym_Site/welcome.php")) {
			throw new IllegalStateException("This is not welcome page! The current page is " + driver.getCurrentUrl());
		}

	}
	
	//
	//Elements present only on this page
	//
	
	//Login XPaths
	
	@FindBy(xpath="//input[@id=\"login_login\"]")
	@CacheLookup
	WebElement txt_login_username;

	@FindBy(xpath="//input[@id=\"login_password\"]")
	@CacheLookup
	WebElement txt_login_password;

	@FindBy(xpath="//button[@id=\"login_submit\"]")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath="//div[@id=\"login_error\"]")
	@CacheLookup
	WebElement bad_login_error;
	
	//Register XPaths
	
	@FindBy(xpath="//input[@id=\"register_username\"]")
	@CacheLookup
	WebElement txt_register_username;

	@FindBy(xpath="//input[@id=\"register_email\"]")
	@CacheLookup
	WebElement txt_register_email;
	
	@FindBy(xpath="//input[@id=\"register_password\"]")
	@CacheLookup
	WebElement txt_register_password;

	@FindBy(xpath="//input[@id=\"register_accept-terms\"]")
	@CacheLookup
	WebElement checkbox_register;
	
	@FindBy(xpath="//input[@type=\"submit\" and @name=\"submitRegistration\"]")
	@CacheLookup
	WebElement btn_register;
	
	@FindBy(xpath="//p[@id=\"register_error\"]")
	@CacheLookup
	WebElement bad_register_error;

	//Other XPaths - sidebar
	
	@FindBy(xpath="//a[@onclick=\"loadWelcomePage()\"]")
	@CacheLookup
	WebElement sidebar_greetings;	
	
	@FindBy(xpath="//div[@id=\"welcome_site\"]")
	@CacheLookup
	WebElement sidebar_greetings_form;
	
	@FindBy(xpath="//a[@onclick=\"createRegisterElement()\"]")
	@CacheLookup
	WebElement sidebar_register;
	
	@FindBy(xpath="//form[@id=\"registration\"]")
	@CacheLookup
	WebElement sidebar_register_form;
	
	@FindBy(xpath="//a[@onclick=\"loadRulesPage()\"]")
	@CacheLookup
	WebElement sidebar_statue;
	
	@FindBy(xpath="//pre[@id=\"rules\"]")
	@CacheLookup
	WebElement sidebar_statue_form;
	
	//
	//Functions only for this page
	//
	
	//Login Functions
	
	public void enterLoginUsername(String username) {
		txt_login_username.sendKeys(username);
	}

	public void enterLoginPassword(String password) {
		txt_login_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}
	
	public void loginErrorFormIsDisplayed() {
		bad_login_error.isDisplayed();
	}
	
	public void loginWithCorrectValues(String username, String password) {
		enterLoginUsername(username);
		enterLoginPassword(password);
		clickLogin();
	}
	
	public void loginWithIncorrectValues(String username) {
		enterLoginUsername(username);
		enterLoginPassword("blabla");
		clickLogin();
		loginErrorFormIsDisplayed();
	}
	
	//Register functions
	
	public void enterRegisterUsername(String username) {
		txt_register_username.sendKeys(username);
	}
	
	public void enterRegisterEmail(String email) {
		txt_register_email.sendKeys(email);
	}

	public void enterRegisterPassword(String password) {
		txt_register_password.sendKeys(password);
	}

	public void clickCheckboxRegister() {
		checkbox_register.click();
	}
	
	public void clickRegister() {
		btn_register.click();
	}

	public void registerErrorIsDisplayed() {
		bad_register_error.isDisplayed();
	}
	
	public boolean registerErrorIsNotDisplayed() {
	    try {
	        WebElement element = bad_register_error;
	        if (element.isDisplayed()) {
	            throw new AssertionError("Register error text is displayed");
	        }
	        return true;
	    } catch (NoSuchElementException e) {
	        return true;
	    }
	}


	
	public void registerWithCorrectValues(String username, String email, String password) {
		enterRegisterUsername(username);
		enterRegisterEmail(email);
		enterRegisterPassword(password);
		clickCheckboxRegister();
		clickRegister();
	}
	
	public void registerWithIncorrectValues(String username, String password) {
		enterRegisterUsername(username);
		enterRegisterEmail("email");
		enterRegisterPassword(password);
		clickCheckboxRegister();
		clickRegister();
		registerErrorIsDisplayed();
	}
	
	//Other functions - sidebar
	
	public void clickSidebarGreetings() {
		sidebar_greetings.click();
	}	
	
	public void SidebarGreetingsForm_isDisplayed() {
		sidebar_greetings_form.isDisplayed();
	}
	
	public void clickSidebarRegister() {
		sidebar_register.click();
	}
	
	public void SidebarRegisterForm_isDisplayed() {
		sidebar_register_form.isDisplayed();
	}
	
	public void clickSidebarStatue() {
		sidebar_statue.click();
	}
	
	public void SidebarStatueForm_isDisplayed() {
		sidebar_statue_form.isDisplayed();
	}




}