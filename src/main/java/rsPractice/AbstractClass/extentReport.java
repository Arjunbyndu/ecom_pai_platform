package rsPractice.AbstractClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class extentReport {
	
	
	public static ExtentReports extentReports()
	{
		
		String reportPath = System.getProperty("user.dir")+"//ExtentReprots//report1.html";
		ExtentSparkReporter reporter = new  ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Regression report");
		reporter.config().setReportName("Web Automation result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
	}

}
