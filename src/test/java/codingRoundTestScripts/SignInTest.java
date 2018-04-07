package codingRoundTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import codingRound.Pages.HomePage;
import codingRound.Pages.LogInPage;
import codingRoundUtility.BrowserInstantiate;
import codingRoundUtility.Common;

public class SignInTest {

	WebDriver driver;
	HomePage homePage = null;
	LogInPage loginPage = null;

	@BeforeTest
	public void LaunchBrowser() {
		driver=BrowserInstantiate.setDriverPath();
		homePage = new HomePage(driver);
		loginPage = new LogInPage(driver);
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {

		homePage.clickYourTripLink();
		loginPage.clickSignInBtn();
		loginPage.clickDialogueBoxSignInBtn();
		loginPage.clickClosebtn();

	}

	@AfterTest

	public void tearDown() {
		// close the browser
		driver.quit();
	}

}
