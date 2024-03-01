package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Featurefile"},
		
		//features= {".//FeatureFile/A_UpcomingBikes.feature"},
		//features= {".//FeatureFile/B_UsedCars.feature"},
		//features= {".//FeatureFile/C_Login.feature"},
		//features= {".//FeatureFile/Smoke.feature"},
		//features= {".//FeatureFile/Regression.feature"},
		glue= "stepDefinations"
		
		
		
		
		)
public class Testrunner {
}
