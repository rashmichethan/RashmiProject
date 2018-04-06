package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestNgBasics {
	
	public static String username;
	public static int counter;
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
	
	@Test(priority=1)
	public void LandHomepage() {
		System.out.println("Landed on cart page");
		
	}
	
	
	@Test(priority=2)
	public void CheckTitleHomepage()
	{
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		 if (driver != null) {
			 driver.quit();
		 }
	}
	
	
	
}
