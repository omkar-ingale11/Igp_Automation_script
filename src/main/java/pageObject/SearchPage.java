package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class SearchPage extends IgpAbstractComponent {

	public WebDriver driver;

	// constructor
	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// search box
	@FindBy(css = "input[name='q']")
	WebElement searchBox;

	// click on search
	@FindBy(css = "img[alt='Search for IGP Gifts']")
	WebElement searchCTA;

	// Search Product Quantity
	@FindBy(css = "h1[itemprop='name']")
	WebElement roseProduct;

	@FindBy(css = "h1[itemprop='name']")
	WebElement cakeProduct;
	

	// click on searchBox
	@FindBy(css = "input[name='q']")
	WebElement search;

	// click on suggestive search - same day delivery
	@FindBy(css = "a[href='/same-day-delivery-gifts']")
	WebElement SuggestiveSearch;

	// grabbing text of suggestive search
	@FindBy(css = "h1[itemprop='name']")
	WebElement suggestiveSeachText;

	// trending search
	@FindBy(css = "a[data-trendingsearch='flowers']")
	WebElement trendingSearchFlowers;

	// flowers text
	@FindBy(css = "h1[itemprop='name']")
	WebElement actualFlowersPageText;
	
	
	
	
	
	
	

	public void searchBox(String productName) {
		searchBox.sendKeys(productName);
		searchCTA.click();
	}

	// getting rose product value for assertion
	public String roseProduct() {
		roseProduct.getText();
		return roseProduct.getText();
	}

	// getting cake value for assertion
	public String cakeProduct() {
		cakeProduct.getText();
		return cakeProduct.getText();
	}

	// clicking on search
	public void clickOnSearch() {
		search.click();
	}

	// clicking on suggestive search
	public void suggestiveSearch() {
		SuggestiveSearch.click();
	}

	// suggestive search Text
	public String suggestiveSearchText() {
		suggestiveSeachText.getText();
		return suggestiveSeachText.getText();
	}

	// clicking on trending search flowers
	public void trendingSearchFlowers() {
		trendingSearchFlowers.click();
	}

	// grabbing text for assertions
	public String actualFlowersPageText() {
		actualFlowersPageText.getText();
		return actualFlowersPageText.getText();
	}

}
