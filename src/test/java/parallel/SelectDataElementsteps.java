package parallel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.DriveryFactory.DriverFactory;
import com.PageObject.SelectDataElementPage;

import io.cucumber.java.en.*;

public class SelectDataElementsteps {

	private SelectDataElementPage dataElement= new SelectDataElementPage(DriverFactory.getDriver());

	@Given("User is redirected to url")
	public void user_is_redirected_to_url() {
		String expectedText="omayo (QAFox.com)";
		String actualText=dataElement.getpageTitle();
		Assert.assertEquals(expectedText, actualText);
	}

	@Then("User will automate image")
	public void user_will_automate_image() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		System.out.println("the url is:"+ dataElement.getImageElement().getAttribute("src"));
		Dimension dimension=dataElement.getImageElement().getSize();
		int expectdheight=200;
		int expectedwidth=150;
		int height=dimension.getHeight();
		int weidth=dimension.getWidth();
		if(expectdheight==height && expectedwidth==weidth)
		{
			System.out.println("given image is not broken");
		}else {
			System.out.println("given image is broken");
		}
	}

	@Then("User will add data using javascript")
	public void user_will_add_data_using_javascript() {
		WebElement element=dataElement.getSearchTextBlog();
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("arguments[0].value='the new blog';", element);

	}

	@Then("User click on search button using javascript")
	public void user_click_on_search_button_using_javascript() {
		WebElement button=dataElement.getSearchBlogButton();
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", button);   
	}

	@Then("User will automate radio function")
	public void user_will_automate_radio_function() {
		dataElement.getradioButton().click();
	}

	@Then("User habdle the alert button")
	public void user_habdle_the_alert_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 500);");
		dataElement.getalertAccept().click();
		Alert alert=DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}

	@Then("User handle checkbox button")
	public void user_handle_checkbox_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 800);");
		WebElement enabled=dataElement.getenabledCheckBox();
		boolean checked=enabled.isSelected();
		if(checked=true)
		{
			System.out.println(checked);
		}else
		{
			enabled.click();
		}
	}

	@Then("User will handle readonly data")
	public void user_will_handle_readonly_data() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 800);");
		WebElement readText=dataElement.getreadyText();
		System.out.println(readText.getText());	
	}

	@Then("User handle prompt data")
	public void user_handle_prompt_data() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 800);");
		dataElement.getPrompt().click();
		Alert alert=DriverFactory.getDriver().switchTo().alert();
		alert.sendKeys("this is autosend text");
		alert.accept();
	}

	@Then("User handle confirm button")
	public void user_handle_confirm_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 800);");
		dataElement.getConfirm().click();
		Alert alert=DriverFactory.getDriver().switchTo().alert();
		alert.dismiss();    
	}

	@Then("User handle hidden button function")
	public void user_handle_hidden_button_function() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 800);");
		WebElement hiddenButton=dataElement.gethiddenButton();
		JavascriptExecutor js1=(JavascriptExecutor)DriverFactory.getDriver();
		js1.executeScript("arguments[0].click();", hiddenButton);    
	}

	@Then("user locate using name text")
	public void user_locate_using_name_text() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		dataElement.getlocateName().sendKeys("the autotext by name");
	}

	@Then("User locate element using classname")
	public void user_locate_element_using_classname() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		dataElement.getlocateClass().sendKeys("the autotext by class");
	}

	@Then("User automate radio button")
	public void user_automate_radio_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		List<WebElement> radioButton=dataElement.getradioButtonMultiple();
		for(int i=0; i<radioButton.size(); i++)
		{
			WebElement ele=radioButton.get(i);
			String data=ele.getAttribute("value");
			if(data.equals("Bicycle"))
			{
				ele.click();
			}
		}
	}

	@Then("User handle multiple checkbox")
	public void user_handle_multiple_checkbox() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		List<WebElement> checkbox=dataElement.getmultipleCheckBox();
		for(int i=0; i<checkbox.size(); i++)
		{
			WebElement ele=checkbox.get(i);
			String data=ele.getAttribute("value");
			if(data.equals("Book"))
			{
				ele.click();
			}
		}
	}

	@Then("User handle the functions")
	public void user_handle_the_functions() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		dataElement.getdropDownSelect().click();
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dataElement.getdropDownClick()));
		dataElement.getdropDownClick().click(); 
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DriverFactory.getDriver().navigate().back();
	}




}
