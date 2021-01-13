#Author: Amruta

@ForgotPassword
Feature: Forgot Password for subscribed user

	@tag1
	Scenario: Verify forgot password 
		Given the user is on SignIn page
		When the user click on forgot password
		Then  enter email and display a message
		
		
  
    
    
  