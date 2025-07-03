package IGP.Sanity;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.DeliveryDetailsPage;
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
		
		pdpPage.internationalProductNextDayDelivery();
		
		pdpPage.addToCart();
		
		pdpPage.proceedToCheckout();
		
		DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage (driver);
		
		deliveryDetails.australiaDeliverHereCTA();
		
		SummaryPage summaryPage = new SummaryPage (driver);
		
//		summaryPage.clickOnApplyCTA();
//		
//		summaryPage.enterCouponName();
//		
//		summaryPage.applyCoupon();
//		
//		ab.waitElementForAppear(By.cssSelector("div[class='coupon-band success revamp-coupon-success']"));
		
		summaryPage.proceedToPaymentCTA();
		
		// payment Page
		
		PaymentPage paymentPage = new PaymentPage (driver);
		
		paymentPage.clickMakePayment();
		
		ab.waitElementForAppear(By.xpath("//div[@class='close-modal']"));
		
		// Success Page
		
		SuccessPage successPage = new SuccessPage (driver);
		
		successPage.closemodal();		
		
		String actualThankYouText = successPage.actualThankYouText();
		
		String expectedThankYouText = "Thank you for your purchase";
		
		Assert.assertEquals(actualThankYouText, expectedThankYouText);
		
		Thread.sleep(3000);
		
		successPage.clickTrackOrderCTA();
			
		
	}




}
