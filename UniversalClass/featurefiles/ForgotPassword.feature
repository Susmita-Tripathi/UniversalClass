#Author: Akanksha Yadav

@forgot_password
Feature: Forgot password

Scenario: To reset password for valid and invalid input
	Given user is on homepage of forgot password 
	
 Scenario: Forgot Password with blank input
 		When we don't enter input for email and click on reset password
 		Then error message is displayed for sending blank input
      
  Scenario Outline: To reset the password for unsubscribed member
     When enters <email> and click on reset password
     Then error message is displayed for email id not found
  
    Examples: 
      | email                 | 
      | knishant097@gmail.com | 
      
  Scenario Outline: To reset the password for subscribed member
     When enters <email> and click on reset password
     Then link to reset password should be sent to respective email address
  
    Examples: 
      | email                 | 
      | yadavakanksha297@gmail.com |
