package rsPractice.pom1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsPractice.AbstractClass.abstractClass1;

public class landingPage1 extends abstractClass1{
	WebDriver driver;
	public landingPage1(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	// page factory design
	@FindBy(xpath="//input[@placeholder='Your Name*']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Your Email*']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(css="#form-submit:nth-of-type(1)")
	WebElement submitButton;
	
	@FindBy(xpath="//form[@id='form']")
	WebElement loginPageElement;
	
	//action class
	
	public void launchWebsite()
	{
		driver.get("https://rahulshettyacademy.com/practice-project");
	}
	
	public allProjectsPage loginPage(String UN , String UE) throws InterruptedException
	{
		
		scrollToUserDetails();
		
		//Thread.sleep(2000);
		userName.sendKeys(UN);
		userEmail.sendKeys(UE);
		checkBox.click();
		submitButton.click();
		allProjectsPage allProjectsPage = new allProjectsPage(driver);
		return allProjectsPage;
		
	}
	
	
	//driver.findElement(By.xpath("//input[@placeholder='Your Name*']")).sendKeys("Arjun");
	//driver.findElement(By.xpath("//input[@placeholder='Your Email*']")).sendKeys("arjunbyndu@gmail.com");
	//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	//driver.findElement(By.cssSelector("#form-submit:nth-of-type(1)")).click();

}
