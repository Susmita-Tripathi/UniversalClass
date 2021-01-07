#Author: your.email@your.domain.com

@forgotPassword
Feature: Forget password for unsubscribed user
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Verify forgot password for valid email
    Given the user is on signin page
    When user click on forgot password 
    And enter <email>
    Then display massage There is no match for an account with that email address
    Examples:
    | email |
    | jyoita.roy@capgemini.com |

  @tag2
  Scenario Outline: Verify forgot password for invalid email 
    Given the user is on signin page
    When user click on forgot password 
    And enter <email>
    Then display massage The mail is invalid
    Examples:
    | email |
    | rjyoita@gmail |
