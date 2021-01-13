#Author: akanksha-danbahadur.yadav@capgemini.com

@search_course
Feature: Search Course

Scenario:  
	Given user is on UniversalClass home page

Scenario: Search for different courses with invalid data
  When user just click on search button without passing any input
  	Then error message should be displayed
  	
Scenario: Search for different courses with valid data
    When user search for particular course and click on search button
    Then should show appropriate result based on the search
     
Scenario: To join certain course based on search
     When user enter course name and click on search button
     Then user should navigate to search result page and click on certain course which is to be join
      And click on join course
 