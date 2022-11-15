package parallel;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.DriveryFactory.DriverFactory;
import com.PageObject.SelectOperationPage;
import io.cucumber.java.en.*;

public class SelectOperationstep {

	private SelectOperationPage selectpage=new SelectOperationPage(DriverFactory.getDriver());

	@Given("User navigate to provided url")
	public void user_navigate_to_provided_url() throws InterruptedException {
		String expectedTitle="omayo (QAFox.com)";
		String actualTitle=selectpage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle);
        Thread.sleep(5000);
	}

	@When("User select a dropdown from given multiple selector")
	public void user_select_a_dropdown_from_given_multiple_selector() {
		String expecteddata="Hyundai";
		String actualdata = "";
		List<WebElement> allOptions =selectpage.getMultipledropdown();
		for (WebElement option : allOptions) {
		if (option.getText().equals("Hyundai")) {
		option.click();
		actualdata=option.getText();
		break;
		}
		}
		System.out.println("the actual value:"+ actualdata);
		Assert.assertEquals(actualdata,expecteddata);
	}

	@When("User select a dropdown using select method")
	public void user_select_a_dropdown_using_select_method() {
		WebElement dropdown=selectpage.getSelectdropdown();
		Select select=new Select(dropdown);
		select.selectByIndex(3);
		WebElement data=select.getFirstSelectedOption();
		System.out.println(data.getText());
	}

	@Then("User clears the data present in the text box")
	public void user_clears_the_data_present_in_the_text_box() {
		selectpage.getpreloadedText().clear();

	}

	@Then("Add text Using JavascriptExecutor")
	public void add_text_using_javascript_executor() {
		WebElement element=selectpage.getpreloadedText();
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		String value=(String)js.executeScript("return arguments[0].value='Selenium data';", element);
		System.out.println(value);
	}

	@When("User click on the link")
	public void user_click_on_the_link() throws InterruptedException {
		selectpage.getwindowLink().click();
		Thread.sleep(5000);
	}

	@Then("User navigate to new window")
	public void user_navigate_to_new_window() throws InterruptedException {
         String parentwindow= DriverFactory.getDriver().getWindowHandle();
         Set<String> allwindow=DriverFactory.getDriver().getWindowHandles();
         Iterator<String> itr=allwindow.iterator();
         while(itr.hasNext())
         {
        	 String childwindow=itr.next();
        	 if(!parentwindow.equals(childwindow))
        	 {
        		 DriverFactory.getDriver().switchTo().window(childwindow);
        		 DriverFactory.getDriver().manage().window().maximize();
        		 Thread.sleep(5000);
        		 System.out.println(selectpage.getPageTitle());
        		 DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        		 DriverFactory.getDriver().close();
        	 }
         }
         DriverFactory.getDriver().switchTo().window(parentwindow);
	}

	@Then("User handle enbale button")
	public void user_handle_enbale_button() {
		boolean Enabled=selectpage.getEnabledButton().isEnabled();
		System.out.println(Enabled);    
		System.out.println(selectpage.getEnabledButton().getText());
	}

	@Then("User handle disable button")
	public void user_handle_disable_button() {
		boolean Disabled=selectpage.getDisabledButton().isEnabled();
		System.out.println(Disabled);
	}

	@Then("User handle disabled box")
	public void user_handle_disabled_box() {
		boolean DisableText=selectpage.getDisabledText().isEnabled();
		System.out.println(DisableText);
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		String textData=(String)js.executeScript("return arguments[0].value='Disabled text';", DisableText);
		System.out.println(textData);
	}

	@Then("User handle submit button")
	public void user_handle_submit_button() {
		System.out.println(selectpage.getSubmit().getText());	
	}

	@Then("User handle Login button")
	public void user_handle_login_button() {
		System.out.println(selectpage.getLogin().getText());
	}

	@Then("User handle Register button")
	public void user_handle_register_button() {
		System.out.println(selectpage.getRegister().getText());
	}

}
