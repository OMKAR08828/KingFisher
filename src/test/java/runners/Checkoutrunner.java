package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
features="src/test/resources/features",
glue="StepDefinitions",
plugin= {"pretty",
		 "html:target/cucumber-reports.html", 
         "json:target/cucumber.json",
         },
monochrome = true

		)
public class Checkoutrunner extends AbstractTestNGCucumberTests{

}
