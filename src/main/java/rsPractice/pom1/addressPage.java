package rsPractice.pom1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rsPractice.AbstractClass.abstractClass1;

public class addressPage extends abstractClass1
{
	WebDriver driver;
	public addressPage(WebDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@style='width: 200px;']")
	WebElement SelectDropdown;
	
	@FindBy(css=".chkAgree")
	WebElement confirmAddressCheckBox;
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement ProceedAndCompleteOrder;
	
	//actions class
	public void addAddress(String country)
	{
		Select countryDD = new Select(SelectDropdown);
		countryDD.selectByValue(country);
		confirmAddressCheckBox.click();
		ProceedAndCompleteOrder.click();
	}
	
	

	
}
