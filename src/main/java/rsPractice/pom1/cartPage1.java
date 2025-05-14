package rsPractice.pom1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsPractice.AbstractClass.abstractClass1;

public class cartPage1 extends abstractClass1
{
	WebDriver driver;
	public cartPage1(WebDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrder;
	
	
	//actions class
	public addressPage placeorder()
	{
		placeOrder.click();
		addressPage addressPage = new addressPage(driver);
		return addressPage;
		
	}
	

	
}
