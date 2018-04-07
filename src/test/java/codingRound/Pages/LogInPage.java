package codingRound.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codingRoundUtility.Common;

public class LogInPage {

	WebDriver driver;
	public LogInPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(id="SignIn")
	private WebElement eleSignIn;
	
	@FindBy(xpath="//div[@id='ModalFrame']//iframe[@id='modal_window']")
	private WebElement eleframe;
	
	@FindBy(xpath="//button[@id='signInButton']")
	private WebElement elePopupSignInbtn;
	
	@FindBy(id="errors1")
	private WebElement eleErrorMsg;
	
	@FindBy(xpath="//a[@id='close']")
	private WebElement elePopupCloseBtn;
	
	
	
	
	
	
	public void clickSignInBtn()
	{
		eleSignIn.click();
	}
	
	public void clickDialogueBoxSignInBtn() throws InterruptedException
	{
		driver.switchTo().frame(eleframe);
		Common.waitFor(2000);
		elePopupSignInbtn.click();
		driver.switchTo().defaultContent();
	}
	
	
	public void clickClosebtn()
	{		
		elePopupCloseBtn.click();
	}
}
