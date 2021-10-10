package redtrust.level_test.cucumber.stepdefs;

import io.cucumber.java.After;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class CucumberHooks {
	
	@After
	public void tearDown() {
		WebDriverManager.exit();
	}

}