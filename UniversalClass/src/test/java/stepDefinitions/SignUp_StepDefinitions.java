package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.SignUp;

@RunWith(Cucumber.class)
public class SignUp_StepDefinitions {

	SignUp su = new SignUp();

	@Given("^user is on Sign up page$")
	public void user_is_on_sign_up_page() throws Throwable {
		su.openSignUpPAge();
	}

	@When("^enter (.+) (.+) (.+) (.+)$")
    public void enter(String firstname, String lastname, String email, String password) throws Throwable {
		su.enter_input_details(firstname, lastname, email, password);
	}
	
	/*@When("^enter (.+) and (.+)$")
	public void enter_and(String firstname, String lastname) throws Throwable { 
		  su.enter_username(firstname, lastname); 
	  }
	  
	@And("^enters (.+) and (.+)$") 
	public void enters_and(String email, String password) throws Throwable { 
		  su.enter_logindetails(email, password); 
	}*/
	  
    @Then("^user should SignIn successfully$") 
    public void user_should_signin_successfully() throws Throwable { 
    	su.verify_email();
	  System.out.println("SignIn successfully"); 
	}
	
    @And("^select checkbox for accepting terms of service to sign up, click Sign up$") 
	public void select_checkbox_for_accepting_terms_of_service_to_sign_up_click_sign_up() throws Throwable {
		  su.select_checkbox_and_click_SignUp(); 
	 }
	 
	@When("^we don't enter any input field  and click Sign Up$")
	public void we_dont_enter_any_input_field_and_click_sign_up() throws Throwable {
		su.blank_input();
	}

	@Then("^error message should be displayed for blank input$")
	public void error_message_should_be_displayed_for_blank_input() throws Throwable {
		su.blank_input_error();
	}

	@Then("^error message should be displayed for not selecting checkbox$")
	public void error_message_should_be_displayed_for_not_selecting_checkbox() throws Throwable {
	        System.out.println("Terms of service is not selected");
	    	su.checkbox_unchecked_error();
	}

	@And("^checkbox is not selected for accepting terms of service to sign up, click Sign up$")
	public void checkbox_is_not_selected_for_accepting_terms_of_service_to_sign_up_click_sign_up() throws Throwable {
	        su.checkbox_unchecked();
	}
	
	@Then("^error message should be displayed for entering invalid email$")
	public void error_message_should_be_displayed_for_entering_invalid_email() throws Throwable {
	        su.invalid_email_error();
	    }
	
    @Then("^error message should be displayed for entering invalid password$")
    public void error_message_should_be_displayed_for_entering_invalid_password() throws Throwable {
        su.invalid_password_error();
    }
    
    @Then("^error message should be displayed for entering email that is already registered$")
    public void error_message_should_be_displayed_for_entering_email_that_is_already_registered() throws Throwable {
        su.duplicate_email_error();
    }
    
    @Then("^error message should be displayed for entering invalid characters in first name and last name$")
    public void error_message_should_be_displayed_for_entering_invalid_characters_in_first_name_and_last_name() throws Throwable {
        System.out.println("hello");
    	su.invalid_character_error();
    }
	 
	 

}
