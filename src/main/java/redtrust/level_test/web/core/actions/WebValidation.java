package redtrust.level_test.web.core.actions;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.github.marcperez06.java_utilities.logger.Logger;

public class WebValidation {

	protected WebValidation() {}

	public static boolean isOperable(WebElement element) {
		boolean isOperable = existInDOM(element);
		if (isOperable) {
			try {
				isOperable &= element.isDisplayed();
				isOperable &= element.isEnabled();
			} catch (StaleElementReferenceException e) {
				WebElement staleElement = WebActions.findStaleElement(element);
				if (staleElement != null) {
					isOperable &= staleElement.isDisplayed();
					isOperable &= staleElement.isEnabled();
				}
			}
		}
		return isOperable;
	}
	
	public static boolean existInDOM(WebElement element) {
		boolean exist = false;
		try {
			if (isNotNull(element)) {
				element.getTagName();
				exist = true;
			}
		} catch (Throwable e) {
			Logger.println("Not exist in DOM: " + e.toString());
			exist = false;
		}
		return exist;
	}

	public static boolean isNotNull(WebElement element) {
		return !isNull(element);
	}
	
	public static boolean isNull(WebElement element) {
		return (element == null);
	}

}