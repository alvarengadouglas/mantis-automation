package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import util.TestRule;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@smoke",
        glue = {"steps", "util"}
)
public class RunTest {

    @ClassRule
    public static TestRule testRule = new TestRule();

}
