package pages;

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
	
	@FindBy(id="")
	@CacheLookup
	WebElement txt_login_username;

	@FindBy(id="")
	@CacheLookup
	WebElement txt_login_password;

	@FindBy(xpath="")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement bad_login_error;
	
	//Register XPaths
	
	@FindBy(id="")
	@CacheLookup
	WebElement txt_register_username;

	@FindBy(id="")
	@CacheLookup
	WebElement txt_register_email;
	
	@FindBy(id="")
	@CacheLookup
	WebElement txt_register_password;

	@FindBy(id="")
	@CacheLookup
	WebElement checkbox_register;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement btn_register;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement bad_register_error;

	//Other XPaths - sidebar
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_greetings;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_register;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sidebar_statue;
	
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
		// TODO Auto-generated method stub
		
	}
	
	//Other functions - sidebar
	
	public void clickSidebarGreetings() {
		sidebar_greetings.click();
	}
	
	public void clickSidebarRegister() {
		sidebar_register.click();
	}
	
	public void clickSidebarStatue() {
		sidebar_statue.click();
	}
	
	public void imgIsDisplayed() {
		// TODO Auto-generated method stub
		
	}



}