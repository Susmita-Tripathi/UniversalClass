package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/coursecatlog.feature"}
		,glue= {"stepDefinitions","base"}
		,tags="@CourseCatalog"
		)

public class Course_Catalog_testrunner extends AbstractTestNGCucumberTests {
	
}
