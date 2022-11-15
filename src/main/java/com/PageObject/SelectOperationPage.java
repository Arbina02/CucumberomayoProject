package com.PageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectOperationPage 
{
	private WebDriver driver;
	
	private By multipleDropDown=By.xpath("//select[@id='multiselect1']/option");
	private By selectDropDown=By.xpath("//select[@id='drop1']");
	private By preloadedText=By.xpath("//input[@value='Selenium WebDriver']");
	private By windowLink=By.xpath("//a[contains(text(),'SeleniumTutorial')]");
	private By enabledButton=By.xpath("//button[@id='but2']");
	private By disabledButton=By.xpath("//button[@id='but1']");
	private By disabledText=By.xpath("//input[@id='tb2']");
	private By sumbitButton=By.xpath("//button[contains(text(),'Submit')]");
	private By loginButton=By.xpath("//button[contains(text(),'Login')]");
	private By registerButton=By.xpath("//button[contains(text(),'Register')]");
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public SelectOperationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public List<WebElement> getMultipledropdown()
	{
	   return driver.findElements(multipleDropDown);	
	}
	
	public WebElement getSelectdropdown()
	{
		return driver.findElement(selectDropDown);
	}
	
	public WebElement getpreloadedText()
	{
		return driver.findElement(preloadedText);
	}
	
	public WebElement getwindowLink()
	{
		return driver.findElement(windowLink);
	}
	
	public WebElement getEnabledButton()
	{
		return driver.findElement(enabledButton);
	}
	
	public WebElement getDisabledButton()
	{
		return driver.findElement(disabledButton);
	}
	
    public WebElement getDisabledText()
    {
    	return driver.findElement(disabledText);
    }
    
    public WebElement getSubmit()
    {
    	return driver.findElement(sumbitButton);
    }
    
    public WebElement getLogin()
    {
    	return driver.findElement(loginButton);
    }
    
    public WebElement getRegister()
    {
    	return driver.findElement(registerButton);
    }
}
