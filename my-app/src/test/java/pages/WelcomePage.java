package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage{

	protected WebDriver driver;
	
	//
	//Elements present only on this page
	//
	
	@FindBy(id="form3-username")
	@CacheLookup
	WebElement txt_login_username;

	@FindBy(id="form3-password")
	@CacheLookup
	WebElement txt_login_password;

	@FindBy(xpath="//div[1]/button[@class='submit button']")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(id="form3-username")
	@CacheLookup
	WebElement txt_register_username;

	@FindBy(id="form3-password")
	@CacheLookup
	WebElement txt_register_email;
	
	@FindBy(id="form3-username")
	@CacheLookup
	WebElement txt_register_password;

	@FindBy(xpath="//a[@href='/signup']")
	@CacheLookup
	WebElement a_register;
	
	@FindBy(xpath="//a[@href='/password/reset']")
	@CacheLookup
	WebElement a_resetpassword;
	
	@FindBy(xpath="//p[@class='error username-exists none']")
	@CacheLookup
	WebElement bad_login_error;
	
	@FindBy(xpath="//p[@class='error username-exists none']")
	@CacheLookup
	WebElement bad_register_error;
	
	//Constructor checks if you are on the right page 
	public WelcomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(1000);
		if(!driver.getCurrentUrl().equals("https://lichess.org/login?referrer=/")) {
			throw new IllegalStateException("This is not login page! The current page is " + driver.getCurrentUrl());
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

}