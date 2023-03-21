#Author: bartosz.grzegorczyk97@gmail.com

Feature: Feature to test register functionality

	Background: 
	  Given user is on welcome page
	  
	@Register
  Scenario: Check register is succesfull with valid credentials
    When user enters valid <username> and <email> and <password>
    And click on register button
    Then user is navigated to the welcome page
    And welcome page is displayed

    Examples:  
    | username | email | password |
    | TestingAccount321 | kuku@gmail.com | kukuruku |
    
	@Register
  Scenario: Check login is unsuccesfull with invalid credentials
    When user enters unvalid <username> and <email> and <password>
    And click on register button
    Then register error text is displayed 
    
    Examples:  
    | username | email | password |
    | TestingAccount321 | kuku@gmail.com | kukuruku |