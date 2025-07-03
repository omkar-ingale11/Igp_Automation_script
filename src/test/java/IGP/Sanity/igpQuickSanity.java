package IGP.Sanity;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import igpAbstractComponent.IgpAbstractComponent;
import pageObject.DeliveryDetailsPage;
import pageObject.PDPPage;
import pageObject.PaymentPage;
import pageObject.SameDayDeliveryPage;
import pageObject.SearchPage;
import pageObject.SignInPage;
import pageObject.SuccessPage;
import pageObject.SummaryPage;
import testComponent.baseTest;

public class igpQuickSanity extends baseTest {
	
	// generating random email id
	public String getRamndomEmails()
	{
		return "user" + System.currentTimeMillis() + "@" + "igp.com";
	}

	// Generating New Mobile Number every time
	Random random = new Random();
	public String getRandomMobileNo() {
	        
	        // Generate first digit (6 to 9 for valid mobile numbers)
	        int firstDigit = 6 + random.nextInt(4); // 6, 7, 8, 9
	        
	        // Generate remaining 9 digits
	        StringBuilder mobileNumber = new StringBuilder(String.valueOf(firstDigit));
	        for (int i = 0; i < 9; i++) {
	            mobileNumber.append(random.nextInt(10)); // Random digit 0-9
	 }
	        return mobileNumber.toString();
	  }

	
	@Test (enabled = false)
	public void searchTest()
	{
		String prodcut1 = "Roses";
		String product2 = "Cakes";
		// creating abstract component class object
		IgpAbstractComponent ab = new IgpAbstractComponent (driver);
				
		// Creating Search page Object
		SearchPage searchPage = new SearchPage(driver);
		
	    // searching for roses
		searchPage.searchBox(prodcut1);
		
		// saving actual product values
		String roseActualValue = searchPage.roseProduct();
		
		// expected product values
		String roseExpectedValue = prodcut1;
		String cakeExpectedValue = product2;
		
		// checking whether both are matching or not.
		Assert.assertEquals(roseActualValue, roseExpectedValue);
		
		// clicking on home button
		ab.clickOnHome();
		
		// searching another products
		searchPage.searchBox(product2);
		
		// saving actual cakes quantity
		String cakeActualValue = searchPage.cakeProduct();
				
		// checking whether both are matching or not.
		Assert.assertEquals(cakeActualValue, cakeExpectedValue);
		
		// clicking on home button
		ab.clickOnHome();
		
		// click on search
		searchPage.clickOnSearch();
		
		// click on suggestive search - same day delivery
		//ab.waitElementForAppear(By.cssSelector("a[href='/same-day-delivery-gifts']"));
//		searchPage.suggestiveSearch();
//		
//		// Suggestive search assertion
//		String actualTextSuggestiveSearch = searchPage.suggestiveSearchText();
//		String expectedTextSuggestiveSearch = "Same Day Delivery Gifts";
//		Assert.assertEquals(actualTextSuggestiveSearch, expectedTextSuggestiveSearch);
		
		// clicking on home button
//		ab.clickOnHome();
		
		// click on search
		searchPage.clickOnSearch();
		
		// click on trending search
		searchPage.trendingSearchFlowers();
		
		// trending search assertion
		String actualFlowersPageText = searchPage.actualFlowersPageText();
		String expectedFlowersPageText = "Flowers";
		Assert.assertEquals(actualFlowersPageText, expectedFlowersPageText);
		
	}
	
	@Test (enabled = false)
	public void loginViaEmailPassword()
	{
		// Sign In Page Object
		SignInPage signIn = new SignInPage(driver);
		
		//abstract component object
		IgpAbstractComponent ab = new IgpAbstractComponent (driver);
		
		// click on profile icon
		IGPHomePage.clickOnProfile();
		
		// entering email id
		signIn.emailId("omkar.ingale@joinventures.com");
		
		// Entering Password
		signIn.password("123456");
		
		// Click on Sign in button
		signIn.signInButton();
		
		// Asserting Actual email and Expected email
		ab.waitElementForAppear(By.id("user-menu"));
		IGPHomePage.clickOnProfile();
		ab.waitElementForAppear(By.cssSelector("span[class='user-phone']"));
		String actualEmail = IGPHomePage.emailFromProfile();
		Assert.assertEquals(actualEmail, "omkar.ingale@joinventures.com");
		
	}
	
