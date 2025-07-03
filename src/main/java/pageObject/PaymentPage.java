package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class PaymentPage extends IgpAbstractComponent {
	
	
	public WebDriver driver;

	// constructor
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".wallet-onlypay.btn.btn-blue.text-center.card-edit-btn.btn-red.revamp-submit-btn")
	WebElement makePaymentCTA;
	
	
	
	public void clickMakePayment()
	{
		makePaymentCTA.click();
	}
	
	
	
	
	

}
