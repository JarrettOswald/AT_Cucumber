package AT_Сucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/AT_Сucumber/features",
            glue = "AT_Сucumber",
            tags = "@all"
    )
    public class TestRunner {

    }
