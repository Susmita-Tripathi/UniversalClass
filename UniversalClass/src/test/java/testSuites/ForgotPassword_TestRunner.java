package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/t_forgotpass.feature"}
		,glue= {"stepDefinitions","base"}
		,tags= "@forgotpass"
		)

public class ForgotPassword_TestRunner extends AbstractTestNGCucumberTests{

}
