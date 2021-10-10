package redtrust.level_test.web.spotify.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.marcperez06.java_utilities.validation.ValidationUtils;
import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class LoginPageActions {
	
	private LoginPageElements elements;

    private WebDriverWait wait;

    public LoginPageActions() {
        this.wait = WebDriverManager.getWebDriverWait();
    }

    public LoginPageActions(LoginPageElements elements) {
        this();
        this.elements = elements;
    }
    
    public boolean login(String user, String password) {
    	String currentUrl = WebDriverManager.getDriver().getCurrentUrl();
    	boolean login = false;
    	WebElement waitElement = this.wait.until(ExpectedConditions.visibilityOf(this.elements.username));
    	WebActions.writeOn(waitElement, user);
    	WebActions.writeOn(this.elements.password, password);
    	WebActions.clickOn(this.elements.remember);
    	WebActions.clickOn(this.elements.loginButton);
    	WebActions.sleep(2000);
    	String newUrl = WebDriverManager.getDriver().getCurrentUrl();
    	login = !ValidationUtils.equals(currentUrl, newUrl);
    	return login;
    }

}