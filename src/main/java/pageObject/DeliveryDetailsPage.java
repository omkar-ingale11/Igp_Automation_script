package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class DeliveryDetailsPage extends IgpAbstractComponent{
	
	public WebDriver driver;

	public DeliveryDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//div[@class='deliver-here-link ']")
	WebElement deliverHereCta;
	
	@FindBy (xpath = "(//a[@id='deliver-btn-9113762'])[1]") 
	WebElement australiaDeliverHereCTA;
	
	
	
	public void clickDeliverHere()
	{
		deliverHereCta.click();
	}
	
	public void australiaDeliverHereCTA()
	{
		australiaDeliverHereCTA.click();	
	}
	
}
