package redtrust.level_test.web.spotify.profile;

import org.openqa.selenium.WebDriver;

import redtrust.level_test.web.core.driver.WebDriverManager;
import redtrust.level_test.web.core.page.Page;

public class ProfilePage extends Page {
	
	public ProfilePageElements elements;
	public ProfilePageActions actions;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		this.initializePage();
	}
	
	private void initializePage() {
        WebDriverManager.addWebDriver(this.driver);
        this.elements = new ProfilePageElements(this.driver);
        this.elements.initElements();
        this.actions = new ProfilePageActions(this.elements);
    }

}