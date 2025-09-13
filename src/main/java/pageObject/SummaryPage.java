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
	
	@FindBy (css = "span[class='Paragraph-14-S--Regular']")
	WebElement greetingMessage1;
	
	@FindBy (css = ".save-preview-button.Paragraph-12-XS--Semibold.caps")
	WebElement saveAndPreviewCTA;
	
	@FindBy (css = ".greeting-card-preview-overlay-close")
	WebElement greetingPopUpclose;
	
	
	
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
	
	public void addGreetingMessage()
	{
		greetingMessage1.click();
	}
	
	
	public void clickSaveAndPreviewCTA()
	{
		saveAndPreviewCTA.click();
	}
	

	public void closeGreetingPopUp()
	{
		greetingPopUpclose.click();
	}
	
	
}
