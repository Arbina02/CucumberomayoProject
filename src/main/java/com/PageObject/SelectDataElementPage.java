package com.PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDataElementPage 
{
	private WebDriver driver;

	private By imageElement=By.xpath("//div[@id='HTML29']/div[1]/img");
	private By searchTextBlog=By.xpath("//input[@class='gsc-input']");
	private By searchBlogButton=By.xpath("//input[@class='gsc-search-button']");
	private By radioButton=By.xpath("//input[@id='radio1']");
	private By alertAccept=By.xpath("//input[@id='alert1']");
	private By enabledCheckBox=By.xpath("//input[@id='checkbox1']");
	private By readyText=By.xpath("//input[@id='rotb']");
	private By getPrompt=By.xpath("//input[@id='prompt']");
	private By getConfirm=By.xpath("//input[@id='confirm']");
	private By hiddenButton=By.xpath("document.getElementById('hbutton')");
	private By locateName=By.name("textboxn");
	private By locateClass=By.className("classone");
	private By radioButtonMultiple=By.xpath("//div[@id='HTML32']/div[1]/input");
	private By multipleCheckBox=By.xpath("//div[@id='HTML33']/div[1]/input");
	private By dropDownSelect=By.xpath("//button[@class='dropbtn']");
	private By dropDownClick=By.xpath("//div[@id='myDropdown']/a[1]");

	public SelectDataElementPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getpageTitle()
	{
		return driver.getTitle();
	}

	public WebElement getImageElement()
	{
		return driver.findElement(imageElement);
	}

	public WebElement getSearchTextBlog()
	{
		return driver.findElement(searchTextBlog);
	}

	public WebElement getSearchBlogButton()
	{
		return driver.findElement(searchBlogButton);
	}

	public WebElement getradioButton()
	{
		return driver.findElement(radioButton);
	}

	public WebElement getalertAccept()
	{
		return driver.findElement(alertAccept);
	}

	public WebElement getenabledCheckBox()
	{
		return driver.findElement(enabledCheckBox);
	}

	public WebElement getreadyText()
	{
		return driver.findElement(readyText);
	}

	public WebElement getPrompt()
	{
		return driver.findElement(getPrompt);
	}

	public WebElement getConfirm()
	{
		return driver.findElement(getConfirm);
	}

	public WebElement gethiddenButton()
	{
		return driver.findElement(hiddenButton);
	}

	public WebElement getlocateName()
	{
		return driver.findElement(locateName);
	}

	public WebElement getlocateClass()
	{
		return driver.findElement(locateClass);
	}

	public List<WebElement> getradioButtonMultiple()
	{
		return driver.findElements(radioButtonMultiple);
	}

	public List<WebElement> getmultipleCheckBox()
	{
		return driver.findElements(multipleCheckBox);
	}

	public WebElement getdropDownSelect()
	{
		return driver.findElement(dropDownSelect);
	}

	public WebElement getdropDownClick()
	{
		return driver.findElement(dropDownClick);
	}

}
