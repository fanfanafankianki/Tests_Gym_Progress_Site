package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoggedPage extends BasePage{

	protected WebDriver driver;
	
	//
	//Elements present only on this page
	//
	
	//Login XPaths
	
	@FindBy(xpath="//p[contains(text(), 'Hi')]")
	@CacheLookup
	WebElement txt_displayed_username;

	@FindBy(id="logout")
	@CacheLookup
	WebElement txt_displayed_logout;
	
	//Sidebar XPaths for user Profile

	@FindBy(xpath="//a[starts-with(@onclick, \"myAccFunc('\") and contains(@onclick, \"')\")][1]")
	@CacheLookup
	WebElement sidebar_profile;

	@FindBy(xpath="(//a[contains(@onclick, 'loadTrainingDiv(') and @href='#'])[1]")
	@CacheLookup
	WebElement sidebar_profile_training;

	@FindBy(xpath="//select[@name=\"Reps_0\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise1_reps;
	
	@FindBy(xpath="//select[@name=\"Weight_0\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise1_weight;
	
	@FindBy(xpath="//select[@name=\"Reps_1\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise2_reps;
	
	@FindBy(xpath="//select[@name=\"Weight_1\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise2_weight;
	
	@FindBy(xpath="//select[@name=\"Reps_2\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise3_reps;
	
	@FindBy(xpath="//select[@name=\"Weight_2\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise3_weight;
	
	@FindBy(xpath="//input[@type=\"submit\" and @name=\"SendTrainingWithExercises\" and @value=\"Send\"]")
	@CacheLookup
	WebElement sidebar_profile_training_exercise1_send;
	
	@FindBy(xpath="//a[starts-with(@onclick,\"confirmTrainingDeletion(\") and contains(@onclick, \")\") and @href=\"#\"][1]")
	@CacheLookup
	WebElement sidebar_profile_training_delete;
	
	//Sidebar XPaths for add training
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadAddTrainingDiv(\") and contains(@onclick, \")\") and @class=\"css-bar-item css-button\"])[1]")
	@CacheLookup
	WebElement sidebar_profile_add_training;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text1\" and @placeholder=\"Training name\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_name;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text2\" and @placeholder=\"Exercise 1\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise1;

	@FindBy(xpath="//input[@type=\"text\" and @name=\"text3\" and @placeholder=\"Exercise 2\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise2;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text4\" and @placeholder=\"Exercise 3\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise3;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text5\" and @placeholder=\"Exercise 4\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise4;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text6\" and @placeholder=\"Exercise 5\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise5;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text7\" and @placeholder=\"Exercise 6\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise6;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text8\" and @placeholder=\"Exercise 7\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise7;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text9\" and @placeholder=\"Exercise 8\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise8;
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text10\" and @placeholder=\"Exercise 9\" ]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_exercise9;
		
	@FindBy(xpath="//input[@type=\"submit\" and @name=\"insertTrainingWithExercises\"]")
	@CacheLookup
	WebElement sidebar_profile_add_training_tr_add;
	
	//Sidebar XPaths for training history
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadTrainingHistoryDiv(\") and contains(@onclick, \")\") and @class=\"css-bar-item css-button\"])[1]")
	@CacheLookup
	WebElement sidebar_profile_training_history;
	
	@FindBy(xpath="//a[starts-with(@onclick, \"loadTrainingHistoryTableDiv(\") and contains(@onclick, \")\") and @href=\"#\"] ")
	@CacheLookup
	WebElement sidebar_profile_training_history_object;
	
	@FindBy(xpath="//a[starts-with(@onclick, \"showTrainingHistoryDetails(\") and contains(@onclick, \")\") and @href=\"#\"][1]")
	@CacheLookup
	WebElement sidebar_profile_training_history_object_date;
	
	@FindBy(xpath="//a[starts-with(@onclick, \"confirmTrainingHistoryDeletion(\") and contains(@onclick, \")\") and @href=\"#\"]")
	@CacheLookup
	WebElement sidebar_profile_training_history_object_date_delete;
	
	@FindBy(id="training_history_table")
	@CacheLookup
	WebElement sidebar_profile_training_history_object_date_table;
	
	//Sidebar XPaths for training charts
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadChartDiv(\") and contains(@onclick, \")\") and @class=\"css-bar-item css-button\"])[1]")
	@CacheLookup
	WebElement sidebar_profile_charts;
	
	@FindBy(xpath="//a[starts-with(@onclick, \"showTrainingWithExercisesDetails(\") and contains(@onclick, \")\") and @href=\"#\"][1]")
	@CacheLookup
	WebElement sidebar_profile_charts_object;
	
	@FindBy(xpath="//a[starts-with(@onclick, \"showExerciseDetailsChart(\") and contains(@onclick, \",\") and contains(@onclick, \")\") and @href=\"#\" and @class=\"css-bar-item css-button\" and @style=\"display: block;\"][1]")
	@CacheLookup
	WebElement sidebar_profile_charts_object_exercise;
	
	@FindBy(id="myChart")
	@CacheLookup
	WebElement sidebar_profile_charts_object_exercise_chart;
	
	//Sidebar XPaths for profile delete
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"confirmProfileDeletion(\") and contains(@onclick, \")\") and @class=\"css-bar-item css-button\"])[1]")
	@CacheLookup
	WebElement sidebar_profile_delete_profile;
	
	//Sidebar always existing XPaths
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadProfileDiv(\") and contains(@onclick, \")\") and contains(@class, \"css-button\") and contains(@class, \"css-block2\") and contains(@class, \"css-left-align\")])[1]")
	@CacheLookup
	WebElement sidebar_add_profile;
	
	
	@FindBy(xpath="//input[@type=\"text\" and @name=\"text\" and @placeholder=\"Profile name\"]")
	@CacheLookup
	WebElement sidebar_add_profile_text;
	
	
	@FindBy(xpath="//input[@type=\"submit\" and @name=\"add_profile\" and @value=\"Add profile\"]")
	@CacheLookup
	WebElement sidebar_add_profile_text_send;
	
	//BMI Calculator locators
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadBMICalculator(\") and contains(@onclick, \")\") and contains(@class, \"css-button\") and contains(@class, \"css-block2\") and contains(@class, \"css-left-align\")])[1]")
	@CacheLookup
	WebElement sidebar_bmi_calculator;	
	
	@FindBy(xpath="//input[@type=\"text\" and @id=\"weight_bmi\" and @placeholder=\"Weight\"]")
	@CacheLookup
	WebElement sidebar_bmi_calculator_weight_text;
	
	
	@FindBy(xpath="//input[@type=\"text\" and @id=\"height_bmi\" and @placeholder=\"Height\"]")
	@CacheLookup
	WebElement sidebar_bmi_calculator_height_text;
		
	@FindBy(xpath="//button[@onclick=\"calculateBMI()\"]")
	@CacheLookup
	WebElement sidebar_bmi_calculator_text_send;

	
	@FindBy(xpath="//div[@id=\"result_bmi\" and text()]")
	@CacheLookup
	WebElement sidebar_bmi_calculator_text_answer;

	//Calories Calculator locators
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadCaloriesCalculator(\") and contains(@onclick, \")\") and contains(@class, \"css-button\") and contains(@class, \"css-block2\") and contains(@class, \"css-left-align\")])[1]")
	@CacheLookup
	WebElement sidebar_calories_calculator;
	
	@FindBy(xpath="//input[@id=\"weight_calories\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_weight_text;

	@FindBy(xpath="//input[@id=\"height_calories\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_height_text;
	
	@FindBy(xpath="//input[@id=\"age_calories\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_age_text;
	
	@FindBy(xpath="//select[@id=\"gender_calories\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_sex;
	
	@FindBy(xpath="//select[@id=\"activity_calories\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_activity;	
	
	@FindBy(xpath="//button[@onclick=\"calculateCaloricRequirement()\"]")
	@CacheLookup
	WebElement sidebar_calories_calculator_text_send;
	
	@FindBy(xpath="//div[@id=\"result_calories\" and text()]")
	@CacheLookup
	WebElement sidebar_calories_calculator_text_answer;
	
	//FFMI Calculator locators
	
	@FindBy(xpath="(//a[starts-with(@onclick, \"loadFFMICalculator(\") and contains(@onclick, \")\") and contains(@class, \"css-button\") and contains(@class, \"css-block2\") and contains(@class, \"css-left-align\")])[1]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator;
	
	@FindBy(xpath="//input[@id=\"weight_ffmi\"]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator_weight_text;
	
	@FindBy(xpath="//input[@id=\"height_ffmi\"]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator_height_text;
	
	@FindBy(xpath="//input[@id=\"fat_ffmi\"]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator_fat_text;
	
	@FindBy(xpath="//button[@onclick=\"calculateFFMI()\"]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator_text_send;
	
	@FindBy(xpath="//div[@id=\"result_ffmi\" and text()]")
	@CacheLookup
	WebElement sidebar_ffmi_calculator_text_answer;
	
	//Constructor checks if you are on the right page 
	public LoggedPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(1000);
		if(!driver.getCurrentUrl().endsWith("/logged.php")) {
			throw new IllegalStateException("This is not logged page! The current page is " + driver.getCurrentUrl());
		}

	}
	
	//Functions only for this page
	
	//Login
	
	public void usernameIsDisplayed() {
		txt_displayed_username.isDisplayed();
	}
	
	public void logoutIsDisplayed() {
		txt_displayed_logout.isDisplayed();
	}
	
	public void clickLogout() {
		txt_displayed_logout.click();
	}
	
	public void clickSidebarProfile() {
		sidebar_profile.click();
	}
	
	public boolean isTextPresentInProfile(String profilename) {
	    String elementText = sidebar_profile.getText();
	    return elementText.contains(profilename);
	}
	
	public boolean isProfileNotDisplayed() {
		try {
		WebElement element = sidebar_profile;
		if (element.isDisplayed() && element.getText().contains("TestingAccount3211")) {
			throw new AssertionError("TestingAccount321 element is displayed");
		}
		return true;
		} catch (NoSuchElementException e) {
		return true;
		}
	}
	
	//Sidebar
	
	//Created profile functions
	
	public void clickSidebarProfileTraining() {
		sidebar_profile_training.click();
	}
	
	public boolean isProfileTrainingNotDisplayed() {
	    try {
	        WebElement element = sidebar_profile_training;
	        if (element.isDisplayed()) {
	            // sprawd�, czy element jest wci�� do��czony do strony
	            if (element.getText().contains("Training1")) {
	                throw new AssertionError("Training1 element is displayed");
	            }
	        }
	        return true;
	    } catch (NoSuchElementException e) {
	        return true;
	    } catch (StaleElementReferenceException e) {
	        return true;
	    }
	}


	
	public void clickSidebarProfileTrainingExercise1_Reps(String reps) {
		sidebar_profile_training_exercise1_reps.sendKeys(reps);
	}
	
	public void clickSidebarProfileTrainingExercise1_Weight(String weight) {
		sidebar_profile_training_exercise1_weight.sendKeys(weight);
	}
	
	public void clickSidebarProfileTrainingSend() {
		sidebar_profile_training_exercise1_send.click();
	}
	
	public void chooseSidebarProfileTrainingWeightAndReps() {
	    Select weight1Select = new Select(sidebar_profile_training_exercise1_weight);
	    weight1Select.selectByValue("20");
	    Select weight2Select = new Select(sidebar_profile_training_exercise2_weight);
	    weight2Select.selectByValue("25");
	    Select weight3Select = new Select(sidebar_profile_training_exercise3_weight);
	    weight3Select.selectByValue("30");
	    Select reps1Select = new Select(sidebar_profile_training_exercise1_reps);
	    reps1Select.selectByValue("20");
	    Select reps2Select = new Select(sidebar_profile_training_exercise2_reps);
	    reps2Select.selectByValue("25");
	    Select reps3Select = new Select(sidebar_profile_training_exercise3_reps);
	    reps3Select.selectByValue("30");
	}
	
	public void clickSidebarProfileTrainingDelete() {
		sidebar_profile_training_delete.click();
	}
	
	public boolean isTextPresentInProfileTraining(String trainingname) {
	    String elementText = sidebar_profile_training.getText();
	    return elementText.contains(trainingname);
	}
	
	
	//Add training functions

	public void clickSidebarProfileAddTraining() {
		sidebar_profile_add_training.click();
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrName(String trainingname) {
		sidebar_profile_add_training_tr_name.sendKeys(trainingname);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise1(String exercise) {
		sidebar_profile_add_training_tr_exercise1.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise2(String exercise) {
		sidebar_profile_add_training_tr_exercise2.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise3(String exercise) {
		sidebar_profile_add_training_tr_exercise3.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise4(String exercise) {
		sidebar_profile_add_training_tr_exercise4.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise5(String exercise) {
		sidebar_profile_add_training_tr_exercise5.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise6(String exercise) {
		sidebar_profile_add_training_tr_exercise6.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise7(String exercise) {
		sidebar_profile_add_training_tr_exercise7.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise8(String exercise) {
		sidebar_profile_add_training_tr_exercise8.sendKeys(exercise);
	}
	
	public void sendkeys_to_SidebarProfileAddTrainingTrExercise9(String exercise) {
		sidebar_profile_add_training_tr_exercise9.sendKeys(exercise);
	}
	
	public void clickSidebarProfileAddTrainingTrExerciseAdd() {
		sidebar_profile_add_training_tr_add.click();
	}
	
	public void addTrainingToProfile(String trainingname, String exercise1, String exercise2, String exercise3) {
		clickSidebarProfileAddTraining();
		clickSiteIconX();
		sendkeys_to_SidebarProfileAddTrainingTrName(trainingname);
		sendkeys_to_SidebarProfileAddTrainingTrExercise1(exercise1);
		sendkeys_to_SidebarProfileAddTrainingTrExercise2(exercise2);
		sendkeys_to_SidebarProfileAddTrainingTrExercise3(exercise3);
		clickSidebarProfileAddTrainingTrExerciseAdd();
	}

	//Training history functions
	
	public void clickSidebarProfileTrainingHistory() {
		sidebar_profile_training_history.click();
	}
	
	public void clickSidebarProfileTrainingHistoryObject() {
		sidebar_profile_training_history_object.click();
	}
	
	public void clickSidebarProfileTrainingHistoryObjectDate() {
		sidebar_profile_training_history_object_date.click();
	}
	
	public void clickSidebarProfileTrainingHistoryObjectDateDelete() {
		sidebar_profile_training_history_object_date_delete.click();
	}
	
	public void checkSidebarProfileHistoryObjectDateTable_is_displayed() {
		sidebar_profile_training_history_object_date_table.isDisplayed();
	}
	
	//Training charts functions
	
	public void clickSidebarProfileCharts() {
		sidebar_profile_charts.click();
	}
	
	public void clickSidebarProfileChartsObject() {
		sidebar_profile_charts_object.click();
	}
	
	public void clickSidebarProfileChartsObjectExercise() {
		sidebar_profile_charts_object_exercise.click();
	}
	
	public void checkSidebarProfileChartsObjectExerciseChart_is_displayed() {
		sidebar_profile_charts_object_exercise_chart.isDisplayed();
	}
	
	//Function for profile delete
	
	public void clickSidebarProfileDeleteProfile() throws InterruptedException {
	    // sprawd�, czy sidebar_profile_training_history_object_date_delete jest nie-null
	    if (sidebar_profile_delete_profile!= null) {
	        // kliknij przycisk, kt�ry wywo�uje confirm()
	        WebElement deleteButton = sidebar_profile_delete_profile;
	        deleteButton.click();
	        
	        Thread.sleep(2000);
	    }
	}

	
	public void clickSidebarProfileDeleteProfileOk1() {
		sidebar_profile_delete_profile.click();
		


	}
	
	
	
	//Functions for adding new profile
	
	public void clickSidebarAddProfile() {
		sidebar_add_profile.click();
	}
	
	public void sendKeys_SidebarAddProfileText(String name) {
		sidebar_add_profile_text.sendKeys(name);
	}
	
	public void clickSidebarAddProfileTextSend() {
		sidebar_add_profile_text_send.click();
	}
	
	public void AddNewProfile(String name) {
		clickSidebarAddProfile();
		sendKeys_SidebarAddProfileText(name);
		clickSidebarAddProfileTextSend();
	}
	
	//Functions for calculators
	
	//BMI
	
	public void clickSidebarBMICalculator() {
		sidebar_bmi_calculator.click();
	}
	
	public void sendKeys_SidebarBMICalculator_Weight_Text(Integer weight) {
	    sidebar_bmi_calculator_weight_text.sendKeys(String.valueOf(weight));
	}

	
	public void sendKeys_SidebarBMICalculator_Height_Text(Integer height) {
		sidebar_bmi_calculator_height_text.sendKeys(String.valueOf(height));
	}
	
	public void clickSidebarBMICalculatorTextSend() {
		sidebar_bmi_calculator_text_send.click();
	}
	
	public void SidebarBMICalculatorAnswerIsDisplayed() {
		sidebar_bmi_calculator_text_answer.isDisplayed();
	}
	
	public void testSidebarBMICalculator(Integer weight, Integer height, Integer fat) {
		clickSidebarBMICalculator();
		sendKeys_SidebarBMICalculator_Weight_Text(weight);
		sendKeys_SidebarBMICalculator_Height_Text(height);
		clickSidebarBMICalculatorTextSend();
		SidebarBMICalculatorAnswerIsDisplayed();
	}
	
	//Calories
	
	public void clickSidebarCaloriesCalculator() {
		sidebar_calories_calculator.click();
	}
	
	public void sendKeys_SidebarCaloriesCalculator_Weight_Text(Integer weight) {
		sidebar_calories_calculator_weight_text.sendKeys(String.valueOf(weight));
	}
	
	public void sendKeys_SidebarCaloriesCalculator_Height_Text(Integer height) {
		sidebar_calories_calculator_height_text.sendKeys(String.valueOf(height));
	}
	
	public void sendKeys_SidebarCaloriesCalculator_Age_Text(Integer age) {
		sidebar_calories_calculator_age_text.sendKeys(String.valueOf(age));
	}
	
	public void clickSidebarCaloriesCalculator_sex() {
		sidebar_calories_calculator_sex.click();
	}
	
	public void choose_SidebarCaloriesCalculator_Sex() {
	    Select genderSelect = new Select(sidebar_calories_calculator_sex);
	    genderSelect.selectByValue("female");
	}
	
	public void clickSidebarCaloriesCalculator_activity() {
		sidebar_calories_calculator_activity.click();
	}
	
	public void choose_SidebarCaloriesCalculator_Activity() {
	    Select ageSelect = new Select(sidebar_calories_calculator_activity);
	    ageSelect.selectByValue("1.60");
	}
	
	public void clickSidebarCaloriesCalculatorTextSend() {
		sidebar_calories_calculator_text_send.click();
	}
	
	public void SidebarCaloriesCalculatorAnswerIsDisplayed() {
		sidebar_calories_calculator_text_answer.isDisplayed();
	}
	
	public void testSidebarCaloriesCalculator(Integer weight, Integer height, Integer age, String answer, String sex, String activity) {
		clickSidebarFFMICalculator();
		sendKeys_SidebarCaloriesCalculator_Weight_Text(weight);
		sendKeys_SidebarCaloriesCalculator_Height_Text(height);
		sendKeys_SidebarCaloriesCalculator_Age_Text(age);
		clickSidebarCaloriesCalculatorTextSend();
	}
	
	//FFMI

	public void clickSidebarFFMICalculator() {
		sidebar_ffmi_calculator.click();
	}
	
	public void sendKeys_SidebarFFMICalculator_Weight_Text(Integer weight) {
		sidebar_ffmi_calculator_weight_text.sendKeys(String.valueOf(weight));
	}
	
	public void sendKeys_SidebarFFMICalculator_Height_Text(Integer height) {
		sidebar_ffmi_calculator_height_text.sendKeys(String.valueOf(height));
	}
	
	public void sendKeys_SidebarFFMICalculator_Fat_Text(Integer fat) {
		sidebar_ffmi_calculator_fat_text.sendKeys(String.valueOf(fat));
	}
	
	public void clickSidebarFFMICalculatorTextSend() {
		sidebar_ffmi_calculator_text_send.click();
	}
	
	public void SidebarFFMICalculatorAnswerIsDisplayed() {
		sidebar_ffmi_calculator_text_answer.isDisplayed();
	}
	
	public void testSidebarFFMICalculator(Integer weight, Integer height, Integer fat) {
		clickSidebarFFMICalculator();
		sendKeys_SidebarFFMICalculator_Weight_Text(weight);
		sendKeys_SidebarFFMICalculator_Height_Text(height);
		sendKeys_SidebarFFMICalculator_Fat_Text(fat);
		clickSidebarFFMICalculatorTextSend();
		SidebarFFMICalculatorAnswerIsDisplayed();
	}
	
}