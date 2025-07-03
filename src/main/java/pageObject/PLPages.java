package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class PLPages extends IgpAbstractComponent{
	
	public WebDriver driver;

    public PLPages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	
	@FindBy (css ="img[title='Two Dozen Chocolate Roses Bouquet']")
	WebElement australiaProduct;
	

	// flower product, 2nd product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [1]")
    WebElement roseProduct2ndPrdct;
    
    //// flower product, 1st product on PLP
    @FindBy(xpath = "//div[@class='product-grid-item product-grid-item-revamp col s3'] [1]")
    WebElement flowerProduct3rdprdct;
    
	
	public void australiaProduct()
	{
		australiaProduct.click();
	}
	
	// 1st product
	public void select1stPrdct()
	{
		roseProduct2ndPrdct.click();
	}
	
	
	// 2rd prdct
	public void select2ndprdct()
	{
		flowerProduct3rdprdct.click();
	}
	
	
	
	
	

}
