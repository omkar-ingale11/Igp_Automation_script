package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class OrderDetailsPage extends IgpAbstractComponent {

	public WebDriver driver;

	// constructor
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css = "[class='orderid Paragraph-16-M--Semibold']")
	WebElement getOrderID;
	
	
	public String getOrderId()
	{
		getOrderID.getText();
		return getOrderID.getText();
	}
	
	
	
	
}
