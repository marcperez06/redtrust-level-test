package redtrust.level_test.web.spotify.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import redtrust.level_test.web.core.page.PageElements;

public class LoginPageElements extends PageElements {
	
	@FindBy(id = LoginLocators.idUsername)
	protected WebElement username;
	
	@FindBy(id = LoginLocators.idPassword)
	protected WebElement password;
	
	@FindBy(css = LoginLocators.cssRemember)
	protected WebElement remember;
	
	@FindBy(id = LoginLocators.idLoginButton)
	protected WebElement loginButton;

	public LoginPageElements(WebDriver driver) {
		super(driver);
	}
	
}