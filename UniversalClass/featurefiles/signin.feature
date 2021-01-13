#Author: jyoita.roy@capgemini.com

@signin
Feature: SignIn 
  I want to use this template for my feature file
  
   Scenario: SignIn for valid credentials
    Given the user is on home page
    When click on signin
    And enter valid login credentials
    Then user signin successfully

   Scenario: Remove the account
    Given the user is on after signin home page
    When click on account options
    And privacy settings
    Then click account removal request form
  
   Scenario Outline: SignIn for invalid credential
    Given the user is on home page
    When click on signin
    And enter invalid <mail> <pass>credentials
    Then display error message
    Examples:
    |mail|pass|
    |pakhi@gmail.com|ghfgh|
    