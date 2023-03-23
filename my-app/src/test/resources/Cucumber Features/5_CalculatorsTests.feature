#Author: bartosz.grzegorczyk97@gmail.com

Feature: Feature to test BMI, Calories and FFMI calculators

	Background: 
	  Given user is on logged page
	  
	@Calculators
  Scenario: Check BMI calculator is working properly
    When user clicks BMI Calculator
    And user inputs <weight> and <height>
    And user clicks Calculate BMI button
    Then BMI Calculator answer is displayed 

    Examples:  
    | weight | height |
    | 10 | 10 |
    
	@Calculators
  Scenario: Check Calories calculator is working properly
    When user clicks Calories Calculator
    And user inputs <weight> and <height> and <age>
    And user chooses sex and activity in dropbox
    And user clicks Calculate your caloric needs button
    Then Calories Calculator answer is displayed 

    Examples:  
    | weight | height | age |
    | 10     | 11     | 22  |

    
	@Calculators
  Scenario: Check FFMI calculator is working properly
    When user clicks FFMI Calculator
    And user input <weight> and <height> and <fatlevel>
    And user clicks Calculate FFMI button
    Then FFMI Calculator answer is displayed 

    Examples:  
    | weight | height | fatlevel |
    | 31     | 12     | 32       |
    
    

    
