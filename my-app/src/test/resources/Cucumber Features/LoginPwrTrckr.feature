#Author: bartosz.grzegorczyk97@gmail.com

Feature: Feature to test login functionality

	Background: 
	  Given user is on welcome page
	  
	@Login
  Scenario: Check login is succesfull with valid credentials
    When user enters valid <username> and <password>
    And click on login button
    Then user is navigated to the logged page
    And user username is displayed in left corner

    Examples:  
    | username | password |
    | TestingAccount321 | Lichesstesting123 |
    
	@Login
  Scenario: Check login is unsuccesfull with invalid credentials
    When user enters invalid <username> and <password>
    And click on login button
    Then login error text is displayed 
    
    Examples:  
    | username | password |
    | TestingAccount321 | Lichesstesting123 |