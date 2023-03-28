package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.WelcomePage;
import pages.LoggedPage;

public class SeleniumUtility {
	public WebDriver driver;
	public WelcomePage welcome;
	public LoggedPage logged;

	
	
    public WebDriver getDriver() {
        if (driver == null) {
            // Chromedriver path in system
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Browser_Drivers/chromedriver.exe");
            System.out.println("Initializing driver");

            // WebDriverManager keeps chromedriver version up to date
            WebDriverManager.chromedriver().setup();

            // Set ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-debugging-port=0");
            options.addArguments("--headless"); // Dodaj t� opcj�, je�li uruchamiasz testy w trybie bez g�owy

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

	public WelcomePage getWelcomePage() throws InterruptedException{
	      return (welcome == null) ? welcome = new WelcomePage(driver) : welcome;
	      }
	
	public LoggedPage getLoggedPage() throws InterruptedException{
	      return (logged == null) ? logged = new LoggedPage(driver) : logged;
	      }
}
