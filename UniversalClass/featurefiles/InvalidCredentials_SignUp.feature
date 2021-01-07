#Author: Akanksha Yadav

@signup_invalid
Feature: Sign Up with invalid input

  Scenario: 
		Given user is on Sign up page

	Scenario: Input fields are blank for Sign Up
		When we don't enter any input field and click Sign Up
		Then error message should be displayed

	Scenario Outline: Checkbox for accepting terms of service is not selected
     When enter <firstname> <lastname> <email> <password> 
      And checkbox is not selected for accepting terms of service to sign up, click Sign up
     Then error message should be displayed
  
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita123 | 

	Scenario Outline: Invalid characters in firstname and lastname
     When enter invalid characters in <firstname> and <lastname>, valid <email> and <password>  
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | 12@sm     | sm@12    | smitamhatre538@gmail.com | smita123 | 
      
   Scenario Outline: Invalid email
     When enter  <firstname>,<lastname>,invalid email<email>, <password> 
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed
  
    Examples: 
      | firstname | lastname | email                   | password | 
      | Smita     | Mhatre   | smitamhatre538_gmailcom | smita123 | 
      
    Scenario Outline: Invalid password
     When enter  <firstname>,<lastname>,<email>, invalid password <password>
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita    | 
      
     Scenario Outline: Email already registered
     When enter  <firstname>,<lastname>, <email>, <password> 
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita    | 
