#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to test sidebar buttons on welcome page

	Background: 
	  Given user is on welcome page
	  
	@SidebarButtons
  Scenario: Check that after clicking "Greetings!" button greetings form is displayed
    When user clicks Greetings! button
    Then greetings form is displayed
    
	@SidebarButtons
  Scenario: Check that after clicking "Registration form" button registration form is displayed
    When user clicks Registration form button
    Then registratio form is displayed
    
	@SidebarButtons
  Scenario: Check that after clicking "Site statue" button statue form is displayed
    When user clicks Site statue button
    Then statue form is displayed