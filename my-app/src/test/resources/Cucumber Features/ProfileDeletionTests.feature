#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to deletion of new objects - history of training, training and profile.


    
  @Profile
  Scenario: Check user can delete training 
    Given user is on logged page  
    And user clicking <trainingname>
    When user clicks Delete this training! and clicks Ok in first and second checkbox    
    Then user is redirected to logged page training name is not displayed

    
    Examples:  
      | trainingname |
      | Training1    |
    
  @Profile
  Scenario: Check user can delete profile 
    Given user is on logged page  
    When user clicks Delete Profile and clicks Ok in first and second checkbox        
    Then user is redirected to logged page and profile name is not displayed
