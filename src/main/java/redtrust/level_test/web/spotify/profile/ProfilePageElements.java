package redtrust.level_test.web.spotify.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import redtrust.level_test.web.core.page.PageElements;

public class ProfilePageElements extends PageElements {
	
	@FindBy(xpath = ProfileLocators.xpathEmail)
	protected WebElement email;
	
	public ProfilePageElements(WebDriver driver) {
		super(driver);
	}
	
}