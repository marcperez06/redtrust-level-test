package redtrust.level_test.web.spotify.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class ProfilePageActions {
	
	private ProfilePageElements elements;

    private WebDriverWait wait;

    public ProfilePageActions() {
        this.wait = WebDriverManager.getWebDriverWait();
    }

    public ProfilePageActions(ProfilePageElements elements) {
        this();
        this.elements = elements;
    }
    
    public String getEmailText() {
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.email));
    	return WebActions.getText(waitElement);
    }

}