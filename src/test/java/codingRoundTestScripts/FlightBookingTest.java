package codingRoundTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import codingRound.Pages.HomePage;
import codingRoundUtility.BrowserInstantiate;
import codingRoundUtility.Common;


public class FlightBookingTest extends BrowserInstantiate{

	WebDriver driver;
	Common compage = null;
	HomePage homePage = null;

	@BeforeTest
	public void LaunchBrowser() {
		driver=BrowserInstantiate.setDriverPath();
		homePage = new HomePage(driver);
		compage= new Common(driver);
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		homePage.clickOneWay();
		homePage.fillDepartureCity("Bangalore");
		homePage.fillArrivalCity("Delhi");
		homePage.clickDeparturedate();

		// all fields filled in. Now click on search
		homePage.clickSearchBtn();
		
	
		Common.waitFor(5000);

		// verify that result appears for the provided journey search
		
		
		Assert.assertTrue(compage.isElementPresent(homePage.getEleSearchSummary()));

		

	}
	
	@AfterTest
	public void tearDown()
	{
		// close the browser
		driver.quit();
	}

}
