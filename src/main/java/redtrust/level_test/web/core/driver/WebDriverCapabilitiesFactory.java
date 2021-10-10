package redtrust.level_test.web.core.driver;

import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCapabilitiesFactory {

	public static ChromeOptions createChromeOptions() {
		ArrayList<String> optionsList = new ArrayList<String>();
		ChromeOptions chromeOptions = new ChromeOptions();
		//optionsList.add("--window-size=1024,768");
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("--whitelisted-ips=''");
		chromeOptions.addArguments(optionsList);
		return chromeOptions;
	}
	
}
