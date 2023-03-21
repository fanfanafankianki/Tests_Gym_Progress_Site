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
	
	@FindBy(xpath="//h1[@class='site-title']/a")
	@CacheLookup
	WebElement a_lichess;
	
	//
	
	@FindBy(xpath="//span[@class='play']")
	@CacheLookup
	WebElement hov_play;

}