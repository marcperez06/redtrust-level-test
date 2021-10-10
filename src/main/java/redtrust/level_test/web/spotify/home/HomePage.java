package redtrust.level_test.web.spotify.home;

import org.openqa.selenium.WebDriver;

import redtrust.level_test.web.core.driver.WebDriverManager;
import redtrust.level_test.web.core.page.Page;

public class HomePage extends Page {
	
	public HomePageElements elements;
	public HomePageActions actions;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.initializePage();
	}
	
	private void initializePage() {
        WebDriverManager.addWebDriver(this.driver);
        this.elements = new HomePageElements();
        this.elements.initElements(this.driver);
        this.actions = new HomePageActions(this.elements);
    }

}