package redtrust.level_test.web.core.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	private static Map<Long, WebDriver> driversMap = new HashMap<Long, WebDriver>();
	
	private WebDriverManager() {}
	
	public static void addWebDriver(WebDriver driver) {
		Long key = getKey();
		if (!driversMap.containsKey(key)) {
			driversMap.put(key, driver);	
		}
	}

	private static Long getKey() {
		return getKeyOfThread(Thread.currentThread());
	}
	
	private static Long getKeyOfThread(Thread thread) {
		return Long.valueOf(thread.getId());
	}
	
	public static WebDriver getDriver() {
		return getDriverByKey(Thread.currentThread());
	}
	
	public static WebDriver getDriverByKey(Thread thread) {
		Long key = getKeyOfThread(thread);
		return getDriverByKey(key);
	}
	
	public static WebDriver getDriverByKey(Long key) {
		WebDriver driver = null;
		if (driversMap != null) {
			driver = driversMap.get(key);
		}
		return driver;
	}
	
	public static WebDriverWait getWebDriverWait() {
		int waitTime = 5;
		WebDriverWait wait = null;
		WebDriver driver = getDriver();
		if (driver != null) {
			wait = new WebDriverWait(driver, waitTime);
		}
		return wait;
	}

}