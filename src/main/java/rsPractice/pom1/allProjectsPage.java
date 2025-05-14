package rsPractice.pom1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsPractice.AbstractClass.abstractClass1;

public class allProjectsPage extends abstractClass1
{
	WebDriver driver;
	public allProjectsPage(WebDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='projects-item']/a)[1]")
	WebElement project1Link;
	
	
//action methos 
	
	public productCatalogPage1 automationPractice1()
	{
		scrollToProjectList();
		project1Link.click();
		productCatalogPage1 productCatalogPage1 = new productCatalogPage1(driver);
		return productCatalogPage1;
	}
	
	
	
	
}
