#Author: Amruta

@SignIn
Feature: SignIn for Subscribed user

@tag1
Scenario: Verify Member SignIn for invalid input
	
 Given the user is on home page
 When the user click on member signin page
 Then enter invalid email password and click on signIn button and verify error message

	
		
@tag2
Scenario: Verify Member SignIn for valid input #manual
	
	Given the user is on home page
  When the user click on member signin page
  And enter valid uid pwd and click on signIn button
  Then user should be signedIn

		

	
	
	