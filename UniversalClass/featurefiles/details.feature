#Author: susmita.tripathy@capgemini.com

@post_signin
Feature: Post Login Options

  @welcome_message
  Scenario: Verify welcome message
    Given The user is logged in
    When the user clicks on the menu button
    Then Welcome and username should be displayed

  @update_info
  Scenario Outline: Update user information
		Given user is on Account Options page
		When the user clicks on Member Information
		And user updates the <firstname> and <lastname>
		Then a message should be displayed 
		And profile name should be changed
		
		Examples:
		| firstname | lastname |
		| Susmita | Tripathi |

	@logout_message
	Scenario: Verify logout message
		Given The user is loggedIn
    When the user clicks on the menu
		And the user clicks on LogOut
		Then successfully logged out message should be displayed