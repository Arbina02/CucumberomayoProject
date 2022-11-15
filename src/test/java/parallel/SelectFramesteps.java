package parallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.DriveryFactory.DriverFactory;
import com.PageObject.SelectFramePage;
import io.cucumber.java.en.*;

public class SelectFramesteps {
	
	private SelectFramePage framepage=new SelectFramePage(DriverFactory.getDriver());
	
	@Given("User login to provided url")
	public void user_login_to_provided_url() {
		String expectedTitle="omayo (QAFox.com)";
		String actualTitle=framepage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle);
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("User enter data into text field using JavaScript")
	public void user_enter_data_into_text_field_using_java_script() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, 600)");
		WebElement Textfields=framepage.getTextField();
		JavascriptExecutor js1=(JavascriptExecutor)DriverFactory.getDriver();
		js1.executeScript("arguments[0].value='The data to this text field is added by automation';", Textfields);
	    
	}

	@Then("User retive data using javascript")
	public void user_retive_data_using_javascript() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, 600)");
		WebElement retriveText=framepage.getRetriveText();
		System.out.println(retriveText.getText());
	}

	@Then("User data from table provided")
	public void user_data_from_table_provided() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, 900)");
		int rowData=framepage.getTableRow().size();
		int colData=framepage.getTablecol().size();
		for(int i=1; i<=rowData; i++)
		{
			for(int j=1; j<=colData; j++)
			{
			     System.out.print(DriverFactory.getDriver().findElement
			    		 (By.xpath("//table[@id='table1']/tbody/tr[" +i+ "]/td[" +j+ "]")).getText()+" ");
			}
			System.out.println();
		}
	}

	@Then("User pass Username to text tab")
	public void user_pass_username_to_text_tab() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		framepage.getUserName().sendKeys("Ariyna12@gmail.com");
	}

	@Then("User pass password to text tab")
	public void user_pass_password_to_text_tab() {
	    framepage.getPassword().sendKeys("Password12");
	}

	@Then("User click on submit button")
	public void user_click_on_submit_button() {
		framepage.getLoginButton().click();
	}

	@Then("User handle to iframe provded")
	public void user_handle_to_iframe_provded() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		WebElement frameOne=framepage.getIframeTwo();
		DriverFactory.getDriver().switchTo().frame(frameOne);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(framepage.getIframeOne().getText());
	}

	@Then("User hanle login page")
	public void user_hanle_login_page() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		framepage.getLoginUser().sendKeys("Alynazon@gmail.com");
		framepage.getLoginPassword().sendKeys("Password123");
		framepage.getCancel().click();
	}

}
