package redtrust.level_test.web.spotify.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class HomePageActions {
	
	private HomePageElements elements;

    private WebDriverWait wait;

    public HomePageActions() {
        this.wait = WebDriverManager.getWebDriverWait();
    }

    public HomePageActions(HomePageElements elements) {
        this();
        this.elements = elements;
    }
    
    public boolean clickInitSesion() {
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.initSesion));
    	return WebActions.clickOn(waitElement);
    }
    
    public boolean openProfile() {
    	boolean openProfile = false;
    	if (this.expandProfileMenu()) {
    		openProfile = this.clickProfileLink();
    	}
    	return openProfile;
    }
    
    private boolean expandProfileMenu() {
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.profileMenu));
    	return WebActions.clickOn(waitElement);
    }
    
    private boolean clickProfileLink() {
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.profileLink));
    	return WebActions.clickOn(waitElement);
    }

}
