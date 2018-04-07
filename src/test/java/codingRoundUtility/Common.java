package codingRoundUtility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Common {

	 

	public Common(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	public boolean isElementPresent(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
}
