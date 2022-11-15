package com.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFramePage {
	
	private WebDriver driver;
	
	private By textfield=By.xpath("//textarea[@id='ta1']");
	private By retriveText=By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]");
	private By tableRow=By.xpath("//table[@id='table1']/tbody/tr");
	private By tableColumn=By.xpath("//table[@id='table1']/tbody/tr[1]/td");
	private By userName=By.xpath("//form[@name='form1']/input[1]");
	private By passWord=By.xpath("//form[@name='form1']/input[2]");
	private By loginButton=By.xpath("//button[contains(text(),' LogIn ')]");
	private By iframeTwo=By.xpath("//iframe[@id='iframe2']");
	private By iframeOne=By.xpath("//html/body[@text='#000000']/h2[1]");
	private By loginUser=By.xpath("//input[@name='userid']");
	private By loginPassword=By.xpath("//input[@name='pswrd']");
	private By login=By.xpath("//input[@value='Login']");
	private By cancelButton=By.xpath("//input[@value='Cancel']");
	
	
	public SelectFramePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public WebElement getTextField()
	{
		return driver.findElement(textfield);
	}
	
	public WebElement getRetriveText()
	{
		return driver.findElement(retriveText);
	}
	
	public List<WebElement> getTableRow()
	{
		return driver.findElements(tableRow);
	}
	
	public List<WebElement> getTablecol()
	{
		return driver.findElements(tableColumn);
	}
	
	public WebElement getUserName()
	{
		return  driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(passWord);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}

	public WebElement getIframeOne()
	{
		return driver.findElement(iframeOne);
	}
	
	public WebElement getIframeTwo()
	{
		return driver.findElement(iframeTwo);
	}
	
	public WebElement getLoginUser()
	{
		return driver.findElement(loginUser);
	}
	
	public WebElement getLoginPassword()
	{
		return driver.findElement(loginPassword);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getCancel()
	{
		return driver.findElement(cancelButton);
	}
}
