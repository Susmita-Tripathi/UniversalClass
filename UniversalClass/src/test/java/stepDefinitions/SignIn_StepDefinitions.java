package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.SignIn;
import pages.SignIn_JoinCourse;

@RunWith(Cucumber.class)
public class SignIn_StepDefinitions {

	SignIn si = new SignIn();
	
    @Given("^user is on signIn page$")
    public void user_is_on_signin_page() throws Throwable {
	        si.open_signInPage();
	    }

    @When("^enters (.+) and (.+) as a input details and click on signIn$")
    public void enter_and_as_a_input_details_and_click_on_signin(String username, String password) throws Throwable {
	    	 si.input_details(username, password);
	    }

	    @Then("^user should signIn successfully$")
	    public void user_should_signin_successfully() throws Throwable {
	        si.signIn_success();
	    }

	    @Then("^error message should be displayed when entered invalid email or password$")
	    public void error_message_should_be_displayed_when_entered_invalid_email_or_password() throws Throwable {
	    	si.signIn_Error();
	    }
	       
}
