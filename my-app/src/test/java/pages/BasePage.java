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
	@FindBy(xpath="")
	@CacheLookup
	WebElement site_icon;
	
	//Footer
	
	@FindBy(id="")
	@CacheLookup
	WebElement footer_name;
	
	@FindBy(id="")
	@CacheLookup
	WebElement footer_email;

	@FindBy(id="")
	@CacheLookup
	WebElement footer_subject;
	
	@FindBy(id="")
	@CacheLookup
	WebElement footer_message;
	
	@FindBy(id="")
	@CacheLookup
	WebElement footer_send;

	//Github Link
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement github_link;
	
	//
	//Functions for every page
	//

	public void clickSiteIcon() {
		site_icon.click();
	}

	public void clickFooterName() {
		footer_name.click();
	}
	
	public void clickFooterEmail() {
		footer_email.click();
	}
	
	public void clickFooterSubject() {
		footer_subject.click();
	}	
	
	public void clickFooterMessage() {
		footer_message.click();
	}	
	
	public void clickFooterSend() {
		footer_send.click();
	}
	
	public void clickGithubLink() {
		github_link.click();
	}
}