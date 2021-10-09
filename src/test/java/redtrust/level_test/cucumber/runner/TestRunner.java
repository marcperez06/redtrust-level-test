package redtrust.level_test.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				plugin = { "pretty", "json:report/Cucumber_report.json", "html:reports/Cucumber_report.html" }, 
				glue = { "cucumber.stepdefs" }, 
				features = { "features/exercice2" })

public class TestRunner {

}