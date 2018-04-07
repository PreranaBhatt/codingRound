package codingRound.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codingRoundUtility.BrowserInstantiate;
import codingRoundUtility.Common;

public class HomePage {

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		} 
	
	
	@FindBy(id="OneWay")
	private WebElement eleOneway;
	
	@FindBy(id="FromTag")
	private WebElement eleDepartureCity;
	
	@FindBy(id="ToTag")
	private WebElement eleArivalCity;
	
	@FindBy(id="DepartDate")
	private WebElement eleDeparturedate;
	
	@FindBy(id="SearchBtn")
	private WebElement eleSearchBtn;
	
	@FindBy(className="searchSummary")
	private WebElement eleSearchsummary;
	
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;
	
	@FindBy(linkText="Your trips")
	private WebElement eleYourTrips;
	
	
	public void clickOneWay()
	{
		eleOneway.click();
	}
	
	public void fillDepartureCity(String departureCity)
	{
		eleDepartureCity.clear();
		eleDepartureCity.sendKeys(departureCity);
		Common.waitFor(3000);
		List<WebElement> originOptions = BrowserInstantiate.driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
	}
	
	public void fillArrivalCity(String ArrivalCity)
	{
		eleArivalCity.clear();
		eleArivalCity.sendKeys(ArrivalCity);
		Common.waitFor(2000);
		List<WebElement> destinationOptions = BrowserInstantiate.driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
	}
	
	public void clickDeparturedate()
	{
		eleDeparturedate.click();
		BrowserInstantiate.driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
	}
	
	public WebElement getEleSearchSummary()
	{
		return eleSearchsummary;
	}
	
	public void clickSearchBtn()
	{
		eleSearchBtn.click();
	}
	
	public void clikHotelLink()
	{
		hotelLink.click();
	}
	
	public void  clickYourTripLink()
	{
		eleYourTrips.click();
	}
}
