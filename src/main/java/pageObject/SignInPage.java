package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import igpAbstractComponent.IgpAbstractComponent;

public class SignInPage extends IgpAbstractComponent{
	
	public WebDriver driver;

    public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    // sign in field
    @FindBy (id = "otp-email")
    WebElement emailField;	
    
    // click on next button
    @FindBy (id = "row-otp-login-submit")
    WebElement nextButton;
    
    // go for login via password
    @FindBy (id = "backo-login-fpass")
    WebElement loginViaPass;
    
    // password field
    @FindBy (id = "passwd")
    WebElement passwordField;
    
    // sign in button 
    @FindBy (xpath = "//button[@data-action='login']")
    WebElement signInButton;
    
    // sign up link
    @FindBy (id = "goto-signup")
    WebElement signUp;
    
    // Sign up name
    @FindBy (id = "cname")
    WebElement nameFieldSignup;
    
    // email field sign up
    @FindBy (xpath = "//input[@placeholder='Email ID']")
    WebElement emailFieldSignup;
    
    //password field sign up
    @FindBy (xpath = "(//input[@id='passwd'])[2]")
    WebElement PasswordFieldSignup;
    
    // Country DD Open
    @FindBy (css = "img[class='arrow-down']")
    WebElement country;
    
    // Select Country
    @FindBy (xpath = "//div[@data-countname='India']")
    WebElement countryIndia;
    // Enter Mobile number
    @FindBy (id = "mob")
    WebElement mobileNumber;
    
    // Sign up button
    @FindBy (css = "button[data-action='signup']")
    WebElement signup;
    
    // sign in without verification hyperlink
    @FindBy (css = "button[style='color: #545454;']")
    WebElement signupWithoutVerification;
    
    // google login CTA
    @FindBy (xpath = "(//img[@class=\"guest-image\"])[1]")
    WebElement google;
    
    // google login email field
    @FindBy (css = "input[class='whsOnd zHQkBf']")
    WebElement googleEmail;
    
    // email Next button
    @FindBy (xpath = "//span[normalize-space()='Next']")
    WebElement emailNextbutton; 
    
    // google login password field
    @FindBy (xpath = "//input[@name='Passwd']")
    WebElement googlePassword;
    

    
    
    
    
    
    
    
    
    
	
    // Entering email ID
    public void emailId(String emailID)
    {
    	emailField.sendKeys(emailID);
    	nextButton.click();;
    }
    
    // Entering Password
    public void password(String password)
    {
    	loginViaPass.click();
    	passwordField.sendKeys(password);
    }
    
    // click on Sign In button
    public void signInButton()
    {
    	signInButton.click();
    }
    
    // click on sign up button
    public void goToSignupPage()
    {
    	signUp.click();
    }
    
    // entering all details name, email , password, mobile number
    public void enterName(String userName)
    {
    	nameFieldSignup.sendKeys(userName);
    }
    
	public void enterEmail(String signupEmail)
	{
		emailFieldSignup.sendKeys(signupEmail);
	}
	
	public void enterPassword (String signupPass)
	{
		PasswordFieldSignup.sendKeys(signupPass);
	}
	
	public void selectCountry()
	{
		country.click();
		countryIndia.click();
	}
	
	public void enterMobileNo(String signupMobileNo)
	{
		mobileNumber.sendKeys(signupMobileNo);
	}
	
	// click on sign up button
	public void clickOnSignup()
	{
		signup.click();
	}
	
	// sign up Without Verification
	public void clickSignupWithoutVerification()
	{
		signupWithoutVerification.click();
	}
	
	// click on google login CTA
	public void clickGoogleLogin()
	{
		google.click();
	}
	
	// enter google email
	public void googleEmail(String emailForGoogle)
	{
		googleEmail.sendKeys(emailForGoogle);
	}
	
	// click on next button
	public void clickNextButton()
	{
		emailNextbutton.click();
	}
	
	// emter password
	public void googlePassword(String passwordForGoogle)
	{
		googlePassword.sendKeys(passwordForGoogle);
	}
	
}
