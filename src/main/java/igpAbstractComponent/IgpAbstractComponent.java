package igpAbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IgpAbstractComponent {

	
	public WebDriver driver;
	
	// Constructor
	public IgpAbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// IGP Home Icon
	@FindBy (xpath= "//img[@class='img-responsive logo']")
	WebElement igpHomeBUtton;
	
	// Mega menu
	@FindBy (css = "img[alt='hamburger img']")
	WebElement megaMenu;
	
	
	
	// Clicking on home
	public void clickOnHome()
	{
		igpHomeBUtton.click();
	}
	
	// open mega menu
	public void openMegaMenu()
	{
		megaMenu.click();
	}
	
	// scrolling down
	public void scrollingDown()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
	}

	// scrolling down
	public void scrollingDown1()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	}	
	
	// scrolling Up
	public void scrollingUp()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-150)");
	}
	
	// explicitly wait for the element
	public void waitElementForAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitElementToBeClickable (By findBy)
	{
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void scrollingDownmore()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	}
	
	public void scrollingDownmorextra()
	{
	JavascriptExecutor js =  (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	}
}
