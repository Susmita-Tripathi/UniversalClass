package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ForgotPassword;

public class ForgotPassword_StepDefinitions {

	ForgotPassword forgotPass = new ForgotPassword();
	
	@Given("^user is on homepage of forgot password$")
    public void user_is_on_homepage_of_forgot_password() throws Throwable {
		forgotPass.open_forgotPassPage();
    }
	
	@When("^we don't enter input for email and click on reset password$")
    public void we_dont_enter_input_for_email_and_click_on_reset_password() throws Throwable {
		forgotPass.blank_input();
    }

    @Then("^error message is displayed for sending blank input$")
    public void error_message_is_displayed_for_sending_blank_input() throws Throwable {
    	forgotPass.blank_input_error_details();
    }
    
    @When("^enters (.+) and click on reset password$")
    public void enter_and_click_on_reset_password(String email) throws Throwable {
    	forgotPass.input_details(email);
    }

    @Then("^error message is displayed for email id not found$")
    public void error_message_is_displayed_for_email_id_not_found() throws Throwable {
    	forgotPass.error_details();
    }
    
    @Then("^link to reset password should be sent to respective email address$")
    public void link_to_reset_password_should_be_sent_to_respective_email_address() throws Throwable {
    	forgotPass.ResetPass_MailSent();
    }
}
