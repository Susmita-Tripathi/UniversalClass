package stepDefinitions;

import cucumber.api.java.en.And;


import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SignIn_pages;

public class SignIn_Steps {
	
	SignIn_pages si=new SignIn_pages();
	
	@Given("^the user is on home page$")
    public void the_user_is_on_home_page() throws Throwable {
        si.universalclass();
    }

    @When("^the user click on member signin page$")
    public void the_user_click_on_member_signin_page() throws Throwable {
        si.click_on_signin();
    }

    @Then("^enter invalid email password and click on signIn button and verify error message$")
    public void enter_invalid_email_password_and_click_on_signin_button_and_verify_error_message() throws Throwable {
        si.enter_invalid_credentials();
    }
	
    @And("^enter valid uid pwd and click on signIn button$")
    public void enter_valid_uid_pwd_and_click_on_signin_button() throws Throwable {
        si.valid_signin();
    }
    
    @Then("^user should be signedIn$")
    public void user_should_be_signedin() throws Throwable {
        si.welcome_window();
    }
    	    
}
