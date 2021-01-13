#Author: akanksha-danbahadur.yadav@capgemini.com

@signIn
Feature: SignIn with valid and invalid input

Scenario:
	Given user is on signIn page
	
	Scenario Outline: Sign In with invalid input
		 When enters <username> and <password> as a input details and click on signIn
		Then error message should be displayed when entered invalid email or password
		
	Examples:
	|username|password|
	|mhsmita@gmail.com|smita@123|
	
	Scenario Outline: Sign In with valid input
     When enters <username> and <password> as a input details and click on signIn
     Then user should signIn successfully

	Examples:
	|username|password|
	|yadavakanksha297@gmail.com|akanksha|
