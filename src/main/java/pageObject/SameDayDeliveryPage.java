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
    @FindBy (xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [1]")
    WebElement sameDayFirstProduct;

    // flower product, 2nd product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [1]")
    WebElement flowerProduct2ndPrdct;
    
    // flower product, 2nd product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [2]")
    WebElement ThirdPrdct;
    
    // Sort drop down
    @FindBy (xpath = "//div[@class='c-dd sort-by pull-right w185 igp-revamp-sort ']")
    WebElement sortFilterDD;
   
    // low to high option selection
    
    @FindBy (xpath = "//li[@data-value='mrp_asc']")
    WebElement lowToHigh;
    
    // low to high option selection
    
    @FindBy (xpath = "//li[@data-value='mrp_desc']")
    WebElement highToLow;
    
    // latest first
    @FindBy (xpath = "//li[@data-value='created_desc']")
    WebElement latestFirst;
    
    // clicking on product
    public void clickOnProduct()
    {
    	sameDayFirstProduct.click();
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
     
    public void sortFilterDD()
    {
    	sortFilterDD.click();
    }
    
    public void lowToHigh()
    {
    	lowToHigh.click();
    }
    
    public void highToLow()
    {
    	highToLow.click();
    }
    
    public void latestFirst()
    {
    	latestFirst.click();
    }
    
}
