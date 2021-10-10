package redtrust.level_test.web.core.page;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean exit() {
		boolean exit = false;
		try {
			this.driver.close();
			this.driver.quit();
			exit = true;
		} catch (Exception e) {
			exit = false;
		}
		return exit;
	}

}
