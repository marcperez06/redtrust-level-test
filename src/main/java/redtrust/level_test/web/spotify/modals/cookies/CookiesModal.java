package redtrust.level_test.web.spotify.modals.cookies;

import org.openqa.selenium.WebDriver;

import redtrust.level_test.web.core.driver.WebDriverManager;
import redtrust.level_test.web.core.page.Page;

public class CookiesModal extends Page {
	
	public CookiesModalElements elements;
	public CookiesModalActions actions;
	
	public CookiesModal(WebDriver driver) {
		super(driver);
		this.initializePage();
	}
	
	private void initializePage() {
        WebDriverManager.addWebDriver(this.driver);
        this.elements = new CookiesModalElements(this.driver);
        this.elements.initElements();
        this.actions = new CookiesModalActions(this.elements);
    }

}