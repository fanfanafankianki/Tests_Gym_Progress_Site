#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to test logout functionality

	Background: 
	  Given user is on logged page
	  
	@Logout
  Scenario: Check logout is successfull
    When user clicks "logout" button
    Then user is navigated to the welcome page
    