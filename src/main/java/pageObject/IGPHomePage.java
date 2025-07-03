package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class IGPHomePage extends IgpAbstractComponent {

	public WebDriver driver;
	
	//Constructor
	public IGPHomePage (WebDriver driver)
	{
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// profile icon
	@FindBy (id = "user-menu")
	WebElement profile;
	
	// extracting email id from profile
	@FindBy (xpath = "//span[@class='user-phone']")
	WebElement profileEmail;
	
	// same day delivery tile
	@FindBy (xpath = "//a[@data-item-name=\"Same Day Delivery\"]")
	WebElement sameDayDelivery;
	
	// open location module
	@FindBy (css = ".changeCountry_content")
	WebElement locationModule;
	
	// Global Location pincode
	@FindBy (id = "pincode_city_field")
	WebElement  pincodeField;
	
	// global locaion apply button
	@FindBy (xpath = "//button[normalize-space()='Apply']")
	WebElement applyButton;
	
	@FindBy (css = "div[class='tr-overlay global-location']")
	WebElement openCountryDD;
	
	@FindBy (xpath ="//div[@id='countrySelectionModal']//li[3]")
	WebElement australiaCountry;
	
	
	
	
	
	// visiting IGP web site
	public void visitIGP () 
	{
		driver.get("https://www.igp.com/");
	}
	
	// click on Profile
	public void clickOnProfile()
	{
		profile.click();
	}
	
	// extracting email id from profile
	public String emailFromProfile()
	{
		profileEmail.getText();
		return profileEmail.getText();
	}
	
	// click on same day delivery
	public void clickSameDayDelivery()
	{
		sameDayDelivery.click();
	}
	
	
	//open location module
	public void openLocationModule()
	{
		locationModule.click();
	}
	
	// enter pincode
	public void applyPincode(String pincode)
	{
		pincodeField.sendKeys(pincode);
		// click on apply button
		applyButton.click();
	}
	
	// Country DD
	public void openCouuntryDD()
	{
		openCountryDD.click();
	}
	
	// Select USA Country 
	public void australiaCountry()
	{
		australiaCountry.click();
	}
	
	// location apply button
	public void applyLocation()
	{
		applyButton.click();
	}
	
	
}
