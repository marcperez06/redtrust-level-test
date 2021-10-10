package redtrust.level_test.web.spotify.modals.cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import redtrust.level_test.web.core.page.PageElements;

public class CookiesModalElements extends PageElements {
	
	@FindBy(id = CookiesLocators.idAcceptAllButton)
	protected WebElement acceptAll;
	
	public CookiesModalElements(WebDriver driver) {
		super(driver);
	}
	
}