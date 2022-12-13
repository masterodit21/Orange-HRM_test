package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue= "stepdefs"
)
public class LoginRunner  extends AbstractTestNGCucumberTests {

}
