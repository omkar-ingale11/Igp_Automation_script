package IGP.Sanity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.SameDayDeliveryPage;
import testComponent.baseTest;

public class SortAndQuickFilters extends baseTest{

	@Test
	public void sortFilterLowToHigh () throws InterruptedException
	
	{
	//	IGPHomePage homePage = new IGPHomePage (driver);
		IGPHomePage.clickSameDayDelivery();
		
		SameDayDeliveryPage sdd = new SameDayDeliveryPage (driver);
		IgpAbstractComponent ab = new IgpAbstractComponent(driver);
		
		ab.waitElementForAppear(By.xpath("//input[@id='pincode_city_field']"));
		
		IGPHomePage.applyPincode("400059");
		
		Thread.sleep(2000);
		
		sdd.sortFilterDD();
		
		ab.waitElementToBeClickable(By.xpath("//li[@data-value=\"mrp_asc\"]"));
		
		sdd.lowToHigh();
	
		ab.scrollingDown();
		
		List<WebElement> priceElements = driver.findElements(By.cssSelector("span[class='Paragraph-16-M--Semibold']"));
		
		List<Double> actualPrices = new ArrayList<>();
		for (WebElement priceElement : priceElements) {
		    String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
		    System.out.println(priceText);
		    if (!priceText.isEmpty()) {
                actualPrices.add(Double.parseDouble(priceText));
            }
		}
		
		List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);
		
        Assert.assertEquals(actualPrices, sortedPrices, "Products are NOT sorted from Low to High!");

        System.out.println("✅ Prices are sorted from Low to High!");
			
		
        // High To Low
        
        ab.clickOnHome();
        
        IGPHomePage.clickSameDayDelivery();
        
        Thread.sleep(2000);
        
        sdd.sortFilterDD();
        
        sdd.highToLow();
        
        ab.scrollingDown();
        
        List<WebElement> H2LpriceElements = driver.findElements(By.cssSelector("span[class='Paragraph-16-M--Semibold']"));
		
		List<Double> H2LactualPrices = new ArrayList<>();
		for (WebElement priceElement : H2LpriceElements) {
		    String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
		    System.out.println(priceText);
		    if (!priceText.isEmpty()) {
                H2LactualPrices.add(Double.parseDouble(priceText));
            }
		}
		
		List<Double> H2LsortedPrices1 = new ArrayList<>(H2LactualPrices);
		  H2LsortedPrices1.sort(Collections.reverseOrder());
		  
		  Assert.assertEquals(H2LactualPrices, H2LsortedPrices1, "Products are NOT sorted from High to Low!");

	        System.out.println("✅ Prices are sorted from High TO Low!");
        
	        
	     // Latest First
	        
	        ab.clickOnHome();
	        
	        IGPHomePage.clickSameDayDelivery();
	        
	        Thread.sleep(2000);
	        
	        sdd.sortFilterDD();
	        
	        sdd.latestFirst();
	        
	        ab.scrollingDown();
	        
	        ab.scrollingDown();
	    	
			List<WebElement> LFpriceElements = driver.findElements(By.cssSelector("span[class='Paragraph-16-M--Semibold']"));
			
			List<Double> LfActualPrices = new ArrayList<>();
			for (WebElement priceElement : LFpriceElements) {
			    String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
			    System.out.println(priceText);
			}
		          
			
			
			
	}
	
	

}
	
		

