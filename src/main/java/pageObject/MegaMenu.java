package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class MegaMenu extends IgpAbstractComponent{
	
	public WebDriver driver;

    public MegaMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
    }
	
    @FindBy (css = "a[href='/same-day-delivery-gifts']")
    WebElement sameDayDelivery;
    
    
    
    public void clickSameDayDelivery() 
    {
    	sameDayDelivery.click();
    }
    
    
    
}
