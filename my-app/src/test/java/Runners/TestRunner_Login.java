package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Cucumber Features/loginPwrTrckr.feature", glue= {"StepDefinitions"},
monochrome=true,
plugin = { "pretty", "html:HtmlReports/HtmlReport"}
)

public class TestRunner_Login {

}