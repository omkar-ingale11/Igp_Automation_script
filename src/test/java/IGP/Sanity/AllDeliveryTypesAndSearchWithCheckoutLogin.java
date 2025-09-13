package IGP.Sanity;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.DeliveryDetailsPage;
import pageObject.MegaMenu;
import pageObject.OrderDetailsPage;
import pageObject.PDPPage;
import pageObject.PLPages;
import pageObject.PaymentPage;
import pageObject.SameDayDeliveryPage;
import pageObject.SearchPage;
import pageObject.SignInPage;
import pageObject.SuccessPage;
import pageObject.SummaryPage;
import testComponent.baseTest;

public class AllDeliveryTypesAndSearchWithCheckoutLogin extends baseTest {

	@Test
	public void allDeliveryTypesSearchAndCheckoutLogin() throws InterruptedException
	{
		IgpAbstractComponent ab = new IgpAbstractComponent(driver);
		
		// action class
		Actions actions = new Actions(driver);
		
		// click on same day delivery tile
		IGPHomePage.clickSameDayDelivery();
		
	//	ab.waitElementForAppear(By.xpath("//img[@title='Floral Delight Cake']"));
		
		// same day delivery page object
		SameDayDeliveryPage sameDay = new SameDayDeliveryPage (driver);
		
		ab.waitElementForAppear(By.xpath("//input[@id='pincode_city_field']"));
		
		// applying pin code
		IGPHomePage.applyPincode("411003");
		
		Thread.sleep(3000);
		
		ab.scrollingDown(); 
		
		// click on first product
		sameDay.clickOnProduct();
		
		// PDP Page Object
		PDPPage pdp = new PDPPage (driver);
		
		ab.scrollingDownmore();
		
		// Selecting Today Date
		pdp.selectTodayDate();
		
		// Standard Delivery
		pdp.selectStdDelivery();
		
		// open time slot drop down
		pdp.openTimeSlotsDD();
		
		ab.waitElementForAppear(By.xpath("//div[@class='timeslotOptions']"));
		
		// open select time slot
		pdp.selectTimeSlot();
		
		Thread.sleep(1000);
		
	//	WebElement flv = driver.findElement(By.cssSelector("div[class='flavour-drop-down']"));
		
	//	actions.moveToElement(flv).perform();
		
		// select flavor
		
		ab.scrollingDown();
		
		Thread.sleep(1000);
		
	//	writing if else condition for selection of flavor
		
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
		
		Thread.sleep(2500);
		
		ab.waitElementForAppear(By.xpath("//button[@title=\"ADD TO CART\"]"));
		
		// skipping add ons
		pdp.continueWithoutAddonsButton();
		
		ab.waitElementForAppear(By.cssSelector("div[class='Heading-3--Bold']"));
		
		// Search page object
		SearchPage searchPage = new SearchPage(driver);
		
		// searching for product
		searchPage.searchBox("HD1139330");
		
		// click on 2nd product
		PLPages plpPage = new PLPages (driver);
		
		// click on first product
		plpPage.select1stPrdct();
		
		ab.scrollingDownmore();
		
		pdp.selectTodayDate();
		
		pdp.clickFixedTimeDelivery();
		
		pdp.openTimeSlotsDD();
		
		ab.scrollingDown();
		
		ab.waitElementForAppear(By.xpath("//div[@class='timeslotOptions']"));
		
		pdp.selectTimeSlot();
		
		pdp.addToCart();
		
		Thread.sleep(2500);
		
		ab.waitElementForAppear(By.xpath("//button[@title=\"ADD TO CART\"]"));
		
		pdp.continueWithoutAddonsButton();
		
		ab.waitElementForAppear(By.cssSelector("div[class='Heading-3--Bold']"));
		
		// searching for product
		searchPage.searchBox("JVS1406967");
		
		plpPage.select2ndprdct();
		
		ab.scrollingDown();
		
		pdp.selectTodayDate();
		
		pdp.clickOnMidnightDelivery();
		
		pdp.addToCart();
		
		Thread.sleep(2500);
		
		ab.waitElementForAppear(By.xpath("//button[@title=\"ADD TO CART\"]"));
		
		pdp.continueWithoutAddonsButton();
		
		pdp.proceedToCheckout();
		
		SignInPage signIn = new SignInPage(driver);

		// entering email id
		signIn.emailId("automation@igp.com");

		// Entering Password
		signIn.password("igp@123");

		// Click on Sign in button
		signIn.signInButton();

		DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage(driver);

		deliveryDetails.clickDeliverHere();

		// Summary page
		SummaryPage summaryPage = new SummaryPage(driver);

		Thread.sleep(2000);
	
		// adding greeting message
		
		summaryPage.addGreetingMessage();
		
		// Scrolling down towards coupon field with help of action class
//		ab.scrollingDownmorextra();

//		WebElement coupon = driver.findElement(By.cssSelector("div[class='select_feeBreakUp_cont select_impression_cont checkout_breakUp_cont ']"));
//		actions.moveToElement(coupon).perform();
		
	//	ab.scrollingDownmorextra();
		
	//	ab.waitElementForAppear(By.cssSelector("span[class='coupon-form-focus Paragraph-12-XS--Semibold']"));
		
		
//		WebElement couponField = driver.findElement(By.xpath("//span[@class='coupon-form-focus Paragraph-12-XS--Semibold']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", couponField);
//		couponField.click();
//		
//		ab.waitElementToBeClickable(By.xpath("//span[@class='coupon-form-focus Paragraph-12-XS--Semibold']"));
//		
//		Thread.sleep(1000);
//		
//		summaryPage.clickOnApplyCTA();
//
//		summaryPage.enterCouponName();
//
//		summaryPage.applyCoupon();
//
//		ab.waitElementForAppear(By.cssSelector("div[class='coupon-band success revamp-coupon-success']"));

		summaryPage.proceedToPaymentCTA();

		// Payment Page
		PaymentPage paymentPage = new PaymentPage(driver);
		
		// click on make payment CTA
		paymentPage.clickMakePayment();

		ab.waitElementForAppear(By.xpath("//div[@class='close-modal']"));

		// Success Page
		SuccessPage successPage = new SuccessPage(driver);
		
		// closing shopping experience widget
		successPage.closemodal();
		
		// asserting success page
		String actualThankYouText = successPage.actualThankYouText();

		String expectedThankYouText = "Thank you for your purchase";

		Assert.assertEquals(actualThankYouText, expectedThankYouText);

		Thread.sleep(3000);
		
		// Track Order Details
		successPage.clickTrackOrderCTA();
		
		// order details page - storing order id
		
		OrderDetailsPage orderDetails = new OrderDetailsPage (driver);
		String orderId = orderDetails.getOrderId();
		System.out.println("Order ID For All Delivery Types Order is " + orderId);

		
    }

	
	
}