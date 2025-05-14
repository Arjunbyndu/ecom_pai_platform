package practice.basetest;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreport5 
{
	
	public static ExtentReports ER5()
	{
		String reportPath = System.getProperty("user.dir")+"//practicereport5//file5.html";
		ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
		report.config().setDocumentTitle("regression test");
		
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(report);
		return extent;
		
	}
}
