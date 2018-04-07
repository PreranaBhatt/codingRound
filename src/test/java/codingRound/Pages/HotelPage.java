package codingRound.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPage {

	WebDriver driver;

	public HotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	public void fillLocation() {
		Actions act = new Actions(driver);
		act.moveToElement(localityTextBox).perform();
		act.click().perform();
		act.sendKeys("Indiranagar, Bangalore").clickAndHold().sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).build()
				.perform();

	}

	public void fillTravellersInfo() {
		new Select(travellerSelection).selectByVisibleText("1 room, 1 adult");
	}

	public void ClickSearchbtn() {
		searchButton.click();
	}
}
