package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue="TestScenarios",
        plugin={"json:target/output/cucumber.json",
                "html:target/output/cucumber-html-report.html"},
        tags="not @Ignore")
public class TestRunner {
}