	@Test (enabled = false)
	public void signUp () 
	{

		// Sign In Page Object
		SignInPage signIn = new SignInPage(driver);
		
		//abstract component object
		IgpAbstractComponent ab = new IgpAbstractComponent (driver);
		
		// click on profile icon
		IGPHomePage.clickOnProfile();
		
		// sign up page
		signIn.goToSignupPage();
		
		// enter detail name, email, password, country and mobile no
		signIn.enterName("Omkar Automation");
		
		
		String siunupEmailId = getRamndomEmails();
		signIn.enterEmail(siunupEmailId);
		
		signIn.enterPassword("123456");
		
		signIn.selectCountry();
		
		signIn.enterMobileNo(getRandomMobileNo());
		
		// scrolling down
		ab.scrollingDown();
		
		// waiting for sign up button
		ab.waitElementForAppear(By.cssSelector("button[data-action='signup']"));
		
		//click on sign up
		signIn.clickOnSignup();
		
		// click on Sign up Without Verification
		signIn.clickSignupWithoutVerification();
		
		// Asserting Email
		// Asserting Actual email and Expected email
		ab.waitElementForAppear(By.id("user-menu"));
		IGPHomePage.clickOnProfile();
		ab.waitElementForAppear(By.cssSelector("span[class='user-phone']"));
		String actualEmail = IGPHomePage.emailFromProfile();
		Assert.assertEquals(actualEmail, siunupEmailId);
		
	}
	
	@Test (enabled = false)
	public void googleSignIn()
	{
		// Sign In Page Object
		SignInPage signIn = new SignInPage(driver);
			
		//abstract component object
		IgpAbstractComponent ab = new IgpAbstractComponent(driver);
		
		// click on profile icon
		IGPHomePage.clickOnProfile();
		
		// scrolling Down
		ab.scrollingDown();
		
		// click on google login CTA
		signIn.clickGoogleLogin();
		
		// window handles code for switching windows
		Set <String> windows  =  driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		
		// switching to child window
		driver.switchTo().window(childID);
		
		// enter email
		String googleSignInEmail = "igpautomationsanity@gmail.com";
		signIn.googleEmail(googleSignInEmail);
		
		// click on next button
		signIn.clickNextButton();
		
		// explicitly waiting for password field
		ab.waitElementForAppear(By.xpath("//input[@name='Passwd']"));
		
		// enter password
		String googleSignInPassword = "IgpAutomation@12";
		signIn.googlePassword(googleSignInPassword);
		
		// click on next button
		signIn.clickNextButton();
		
		// switching back to parent
		driver.switchTo().window(parentID);
		
		// Asserting
		ab.waitElementForAppear(By.id("user-menu"));
		IGPHomePage.clickOnProfile();
		ab.waitElementForAppear(By.cssSelector("span[class='user-phone']"));
		String ActualGoogleSignInEmail = IGPHomePage.emailFromProfile();
		Assert.assertEquals(ActualGoogleSignInEmail, googleSignInEmail);
		
	}
	
	@Test (enabled = true)
	public void userJourney () throws InterruptedException
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
		
	//	IGPHomePage.clickSameDayDelivery();

		IgpAbstractComponent ab = new IgpAbstractComponent(driver);
		
	//	ab.waitElementForAppear(By.cssSelector(".changeCountry_content"));
		
		//IGPHomePage.openLocationModule();
		
		//IGPHomePage.applyPincode("400059");
		
	//	ab.waitElementForAppear(By.xpath("//a[@class='tile-8 sdd']"));
		
		IGPHomePage.clickSameDayDelivery();
		
		ab.waitElementForAppear(By.xpath("//img[@title='Floral Delight Cake']"));
		
		SameDayDeliveryPage sameDay = new SameDayDeliveryPage (driver);
		
		ab.waitElementForAppear(By.xpath("//input[@id='pincode_city_field']"));
		
		IGPHomePage.applyPincode("400059");
		
		//ab.waitElementForAppear(By.xpath("//img[@title='Floral Delight Cake']"));
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//img[@title='Floral Delight Cake']")).click();
		
		
		ab.scrollingDown();
		
		sameDay.clickOnProduct();
		
		PDPPage pdp = new PDPPage (driver);
				
		ab.scrollingDownmore();
		
		pdp.selectFlavor();
		
		pdp.addToCart();
		
		Thread.sleep(2000);
		
		ab.waitElementForAppear(By.xpath("//button[@title=\"ADD TO CART\"]"));
		
		pdp.continueWithoutAddonsButton();
				
		pdp.proceedToCheckout();
		
		DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage (driver);
		
		deliveryDetails.clickDeliverHere();
		
		// Summary page
		
		SummaryPage summaryPage = new SummaryPage (driver);
		
		summaryPage.clickOnApplyCTA();
		
		summaryPage.enterCouponName();
		
		summaryPage.applyCoupon();
		
		ab.waitElementForAppear(By.cssSelector("div[class='coupon-band success revamp-coupon-success']"));
		
		summaryPage.proceedToPaymentCTA();
		
		// Payment Page
		
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
