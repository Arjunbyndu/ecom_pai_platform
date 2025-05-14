package practice.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p5basetest 
{
	public WebDriver driver;
	
public WebDriver initializer() throws IOException 
{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testPractice5\\practice\\basetest\\browser.properties");
	prop.load(fis);
	
	String browserName5 = prop.getProperty("browser");
	
	if(browserName5.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	else if(browserName5.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		
	}
	else if(browserName5.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;
	
}

public String screenShot(String testCaseName5 , WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	
	File path = new File(System.getProperty("user.dir")+ "\\practiceReports\\"+ testCaseName5 +".png");
	FileUtils.copyFile(source, path);		
	return System.getProperty("user.dir")+ "\\practiceReports\\"+ testCaseName5 +".png";
}



@BeforeMethod
public void launchapp() throws IOException
{
	driver = initializer();
	// add the codes for launch app with url
	
}



}
