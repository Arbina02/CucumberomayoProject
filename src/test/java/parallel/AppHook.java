package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.DriveryFactory.DriverFactory;
import com.Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHook 
{
	public WebDriver driver;
	private ConfigReader reader;
	private DriverFactory factory;
	private Properties prop;

	@Before(order=0)
	public void conifReader()
	{
		reader = new ConfigReader();
		prop=reader.init_prop();
	}

	@Before(order=1)
	public void init_browser()
	{
		String browserName=prop.getProperty("browser");
		String UrlName=prop.getProperty("url");
		factory = new DriverFactory();
		driver = factory.init_driver(browserName);
		DriverFactory.getDriver().get(UrlName);
	}

	@After(order=0)
	public void quits()
	{
		driver.quit();	
	}

	@After(order=1)
	public void teardown(Scenario scenarios)
	{
		String sourcepath=scenarios.getName().replaceAll(" ", "_");
		byte[] desnationpath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenarios.attach(desnationpath, "image/png", sourcepath);
	}

}
