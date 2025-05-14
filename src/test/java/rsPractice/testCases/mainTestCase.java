package rsPractice.testCases;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rsPractice.pom1.landingPage1;

public class mainTestCase 
{
	String productToBuy = "Tomato";
	@Test
	public  void testcase() throws InterruptedException
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
		
		
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(productList));

		boolean found = false;
		
		for(WebElement product : productList)
		{
		String productName =	product.findElement(By.xpath("h4")).getText();
		
			if(productName.contains(productToBuy))
			{
				product.findElement(By.xpath("div[3]")).click();
				found = true ; 
				break;
			}
			
		}
		
		if(found)
		{
			System.out.println("Added to cart");
		}
		else if (found)
		{
			System.out.println("vegitable not found");
		}
		
		//check cart
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		
		driver.findElement(By.xpath("(//div[@class='action-block']/button)[1]")).click();
		
		// cart page 
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		//choose country
		WebElement dd = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select countryDD = new Select(dd);
		countryDD.selectByValue("India");
		
		driver.findElement(By.cssSelector(".chkAgree")).click();
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
	}
}