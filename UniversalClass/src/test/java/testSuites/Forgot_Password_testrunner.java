package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"featurefiles/forgotpassword.feature"}
		,glue= {"stepDefinitions","base"}
		,tags="@ForgotPassword"
		)
public class Forgot_Password_testrunner extends AbstractTestNGCucumberTests{

}
