package rsPractice.testCases;


import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import rsPractice.TestComponents.BaseTest1;
import rsPractice.TestComponents.retest;
import rsPractice.pom1.addressPage;
import rsPractice.pom1.allProjectsPage;
import rsPractice.pom1.cartPage1;
import rsPractice.pom1.landingPage1;
import rsPractice.pom1.productCatalogPage1;

public class TestCase1  extends BaseTest1
{
	

	//@Test(dataProvider = "getdata" , retryAnalyzer = retest.class)
	@Test(dataProvider = "getdata")
	public  void place_Order(HashMap<String , String> input ) throws  IOException, InterruptedException
	{
		//landingPage1 landingPageobj =launchRahulshettyAcademyWebsite();
		allProjectsPage project1 =landingPageobj.loginPage( input.get("userName") , input.get("userEMail")); //login to page with credential
		productCatalogPage1 productCatalogPage1 =project1.automationPractice1(); //open automation practice page 1
		productCatalogPage1.addItemToCart(input.get("productToBuy")); // add required item to cart 
		cartPage1 cartPage1 =productCatalogPage1.checkout(); //checkout the cart
		addressPage addressPage = cartPage1.placeorder(); //confirm the order 
		addressPage.addAddress(input.get("country")); //add country and place the order		
	}
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		List<HashMap<String , String>> data = getJsonData(System.getProperty("user.dir")+ "\\src\\test\\java\\testData\\dataProvider1.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

	
}