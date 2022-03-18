package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"StepDefinition"}
,monochrome = true
//,plugin = {"pretty", "junit:target/JunitReport/report.xml",
//		"json:target/JSONReport/report.json",
//		"html:target/htmlReport/report.html"} 

		)
public class TestRunner {

}
