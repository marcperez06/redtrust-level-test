package redtrust.level_test.web.core.driver;

public class WebDriverPropertiesManager {
	
	public static final String CHROME_PROPERTY = "webdriver.chrome.driver";

	private WebDriverPropertiesManager() {}
	
	public static void setChromeDriverProperty(String...driverPath) {
		System.setProperty(CHROME_PROPERTY, driverPath[0]);
	}

}