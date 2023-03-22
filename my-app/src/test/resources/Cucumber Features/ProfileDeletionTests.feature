#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to deletion of new objects - history of training, training and profile.

  @Profile
  Scenario: Check user can delete training history 
    Given user is on logged page
    And user clicks "Training history" button  
    And user clicks <trainingname>
    And user clicks training date
    When user clicks "Delete this history record!" 
    And user clicks "Ok" in first checkbox
    And user clicks "Ok" in second checkbox    
    Then user is redirected to logged page
    
  @Profile
  Scenario: Check user can delete training 
    Given user is on logged page  
    And user clicks <trainingname>
    When user clicks "Delete this training!" 
    And user clicks "Ok" in first checkbox
    And user clicks "Ok" in second checkbox       
    Then user is redirected to logged page
    And training name is not displayed
    
  @Profile
  Scenario: Check user can delete profile 
    Given user is on logged page  
    When user clicks "Delete Profile" 
    And user clicks "Ok" in first checkbox
    And user clicks "Ok" in second checkbox       
    Then user is redirected to logged page
    And profile name is not displayed
    