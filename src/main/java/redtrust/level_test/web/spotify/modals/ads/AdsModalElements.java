package redtrust.level_test.web.spotify.modals.ads;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import redtrust.level_test.web.core.page.PageElements;

public class AdsModalElements extends PageElements {
	
	@FindBy(css = AdsLocators.cssCloseButtons)
	protected List<WebElement> closeButtons;
	
	public AdsModalElements(WebDriver driver) {
		super(driver);
	}
	
}