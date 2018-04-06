package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckOutTest {

	WebDriver driver;
	
	@BeforeMethod
	
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		System.out.println("Chrome browser launced successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver .get("https://buy.norton.com/ps?selSKU=21258941&ctry=US&lang=en&tppc=ECBA161D-8ECF-365C-B4F2-88ECD4E7CE3E&ptype=cart");
		
		}
	
	@DataProvider
	
	
	@Test
	
	public void CheckOutPageData(String address, String zipcode, String city, String state, 
			String name, String cardno, String cvv) {
		
		//enter data
		
		
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys(address);
		
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(zipcode);
		
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(city);
		
		Select droplist1 = new Select(driver.findElement(By.id("statedropdown")));   
	    droplist1.selectByVisibleText(state);
	    
	    driver.findElement(By.id("cardHolderName")).clear();
        driver.findElement(By.id("cardHolderName")).sendKeys(name);
        
        driver.findElement(By.id("cardNumber")).clear();
        driver.findElement(By.id("cardNumber")).sendKeys(cardno);
        
        driver.findElement(By.id("cvv")).clear();
        driver.findElement(By.id("cvv")).sendKeys(
        		cvv);
        
        Select droplist2 = new Select(driver.findElement(By.id("expMonthDropDown")));   
		droplist2.selectByVisibleText("05-May");
		  
		Select droplist3 = new Select(driver.findElement(By.id("expYearDropDown")));   
		droplist3.selectByVisibleText("2020");
	}
	
	@Test
	
	public void PortalLoginData() {
		
		//enter data
		  driver.findElement(By.id("loginUsername")).clear();
		  driver.findElement(By.id("loginUsername")).sendKeys("email");
		  
		  driver.findElement(By.id("loginPassword")).clear();
		  driver.findElement(By.id("loginPassword")).sendKeys("password");

	}
	
	@AfterMethod
	
	public void tearDown() {
		if (driver != null) {
			 driver.quit();
		 }
	
	}
	
	
}
