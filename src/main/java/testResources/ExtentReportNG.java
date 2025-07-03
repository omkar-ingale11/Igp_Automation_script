package testResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String path  = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Omkar Automation REPORT");
		reporter.config().setDocumentTitle("IGP SANITY REPORT");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Omkar", "QA");
		extent.createTest(path);
		return extent;
		
	}		
	
	
	
	
}
