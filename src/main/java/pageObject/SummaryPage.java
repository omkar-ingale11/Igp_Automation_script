package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class SummaryPage extends IgpAbstractComponent{
	
	public WebDriver driver;

	// constructor
	public SummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css = "span[class = 'coupon-form-focus Paragraph-12-XS--Semibold']")
	WebElement  couponApply;
	
	@FindBy (id = "coupon")
	WebElement couponName;
	
	@FindBy (xpath = "//button[normalize-space()='Apply']")
	WebElement applyCTA;
	
	@FindBy (xpath = "//div[@class='payment-button-container']")
	WebElement proceedToPaymentCTA;
	
	
	
	
	
	public void clickOnApplyCTA()
	{
	couponApply.click();
	}
	
	
	public void enterCouponName()
	{
		couponName.sendKeys("praksigp");
	}
	
	public void applyCoupon()
	{
		applyCTA.click();
	}
	
	
	public void proceedToPaymentCTA()
	{
		proceedToPaymentCTA.click();
	}
	

}
