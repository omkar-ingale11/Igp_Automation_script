package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class SameDayDeliveryPage extends IgpAbstractComponent {
	
	// Constructor
	
	public WebDriver driver;

    public SameDayDeliveryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    // cake product
    @FindBy (xpath = "//img[@title='Floral Delight Cake']")
    WebElement cakeProduct;

    // flower product, 2nd product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [1]")
    WebElement flowerProduct2ndPrdct;
    
    //// flower product, 2nd product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [2]")
    WebElement ThirdPrdct;
   
    
    // clicking on product
    public void clickOnProduct()
    {
    	cakeProduct.click();
    }
    
    // clicking on product
    public void clickOn2ndPrdct()
    {
    	flowerProduct2ndPrdct.click();
    }
    
    public void clickOn3rdProduct()
    {
    	ThirdPrdct.click();
    }
     
    
    
    
    
}
