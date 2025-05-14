package rsPractice.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rsPractice.pom1.landingPage1;

public class BaseTest1 {
public WebDriver driver;
public landingPage1 landingPageobj ;

		public WebDriver initializer() throws IOException
		{
			 Properties prop = new Properties();
			 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rsPractice//Resorces//browserType.properties");
			 prop.load(fis);
			 String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
			 
			//String browserName = prop.getProperty("browser");
			
			if(browserName.contains("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				//options.addArguments("--diasable-notifications");
					if(browserName.contains("headless"))
					{
						options.addArguments("--headless");
					}
				
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1400,900));
				
			}
			else if (browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
		}
		
		public List<HashMap<String, String>> getJsonData(String filePath) throws IOException
		{ 
			//convert json to string
			String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
			
			//convert string to hash map
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String , String>> data  =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String , String>>>() {} );
			return data;	
		}
		
		public String getScreenShot(String testCaseNAme , WebDriver driver) throws IOException
		{
			
			TakesScreenshot ts =(TakesScreenshot)driver;
			File sourc =ts.getScreenshotAs(OutputType.FILE);
			File path = new File(System.getProperty("user.dir")+ "\\reports\\"+ testCaseNAme + ".png"); 
			FileUtils.copyFile(sourc, path);
			return System.getProperty("user.dir")+ "\\reports\\"+ testCaseNAme + ".png";
		}
		
		
		@BeforeMethod
		public landingPage1 launchRahulshettyAcademyWebsite() throws IOException
		{
			
			driver = initializer();
			landingPageobj = new landingPage1(driver);
			landingPageobj.launchWebsite();
			return landingPageobj;
			
		}
		
		@AfterMethod
		public void close() throws InterruptedException
		{
			//Thread.sleep(2000);
			driver.quit();
			
		}
	
}
