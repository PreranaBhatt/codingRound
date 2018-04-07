package codingRoundTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import codingRound.Pages.HomePage;
import codingRound.Pages.HotelPage;
import codingRoundUtility.BrowserInstantiate;
import codingRoundUtility.Common;

public class HotelBookingTest extends BrowserInstantiate{

	WebDriver driver;
	HomePage homePage = null;
	HotelPage hotelPage = null;

	@BeforeTest
	public void LaunchBrowser() {
		driver=BrowserInstantiate.setDriverPath();
		homePage = new HomePage(driver);
		hotelPage = new HotelPage(driver);
	}

	@Test
	public void shouldBeAbleToSearchForHotels() {

		homePage.clikHotelLink();
		hotelPage.fillLocation();
		hotelPage.fillTravellersInfo();
		hotelPage.ClickSearchbtn();

	}

	@AfterTest

	public void tearDown() {
		// close the browser
		driver.quit();
	}

}
