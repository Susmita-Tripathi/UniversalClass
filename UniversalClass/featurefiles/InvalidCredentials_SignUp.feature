#Author: Akanksha Yadav

@signup_invalid
Feature: Sign Up with invalid input

  Scenario: 
		Given user is on Sign up page

  Scenario: Input fields are blank for Sign Up
		When we don't enter any input field  and click Sign Up
		Then error message should be displayed for blank input
		
	Scenario Outline: Checkbox for accepting terms of service is not selected
    When enter <firstname> <lastname> <email> <password>  
      And checkbox is not selected for accepting terms of service to sign up, click Sign up
     Then error message should be displayed for not selecting checkbox
  
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita123 | 	
      
    Scenario Outline: Invalid email
     When enter <firstname> <lastname> <email> <password>
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed for entering invalid email
  
    Examples: 
      | firstname | lastname | email                   | password | 
      | Smita     | Mhatre   | smitamhatre538_gmailcom | smita123 | 
      
    Scenario Outline: Invalid password
     When enter <firstname> <lastname> <email> <password>
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed for entering invalid password
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita    | 
      
    Scenario Outline: Email already registered
     When enter <firstname> <lastname> <email> <password>
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed for entering email that is already registered
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Smita     | Mhatre   | smitamhatre538@gmail.com | smita123    | 

		Scenario Outline: Invalid characters in firstname and last name
     When enter <firstname> <lastname> <email> <password>
      And select checkbox for accepting terms of service to sign up, click Sign up
     Then error message should be displayed for entering invalid characters in first name and last name
     
    Examples: 
      | firstname | lastname | email                    | password | 
      | Sm@12     | 12@sm   | mhatre007smita@gmail.com | smita123    |
	