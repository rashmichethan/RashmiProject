package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogin {
	
WebDriver driver;
	
	@Test
	@Parameters({"browser","url","email","password"})
	
	public void Cartpage(String browser, String url, String email, String password)
	{
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser launched");
			
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/rashmi.chethan/Downloads/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser launched");
		}
		
		
		driver.get(url);
		System.out.println("Landed on Yahoo Sign in page");
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-signin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
		
		System.out.println("Successfully signed into Yahoo");
	}

}
