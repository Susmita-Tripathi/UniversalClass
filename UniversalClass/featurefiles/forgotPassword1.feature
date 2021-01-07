#Author: your.email@your.domain.com

@forgotPassword
Feature: Forget password for subscribed user
  I want to use this template for my feature file

  @tag1
    Scenario Outline: Verify forgot password for valid email
    Given the user is on signin page
    When user click on forgot password
    And enter <email>
    Then display massage Succesfully sent password reset information to email
    Examples:
    | email |
    | rjyoita@gmail.com |