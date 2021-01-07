package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class SignUp_StepDefinitions {

	@Given("^user is on Sign up page$")
	public void user_is_on_sign_up_page() throws Throwable {

	}
	
    @When("^enter (.+) (.+) (.+) (.+) $")
    public void enter(String firstname, String lastname, String email, String password) throws Throwable {
       
    }

    @Then("^user should SignIn successfully$")
    public void user_should_signin_successfully() throws Throwable {
        
    }

    @And("^select checkbox for accepting terms of service to sign up, click Sign up$")
    public void select_checkbox_for_accepting_terms_of_service_to_sign_up_click_sign_up() throws Throwable {
        
    }

	@When("^we don't enter any input field and click Sign Up$")
	public void we_dont_enter_any_input_field_and_click_sign_up() throws Throwable {

	}

	@Then("^error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {

	}

	@And("^checkbox is not selected for accepting terms of service to sign up, click Sign up$")
	public void checkbox_is_not_selected_for_accepting_terms_of_service_to_sign_up_click_sign_up() throws Throwable {

	}

	@When("^enter invalid characters in (.+) and (.+), valid (.+) and (.+)  $")
    public void enter_invalid_characters_in_and_valid_and(String firstname, String lastname, String email, String password) throws Throwable {
     
    }

	@When("^enter  (.+),(.+),invalid email(.+), (.+) $")
	public void enter_invalid_email(String firstname, String lastname, String email, String password) throws Throwable {

	}

	@When("^enter  (.+),(.+),(.+), invalid password (.+)$")
	public void enter_invalid_password(String firstname, String lastname, String email, String password)
			throws Throwable {

	}

}
