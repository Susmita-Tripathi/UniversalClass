package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.SearchCourse;

@RunWith(Cucumber.class)
public class SearchCourse_StepDefinitions {

	SearchCourse sc = new SearchCourse();
	
	@Given("^user is on UniversalClass home page$")
    public void user_is_on_universalclass_home_page() throws Throwable {
        sc.openurl();
    }

	@When("^user just click on search button without passing any input$")
    public void user_just_click_on_search_button_without_passing_any_input() throws Throwable {
        sc.blank_input_details();
    }

    @Then("^error message should be displayed$")
    public void error_message_should_be_displayed() throws Throwable {
        sc.blank_input_error_details();
    }
    
    @When("^user search for particular course and click on search button$")
    public void user_search_for_particular_course_and_click_on_search_button() throws Throwable {
        sc.course_search();
    }

    @Then("^should show appropriate result based on the search$")
    public void should_show_appropriate_result_based_on_the_search() throws Throwable {
        System.out.println("Search course result is displayed");
    }
    
    @When("^user enter course name and click on search button$")
    public void user_enter_course_name_and_click_on_search_button() throws Throwable {
    	sc.enter_coursename();
    }

    @Then("^user should navigate to search result page and click on certain course which is to be join$")
    public void user_should_navigate_to_search_result_page_and_click_on_certain_course_which_is_to_be_join() throws Throwable {
       sc.navigate_to_specific_course_page();
    }

    @And("^click on join course$")
    public void click_on_join_course() throws Throwable {
        sc.join_course();
    }
}
