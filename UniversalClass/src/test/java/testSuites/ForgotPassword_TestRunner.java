package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
(		
		features = {"featurefiles/ForgotPassword.feature"} /// which feature files to run	
		,glue={"stepDefinitions","base"}																	//package names having the scripts for the feature file		
		,tags= {"@forgot_password"}											// the tags to run.... which are in feature file				
)
public class ForgotPassword_TestRunner extends AbstractTestNGCucumberTests{

}
