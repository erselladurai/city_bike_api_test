package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"boots.uk.dps"},
        strict = true
)

public class Runner extends AbstractTestNGCucumberTests {

    private static Integer count = 0;


    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Currently executing -> " + ++count + "." + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
    }
}

