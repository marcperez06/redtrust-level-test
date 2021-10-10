package redtrust.level_test.web.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageElements {
	
	protected WebDriver driver;
	
	protected PageElements(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void initElements() {
        PageFactory.initElements(this.driver, this);
    }

}
