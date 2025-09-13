package testComponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	
	
	public WebDriver driver;
	public pageObject.IGPHomePage IGPHomePage;
	//public abstractComponent.IgpAbstractComponent AbstractComponent; 
	public WebDriver initializeDriver() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	// Screenshot Utility
	 	public String getScreenshot (String testCaseName, WebDriver driver) throws IOException
	 	{
	 		TakesScreenshot ts = (TakesScreenshot)driver;
	 		File source = ts.getScreenshotAs(OutputType.FILE);
	 		File file = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
	 		FileUtils.copyFile(source, file);
	 		//return System.getProperty(("user.dir") + "//reports" + testCaseName + ".png");
	 		return (System.getProperty("user.dir")+"/reports" +testCaseName+".png");
	 	}
		
		@BeforeMethod (alwaysRun = true)
		public pageObject.IGPHomePage launchApplication()
		{
			 driver = initializeDriver();
			 IGPHomePage = new pageObject.IGPHomePage(driver);
			 IGPHomePage.visitIGP();
			 return IGPHomePage;	
	
        }
		
		@AfterMethod (alwaysRun = true)
		public void closeBrowser() throws InterruptedException 
		{
			Thread.sleep(1500);
			//driver.close();
			driver.quit();
		}
		
}						