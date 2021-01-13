package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Course_Catalog_Pages;

public class Course_Catalog_Steps {

		Course_Catalog_Pages cp=new Course_Catalog_Pages();
	
		@Given("^the user is on UniversalClass home page$")
	    public void the_user_is_on_universalclass_home_page() throws Throwable {
	        cp.home_page();
	    }

	    @When("^the user click on menu and again click on Course Catalog$")
	    public void the_user_click_on_menu_and_again_click_on_course_catalog() throws Throwable {
	        cp.click_on_course_catalog();
	    }

	    @Then("^the Course Catalog should be displayed$")
	    public void the_course_catalog_should_be_displayed() throws Throwable {
	        cp.coursecatalog_page();
	    }
	    
	    @Given("^the sarch text box is visible$")
	    public void the_sarch_text_box_is_visible() throws Throwable {
	       cp.find_search_text_box();
	    }

	    @When("^the user type course (.+) in search text box$")
	    public void the_user_type_course_in_search_text_box(String name) throws Throwable {
	       cp.search_for_course(name);
	    }

	    @Then("^validate results based on course name (.+)$")
	    public void validate_results_based_on_course_name(String coursestatus) throws Throwable {
	        cp.available_courses(coursestatus);
	    }
}
