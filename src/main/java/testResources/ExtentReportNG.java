package testResources;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            // Create reports directory if missing
            String reportDirPath = System.getProperty("user.dir") + "/reports/";
            File reportDir = new File(reportDirPath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            // Define report file path
            String reportPath = reportDirPath + "index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Omkar Automation REPORT");
            reporter.config().setDocumentTitle("IGP SANITY REPORT");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Automation QA", "Omkar");
        }
        return extent;
    }
}
