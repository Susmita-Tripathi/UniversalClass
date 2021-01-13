#Author: jyoita.roy@capgemini.com

@search
Feature: Search Functionality

Scenario: User should be able to search 
   Given user is on the homepage
   When user enter coursename which is available
   Then user should be able to see the suggestion of courses