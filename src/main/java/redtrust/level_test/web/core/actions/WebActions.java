package redtrust.level_test.web.core.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

import io.github.marcperez06.java_utilities.logger.Logger;
import io.github.marcperez06.java_utilities.reflection.ReflectionUtils;
import redtrust.level_test.web.core.driver.WebDriverManager;

public class WebActions {
	
	public static final long WAIT_TIME = 1000;
	private static final String WEB_ELEMENT_WITHOUT_LOCATOR = "'The web element is null, not have locator'";
	
	/**
	 * Return the locator used to locate the element
	 * @param element - WebElement
	 * @return String - locator of element
	 */
	public static String getLocator(WebElement element) {
		String locator = WEB_ELEMENT_WITHOUT_LOCATOR;
		if (element != null) {
			By by = getByLocator(element);
	    	String fullLocator = getFullLocator(element);
	    	locator = extractLocator(by, fullLocator);
		}
		return locator;
	}
	
	public static String extractLocator(By by, String fullLocator) {
		String locator = fullLocator;
		
		if (fullLocator.contains("By.id")) {
    		locator = ReflectionUtils.getFieldValue(by, "id");
    	} else if (fullLocator.contains("By.cssSelector")) {
    		locator = ReflectionUtils.getFieldValue(by, "cssSelector");
    	} else if (fullLocator.contains("By.tagName")) {
    		locator = ReflectionUtils.getFieldValue(by, "tagName");
    	} else if (fullLocator.contains("By.xpath")) {
    		locator = ReflectionUtils.getFieldValue(by, "xpath");
    	} else if (fullLocator.contains("By.className")) {
    		locator = ReflectionUtils.getFieldValue(by, "className");
    	} else if (fullLocator.contains("By.name")) {
    		locator = ReflectionUtils.getFieldValue(by, "name");
    	} else if (fullLocator.contains("By.linkText")) {
    		locator = ReflectionUtils.getFieldValue(by, "linkText");
    	} else if (fullLocator.contains("By.partialLinkText")) {
    		locator = ReflectionUtils.getFieldValue(by, "partialLinkText");
    	}
		
		return locator;		
	}
	
	/**
	 * Return the type of locator (Example: id, tagName...) and the locator used to locate the element
	 * @param element - WebElement
	 * @return String - locator of element
	 */
	public static String getFullLocator(WebElement element) {
		String fullLocator = WEB_ELEMENT_WITHOUT_LOCATOR;
		if (element != null) {
			By by = getByLocator(element);
	    	if (by != null) {
	    		fullLocator = by.toString();
	    	} else {
	    		fullLocator = "Element with html: \n" + getOuterHtml(element) + "\n not have a locator defined";
	    	}
		}
		return fullLocator;	
	}
	
	/**
	 * Return the By locator used to locate the element
	 * @param element - WebElement
	 * @return By - By object with the locator of element
	 */
	public static By getByLocator(WebElement element) {
		By by = null;
		if (element != null) {
			LocatingElementHandler locatingElementHandler = ReflectionUtils.getFieldValue(element, "h");
			ElementLocator defaultLocator = ReflectionUtils.getFieldValue(locatingElementHandler, "locator");
	    	by = ReflectionUtils.getFieldValue(defaultLocator, "by");
		}
		return by;
	}

	public static WebElement findStaleElement(WebElement element) {
		WebElement staleElement = null;
		By locator = getByLocator(element);
		if (locator != null) {
			WebDriver driver = WebDriverManager.getDriver();
			
			try {
				sleep();
				staleElement = driver.findElement(locator);
			} catch (Exception e) {
				staleElement = null;
			}
		}
		return staleElement;
	}
	
	public static void sleep() {
		sleep(WAIT_TIME);
	}
	
	public static void sleep(long waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			Logger.println(e.getMessage());
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
	}
	
	public static WebElement getParent(WebElement element) {
		WebElement parent = null;
		if (WebValidation.existInDOM(element) == true) {
			try {
				parent = element.findElement(By.xpath("./.."));	
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					parent = staleElement.findElement(By.xpath("./.."));	
				}
			}
		}
		return parent;
	}
	
	public static boolean clickOn(WebElement element) {
		boolean clickOn = false;
		
		if (WebValidation.isOperable(element) == true) {
			try {
				element.click();
				clickOn = true;
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					staleElement.click();
					clickOn = true;
				}
			}
		}
		
		return clickOn;
	}
	
	public static boolean clearContent(WebElement element) {
		boolean clearContent = false;
		if (WebValidation.isOperable(element) == true) {
			try {
				element.clear();
				clearContent = true;
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					staleElement.clear();
					clearContent = true;
				}
			}
			
		}
		return clearContent;
	}
	
	public static boolean writeOn(WebElement element, String text) {
		boolean writeOn = false;
		
		clearContent(element);
		
		if (WebValidation.isOperable(element) == true) {
			try {
				element.sendKeys(text);
				writeOn = true;
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					staleElement.sendKeys(text);
					writeOn = true;
				}
			}
		}
		
		return writeOn;
	}

	public static String getContent(WebElement element) {
		String content = "";
		
		if (WebValidation.existInDOM(element)) {
			content = getText(element);
			if (content.isEmpty()) {

				WebElement parent = getParent(element);
				if (WebValidation.isNotNull(parent)) {
					content = getText(parent);
				}

			}
			
		}
		
		return content;
	}
	
	public static String getText(WebElement element) {
		String text = "";
		if (WebValidation.existInDOM(element)) {
			try {
				text = element.getText();
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					text = staleElement.getText();
				}
			}
			
			text = text.trim();
			text = text.replaceAll("\n", "");
		}
		return text;
	}
	
	public static String getAttribute(WebElement element, String attribute) {
		String attributeValue = "";
		if (WebValidation.existInDOM(element) == true) {
			try {
				attributeValue = element.getAttribute(attribute);
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = findStaleElement(element);
				if (staleElement != null) {
					attributeValue = staleElement.getAttribute(attribute);
				}
			}
			
			if (attributeValue == null) {
				attributeValue = "";
			}
		}
		return attributeValue;
	}
	
	public static String getOuterHtml(WebElement element) {
		return getAttribute(element, "outerHTML");
	}
	
	public static WebElement searchElement(By locator) {
		WebDriver driver = WebDriverManager.getDriver();
		WebElement child = driver.findElement(locator);
		return child;
	}
	
	public static List<WebElement> searchElements(By locator) {
		WebDriver driver = WebDriverManager.getDriver();
		List<WebElement> childs = driver.findElements(locator);
		return childs;
	}

}