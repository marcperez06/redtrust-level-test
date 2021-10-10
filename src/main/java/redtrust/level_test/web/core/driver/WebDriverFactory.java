package redtrust.level_test.web.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.marcperez06.java_utilities.logger.Logger;
import redtrust.level_test.web.information.Paths;

public class WebDriverFactory {
	
	private WebDriverFactory() {}
	
	public static WebDriver createDriver() {
		WebDriver driver = null;
		WebDriverPropertiesManager.setChromeDriverProperty(Paths.CHROME_DRIVER);

		try {
			ChromeOptions chromeOptions = WebDriverCapabilitiesFactory.createChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		} catch (Throwable e) {
			Logger.println("Can not create Web Driver");
			throw new RuntimeException(e);
		}

		return driver;
	}

}