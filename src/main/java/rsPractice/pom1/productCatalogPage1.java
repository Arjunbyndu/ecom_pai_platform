package rsPractice.pom1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rsPractice.AbstractClass.abstractClass1;

public class productCatalogPage1 extends abstractClass1{
	
	WebDriver driver;
	public productCatalogPage1(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	//page factory design
	@FindBy(xpath="//div[@class='product']")
	List<WebElement> allProductELement;
	
	@FindBy(css="a[class='cart-icon']")
	WebElement clickOnCart;

	@FindBy(xpath="(//div[@class='action-block']/button)[1]")
	WebElement ProceedToCheckOut;
	


	//action methos 

	public void addItemToCart(String productToBuy)
	{
		loadProductElements(allProductELement);
		boolean found = false;
		for(WebElement product : allProductELement)
			{
			String productName =	product.findElement(By.xpath("h4")).getText();
				if(productName.contains(productToBuy))
				{
					product.findElement(By.xpath("div[3]")).click();
					found = true ; 
					break;
				}	
			}
		if(found){ System.out.println("Added to cart"); }
			
	}
	
	public cartPage1 checkout()
	{
		clickOnCart.click();
		ProceedToCheckOut.click();
		cartPage1 cartPage1 = new cartPage1(driver);
		return cartPage1;
		
	}
	
}
