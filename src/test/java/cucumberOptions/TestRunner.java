package cucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepDefinations",
		plugin = {"pretty", "html:target/report-html"},
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		stepNotifications = true,
		monochrome = true
		)
public class TestRunner {

}

