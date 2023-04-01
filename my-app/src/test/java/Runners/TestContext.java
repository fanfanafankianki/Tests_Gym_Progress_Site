package Runners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.BasePage;
import pages.LoggedPage;
import pages.WelcomePage;

//
//Class for dependency injection
//

public class TestContext {
	
	public WebDriver driver;
	
	public BasePage base;
	public LoggedPage logged;
	public WelcomePage welcome;



	
    // Driver methods
    public WebDriver getDriver() {
        if (driver == null) {
            // Chromedriver path in system
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Browser_Drivers/chromedriver.exe");
            System.out.println("Initializing driver");

            // WebDriverManager keeps chromedriver version up to date
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--verbose");
            options.addArguments("--whitelisted-ips=''");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-debugging-port=0");
            options.addArguments("--headless");
            options.addArguments("--display=" + System.getenv("DISPLAY"));



            // initialize the driver
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }
        return driver;
    }

    public void driverTeardown(WebDriver driver) {
        driver.close();
        driver.quit();
    }
	
	//Methods for page objects creation 

	public BasePage getBasePage() throws InterruptedException{
	      return (base == null) ? base = new BasePage(driver) : base;
	      }
	
	public LoggedPage getLoggedPage() throws InterruptedException{
	      return (logged == null) ? logged = new LoggedPage(driver) : logged;
	      }
	
	public WelcomePage getWelcomePage() throws InterruptedException{
	      return (welcome == null) ? welcome = new WelcomePage(driver) : welcome;
	      }
	

}
