package redtrust.level_test.cucumber.stepdefs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.marcperez06.java_utilities.api.request.Request;
import io.github.marcperez06.java_utilities.api.request.Response;
import io.github.marcperez06.java_utilities.api.request.ResponseTypeHolder;
import io.github.marcperez06.java_utilities.api.request.enums.HttpMethodEnum;
import io.github.marcperez06.java_utilities.api.rest.UnirestClient;
import io.github.marcperez06.java_utilities.api.rest.interfaces.IRestClient;
import io.github.marcperez06.java_utilities.logger.Logger;
import io.github.marcperez06.java_utilities.validation.ValidationUtils;
import redtrust.level_test.web.core.actions.WebActions;
import redtrust.level_test.web.core.driver.WebDriverFactory;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class LinkCheckerStepDefs {
	
	private WebDriver globalDriver;
	private IRestClient rest;
	private Map<String, Integer> linksVisited = new HashMap<String, Integer>();
	private Set<String> linksFailed = new HashSet<String>();
	private List<WebElement> links;
	
	@Given("a webpage {string}")
	public void a_webpage(String webpage) {
		this.globalDriver = WebDriverFactory.createDriver();
		WebDriverManager.addWebDriver(this.globalDriver);
	    this.globalDriver.get(webpage);
	    this.rest = new UnirestClient();
	}
	
	@When("get all the links")
	public void get_all_the_links() {
	    links = WebActions.searchElements(By.tagName("a"));
	}
	
	@Then("verify that each link returns the status code {int}")
	public void verify_that_each_link_returns_the_status_code(int expectedStatusCode) {
	    for (WebElement link : this.links) {
	    	String href = WebActions.getAttribute(link, "href");
	    	
	    	if (href.startsWith("http") || href.startsWith("www")) {
	    		
	    		if (!this.linksVisited.containsKey(href)) {
	    			
	    			Request request = new Request(HttpMethodEnum.GET);
		    		request.setURL(href);
		    		request.setResponseType(new ResponseTypeHolder<Void>() {});
		    		Response<Void> response = this.rest.send(request);
		    		
		    		this.linksVisited.put(href, response.getStatusCode());
		    		
		    		if (!ValidationUtils.equals(response.getStatusCode(), expectedStatusCode)) {
		    			this.linksFailed.add(href);
		    		}
		    		
	    		}

	    	}

	    }
	    
	    Logger.println("Print results");
	    for (Entry<String, Integer> entry : this.linksVisited.entrySet()) {
	    	System.out.println("Url: " + entry.getKey() + " --> Status: " + entry.getValue());
	    }
	    
	    Assert.assertTrue("Exist " + this.linksFailed.size() + " links that fails", this.linksFailed.isEmpty());
	}

}