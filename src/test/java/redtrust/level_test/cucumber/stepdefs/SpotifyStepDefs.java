package redtrust.level_test.cucumber.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.marcperez06.java_utilities.file.FileUtils;
import io.github.marcperez06.java_utilities.strings.StringUtils;
import redtrust.level_test.web.core.driver.WebDriverFactory;
import redtrust.level_test.web.information.Paths;
import redtrust.level_test.web.spotify.home.HomePage;
import redtrust.level_test.web.spotify.login.LoginPage;
import redtrust.level_test.web.spotify.modals.ads.AdsModal;
import redtrust.level_test.web.spotify.modals.cookies.CookiesModal;
import redtrust.level_test.web.spotify.profile.ProfilePage;

public class SpotifyStepDefs {
	
	private static final String SPOTIFY_URL = "https://www.spotify.com/es";
	private WebDriver globalDriver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ProfilePage profilePage;
	private CookiesModal cookiesModal;
	private AdsModal adsModal;

	@Given("a valid user for Spotify webpage")
	public void a_valid_user_for_spotify() {
		// oauth.txt content is --> user, password 
		String userAndPass = FileUtils.getStringOfFile(Paths.RESOURCES_DIR + "oauth.txt");
		String[] oauth = StringUtils.split(userAndPass, ",");
		
	    this.globalDriver = WebDriverFactory.createDriver();
	    this.globalDriver.get(SPOTIFY_URL);
	    this.homePage = new HomePage(this.globalDriver);
	    this.loginPage = new LoginPage(this.globalDriver);
	    
	    this.homePage.actions.clickInitSesion();
	    boolean login = this.loginPage.actions.login(oauth[0].trim(), oauth[1].trim());
	    
	    Assert.assertTrue("The user specified is not valid", login);
	}

	@When("accept cookies")
	public void accept_cookies() {
	    this.cookiesModal = new CookiesModal(this.globalDriver);
		this.cookiesModal.actions.acceptAll();
	}
	
	@When("close all advertisements")
	public void close_all_advertisements() {
		this.adsModal = new AdsModal(this.globalDriver);
		this.adsModal.actions.closeAll();
	}
	
	@When("change the url for Spotify webpage")
	public void change_the_url_for_spotify_webpage() {
	    this.globalDriver.get(SPOTIFY_URL);
	}

	@When("access to profile page")
	public void access_to_profile_page() {
	    Assert.assertTrue("Cannot access to profile page", this.homePage.actions.openProfile());
	}

	@Then("verify that email is {string}")
	public void verify_that_email_is(String email) {
	    this.profilePage = new ProfilePage(this.globalDriver);
	    String currentEmail = this.profilePage.actions.getEmailText();
	    Assert.assertEquals("The emails are not equals", currentEmail, email);
	}
	
}