package redtrust.level_test.web.spotify.modals.ads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class AdsModalActions {
	
	private AdsModalElements elements;

    private WebDriverWait wait;

    public AdsModalActions() {
        this.wait = WebDriverManager.getWebDriverWait();
    }

    public AdsModalActions(AdsModalElements elements) {
        this();
        this.elements = elements;
    }
    
    public void closeAll() {
    	for(WebElement closeButton : this.elements.closeButtons) {
    		try {
    			WebActions.clickOn(closeButton);	
    		} catch (Exception e) { }
    	}
    }

}