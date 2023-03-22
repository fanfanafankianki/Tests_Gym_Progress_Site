#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to test visibility of new objects - history of training and charts

  @Profile
  Scenario: Check user can view training chart 
    Given user is on logged page
    And user clicks "Chart" button
    When user clicks <trainingname>
    And user clicks <exercisename>
    Then chart is displayed

  @Profile
  Scenario: Check user can view training history 
    Given user is on logged page
    And user clicks "Training history" button  
    When user clicks <trainingname>
    And user clicks training date 
    Then history table is displayed
