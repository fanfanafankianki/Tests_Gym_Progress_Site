package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BasePage {
	
	protected WebDriver driver;
	
	//
	//Constructor
	//
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
	}

	//
	//Elements present on every page
	//
	
	
	//Site Icon
	@FindBy(xpath="//img[@id=\"logo\"]")
	@CacheLookup
	WebElement site_icon;
	
	@FindBy(xpath="//i[@onclick='sidebar_close()']")
	@CacheLookup
	WebElement site_icon_x;
	
	//Footer
	
	@FindBy(xpath="//input[@id=\"Name_footer\"]")
	@CacheLookup
	WebElement footer_name;
	
	@FindBy(xpath="//input[@id=\"Email_footer\"]")
	@CacheLookup
	WebElement footer_email;

	@FindBy(xpath="//input[@id=\"Subject_footer\"]")
	@CacheLookup
	WebElement footer_subject;
	
	@FindBy(xpath="//textarea[@id=\"Message_footer\"]")
	@CacheLookup
	WebElement footer_message;
	
	@FindBy(xpath="//button[@id=\"Submit_footer\"]")
	@CacheLookup
	WebElement footer_send;

	//Github Link
	
	@FindBy(xpath="//a[@id=\"github\"]")
	@CacheLookup
	WebElement github_link;
	
	//
	//Functions for every page
	//

	
	public void siteIcon_IsDisplayed() {
		site_icon.isDisplayed();
	}
	
	public void siteIconX_IsDisplayed() {
		site_icon_x.isDisplayed();
	}
	
	public void clickSiteIcon() {
		site_icon.click();
	}
	
	public void clickSiteIconX() {
		site_icon_x.click();
	}

	public void sendKeys_FooterName(String name) {
		footer_name.sendKeys(name);
	}
	
	public void sendKeys_FooterEmail(String email) {
		footer_email.sendKeys(email);
	}
	
	public void sendKeys_FooterSubject(String subject) {
		footer_subject.sendKeys(subject);
	}	
	
	public void sendKeys_FooterMessage(String message) {
		footer_message.sendKeys(message);
	}	
	
	public void clickFooterSend() {
		footer_send.click();
	}
	
	public void sendFooterMessage(String name, String email, String subject, String message) {
		sendKeys_FooterName(name);
		sendKeys_FooterEmail(email);
		sendKeys_FooterSubject(subject);
		sendKeys_FooterMessage(message);
		clickFooterSend();
	}
	
	public void clickGithubLink() {
		github_link.click();
	}
}