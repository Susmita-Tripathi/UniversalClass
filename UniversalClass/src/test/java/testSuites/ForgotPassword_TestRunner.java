package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/forgotPassword1.feature","featurefiles/forgotPassword2.feature"}
		,glue= {"stepDefinitions","base"}
		,tags= "@forgotPassword"
		)

public class ForgotPassword_TestRunner extends  AbstractTestNGCucumberTests {

}
