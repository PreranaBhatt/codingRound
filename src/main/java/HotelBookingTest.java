import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

	
    WebDriver driver;
	
    

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")//city
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        
        driver.get("https://www.cleartrip.com/");
        //hotelLink.click();
        driver.findElement(By.linkText("Hotels")).click();
      WebElement ele2= driver.findElement(By.id("Tags"));
        
        Actions act= new Actions(driver);
        act.moveToElement(ele2).perform();
        act.click().perform();
        act.sendKeys("Indiranagar, Bangalore").clickAndHold().sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).build().perform();
        
        
      //  ele.get(1).click();
        WebElement travellerSelection=driver.findElement(By.id("travellersOnhome"));

        /*localityTextBox.sendKeys("Indiranagar, Bangalore");*/
        
        

        new Select(travellerSelection).selectByVisibleText("1 room, 1 adult");
       driver.findElement(By.id("SearchHotelsButton")).click(); 
       
       //   searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
