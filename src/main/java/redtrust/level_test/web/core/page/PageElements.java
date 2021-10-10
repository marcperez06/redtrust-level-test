package redtrust.level_test.web.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class PageElements {
	
	protected WebDriver driver;
	
	protected PageElements() {
		this.driver = null;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void initElements() {
        PageFactory.initElements(this.driver, this);
    }

    public void initElements(WebDriver driver) {
    	this.driver = driver;
    	this.initElements(driver);
    }

    public void initElements(FieldDecorator decorator) {
        PageFactory.initElements(decorator, this);
    }

}
