package redtrust.level_test.web.spotify.modals.cookies;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class CookiesModalActions {
	
	private CookiesModalElements elements;

    private WebDriverWait wait;

    public CookiesModalActions() {
        this.wait = WebDriverManager.getWebDriverWait();
    }

    public CookiesModalActions(CookiesModalElements elements) {
        this();
        this.elements = elements;
    }
    
    public boolean acceptAll() {
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.acceptAll));
    	return WebActions.clickOn(waitElement);
    }

}