package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class Acqflow {

	WebDriver driver;
	
	@Test
	@Parameters({"url","email","password"})
	
	public void Cartpage(String url, String email, String password)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		System.out.println("Chrome browser launced successfully");
		driver.get(url);
		
		
		System.out.println("Landed on Sign in page");
		
		driver.findElement(By.id("checkout")).click();
		try{
			  Assert.assertTrue(driver.getTitle().contains("Norton Secure Login")); 
		  }
		  catch(Throwable t){
			  System.out.println(t + "landed on different page");
			  
		  }
		  
		  System.out.println("Landed on portal login page");
		  driver.findElement(By.id("registerUsername")).sendKeys(email);
		  driver.findElement(By.id("login-signin")).click();
		  driver.findElement(By.id("login-passwd")).sendKeys(password);
		  driver.findElement(By.id("login-signin")).click();
		  
		  
	}
	
}
