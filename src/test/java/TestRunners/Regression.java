package TestRunners;

import Utilities.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features"
        , glue={"StepDefinitions"}
        , tags = "@RegressionTests"
)

public class Regression {
    @BeforeClass
    public static void setup() {
        DriverManager.getDriver();
    }

    @AfterClass
    public static void teardown() {
        DriverManager.quitDriver();
    }
}
