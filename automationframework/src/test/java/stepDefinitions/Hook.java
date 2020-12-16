package stepDefinitions;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.BaseClass;
import framework.SuiteConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.stqa.selenium.factory.WebDriverPool;

public class Hook extends BaseClass {
	
	private BaseClass base;

	public Hook(BaseClass base) {
		this.base = base;
	}
 
	protected static URL gridHubUrl;
	protected static Capabilities capabilities;
  
	@Before
	public void initDriver() throws Throwable {
		SuiteConfiguration config = new SuiteConfiguration();
		base.baseUrl = config.getProperty("site.url");
		if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
			gridHubUrl = new URL(config.getProperty("grid.url"));
		}
		capabilities = config.getCapabilities();
		base.driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	 
	}

	@After
	public void teardown() {
		base.driver.quit();
		 
	}
}
