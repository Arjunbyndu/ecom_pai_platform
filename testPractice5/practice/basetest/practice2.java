package practice.basetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practice2 
{

	@Test
	public void pagination3() throws InterruptedException
	{
		String FruitName = "Cherry";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		int  pages =driver.findElements(By.xpath("//ul[@aria-label='Pagination']/li")).size();
	
			for(int i= 3; i<=pages-2; i++)
			{
				
				driver.findElement(By.xpath("//ul[@aria-label='Pagination']/li["+i+"]")).click();
				boolean flag = false;
				
				List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
				
				for(WebElement indexValue :rows)
				{
					
					String fruitName = indexValue.findElement(By.xpath("td[1]")).getText();
					String FruitPrice;
					String FruitDiscount;
						if(fruitName.equalsIgnoreCase(FruitName))
						{
							 FruitPrice =indexValue.findElement(By.xpath("td[2]")).getText();
							 FruitDiscount =indexValue.findElement(By.xpath("td[3]")).getText();
							 System.out.println(FruitName+" price is "+ FruitPrice);
							 System.out.println(FruitName+ " discount is "+ FruitDiscount);
							 flag = true;
							 break;
					  	}
				}
				if(flag)
				{
					break;
				}	
		}
	}
	
}
