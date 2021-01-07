#Author: Amruta

@SignIn
Feature: SignIn
@tag1
Scenario: Verify Member SignIn page
	
	Given User is on universalclass home page
	When User navigate to header and click signIn
	Then Member signin page should be dispalyed

@tag2
Scenario Outline: Verify Member SignIn for valid input
	
	Given User is on Member SignIn page
	When User enteres valid <email> <password> and click on signIn button
	Then Member should be signIn

	Examples:
	| email | password |
	| amrutakolekar191@gmail.com | Amruta@1010 |

@tag3
Scenario Outline: Verify Member SignIn for invalid inputs
	
	Given User is on Member SignIn page
	When User enteres invalid <email> <password> and click on signIn button
	Then the error message should be displayed
	Examples:
	| email | password |
	| amrutakolekar191@gmail.com | Amruta@1001 |
	| amrutakolekar19@gmail.com | Amruta@1010 |
	| | Amruta@1010 |
	| amrutakolekar191@gmail.com | |
	| | |

    