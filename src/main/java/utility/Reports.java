package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generateReports()
	{
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReports.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("version","1.10");
		reports.setSystemInfo("Created By", "Priyanka");
		reports.setSystemInfo("Testing Type", "Regression");
		return reports;
	}

}
