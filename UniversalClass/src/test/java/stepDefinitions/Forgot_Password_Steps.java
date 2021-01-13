package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.Forgot_Password_Pages;
import cucumber.api.java.en.Then;

public class Forgot_Password_Steps {

		Forgot_Password_Pages fp=new Forgot_Password_Pages();
		
		@Given("^the user is on SignIn page$")
	    public void the_user_is_on_signin_page() throws Throwable {
	        
	    }

	    @When("^the user click on forgot password$")
	    public void the_user_click_on_forgot_password() throws Throwable {
	        fp.go_to_forgotpass_page();
	    }

	    @Then("^enter email and display a message$")
	    public void enter_email_and_display_a_message() throws Throwable {
	        fp.enter_email();
	    }


	    
	

}
