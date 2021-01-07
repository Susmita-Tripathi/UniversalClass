package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/searchcourse.feature"} // which feature files to run
		,glue={"stepDefinitions"}  //,"base"}//package names having the scripts for the feature file
		,tags= {"@tag1"}
		)

public class SearchCourse_testrunner {

}
