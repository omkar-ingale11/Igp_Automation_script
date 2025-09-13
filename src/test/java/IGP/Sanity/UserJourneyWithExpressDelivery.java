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
import pageObject.PaymentPage;
import pageObject.SameDayDeliveryPage;
import pageObject.SignInPage;
import pageObject.SuccessPage;
import pageObject.SummaryPage;
import testComponent.baseTest;

public class UserJourneyWithExpressDelivery extends baseTest{
	
	@Test (enabled = true)
	public void userJourneyAndExpressDelivery () throws InterruptedException
	{
		// Sign In Page Object
		SignInPage signIn = new SignInPage(driver);
		
		// click on profile icon
		IGPHomePage.clickOnProfile();
		
		// entering email id
		signIn.emailId("omkar45@igp.com");
		
		// Entering Password
		signIn.password("123456");
		
		// Click on Sign in button
		signIn.signInButton();		

		IgpAbstractComponent ab = new IgpAbstractComponent(driver);
		
//		IGPHomePage.clickSameDayDelivery();
		IGPHomePage.clickSameDayDelivery();
		
		//ab.waitElementForAppear(By.xpath("//img[@title='Floral Delight Cake']"));
		
		SameDayDeliveryPage sameDay = new SameDayDeliveryPage (driver);
		
		ab.waitElementForAppear(By.xpath("//input[@id='pincode_city_field']"));
		
		// applying pin code
		IGPHomePage.applyPincode("400059");
		
		Thread.sleep(3000);
		
		ab.scrollingDown();
		
		// clicking on product
		sameDay.clickOnProduct();
			
		PDPPage pdp = new PDPPage (driver);
				
		ab.scrollingDownmore();
		
		ab.scrollingDown();
		
		List<WebElement> expressDelivery = driver.findElements(By.xpath("//img[@alt='igp now']"));
		if (expressDelivery.size() > 0 && expressDelivery.get(0).isDisplayed())
		{	
			System.out.println("Express delivery is avalibale");
		}
		else 
		{
			pdp.openTimeSlotsDD();
			ab.scrollingDown();
			Thread.sleep(1000);
			ab.waitElementForAppear(By.xpath("//div[@class='timeslotOptions']"));
			pdp.selectTimeSlot();
			Thread.sleep(1000);
		//	ab.scrollingDown();
			System.out.println("Express delivery is not available, Selecting Standard Delivery type");
		}
		
		//ab.waitElementToBeClickable(By.cssSelector("div[class='flavour-drop-down']"));
		// selecting flavor
		List <WebElement> flavourSelect = driver.findElements(By.cssSelector("div[class='flavour-drop-down']"));
		
		List <WebElement> flavourPreselected = driver.findElements(By.cssSelector("div[class='flavour-drop-down-container rebrand-attribute-dropdown flavour-selected flavour-preselected']"));
		
		if (flavourSelect.size() > 0 && flavourSelect.get(0).isDisplayed())
		{
			if (flavourPreselected.size() > 0 && flavourPreselected.get(0).isDisplayed())
			{
				System.out.println("Flavour is preselected");
			}
			
			else
			{
				ab.waitElementToBeClickable(By.cssSelector("div[class='flavour-drop-down']"));
				pdp.selectFlavor();
			}
			
		}
		
		else
		{
			System.out.println("flavour selection DD is not present");
		}
		
		// adding into cart
		pdp.addToCart();
		
		Thread.sleep(2000);
		
		ab.waitElementForAppear(By.xpath("//button[@title=\"ADD TO CART\"]"));
		
		// continue without add on
		pdp.continueWithoutAddonsButton();
		
		// click on proceed to checkout
		pdp.proceedToCheckout();
		
		DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage (driver);
		
		// selecting address
		deliveryDetails.clickDeliverHere();
		
		// Summary page
		
		SummaryPage summaryPage = new SummaryPage (driver);
		
		// applying coupon code
		summaryPage.clickOnApplyCTA();
		
		summaryPage.enterCouponName();
		
		summaryPage.applyCoupon();
		
		ab.waitElementForAppear(By.cssSelector("div[class='coupon-band success revamp-coupon-success']"));
		
		// adding greeting message
		
		summaryPage.addGreetingMessage();
		
		// click on proceed to payment
		summaryPage.proceedToPaymentCTA();
		
		// Payment Page
		
		PaymentPage paymentPage = new PaymentPage (driver);
		
		// click on make payment CTA
		paymentPage.clickMakePayment();
		
		ab.waitElementForAppear(By.xpath("//div[@class='close-modal']"));
		
		// Success Page
		
		SuccessPage successPage = new SuccessPage (driver);
		
		// closing shopping experience widget
		successPage.closemodal();		
		
		// asserting success message text
		String actualThankYouText = successPage.actualThankYouText();
		
		String expectedThankYouText = "Thank you for your purchase";
		
		Assert.assertEquals(actualThankYouText, expectedThankYouText);
		
		Thread.sleep(3000);
		
		// click on Track order CTA 
		successPage.clickTrackOrderCTA();
		
		// order details page - storing order id
		
		OrderDetailsPage orderDetails = new OrderDetailsPage (driver);
		String orderId = orderDetails.getOrderId();
		System.out.println("Order ID For Express Deliver Product is " + orderId);

			
		
	}
	
	
	
	
	
}
