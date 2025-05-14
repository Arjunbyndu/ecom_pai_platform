package rsPractice.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class oder_Tcs {

	public  void pageScroll() throws InterruptedException
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/practice-project");
		driver.findElement(By.xpath("//input[@placeholder='Your Name*']")).sendKeys("Arjun");
		driver.findElement(By.xpath("//input[@placeholder='Your Email*']")).sendKeys("arjunbyndu@gmail.com");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector("#form-submit:nth-of-type(1)")).click();
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,700)");
		driver.findElement(By.xpath("(//div[@class='projects-item']/a)[1]")).click();
	}	
	
	public  void orderWithOffer() throws InterruptedException
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/practice-project");
		driver.findElement(By.xpath("//input[@placeholder='Your Name*']")).sendKeys("Arjun");
		driver.findElement(By.xpath("//input[@placeholder='Your Email*']")).sendKeys("arjunbyndu@gmail.com");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector("#form-submit:nth-of-type(1)")).click();
		
	}	
}
