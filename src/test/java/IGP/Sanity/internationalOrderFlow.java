package IGP.Sanity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.DeliveryDetailsPage;
import pageObject.OrderDetailsPage;
import pageObject.PDPPage;
import pageObject.PLPages;
import pageObject.PaymentPage;
import pageObject.SameDayDeliveryPage;
import pageObject.SignInPage;
import pageObject.SuccessPage;
import pageObject.SummaryPage;
import testComponent.baseTest;

public class internationalOrderFlow extends baseTest {

	@Test
	public void internationalOrder() throws InterruptedException
	{
		
		SignInPage signIn = new SignInPage(driver);
		
		// click on profile icon
		IGPHomePage.clickOnProfile();
		
		// entering email id
		signIn.emailId("omkar45@igp.com");
		
		// Entering Password
		signIn.password("123456");
		
		// Click on Sign in button
		signIn.signInButton();		
		
		IGPHomePage.clickSameDayDelivery();
		
		IgpAbstractComponent ab = new IgpAbstractComponent (driver);
		
		ab.waitElementForAppear(By.xpath("//input[@id='pincode_city_field']"));
		
		IGPHomePage.openCouuntryDD();
		
		IGPHomePage.australiaCountry();
		
		IGPHomePage.applyLocation();
		
		PDPPage pdpPage = new PDPPage (driver);
		
		PLPages plpPage = new PLPages (driver);
		
		Thread.sleep(1500);
		
		ab.scrollingDown();
		
		plpPage.australiaProduct();
		
		ab.scrollingDown();
		
		// web element for next day delivery slot
		List<WebElement> nextDayDeliveryList  = driver.findElements(By.cssSelector("div[id = 'sel-Next_Day_Delivery']"));
		
		List<WebElement> freeShipping  = driver.findElements(By.cssSelector("div[id='sel-Free_Shipping']"));
		
		if (nextDayDeliveryList.size() > 0 && nextDayDeliveryList.get(0).isDisplayed()) {
		    nextDayDeliveryList.get(0).click();
		}
		else if (freeShipping.size() > 0 && freeShipping.get(0).isDisplayed()) {
			freeShipping.get(0).click();
			driver.findElement(By.xpath("//input[@id='std-datepicker']")).click();
			driver.findElement(By.cssSelector("a[title='Next']")).click();
			ab.waitElementForAppear(By.xpath("//td[not(contains(@class,'ui-datepicker-unselectable'))]//a[@class='ui-state-default']"));
			Thread.sleep(1000);
			ab.scrollingUp();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-unselectable'))]//a[@class='ui-state-default']")).click();
			
//			ab.waitElementForAppear(By.cssSelector("td[class=\" ui-datepicker-days-cell-over undefined ui-datepicker-current-day\"]"));
//			Thread.sleep(1000);
//			driver.findElement(By.cssSelector("td[class=\" ui-datepicker-days-cell-over undefined ui-datepicker-current-day\"]")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='std-datepicker']")).click();
			driver.findElement(By.cssSelector("a[title='Next']")).click();
			ab.waitElementForAppear(By.xpath("//td[not(contains(@class,'ui-datepicker-unselectable'))]//a[@class='ui-state-default']"));
			Thread.sleep(1000);
			ab.scrollingUp();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-unselectable'))]//a[@class='ui-state-default']")).click();
			
		}
		
		pdpPage.addToCart();
		
		Thread.sleep(2500);
		
		List<WebElement> continueWithoutAddons  = driver.findElements(By.cssSelector("button[id='add-cart']"));
		
		if (continueWithoutAddons.size() > 0 && continueWithoutAddons.get(0).isDisplayed())
		{
			driver.findElement(By.cssSelector("button[id='add-cart']")).click();
		}
		else 
		{
			System.out.println("addons not appeared");
		}
		
		
		pdpPage.proceedToCheckout();
		
		DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage (driver);
		
		deliveryDetails.australiaDeliverHereCTA();
		
		SummaryPage summaryPage = new SummaryPage (driver);
		
		Thread.sleep(1000);
		summaryPage.addGreetingMessage();
		
		Thread.sleep(1000);
		summaryPage.clickOnApplyCTA();
		
		summaryPage.enterCouponName();
		
		summaryPage.applyCoupon();
		
		ab.waitElementForAppear(By.cssSelector("div[class='coupon-band success revamp-coupon-success']"));
		
		summaryPage.proceedToPaymentCTA();
		
		// payment Page
		
		PaymentPage paymentPage = new PaymentPage (driver);
		
		paymentPage.clickMakePayment();
		
		ab.waitElementForAppear(By.xpath("//div[@class='close-modal']"));
		
		// Success Page
		
		SuccessPage successPage = new SuccessPage (driver);
		
		successPage.closemodal();		
		
		String actualThankYouText = successPage.actualThankYouText();
			
		String expectedThankYouText = "Thank you for your purchase123";
		
		Assert.assertEquals(actualThankYouText, expectedThankYouText);
		
		Thread.sleep(3000);
		
		successPage.clickTrackOrderCTA();
			
		// order details page - storing order id
		
		OrderDetailsPage orderDetails = new OrderDetailsPage (driver);
		String orderId = orderDetails.getOrderId();
		System.out.println("Order ID For International Order is " + orderId);
		
	}




}
