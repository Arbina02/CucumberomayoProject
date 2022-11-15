package com.DriveryFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	
	private static ThreadLocal<WebDriver> ldriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("launching the browser:"+ browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ldriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			ldriver.set(new FirefoxDriver());
		}else if(browser.equalsIgnoreCase("safari"))
		{
			ldriver.set(new SafariDriver());
		}else 
		{
			System.out.println("Please provide valid browser"+ browser);
		}
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return ldriver.get();
	}
	

}
