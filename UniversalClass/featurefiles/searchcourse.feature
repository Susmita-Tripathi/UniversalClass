#Author: your.email@your.domain.com

@Search
Feature: Search Functionality

@tag1
Scenario: User should be able to search on UniversalClass Homepage
	Given User is on the homepage
	When User enters course which is available
	Then User should be able to see the suggestion of courses
	
@tag2
Scenario Outline: User should be able to search after signed in
	Given User has signed in
	When User selects search from dropdown menu
	And The User enters <CourseName> which is available
	Then User should be able to see the suggestion of courses
Examples:
	| CourseName |
	| Accounting |

@tag3
Scenario Outline: User should be able to search after signed in
	Given User has signed in
	When User selects search from dropdown menu
	And User enters <CourseName> which is not available
	Then No records matched your search criteria message should be displayed
Examples:
	| CourseName |
	| Selenium |

@tag4
Scenario: User should be able to search after signed in
	Given User has signed in
	When User selects search from dropdown menu
	And User doesn't enters any input in searchbar 
	Then No records matched your search criteria message should be displayed

