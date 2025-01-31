package Testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/car_valuation.feature" ,
        glue="Stepdefinition",
        dryRun = false,

        monochrome = true,
        plugin={"pretty","html:test-output"}


)
public class TestRunner {

}
