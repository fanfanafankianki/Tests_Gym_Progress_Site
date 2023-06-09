#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to test register functionality

	Background: 
	  Given user is on welcome page
	  
	@Register
  Scenario: Check register is succesfull with valid credentials
    When user enter valid <username> and <email> and <password>
    And user clicks register checkbox    
    And click on register button
    Then welcome page is displayed
    And register error text is not displayed     

    Examples:  
    | username | email | password |
    | Bambik | User@gmail.com | Bambik |
    
	@Register
  Scenario: Check register is unsuccesfull with invalid credentials
    When user enter invalid <username> and <email> and <password>
    And user clicks register checkbox       
    And click on register button
    Then welcome page is displayed
    And register error text is displayed 
    	
    Examples:  
    | username | email | password |
    | Bambik11 | User11@gmail.com | Bambik |
    