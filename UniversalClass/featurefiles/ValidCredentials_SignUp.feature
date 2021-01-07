#Author: Akanksha Yadav

@signup_valid
Feature: Sign Up

  Scenario Outline: Sign Up with valid input
    Given user is on Sign up page
     When enter <firstname> <lastname> <email> <password> 
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then user should SignIn successfully
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita123 | 
  
