#Author: bartosz.grzegorczyk97@gmail.com

Feature: Feature to test BMI, Calories and FFMI calculators

	Background: 
	  Given user is on logged page
	  
	@Calculators
  Scenario: Check BMI calculator is working properly
    When user clicks "BMI Calculator"
    And user inputs <weight> and <height>
    And user clicks "Calculate BMI" button
    Then BMI Calculator answer is displayed 

    Examples:  
    | weight | height |
    | TestingAccount321 | sss |
    
	@Calculators
  Scenario: Check Calories calculator is working properly
    When user clicks "Calories Calculator"
    And user inputs <weight> and <height> and <age>
    And user chooses sex and activity in dropbox
    And user clicks "Calculate your caloric needs" button
    Then Calories Calculator answer is displayed 

    Examples:  
    | weight | height | age |
    | TestingAccount321 | sss | sds |
    
	@Calculators
  Scenario: Check FFMI calculator is working properly
    When user clicks "FFMI Calculator"
    And user inputs <weight> and <height> and <fatlevel>
    And user clicks "Calculate FFMI" button
    Then BMI Calculator answer is displayed 

    Examples:  
    | weight | height | fatlevel |
    | TestingAccount321 | sss | sss |
    
    

    
