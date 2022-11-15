package com.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectButtonPage {
	
	private WebDriver driver;
	
	private By orderList = By.xpath("//ol/li");
	private By unOrderList = By.xpath("//div[@id='HTML26']/div[1]/ul/li");
	private By disAppearText = By.xpath("//div[@id='deletesuccess']");
	private By disAppearButton = By.xpath("//input[@id='alert2']");
	private By displayText = By.xpath("//div[@id='delayedText']");
	private By popUpLink = By.xpath("//a[contains(text(),'Open a popup window')]");
	private By uploadButton = By.xpath("//input[@id='uploadfile']");
	private By waitforButton = By.xpath("//input[@id='timerButton']");
	private By tryItButton = By.xpath("//button[contains(text(),'Try it')]");
	private By disableButton = By.xpath("//button[contains(text(),'My Button')]");
	private By doubleClick = By.xpath("//button[contains(text(),' Double click Here   ')]");
	private By checkThisButton = By.xpath("//button[contains(text(),'Check this')]");
	private By mrOption = By.xpath("//input[@id='dte']");
	
	public SelectButtonPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}

	public List<WebElement> getOrderList()
	{
		return driver.findElements(orderList);
	}
	
	public List<WebElement> getUnderList()
	{
		return driver.findElements(unOrderList);
	}
	
	public WebElement getDisAppearList()
	{
		return driver.findElement(disAppearText);
	}
	
	public WebElement getdisAppearButton()
	{
		return driver.findElement(disAppearButton);
	}
	
	public WebElement getdisplayText()
	{
		return driver.findElement(displayText);
	}
	
	public WebElement getpopUpLink()
	{
		return driver.findElement(popUpLink);
	}
	
	public WebElement getUploadButton()
	{
		return driver.findElement(uploadButton);
	}
	
	public WebElement getenableButton()
	{
		return driver.findElement(waitforButton);
	}
	
	public WebElement gettryItButton()
	{
		return driver.findElement(tryItButton);
	}
	
	public WebElement getdisableButton()
	{
		return driver.findElement(disableButton);
	}
	
	public WebElement getdoubleClick()
	{
		return driver.findElement(doubleClick);
	}
	
	public WebElement getcheckThisButton()
	{
		return driver.findElement(checkThisButton);
	}
	
	public WebElement getmrOption()
	{
		return driver.findElement(mrOption);
	}
}
