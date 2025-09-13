package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class PDPPage extends IgpAbstractComponent{
	
	// Constructor
	
		public WebDriver driver;

	    public PDPPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	    // delivery slot
	    @FindBy (xpath = "//div[@class='timeslotOptions']")
	    WebElement deliverySlot;
	    
	   //  flavor drop down
	    @FindBy(css = "div[class='flavour-drop-down']")
	    WebElement flavorDD;
	    
	    // Select flavor
	    @FindBy (css = "div[data-val='Chocolate']")
	    WebElement selectFlavor;
	    
	    // add to cart button
	    @FindBy (xpath = "//button[@id='add-cart']")
	    WebElement addToCart;
	    
	    // continue without addons
	    @FindBy (xpath = "//button[@id='add-cart']")
	    WebElement continueWithoutAddons;
	    
	    @FindBy (xpath = "//div[@id='enabled-button']")
	    WebElement proceedToCheckout;
	    
	    @FindBy (css = "div[id = 'sel-Next_Day_Delivery']")
		WebElement  internatinalNextDayDelivery;
	    
	    @FindBy (css = "div[id='sel-Standard_Delivery']")
	    List<WebElement> internationalStdDelivery;
	    
	    // select tomorrow date
	    @FindBy (xpath = "//button[@onclick='wholeselectdate(1,false)']")
	    WebElement tomorrowDate;
	    
	 // select today date
	    @FindBy (xpath = "//button[@onclick='wholeselectdate(0,false)']")
	    WebElement todayDate;
	    
	    // standard delivery
	    @FindBy (css = "label[for='Standard']")
	    WebElement standardDelivery;
	    
	    //time slot drop down
	    @FindBy (xpath = "//div[@class='empty-title']//img[@id='drpdown-down-arrow']")
	    WebElement openSlotsDD;
	    
	    // Select time slots
	    @FindBy (xpath = "//div[@class='timeslotOptions']")
	    WebElement selectTimeSlot;
	    
	    // Fixed time delivery
	    @FindBy (css = "div[id='sel-Fixed_Time']")
	    WebElement fixedTimeDelivery;
	    
	    // midnight delivery
	    @FindBy (xpath = "//div[@id='sel-Midnight']")
	    WebElement midnightDelivery;
	    
	    
	    public void selectFlavor()
	    {
	    	flavorDD.click();
	    	selectFlavor.click();
	    }
	    
	    
	    public void addToCart()
	    {
	    	addToCart.click();
	    }
	    
	    public void continueWithoutAddonsButton()
	    {
	    	continueWithoutAddons.click();
	    }
	    
	    
	    public void proceedToCheckout()
	    {
	    	proceedToCheckout.click();
	    }
	    
	    public void internationalProductNextDayDelivery()
	    {
	    	internatinalNextDayDelivery.click();
	    }
	    
	    // select tomorrow date
	    public void selectTomorrowDate()
	    {
	    	tomorrowDate.click();
	    }
	    

	    // select today date
	    public void selectTodayDate()
	    {
	    	todayDate.click();
	    }
	   
	    
	    
	    // Select Standard Delivery
	    public void selectStdDelivery()
	    {
	    	standardDelivery.click();
	    }
	    
	    // Open Time Slots Drop Down
	    public void openTimeSlotsDD()
	    {
	    	openSlotsDD.click();
	    }
	    
	    // select time slot
	    public void selectTimeSlot()
	    {
	    	selectTimeSlot.click();
	    }
	    
	    // click on fixed time delivery
	    public void clickFixedTimeDelivery()
	    {
	    	fixedTimeDelivery.click();
	    }
	    
	    // click on midnight delivery
	    public void clickOnMidnightDelivery()
	    {
	    	midnightDelivery.click();
	    }
	    
	    
	    
	    
	    
	    
	    
}
