package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Options_pl;

public class PostLogin_Options {
	Options_pl op = new Options_pl();
	
	@Given("^The user is logged in$")
    public void the_user_is_logged_in() throws Throwable {
        op.login();
    }

    @When("^the user clicks on the menu button$")
    public void the_user_clicks_on_the_menu_button() throws Throwable {
        op.menu_click();
    }

    @Then("^Welcome and username should be displayed$")
    public void welcome_and_username_should_be_displayed() throws Throwable {
        op.verify_message();
    }
    
}
