package parallel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.DriveryFactory.DriverFactory;
import com.PageObject.SelectButtonPage;
import io.cucumber.java.en.*;

public class SelectButtonSteps {
	
	private SelectButtonPage selectButton= new SelectButtonPage(DriverFactory.getDriver());
	
	@Given("User navigate to provided url page")
	public void user_navigate_to_provided_url_page() throws InterruptedException {
		String expectedTitle="omayo (QAFox.com)";
		String actualTitle=selectButton.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle);
        Thread.sleep(5000);
	}
	
	@Then("User select required data and print on console")
	public void user_select_required_data_and_print_on_console() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,1000);");
		List<WebElement> orderlist=selectButton.getOrderList();
		for(WebElement Order: orderlist)
		{
			if(Order.getText().equals("Four"))
			{
				Order.click();
				System.out.println(Order.getText());
				break;
			}
		}
	}

	@Then("User select required data from unorder list")
	public void user_select_required_data_from_unorder_list() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,1000);");
		List<WebElement> unorderlist=selectButton.getUnderList();
		for(WebElement unOrder: unorderlist)
		{
			System.out.println(unOrder.getText());
		}
	    
	}

	@Then("User print the text before it disappear")
	public void user_print_the_text_before_it_disappear() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1000);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean data=selectButton.getDisAppearList().isDisplayed();
		System.out.println(data);
		System.out.println(selectButton.getDisAppearList().getText());
	}

	@Then("User click on disappear button")
	public void user_click_on_disappear_button() {
		selectButton.getdisAppearButton().click();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Alert alert = DriverFactory.getDriver().switchTo().alert();
	    alert.accept();
	}

	@Then("User wait for the text to be appear")
	public void user_wait_for_the_text_to_be_appear() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement visibleElement=selectButton.getdisplayText();
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibleElement));
		System.out.println(selectButton.getdisplayText().getText());
	}

	@When("User click on popup link")
	public void user_click_on_popup_link() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectButton.getpopUpLink().click();	   
	}

	@Then("User will navigate to new popup window")
	public void user_will_navigate_to_new_popup_window() {
		String expectedstring="Basic Web Page Title";
		String actualstring="";
		String parentwinodw=DriverFactory.getDriver().getWindowHandle();
		Set<String> allwindow=DriverFactory.getDriver().getWindowHandles();
		Iterator<String> itr=allwindow.iterator();
		while(itr.hasNext())
		{
			String childwinodw=itr.next();
			if(!parentwinodw.equals(childwinodw))
			{
			   DriverFactory.getDriver().switchTo().window(childwinodw);
			   DriverFactory.getDriver().manage().window().maximize();
			   actualstring=selectButton.getTitle();
			}
		}
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(actualstring, expectedstring);
		System.out.println(actualstring);
		DriverFactory.getDriver().switchTo().window(parentwinodw);
	}

	@Then("User upload a file using sendkeys")
	public void user_upload_a_file_using_sendkeys() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectButton.getUploadButton().sendKeys("C:\\Users\\BQLPT01\\Desktop\\Regression TCs Master.xlsx");	    
	}

	@Then("user upload a file using robot class")
	public void user_upload_a_file_using_robot_class() throws AWTException {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Robot robot=new Robot();
	   StringSelection select=new StringSelection("C:\\Users\\BQLPT01\\Desktop\\Regression TCs Master.xlsx");
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null);
	   robot.keyPress(KeyEvent.VK_ENTER);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyPress(KeyEvent.VK_V);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyRelease(KeyEvent.VK_V);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyPress(KeyEvent.VK_ENTER);
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Then("User wait for the button to enable to click")
	public void user_wait_for_the_button_to_enable_to_click() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectButton.getenableButton()));   
	}

	@When("User click on try it butoon to diable the button")
	public void user_click_on_try_it_butoon_to_diable_the_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0, 1500);");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectButton.gettryItButton().click(); 
	}

	@Then("User check for the button to be disabled")
	public void user_check_for_the_button_to_be_disabled() {
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectButton.getdisableButton()));      
	}

	@Then("User use action class to double click on a button")
	public void user_use_action_class_to_double_click_on_a_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, document.body.ScrollHeight);");
		WebElement Double=selectButton.getdoubleClick();
	    Actions action = new Actions(DriverFactory.getDriver());
	    action.doubleClick(Double).build().perform();
	    String alert=DriverFactory.getDriver().switchTo().alert().getText();
	    System.out.println("the alert value:"+ alert);
	    DriverFactory.getDriver().switchTo().alert().accept();
	}

	@Then("User will click on check it button")
	public void user_will_click_on_check_it_button() {
		JavascriptExecutor js=(JavascriptExecutor)DriverFactory.getDriver();
		js.executeScript("window.scrollTo(0, document.body.ScrollHeight);");
		selectButton.getcheckThisButton().click();
	    
	}

	@Then("User make sure checkbox is enabled")
	public void user_make_sure_checkbox_is_enabled() {
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectButton.getcheckThisButton())); 
		selectButton.getcheckThisButton().click();
	}

}
