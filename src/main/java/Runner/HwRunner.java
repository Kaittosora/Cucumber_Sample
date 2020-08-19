package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html"},
        features ={"src/test/java/FeatureFiles"},
        glue = {"StepDefinition"},
        dryRun = false
)

public class HwRunner extends AbstractTestNGCucumberTests {
}
