#Author: jyoita.roy@capgemini.com

@forgotpass
Feature: Forget password for user
  I want to use this template for my feature file

    Scenario: Verify forgot password for valid email
    Given the user is on signin page
    When user click on forgot password
    Then enter email and view message
   