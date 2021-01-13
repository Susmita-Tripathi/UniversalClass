package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/signin.feature"}
		,glue= {"stepDefinitions"}
		,tags= {"@SignIn"}
		)
public class SignIn_testrunner extends AbstractTestNGCucumberTests
{

}
