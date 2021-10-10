package redtrust.level_test.web.spotify.modals.ads;

import org.openqa.selenium.WebDriver;

import redtrust.level_test.web.core.driver.WebDriverManager;
import redtrust.level_test.web.core.page.Page;

public class AdsModal extends Page {
	
	public AdsModalElements elements;
	public AdsModalActions actions;
	
	public AdsModal(WebDriver driver) {
		super(driver);
		this.initializePage();
	}
	
	private void initializePage() {
        WebDriverManager.addWebDriver(this.driver);
        this.elements = new AdsModalElements(this.driver);
        this.elements.initElements();
        this.actions = new AdsModalActions(this.elements);
    }

}