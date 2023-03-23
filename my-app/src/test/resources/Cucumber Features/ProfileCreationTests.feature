#Author: bartosz.grzegorczyk97@gmail.com
Feature: Feature to test adding new objects - profile, training and history of training

  Background: 
    Given user is on logged page

  @Profile
  Scenario: Check user can create new profile
    When user clicks Add New Profile
    And input profile <name> into textbox
    And clicks Add new profile button
    Then new profile is created
    And profile have <name> inserted by user 

    Examples:  
      | name              |
      | TestingAccount321 |

  @Profile
  Scenario: Check user can add new training in profile
    When user clicks Add training button
    And user insert training informations into textboxes
    Then new training is created

  @Profile
  Scenario: Check user can add new training history in profile
    When user clicks <trainingname> button
    And user insert training history informations into chooseboxes
    And user clicks Send button
    Then user is redirected to logged page
    
    Examples:  
      | trainingname |
      | trening1     |    
    