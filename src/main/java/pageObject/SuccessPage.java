package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class SuccessPage extends IgpAbstractComponent{
	
	public WebDriver driver;

	// constructor
	public SuccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='close-modal']")
	WebElement closemodal;
	
	
	@FindBy (xpath = "//span[@class='thank-you-text Heading-3--Bold']")
	WebElement actualThankYouText;
	
	// Track order CTA
	@FindBy(partialLinkText = "TRACK ORDER")
	WebElement trcakOrder;
	
	
	

	
	
	public void closemodal()
	{
		closemodal.click();
	}
	
	
	public String actualThankYouText()
	{
		actualThankYouText.getText();
		return actualThankYouText.getText();
	}
	
	// CLick on Track Order CTA
	public void clickTrackOrderCTA() 
	{
		trcakOrder.click();
	}
	
	
	

}
