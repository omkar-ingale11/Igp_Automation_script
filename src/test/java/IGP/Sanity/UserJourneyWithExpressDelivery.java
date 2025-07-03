package IGP.Sanity;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.DeliveryDetailsPage;
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
		
		ab.waitElementForAppear(By.xpath("//img[@title='Floral Delight Cake']"));
		
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
		
		// selecting flavor
		pdp.selectFlavor();
		
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
		
		
			
		
	}
	
	
	
	
	
}
