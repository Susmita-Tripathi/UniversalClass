package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
(		
		features = {"featurefiles/SearchCourse.feature"} /// which feature files to run	
		,glue={"stepDefinitions","base"}																	//package names having the scripts for the feature file		
		,tags= {"@search_course"}											// the tags to run.... which are in feature file				
)
public class SearchCourse_TestRunner extends AbstractTestNGCucumberTests{

}
