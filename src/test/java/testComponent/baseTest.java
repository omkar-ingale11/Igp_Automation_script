package testComponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

    public WebDriver driver;
    public pageObject.IGPHomePage IGPHomePage;

    public WebDriver initializeDriver() {

        // Set path to chromedriver (ARM64 compatible)
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	

        ChromeOptions options = new ChromeOptions();

        // Headless mode for server
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Unique temporary user-data-dir per session
        String userDataDir = "/tmp/chrome_" + System.currentTimeMillis() + "_" + UUID.randomUUID();
        options.addArguments("--user-data-dir=" + userDataDir);

       // WebDriverManager.chromedriver().setup();
        
        // Optional: set window size
        	options.addArguments("--window-size=1366,768");
      //    options.addArguments("--window-size=1920,1080");
        
      //    Optional: specify Chromium binary path if needed
      //    options.setBinary("/usr/bin/chromium-browser");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //   driver.manage().window().maximize();
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
		
//		@AfterMethod (alwaysRun = true)
//		public void closeBrowser() throws InterruptedException 
//		{
//			Thread.sleep(1500);
//			//driver.close();
//			driver.quit();
//		}
		
//		@AfterMethod(alwaysRun = true)
//	    public void closeBrowser() throws InterruptedException {
//	        Thread.sleep(1500);
//	        if (driver != null) {
//	            driver.quit();
//	        }
//		
//		}	
}						