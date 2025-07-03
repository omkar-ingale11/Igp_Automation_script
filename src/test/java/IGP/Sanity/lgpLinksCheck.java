package IGP.Sanity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponent.baseTest;

public class lgpLinksCheck extends baseTest {

	
//	@BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://igp.com"); // Change this URL
//    }

    @DataProvider(name = "linksProvider", parallel = true)
    public Object[][] getLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> hrefs = new ArrayList<>();

        for (WebElement link : links) {	
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                hrefs.add(href);
            }
        }

        // Convert List to Object[][] for DataProvider
        Object[][] data = new Object[hrefs.size()][1];
        for (int i = 0; i < hrefs.size(); i++) {
            data[i][0] = hrefs.get(i);
        }
        return data;
    }

    @Test(dataProvider = "linksProvider")
    public void verifyNoProductFound(String url) {
        WebDriver threadDriver = new ChromeDriver();
        try {
            threadDriver.get(url);
            WebDriverWait wait = new WebDriverWait(threadDriver, Duration.ofSeconds(5));

            boolean isNoProductFound = threadDriver.getPageSource().contains("No product found");

            if (isNoProductFound) {
                System.out.println("Broken Product Link Found: " + url);
            }

            Assert.assertFalse(isNoProductFound, "Broken link detected: " + url);
	
        } finally {
            threadDriver.quit();
        }
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
   // }
} 
	
	

