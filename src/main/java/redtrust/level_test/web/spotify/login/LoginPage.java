package redtrust.level_test.web.spotify.login;

import org.openqa.selenium.WebDriver;

import redtrust.level_test.web.core.driver.WebDriverManager;
import redtrust.level_test.web.core.page.Page;

public class LoginPage extends Page {
	
	public LoginPageElements elements;
	public LoginPageActions actions;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.initializePage();
	}
	
	private void initializePage() {
        WebDriverManager.addWebDriver(this.driver);
        this.elements = new LoginPageElements(this.driver);
        this.elements.initElements();
        this.actions = new LoginPageActions(this.elements);
    }

}