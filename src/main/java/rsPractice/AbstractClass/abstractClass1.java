package rsPractice.AbstractClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractClass1 {
	
	WebDriver driver;
	public abstractClass1(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	
	}
	
	
	public void scrollToProjectList()
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,700)");
	}
	
	public void scrollToUserDetails()
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,100)");
	}
	
	
	public void loginPAgeElementLoad(WebElement ele1)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele1));
	}
	
	public void loadProductElements(List<WebElement> allProductELement)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(allProductELement));
	}
	
}
