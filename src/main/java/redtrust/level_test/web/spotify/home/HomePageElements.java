package redtrust.level_test.web.spotify.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import redtrust.level_test.web.core.page.PageElements;

public class HomePageElements extends PageElements {
	
	@FindBy(css = HomeLocators.cssInitSesion)
	protected WebElement initSesion;

	public HomePageElements() { }
	
}