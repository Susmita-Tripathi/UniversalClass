#Author: Amruta

@CourseCatalog
Feature: Verify Course Catalog
  I want to use this template for my feature file

  @tag1
  Scenario: Verify Course Catalog without signin
    Given the user is on UniversalClass home page
		When the user click on menu and again click on Course Catalog
    Then the Course Catalog should be displayed
  @tag2
  Scenario Outline: Verify search option 
    Given the sarch text box is visible
    When the user type course <name> in search text box
    Then validate results based on course name <coursestatus>

    Examples: 
      | name  | coursestatus |
      | Business | available |
      | java | notavailable |
      
