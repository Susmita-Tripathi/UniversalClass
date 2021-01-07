package testSuites;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/details.feature"} 
		,glue={"stepDefinitions","base"}				
		,tags= {"@welcome_message"}				
		)

public class PostLogin_Runner {

}
