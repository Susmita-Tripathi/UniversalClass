package testSuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(		
		features = {"featurefiles/ValidCredentials_SignUp.feature"} /// which feature files to run	
		,glue={"stepDefinitions"}																	//package names having the scripts for the feature file		
		,tags= {"@signup_valid"}											// the tags to run.... which are in feature file				
)
public class SignUp_TestRunner {

}
